package com.bn.feifeikuaipao.Thread;
import static com.bn.feifeikuaipao.view.RunView.magnetCount;
public class MagnetThread extends Thread
{
    boolean flag=true;
    public void run()
    {
        while (flag)
        {
            magnetCount++;
            try
            {
                Thread.sleep(200);
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
