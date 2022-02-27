package com.English.Speech;
import android.widget.BaseAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.TreeMap;
import android.view.LayoutInflater;
import android.content.Context;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.Toast;
import java.util.TreeSet;
import android.widget.ArrayAdapter;
import android.view.View.OnLongClickListener;
import android.content.Intent;
import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileAdapter extends BaseAdapter
{

    TreeSet<String> set;
    Context context;
    FileAdapter(          TreeSet<String> set     ,    Context context){
        this.context=context;
        this.set=set;
    }
    
    
    @Override
    public int getCount()
    {
        return set.size();
    }

    @Override
    public Object getItem(int p1)
    {
        return   set.toArray()[p1] ;
    }

    @Override
    public long getItemId(int p1)
    {
        return p1;
    }

    @Override
    public View getView(final int p1, View p2, ViewGroup p3)
    {

       p2=LayoutInflater.from(context).inflate(R.layout.filelist,p3,false) ;
       Button filelistButton1=p2.findViewById(R.id.filelistButton1);
        String s[]=set.toArray()[p1].toString().split ("/");
        if (s.length!=0){
        filelistButton1.setText( s[s.length-1]);}
        else{
            filelistButton1.setText(set.toArray()[p1].toString());
            
        }
        filelistButton1.setOnClickListener(new OnClickListener(){

                @Override
                public void onClick(View v)
                {  
                   // Toast.makeText(context,set.toArray()[p1].toString(),Toast.LENGTH_LONG).show();

                    Intent intent = new Intent();
                    intent.setClass(context, a.class);
                    intent.setFlags( intent.FLAG_ACTIVITY_NEW_TASK);
                    try
                    {
                        intent.putExtra("english", tool.getEnglish(new FileInputStream(new File(set.toArray()[p1].toString()))));
                        intent.putExtra("chinese", tool.getChinese(new FileInputStream(new File(set.toArray()[p1].toString()))));
                        
                   context.startActivity(intent);
                    }
                    catch (FileNotFoundException e)
                    {
                        e.printStackTrace();
                        Toast.makeText(context,"文件丢失",Toast.LENGTH_LONG).show();
                    }
                    
                }
        });
        filelistButton1.setOnLongClickListener(new OnLongClickListener(){

                @Override
                public boolean onLongClick(View v)
                {
                    set.remove(set.toArray()[p1]);

                    Toast.makeText(context,"已删除",Toast.LENGTH_LONG).show();
                    
                    return false;
                }
                
            
            
            
        });
        
        return p2;
    }
    
    
    
    
    
    
    
    
}
