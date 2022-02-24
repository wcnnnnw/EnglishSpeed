package com.English.Speech;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import java.io.IOException;
import android.content.Context;
import android.widget.Toast;
import android.view.View;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.view.Menu;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.content.SharedPreferences;
import java.io.InputStream;
import com.leon.lfilepickerlibrary.LFilePicker;
import java.util.List;
import android.widget.ListView;
import java.util.TreeMap;
import android.content.SharedPreferences.Editor;
import java.util.TreeSet;
import android.support.v7.recyclerview.extensions.ListAdapter;

public class MainActivity extends AppCompatActivity
{

    private Spinner spinner;

    private static final int REQUESTCODE_FROM_ACTIVITY = 1000;
ListView listView;
TreeSet<String> set =new TreeSet<String>() ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
        listView=findViewById(R.id.activitymainFileListView1);
        set = new TreeSet<String>(getSharedPreferences("file",MODE_PRIVATE).getStringSet("file",set));
listView.setAdapter(new FileAdapter(set,getApplicationContext()));
        SharedPreferences sp=getSharedPreferences("language",MODE_PRIVATE);
        final SharedPreferences.Editor edit=sp.edit();
        spinner=findViewById(R.id.language);
        spinner.setOnItemSelectedListener( (new AdapterView. OnItemSelectedListener(){

                                              @Override
                                              public void onItemSelected(AdapterView<?> p1, View p2, int p3, long p4)
                                              {
                                               //   Toast.makeText(getApplicationContext(),spinner.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
                                                  edit.putString("language",spinner.getSelectedItem().toString());
                                                  edit.commit();
                                              }

                                              @Override
                                              public void onNothingSelected(AdapterView<?> p1)
                                              {
                                              }


                                          }));
        

        
  }
  
    public void Common_spoken_English(View v) throws IOException{
        Intent intent = new Intent();
        intent.setClass(this, a.class);
        intent.putExtra("english", tool.getEnglish(getAssets().open("a")));
        intent.putExtra("chinese", tool.getChinese(getAssets().open("a") ));

        startActivity(intent);
      
  }
  
  
  public void Common_English(View v) throws IOException{
      

      Intent intent = new Intent();
      intent.setClass(this, a.class);
      intent.putExtra("english", tool.getEnglish(getAssets().open("b")));
      intent.putExtra("chinese", tool.getChinese(getAssets().open("b") ));

      startActivity(intent);
      
      
      
  }
  
  public void Prepositional_VPG_EEE(View v) throws IOException{
      

      Intent intent = new Intent();
      intent.setClass(this, a.class);
      intent.putExtra("english", tool.getEnglish(getAssets().open("c")));
      intent.putExtra("chinese", tool.getChinese(getAssets().open("c") ));

      startActivity(intent);
      
  }

  
  
  
  
    public void High_frequency_English(View v) throws IOException{

        Intent intent = new Intent();
        intent.setClass(this, a.class);
        intent.putExtra("english", tool.getEnglish(getAssets().open("d")));
        intent.putExtra("chinese", tool.getChinese(getAssets().open("d") ));

        startActivity(intent);
        
        
        
        
    }
  
  

    public void Test_Sentence(View v) throws IOException{
        

        Intent intent = new Intent();
        intent.setClass(this, a.class);
        intent.putExtra("english", tool.getEnglish(getAssets().open("e")));
        intent.putExtra("chinese", tool.getChinese(getAssets().open("e") ));

        startActivity(intent);
        
        
    }
    
    
    
    
    public void be_A_P(View v) throws IOException{
        
        
        Intent intent = new Intent();
        intent.setClass(this, a.class);
        intent.putExtra("english", tool.getEnglish(getAssets().open("f")));
        intent.putExtra("chinese", tool.getChinese(getAssets().open("f") ));

        startActivity(intent);
        
        
        
    }
    
    
    public void To_phrase(View v) throws IOException{
        
        

        Intent intent = new Intent();
        intent.setClass(this, a.class);
        intent.putExtra("english", tool.getEnglish(getAssets().open("g")));
        intent.putExtra("chinese", tool.getChinese(getAssets().open("g") ));

        startActivity(intent);
        
    }
  
    public void addFile(View v){
        new LFilePicker()
            .withActivity(MainActivity.this)
            .withMutilyMode(false)
            .withRequestCode(REQUESTCODE_FROM_ACTIVITY)
            .start();
        
        
        
        
    }
    
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUESTCODE_FROM_ACTIVITY) {
               List<String> list = data.getStringArrayListExtra(/*RESULT_INFO*/"paths");
               //System.out.println(data.getStringArrayListExtra(
               if (list.size()!=0){
               Toast.makeText(getApplicationContext(), "选中了" + list.get(0), Toast.LENGTH_SHORT).show();
            //    map.put(list.get(0),list.get(0));
            set.add(list.get(0));
                   SharedPreferences.Editor ed=getSharedPreferences("file", MODE_PRIVATE).edit();
                   ed.putStringSet("file",set);
                   ed.commit();
                   listView.setAdapter(new FileAdapter(set,getApplicationContext()));
               }
           }
        }
    }

    @Override
    protected void onDestroy()
    { SharedPreferences.Editor ed=getSharedPreferences("file", MODE_PRIVATE).edit();
        ed.putStringSet("file",set);
        ed.commit();
        
        super.onDestroy();
    }
    
    
    
    
    
    
    
  }
