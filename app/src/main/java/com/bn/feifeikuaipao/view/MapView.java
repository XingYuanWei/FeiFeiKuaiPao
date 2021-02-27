package com.bn.feifeikuaipao.view;
import android.content.Context;
import android.content.SharedPreferences;
import android.opengl.GLES30;
import android.view.MotionEvent;
import android.widget.Toast;

import com.bn.screen.auto.ScreenScaleUtil;
import com.bn.feifeikuaipao.MainActivity;
import com.bn.feifeikuaipao.MatrixState.MatrixState;
import com.bn.feifeikuaipao.GameSurfaceView;
import com.bn.feifeikuaipao.TexManager.TexManager;
import com.bn.feifeikuaipao.constant.MapConstant;
import javax.microedition.khronos.opengles.GL10;

import static com.bn.feifeikuaipao.Thread.AnimalRunThread.AR_aniX;
import static com.bn.feifeikuaipao.Thread.AnimalRunThread.AR_aniY;
import static com.bn.feifeikuaipao.Thread.AnimalRunThread.bChangeArrowColorFlag;
import static com.bn.feifeikuaipao.Thread.AnimalRunThread.flag;
import static com.bn.feifeikuaipao.Thread.AnimalRunThread.isColFlag;
import static com.bn.feifeikuaipao.Thread.AnimalRunThread.over_flag;
import static com.bn.feifeikuaipao.Thread.AnimalRunThread.tempCurrentAngle;
import static com.bn.feifeikuaipao.Thread.TimeBodyThread.timer_body_flag;
import static com.bn.feifeikuaipao.Thread.TimesFootThread.time_foot_flag;
import static com.bn.feifeikuaipao.constant.Constant.ssr;
import static com.bn.feifeikuaipao.constant.MapConstant.beanCount;
import static com.bn.feifeikuaipao.constant.MapConstant.initAllMapData;
import static com.bn.feifeikuaipao.constant.SourceConstant.AnimalLocationX;
import static com.bn.feifeikuaipao.constant.SourceConstant.AnimalLocationY;
import static com.bn.feifeikuaipao.constant.SourceConstant.AnimalV;
import static com.bn.feifeikuaipao.constant.SourceConstant.MapView_Menu_Button_LocationX;
import static com.bn.feifeikuaipao.constant.SourceConstant.MapView_Menu_Button_LocationY;
import static com.bn.feifeikuaipao.constant.SourceConstant.Mapview_Menu_ButtonX;
import static com.bn.feifeikuaipao.constant.SourceConstant.Mapview_Menu_ButtonY;
import static com.bn.feifeikuaipao.constant.SourceConstant.Sound_click;
import static com.bn.feifeikuaipao.constant.SourceConstant.arrowColorCount;
import static com.bn.feifeikuaipao.constant.SourceConstant.arrowFirst;
import static com.bn.feifeikuaipao.constant.SourceConstant.bg_menuX;
import static com.bn.feifeikuaipao.constant.SourceConstant.bg_menuY;
import static com.bn.feifeikuaipao.constant.SourceConstant.bg_menu_LocationX;
import static com.bn.feifeikuaipao.constant.SourceConstant.bg_menu_LocationY;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalEightFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalFiveFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalFourFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalOneFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalSevenFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalSixFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalThreeFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalTwoFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.moveFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.rotateDirection;
import static com.bn.feifeikuaipao.constant.SourceConstant.sound;
import static com.bn.feifeikuaipao.constant.SourceConstant.word_chooseworldX;
import static com.bn.feifeikuaipao.constant.SourceConstant.word_chooseworldY;
import static com.bn.feifeikuaipao.constant.SourceConstant.word_chooseworld_LocationX;
import static com.bn.feifeikuaipao.constant.SourceConstant.word_chooseworld_LocationY;
import static com.bn.feifeikuaipao.constant.SourceConstant.word_menuX;
import static com.bn.feifeikuaipao.constant.SourceConstant.word_menuY;
import static com.bn.feifeikuaipao.view.FailGameView.initClickEight;
import static com.bn.feifeikuaipao.view.FailGameView.initClickFive;
import static com.bn.feifeikuaipao.view.FailGameView.initClickFour;
import static com.bn.feifeikuaipao.view.FailGameView.initClickOne;
import static com.bn.feifeikuaipao.view.FailGameView.initClickSeven;
import static com.bn.feifeikuaipao.view.FailGameView.initClickSix;
import static com.bn.feifeikuaipao.view.FailGameView.initClickThree;
import static com.bn.feifeikuaipao.view.FailGameView.initClickTwo;
import static com.bn.feifeikuaipao.view.FailGameView.initWorldEight;
import static com.bn.feifeikuaipao.view.FailGameView.initWorldFive;
import static com.bn.feifeikuaipao.view.FailGameView.initWorldFour;
import static com.bn.feifeikuaipao.view.FailGameView.initWorldOne;
import static com.bn.feifeikuaipao.view.FailGameView.initWorldSeven;
import static com.bn.feifeikuaipao.view.FailGameView.initWorldSix;
import static com.bn.feifeikuaipao.view.FailGameView.initWorldThree;
import static com.bn.feifeikuaipao.view.FailGameView.initWorldTwo;
import static com.bn.feifeikuaipao.view.MainView.texIDbg_menu;
import static com.bn.feifeikuaipao.view.RunView.Score;
import static com.bn.feifeikuaipao.view.RunView.isFail;

