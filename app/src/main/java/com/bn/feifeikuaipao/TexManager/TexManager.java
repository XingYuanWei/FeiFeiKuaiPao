package com.bn.feifeikuaipao.TexManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES30;
import android.opengl.GLUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class TexManager
{
    //存放对应的纹理编号
    private static Map<String,Integer> tex=new HashMap<String, Integer>();
    private static List<String> texName=new ArrayList<String>();
    private static int initTexture(Resources r, String texFileName)
    {
        //生成纹理ID
        int[] textures = new int[1];
        GLES30.glGenTextures
                (
                        1,          //产生的纹理id的数量
                        textures,   //纹理id的数组
                        0           //偏移量
                );
        int textureId=textures[0];
        GLES30.glBindTexture(GLES30.GL_TEXTURE_2D, textureId);
        GLES30.glTexParameterf(GLES30.GL_TEXTURE_2D, GLES30.GL_TEXTURE_MIN_FILTER,GLES30.GL_NEAREST);
        GLES30.glTexParameterf(GLES30.GL_TEXTURE_2D,GLES30.GL_TEXTURE_MAG_FILTER,GLES30.GL_LINEAR);
        GLES30.glTexParameterf(GLES30.GL_TEXTURE_2D, GLES30.GL_TEXTURE_WRAP_S,GLES30.GL_CLAMP_TO_EDGE);
        GLES30.glTexParameterf(GLES30.GL_TEXTURE_2D, GLES30.GL_TEXTURE_WRAP_T,GLES30.GL_CLAMP_TO_EDGE);
        //通过输入流加载图片===============begin===================
        InputStream is=null;
        Bitmap bitmapTmp=null;
        try
        {
            is = r.getAssets().open("pic/"+texFileName);
            bitmapTmp = BitmapFactory.decodeStream(is);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                is.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        //通过输入流加载图片===============end=====================
        //实际加载纹理进显存
        GLUtils.texImage2D
                (
                        GLES30.GL_TEXTURE_2D, //纹理类型
                        0, 					  //纹理的层次，0表示基本图像层，可以理解为直接贴图
                        bitmapTmp, 			  //纹理图像
                        0					  //纹理边框尺寸
                );
        bitmapTmp.recycle(); 		  //纹理加载成功后释放内存中的纹理图
        return textureId;
    }

    public static void addTex(String tn)
    {
        texName.add(tn);
    }

    public static void addTexArray(String[] tna)
    {
        for(String tn:tna)
        {
            texName.add(tn);
        }
    }
    //没有参数R找不到图片
    public static void loadTextures(Resources r)
    {
        for(String tn:texName)
        {
            //根据传进来的图片名称加载所有的图片，surface在create的时候需要加载所有的
            tex.put(tn,initTexture(r,tn));
        }
    }
    //根据传进来的图片名字得到图片
    public static int getTex(String tn)
    {
        return tex.get(tn);
    }
}
