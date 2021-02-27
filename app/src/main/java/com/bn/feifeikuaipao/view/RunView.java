package com.bn.feifeikuaipao.view;
import android.opengl.GLES30;
import android.view.MotionEvent;
import com.bn.feifeikuaipao.MatrixState.MatrixState;
import com.bn.feifeikuaipao.GameSurfaceView;
import com.bn.feifeikuaipao.TexManager.TexManager;
import com.bn.feifeikuaipao.Thread.MagnetThread;
import com.bn.feifeikuaipao.Thread.SecurityThread;
import com.bn.feifeikuaipao.Thread.TimeBodyThread;
import com.bn.feifeikuaipao.Thread.TimesFootThread;
import com.bn.feifeikuaipao.constant.SourceConstant;
import com.bn.feifeikuaipao.Thread.AnimalRunThread;
import javax.microedition.khronos.opengles.GL10;
import static com.bn.feifeikuaipao.GameSurfaceView.MV_aniX;
import static com.bn.feifeikuaipao.GameSurfaceView.MV_aniY;
import static com.bn.feifeikuaipao.Thread.AnimalRunThread.bChangeArrowColorFlag;
import static com.bn.feifeikuaipao.Thread.AnimalRunThread.clockUnlock_flag;
import static com.bn.feifeikuaipao.Thread.AnimalRunThread.magnetUnlock_flag;
import static com.bn.feifeikuaipao.Thread.AnimalRunThread.over_flag;
import static com.bn.feifeikuaipao.Thread.AnimalRunThread.securityUnlock_flag;
import static com.bn.feifeikuaipao.constant.Constant.cx;
import static com.bn.feifeikuaipao.constant.Constant.cy;
import static com.bn.feifeikuaipao.constant.MapConstant.ARROWMAPTemp;
import static com.bn.feifeikuaipao.constant.MapConstant.BEANMAPTemp;
import static com.bn.feifeikuaipao.constant.MapConstant.MAPTemp;
import static com.bn.feifeikuaipao.constant.MapConstant.bean;
import static com.bn.feifeikuaipao.constant.MapConstant.finalrect;
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
import static com.bn.feifeikuaipao.constant.MapConstant.grayarrow_left;
import static com.bn.feifeikuaipao.constant.MapConstant.grayarrow_right;
import static com.bn.feifeikuaipao.constant.MapConstant.green_arrow_down;
import static com.bn.feifeikuaipao.constant.MapConstant.green_arrow_down_left;
import static com.bn.feifeikuaipao.constant.MapConstant.green_arrow_down_right;
import static com.bn.feifeikuaipao.constant.MapConstant.green_arrow_left;
import static com.bn.feifeikuaipao.constant.MapConstant.green_arrow_left_jump;
import static com.bn.feifeikuaipao.constant.MapConstant.green_arrow_right;
import static com.bn.feifeikuaipao.constant.MapConstant.green_arrow_right_jump;
import static com.bn.feifeikuaipao.constant.MapConstant.green_arrow_up_jump;
import static com.bn.feifeikuaipao.constant.MapConstant.green_arrow_up_left;
import static com.bn.feifeikuaipao.constant.MapConstant.green_arrow_up_right;
import static com.bn.feifeikuaipao.constant.MapConstant.initAllMapData;
import static com.bn.feifeikuaipao.constant.MapConstant.mapIndex;
import static com.bn.feifeikuaipao.constant.MapConstant.narrowrect;
import static com.bn.feifeikuaipao.constant.MapConstant.rect;
import static com.bn.feifeikuaipao.constant.MapConstant.rectDown;
import static com.bn.feifeikuaipao.constant.MapConstant.rectLeft;
import static com.bn.feifeikuaipao.constant.MapConstant.rectLeft_narrowrect;
import static com.bn.feifeikuaipao.constant.MapConstant.rectRight;
import static com.bn.feifeikuaipao.constant.MapConstant.rectRight_narrowrect;
import static com.bn.feifeikuaipao.constant.MapConstant.rectTop;
import static com.bn.feifeikuaipao.constant.MapConstant.rectbegin_1;
import static com.bn.feifeikuaipao.constant.MapConstant.rectbegin_2;
import static com.bn.feifeikuaipao.constant.MapConstant.rectbegin_3;
import static com.bn.feifeikuaipao.constant.MapConstant.rectbegin_4;
import static com.bn.feifeikuaipao.constant.MapConstant.rectbegin_5;
import static com.bn.feifeikuaipao.constant.MapConstant.rectbegin_6;
import static com.bn.feifeikuaipao.constant.MapConstant.rectbegin_7;
import static com.bn.feifeikuaipao.constant.MapConstant.rectbegin_8;
import static com.bn.feifeikuaipao.constant.MapConstant.semicircle_down;
import static com.bn.feifeikuaipao.constant.MapConstant.semicircle_downfromup;
import static com.bn.feifeikuaipao.constant.MapConstant.semicircle_left;
import static com.bn.feifeikuaipao.constant.MapConstant.semicircle_leftfromright;
import static com.bn.feifeikuaipao.constant.MapConstant.semicircle_right;
import static com.bn.feifeikuaipao.constant.MapConstant.semicircle_rightfromleft;
import static com.bn.feifeikuaipao.constant.MapConstant.semicircle_up;
import static com.bn.feifeikuaipao.constant.MapConstant.semicircle_upfromldown;
import static com.bn.feifeikuaipao.constant.SourceConstant.AnimalJumpFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.AnimalJumpHeightBig;
import static com.bn.feifeikuaipao.constant.SourceConstant.AnimalJumpWidthBig;
import static com.bn.feifeikuaipao.constant.SourceConstant.AnimalStartHeightBig;
import static com.bn.feifeikuaipao.constant.SourceConstant.AnimalStartHeightSmall;
import static com.bn.feifeikuaipao.constant.SourceConstant.AnimalStartWidthBig;
import static com.bn.feifeikuaipao.constant.SourceConstant.AnimalStartWidthSmall;
import static com.bn.feifeikuaipao.constant.SourceConstant.AnimalStartX;
import static com.bn.feifeikuaipao.constant.SourceConstant.AnimalStartY;
import static com.bn.feifeikuaipao.constant.SourceConstant.arrowColorCount;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalFiveFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalFourFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalOneFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalSevenFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalSixFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalThreeFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.finalTwoFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.magnetUseBigSizeX;
import static com.bn.feifeikuaipao.constant.SourceConstant.magnetUseBigSizeY;
import static com.bn.feifeikuaipao.constant.SourceConstant.magnetUseSmallSizeX;
import static com.bn.feifeikuaipao.constant.SourceConstant.magnetUseSmallSizeY;
import static com.bn.feifeikuaipao.constant.SourceConstant.moveFlag;
import static com.bn.feifeikuaipao.constant.SourceConstant.overX;
import static com.bn.feifeikuaipao.constant.SourceConstant.overY;
import static com.bn.feifeikuaipao.constant.SourceConstant.rotateDirection;
import static com.bn.feifeikuaipao.constant.SourceConstant.rotateTime;
import static com.bn.feifeikuaipao.constant.SourceConstant.securitySizeX;
import static com.bn.feifeikuaipao.constant.SourceConstant.securitySizeY;
import static com.bn.feifeikuaipao.view.FailGameView.magnetUse_flag;
import static com.bn.feifeikuaipao.view.FailGameView.securityUse_flag;
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