public class MapView extends CurrentView {
    public GameSurfaceView viewManager;
    public static int texIDWord_choosepoint = TexManager.getTex("word_choosepoint.png");//选择关卡图片
    public static int texIDMenu_Button = TexManager.getTex("menu.png");//菜单图片
    public static int texIDWord_menu = TexManager.getTex("word_menu.png");//菜单文字图片
    public static int texIDWorld_One_Button = TexManager.getTex("number_1.png");//关卡1
    public static int texIDWorld_Two_Button = TexManager.getTex("number_2.png");//关卡2
    public static int texIDWorld_Three_Button =TexManager.getTex("number_3.png");//关卡3
    public static int texIDWorld_Four_Button = TexManager.getTex("number_4.png");//关卡4
    public static int texIDWorld_Five_Button = TexManager.getTex("number_5.png");//关卡5
    public static int texIDWorld_Six_Button = TexManager.getTex("number_6.png");//关卡6
    public static int texIDWorld_Seven_Button = TexManager.getTex("number_7.png");//关卡7
    public static int texIDWorld_Eight_Button = TexManager.getTex("number_8.png");//关卡8
    public static int texIDWorld_Lock_Two_Button = TexManager.getTex("number_lock_2.png");//锁住的关卡2
    public static int texIDWorld_Lock_Three_Button = TexManager.getTex("number_lock_3.png");//锁住的关卡3
    public static int texIDWorld_Lock_Four_Button = TexManager.getTex("number_lock_4.png");//锁住的关卡4
    public static int texIDWorld_Lock_Five_Button = TexManager.getTex("number_lock_5.png");//锁住的关卡5
    public static int texIDWorld_Lock_Six_Button = TexManager.getTex("number_lock_6.png");//锁住的关卡6
    public static int texIDWorld_Lock_Seven_Button = TexManager.getTex("number_lock_7.png");//锁住的关卡7
    public static int texIDWorld_Lock_Eight_Button = TexManager.getTex("number_lock_8.png");//锁住的关卡8
    public static int texIDCrown = TexManager.getTex("crown.png");//皇冠

    public static boolean World_Two = false;//关卡是否解锁
    public static boolean World_Three = false;
    public static boolean World_Four = false;
    public static boolean World_Five = false;
    public static boolean World_Six = false;
    public static boolean World_Seven = false;
    public static boolean World_Eight = false;

