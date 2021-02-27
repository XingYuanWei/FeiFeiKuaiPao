package com.bn.feifeikuaipao.view;
import android.view.MotionEvent;
import com.bn.screen.auto.ScreenScaleUtil;
import com.bn.feifeikuaipao.MatrixState.MatrixState;
import com.bn.feifeikuaipao.GameSurfaceView;
import com.bn.feifeikuaipao.TexManager.TexManager;
import javax.microedition.khronos.opengles.GL10;
import static com.bn.feifeikuaipao.Thread.AnimalRunThread.flag;
import static com.bn.feifeikuaipao.Thread.TimeBodyThread.timer_body_flag;
import static com.bn.feifeikuaipao.Thread.TimesFootThread.time_foot_flag;
import static com.bn.feifeikuaipao.constant.Constant.ssr;
import static com.bn.feifeikuaipao.constant.SourceConstant.touchContinue_Location_X;
import static com.bn.feifeikuaipao.constant.SourceConstant.touchContinue_Location_Y;
import static com.bn.feifeikuaipao.constant.SourceConstant.touchContinue_X;
import static com.bn.feifeikuaipao.constant.SourceConstant.touchContinue_Y;
import static com.bn.feifeikuaipao.view.FailGameView.texIDFailgameView;
public class TouchContinueGameView extends CurrentView
{
    public GameSurfaceView viewManager;
    public int texIDTouchContinueGame= TexManager.getTex("touch_continue_game.png");
    public TouchContinueGameView(GameSurfaceView viewManager)
    {
        this.viewManager=viewManager;
    }
    @Override
    public void initView() {
    }
    public boolean onTouchEvent(MotionEvent e)
    {
        int xy[] = ScreenScaleUtil.touchFromTargetToOrigin(e.getX(),e.getY(),ssr);
        float x=xy[0];
        float y=xy[1];
        switch (e.getAction())
        {
            case MotionEvent.ACTION_UP:
                if (x>0&&x<1920&&y>0&&y<1920)
                {
                    viewManager.currentView=viewManager.runView;
                    flag=true;//恢复线程标志位
                    timer_body_flag=true;
                    time_foot_flag=true;
                    viewManager.runView.initView();//启动线程
                }
                break;
        }
        return true;
    }
    @Override
    public void drawView(GL10 gl)
    {
        MatrixState.setCamera(1f,-1.8f,5f,1f,-1.8f,0f,0f,1f,0.0f);
        //轻触继续的时候线程还是在行走，并不能停下来
        viewManager.texDrawer.drawSelf(texIDFailgameView,1500,2500,500,1000,0,2);
        viewManager.texDrawer.drawSelf(texIDTouchContinueGame,touchContinue_Location_X,touchContinue_Location_Y,touchContinue_X,touchContinue_Y,0,2);

    }
}
