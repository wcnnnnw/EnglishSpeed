package com.English.Speech;
import java.util.Random;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import org.apache.commons.codec.Charsets;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public  class tool
{
    
    public static String[] getEnglish(InputStream input){
        byte[] b=new byte[1024];
        try
        {
         b =new byte[input.available()];
        }
        catch (IOException e)
        {}
       
        try
        {
            while (input.read(b)!=-1){
                
                }
        }
        catch (IOException e)
        {}

        
        try
        {
            String s[]=new String(b, "utf-8").split("\n");
            String[] s1=new String[s.length/2];
            for (int i=0;i<s1.length;i++){
                
                s1[i]=s[i*2];
            }
            return s1;
        }
        catch (UnsupportedEncodingException e)
        {}

        return new String[0];
    }

    
    
    
    
    public static String[] getChinese(InputStream input){

        try
        {
          byte[]  b =new byte[input.available()];
            while (input.read(b)!=-1){

            }      
            

            String s[]=new String(b,"utf-8").split ("\n");
            String[] s1=new String[(s.length/2)];
            for (int i=1;i<s.length;i+=2){
                s1[i/2]=s[i];

            }
            return s1;
            
            
            
            }
        catch (IOException e)
        {e.printStackTrace();}



        return new String[0];    }

   static Locale getLanguage(String s){
        System.out.println(s);
        switch (s){
            

                case      "中文"     :
                return Locale    .CHINESE        ;
                

                case     "english"      :
                return Locale       .ENGLISH     ;
                

                case    "日本语"       :
                return Locale      .JAPANESE      ;
                

                case     "한어"      :
                return Locale     .KOREAN       ;
                

                case       "русск"    :
                return new Locale("ru")          ;
                

                case      "français"     :
                return Locale  .FRANCE          ;
                

                case      "español"     :
                return  new Locale("es");
                

                case      "العربية"     :
                return new Locale  ("ar")          ;

                case  "Deutsch"         :
                return Locale.GERMAN            ;
            default :
            return Locale.UK;
        }
        
    }
    
    
        
        
        
        
    
    
    }