    public static boolean ClickWorld_One = false;
    public static boolean ClickWorld_Two = false;//点击的是哪个关卡
    public static boolean ClickWorld_Three = false;
    public static boolean ClickWorld_Four = false;
    public static boolean ClickWorld_Five = false;
    public static boolean ClickWorld_Six = false;
    public static boolean ClickWorld_Seven = false;
    public static boolean ClickWorld_Eight = false;


    public MapView(GameSurfaceView viewManager)
    {
        this.viewManager = viewManager;
    }
    @Override
    public void initView()
    {
        AnimalLocationY=0;//游戏中的内容重新进行初始化
        AnimalLocationX=0;
        AR_aniX=0;
        AR_aniY=0;
        bChangeArrowColorFlag=false;
        rotateDirection=0;
        AnimalV=8.0f;//恢复默认速度
        flag=true;//动物行走标志位设置为真
        isFail=false;//修改失败标志位
        isColFlag=false;//修改碰撞检测
        over_flag=true;//打叉标志位设置
        timer_body_flag=true;
        time_foot_flag=true;
        tempCurrentAngle=0;
        arrowFirst=0;//避免刷帧线程重复调用造成二次绘制使得吃掉的东西又复原了
        beanCount=0;//避免刷帧线程重复调用造成二次绘制之前吃掉的东西又复原了
        arrowColorCount=0;
        Score = 0;//重置得分数
        moveFlag=false;//避免二次点击地图开始关卡的时候动物处于转弯状态
    }
    @Override
    public boolean onTouchEvent(MotionEvent e)
    {
        //屏幕自适应，将所在机型的x y坐标转换为默认坐标 xy[0]=e.getX(),xy[1]=e.getY();
        int[] xy= ScreenScaleUtil.touchFromTargetToOrigin(e.getX(),e.getY(),ssr);
        float x=xy[0];
        float y=xy[1];
        switch (e.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                //点击菜单按钮
                if (x>470&&x<610&&y>1670&&y<1800)
                {
                    viewManager.currentView = viewManager.mainView;//切换到主界面
                    if (sound)
                    {
                        MainActivity.soundManager.playMusic(Sound_click,0);//点击声音
                    }
                }
                if (x>160&&x<300&&y>550&&y<690)//点击第一世界按钮
                {
                    initClickOne();
                    viewManager.mapView.initView();
                    initAllMapData();
                    initWorldOne();
                    initRunViewAndMusic();//设置音乐和切换到runview并启动相关线程
                }
                if (x>470&&x<600&&y>550&&y<690)//点击第二世界
                {
                    if (World_Two)
                    {
                        initClickTwo();
                        //初始化当前选关内容
                        viewManager.mapView.initView();
                        MapConstant.initAllMapData();
                        initWorldTwo();
                        initRunViewAndMusic();//设置音乐和切换到runview并启动相关线程
                    }
                    else
                    {
                        Toast.makeText(this.viewManager.getContext(),"未解锁第二世界",Toast.LENGTH_SHORT).show();
                    }
                }
                if (x>770&&x<900&&y>550&&y<690)//点击第三世界
                {
                    if (World_Three)
                    {
                        initClickThree();
                        viewManager.mapView.initView();
                        MapConstant.initAllMapData();//重置地图
                        initWorldThree();
                        initRunViewAndMusic();//设置音乐和切换到runview并启动相关线程
                    }
                    else
                    {
                        Toast.makeText(this.viewManager.getContext(),"未解锁第三世界",Toast.LENGTH_SHORT).show();
                    }
                }
                if (x>160&&x<300&&y>910&&y<1040)//点击第四世界
                {
                    if (World_Four)//假如前三关都通关
                    {
                        initClickFour();
                        viewManager.mapView.initView();
                        MapConstant.initAllMapData();
                        initWorldFour();
                        initRunViewAndMusic();//设置音乐和切换到runview并启动相关线程
                    }
                    else
                    {
                        Toast.makeText(this.viewManager.getContext(),"未解锁第四世界",Toast.LENGTH_SHORT).show();
                    }
                }
                if (x>470&&x<600&&y>910&&y<1040)//点击第五世界
                {
                    if (World_Five)//假如前四关都通关,第五关世界解锁
                    {

                        initClickFive();
                        viewManager.mapView.initView();
                        initAllMapData();
                        initWorldFive();
                        initRunViewAndMusic();//设置音乐和切换到runview并启动相关线程
                    }
                    else
                    {
                        Toast.makeText(this.viewManager.getContext(),"未解锁第五世界",Toast.LENGTH_SHORT).show();
                    }
                }
                if (x>770&&x<900&&y>910&&y<1040)//点击第六世界
                {
                    if (World_Six)
                    {
                        initClickSix();
                        viewManager.mapView.initView();
                        initAllMapData();
                        initWorldSix();
                        initRunViewAndMusic();//设置音乐和切换到runview并启动相关线程
                    }
                    else
                    {
                        Toast.makeText(this.viewManager.getContext(),"未解锁第六世界",Toast.LENGTH_SHORT).show();
                    }
                }
                if (x>160&&x<300&&y>1270&&y<1400)//点击第七世界
                {
                    if (World_Seven)
                    {
                        initClickSeven();
                        viewManager.mapView.initView();
                        initAllMapData();
                        initWorldSeven();
                        initRunViewAndMusic();//设置音乐和切换到runview并启动相关线程
                    }
                    else
                    {
                        Toast.makeText(this.viewManager.getContext(),"未解锁第七世界",Toast.LENGTH_SHORT).show();
                    }
                }
                if (x>470&&x<600&&y>1270&&y<1400)//点击第八世界
                {
                    if (World_Eight)
                    {
                        initClickEight();
                        viewManager.mapView.initView();
                        initAllMapData();
                        initWorldEight();
                        initRunViewAndMusic();//设置音乐和切换到runview并启动相关线程
                    }
                    else
                    {
                        Toast.makeText(this.viewManager.getContext(),"未解锁第八世界",Toast.LENGTH_SHORT).show();
                    }
                }
        }
        return false;
    }

