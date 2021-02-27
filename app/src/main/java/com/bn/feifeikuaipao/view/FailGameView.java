package com.bn.feifeikuaipao.view;
import android.opengl.GLES30;
import android.view.MotionEvent;

import com.bn.screen.auto.ScreenScaleUtil;
import com.bn.feifeikuaipao.MainActivity;
import com.bn.feifeikuaipao.MatrixState.MatrixState;
import com.bn.feifeikuaipao.GameSurfaceView;
import com.bn.feifeikuaipao.TexManager.TexManager;
import com.bn.feifeikuaipao.constant.MapConstant;

import javax.microedition.khronos.opengles.GL10;

import static com.bn.feifeikuaipao.Thread.AnimalRunThread.AR_aniX;
import static com.bn.feifeikuaipao.Thread.AnimalRunThread.AR_aniY;
import static com.bn.feifeikuaipao.Thread.AnimalRunThread.FlyTime;
import static com.bn.feifeikuaipao.Thread.AnimalRunThread.flag;
import static com.bn.feifeikuaipao.Thread.AnimalRunThread.isColFlag;
import static com.bn.feifeikuaipao.Thread.AnimalRunThread.over_flag;
import static com.bn.feifeikuaipao.Thread.AnimalRunThread.tempCurrentAngle;
import static com.bn.feifeikuaipao.Thread.TimeBodyThread.timer_body_flag;
import static com.bn.feifeikuaipao.Thread.TimesFootThread.time_foot_flag;
import static com.bn.feifeikuaipao.constant.Constant.cx;
import static com.bn.feifeikuaipao.constant.Constant.cy;
import static com.bn.feifeikuaipao.constant.Constant.ssr;
import static com.bn.feifeikuaipao.constant.MapConstant.HGrayArrow;
import static com.bn.feifeikuaipao.constant.MapConstant.beanCount;
import static com.bn.feifeikuaipao.constant.MapConstant.grayarrow_left;
import static com.bn.feifeikuaipao.constant.MapConstant.green_arrow_left;
import static com.bn.feifeikuaipao.constant.MapConstant.green_arrow_right;
import static com.bn.feifeikuaipao.constant.MapConstant.green_arrow_up_jump;
import static com.bn.feifeikuaipao.constant.MapConstant.mapIndex;
import static com.bn.feifeikuaipao.constant.SourceConstant.AnimalLocationX;
import static com.bn.feifeikuaipao.constant.SourceConstant.AnimalLocationY;
import static com.bn.feifeikuaipao.constant.SourceConstant.AnimalStartX;
import static com.bn.feifeikuaipao.constant.SourceConstant.AnimalStartY;
import static com.bn.feifeikuaipao.constant.SourceConstant.AnimalV;
import static com.bn.feifeikuaipao.constant.SourceConstant.FailGameView_AgainGame_Button_X;
import static com.bn.feifeikuaipao.constant.SourceConstant.FailGameView_AgainGame_Button_Y;
import static com.bn.feifeikuaipao.constant.SourceConstant.FailGameView_Map_Button_X;
import static com.bn.feifeikuaipao.constant.SourceConstant.FailGameView_Map_Button_Y;
import static com.bn.feifeikuaipao.constant.SourceConstant.Sound_click;
import static com.bn.feifeikuaipao.constant.SourceConstant.arrowColorCount;
import static com.bn.feifeikuaipao.constant.SourceConstant.arrowFirst;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalEightFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalFiveFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalFourFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalOneFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalSevenFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalSixFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalThreeFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalTwoFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.rotateDirection;
import static com.bn.feifeikuaipao.constant.SourceConstant.sound;
import static com.bn.feifeikuaipao.constant.SourceConstant.word_failGame_X;
import static com.bn.feifeikuaipao.constant.SourceConstant.word_failGame_Y;
import static com.bn.feifeikuaipao.view.MapView.ClickWorld_Eight;
import static com.bn.feifeikuaipao.view.MapView.ClickWorld_Five;
import static com.bn.feifeikuaipao.view.MapView.ClickWorld_Four;
import static com.bn.feifeikuaipao.view.MapView.ClickWorld_One;
import static com.bn.feifeikuaipao.view.MapView.ClickWorld_Seven;
import static com.bn.feifeikuaipao.view.MapView.ClickWorld_Six;
import static com.bn.feifeikuaipao.view.MapView.ClickWorld_Three;
import static com.bn.feifeikuaipao.view.MapView.ClickWorld_Two;
import static com.bn.feifeikuaipao.view.MapView.World_Eight;
import static com.bn.feifeikuaipao.view.MapView.World_Five;
import static com.bn.feifeikuaipao.view.MapView.World_Four;
import static com.bn.feifeikuaipao.view.MapView.World_Seven;
import static com.bn.feifeikuaipao.view.MapView.World_Six;
import static com.bn.feifeikuaipao.view.MapView.World_Three;
import static com.bn.feifeikuaipao.view.MapView.World_Two;
import static com.bn.feifeikuaipao.view.RunView.Score;
import static com.bn.feifeikuaipao.view.RunView.isFail;
public class FailGameView extends CurrentView
{
    public static int texIDAgainGame_button= TexManager.getTex("again.png");
    public static int texIDMap_button=TexManager.getTex("map.png");
    public static int texIDLoseGame_word=TexManager.getTex("word_fail.png");
    public static int texIDWord_map = TexManager.getTex("word_map.png");
    public static int texIDFailgameView = TexManager.getTex("fail_bg.png");//透明背景图
    //道具图
    public static int texIDClock = TexManager.getTex("clock.png");//秒表图片
    public static int texIDClock_lock = TexManager.getTex("clock_lock.png");//为解锁的秒表
    public static int texIDMagnet = TexManager.getTex("magnet.png");//磁石图片
    public static int texIDMagnet_lock = TexManager.getTex("magnet_lock.png");//为解锁的磁石图片
    public static int texIDSecurity = TexManager.getTex("security.png");//盾牌图片
    public static int texIDSecuity_lock = TexManager.getTex("security_lock.png");//为解锁的盾牌图片
    public GameSurfaceView viewManager;
    public FailGameView(GameSurfaceView viewManager)
    {
        this.viewManager=viewManager;
    }

