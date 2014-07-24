package com.example.takebayashi.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.content.Intent;

public class NewHelloWorld extends Activity {

    public final static String EXTRA ="com.example.takebayashi.helloworld.MESSAGE";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        LinearLayout linearLayout=new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        addContentView(linearLayout, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));

        Log.v("LifeCycle", "onCreate");
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.v("LifeCycle", "onStart");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.v("LifeCycle", "onResume");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.v("LifeCycle", "onPause");
    }

    @Override
    public void onRestart(){
        super.onRestart();
        Log.v("LifeCycle", "onRestart");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.v("LifeCycle", "onStop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.v("LifeCycle", "onDestroy");
    }

    //
    public void onPush(View v){
        Log.d("ActionButton","Pushed Button");
//        Intent intent = new Intent();
        Intent intent = new Intent(this,HelloWorld.class);
//        intent.setClassName("com.example.takebayashi.helloworld",
//                "com.example.takebayashi.helloworld.HelloWorld");

        EditText editText = (EditText)findViewById(R.id.editText);
        String message=editText.getText().toString();
        intent.putExtra(EXTRA,message);

        startActivity(intent);

    }
}