    //更新地图数据
    public void upmapdata()
    {
        //获取SharedPreferences
        SharedPreferences sp=viewManager.getContext().getSharedPreferences("mp", Context.MODE_PRIVATE);
        //从SharedPreferences中读取上次访问的时间
        String mapdata =sp.getString
                (
                        "mapdata",   //键值
                        "1"    //默认值
                );
        //筛选关卡
        switch (Integer.valueOf(mapdata))
        {
            case 1 :
                break;
            case 2 :
                World_Two = true;
                break;
            case 3 :
                World_Two = true;
                World_Three = true;
                break;
            case 4 :
                World_Two = true;
                World_Three = true;
                World_Four = true;
                break;
            case 5 :
                World_Two = true;
                World_Three = true;
                World_Four = true;
                World_Five = true;
                break;
            case 6 :
                World_Two = true;
                World_Three = true;
                World_Four = true;
                World_Five = true;
                World_Six = true;
                break;
            case 7 :
                World_Two = true;
                World_Three = true;
                World_Four = true;
                World_Five = true;
                World_Six = true;
                World_Seven = true;
                break;
            case 8 :
                World_Two = true;
                World_Three = true;
                World_Four = true;
                World_Five = true;
                World_Six = true;
                World_Seven = true;
                World_Eight = true;
                break;

        }
    }
    @Override
    public void drawView(GL10 gl) {
        upmapdata();
        MatrixState.setCamera(1f,-1.8f,5f,1f,-1.8f,0f,0f,1f,0.0f);
        GLES30.glClearColor(0.161f,0.714f,0.97f,1.0f);
        //绘制蓝色底边
        viewManager.texDrawer.drawSelf(texIDbg_menu,bg_menu_LocationX,bg_menu_LocationY,bg_menuX,bg_menuY,0,2);
        //绘制选择关卡
        viewManager.texDrawer.drawSelf(texIDWord_choosepoint,word_chooseworld_LocationX,word_chooseworld_LocationY,word_chooseworldX,word_chooseworldY,0,2);
        //绘制菜单按钮
        viewManager.texDrawer.drawSelf(texIDMenu_Button,MapView_Menu_Button_LocationX,MapView_Menu_Button_LocationY,Mapview_Menu_ButtonX,Mapview_Menu_ButtonY,0,2);
        //绘制菜单文字图片
        viewManager.texDrawer.drawSelf(texIDWord_menu,1500,3370,word_menuX,word_menuY,0,2);

        //绘制八个关卡
        //第一关卡
        viewManager.texDrawer.drawSelf(texIDWorld_One_Button,1250,2430,70,65,0,2);
        viewManager.texDrawer.drawSelf(texIDCrown,1250,2320,40,30,0,2);
        //第二关卡
        if (World_Two)
        {
            viewManager.texDrawer.drawSelf(texIDWorld_Two_Button,1500,2430,70,65,0,2);
            viewManager.texDrawer.drawSelf(texIDCrown,1500,2320,40,30,0,2);
        }
        else {
            viewManager.texDrawer.drawSelf(texIDWorld_Lock_Two_Button,1500,2430,70,65,0,2);
        }
        //第三关卡
        if (World_Three)
        {
            viewManager.texDrawer.drawSelf(texIDWorld_Three_Button,1750,2430,70,65,0,2);
            viewManager.texDrawer.drawSelf(texIDCrown,1750,2320,40,30,0,2);
        }
        else {
            viewManager.texDrawer.drawSelf(texIDWorld_Lock_Three_Button,1750,2430,70,65,0,2);
        }
        //第四关卡
        if (World_Four)
        {
            viewManager.texDrawer.drawSelf(texIDWorld_Four_Button,1250,2700,70,65,0,2);
            viewManager.texDrawer.drawSelf(texIDCrown,1250,2590,40,30,0,2);
        }else {
            viewManager.texDrawer.drawSelf(texIDWorld_Lock_Four_Button,1250,2700,70,65,0,2);
        }
        //第五关卡
        if (World_Five)
        {
            viewManager.texDrawer.drawSelf(texIDWorld_Five_Button,1500,2700,70,65,0,2);
            viewManager.texDrawer.drawSelf(texIDCrown,1500,2590,40,30,0,2);
        }
        else {
            viewManager.texDrawer.drawSelf(texIDWorld_Lock_Five_Button,1500,2700,70,65,0,2);
        }
        //第六关卡
        if (World_Six)
        {
            viewManager.texDrawer.drawSelf(texIDWorld_Six_Button,1750,2700,70,65,0,2);
            viewManager.texDrawer.drawSelf(texIDCrown,1750,2590,40,30,0,2);
        }
        else{
            viewManager.texDrawer.drawSelf(texIDWorld_Lock_Six_Button,1750,2700,70,65,0,2);
        }
        //第七关卡
        if (World_Seven)
        {
            viewManager.texDrawer.drawSelf(texIDWorld_Seven_Button,1250,2970,70,65,0,2);
            viewManager.texDrawer.drawSelf(texIDCrown,1250,2860,40,30,0,2);
        }
        else {
            viewManager.texDrawer.drawSelf(texIDWorld_Lock_Seven_Button,1250,2970,70,65,0,2);
        }
        //第八关卡
        if (World_Eight)
        {
            viewManager.texDrawer.drawSelf(texIDWorld_Eight_Button,1500,2970,70,65,0,20);
            viewManager.texDrawer.drawSelf(texIDCrown,1500,2860,40,30,0,2);
        }
        else {
            viewManager.texDrawer.drawSelf(texIDWorld_Lock_Eight_Button,1500,2970,70,65,0,2);
        }
    }
    public void initRunViewAndMusic()
    {
        if (sound)
        {
            MainActivity.soundManager.playMusic(Sound_click,0);//点击声音
        }
        MapConstant.initAllMapData();
        viewManager.currentView = viewManager.runView;
        viewManager.runView.initView();//启动行走
    }
}
