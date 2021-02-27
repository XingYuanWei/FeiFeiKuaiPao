package com.bn.feifeikuaipao.Thread;

import static com.bn.feifeikuaipao.view.RunView.timer;
import static com.bn.feifeikuaipao.view.RunView.timers;

//脚循环时间
public class TimesFootThread extends Thread {
    public static boolean time_foot_flag = true;//脚循环标志
    public void run()
    {
        while (time_foot_flag)
        {
            timers++;
            try
            {
                Thread.sleep(200);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
            if(timers==100)
            {
                timers = 0;
            }
        }
    }
}