    public static boolean clockLogo_flag = false;//秒表初始为未解锁
    public static boolean magnetLogo_flag = false;//磁石初始为未解锁
    public static boolean securityLogo_flag = false;//盾牌初始为未解锁
    public static boolean clockUse_flag = false;//初始秒表道具状态为未被使用
    public static boolean magnetUse_flag = false;//初始磁石道具状态为未被使用
    public static boolean securityUse_flag = false;//初始盾牌状态为未被使用
    @Override
    public  void initView()//游戏内容初始化
    {
        AnimalLocationY=0;//游戏中的内容重新进行初始化
        AnimalLocationX=0;
        AR_aniX=0;
        AR_aniY=0;
        rotateDirection=0;
        AnimalV=8.0f;//恢复默认速度
        flag=true;//动物行走标志位设置为真
        isFail=false;//修改失败标志位
        isColFlag=false;//修改碰撞检测
        over_flag=true;//打叉标志位设置
        timer_body_flag=true;//启动换身体线程
        time_foot_flag=true;//启动换腿线程
        tempCurrentAngle=0;
        arrowFirst=0;//避免刷帧线程重复调用造成二次绘制使得吃掉的东西又复原了
        beanCount=0;//避免刷帧线程重复调用造成二次绘制之前吃掉的东西又复原了
        Score = 0;
        //-----------------动物到达下一关的时候，再次加载加载的是下一关的内容-----------------
        if(finalOneFlag)
        {
            World_Two=true;
            initClickTwo();
            AnimalV=7.5f;

        }else if(finalTwoFlag)
        {
            World_Three=true;
            initClickThree();
            AnimalV=7.5f;

        }
        else if(finalThreeFlag)
        {
            World_Four=true;
            initClickFour();
            AnimalV=8.0f;
        }
        else if(finalFourFlag)
        {
            World_Five=true;
            initClickFive();
            AnimalV=8.5f;
        }
        else if(finalFiveFlag)
        {
            World_Six=true;
            initClickSix();
            AnimalV=9.0f;
        }
        else if(finalSixFlag)
        {
            World_Seven=true;
            initClickSeven();
            AnimalV=9.5f;
        }
        else if(finalSevenFlag||finalEightFlag)
        {
            World_Eight=true;
            initClickEight();
            AnimalV=10.0f;
        }
        MapConstant.initAllMapData();
        initAllMap();
        viewManager.currentView=viewManager.runView;
        viewManager.runView.initView();
    }
    @Override
    public boolean onTouchEvent(MotionEvent e)
    {
        int xy[] =ScreenScaleUtil.touchFromTargetToOrigin(e.getX(),e.getY(),ssr);
        float x=xy[0];
        float y=xy[1];
        switch (e.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                if(x>380&&x<700&&y>650&&y<1030)
                {
                    viewManager.failGameView.initView();//游戏内容初始化
                    if(sound)
                    {
                        MainActivity.soundManager.playMusic(Sound_click,0);//点击声音
                    }
                }
                if(x>470&&x<600&&y>1310&&y<1440)
                {
                    viewManager.currentView=viewManager.mapView;
                    if(sound)
                    {
                        MainActivity.soundManager.playMusic(Sound_click,0);//点击声音
                    }
                }
                if (x>220&&x<350&&y>1600&&y<1730&&magnetLogo_flag)//如果解锁，使用磁石功能
                {
                    magnetUse_flag = true;//使用磁石
                    magnetLogo_flag = false;//使用过后失效
                    if(sound)
                    {
                        MainActivity.soundManager.playMusic(Sound_click,0);//点击声音
                    }
                }
                if (x>480&&x<1830&&y>1600&&y<1730&&clockLogo_flag)//如果解锁，使用秒表功能
                {
                    clockUse_flag = true;//使用秒表
                    clockLogo_flag = false;//使用过后失效
                    if(sound)
                    {
                        MainActivity.soundManager.playMusic(Sound_click,0);//点击声音
                    }
                }
                if (x>720&&x<860&&y>1600&&y<1730&&securityLogo_flag)//如果解锁，使用盾牌功能
                {
                    securityUse_flag= true;//使用盾牌
                    securityLogo_flag = false;//使用过后失效
                    if(sound)
                    {
                        MainActivity.soundManager.playMusic(Sound_click,0);//点击声音
                    }
                }
                break;

        }
        return false;
    }
    @Override
    public  void drawView(GL10 gl)
    {
        MatrixState.setCamera(1f,-1.8f,5f,1f,-1.8f,0f,0f,1f,0.0f);
        MatrixState.pushMatrix();
        //绘制透明背景图
        viewManager.texDrawer.drawSelf(texIDFailgameView,1500,2500,500,1000,0,2);
        viewManager.texDrawer.drawSelf(texIDLoseGame_word,1500,2300,word_failGame_X,word_failGame_Y,0,2);
        viewManager.texDrawer.drawSelf(texIDAgainGame_button,1500,2600,FailGameView_AgainGame_Button_X,FailGameView_AgainGame_Button_Y,0,2);
        viewManager.texDrawer.drawSelf(texIDMap_button,1500,3000,FailGameView_Map_Button_X,FailGameView_Map_Button_Y,0,2);
        viewManager.texDrawer.drawSelf(texIDWord_map,1500,3100,64,30,0,2);
        if (clockLogo_flag)
        {
            viewManager.texDrawer.drawSelf(texIDClock,1500,3220,64,60,0,2);//解锁的秒表
        }
        else
        {
            viewManager.texDrawer.drawSelf(texIDClock_lock,1500,3220,64,60,0,2);//未解锁的秒表
        }
        if (magnetLogo_flag)
        {
            viewManager.texDrawer.drawSelf(texIDMagnet,1300,3220,64,60,0,2);//解锁的磁石
        }
        else
        {
            viewManager.texDrawer.drawSelf(texIDMagnet_lock,1300,3220,64,60,0,2);//未解锁的磁石
        }
        if (securityLogo_flag)
        {
            viewManager.texDrawer.drawSelf(texIDSecurity,1700,3220,64,60,0,2);//未解锁的盾牌
        }
        else
        {
            viewManager.texDrawer.drawSelf(texIDSecuity_lock,1700,3220,64,60,0,2);//未解锁的秒表
        }
        MatrixState.popMatrix();
    }
    //对动物和箭头的设定进行改写
    public static void initAllMap()
    {
        if (ClickWorld_One&&!ClickWorld_Two&&!ClickWorld_Three&&!ClickWorld_Four&&!ClickWorld_Five&&!ClickWorld_Six&&!ClickWorld_Seven&&!ClickWorld_Eight)
        {
            initWorldOne();
        }
        if (!ClickWorld_One&&ClickWorld_Two&&!ClickWorld_Three&&!ClickWorld_Four&&!ClickWorld_Five&&!ClickWorld_Six&&!ClickWorld_Seven&&!ClickWorld_Eight)
        {
            initWorldTwo();
        }
        //-----第三关----
        if (!ClickWorld_One&&!ClickWorld_Two&&ClickWorld_Three&&!ClickWorld_Four&&!ClickWorld_Five&&!ClickWorld_Six&&!ClickWorld_Seven&&!ClickWorld_Eight)
        {
            initWorldThree();
        }
        //-----第四关----
        if (!ClickWorld_One&&!ClickWorld_Two&&!ClickWorld_Three&&ClickWorld_Four&&!ClickWorld_Five&&!ClickWorld_Six&&!ClickWorld_Seven&&!ClickWorld_Eight)
        {
            initWorldFour();
        }
        //-----第五关-----
        if (!ClickWorld_One&&!ClickWorld_Two&&!ClickWorld_Three&&!ClickWorld_Four&&ClickWorld_Five&&!ClickWorld_Six&&!ClickWorld_Seven&&!ClickWorld_Eight)
        {
            initWorldFive();
        }
        //----------第六关------------------
        if (!ClickWorld_One&&!ClickWorld_Two&&!ClickWorld_Three&&!ClickWorld_Four&&!ClickWorld_Five&&ClickWorld_Six&&!ClickWorld_Seven&&!ClickWorld_Eight)
        {
            initWorldSix();
        }
        if (!ClickWorld_One&&!ClickWorld_Two&&!ClickWorld_Three&&!ClickWorld_Four&&!ClickWorld_Five&&!ClickWorld_Six&&ClickWorld_Seven&&!ClickWorld_Eight)
        {
           initWorldSeven();
        }
        if (!ClickWorld_One&&!ClickWorld_Two&&!ClickWorld_Three&&!ClickWorld_Four&&!ClickWorld_Five&&!ClickWorld_Six&&!ClickWorld_Seven&&ClickWorld_Eight)
        {
            initWorldEight();
        }
    }
    public static void popclock()
    {
        if (clockUse_flag)
        {
            AnimalV = 6.5f;//给定初始速度
            FlyTime = 10;//飞行时间
        }
    }
    public static void initCleanColor()
    {
        finalOneFlag=false;
        finalTwoFlag=false;
        finalThreeFlag=false;
        finalFourFlag=false;
        finalFiveFlag=false;
        finalSixFlag=false;
        finalSevenFlag=false;
        finalEightFlag=false;
        if (ClickWorld_One)
        {
            GLES30.glClearColor(0.161f,0.714f,0.97f, 1.0f);
        }
        else if(World_Two&&ClickWorld_Two)
        {
            GLES30.glClearColor(0.08f,0.70f,0.70f,1.0f);
        }
        else if(World_Three&&ClickWorld_Three)
        {
            GLES30.glClearColor(0.142f,0.705f,0.066f,1.0f);
        }
        else if(World_Four&&ClickWorld_Four)
        {
            GLES30.glClearColor(0.80f,0.06f,0.76f,1.0f);
        }
        else if(World_Five&&ClickWorld_Five)
        {
            GLES30.glClearColor(1.0f,0.58f,0.5f,1.0f);
        }
        else if(World_Six&&ClickWorld_Six)
        {
            GLES30.glClearColor(0.785f,0.785f,0.663f,1.0f);
        }
        else if (World_Seven&&ClickWorld_Seven)
        {
            GLES30.glClearColor(0.525f,0.239f,0.705f,1.0f);
        }
        else if(World_Eight&&ClickWorld_Eight)
        {
            GLES30.glClearColor(1.0f,0.0f,0.0f,1.0f);
        }
    }
    public static void initWorldOne()
    {
        initCleanColor();
        AnimalStartX=1500.0f;
        AnimalStartY=12170.0f;
        cx=1.0f;
        cy=11.4f;
        AnimalV = 7.0f;//给定初始速度
        FlyTime = 9;//飞行时间
        mapIndex = 1;//重置当前关卡数
        //设置绿色箭头的起始位置变化
        arrowColorCount=0;
        //恢复第二关卡箭头的变化
        HGrayArrow.put(6,grayarrow_left);
    }
    public static void initWorldTwo()
    {
        //摄像机和动物位置的重新设置
        AnimalStartX=960.0f;
        AnimalStartY=12170.0f;
        cx=0.4f;
        cy=11.4f;
        AnimalV = 7.5f;//给定初始速度
        FlyTime = 9;//飞行时间
        mapIndex = 2;//重置当前关卡数
        //设置绿色箭头的起始位置变化
        arrowColorCount=6;
        initCleanColor();
        //重新设定第二关的箭头设定
        HGrayArrow.put(arrowColorCount,green_arrow_left);
        popclock();//秒表道具
    }
    public static void initWorldThree()
    {
        //摄像机和动物位置的重新设置
        AnimalStartX=420.0f;
        AnimalStartY=12170.0f;
        cx=-0.1f;
        cy=11.4f;
        AnimalV = 6.5f;//给定初始速度
        FlyTime = 10;//飞行时间
        mapIndex = 3;//重置当前关卡数
        //设置绿色箭头的起始位置变化
        arrowColorCount=15;
        initCleanColor();
        //重新设定第二关的箭头设定
        HGrayArrow.put(arrowColorCount,green_arrow_right);
        popclock();//秒表道具
    }
    public static void initWorldFour()
    {
        //摄像机和动物位置的重新设置
        AnimalStartX=1680.0f;
        AnimalStartY=12170.0f;
        cx=1.2f;
        cy=11.4f;
        AnimalV = 8.0f;//给定初始速度
        FlyTime = 9;
        mapIndex = 4;//重置当前关卡数
        //设置绿色箭头的起始位置变化
        arrowColorCount=27;
        initCleanColor();
        //重新设定第二关的箭头设定
        HGrayArrow.put(arrowColorCount,green_arrow_left);
        popclock();//秒表道具
    }
    public static void initWorldFive()
    {
        //摄像机和动物位置的重新设置
        AnimalStartX=1320.0f;
        AnimalStartY=12170.0f;
        cx=0.8f;
        cy=11.6f;
        AnimalV = 8.5f;//给定初始速度
        FlyTime = 8;//飞行时间
        mapIndex = 5;//重置当前关卡数
        //设置绿色箭头的起始位置变化
        arrowColorCount=38;
        initCleanColor();
        //重新设定第二关的箭头设定
        HGrayArrow.put(arrowColorCount,green_arrow_left);
        popclock();//秒表道具
    }
    public static void initWorldSix()
    {
        //摄像机和动物位置的重新设置
        AnimalStartX=1140.0f;
        AnimalStartY=12170.0f;
        cx=0.7f;
        cy=11.4f;
        mapIndex = 6;//重置当前关卡数
        AnimalV = 9.0f;//给定初始速度
        FlyTime = 8;//飞行时间
        //设置绿色箭头的起始位置变化
        arrowColorCount=48;
        initCleanColor();
        //重新设定第二关的箭头设定
        HGrayArrow.put(arrowColorCount,green_arrow_right);
        popclock();//秒表道具
    }
    public static void initWorldSeven()
    {
        //摄像机和动物位置的重新设置
        AnimalStartX=420.0f;
        AnimalStartY=12170.0f;
        cx=-0.1f;
        cy=11.4f;
        mapIndex = 7;//重置当前关卡数
        AnimalV = 9.5f;//给定初始速度
        FlyTime = 8;//飞行时间
        //设置绿色箭头的起始位置变化
        arrowColorCount=59;
        initCleanColor();
        //重新设定第二关的箭头设定
        HGrayArrow.put(arrowColorCount,green_arrow_up_jump);
        popclock();//秒表道具
    }
    public static void initWorldEight()
    {
        //摄像机和动物位置的重新设置
        AnimalStartX=420.0f;
        AnimalStartY=12170.0f;
        cx=-0.1f;
        cy=11.4f;
        mapIndex = 8;//重置当前关卡数
        AnimalV = 10.0f;//给定初始速度
        //设置绿色箭头的起始位置变化
        arrowColorCount=69;
        initCleanColor();
        //重新设定第二关的箭头设定
        HGrayArrow.put(arrowColorCount,green_arrow_right);
        popclock();//秒表道具
    }
    public static void initClickOne()
    {
        ClickWorld_One=true;
        ClickWorld_Two=false;
        ClickWorld_Three=false;
        ClickWorld_Four=false;
        ClickWorld_Five=false;
        ClickWorld_Six=false;
        ClickWorld_Seven=false;
        ClickWorld_Eight=false;
    }
    public static void initClickTwo()
    {
        ClickWorld_Two=true;
        ClickWorld_One=false;
        ClickWorld_Three=false;
        ClickWorld_Four=false;
        ClickWorld_Five=false;
        ClickWorld_Six=false;
        ClickWorld_Seven=false;
        ClickWorld_Eight=false;
    }
    public static void initClickThree()
    {
        ClickWorld_Three=true;
        ClickWorld_One=false;
        ClickWorld_Two=false;
        ClickWorld_Four=false;
        ClickWorld_Five=false;
        ClickWorld_Six=false;
        ClickWorld_Seven=false;
        ClickWorld_Eight=false;
    }
    public static void initClickFour()
    {
        ClickWorld_Four=true;
        ClickWorld_One=false;
        ClickWorld_Two=false;
        ClickWorld_Three=false;
        ClickWorld_Five=false;
        ClickWorld_Six=false;
        ClickWorld_Seven=false;
        ClickWorld_Eight=false;
    }
    public static void initClickFive()
    {
        ClickWorld_Five=true;
        ClickWorld_One=false;
        ClickWorld_Two=false;
        ClickWorld_Three=false;
        ClickWorld_Four=false;
        ClickWorld_Six=false;
        ClickWorld_Seven=false;
        ClickWorld_Eight=false;
    }
    public static void initClickSix()
    {
        ClickWorld_Six=true;
        ClickWorld_One=false;
        ClickWorld_Two=false;
        ClickWorld_Three=false;
        ClickWorld_Four=false;
        ClickWorld_Five=false;
        ClickWorld_Seven=false;
        ClickWorld_Eight=false;
    }
    public static void initClickSeven()
    {
        ClickWorld_Seven=true;
        ClickWorld_One=false;
        ClickWorld_Two=false;
        ClickWorld_Three=false;
        ClickWorld_Four=false;
        ClickWorld_Five=false;
        ClickWorld_Six=false;
        ClickWorld_Eight=false;
    }
    public static void initClickEight()
    {
        ClickWorld_Eight=true;
        ClickWorld_One=false;
        ClickWorld_Two=false;
        ClickWorld_Three=false;
        ClickWorld_Four=false;
        ClickWorld_Five=false;
        ClickWorld_Six=false;
        ClickWorld_Seven=false;
    }
}
