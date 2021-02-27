package com.bn.feifeikuaipao.view;

import android.opengl.GLES30;
import android.view.MotionEvent;

import com.bn.screen.auto.ScreenScaleUtil;
import com.bn.feifeikuaipao.MainActivity;
import com.bn.feifeikuaipao.MatrixState.MatrixState;
import com.bn.feifeikuaipao.GameSurfaceView;
import com.bn.feifeikuaipao.TexManager.TexManager;

import javax.microedition.khronos.opengles.GL10;
import static com.bn.feifeikuaipao.constant.Constant.ssr;
import static com.bn.feifeikuaipao.constant.SourceConstant.Mainview_Continue_ButtonX;
import static com.bn.feifeikuaipao.constant.SourceConstant.Mainview_Continue_ButtonY;
import static com.bn.feifeikuaipao.constant.SourceConstant.Mainview_Continue_Button_LocationX;
import static com.bn.feifeikuaipao.constant.SourceConstant.Mainview_Continue_Button_LocationY;
import static com.bn.feifeikuaipao.constant.SourceConstant.Mainview_Option_ButtonX;
import static com.bn.feifeikuaipao.constant.SourceConstant.Mainview_Option_ButtonY;
import static com.bn.feifeikuaipao.constant.SourceConstant.Mainview_Option_Button_LocationX;
import static com.bn.feifeikuaipao.constant.SourceConstant.Mainview_Option_Button_LocationY;
import static com.bn.feifeikuaipao.constant.SourceConstant.Mainview_logoX;
import static com.bn.feifeikuaipao.constant.SourceConstant.Mainview_logoY;
import static com.bn.feifeikuaipao.constant.SourceConstant.Mainview_logo_LocationX;
import static com.bn.feifeikuaipao.constant.SourceConstant.Mainview_logo_LocationY;
import static com.bn.feifeikuaipao.constant.SourceConstant.Sound_click;
import static com.bn.feifeikuaipao.constant.SourceConstant.bg_menuX;
import static com.bn.feifeikuaipao.constant.SourceConstant.bg_menuY;
import static com.bn.feifeikuaipao.constant.SourceConstant.bg_menu_LocationX;
import static com.bn.feifeikuaipao.constant.SourceConstant.bg_menu_LocationY;
import static com.bn.feifeikuaipao.constant.SourceConstant.sound;
import static com.bn.feifeikuaipao.constant.SourceConstant.word_beginX;
import static com.bn.feifeikuaipao.constant.SourceConstant.word_beginY;
import static com.bn.feifeikuaipao.constant.SourceConstant.word_continueX;
import static com.bn.feifeikuaipao.constant.SourceConstant.word_continueY;
import static com.bn.feifeikuaipao.constant.SourceConstant.word_continue_LocationX;
import static com.bn.feifeikuaipao.constant.SourceConstant.word_continue_LocationY;
public class MainView extends CurrentView {
    public GameSurfaceView viewManager;
    public static int texIDContinue_button = TexManager.getTex("continue.png");//继续图片
    public static int texIDOption_button = TexManager.getTex("set.png");//设置图片
    public static int texIDLogo = TexManager.getTex("logo.png");//logo图片
    public static int texIDWord_continue = TexManager.getTex("word_continue.png");//继续文字图片
    public static int texIDWord_option = TexManager.getTex("word_option.png");//选项文字图片
    public static int texIDbg_menu =TexManager.getTex("bg_menu.png");//蓝色底边
    public MainView(GameSurfaceView viewManager)
    {
        this.viewManager = viewManager;
    }
    @Override
    public void initView() {
    }
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        //屏幕自适应，将所在机型的x y坐标转换为默认坐标 xy[0]=e.getX(),xy[1]=e.getY();
        int[] xy=ScreenScaleUtil.touchFromTargetToOrigin(e.getX(),e.getY(),ssr);
        float x=xy[0];
        float y=xy[1];
        switch (e.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                if (x>380&&x<710 &&y>940&&y<1270)//转到地图选择界面
                {
                    viewManager.currentView = viewManager.mapView;
                    if (sound)
                    {
                        MainActivity.soundManager.playMusic(Sound_click,0);//点击声音
                    }
                }
                if (x>470&&x<600&&y>1650&&y<1800)//跳转到选项界面
                {
                    viewManager.currentView = viewManager.optionView;//跳转到选项界面
                    if (sound)
                    {
                        MainActivity.soundManager.playMusic(Sound_click,0);//点击声音
                    }
                }
        }
        return false;
    }
    @Override
    public void drawView(GL10 gl)
    {
        MatrixState.pushMatrix();
        GLES30.glClearColor(0.161f,0.714f,0.97f,1.0f);//恢复颜色
        MatrixState.setCamera(1f,-1.8f,5f,1f,-1.8f,0f,0f,1f,0.0f);
        //绘制logo
        viewManager.texDrawer.drawSelf(texIDLogo,Mainview_logo_LocationX,Mainview_logo_LocationY,Mainview_logoX,Mainview_logoY,0,2);
        //绘制蓝色底边
        viewManager.texDrawer.drawSelf(texIDbg_menu,bg_menu_LocationX,bg_menu_LocationY,bg_menuX,bg_menuY,0,2);
        //继续按钮
        viewManager.texDrawer.drawSelf(texIDContinue_button,Mainview_Continue_Button_LocationX,Mainview_Continue_Button_LocationY,Mainview_Continue_ButtonX,Mainview_Continue_ButtonY,0,2);
        //绘制继续文字
        viewManager.texDrawer.drawSelf(texIDWord_continue,word_continue_LocationX,word_continue_LocationY,word_continueX,word_continueY,0,2);
        //选项按钮
        viewManager.texDrawer.drawSelf(texIDOption_button,Mainview_Option_Button_LocationX,Mainview_Option_Button_LocationY,Mainview_Option_ButtonX,Mainview_Option_ButtonY,0,2);
        //绘制选项文字
        viewManager.texDrawer.drawSelf(texIDWord_option,1500,3370,word_beginX,word_beginY,0,2);
        MatrixState.popMatrix();
    }
}
