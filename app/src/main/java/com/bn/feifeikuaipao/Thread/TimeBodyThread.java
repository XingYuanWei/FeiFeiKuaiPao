package com.bn.feifeikuaipao.Thread;
import static com.bn.feifeikuaipao.view.RunView.timer;
public class TimeBodyThread extends Thread
{
    public static boolean timer_body_flag = true;//时间循环标志位
    public void run()
    {
        while (timer_body_flag)
        {
            timer++;
            try
            {
                Thread.sleep(150);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
            if(timer==100)
            {
                timer = 0;
            }
        }
    }
}
