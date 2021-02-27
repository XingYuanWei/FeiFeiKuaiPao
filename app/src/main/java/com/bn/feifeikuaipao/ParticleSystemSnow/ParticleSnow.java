package com.bn.feifeikuaipao.ParticleSystemSnow;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.util.Log;

import com.bn.screen.auto.ScreenScaleUtil;
import com.bn.feifeikuaipao.MatrixState.MatrixState;
import com.bn.feifeikuaipao.ParticleSystemSnow.ParticleSnowForDraw;
import com.bn.feifeikuaipao.constant.Constant;
import static com.bn.feifeikuaipao.constant.SourceConstant.CURR_INDEX;
import static com.bn.feifeikuaipao.constant.SourceConstant.LIFE_SPAN_STEP;
import static com.bn.feifeikuaipao.constant.SourceConstant.MAX_LIFE_SPAN;
import static com.bn.feifeikuaipao.constant.SourceConstant.Snow_Group_Count;
import static com.bn.feifeikuaipao.constant.SourceConstant.lock;
import static com.bn.feifeikuaipao.constant.SourceConstant.snowPeriod;
import static com.bn.feifeikuaipao.constant.SourceConstant.snowStartPositionX;
import static com.bn.feifeikuaipao.constant.SourceConstant.snowStartPositionY;
import static com.bn.feifeikuaipao.constant.SourceConstant.snowXDraw;
import static com.bn.feifeikuaipao.constant.SourceConstant.snowXRange;
import static com.bn.feifeikuaipao.constant.SourceConstant.snowYDraw;
import static com.bn.feifeikuaipao.constant.SourceConstant.snowYRange;
import static com.bn.feifeikuaipao.constant.SourceConstant.snowZF;
import static com.bn.feifeikuaipao.constant.SourceConstant.snow_Vy;

