package com.example.takebayashi.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class NewHelloWorld extends Activity {

    public final static String EXTRA ="com.example.takebayashi.helloworld.MESSAGE";

    private RequestQueue mQueue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        LinearLayout linearLayout=new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        //ViewにOnClick~が定義されているのでキャストしなくてもいいらしい
        findViewById(R.id.button).setOnClickListener(buttonListener);

        addContentView(linearLayout, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        Log.v("LifeCycle", "onCreate");

        mQueue = Volley.newRequestQueue(this);
        requestVolley();
    }

    private void requestVolley(){
        String url = "http://animemap.net/api/table/tokyo.json";

        mQueue.add(new JsonObjectRequest(Request.Method.GET,url,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        Log.d("logs",jsonObject.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("net error",volleyError.toString());
                    }
                }));
        mQueue.start();
    }

    private final View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("ActionButton","Pushed Button");
            //Intentを使って画面遷移
            Intent intent = new Intent(NewHelloWorld.this,HelloWorld.class);

            EditText editText = (EditText)findViewById(R.id.editText);
            String message=editText.getText().toString();
            intent.putExtra(EXTRA,message);

            startActivity(intent);
        }
    };

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

}
