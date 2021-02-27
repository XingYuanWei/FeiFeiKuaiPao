package com.bn.feifeikuaipao;
import android.content.Context;
import android.content.SharedPreferences;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Toast;
import com.bn.feifeikuaipao.MatrixState.MatrixState;
import com.bn.feifeikuaipao.ParticleSystemSnow.ParticleSnow;
import com.bn.feifeikuaipao.ParticleSystemSnow.ParticleSnowForDraw;
import com.bn.feifeikuaipao.TexManager.TexDrawer;
import com.bn.feifeikuaipao.TexManager.TexManager;
import com.bn.feifeikuaipao.Thread.AnimalRunThread;
import com.bn.feifeikuaipao.constant.Constant;
import com.bn.feifeikuaipao.constant.MapConstant;
import com.bn.feifeikuaipao.picData.Pic2DData;
import com.bn.feifeikuaipao.view.CurrentView;
import com.bn.feifeikuaipao.view.FailGameView;
import com.bn.feifeikuaipao.view.MainView;
import com.bn.feifeikuaipao.view.MapView;
import com.bn.feifeikuaipao.view.OptionView;
import com.bn.feifeikuaipao.view.RunView;
import com.bn.feifeikuaipao.view.TouchContinueGameView;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import static com.bn.feifeikuaipao.Thread.AnimalRunThread.AR_aniX;
import static com.bn.feifeikuaipao.Thread.AnimalRunThread.AR_aniY;
import static com.bn.feifeikuaipao.Thread.TimeBodyThread.timer_body_flag;
import static com.bn.feifeikuaipao.Thread.TimesFootThread.time_foot_flag;
import static com.bn.feifeikuaipao.constant.Constant.cx;
import static com.bn.feifeikuaipao.constant.Constant.cy;
import static com.bn.feifeikuaipao.constant.SourceConstant.AnimalV;
import static com.bn.feifeikuaipao.constant.SourceConstant.HBombBigX;
import static com.bn.feifeikuaipao.constant.SourceConstant.HBombBigY;
import static com.bn.feifeikuaipao.constant.SourceConstant.HBombSmallX;
import static com.bn.feifeikuaipao.constant.SourceConstant.HBombSmallY;
import static com.bn.feifeikuaipao.constant.SourceConstant.bombAngle;
import static com.bn.feifeikuaipao.constant.SourceConstant.bombCount;
import static com.bn.feifeikuaipao.constant.SourceConstant.bombSizeBigX;
import static com.bn.feifeikuaipao.constant.SourceConstant.bombSizeBigY;
import static com.bn.feifeikuaipao.constant.SourceConstant.bombSizeSmallX;
import static com.bn.feifeikuaipao.constant.SourceConstant.bombSizeSmallY;
import static com.bn.feifeikuaipao.constant.SourceConstant.bombSmallXRange;
import static com.bn.feifeikuaipao.constant.SourceConstant.bombSmallYRange;
import static com.bn.feifeikuaipao.constant.SourceConstant.bombStartLocationX;
import static com.bn.feifeikuaipao.constant.SourceConstant.bombStartLocationY;
import static com.bn.feifeikuaipao.constant.SourceConstant.bombXRange;
import static com.bn.feifeikuaipao.constant.SourceConstant.bombYRange;
import static com.bn.feifeikuaipao.constant.SourceConstant.lock1;
import static com.bn.feifeikuaipao.constant.SourceConstant.snowBigSizeX;
import static com.bn.feifeikuaipao.constant.SourceConstant.snowBigSizeY;
import static com.bn.feifeikuaipao.constant.SourceConstant.snowCount;
import static com.bn.feifeikuaipao.constant.SourceConstant.snowSmallSizeX;
import static com.bn.feifeikuaipao.constant.SourceConstant.snowSmallSizeY;
import static com.bn.feifeikuaipao.constant.SourceConstant.snowStartPositionX;
import static com.bn.feifeikuaipao.constant.SourceConstant.snowStartPositionY;
import static com.bn.feifeikuaipao.view.RunView.texIDBg_Bomb;
import static com.bn.feifeikuaipao.view.RunView.texIDSnow_big;
import static com.bn.feifeikuaipao.view.RunView.texIDSnow_small;

