package com.English.Speech;
import android.widget.TextView;
import android.widget.Button;
import android.widget.BaseAdapter;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ListAdapter;
import java.util.zip.Inflater;
import android.content.Context;
import android.view.LayoutInflater;
import android.content.res.ColorStateList;
import android.support.v4.graphics.ColorUtils;
import android.view.View.OnClickListener;
import android.text.style.LocaleSpan;
import java.util.Locale;
import android.widget.Toast;

public class listAdapter extends BaseAdapter
{
    String[] chinese;String[] english;Context context;String[] speakLanguage;
    TtsSpeak talk;
    listAdapter(String[] chinese,String[] english,Context context,TtsSpeak talk,String[] speakLanguage){
        
        this.chinese=chinese;
        this.english=english;
        this.context=context;
        this.speakLanguage=speakLanguage;
this.talk=talk;
    }
    
    @Override
    public int getCount()
    {
        return english.length;
    }

    @Override
    public Object getItem(int p1)
    {
        return english[p1];
    }

    @Override
    public long getItemId(int p1)
    {
        return p1;
    }

    @Override
    public View getView(final int p1, View p2, ViewGroup p3)
    {

        
        /*
        if (p2 == null) {
            p2 = LayoutInflater.from(context).inflate(R.layout.list, null);
           viewHolder vh = new viewHolder(p2);
            p2.setTag(vh);
        } else {
            vh = (viewHolder) p2.getTag();
        }
        */
        int position = p1;
        playOnclick playonclick = null;
        if(playonclick==null){
        playonclick=playOnclick.getPlayOnclick (talk,speakLanguage);}
        viewHolder  vh=null;
        if( p2==null){
        p2=LayoutInflater.from(context).inflate(R.layout.list,p3,false) ;
        
        vh=new viewHolder(p2);
        p2.setTag(vh);

            vh.playButton.setTag(position);
        }else{
           vh=(listAdapter.viewHolder) p2.getTag();
            vh.playButton.setTag(position);
        }
        vh.chineseView.setText(chinese[p1]);
        vh.englishView.setText(english[p1]);
        /*
       vh.playButton.setOnClickListener(new OnClickListener(){

                @Override
                public void onClick(View v)
                {
                    
                    talk.play(english[p1]);
                    
                }
            });
        */
        
        playonclick.setPosition(p1,context);
        vh.playButton.setOnClickListener(playonclick);
        
        return p2;
    }
    
    
    
    
    
    
    
 static class viewHolder{
        
        TextView englishView;
        TextView chineseView;
        Button playButton;
        viewHolder(View v){

            this.chineseView=v.findViewById(R.id.ChineseText);
            this.englishView=v.findViewById(R.id.EnglishText);
            this.playButton=v.findViewById(R.id.VoicePlay);
        }
        
    }
   
    
    }
    
 class playOnclick implements OnClickListener {

        TtsSpeak talk;
        String [] string;
        int position;
        private  static playOnclick playonclick= new playOnclick();
        
        
      
    public static  playOnclick getPlayOnclick(TtsSpeak talk,String[] string){
            playonclick.talk=talk;
            playonclick .string=string;
            return playonclick;
        }

    private playOnclick(){}
    
     public void setPosition(int position,Context context){
         this.position=position;
         this.context=context;
     }
     Context context;
    @Override
    public void onClick(View v)
    {
        talk.play(string[Integer.valueOf( v.getTag())]);
     // talk.play(string[ v.getTag()]);
    }
    
      
    

    
    
    
    
    
    
    
    
    
    
}
    