public class ParticleSnow
{
    public float maxLifeSpan;//粒子最大生命期
    public float lifeSpanStep;//粒子生命期步进
    public int sleepSpan;//粒子更新线程休眠时间间隔
    public int groupCount;//每批喷发的粒子数量
    public float sx;//基础发射点x坐标
    public float sy;//基础发射点y坐标
    float positionX;//绘制位置x坐标
    float positionY;//绘制位置y坐标
    public float xRange;//发射点x方向的变化范围
    public float yRange;//发射点y方向的变化范围
    public float vx;//粒子发射的x方向速度
    public float vy;//粒子发射的y方向速度
    boolean flag=true;//线程工作的标志位
    float halfSize;//粒子半径
    int count=1;//激活粒子的位置计算器
    ParticleSnowForDraw particleSnowForDraw;
    public float[] points;//粒子对应的所有顶点数据数组
    public ParticleSnow(float positionx,float positiony,ParticleSnowForDraw particleSnowForDraw,int count)
    {
        this.positionX=positionx;//初始化此粒子系统的绘制位置x坐标
        this.positionY=positiony;//初始化此粒子系统的绘制位置y坐标
        this.maxLifeSpan=MAX_LIFE_SPAN[CURR_INDEX];//初始化每个粒子的最大生命期
        this.lifeSpanStep=LIFE_SPAN_STEP[CURR_INDEX];//初始化每个粒子的生命步进
        this.groupCount=Snow_Group_Count;//初始化每批喷发的粒子数
        this.sleepSpan=40;//初始化线程的休眠时间
        this.sx=0;//初始化此粒子系统的中心点x坐标
        this.sy=0;//初始化此粒子系统的中心点y坐标
        this.xRange=snowXRange;//初始粒子距离中心点x方向的最大距离
        this.yRange=snowYRange;//初始粒子距离中心点y方向的最大距离
        this.vx=0;//初始化粒子的x方向运动速度
        this.vy=snow_Vy;//初始化粒子的y方向运动速度
        this.halfSize=1.0f;//初始化此粒子系统的粒子半径
        this.particleSnowForDraw=particleSnowForDraw;
        this.points=initPoints(count);//初始化粒子所对应的所有顶点数据数组

        particleSnowForDraw.initVertexData(points);//调用初始化顶点坐标与纹理坐标数据的方法
        new Thread()
        {
            public void run()
            {
                while(flag)
                {
                    update_snow();//调用update方法更新粒子状态
                    try
                    {
                        Thread.sleep(sleepSpan);//休眠一定的时间
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();//打印异常信息
                    }
                }
            }
        }.start();
    }
    public float[] initPoints(int zcount)
    {
        float[] points=new float[zcount*4*6];//临时存放顶点数据的数组-每个粒子对应6个顶点，每个顶点包含4个值
        for(int i=0;i<zcount;i++)
        {
            //循环遍历所有粒子，那么每个粒子的速度就都是规律的
            //在中心附近产生产生粒子的位置------**/
            //px，py相当于是在火盆的圆心在一定的半径里面绘制粒子的x,y坐标
            //X_RANGE 和 Y_RANGE的取值是粒子中心点得一个随机范围
            float px=(float) (sx+xRange*(Math.random()*9-1.0f));//计算粒子位置的x坐标
            float py=(float) (sy+yRange*(Math.random()*6-1.0f));//计算粒子位置的y坐标
            //得到粒子顶点坐标
            points[i*4*6]=px-halfSize/2;//粒子对应的第一个点的x坐标
            points[i*4*6+1]=py+halfSize/2;//粒子对应的第一个点的y坐标
            points[i*4*6+2]=0;
            points[i*4*6+3]=10.0f;//粒子对应的第一个点的当前生命期--10代表粒子处于未激活状态

            points[i*4*6+4]=px-halfSize/2;
            points[i*4*6+5]=py-halfSize/2;
            points[i*4*6+6]=0;
            points[i*4*6+7]=10.0f;

            points[i*4*6+8]=px+halfSize/2;
            points[i*4*6+9]=py+halfSize/2;
            points[i*4*6+10]=0;
            points[i*4*6+11]=10.0f;

            points[i*4*6+12]=px+halfSize/2;
            points[i*4*6+13]=py+halfSize/2;
            points[i*4*6+14]=0;
            points[i*4*6+15]=10.0f;

            points[i*4*6+16]=px-halfSize/2;
            points[i*4*6+17]=py-halfSize/2;
            points[i*4*6+18]=0;
            points[i*4*6+19]=10.0f;

            points[i*4*6+20]=px+halfSize/2;
            points[i*4*6+21]=py-halfSize/2;
            points[i*4*6+22]=0;
            points[i*4*6+23]=10.0f;
        }
        for(int j=0;j<groupCount;j++)
        {
            //循环遍历第一批的粒子
            //每个粒子都是六个顶点所以lifeSpan都是一样的
            points[4*j*6+3]=lifeSpanStep;//设置粒子生命期，不为10时，表示粒子处于活跃状态
            points[4*j*6+7]=lifeSpanStep;//设置粒子生命期，不为10时，表示粒子处于活跃状态
            points[4*j*6+11]=lifeSpanStep;//设置粒子生命期，不为10时，表示粒子处于活跃状态
            points[4*j*6+15]=lifeSpanStep;//设置粒子生命期，不为10时，表示粒子处于活跃状态
            points[4*j*6+19]=lifeSpanStep;//设置粒子生命期，不为10时，表示粒子处于活跃状态
            points[4*j*6+23]=lifeSpanStep;//设置粒子生命期，不为10时，表示粒子处于活跃状态
        }
        return points;//返回所有粒子顶点属性数据数组
    }
    public void drawSelf(int texId,float width,float height)
    {
        //绘制此粒子系统中所有粒子的方法
        GLES30.glDisable(GLES30.GL_DEPTH_TEST);//关闭深度检测
        //开启混合
        GLES30.glEnable(GLES30.GL_BLEND);			//开启混合
        GLES30.glBlendFunc(GLES30.GL_SRC_ALPHA, GLES30.GL_ONE_MINUS_SRC_ALPHA);//设置混合因子
        float wScale=ScreenScaleUtil.fromPixSizeToScreenSize(width,Constant.ssr);
        float hScale= ScreenScaleUtil.fromPixSizeToScreenSize(height,Constant.ssr);
        //update_snow();//调用update方法更新粒子状态
        if (count==1)
        {
            snowXDraw = ScreenScaleUtil.from2DZBTo3DZBX(snowStartPositionX, Constant.ssr);//初始状态
            snowYDraw = ScreenScaleUtil.from2DZBTo3DZBY(snowStartPositionY, Constant.ssr);
        } else
        {
            snowXDraw = snowXDraw - 0.002f;
            snowYDraw = ScreenScaleUtil.from2DZBTo3DZBY(snowStartPositionY, Constant.ssr) + (float) (snowZF * Math.sin(snowPeriod * snowXDraw));
        }
        //平移到绘制点的位置
        MatrixState.pushMatrix();//保护现场
        MatrixState.rotate(30,0,0,1);
        MatrixState.translate(snowXDraw, snowYDraw,0);//执行平移变换
        MatrixState.scale(wScale,hScale,1);
        particleSnowForDraw.drawSelf(texId,maxLifeSpan);//绘制粒子群
        MatrixState.popMatrix();//恢复现场
        GLES30.glDisable(GLES30.GL_BLEND);
    }
    public void update_snow()
    {
        //超过了粒子总数的时候也就是新的一轮粒子系统重新发射
        if(count>=(points.length/groupCount/4/6))//计算器超过激活粒子的总个数时
        {
            count=0;//重新计数
        }
        //查看生命期以及计算下一位置的相应数据
        for(int i=0;i<points.length/4/6;i++)//循环遍历所有粒子
        {
            if(points[i*4*6+3]!=10.0f)//当前为活跃粒子时
            {
                //上面的循环遍历粒子就把生命周期进行重新累加
                points[i*4*6+3]+=lifeSpanStep;//计算当前生命期
                points[i*4*6+7]+=lifeSpanStep;//计算当前生命期
                points[i*4*6+11]+=lifeSpanStep;//计算当前生命期
                points[i*4*6+15]+=lifeSpanStep;//计算当前生命期
                points[i*4*6+19]+=lifeSpanStep;//计算当前生命期
                points[i*4*6+23]+=lifeSpanStep;//计算当前生命期
            }
            float px=(float) (sx+xRange*(Math.random()*9-1.0f));//计算粒子位置x坐标
            float py=(float) (sy+yRange*(Math.random()*5-1.0f));//计算粒子位置y坐标
            if(points[i*4*6+3]>this.maxLifeSpan)//当前生命期大于最大生命期时---重新设置该粒子参数//回到初始状态
            {
                points[i*4*6]=px-halfSize/2;//粒子对应的第一个顶点的x坐标
                points[i*4*6+1]=py+halfSize/2;//粒子对应的第一个顶点的y坐标
                points[i*4*6+2]=0;
                points[i*4*6+3]=10.0f;//粒子对应的第一个顶点的当前生命期--10代表粒子处于未激活状态

                points[i*4*6+4]=px-halfSize/2;
                points[i*4*6+5]=py-halfSize/2;
                points[i*4*6+6]=0;
                points[i*4*6+7]=10.0f;

                points[i*4*6+8]=px+halfSize/2;
                points[i*4*6+9]=py+halfSize/2;
                points[i*4*6+10]=0;
                points[i*4*6+11]=10.0f;

                points[i*4*6+12]=px+halfSize/2;
                points[i*4*6+13]=py+halfSize/2;
                points[i*4*6+14]=0;
                points[i*4*6+15]=10.0f;

                points[i*4*6+16]=px-halfSize/2;
                points[i*4*6+17]=py-halfSize/2;
                points[i*4*6+18]=0;
                points[i*4*6+19]=10.0f;

                points[i*4*6+20]=px+halfSize/2;
                points[i*4*6+21]=py-halfSize/2;
                points[i*4*6+22]=0;
                points[i*4*6+23]=10.0f;
            }
        }
        for(int i=0;i<groupCount;i++)
        {
            //循环发射一批激活计数器所指定位置的粒子
            if(points[groupCount*count*4*6+4*i*6+3]==10.0f)//如果粒子处于未激活状态时
            {
                points[groupCount*count*4*6+4*i*6+3]=lifeSpanStep;//激活粒子--设置粒子当前的生命周期
                points[groupCount*count*4*6+4*i*6+7]=lifeSpanStep;//激活粒子--设置粒子当前的生命周期
                points[groupCount*count*4*6+4*i*6+11]=lifeSpanStep;//激活粒子--设置粒子当前的生命周期
                points[groupCount*count*4*6+4*i*6+15]=lifeSpanStep;//激活粒子--设置粒子当前的生命周期
                points[groupCount*count*4*6+4*i*6+19]=lifeSpanStep;//激活粒子--设置粒子当前的生命周期
                points[groupCount*count*4*6+4*i*6+23]=lifeSpanStep;//激活粒子--设置粒子当前的生命周期
            }
        }
        synchronized(lock)
        {//加锁--防止在更新顶点坐标数据时，将顶点坐标数据送入渲染管线
            particleSnowForDraw.updateVertexData(points);//更新顶点坐标数据缓冲的方法
        }
        count++;//下次激活粒子的位置
    }
}
