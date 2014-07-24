package com.example.takebayashi.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class HelloWorld extends Activity {

    //Activity開始直後に呼ばれるメソッド
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //遷移元から渡されたMessageをキャッチする
        Intent intent =getIntent();
        String message = intent.getStringExtra(NewHelloWorld.EXTRA);

        TextView textView = new TextView(this);
        textView.setText(message);
        textView.setTextSize(20);

        setContentView(textView);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.HONEYCOMB){
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        //画面に対してViewオブジェクトを配置する setContentView(int layoutResID)
        //今回のlayoutResIDを引数とする場合、対象となるXMLファイルを呼び出してオブジェクトを追加する
//        setContentView(R.layout.activity_hello_world);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hello_world, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
