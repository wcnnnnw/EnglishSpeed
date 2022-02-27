package com.English.Speech;



import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import java.util.Locale;
import android.content.Context;

public class TtsSpeak  {
    private TextToSpeech textToSpeech;
    boolean permission=false;
    float speed=0;
    long time=0;
    private static int PERMISSION_GRANTED = 0;
    private String[] permissions = new String[]{Manifest.permission.INTERNET,Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.ACCESS_NETWORK_STATE,Manifest.permission.SYSTEM_ALERT_WINDOW,
        Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION};
        Context context;
        Locale language;
        
        
        
    TtsSpeak(final Context context,final Locale language){
        this.context=context;
        this.language=language;
        if(permission==false){
            getPermission();
            
            }


        // 参数Context,TextToSpeech.OnInitListener

        /**
         * 初始化TextToSpeech引擎
         * status:SUCCESS或ERROR
         * setLanguage设置语言
         */
        TextToSpeech.OnInitListener s=new TextToSpeech.OnInitListener(){
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) 
                {
                    
                    int result = textToSpeech.setLanguage(language);
                    if (result == TextToSpeech.LANG_MISSING_DATA
                        || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Toast.makeText(context, "数据丢失或不支持", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        };

        if(textToSpeech==null){
            textToSpeech = new TextToSpeech(context, s); 

        }

    }
    
    
    
    
    
    public void play(String string){
        if(time>System.currentTimeMillis()-900){
            speed+=0.4;
        }else{

            speed=1;
        }
        time=System.currentTimeMillis();
        if(textToSpeech.isSpeaking()){
            textToSpeech.stop();
        }
        if (textToSpeech != null && !textToSpeech.isSpeaking()) {
            textToSpeech.setPitch(0);// 设置音调
            System.out.println(speed);
            textToSpeech.setSpeechRate(speed);
            textToSpeech.speak(string,TextToSpeech.QUEUE_FLUSH, null);
        }


    }




        public void stop(){
        textToSpeech.stop();}
        
        
        public void shutdown(){
        textToSpeech.shutdown();}






    /**
     * 动态获取权限
     */
    public void getPermission(){
        //判断是否有权限
        permission=true;
        if (ContextCompat.checkSelfPermission(/*this activity*/ context,
                                              Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //请求权限
            // ActivityCompat.requestPermissions(this , permissions, PERMISSION_GRANTED);
            System.out.println( permissions.length);
            //判断是否需要 向用户解释，为什么要申请该权限
            // if (ActivityCompat.shouldShowRequestPermissionRationale( this,
            //                                                      Manifest.permission.READ_CONTACTS)) {
            //Toast.makeText( getApplicationContext(), "shouldShowRequestPermissionRationale", Toast.LENGTH_SHORT).show();
            //  }
        }}

}

