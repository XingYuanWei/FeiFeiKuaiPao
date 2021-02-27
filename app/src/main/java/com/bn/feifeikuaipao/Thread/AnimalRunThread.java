package com.bn.feifeikuaipao.Thread;

import android.opengl.GLES30;

import com.bn.feifeikuaipao.MainActivity;
import com.bn.feifeikuaipao.view.MapView;
import com.bn.feifeikuaipao.view.RunView;
import static com.bn.feifeikuaipao.Thread.TimeBodyThread.timer_body_flag;
import static com.bn.feifeikuaipao.Thread.TimesFootThread.time_foot_flag;
import static com.bn.feifeikuaipao.constant.MapConstant.BEANMAPTemp;
import static com.bn.feifeikuaipao.constant.MapConstant.HGrayArrow;
import static com.bn.feifeikuaipao.constant.MapConstant.MAPTemp;
import static com.bn.feifeikuaipao.constant.MapConstant.bean;
import static com.bn.feifeikuaipao.constant.MapConstant.finalrect_1;
import static com.bn.feifeikuaipao.constant.MapConstant.finalrect_2;
import static com.bn.feifeikuaipao.constant.MapConstant.finalrect_3;
import static com.bn.feifeikuaipao.constant.MapConstant.finalrect_4;
import static com.bn.feifeikuaipao.constant.MapConstant.finalrect_5;
import static com.bn.feifeikuaipao.constant.MapConstant.finalrect_6;
import static com.bn.feifeikuaipao.constant.MapConstant.finalrect_7;
import static com.bn.feifeikuaipao.constant.MapConstant.finalrect_8;
import static com.bn.feifeikuaipao.constant.MapConstant.gray_arrow_down_jump;
import static com.bn.feifeikuaipao.constant.MapConstant.gray_arrow_down_left;
import static com.bn.feifeikuaipao.constant.MapConstant.gray_arrow_down_right;
import static com.bn.feifeikuaipao.constant.MapConstant.gray_arrow_left_jump;
import static com.bn.feifeikuaipao.constant.MapConstant.gray_arrow_right_jump;
import static com.bn.feifeikuaipao.constant.MapConstant.gray_arrow_up_jump;
import static com.bn.feifeikuaipao.constant.MapConstant.gray_arrow_up_left;
import static com.bn.feifeikuaipao.constant.MapConstant.gray_arrow_up_right;
import static com.bn.feifeikuaipao.constant.MapConstant.grayarrow_down;
import static com.bn.feifeikuaipao.constant.MapConstant.grayarrow_left;
import static com.bn.feifeikuaipao.constant.MapConstant.grayarrow_right;
import static com.bn.feifeikuaipao.constant.MapConstant.green_arrow_down_jump;
import static com.bn.feifeikuaipao.constant.MapConstant.green_arrow_down_left;
import static com.bn.feifeikuaipao.constant.MapConstant.green_arrow_down_right;
import static com.bn.feifeikuaipao.constant.MapConstant.green_arrow_left;
import static com.bn.feifeikuaipao.constant.MapConstant.green_arrow_left_jump;
import static com.bn.feifeikuaipao.constant.MapConstant.green_arrow_right;
import static com.bn.feifeikuaipao.constant.MapConstant.green_arrow_right_jump;
import static com.bn.feifeikuaipao.constant.MapConstant.green_arrow_up_jump;
import static com.bn.feifeikuaipao.constant.MapConstant.green_arrow_up_left;
import static com.bn.feifeikuaipao.constant.MapConstant.green_arrow_up_right;
import static com.bn.feifeikuaipao.constant.MapConstant.mapIndex;
import static com.bn.feifeikuaipao.constant.MapConstant.narrowrect;
import static com.bn.feifeikuaipao.constant.MapConstant.rectDown;
import static com.bn.feifeikuaipao.constant.MapConstant.rectLeft;
import static com.bn.feifeikuaipao.constant.MapConstant.rectRight;
import static com.bn.feifeikuaipao.constant.MapConstant.rectTop;
import static com.bn.feifeikuaipao.constant.MapConstant.rectTop_top;
import static com.bn.feifeikuaipao.constant.SourceConstant.AniJumpDownFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.AniJumpLeftFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.AniJumpRightFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.AniJumpUpFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.AnimalJumpFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.AnimalJumpTime;
import static com.bn.feifeikuaipao.constant.SourceConstant.AnimalLocationX;
import static com.bn.feifeikuaipao.constant.SourceConstant.AnimalLocationY;
import static com.bn.feifeikuaipao.constant.SourceConstant.AnimalStartX;
import static com.bn.feifeikuaipao.constant.SourceConstant.AnimalStartY;
import static com.bn.feifeikuaipao.constant.SourceConstant.AnimalV;
import static com.bn.feifeikuaipao.constant.SourceConstant.Sound_eat;
import static com.bn.feifeikuaipao.constant.SourceConstant.Sound_fail;
import static com.bn.feifeikuaipao.constant.SourceConstant.Sound_fall;
import static com.bn.feifeikuaipao.constant.SourceConstant.Sound_finish;
import static com.bn.feifeikuaipao.constant.SourceConstant.Sound_jump;
import static com.bn.feifeikuaipao.constant.SourceConstant.Sound_turn;
import static com.bn.feifeikuaipao.constant.SourceConstant.arrowColorCount;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalEightFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalFiveFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalFourFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalOneFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalSevenFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalSixFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalThreeFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalTwoFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.lock1;
import static com.bn.feifeikuaipao.constant.SourceConstant.moveFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.rotateAngle;
import static com.bn.feifeikuaipao.constant.SourceConstant.rotateDirection;
import static com.bn.feifeikuaipao.constant.SourceConstant.rotateTime;
import static com.bn.feifeikuaipao.constant.SourceConstant.sound;
import static com.bn.feifeikuaipao.view.FailGameView.clockLogo_flag;
import static com.bn.feifeikuaipao.view.FailGameView.clockUse_flag;
import static com.bn.feifeikuaipao.view.FailGameView.magnetLogo_flag;
import static com.bn.feifeikuaipao.view.FailGameView.magnetUse_flag;
import static com.bn.feifeikuaipao.view.FailGameView.securityLogo_flag;
import static com.bn.feifeikuaipao.view.FailGameView.securityUse_flag;
import static com.bn.feifeikuaipao.view.RunView.Score;
import static com.bn.feifeikuaipao.view.RunView.isFail;
import static com.bn.feifeikuaipao.view.RunView.isfinalwin;

