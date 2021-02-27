package com.bn.feifeikuaipao.constant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import static com.bn.feifeikuaipao.constant.BeanMapConstant.BEANMAP01;
import static com.bn.feifeikuaipao.constant.BeanMapConstant.BEANMAP02;
import static com.bn.feifeikuaipao.constant.BeanMapConstant.BEANMAP03;
import static com.bn.feifeikuaipao.constant.BeanMapConstant.BEANMAP04;
import static com.bn.feifeikuaipao.constant.BeanMapConstant.BEANMAP05;
import static com.bn.feifeikuaipao.constant.BeanMapConstant.BEANMAP06;
import static com.bn.feifeikuaipao.constant.BeanMapConstant.BEANMAP07;
import static com.bn.feifeikuaipao.constant.BeanMapConstant.BEANMAP08;
import static com.bn.feifeikuaipao.constant.BeanMapConstant.BEANMAP09;
import static com.bn.feifeikuaipao.constant.ArrowMapConstant.ARROWMAP01;
import static com.bn.feifeikuaipao.constant.ArrowMapConstant.ARROWMAP02;
import static com.bn.feifeikuaipao.constant.ArrowMapConstant.ARROWMAP03;
import static com.bn.feifeikuaipao.constant.ArrowMapConstant.ARROWMAP04;
import static com.bn.feifeikuaipao.constant.ArrowMapConstant.ARROWMAP05;
import static com.bn.feifeikuaipao.constant.ArrowMapConstant.ARROWMAP06;
import static com.bn.feifeikuaipao.constant.ArrowMapConstant.ARROWMAP07;
import static com.bn.feifeikuaipao.constant.ArrowMapConstant.ARROWMAP08;
import static com.bn.feifeikuaipao.constant.ArrowMapConstant.ARROWMAP09;
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
public class MapConstant
{
    public static int mapIndex=1;//当前地图索引默认为0
    /**************地图相关数据***********/
    public static final int rect = 2;//正方形白块
    public static final int rectLeft=31;
    public static final int rectRight=32;
    public static final int rectTop=33;
    public static final int rectDown=34;
    public static final int rectTop_top=39;
    public static final int semicircle_up = 7;//上半圆
    public static final int semicircle_down = 8;//下半圆
    public static final int semicircle_left = 9;//左半圆
    public static final int semicircle_right = 10;//右半圆
    public static final int finalrect = 11;//终点矩形
    public static final int bean = 12;//豆豆
    public static final int grayarrow_down = 14;//向下灰色箭头
    public static final int grayarrow_left = 15;//向左灰色箭头
    public static final int grayarrow_right = 16;//向右灰色箭头
    public static final int gray_arrow_left_jump=40;//灰色向左箭头向前跳跃的时候
    public static final int gray_arrow_right_jump=41;//灰色向右箭头向后跳跃的时候
    public static final int gray_arrow_up_jump=46;//灰色向左箭头向前跳跃的时候
    public static final int gray_arrow_down_jump=47;//灰色向右箭头向后跳跃的时候
    public static final int gray_arrow_up_left=42;//灰色向上箭头向左边转弯的时候
    public static final int gray_arrow_up_right=43;//灰色向上箭头向右边转弯的时候
    public static final int gray_arrow_down_left=44;//灰色向下箭头向左边转弯的时候
    public static final int gray_arrow_down_right=45;//灰色向下箭头向右边转弯的时候
    public static final int green_arrow_down=51;
    public static final int green_arrow_left=52;
    public static final int green_arrow_right=53;
    public static final int green_arrow_up_left=54;//绿色向上箭头向左边转弯的时候
    public static final int green_arrow_up_right=55;//绿色向上箭头向右边转弯的时候
    public static final int green_arrow_down_left=56;//绿色向下箭头向左边转弯的时候
    public static final int green_arrow_down_right=57;//绿色向下箭头向右边转弯的时候
    public static final int green_arrow_left_jump=58;//绿色箭头向左跳
    public static final int green_arrow_right_jump=59;//绿色箭头向右跳
    public static final int green_arrow_up_jump = 60;//绿色箭头向上跳
    public static final int green_arrow_down_jump = 61;//绿色箭头向下跳

