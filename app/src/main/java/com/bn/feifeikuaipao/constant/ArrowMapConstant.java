package com.bn.feifeikuaipao.constant;
import static com.bn.feifeikuaipao.constant.MapConstant.HGrayArrow;
import static com.bn.feifeikuaipao.constant.MapConstant.gray_arrow_left_jump;
import static com.bn.feifeikuaipao.constant.MapConstant.gray_arrow_right_jump;
import static com.bn.feifeikuaipao.constant.MapConstant.gray_arrow_up_jump;
import static com.bn.feifeikuaipao.constant.MapConstant.gray_arrow_up_left;
import static com.bn.feifeikuaipao.constant.MapConstant.gray_arrow_up_right;
import static com.bn.feifeikuaipao.constant.MapConstant.grayarrow_left;
import static com.bn.feifeikuaipao.constant.MapConstant.grayarrow_right;
import static com.bn.feifeikuaipao.constant.MapConstant.green_arrow_left;
import static com.bn.feifeikuaipao.constant.SourceConstant.arrowFirst;
public class ArrowMapConstant
{
    public static int [][]ARROWMAP01=new int[17][10];
    public static int [][]ARROWMAP02=new int[17][10];
    public static int [][]ARROWMAP03=new int[17][10];
    public static int [][]ARROWMAP04=new int[17][10];
    public static int [][]ARROWMAP05=new int[17][10];
    public static int [][]ARROWMAP06=new int[17][10];
    public static int [][]ARROWMAP07=new int[17][10];
    public static int [][]ARROWMAP08=new int[17][10];
    public static int [][]ARROWMAP09=new int[17][10];
    public static void initArrowMap()
    {
        ARROWMAP01 =new int[][]
                {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, HGrayArrow.get(4), 0, 0, HGrayArrow.get(5), 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0,HGrayArrow.get(3), 0, 0,0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, HGrayArrow.get(2), 0, 0, 0, HGrayArrow.get(1), 0, HGrayArrow.get(0), 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
        //第二关
        ARROWMAP02 = new int [][]
                {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, HGrayArrow.get(14), 0, 0, 0,HGrayArrow.get(13), 0, 0, 0 },
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        {0, HGrayArrow.get(10), HGrayArrow.get(11), 0, 0, 0,  HGrayArrow.get(12), 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, HGrayArrow.get(9), 0, HGrayArrow.get(8), 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, HGrayArrow.get(7), 0, HGrayArrow.get(6), 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
        //第三关
        ARROWMAP03 = new int[][]
                {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, HGrayArrow.get(25), HGrayArrow.get(26)},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
                        {0, HGrayArrow.get(21), HGrayArrow.get(22), 0, 0, HGrayArrow.get(23), 0, 0, HGrayArrow.get(24), 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, HGrayArrow.get(20), 0, 0, HGrayArrow.get(19), 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, HGrayArrow.get(18), 0, 0, HGrayArrow.get(17), 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, HGrayArrow.get(15), 0, 0, 0, 0, HGrayArrow.get(16), 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
        //第四关
        ARROWMAP04 = new int[][]
                {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, HGrayArrow.get(36), 0, 0, HGrayArrow.get(37), 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, HGrayArrow.get(34), HGrayArrow.get(35), 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, HGrayArrow.get(33), 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, HGrayArrow.get(32), 0, 0, 0, HGrayArrow.get(31), 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, HGrayArrow.get(29), HGrayArrow.get(30), 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, HGrayArrow.get(28), 0, 0, HGrayArrow.get(27)},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
        //第五关
        ARROWMAP05 = new int[][]
                {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, HGrayArrow.get(45), 0,HGrayArrow.get(46), 0, 0, HGrayArrow.get(47), 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, HGrayArrow.get(44), 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, HGrayArrow.get(43), 0, HGrayArrow.get(42), 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, HGrayArrow.get(41), 0, HGrayArrow.get(40), 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, HGrayArrow.get(39), 0, HGrayArrow.get(38), 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
        //第六关
        ARROWMAP06 = new int[][]
                {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, HGrayArrow.get(58), 0, 0, 0, HGrayArrow.get(57), 0, HGrayArrow.get(56), 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, HGrayArrow.get(54), 0, HGrayArrow.get(55), 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, HGrayArrow.get(52), 0, HGrayArrow.get(53), 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, HGrayArrow.get(51), 0, 0, 0, HGrayArrow.get(50), 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, HGrayArrow.get(48), 0, HGrayArrow.get(49), 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
        //第七关
        ARROWMAP07 = new int[][]
                {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, HGrayArrow.get(68), 0, 0, 0, 0, HGrayArrow.get(67), 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, HGrayArrow.get(65), 0, HGrayArrow.get(66), 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, HGrayArrow.get(64), 0, 0, HGrayArrow.get(63), 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, HGrayArrow.get(60), 0, HGrayArrow.get(61), 0, 0, 0, HGrayArrow.get(62), 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, HGrayArrow.get(59), 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
        //第八关
        ARROWMAP08 = new int[][]
                {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, HGrayArrow.get(73), 0, 0, 0, HGrayArrow.get(74), 0, 0},
                        {0, 0, 0, HGrayArrow.get(72), 0, HGrayArrow.get(71), 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, HGrayArrow.get(69), 0, 0, HGrayArrow.get(70), 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                };
    }
    public static void initArrow()
    {
        if (arrowFirst == 0)
        {
            //第一关
            HGrayArrow.put(0, green_arrow_left);
            HGrayArrow.put(1, gray_arrow_left_jump);//向左跳
            HGrayArrow.put(2, gray_arrow_up_right);//向上箭头向右转弯
            HGrayArrow.put(3, gray_arrow_up_jump);//向前跳
            HGrayArrow.put(4, grayarrow_right);
            HGrayArrow.put(5, gray_arrow_up_left);//向上箭头向左转弯

            //第二关
            HGrayArrow.put(6, grayarrow_left);//左转箭头
            HGrayArrow.put(7, gray_arrow_up_right);//向上右转箭头
            HGrayArrow.put(8, grayarrow_left);//左转箭头
            HGrayArrow.put(9, gray_arrow_up_right);//向上右转箭头
            HGrayArrow.put(10, grayarrow_right);//右转箭头
            HGrayArrow.put(11, gray_arrow_right_jump);//向右跳转箭头
            HGrayArrow.put(12, gray_arrow_up_left);//向上左转动作
            HGrayArrow.put(13, grayarrow_left);//左转
            HGrayArrow.put(14, gray_arrow_up_right);//向上右转

            //第三关
            HGrayArrow.put(15, grayarrow_right);//右转箭头
            HGrayArrow.put(16, gray_arrow_up_left);//向上左转箭头
            HGrayArrow.put(17, grayarrow_left);//左转箭头
            HGrayArrow.put(18, gray_arrow_up_right);//向上右转箭头
            HGrayArrow.put(19, grayarrow_left);//左转箭头
            HGrayArrow.put(20, gray_arrow_up_right);//向上右转箭头
            HGrayArrow.put(21, grayarrow_right);//右转箭头
            HGrayArrow.put(22, gray_arrow_right_jump);//向右跳箭头
            HGrayArrow.put(23, gray_arrow_right_jump);//向右跳箭头
            HGrayArrow.put(24, gray_arrow_up_left);//向上左转箭头
            HGrayArrow.put(25, grayarrow_right);//右转箭头
            HGrayArrow.put(26, gray_arrow_up_left);//想上左转箭头

            //第四关
            HGrayArrow.put(27, grayarrow_left);//左转箭头
            HGrayArrow.put(28, gray_arrow_up_right);//向上右转箭头
            HGrayArrow.put(29, grayarrow_right);//右转箭头
            HGrayArrow.put(30, gray_arrow_up_left);//向上左转箭头
            HGrayArrow.put(31, grayarrow_left);//左转箭头
            HGrayArrow.put(32, gray_arrow_up_right);//向上右转箭头
            HGrayArrow.put(33, gray_arrow_up_jump);//向上跳箭头
            HGrayArrow.put(34, grayarrow_right);//右转箭头
            HGrayArrow.put(35, gray_arrow_up_left);//向上左转箭头
            HGrayArrow.put(36, grayarrow_right);//右转箭头
            HGrayArrow.put(37, gray_arrow_up_left);//向上左转箭头

            //第五关
            HGrayArrow.put(38, grayarrow_left);//左转箭头
            HGrayArrow.put(39, gray_arrow_up_right);//向上右转箭头
            HGrayArrow.put(40, grayarrow_left);//左转箭头
            HGrayArrow.put(41, gray_arrow_up_right);//向上右转箭头
            HGrayArrow.put(42, grayarrow_left);//左转箭头
            HGrayArrow.put(43, gray_arrow_up_right);//向上右转箭头
            HGrayArrow.put(44, gray_arrow_up_jump);//向上跳箭头
            HGrayArrow.put(45, grayarrow_right);//右转箭头
            HGrayArrow.put(46, gray_arrow_right_jump);//向右跳箭头
            HGrayArrow.put(47, gray_arrow_up_left);//向上左转箭头

            //第六关
            HGrayArrow.put(48, grayarrow_right);//右转箭头
            HGrayArrow.put(49, gray_arrow_up_left);//左转向上箭头
            HGrayArrow.put(50, grayarrow_left);//左转箭头
            HGrayArrow.put(51, gray_arrow_up_right);//向上右转箭头
            HGrayArrow.put(52, grayarrow_right);//右转箭头
            HGrayArrow.put(53, gray_arrow_up_left);//向上左转箭头
            HGrayArrow.put(54, grayarrow_right);//右转箭头
            HGrayArrow.put(55, gray_arrow_up_left);//左转向上箭头
            HGrayArrow.put(56, grayarrow_left);//左转箭头
            HGrayArrow.put(57, gray_arrow_left_jump);//向左跳箭头
            HGrayArrow.put(58, gray_arrow_up_right);//想上右转箭头

            //第七关
            HGrayArrow.put(59, gray_arrow_up_jump);//向上跳箭头
            HGrayArrow.put(60, grayarrow_right);//右转箭头
            HGrayArrow.put(61, gray_arrow_right_jump);//向右跳箭头
            HGrayArrow.put(62, gray_arrow_up_left);//向上左转箭头
            HGrayArrow.put(63, grayarrow_left);//左转箭头
            HGrayArrow.put(64, gray_arrow_up_right);//向上右转箭头
            HGrayArrow.put(65, grayarrow_right);//右转箭头
            HGrayArrow.put(66, gray_arrow_up_left);//向上左转
            HGrayArrow.put(67, grayarrow_left);//左转箭头
            HGrayArrow.put(68, gray_arrow_up_right);//向上右转箭头

            //第八关
            HGrayArrow.put(69, grayarrow_right);//右转箭头
            HGrayArrow.put(70, gray_arrow_up_left);//向上左转箭头
            HGrayArrow.put(71, grayarrow_left);//左转箭头
            HGrayArrow.put(72, gray_arrow_up_right);//向上右转箭头
            HGrayArrow.put(73, grayarrow_right);//右转箭头
            HGrayArrow.put(74, gray_arrow_up_left);//向上左转箭头
            arrowFirst++;
        }
    }
}