public class AnimalRunThread extends Thread
{
    static RunView runView;
    public static boolean over_flag = true;//失败图片切换标志位
    public static boolean flag=true;
    public static float tempCurrentAngle=0f;
    public static boolean isColFlag=false;//碰撞检测标志位
    public static boolean bChangeArrowColorFlag;
    public static float AR_aniX;
    public static float AR_aniY;
    public static int FlyTime = 9;
    public static boolean magnetUnlock_flag = false;//显示磁石道具提醒标志
    public static boolean clockUnlock_flag = false;//显示秒表道具提醒标志
    public static boolean securityUnlock_flag = false;//显示磁石道具提醒标志
    public AnimalRunThread(RunView runView)
    {
        this.runView=runView;
    }
    public void run()
    {
        while (flag)
        {
            float tempCurrentChickenX=0.0f;
            float tempCurrentChickenY=0.0f;
            //直走方式
            if(!moveFlag)
            {
                tempCurrentAngle=rotateDirection;
                tempCurrentChickenX=(float)Math.sin(Math.toRadians(tempCurrentAngle))*AnimalV;
                tempCurrentChickenY=(float)Math.cos(Math.toRadians(tempCurrentAngle))*AnimalV;
            }
            float R=20.0f;
            //计算碰撞点所在地图的行列位置
            //再这里发生的是矩形区域的情况
            //col是x，row是y.  此时得到的是坐标，不再是数组
            float colCenter=(float)Math.floor(AnimalLocationX-tempCurrentChickenX+AnimalStartX-R*Math.sin(Math.toRadians(rotateDirection)));
            float rowCenter=(float)Math.floor(AnimalLocationY-tempCurrentChickenY+AnimalStartY-R*Math.cos(Math.toRadians(rotateDirection)));
            //判断是否到终点
            isFinish(colCenter,rowCenter);
            //判断吃掉bean
            isBean(colCenter,rowCenter);
            changeArrowColor();
            //判断是否发生碰撞
            isColFlag =checkAniHead(AnimalLocationX-tempCurrentChickenX,AnimalLocationY-tempCurrentChickenY,rotateDirection);
            if(!isColFlag)
            {
                //没有发生碰撞的时候保持继续移动
                rotateDirection=tempCurrentAngle;
                AnimalLocationX=AnimalLocationX-tempCurrentChickenX;
                AnimalLocationY=AnimalLocationY-tempCurrentChickenY;
                synchronized (lock1)
                {
                    AR_aniX=AnimalLocationX;
                    AR_aniY=AnimalLocationY;
                }
            }
            if(isColFlag)
            {
                //碰撞的时候
                isFail = true;//游戏结束
                AnimalV=0.0f;//撞到赛道
                over_flag = false;//撞上了
                flag=false;//停止移动线程
                timer_body_flag = false;//停止切换线程
                time_foot_flag=false;
                GameOverResetPop();//发生碰撞道具失效
                if (sound)
                {
                    MainActivity.soundManager.playMusic(Sound_fall,0);
                    MainActivity.soundManager.playMusic(Sound_fail,0);
                }
            }
            //点击屏幕，让其的值变成零，点一次消失一次
            try
            {
                Thread.sleep(30);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    //改变箭头颜色,且吃掉箭头
    public void changeArrowColor()
    {
        if(bChangeArrowColorFlag)
        {
            /*********************转弯部分****************************/
            //点击屏幕的箭头是向左转的时候
            if(arrowColorCount>=0&&arrowColorCount<HGrayArrow.size()&&HGrayArrow.get(arrowColorCount)==green_arrow_left)
            {
                if(moveFlag&&rotateTime!=0&&rotateTime==1)
                {
                    aniTurnDirection();
                    //左转90度
                    tempCurrentAngle=rotateDirection+rotateAngle;
                }
                dealArrow();
            }
            if(arrowColorCount>=0&&arrowColorCount<HGrayArrow.size()&&HGrayArrow.get(arrowColorCount)==green_arrow_right)
            {
                //右转90度
                //抬起的时候rotateTime变成0
                if(moveFlag&&rotateTime!=0&&rotateTime==1)
                {
                    aniTurnDirection();
                    //右转90度
                    tempCurrentAngle=rotateDirection-rotateAngle;
                }
                dealArrow();
            }
            //点击屏幕是向上左转的时候
            if(arrowColorCount>=0&&arrowColorCount<HGrayArrow.size()&&HGrayArrow.get(arrowColorCount)==green_arrow_up_left)
            {
                //左转90度
                //抬起的时候rotateTime变成0
                if(moveFlag&&rotateTime!=0&&rotateTime==1)
                {
                    aniTurnDirection();
                    //左转90度
                    tempCurrentAngle=rotateDirection+rotateAngle;
                }
                dealArrow();
            }
            //点击屏幕是向上右转的时候
            if(arrowColorCount>=0&&arrowColorCount<HGrayArrow.size()&&HGrayArrow.get(arrowColorCount)==green_arrow_up_right)
            {
                //右转90度
                //抬起的时候rotateTime变成0
                if(moveFlag&&rotateTime!=0&&rotateTime==1)
                {
                    aniTurnDirection();
                    //右转90度
                    tempCurrentAngle=rotateDirection-rotateAngle;
                }
                dealArrow();
            }
            //点击屏幕是向下左转的时候
            if(arrowColorCount>=0&&arrowColorCount<HGrayArrow.size()&&HGrayArrow.get(arrowColorCount)==green_arrow_down_left)
            {
                //左转90度
                //抬起的时候rotateTime变成0
                if(moveFlag&&rotateTime!=0&&rotateTime==1)
                {
                    aniTurnDirection();
                    //左转90度
                    tempCurrentAngle=rotateDirection+rotateAngle;
                }
                dealArrow();
            }
            //点击屏幕是向下右转的时候
            if(arrowColorCount>=0&&arrowColorCount<HGrayArrow.size()&&HGrayArrow.get(arrowColorCount)==green_arrow_down_right)
            {
                //右转90度
                //抬起的时候rotateTime变成0
                if(moveFlag&&rotateTime!=0&&rotateTime==1)
                {
                    aniTurnDirection();
                    //右转90度
                    tempCurrentAngle=rotateDirection-rotateAngle;
                }
                dealArrow();
            }
            /*************************跳跃部分***********************/
            //点击屏幕是向左跳的时候
            if(arrowColorCount>=0&&arrowColorCount<HGrayArrow.size()&&HGrayArrow.get(arrowColorCount)==green_arrow_left_jump)
            {
                AniJumpLeftFlag = true;//执行跳跃状态
                if (sound)
                {
                    MainActivity.soundManager.playMusic(Sound_jump,0);
                }
                dealArrow();
                animalJump();
            }
            //点击屏幕是向上跳的时候
            if (arrowColorCount>=0&&arrowColorCount<HGrayArrow.size()&&HGrayArrow.get(arrowColorCount)==green_arrow_up_jump)
            {
                AniJumpUpFlag = true;//执行跳跃状态
                if (sound)
                {
                    MainActivity.soundManager.playMusic(Sound_jump,0);
                }
                dealArrow();
                animalJump();
            }
            //点击屏幕是向右跳的时候
            if (arrowColorCount>=0&&arrowColorCount<HGrayArrow.size()&&HGrayArrow.get(arrowColorCount)==green_arrow_right_jump)
            {
                AniJumpRightFlag = true;//执行跳跃状态
                if (sound)
                {
                    MainActivity.soundManager.playMusic(Sound_jump,0);
                }
                dealArrow();
                animalJump();
            }
            //点击屏幕向下跳
            if (arrowColorCount>=0&&arrowColorCount<HGrayArrow.size()&&HGrayArrow.get(arrowColorCount)==green_arrow_down_jump)
            {
                AniJumpDownFlag = true;//执行跳跃状态
                if (sound)
                {
                    MainActivity.soundManager.playMusic(Sound_jump,0);
                }
                dealArrow();
                animalJump();
            }
        }
    }
    //动物转弯声音处理部分
    public void aniTurnDirection()
    {
        //限制住让其转弯一次
        rotateTime++;
        if (sound)
        {
            MainActivity.soundManager.playMusic(Sound_turn,0);//转弯音效
        }
    }
    //箭头处理
    public void dealArrow()
    {
        //点击屏幕让箭头消失
        HGrayArrow.put(arrowColorCount,0);
        //让下一个箭头变成预期的绿色
        if(HGrayArrow.get(arrowColorCount+1)!=null&&HGrayArrow.get(arrowColorCount+1)==grayarrow_left)
        {
            HGrayArrow.put(arrowColorCount+1,green_arrow_left);
        }
        else if(HGrayArrow.get(arrowColorCount+1)!=null&&HGrayArrow.get(arrowColorCount+1)==grayarrow_right)
        {
            HGrayArrow.put(arrowColorCount+1,green_arrow_right);
        }
        //特殊属性部分
        else if (HGrayArrow.get(arrowColorCount+1)!=null&&HGrayArrow.get(arrowColorCount+1)==gray_arrow_up_left)
        {
            HGrayArrow.put(arrowColorCount+1,green_arrow_up_left);
        }
        else if (HGrayArrow.get(arrowColorCount+1)!=null&&HGrayArrow.get(arrowColorCount+1)==gray_arrow_up_right)
        {
            HGrayArrow.put(arrowColorCount+1,green_arrow_up_right);
        }
        else if (HGrayArrow.get(arrowColorCount+1)!=null&&HGrayArrow.get(arrowColorCount+1)==gray_arrow_down_left)
        {
            HGrayArrow.put(arrowColorCount+1,green_arrow_down_left);
        }
        else if (HGrayArrow.get(arrowColorCount+1)!=null&&HGrayArrow.get(arrowColorCount+1)==gray_arrow_down_right)
        {
            HGrayArrow.put(arrowColorCount+1,green_arrow_down_right);
        }
        //跳跃部分
        else if (HGrayArrow.get(arrowColorCount+1)!=null&&HGrayArrow.get(arrowColorCount+1)==gray_arrow_left_jump)
        {
            HGrayArrow.put(arrowColorCount+1,green_arrow_left_jump);
        }
        else if (HGrayArrow.get(arrowColorCount+1)!=null&&HGrayArrow.get(arrowColorCount+1)==gray_arrow_right_jump)
        {
            HGrayArrow.put(arrowColorCount+1,green_arrow_right_jump);
        }
        else if (HGrayArrow.get(arrowColorCount+1)!=null&&HGrayArrow.get(arrowColorCount+1)==gray_arrow_up_jump)
        {
            HGrayArrow.put(arrowColorCount+1,green_arrow_up_jump);
        }
        else if (HGrayArrow.get(arrowColorCount+1)!=null&&HGrayArrow.get(arrowColorCount+1)==gray_arrow_down_jump)
        {
            HGrayArrow.put(arrowColorCount+1,green_arrow_down_jump);
        }
    }
    //判断是否到达终点  4.9改过了
    public void isFinish(float colCenter,float rowCenter)
    {
        float span = 180.0f;
        float col=(float)Math.floor(colCenter/span);
        float row=(float)Math.floor(rowCenter/span);
        int AnimalLocation = MAPTemp[(int)row][(int)col];
        float aniYRect=rowCenter-row*span;
        if ( AnimalLocation == finalrect_1)//第一关到达终点
        {
            if (aniYRect<15)
            {
                mapIndex = 2;
                MapView.World_Two = true;//解锁第二关
                finalOneFlag=true;//第一关终点标志位设置为true
                finalTwoFlag=false;
                finalThreeFlag=false;
                finalFourFlag=false;
                finalFiveFlag=false;
                finalSixFlag=false;
                finalSevenFlag=false;
                finalEightFlag=false;
                if (sound)
                {
                    MainActivity.soundManager.playMusic(Sound_finish,0);//通关音效
                }
            }
        }
        if ( AnimalLocation == finalrect_2)//第二关到达终点
        {
            magnetUnlock_flag = true;//view显示道具解锁
            if (aniYRect<15)
            {
                finalOneFlag=false;
                finalTwoFlag=true;//第二关终点标志位设置为true
                finalThreeFlag=false;
                finalFourFlag=false;
                finalFiveFlag=false;
                finalSixFlag=false;
                finalSevenFlag=false;
                finalEightFlag=false;
                mapIndex = 3;
                AnimalV = 6.0f;//给定初始速度
                FlyTime = 10;//飞行时间
                magnetLogo_flag= true;//磁铁道具解锁
                GLES30.glClearColor(0.142f,0.705f,0.066f,1.0f);//更新成第三关的颜色
                Resetpop();//调用道具重置方法，设置初始化
                MapView.World_Three = true;//解锁第三关
                if (sound)
                {
                    MainActivity.soundManager.playMusic(Sound_finish,0);//通关音效
                }
            }
        }
        if (AnimalLocation != finalrect_2)
        {
            magnetUnlock_flag = false;//view不显示道具解锁
        }
        if ( AnimalLocation == finalrect_3)//第三关到达终点
        {
            if (aniYRect<15)
            {
                finalOneFlag=false;
                finalTwoFlag=false;
                finalThreeFlag=true;//第三关终点标志位设置为true
                finalFourFlag=false;
                finalFiveFlag=false;
                finalSixFlag=false;
                finalSevenFlag=false;
                finalEightFlag=false;
                AnimalV = 6.5f;//给定初始速度
                FlyTime = 10;//飞行时间
                mapIndex = 4;
                GLES30.glClearColor(0.80f,0.06f,0.76f,1.0f);//更新成第四关颜色
                Resetpop();//调用道具重置方法
                MapView.World_Four = true;//解锁第四关
                if (sound)
                {
                    MainActivity.soundManager.playMusic(Sound_finish,0);//通关音效
                }
            }
        }
        if ( AnimalLocation == finalrect_4)//第四关到达终点
        {
            finalOneFlag=false;
            finalTwoFlag=false;
            finalThreeFlag=false;
            finalFourFlag=true;//第四关终点标志位设置为true
            finalFiveFlag=false;
            finalSixFlag=false;
            finalSevenFlag=false;
            finalEightFlag=false;
            clockUnlock_flag = true;//显示提醒
            if (aniYRect<15)
            {
                mapIndex = 5;
                AnimalV = 7.0f;//给定初始速度
                FlyTime = 9;//飞行时间
                clockLogo_flag = true;//解锁秒表道具
                GLES30.glClearColor(1.0f,1.0f,0f,1.0f);//更新成第五关颜色
                Resetpop();//调用道具重置方法
                MapView.World_Five = true;//解锁第五关
                if (sound)
                {
                    MainActivity.soundManager.playMusic(Sound_finish,0);//通关音效
                }
            }
        }
        if (AnimalLocation != finalrect_4)
        {
            clockUnlock_flag = false;//不再显示提醒
        }
        if ( AnimalLocation == finalrect_5)//第五关到达终点
        {
            if (aniYRect<15)
            {
                finalOneFlag=false;
                finalTwoFlag=false;
                finalThreeFlag=false;
                finalFourFlag=false;
                finalFiveFlag=true;//第五关终点标志位设置为true
                finalSixFlag=false;
                finalSevenFlag=false;
                finalEightFlag=false;
                mapIndex = 6;
                AnimalV = 8.0f;//给定初始速度
                FlyTime = 9;//飞行时间
                GLES30.glClearColor(0.705f,0.396f,0.078f,1.0f);//更新成第六关颜色
                Resetpop();//调用道具重置方法
                MapView.World_Six = true;//解锁第六关
                if (sound)
                {
                    MainActivity.soundManager.playMusic(Sound_finish,0);//通关音效
                }
            }
        }
        if ( AnimalLocation == finalrect_6)//第六关到达终点
        {
            securityUnlock_flag = true;//显示盾牌道具解锁提醒
            GLES30.glClearColor(0.525f,0.239f,0.705f,1.0f);
            if (aniYRect<15)
            {
                finalOneFlag=false;
                finalTwoFlag=false;
                finalThreeFlag=false;
                finalFourFlag=false;
                finalFiveFlag=false;
                finalSixFlag=true;//第六关终点标志位设置为true
                finalSevenFlag=false;
                finalEightFlag=false;
                mapIndex = 7;
                AnimalV = 8.0f;//给定初始速度
                FlyTime = 9;//飞行时间
                Resetpop();//调用道具重置方法
                securityLogo_flag = true;//盾牌道具解锁
                MapView.World_Seven = true;//解锁第七关
                if (sound)
                {
                    MainActivity.soundManager.playMusic(Sound_finish,0);//通关音效
                }
            }
        }
        if (AnimalLocation != finalrect_6)
        {
            securityUnlock_flag = false;//不再显示盾牌解锁提醒
        }
        if ( AnimalLocation == finalrect_7)//第七关到达终点
        {
            GLES30.glClearColor(1.0f,0.0f,0.0f,1.0f);//更新成第八关颜色
            if (aniYRect<15)
            {
                finalOneFlag=false;
                finalTwoFlag=false;
                finalThreeFlag=false;
                finalFourFlag=false;
                finalFiveFlag=false;
                finalSixFlag=false;
                finalSevenFlag=true;//第七关终点标志位设置为true
                finalEightFlag=false;
                mapIndex = 8;
                AnimalV = 8.5f;//给定初始速度
                FlyTime = 9;//飞行时间
                Resetpop();//调用道具重置方法
                MapView.World_Eight = true;//解锁第八关
                if (sound)
                {
                    MainActivity.soundManager.playMusic(Sound_finish,0);//通关音效
                }
            }
        }
        if (AnimalLocation == finalrect_8)//通关
        {
            GLES30.glClearColor(0.161f,0.714f,0.97f, 1.0f);//更新成初始颜色
            if (aniYRect<15)
            {
                finalOneFlag=false;
                finalTwoFlag=false;
                finalThreeFlag=false;
                finalFourFlag=false;
                finalFiveFlag=false;
                finalSixFlag=false;
                finalSevenFlag=false;
                finalEightFlag=true;//第八关终点标志位设置为true
                Resetpop();//调用道具重置方法
                flag=false;//停止移动线程
                timer_body_flag = false;//停止切换线程
                time_foot_flag=false;
                isfinalwin = true;//显示通关
                if (sound)
                {
                    MainActivity.soundManager.playMusic(Sound_finish,0);//通关音效
                }
            }
        }
    }
    //判断吃掉豆子   4.9改过了
    public void isBean(float colCenter,float rowCenter)
    {
        float span = 180.0f;
        float col=(float)Math.floor(colCenter/span);
        float row=(float)Math.floor(rowCenter/span);
        int aniBeanCenter=BEANMAPTemp[(int)row][(int)col];
        float aniXRect=colCenter-col*span;
        float aniYRect=rowCenter-row*span;
        if (aniBeanCenter==bean)
        {
            if (magnetUse_flag)
            {
                Score++;
                BEANMAPTemp[(int) row][(int) col] = 0;
                if (sound) {
                    MainActivity.soundManager.playMusic(Sound_eat, 0);//吃东西音效
                }
            }
            else if (aniXRect>30&&aniXRect<150&&aniYRect<120)
            {
                BEANMAPTemp[(int) row][(int) col] = 0;
                Score++;
                if (sound) {
                    MainActivity.soundManager.playMusic(Sound_eat, 0);//吃东西音效
                }
            }
        }
    }
    //动物跳跃部分
    public void animalJump()
    {
        //往左跳的时候循环就走一次那么我们的目的是让这一次循环时间变得长一些
        //当往左跳标志位是true的时候，关闭除了rect_left之外的碰撞检测
        AnimalJumpFlag=true;
        float tempCurrentChickenX;
        float tempCurrentChickenY;
        //右转90度
        //抬起的时候rotateTime变成0
        while (AnimalJumpTime<FlyTime) {
            AnimalJumpTime++;
            //跳跃标志位为true
            AnimalJumpFlag = true;
            //AnimalJumpTime++;
            tempCurrentAngle = rotateDirection;
            tempCurrentChickenX = (float) Math.sin(Math.toRadians(tempCurrentAngle)) * AnimalV * AnimalJumpTime;
            tempCurrentChickenY = (float) Math.cos(Math.toRadians(tempCurrentAngle)) * AnimalV * AnimalJumpTime;
            float R = 20.0f;
            //计算碰撞点所在地图的行列位置
            //再这里发生的是矩形区域的情况
            //col是x，row是y.
            float colCenter = (float) Math.floor(AnimalLocationX - tempCurrentChickenX + AnimalStartX - R * Math.sin(Math.toRadians(rotateDirection)));
            float rowCenter = (float) Math.floor(AnimalLocationY - tempCurrentChickenY + AnimalStartY - R * Math.cos(Math.toRadians(rotateDirection)));
            //判断吃掉bean
            isBean(colCenter, rowCenter);
            isColFlag = checkAniHead(AnimalLocationX - tempCurrentChickenX, AnimalLocationY - tempCurrentChickenY, rotateDirection);
            if (!isColFlag) {
                //没有发生碰撞的时候保持继续移动
                rotateDirection = tempCurrentAngle;
                AnimalLocationX = AnimalLocationX - tempCurrentChickenX;
                AnimalLocationY = AnimalLocationY - tempCurrentChickenY;
                synchronized (lock1) {
                    AR_aniX = AnimalLocationX;
                    AR_aniY = AnimalLocationY;
                }
            }
            if (isColFlag) {
                if (sound)
                {
                    MainActivity.soundManager.playMusic(Sound_fall, 0);

                }
                //碰撞的时候
                isFail = true;//游戏结束
                over_flag = false;//撞上了
                AnimalV = 0;//撞到赛道
                flag = false;//停止移动线程
                timer_body_flag = false;//停止切换线程
                time_foot_flag=false;
                GameOverResetPop();//发生碰撞道具失效
            }
            //限制住让其转弯一次
            rotateTime++;
            try {
                Thread.sleep(60);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (AnimalJumpTime==FlyTime)
        {
            AniJumpLeftFlag=false;
            AniJumpDownFlag = false;
            AniJumpRightFlag = false;
            AniJumpUpFlag = false;//跳跃动作结束
            AnimalJumpFlag=false;
            AnimalJumpTime = 0;//每一次使用完都要置零
        }
    }
    //碰撞检测
    public boolean isCol(float animalLocationX, float animalLocationY)
    {
        float span=180.0f;
        //计算碰撞点所在地图的行列位置
        //再这里发生的是矩形区域的情况
        float col=(float)Math.floor(animalLocationX/span);
        float row=(float)Math.floor(animalLocationY/span);
        int aniNumber=MAPTemp[(int)row][(int)col];
        float aniXRect=animalLocationX-col*span;
        float aniYRect=animalLocationY-row*span;
        //在左边区域且
        if(aniNumber==rectLeft)
        {
            //矩形区域0到-30，动物的Y坐标在10之外就算出界
            if(aniXRect>0) {
                return false;
            }
            else {
                return true;
            }
        }
        //碰到右边方块的时候
        if(aniNumber==rectRight&&!AniJumpLeftFlag) {
            //矩形区域0到30，动物的Y坐标在40之外就算出界
            if(aniXRect<120) {
                return false;
            }
            else {
                return true;
            }
        }
        //碰到上面的方块
        if(aniNumber==rectTop&&!AniJumpLeftFlag) {
            if(aniYRect>0) {
                return false;
            }
            else {
                return true;
            }
        }
        //碰到下面的方块
        if(aniNumber==rectDown&&!AniJumpLeftFlag) {
            if(aniYRect<6) {
                return false;
            }
            else {
                return true;
            }
        }
        //窄的矩形
        if (aniNumber == narrowrect) {
            if (securityUse_flag) {
                if (aniXRect>0&&aniXRect<120) {
                    return false;
                }
                else {
                    return true;
                }
            }
            else {
                if (aniXRect<30||aniXRect>150) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        //碰到向上的半圆
        if(aniNumber==rectTop_top&&!AniJumpLeftFlag&&!AniJumpUpFlag) {
            if(aniYRect>0) {
                return false;
            }
            else {
                return true;
            }
        }
        if (aniNumber==0&&!AniJumpRightFlag&&!AniJumpUpFlag&&!AniJumpLeftFlag&&!AniJumpDownFlag) {
            return true;
        }
        return false;
    }
    //头部中心碰撞检测
    public boolean checkAniHead(float animalX,float animalY,float rotateDirection) {
        float R=15.0f;
        float aniTempX=0;
        float aniTempY=0;
        aniTempX=(float)(animalX+AnimalStartX-R*Math.sin(Math.toRadians(rotateDirection)));
        aniTempY=(float)(animalY+AnimalStartY-R*Math.cos(Math.toRadians(rotateDirection)));
        return isCol(aniTempX,aniTempY);
    }
    //道具使用结束方法  4.9
    public void Resetpop()
    {
        if (clockUse_flag)//如果之前使用秒表，本次结束，并上锁
        {
            clockUse_flag = false;
            clockLogo_flag = false;
        }
        if (magnetUse_flag)//如果之前使用磁石，本次结束，并上锁
        {
            magnetUse_flag = false;
            magnetLogo_flag = false;
        }
        if (securityUse_flag)//如果之前使用盾牌，本次结束，并上锁
        {
            securityUse_flag = false;
            securityLogo_flag = false;
        }
    }
    //游戏结束道具失效
    public void GameOverResetPop()
    {
        if (clockUse_flag)//如果使用秒表
        {
            clockUse_flag = false;
        }
        if (magnetUse_flag)//如果使用磁石
        {
            magnetUse_flag = false;
        }
        if (securityUse_flag)//如果使用盾牌
        {
            securityUse_flag = false;
        }
    }
}
