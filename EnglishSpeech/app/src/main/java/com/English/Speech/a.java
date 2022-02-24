package com.English.Speech;

import android.app.Activity;
import android.os.Bundle;
import java.io.IOException;
import android.widget.ListView;
import android.widget.ListAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.database.DataSetObserver;
import android.widget.BaseAdapter;
import android.widget.Toast;
import java.util.Locale;
import android.content.Intent;

public class a extends Activity 
{
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a);
        
        try
        {
            Intent intent=getIntent();
            final String english[]=intent.getStringArrayExtra("english") ;
            String chinese[]=intent.getStringArrayExtra("chinese") ;
            /*
            for(int i=0;i<chinese.length;i++){
                
                System.out.println(english[i]);
                
            }
            */
            list=findViewById(R.id.aListView1);
           // Toast.makeText(getApplicationContext(),getSharedPreferences("language",MODE_PRIVATE ).getString("language",Locale.UK.toLanguageTag()),Toast.LENGTH_LONG).show();
            System.out.println(tool.getLanguage( getSharedPreferences("language",MODE_PRIVATE ).getString("language",Locale.UK.toLanguageTag())).toLanguageTag());
            TtsSpeak tts=new TtsSpeak(getApplicationContext(),  tool.getLanguage( getSharedPreferences("language",MODE_PRIVATE ).getString("language",Locale.UK.toLanguageTag())));
            list.setAdapter(new listAdapter(chinese,english,getApplicationContext(),tts,english));
        }
        catch ( ArrayIndexOutOfBoundsException e)
        {
            
            Toast.makeText(getApplicationContext(),"文件异常",Toast.LENGTH_LONG).show();
        }

        
        
    }
}