public class GameSurfaceView extends GLSurfaceView
{
    public TouchContinueGameView touchContinueGameView;
    private SceneRenderer mRenderer;//场景渲染器
    static float ratio;
    public CurrentView currentView;
    public RunView runView;//游戏界面
    public MainView mainView;//主界面
    public MapView mapView;//地图选择界面
    public OptionView optionView;//选项界面
    public FailGameView failGameView;//游戏失败界面
    public TexDrawer texDrawer;//纹理三角形对象引用
    public static boolean isExit = false; //准备退出
    public static boolean ismain = false;
    //============雪花粒子系统创建对象=================
    ParticleSnow particleSnow;
    ParticleSnowForDraw particleSnowForDraw;
    public static float MV_aniX;
    public static float MV_aniY;
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };
    public GameSurfaceView(Context context)
    {
        super(context);
        for (int i=0;i<bombCount;i++)
        {
            HBombBigX.put(i,bombStartLocationX+(float)Math.random()*bombXRange);
            HBombBigY.put(i,bombStartLocationY+(float)Math.random()*bombYRange);
            HBombSmallX.put(i,bombStartLocationX+(float)Math.random()*bombSmallXRange);
            HBombSmallY.put(i,bombStartLocationY+(float)Math.random()*bombSmallYRange);
        }
        this.setEGLContextClientVersion(3);	//设置使用OPENGL ES3.0
        mRenderer = new SceneRenderer();	//创建场景渲染器
        setRenderer(mRenderer);				//设置渲染器
        setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);//设置渲染模式为主动渲染
    }
    //触摸事件回调方法
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if(currentView == null)
        {
            return false;
        }
        return currentView.onTouchEvent(event);
    }
    //返回键事件
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            if(currentView==optionView)//选项界面
            {
                currentView=mainView;//返回主界面
                ismain =false;
            }
            else if (currentView==mapView)//选择世界界面
            {
                currentView=mainView;//返回主界面
                ismain=false;
            }
            else if (currentView==runView)//在游戏界面
            {
                exit();
            }
            else if (currentView==mainView)//在主界面准备退出游戏
            {
                exit();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    //退出方法
    public void exit()
    {
        if (!isExit)
        {
            SharedPreferences sp=getContext().getSharedPreferences("mp", Context.MODE_PRIVATE);//开启下一关
            SharedPreferences.Editor editor=sp.edit();
            editor.putString("mapdata", MapConstant.mapIndex+"");
            editor.commit();
            isExit = true;//准备退出
            if (currentView==mainView)
            {
                Toast.makeText(this.getContext(),"再按一次，退出游戏！",Toast.LENGTH_SHORT).show();//显示提示信息
            }
            if (currentView==runView)
            {
                Toast.makeText(this.getContext(),"再按一次，返回到主界面！",Toast.LENGTH_SHORT).show();//显示提示信息
            }
            mHandler.sendEmptyMessageDelayed(0, 2000);//两秒内再按有效
        }
        else
        {
            if (currentView==mainView)
            {
                android.os.Process.killProcess(android.os.Process.myPid());//结束所有线程  使用System.exit(0)可以清除缓存
            }
            if (currentView==runView)
            {
                currentView = mainView;//返回到主界面
                AnimalRunThread.flag = false;//停止行走线程
                timer_body_flag = false;//停止切换线程
                time_foot_flag=false;
                AnimalV=0.0f;//行走速度为零
            }
        }
    }
    private class SceneRenderer implements GLSurfaceView.Renderer
    {
        public void onDrawFrame(GL10 gl)
        {
            synchronized (lock1)
            {
                MV_aniX=AR_aniX;
                MV_aniY=AR_aniY;
            }
            //清除深度缓冲与颜色缓冲
            GLES30.glClear( GLES30.GL_DEPTH_BUFFER_BIT | GLES30.GL_COLOR_BUFFER_BIT);
            MatrixState.pushMatrix();
            //全景视口参数,前后左右大小1.7
            //(-Constant.ssr.vpRatio, Constant.ssr.vpRatio, -1.7f, 1.7f, 1, 20);
            MatrixState.setProjectOrtho(-Constant.ssr.vpRatio, Constant.ssr.vpRatio, -Constant.ssr.vpRatio-0.3f, Constant.ssr.vpRatio+0.3f, 1, 20);
            //调用此方法产生摄像机9参数位置矩阵
            //摄影机摆放初始位置
            //每次移动0.1的位置就会有比较大的变动
//            MatrixState.setCamera(0.5f,-0.3f,3f,0.5f,-0.3f,0f,0f,1f,0.0f);
            MatrixState.setCamera
                        (
                                cx+(MV_aniX/1000),-cy-MV_aniY/1000 ,5f,
                                cx+(MV_aniX/1000),-cy-MV_aniY/1000, 0f,
                                0f,1f,0.0f
                        );
            drawSnow();
            drawBomb();
            if (currentView == null)
            {
                currentView = mainView;
            }
            if(currentView!=null)
            {
                currentView.drawView(gl);
            }
            MatrixState.popMatrix();
        }
        public void onSurfaceChanged(GL10 gl, int width, int height)
        {
            GLES30.glViewport(0, 0, width, height);
            //计算GLSurfaceView的宽高比
            ratio = (float) width / height;
            //设置平行投影矩阵
            MatrixState.setProjectOrtho(-Constant.ssr.vpRatio, Constant.ssr.vpRatio, -Constant.ssr.vpRatio-0.3f, Constant.ssr.vpRatio+0.3f, 1, 20);
//            MatrixState.setCamera(0.5f,-0.3f,3f,0.5f,-0.3f,0f,0f,1f,0.0f);
            //调用此方法产生摄像机9参数位置矩阵
            MatrixState.setCamera
                    (
                            cx+(MV_aniX/1000),-cy-MV_aniY/1000 ,5f,
                            cx+(MV_aniX/1000),-cy-MV_aniY/1000, 0f,
                            0f,1f,0.0f
                    );
            //初始化变换矩阵
            MatrixState.setInitStack();
        }
        public void onSurfaceCreated(GL10 gl, EGLConfig config)
        {
            //设置屏幕背景色RGBA
            GLES30.glClearColor(0.161f,0.714f,0.97f, 1.0f);
            GLES30.glDisable(GLES30.GL_DEPTH_TEST);
            //打开背面剪裁
            GLES30.glEnable(GLES30.GL_CULL_FACE);
            MatrixState.setInitStack();
            //初始化纹理
            TexManager.addTexArray(Pic2DData.picName);
            //加载纹理(里面的参数是为了根据r类找到图片)
            TexManager.loadTextures(GameSurfaceView.this.getResources());
            //创建三角形对对象
            //创建界面对象
            texDrawer=new TexDrawer(GameSurfaceView.this);
            runView=new RunView(GameSurfaceView.this);
            mainView = new MainView(GameSurfaceView.this);
            optionView = new OptionView(GameSurfaceView.this);
            mapView = new MapView(GameSurfaceView.this);
            particleSnowForDraw=new ParticleSnowForDraw(GameSurfaceView.this,20);
            failGameView=new FailGameView(GameSurfaceView.this);
            particleSnow=new ParticleSnow(snowStartPositionX,snowStartPositionY,particleSnowForDraw,snowCount);
            touchContinueGameView=new TouchContinueGameView(GameSurfaceView.this);
        }
        //绘制雪花部分
        public void drawSnow()
        {
            particleSnow.drawSelf(texIDSnow_big,snowSmallSizeX,snowSmallSizeY);
            particleSnow.drawSelf(texIDSnow_small,snowBigSizeX,snowBigSizeY);
        }
        public void drawBomb()
        {
            if(currentView==runView)
            {
                bombAngle=bombAngle+0.5f;
                for (int i=0;i<bombCount;i++)
                {
                    texDrawer.drawSelf(texIDBg_Bomb,HBombBigX.get(i),HBombBigY.get(i),bombSizeBigX,bombSizeBigY,bombAngle,2);
                    texDrawer.drawSelf(texIDBg_Bomb,HBombSmallX.get(i),HBombSmallY.get(i),bombSizeSmallX,bombSizeSmallY,bombAngle,2);
                }
            }
        }
    }
}
