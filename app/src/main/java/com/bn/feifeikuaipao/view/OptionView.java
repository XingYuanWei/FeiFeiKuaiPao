package com.bn.feifeikuaipao.view;
import android.view.MotionEvent;
import com.bn.screen.auto.ScreenScaleUtil;
import com.bn.feifeikuaipao.MainActivity;
import com.bn.feifeikuaipao.MatrixState.MatrixState;
import com.bn.feifeikuaipao.GameSurfaceView;
import com.bn.feifeikuaipao.TexManager.TexManager;
import javax.microedition.khronos.opengles.GL10;
import static com.bn.feifeikuaipao.constant.Constant.ssr;
import static com.bn.feifeikuaipao.constant.SourceConstant.Optionview_about_ButtonX;
import static com.bn.feifeikuaipao.constant.SourceConstant.Optionview_about_ButtonY;
import static com.bn.feifeikuaipao.constant.SourceConstant.Optionview_about_Button_LocationX;
import static com.bn.feifeikuaipao.constant.SourceConstant.Optionview_about_Button_LocationY;
import static com.bn.feifeikuaipao.constant.SourceConstant.Optionview_return_ButtonX;
import static com.bn.feifeikuaipao.constant.SourceConstant.Optionview_return_ButtonY;
import static com.bn.feifeikuaipao.constant.SourceConstant.Optionview_return_Button_LocationX;
import static com.bn.feifeikuaipao.constant.SourceConstant.Optionview_return_Button_LocationY;
import static com.bn.feifeikuaipao.constant.SourceConstant.Optionview_sound_ButtonX;
import static com.bn.feifeikuaipao.constant.SourceConstant.Optionview_sound_ButtonY;
import static com.bn.feifeikuaipao.constant.SourceConstant.Optionview_sound_Button_LocationX;
import static com.bn.feifeikuaipao.constant.SourceConstant.Optionview_sound_Button_LocationY;
import static com.bn.feifeikuaipao.constant.SourceConstant.Optionview_sound_no_ButtonX;
import static com.bn.feifeikuaipao.constant.SourceConstant.Optionview_sound_no_Button_LocationX;
import static com.bn.feifeikuaipao.constant.SourceConstant.Optionview_sound_no_Button_LocationY;
import static com.bn.feifeikuaipao.constant.SourceConstant.Sound_click;
import static com.bn.feifeikuaipao.constant.SourceConstant.bg_menuX;
import static com.bn.feifeikuaipao.constant.SourceConstant.bg_menuY;
import static com.bn.feifeikuaipao.constant.SourceConstant.bg_menu_LocationX;
import static com.bn.feifeikuaipao.constant.SourceConstant.bg_menu_LocationY;
import static com.bn.feifeikuaipao.constant.SourceConstant.sound;
import static com.bn.feifeikuaipao.constant.SourceConstant.word_aboutX;
import static com.bn.feifeikuaipao.constant.SourceConstant.word_aboutY;
import static com.bn.feifeikuaipao.constant.SourceConstant.word_about_LocationX;
import static com.bn.feifeikuaipao.constant.SourceConstant.word_about_LocationY;
import static com.bn.feifeikuaipao.constant.SourceConstant.word_optionX;
import static com.bn.feifeikuaipao.constant.SourceConstant.word_optionY;
import static com.bn.feifeikuaipao.constant.SourceConstant.word_option_LocationX;
import static com.bn.feifeikuaipao.constant.SourceConstant.word_option_LocationY;
import static com.bn.feifeikuaipao.constant.SourceConstant.word_returnX;
import static com.bn.feifeikuaipao.constant.SourceConstant.word_returnY;
import static com.bn.feifeikuaipao.constant.SourceConstant.word_return_LocationX;
import static com.bn.feifeikuaipao.constant.SourceConstant.word_return_LocationY;
import static com.bn.feifeikuaipao.constant.SourceConstant.word_soundX;
import static com.bn.feifeikuaipao.constant.SourceConstant.word_soundY;
import static com.bn.feifeikuaipao.constant.SourceConstant.word_sound_LocationX;
import static com.bn.feifeikuaipao.constant.SourceConstant.word_sound_LocationY;
import static com.bn.feifeikuaipao.view.MainView.texIDWord_option;
import static com.bn.feifeikuaipao.view.MainView.texIDbg_menu;
public class OptionView extends CurrentView {
    public GameSurfaceView viewManager;
    public static int texIDWord_sound = TexManager.getTex("word_sound.png");//声音文字图片
    public static int texIDWord_about = TexManager.getTex("word_about.png");//鸣谢文字图片
    public static int texIDWord_return = TexManager.getTex("word_return.png");//后退文字图片
    public static int texIDSound_Button = TexManager.getTex("sound.png");//声音按钮
    public static int texIDSound_no_Button = TexManager.getTex("sound_no.png");//静音按钮
    public static int texIDAbout_Button = TexManager.getTex("about.png");//感谢或是版权按钮
    public static int texIDReturn_Button = TexManager.getTex("return.png");//返回按钮
    public static int texIDAboutPic = TexManager.getTex("aboutpic.png");//关于弹出图片
    public static boolean aboutflag = false;//是否弹出关于图片标志位
    public OptionView(GameSurfaceView viewManager)
    {
        this.viewManager = viewManager;
    }
    @Override
    public void initView() {
    }
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        //屏幕自适应，将所在机型的x y坐标转换为默认坐标 xy[0]=e.getX(),xy[1]=e.getY();
        int[] xy= ScreenScaleUtil.touchFromTargetToOrigin(e.getX(),e.getY(),ssr);
        float x=xy[0];
        float y=xy[1];
        switch (e.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                if (x>160&&x<290&&y>840&&y<980)//音效按钮
                {
                    if (sound)
                    {
                        sound = false;
                    }
                    else
                    {
                        sound = true;
                    }
                }
                if (aboutflag)
                {
                    aboutflag = false;//触摸屏幕任意处图片消失
                }
                if (x>470&&x<610&&y>840&&y<980)//鸣谢按钮
                {
                    aboutflag = true;//弹出图片
                    if (sound)
                    {
                        MainActivity.soundManager.playMusic(Sound_click,0);//点击声音
                    }
                }
                if (x>790&&x<920&&y>840&&y<980)//返回按钮
                {
                    if (sound)
                    {
                        MainActivity.soundManager.playMusic(Sound_click,0);//点击声音
                    }
                    viewManager.currentView = viewManager.mainView;//返回主界面
                }
        }
        return false;
    }
    @Override
    public void drawView(GL10 gl) {
        MatrixState.setCamera(1f,-1.8f,5f,1f,-1.8f,0f,0f,1f,0.0f);
        MatrixState.pushMatrix();
        if (sound)//绘制声音按钮
        {
            viewManager.texDrawer.drawSelf(texIDSound_Button,Optionview_sound_Button_LocationX,Optionview_sound_Button_LocationY,Optionview_sound_ButtonX,Optionview_sound_ButtonY,0,2);
        }
        else
        {
            viewManager.texDrawer.drawSelf(texIDSound_no_Button,Optionview_sound_no_Button_LocationX,Optionview_sound_no_Button_LocationY,Optionview_sound_no_ButtonX,Optionview_sound_ButtonY,0,2);
        }
        //绘制声音文字图片
        viewManager.texDrawer.drawSelf(texIDWord_sound,word_sound_LocationX,word_sound_LocationY,word_soundX,word_soundY,0,2);
        //绘制鸣谢文字图片
        viewManager.texDrawer.drawSelf(texIDWord_about,word_about_LocationX,word_about_LocationY,word_aboutX,word_aboutY,0,2);
        //绘制返回文字图片
        viewManager.texDrawer.drawSelf(texIDWord_return,word_return_LocationX,word_return_LocationY,word_returnX,word_returnY,0,2);
        //绘制选项文字图片
        viewManager.texDrawer.drawSelf(texIDWord_option,word_option_LocationX,word_option_LocationY,word_optionX,word_optionY,0,2);
        //绘制蓝色底边
        viewManager.texDrawer.drawSelf(texIDbg_menu,bg_menu_LocationX,bg_menu_LocationY,bg_menuX,bg_menuY,0,2);
        //绘制鸣谢按钮
        viewManager.texDrawer.drawSelf(texIDAbout_Button,Optionview_about_Button_LocationX,Optionview_about_Button_LocationY,Optionview_about_ButtonX,Optionview_about_ButtonY,0,2);
        //后退界面按钮
        viewManager.texDrawer.drawSelf(texIDReturn_Button,Optionview_return_Button_LocationX,Optionview_return_Button_LocationY,Optionview_return_ButtonX,Optionview_return_ButtonY,0,2);
        //关于界面
        if (aboutflag)
        {
            viewManager.texDrawer.drawSelf(texIDAboutPic,1500,2400,400,400,0,2);
        }
        MatrixState.popMatrix();
    }
}
