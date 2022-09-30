package com.example.twinprime;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.media.tv.TvContract;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Parameter;

public class MainActivity extends AppCompatActivity {
    EditText edit;
    TextView tv;
    Handler handler;
    double num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = (EditText) findViewById(R.id.editTextTextPersonName);
        tv = (TextView) findViewById(R.id.textView2);
        tv.setMovementMethod(new ScrollingMovementMethod());
        handler = new Handler(Looper.getMainLooper());

    }


public class printPrime extends Thread{
            @RequiresApi(api = Build.VERSION_CODES.O)

            public void run(){
                //placeholder number (findViewById(R.id.editTextTextPersonName).getAutofillType()?)
                for(int i = 3; i < 200;i++){
                    if( isPrime(i) == true && isPrime(i+2) == true ){
                        tv.setText("twin primes"+ i + ","+ i+2);
                    }
                }

}

    public void onAsyncClick(View view){
        // new MyAsyncTask().execute();

        Runnable r = new Runnable(){

            @Override
            public void run() {
                for(int i =2; i< edit.length(); i++){
                    if(isPrime(i) && isPrime(i+2)){
                        tv.setText("twin primes"+ i +","+ i+2);
                    }
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                    }
                });{

                }
            }
        };
    }

    public boolean isPrime(int num){

        if (num < 2){
            return false;
        }for(int k =2; k <= num/2; k++){
            if(num%k == 0){
                return false;
            }
        }
        return true;
    }

    }

    public void onThreadClick(View view){
        printPrime threadClick = new printPrime();
        threadClick.start();
        System.out.println("it worked inside");

    }

//    class MyAsyncTask extends AsyncTask<Parameter, TvContract.Programs> {
//
//
//
//        protected Object doInBackground() {
//            for(int i =2; i< edit.length(); i++){
//                if(isPrime(i) && isPrime(i+2)){
//                   // tv.setText("twins: ( ";
//                }
//            }
//            return tv.getText();
//        }
//
//        @Override
//        protected Object doInBackground(Object[] objects) {
//            return null;
//        }
//    }


}