    //起点
    public static final int rectbegin_1 = 63;//第一关起点图
    public static final int rectbegin_2 = 64;//第二关起点图
    public static final int rectbegin_3 = 65;//第三关起点图
    public static final int rectbegin_4 = 66;//第四关起点图
    public static final int rectbegin_5 = 67;//第五关起点图
    public static final int rectbegin_6 = 68;//第六关起点图
    public static final int rectbegin_7 = 69;//第七关起点图
    public static final int rectbegin_8 = 70;//第八关起点图
    //终点
    public static final int finalrect_1 = 71;//第一关终点
    public static final int finalrect_2 = 72;//第二关终点
    public static final int finalrect_3 = 73;//第三关终点
    public static final int finalrect_4 = 74;//第四关终点
    public static final int finalrect_5 = 75;//第五关终点
    public static final int finalrect_6 = 76;//第六关终点
    public static final int finalrect_7 = 77;//第七关终点
    public static final int finalrect_8 = 78;//第八关终点
    public static final int semicircle_rightfromleft = 81;//向右的半圆，从左面跳过来
    public static final int semicircle_leftfromright = 82;//向右的半圆，从左面跳过来
    public static final int semicircle_upfromldown = 83;//向右的半圆，从左面跳过来
    public static final int semicircle_downfromup = 84;//向右的半圆，从左面跳过来
    public static final int narrowrect = 85;//窄的矩形
    public static final int rectLeft_narrowrect = 86;//紧邻窄矩形的矩形
    public static final int rectRight_narrowrect = 87;//紧邻窄矩形的矩形
    //计数绿色箭头，每次吃一次的时候转变颜色
    public static HashMap<Integer,Integer>HGrayArrow=new HashMap<Integer, Integer>();
    public static int [][] MAPTemp=new int[136][10];//每一关暂时存放的数据
    public static int [][] BEANMAPTemp=new int[136][10];//每一关暂时存放的数据
    public static int [][] ARROWMAPTemp=new int[136][10];//每一关暂时存放的数据
    public static int beanCount=0;
    //public static int [][]MAP09=new int [17][10];
    //地图可以被改变的数据
    public static int [][]MAP01=
            {
                    {0, 0, 0, 0, 0, finalrect_1, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, rect, 0, 0, 0, 0},
                    {0, 0, rectTop, rectTop, rectTop, rectRight, 0, 0, 0, 0, 0},
                    {0, 0, rectRight, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, rectRight, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, semicircle_downfromup, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, semicircle_up, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, rectRight, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, rectRight, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, rectLeft, rectTop, semicircle_rightfromleft, 0, semicircle_left, rectTop, rectTop, 0,},
                    {0, 0, 0, 0, 0, 0, 0, 0, rectLeft, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, rectLeft, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, rectLeft, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, rectLeft, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, rectLeft, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, rectbegin_1, 0},//起点
            };
    //第二关
    public static int [][]MAP02=
            {
                    {0, 0, finalrect_2, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, rect, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, rectLeft, rectTop, rectTop, rectTop, rectTop, 0, 0, 0 },
                    {0, 0, 0, 0, 0, 0, rectLeft, 0, 0, 0 },
                    {0, rectTop, semicircle_right, 0, semicircle_leftfromright, rectTop,rectRight, 0, 0, 0},
                    {0, rectRight, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, rectLeft, rectTop, rectTop, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, rectRight, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, rectRight, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, rectRight, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, rectLeft, rectTop, rectTop, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, rectLeft, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, rectLeft, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, rectLeft, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, rectLeft, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, rectLeft, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, rectbegin_2, 0, 0, 0, 0},
            };
    //第三关
    public static int [][]MAP03=
            {
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, finalrect_3},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, rect},
                    {0, 0, 0, 0, 0, 0, 0, 0, rectLeft, rectRight},
                    {0, 0, 0, 0, 0, 0, 0, 0, rectRight, 0},
                    {0, rectTop, semicircle_right, 0, semicircle_leftfromright, semicircle_right, 0, semicircle_leftfromright, rectRight, 0},
                    {0, rectRight, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, rectRight, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, rectLeft, rectTop, rectTop, rectTop, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, rectLeft, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, rectLeft, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, rectLeft, rectTop, rectTop, rectTop, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, rectLeft, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, rectLeft, 0, 0},
                    {0, 0, rectTop, rectTop, rectTop, rectTop, rectTop, rectRight, 0, 0},
                    {0, 0, rectRight, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, rectRight, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, rectbegin_3, 0, 0, 0, 0, 0, 0, 0},
            };
    //第四关
    public static int [][]MAP04=
            {
                    {0, 0, 0, 0, 0, 0, 0, finalrect_4, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, rect, 0, 0},
                    {0, 0, 0, 0, rectTop, rectTop, rectTop, rectRight, 0, 0},
                    {0, 0, 0, 0, rectRight, 0, 0, 0, 0, 0},
                    {0, 0, 0, rectTop, rectRight, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, semicircle_up, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, rectLeft, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, rectLeft, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, rectLeft, rectTop, rectTop, rectTop, rectTop, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, rectRight, 0, 0},
                    {0, 0, 0, 0, 0, 0, rectTop, rectRight, 0, 0},
                    {0, 0, 0, 0, 0, 0, rectRight, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, rectTop, rectTop,/*10*/rectTop, rectTop},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, rectLeft},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, rectLeft},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, rectbegin_4},
            };
    //第五关
    public static int [][]MAP05=
            {
                    {0, 0, 0, 0, 0, 0, finalrect_5, 0, 0, 0},
                    {0, rectLeft, rect, semicircle_right, 0, semicircle_leftfromright, rectRight, 0, 0, 0},
                    {0, rectRight, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, semicircle_downfromup, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, semicircle_up, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, rectRight, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, rectRight, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, rectLeft, rectTop, rectTop, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, rectLeft, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, rectLeft, rectTop, rectTop, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, rectLeft, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, rectLeft, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, rectLeft, rectTop, rectTop, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, rectLeft, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, rectLeft, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, rectbegin_5, 0, 0},
            };
    //第六关
    public static int [][]MAP06=
            {
                    {0, 0, finalrect_6, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, rect, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, rect, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, rectLeft, rectTop, semicircle_rightfromleft, 0, semicircle_left, rectTop, rectTop, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, rectLeft, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, rectLeft, 0},
                    {0, 0, 0, 0, 0, 0, rectTop, rectTop, rectRight, 0},
                    {0, 0, 0, 0, 0, 0, rectLeft, 0, 0, 0},
                    {0, 0, 0, 0, rectTop, rectTop, rectRight, 0, 0, 0},
                    {0, 0, 0, 0, rectRight, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, rectRight, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, rectLeft, rectTop, rectTop, rectTop, rectTop, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, rectLeft, 0},
                    {0, 0, 0, 0, 0, 0, rectTop, rectTop, rectRight, 0},
                    {0, 0, 0, 0, 0, 0, rectLeft, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, rectLeft, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, rectbegin_6, 0, 0, 0},
            };
    //第七关
    public static int [][]MAP07=
            {
                    {0, 0, finalrect_7, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, rect, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, rect,  0, 0, 0, 0, 0, 0, 0},
                    {0, 0, rectLeft, rectTop, rectTop, rectTop, rectTop, rectTop, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, narrowrect, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, rectLeft, 0, 0},
                    {0, 0, 0, 0, 0, rectTop, rectTop, rectRight, 0, 0},
                    {0, 0, 0, 0, 0, rectRight, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, rectLeft, rectTop, rectTop, rectTop, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, narrowrect, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, rectLeft_narrowrect, 0},
                    {0, 0, rectTop, rectTop, semicircle_right, 0, semicircle_leftfromright, rectTop, rectRight, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, semicircle_up, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, narrowrect, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, rectRight_narrowrect, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, rectbegin_7, 0, 0, 0, 0, 0, 0, 0},
            };
    //第八关
    public static int [][]MAP08=
            {
                    {0, 0, 0, 0, 0, 0, 0, finalrect_8, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, rect, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, rect, 0, 0},
                    {0, 0, 0, rectLeft,rectTop,rectTop, rectTop, rectRight, 0, 0},
                    {0, 0, 0, rectLeft, rectTop, rectTop, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, rectLeft, 0, 0, 0, 0},//窄的
                    {0, 0, 0, 0, 0, rectLeft, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, narrowrect, 0, 0, 0, 0},//窄的
                    {0, 0, 0, 0, 0, rectLeft_narrowrect, 0, 0, 0, 0},
                    {0, 0, rectTop, rectTop, rectTop, rectRight, 0, 0, 0, 0},
                    {0, 0, rectRight, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, narrowrect, 0, 0, 0, 0, 0, 0, 0},//两个窄的
                    {0, 0, rectRight_narrowrect, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, rectRight, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, rectRight, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, rectRight, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, rectbegin_8, 0, 0, 0, 0, 0, 0, 0},
            };
    public static int [][]MAP09=new int[17][10];
    //初始化豆豆图
    public static void initBeanMapData()
    {
        if(beanCount==0)//此方法只执行一次是为了让动物吃掉豆以后防止豆再一次出现
        {
            if(ClickWorld_One)//点击第一世界
            {
                BEANMAPTemp=initWorldMAP(BEANMAP01,BEANMAP02,BEANMAP03,BEANMAP04);
            }
            if (ClickWorld_Two&&World_Two)//假如点击第二世界且第二世界解锁
            {
                BEANMAPTemp=initWorldMAP(BEANMAP02,BEANMAP03,BEANMAP04,BEANMAP05);
            }
            if(ClickWorld_Three&&World_Three)//假如点击第三世界且第三世界解锁
            {
                BEANMAPTemp=initWorldMAP(BEANMAP03,BEANMAP04,BEANMAP05,BEANMAP06);
            }
            if(ClickWorld_Four&&World_Four)//假如点击第四世界且第四世界解锁
            {
                BEANMAPTemp=initWorldMAP(BEANMAP04,BEANMAP05,BEANMAP06,BEANMAP07);
            }
            if(ClickWorld_Five&&World_Five)//假如点击第五世界且第五世界解锁
            {
                BEANMAPTemp=initWorldMAP(BEANMAP05,BEANMAP06,BEANMAP07,BEANMAP08);
            }
            if(ClickWorld_Six&&World_Six)//假如点击第三世界且第三世界解锁
            {
                BEANMAPTemp=initWorldMAP(BEANMAP06,BEANMAP07,BEANMAP08,BEANMAP09);
            }
            if(ClickWorld_Seven&&World_Seven)//假如点击第三世界且第三世界解锁
            {
                BEANMAPTemp=initWorldMAP(BEANMAP07,BEANMAP08,BEANMAP09,BEANMAP09);
            }
            if(ClickWorld_Eight&&World_Eight)//假如点击第三世界且第三世界解锁
            {
                BEANMAPTemp=initWorldMAP(BEANMAP08,BEANMAP09,BEANMAP09,BEANMAP09);
            }
            beanCount++;
        }
    }
    //初始化地图
    public static void initMapData()
    {
        if(ClickWorld_One)//点击第一世界
        {
            MAPTemp=initWorldMAP(MAP01,MAP02,MAP03,MAP04);
        }
        if (ClickWorld_Two&&World_Two)//假如点击第二世界且第二世界解锁
        {
            MAPTemp=initWorldMAP(MAP02,MAP03,MAP04,MAP05);
        }
        if(ClickWorld_Three&&World_Three)//假如点击第三世界且第三世界解锁
        {
            MAPTemp=initWorldMAP(MAP03,MAP04,MAP05,MAP06);
        }
        if(ClickWorld_Four&&World_Four)//假如点击第四世界且第四世界解锁
        {
            MAPTemp=initWorldMAP(MAP04,MAP05,MAP06,MAP07);
        }
        if(ClickWorld_Five&&World_Five)//假如点击第五世界且第五世界解锁
        {
            MAPTemp=initWorldMAP(MAP05,MAP06,MAP07,MAP08);
        }
        if(ClickWorld_Six&&World_Six)//假如点击第三世界且第三世界解锁
        {
            MAPTemp=initWorldMAP(MAP06,MAP07,MAP08,MAP09);
        }
        if(ClickWorld_Seven&&World_Seven)//假如点击第三世界且第三世界解锁
        {
            MAPTemp=initWorldMAP(MAP07,MAP08,MAP09,MAP09);
        }
        if(ClickWorld_Eight&&World_Eight)//假如点击第三世界且第三世界解锁
        {
            MAPTemp=initWorldMAP(MAP08,MAP09,MAP09,MAP09);
        }
    }
    public static void initArrowMapData()
    {
        if(ClickWorld_One)//点击第一世界
        {
            ARROWMAPTemp=initWorldMAP(ARROWMAP01,ARROWMAP02,ARROWMAP03,ARROWMAP04);
        }
        if (ClickWorld_Two&&World_Two)//假如点击第二世界且第二世界解锁
        {
            ARROWMAPTemp=initWorldMAP(ARROWMAP02,ARROWMAP03,ARROWMAP04,ARROWMAP05);
        }
        if(ClickWorld_Three&&World_Three)//假如点击第三世界且第三世界解锁
        {
            ARROWMAPTemp=initWorldMAP(ARROWMAP03,ARROWMAP04,ARROWMAP05,ARROWMAP06);
        }
        if(ClickWorld_Four&&World_Four)//假如点击第四世界且第四世界解锁
        {
            ARROWMAPTemp=initWorldMAP(ARROWMAP04,ARROWMAP05,ARROWMAP06,ARROWMAP07);
        }
        if(ClickWorld_Five&&World_Five)//假如点击第五世界且第五世界解锁
        {
            ARROWMAPTemp=initWorldMAP(ARROWMAP05,ARROWMAP06,ARROWMAP07,ARROWMAP08);
        }
        if(ClickWorld_Six&&World_Six)//假如点击第三世界且第三世界解锁
        {
            ARROWMAPTemp=initWorldMAP(ARROWMAP06,ARROWMAP07,ARROWMAP08,ARROWMAP09);
        }
        if(ClickWorld_Seven&&World_Seven)//假如点击第三世界且第三世界解锁
        {
            ARROWMAPTemp=initWorldMAP(ARROWMAP07,ARROWMAP08,ARROWMAP09,ARROWMAP09);
        }
        if(ClickWorld_Eight&&World_Eight)//假如点击第三世界且第三世界解锁
        {
            ARROWMAPTemp=initWorldMAP(ARROWMAP08,ARROWMAP09,ARROWMAP09,ARROWMAP09);
        }
    }

    public static void initAllMapData()
    {
        ArrowMapConstant.initArrow();
        ArrowMapConstant.initArrowMap();
        BeanMapConstant.initBeanMap();
        MapConstant.initMapData();
        MapConstant.initBeanMapData();
        MapConstant.initArrowMapData();

    }
    public static int [][] initWorldMAP(int [][]MAP01,int [][]MAP02,int [][]MAP03,int [][]MAP04)
    {
        //将数组转为集合的方法，返回的是List集合。和Collection的toArray对应，是数组和集合间相互转换的两个桥梁方法。
        //Arrays.asList方法返回的List是不允许add和remove的,这种list的长度不可变
        List<int []>list = new ArrayList<int[]>(Arrays.<int[]>asList(MAP04));
        //Arrays.asList的返回值是调用是传入参数类型的List，所以传入啥，返回啥的列表
        list.addAll(Arrays.<int[]>asList(MAP03));
        list.addAll(Arrays.<int[]>asList(MAP02));
        list.addAll(Arrays.<int[]>asList(MAP01));
        return list.toArray(MAP04);
    }
}
