package com.example.lenovo.work3_ui;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
public class XML extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        TextView textView = (TextView) findViewById(R.id.textView);
        int id = item.getItemId();

        //响应菜单项
        if(id == R.id.small){
            textView.setTextSize(10);
        }
        if(id == R.id.middle){
            textView.setTextSize(16);
        }
        if(id == R.id.big){
            textView.setTextSize(20);
        }
        if (id == R.id.menuItem_2) {

            Toast.makeText(XML.this, "普通菜单项", Toast.LENGTH_SHORT).show();
            return true;
        }
        if(id == R.id.red){
            textView.setTextColor(Color.rgb(255, 0, 0));
        }
        if(id == R.id.black){
            textView.setTextColor(Color.rgb(0, 0, 0));
        }
        return super.onOptionsItemSelected(item);

    }



}
