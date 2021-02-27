package com.bn.feifeikuaipao.view;
import android.view.MotionEvent;
import javax.microedition.khronos.opengles.GL10;
public abstract class CurrentView
{
    public abstract void initView();
    public abstract boolean onTouchEvent(MotionEvent e);
    public abstract void drawView(GL10 gl);
}
