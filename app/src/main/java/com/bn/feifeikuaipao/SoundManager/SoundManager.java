package com.bn.feifeikuaipao.SoundManager;
import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.media.SoundPool;

import com.bn.feifeikuaipao.MainActivity;
import com.bn.feifeikuaipao.R;

import java.util.HashMap;

import static com.bn.feifeikuaipao.constant.SourceConstant.Sound_click;
import static com.bn.feifeikuaipao.constant.SourceConstant.Sound_eat;
import static com.bn.feifeikuaipao.constant.SourceConstant.Sound_fail;
import static com.bn.feifeikuaipao.constant.SourceConstant.Sound_fall;
import static com.bn.feifeikuaipao.constant.SourceConstant.Sound_finish;
import static com.bn.feifeikuaipao.constant.SourceConstant.Sound_jump;
import static com.bn.feifeikuaipao.constant.SourceConstant.Sound_turn;
public class SoundManager {
    SoundPool soundPool;//安卓音效池   适合短促且对反应速度比较高的情况
    HashMap<Integer, Integer> hashMap;//放置各种音效
    MainActivity mainActivity;

    public SoundManager(MainActivity mainActivity)
    {
        this.mainActivity = mainActivity;
        initSound();
    }
    public void initSound()
    {
        //同时存在最多音频数量，声音流的类型，采样速率转化器的质量
        soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 100);
        hashMap = new HashMap<Integer, Integer>();
        //最后为音效播放时的优先级，官方解释这个参数在这个方法中不起作用，建议用1暂时代替
        hashMap.put(Sound_click,soundPool.load(mainActivity, R.raw.press_button,1));//点击按钮声音
        hashMap.put(Sound_eat,soundPool.load(mainActivity,R.raw.eatbean,1));//吃掉豆豆声音
        hashMap.put(Sound_turn,soundPool.load(mainActivity,R.raw.turn,1));//转弯
        hashMap.put(Sound_fall,soundPool.load(mainActivity,R.raw.fall,1));//下落
        hashMap.put(Sound_jump,soundPool.load(mainActivity,R.raw.bird_jump,1));//起跳
        hashMap.put(Sound_fail,soundPool.load(mainActivity,R.raw.tuning_level_fail,1));//失败
        hashMap.put(Sound_finish,soundPool.load(mainActivity,R.raw.tuning_level_backwin,1));//成功通过一关
    }
    public void playMusic(int sound, int loop)
    {
        AudioManager audioManager = (AudioManager)mainActivity.getSystemService(mainActivity.AUDIO_SERVICE);
        float steamVolumCurrent = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        float steamVolumMax = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float volum = steamVolumCurrent / steamVolumMax;
        soundPool.play(hashMap.get(sound), volum, volum, 1, loop, 1);
    }
}
