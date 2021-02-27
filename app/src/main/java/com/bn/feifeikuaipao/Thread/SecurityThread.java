package com.bn.feifeikuaipao.Thread;

import static com.bn.feifeikuaipao.view.RunView.magnetCount;

/**
 * Created by lcy on 2018/4/10.
 */

public class SecurityThread extends Thread
{
    boolean flag=true;
    public void run()
    {
        while (flag)
        {
            magnetCount++;
            try
            {
                Thread.sleep(100);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
            if(magnetCount==100)
            {
                magnetCount=0;
            }
        }
    }
}