public class RunView extends CurrentView
{
    public GameSurfaceView viewManager;
    //地图
    public static int texIDFinal_rect=TexManager.getTex("final_rect.png");//终点
    public static int texIDRect=TexManager.getTex("rect.png");
    public static int texIDNarrowRect = TexManager.getTex("rect.png");//窄的矩形
    //起点图
    public static int texIDRectbegin_1 = TexManager.getTex("rect_1.png");//第一关起点图
    public static int texIDRectbegin_2 = TexManager.getTex("rect_2.png");//第二关起点图
    public static int texIDRectbegin_3 = TexManager.getTex("rect_3.png");//第三关起点图
    public static int texIDRectbegin_4 = TexManager.getTex("rect_4.png");//第四关起点图
    public static int texIDRectbegin_5 = TexManager.getTex("rect_5.png");//第五关起点图
    public static int texIDRectbegin_6 = TexManager.getTex("rect_6.png");//第六关起点图
    public static int texIDRectbegin_7 = TexManager.getTex("rect_7.png");//第七关起点图
    public static int texIDRectbegin_8 = TexManager.getTex("rect_8.png");//第八关起点图

    public static int texIDSemicircle_up=TexManager.getTex("semicircle_up.png");//半圆矩形
    public static int texIDSemicircle_down=TexManager.getTex("semicircle_down.png");
    public static int texIDSemicircle_right=TexManager.getTex("semicircle_right.png");
    public static int texIDSemicircle_left=TexManager.getTex("semicircle_left.png");
    //道具功能图
    public static int texIDBean= TexManager.getTex("bean.png");//豆豆
    public static int texIDGray_arrow_down=TexManager.getTex("gray_arrow_down.png");//向下灰色箭头
    public static int texIDGray_arrow_left=TexManager.getTex("gray_arrow_left.png");//向左灰色箭头
    public static int texIDGray_arrow_right=TexManager.getTex("gray_arrow_right.png");//向右灰色箭头
    public static int texIDGray_arrow_up=TexManager.getTex("gray_arrow_up.png");//向上灰色箭头
    public static int texIDGreen_arrow_down=TexManager.getTex("green_arrow_down.png");//向下绿色箭头
    public static int texIDGreen_arrow_left=TexManager.getTex("green_arrow_left.png");//向左绿色箭头
    public static int texIDGreen_arrow_right=TexManager.getTex("green_arrow_right.png");//向右绿色箭头
    public static int texIDGreen_arrow_up=TexManager.getTex("green_arrow_up.png");//向上绿色箭头
    //动物纹理
    public static int texIDSmallRedChicken = TexManager.getTex("smallbird.png");
    public static int texIDBigRedChicken = TexManager.getTex("bigbird.png");
    //动物挑起来的纹理
    public static int texIDFlyChicken=TexManager.getTex("fly_chicken.png");
    //碰撞的纹理
    public static int texIDOver = TexManager.getTex("over.png");
    //雪
    public static int texIDSnow_big = TexManager.getTex("big_snow.png");//大雪
    public static int texIDSnow_small = TexManager.getTex("small_snow.png");//小雪
    public static int texIDBg_Bomb= TexManager.getTex("bg_bomb.png");//炸弹
    //吸豆的磁铁
    public static int texIDMagnetUse=TexManager.getTex("halo.png");
    //保护罩
    public static int texIDProtectionCoverUse=TexManager.getTex("halocover.png");
    //道具解锁提醒文字
    public static int texIDWordmangetunlock = TexManager.getTex("word_mangetunlock.png");//磁石道具
    public static int texIDWordclockunlock = TexManager.getTex("word_clockunlock.png");//秒表道具
    public static int texIDWordsecurityunlock = TexManager.getTex("word_securityunlock.png");//盾牌道具
    //通关图片
    public static int texIDFinalWin = TexManager.getTex("finalwin.png");
    AnimalRunThread animalRunThread;
    TimeBodyThread timeBodyThread;
    TimesFootThread timesFootThread;
    public static int timer = 0;//身体切换计数器
    public static int timers = 0;//大腿切换计数器
    MagnetThread magnetThread;
    public static int magnetCount=0;
    SecurityThread securityThread;
    public static int securityCount=0;
    //切换图片的计数器
    public static boolean isFail = false;//判断游戏是否结束
    public static boolean isfinalwin = false;//通关标志位
    public static int Score;
    public RunView(GameSurfaceView viewManager)
    {
        this.viewManager=viewManager;
    }
    @Override
    public void initView()
    {
        animalRunThread=new AnimalRunThread(this);
        timeBodyThread=new TimeBodyThread();
        timesFootThread = new TimesFootThread();
        animalRunThread.start();
        timeBodyThread.start();
        timesFootThread.start();
        magnetThread=new MagnetThread();
        securityThread=new SecurityThread();
        if(magnetUse_flag)
        {
            magnetThread.start();
        }
        if(securityUse_flag)
        {
            securityThread.start();
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent e)
    {
        switch (e.getAction())
        {
            //当触点松开时被触发。
            case MotionEvent.ACTION_UP:
                moveFlag=false;
                rotateTime=0;
                arrowColorCount++;
                //System.out.println(arrowColorCount);
                bChangeArrowColorFlag=false;
                if (isfinalwin)
                {
                    viewManager.currentView = viewManager.mainView;
                    isfinalwin = false;
                }
                break;
            //当屏幕检测到第一个触点按下之后就会触发到这个事件
            case MotionEvent.ACTION_DOWN:
                rotateTime=1;
                bChangeArrowColorFlag=true;
                moveFlag=true;
                break;
        }
        return true;
    }
    @Override
    public void drawView(GL10 gl)
    {
        if (ClickWorld_One)
        {
            GLES30.glClearColor(0.161f,0.714f,0.97f, 1.0f);
        }
        else if(World_Two&&ClickWorld_Two)
        {
            GLES30.glClearColor(0.988f,0.616f,0.604f,1.0f);
        }
        else if(World_Three&&ClickWorld_Three)
        {
            GLES30.glClearColor(0.785f,0.785f,0.66f,1.0f);
        }
        else if(World_Four&&ClickWorld_Four)
        {
            GLES30.glClearColor(0.137f,0.92f,0.7255f,1.0f);
        }
        else if(World_Five&&ClickWorld_Five)
        {
            GLES30.glClearColor(0.15f,0.74f,0.84f,1.0f);
        }
        else if(World_Six&&ClickWorld_Six)
        {
            GLES30.glClearColor(0.149f,0.6157f,0.502f,1.0f);
        }
        else if (World_Seven&&ClickWorld_Seven)
        {
            GLES30.glClearColor(0.68f,0.867f,0.506f,1.0f);
        }
        else if(World_Eight&&ClickWorld_Eight)
        {
            GLES30.glClearColor(1.0f,0.588f,0.502f,1.0f);
        }


        if(finalOneFlag&&!ClickWorld_Two)
        {
            GLES30.glClearColor(0.988f,0.616f,0.604f,1.0f);
        }
        else if(finalTwoFlag&&!ClickWorld_Three)
        {
            GLES30.glClearColor(0.785f,0.785f,0.66f,1.0f);
        }
        else if(finalThreeFlag&&!ClickWorld_Four)
        {
            GLES30.glClearColor(0.137f,0.92f,0.7255f,1.0f);
        }
        else if(finalFourFlag&&!ClickWorld_Five)
        {
            GLES30.glClearColor(0.15f,0.74f,0.84f,1.0f);
        }
        else if(finalFiveFlag&&!ClickWorld_Six)
        {
            GLES30.glClearColor(0.149f,0.6157f,0.502f,1.0f);
        }
        else if(finalSixFlag&&!ClickWorld_Seven)
        {
            GLES30.glClearColor(0.68f,0.867f,0.506f,1.0f);
        }
        else if(finalSevenFlag&&!ClickWorld_Eight)
        {
            GLES30.glClearColor(1.0f,0.0f,0.0f,1.0f);
        }
        MatrixState.setCamera(1f,-1.8f,5f,1f,-1.8f,0f,0f,1f,0.0f);
        MatrixState.setCamera
                (
                        cx+(MV_aniX/1000),-cy-MV_aniY/1000 ,5f,
                        cx+(MV_aniX/1000),-cy-MV_aniY/1000, 0f,
                        0f,1f,0.0f
                );
        drawMap();
        drawAnimal();

        if (isFail)//失败标志位为真
        {
            viewManager.currentView=viewManager.failGameView;
        }
        MatrixState.setCamera(1f,-1.8f,5f,1f,-1.8f,0f,0f,1f,0.0f);
        if (isfinalwin)//通关
        {
            viewManager.texDrawer.drawSelf(texIDFinalWin,1500,2400,284,74,0,2);//通关提醒
        }
        drawRemindPop();//道具解锁提醒
        drawScoreboard();//绘制记分板
    }
    public void drawMap()
    {
        initAllMapData();
        MatrixState.pushMatrix();
        //绘制地图
        for (int y=0; y< MAPTemp.length;y++)
        {
            for (int x = 0; x < MAPTemp[y].length; x++)
            {
                switch (MAPTemp[y][x])
                {
                    case rectbegin_1:
                        viewManager.texDrawer.drawSelf(texIDRectbegin_1,x*180+60,y*180+60, SourceConstant.circleX,SourceConstant.circleY,0,2);
                        break;
                    case rectbegin_2:
                        viewManager.texDrawer.drawSelf(texIDRectbegin_2,x*180+60,y*180+60, SourceConstant.circleX,SourceConstant.circleY,0,2);
                        break;
                    case rectbegin_3:
                        viewManager.texDrawer.drawSelf(texIDRectbegin_3,x*180+60,y*180+60, SourceConstant.circleX,SourceConstant.circleY,0,2);
                        break;
                    case rectbegin_4:
                        viewManager.texDrawer.drawSelf(texIDRectbegin_4,x*180+60,y*180+60, SourceConstant.circleX,SourceConstant.circleY,0,2);
                        break;
                    case rectbegin_5:
                        viewManager.texDrawer.drawSelf(texIDRectbegin_5,x*180+60,y*180+60, SourceConstant.circleX,SourceConstant.circleY,0,2);
                        break;
                    case rectbegin_6:
                        viewManager.texDrawer.drawSelf(texIDRectbegin_6,x*180+60,y*180+60, SourceConstant.circleX,SourceConstant.circleY,0,2);
                        break;
                    case rectbegin_7:
                        viewManager.texDrawer.drawSelf(texIDRectbegin_7,x*180+60,y*180+60, SourceConstant.circleX,SourceConstant.circleY,0,2);
                        break;
                    case rectbegin_8:
                        viewManager.texDrawer.drawSelf(texIDRectbegin_8,x*180+60,y*180+60, SourceConstant.circleX,SourceConstant.circleY,0,2);
                        break;
                    case finalrect:
                    case finalrect_1:
                    case finalrect_2:
                    case finalrect_3:
                    case finalrect_4:
                    case finalrect_5:
                    case finalrect_6:
                    case finalrect_7:
                    case finalrect_8:
                        viewManager.texDrawer.drawSelf(texIDFinal_rect,x*180+60,y*180+60, SourceConstant.final_rect_X,SourceConstant.final_rect_Y,0,2);
                        break;
                    case rectRight_narrowrect:
                    case rectLeft_narrowrect:
                    case rectDown:
                    case rectTop:
                    case rectRight:
                    case rectLeft:
                    case rect:
                        viewManager.texDrawer.drawSelf(texIDRect,x*180+60,y*180+60, SourceConstant.rectX,SourceConstant.rectY,0,2);
                        break;
                    case narrowrect://窄的矩形
                        viewManager.texDrawer.drawSelf(texIDNarrowRect,x*180+60,y*180+60, SourceConstant.rectX/2,SourceConstant.rectY,0,2);
                        break;
                    case semicircle_up:
                    case semicircle_upfromldown:
                        viewManager.texDrawer.drawSelf(texIDSemicircle_up,x*180+60,y*180+60, SourceConstant.semicircle_upX,SourceConstant.semicircle_upY,0,2);
                        break;
                    case semicircle_downfromup:
                    case semicircle_down:
                        viewManager.texDrawer.drawSelf(texIDSemicircle_down,x*180+60,y*180+60, SourceConstant.semicircle_downX,SourceConstant.semicircle_downY,0,2);
                        break;
                    case semicircle_leftfromright:
                    case semicircle_left:
                        viewManager.texDrawer.drawSelf(texIDSemicircle_left,x*180+60,y*180+60, SourceConstant.semicircle_leftX,SourceConstant.semicircle_leftY,0,2);
                        break;
                    case semicircle_rightfromleft:
                    case semicircle_right:
                        viewManager.texDrawer.drawSelf(texIDSemicircle_right,x*180+60,y*180+60, SourceConstant.semicircle_rightX,SourceConstant.semicircle_rightY,0,2);
                        break;
                }
            }
        }
        MatrixState.popMatrix();
        //绘制道具图(豆豆，箭头)
        for(int y = 0;y < BEANMAPTemp.length;y++)
        {
            for(int x = 0;x < BEANMAPTemp[y].length;x++)
            {

                MatrixState.pushMatrix();
                switch (BEANMAPTemp[y][x])
                {
                    case bean:
                        viewManager.texDrawer.drawSelf(texIDBean,x*180+60,y*180+60,SourceConstant.beanX,SourceConstant.beanY,0,2);
                        break;
                }
                MatrixState.popMatrix();
            }
        }
        //绘制道具图(豆豆，箭头)
        for(int y = 0;y < ARROWMAPTemp.length;y++)
        {
            for (int x = 0; x < ARROWMAPTemp[y].length; x++)
            {
                MatrixState.pushMatrix();
                switch (ARROWMAPTemp[y][x])
                {
                    case gray_arrow_down_jump:
                    case gray_arrow_down_left:
                    case gray_arrow_down_right:
                        viewManager.texDrawer.drawSelf(texIDGray_arrow_down,x*180+60,y*180+60,SourceConstant.gray_arrow_X,SourceConstant.gray_arrow_Y,0,2);
                        break;
                    case grayarrow_left:
                    case gray_arrow_left_jump:
                        viewManager.texDrawer.drawSelf(texIDGray_arrow_left,x*180+60,y*180+60,SourceConstant.gray_arrow_X,SourceConstant.gray_arrow_Y,0,2);
                        break;
                    case grayarrow_right:
                    case gray_arrow_right_jump:
                        viewManager.texDrawer.drawSelf(texIDGray_arrow_right,x*180+60,y*180+60,SourceConstant.gray_arrow_X,SourceConstant.gray_arrow_Y,0,2);
                        break;
                    case gray_arrow_up_jump:
                    case gray_arrow_up_left:
                    case gray_arrow_up_right:
                        viewManager.texDrawer.drawSelf(texIDGray_arrow_up,x*180+60,y*180+60,SourceConstant.gray_arrow_X,SourceConstant.gray_arrow_Y,0,2);
                        break;

                    case green_arrow_down:
                    case green_arrow_down_left:
                    case green_arrow_down_right:
                        viewManager.texDrawer.drawSelf(texIDGreen_arrow_down,x*180+60,y*180+60, SourceConstant.green_arrow_X,SourceConstant.green_arrow_Y,0,2);
                        break;
                    case green_arrow_up_jump:
                    case green_arrow_up_left:
                    case green_arrow_up_right:
                        viewManager.texDrawer.drawSelf(texIDGreen_arrow_up,x*180+60,y*180+60, SourceConstant.green_arrow_X,SourceConstant.green_arrow_Y,0,2);
                        break;
                    case green_arrow_left:
                    case green_arrow_left_jump:
                        viewManager.texDrawer.drawSelf(texIDGreen_arrow_left,x*180+60,y*180+60, SourceConstant.green_arrow_X,SourceConstant.green_arrow_Y,0,2);
                        break;
                    case green_arrow_right:
                    case green_arrow_right_jump:
                        viewManager.texDrawer.drawSelf(texIDGreen_arrow_right,x*180+60,y*180+60, SourceConstant.green_arrow_X,SourceConstant.green_arrow_Y,0,2);
                        break;
                }
                MatrixState.popMatrix();
            }
        }
    }
    public void drawAnimal()
    {
        MatrixState.pushMatrix();
        //每一帧切换一次动物的图片，休眠0.5s
        if (over_flag)//判断是否需要
        {
            if (!AnimalJumpFlag)
            {
                if (timers%2==0) {
                    viewManager.texDrawer.drawSelf(TexManager.getTex("foot_font_left.png"),MV_aniX+AnimalStartX-35,MV_aniY+AnimalStartY-20,25,25,0,2);
                    viewManager.texDrawer.drawSelf(TexManager.getTex("foot_back_right.png"),MV_aniX+AnimalStartX+35,MV_aniY+AnimalStartY+30,20,20,0,2);
                }
                else {
                    viewManager.texDrawer.drawSelf(TexManager.getTex("foot_font_right.png"),MV_aniX+AnimalStartX+35,MV_aniY+AnimalStartY-20,25,25,0,2);
                    viewManager.texDrawer.drawSelf(TexManager.getTex("foot_back_left.png"),MV_aniX+AnimalStartX-35,MV_aniY+AnimalStartY+30,20,20,0,2);
                }
                if(timer%2==0) {
                    //小鸟图片
                    viewManager.texDrawer.drawSelf(texIDSmallRedChicken,MV_aniX+AnimalStartX,MV_aniY+AnimalStartY,AnimalStartWidthSmall,AnimalStartHeightSmall,rotateDirection,2);
                }else {
                    //大鸟图片
                    viewManager.texDrawer.drawSelf(texIDBigRedChicken,MV_aniX+AnimalStartX,MV_aniY+AnimalStartY,AnimalStartWidthBig,AnimalStartHeightBig,rotateDirection,2);
                }
            }
            else {
                viewManager.texDrawer.drawSelf(texIDFlyChicken,MV_aniX+AnimalStartX,MV_aniY+AnimalStartY,AnimalJumpWidthBig,AnimalJumpHeightBig,rotateDirection,2);//跳跃图片
            }
            //-----------------绘制磁铁和保护盾部分---------------------
            if (magnetUse_flag) {
                if(magnetCount%2==0) {
                    viewManager.texDrawer.drawSelf(texIDMagnetUse,MV_aniX+AnimalStartX,MV_aniY+AnimalStartY,magnetUseBigSizeX,magnetUseBigSizeY,0,2);
                }
                else {
                    viewManager.texDrawer.drawSelf(texIDMagnetUse,MV_aniX+AnimalStartX,MV_aniY+AnimalStartY,magnetUseSmallSizeX,magnetUseSmallSizeY,0,2);
                }
            }
            if(securityUse_flag)
            {
                if(securityCount%2==0) {
                    viewManager.texDrawer.drawSelf(texIDProtectionCoverUse,MV_aniX+AnimalStartX,MV_aniY+AnimalStartY,securitySizeX,securitySizeY,0,2);
                }
                else {
                    viewManager.texDrawer.drawSelf(texIDProtectionCoverUse,MV_aniX+AnimalStartX,MV_aniY+AnimalStartY,securitySizeX,securitySizeY,0,2);
                }
            }
        }
        else {
            viewManager.texDrawer.drawSelf(texIDOver,MV_aniX+AnimalStartX,MV_aniY+AnimalStartY,overX,overY,rotateDirection,2);//碰撞图片
        }
        MatrixState.popMatrix();
    }
    //绘制记分板
    public void drawScoreboard() {
        //绘制关卡界面
        viewManager.texDrawer.drawSelf(TexManager.getTex("Scoreboard.png"),1500,2025,500,65,0,2);//绘制积分板
        viewManager.texDrawer.drawSelf(TexManager.getTex("number_usual_"+(mapIndex)+".png"),1670,2030,25,25,0,2);//当前关卡数
        if (Score>0) {
            if (Score<10) {
                viewManager.texDrawer.drawSelf(TexManager.getTex("number_usual_"+Score+".png"),1400,2030,25,25,0,2);//十位
            }
            else if(Score<100) {
                viewManager.texDrawer.drawSelf(TexManager.getTex("number_usual_"+(Score/10)+".png"),1350,2030,25,25,0,2);//百位
                viewManager.texDrawer.drawSelf(TexManager.getTex("number_usual_"+Score%10+".png"),1400,2030,25,25,0,2);//十位
            }else {
                viewManager.texDrawer.drawSelf(TexManager.getTex("number_usual_"+(Score/100)+".png"),1300,2030,25,25,0,2);//千位
                viewManager.texDrawer.drawSelf(TexManager.getTex("number_usual_"+(Score%100)+".png"),1350,2030,25,25,0,2);//百位
                viewManager.texDrawer.drawSelf(TexManager.getTex("number_usual_"+Score+".png"),1400,2030,25,25,0,2);//十位
            }
        }
        else {
            viewManager.texDrawer.drawSelf(TexManager.getTex("number_usual_0.png"),1400,2030,25,25,0,2);//最后的0
        }
    }
    //道具解锁提醒
    public void drawRemindPop()
    {
        if (magnetUnlock_flag) {
            viewManager.texDrawer.drawSelf(texIDWordmangetunlock,1500,3100,259,44,0,2);//显示磁石道具解锁提醒
        }
        if (clockUnlock_flag) {
            viewManager.texDrawer.drawSelf(texIDWordclockunlock,1500,3100,259,44,0,2);//显示秒表道具解锁提醒
        }
        if (securityUnlock_flag) {
            viewManager.texDrawer.drawSelf(texIDWordsecurityunlock,1500,3100,259,44,0,2);//显示盾牌道具解锁提醒
        }
    }
}
