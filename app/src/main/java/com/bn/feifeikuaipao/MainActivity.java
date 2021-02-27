package com.bn.feifeikuaipao;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import com.bn.screen.auto.ScreenScaleUtil;
import com.bn.feifeikuaipao.SoundManager.SoundManager;
import com.bn.feifeikuaipao.constant.Constant;
import static com.bn.feifeikuaipao.Thread.AnimalRunThread.flag;
import static com.bn.feifeikuaipao.Thread.TimeBodyThread.timer_body_flag;
import static com.bn.feifeikuaipao.Thread.TimesFootThread.time_foot_flag;
import static com.bn.feifeikuaipao.constant.SourceConstant.touchContinueGameFlag;
import static com.bn.feifeikuaipao.view.RunView.isFail;

public class MainActivity extends Activity {
    private GameSurfaceView mGLSurfaceView;
    public static SoundManager soundManager;//声音
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //设置为全屏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN ,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //设置为竖屏模式
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //获取屏幕宽度高度
        WindowManager manager = this.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        Constant.SCREEN_WIDTH = outMetrics.widthPixels;
        Constant.SCREEN_HEIGHT= outMetrics.heightPixels;
        //计算屏幕自适应
        Constant.ssr= ScreenScaleUtil.calScale(Constant.SCREEN_WIDTH,Constant.SCREEN_HEIGHT);
        soundManager = new SoundManager(this);
        //切换到主界面
        //初始化GLSurfaceView
        mGLSurfaceView = new GameSurfaceView(this);
        setContentView(mGLSurfaceView);
        mGLSurfaceView.requestFocus();//获取焦点
        mGLSurfaceView.setFocusableInTouchMode(true);//设置为可触控
    }
    @Override
    protected void onResume()
    {
        super.onResume();
        if(touchContinueGameFlag&&!isFail)
        {
            mGLSurfaceView.currentView=mGLSurfaceView.touchContinueGameView;//切换到轻触继续界面
            touchContinueGameFlag=false;
        }
        mGLSurfaceView.onResume();
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        if(mGLSurfaceView.currentView==mGLSurfaceView.runView&&!isFail)//当动物正在行走但是我们按下home键的时候
        {
            //切换到轻触继续界面
            touchContinueGameFlag=true;
            //假如不停止线程，那么切换到轻触继续界面还是会发生动物继续走的情况
            flag=false;//设置直走标志位为false，停止线程
            timer_body_flag=false;//设置切图标志位为false，停止线程
            time_foot_flag=false;
        }
        mGLSurfaceView.onPause();
    }
}