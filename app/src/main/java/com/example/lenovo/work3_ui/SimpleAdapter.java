package com.example.lenovo.work3_ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleAdapter extends AppCompatActivity {

    //用三个数组装载数据

    private String[] names = new String[]{"Lion", "Tiger", "Monkey","Dog","Cat","Elephant"};

    private int[] imgIds = new int[]{R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.simple_adapter);


       /* final String[] list = ItemData.getmDataList();

        List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();

        data = ItemData.getDataLIst("item_tv","iv");*/

        final List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < names.length; i++) {

            Map<String, Object> showitem = new HashMap<String, Object>();

            showitem.put("touxiang", imgIds[i]);

            showitem.put("name", names[i]);

            listitem.add(showitem);

        }



        //创建一个simpleAdapter

        android.widget.SimpleAdapter myAdapter = new android.widget.SimpleAdapter(SimpleAdapter.this,listitem, R.layout.simple_adapter_1,new String[]{"touxiang","name"},

                new int[]{R.id.images,R.id.name});
        final ListView listView = (ListView)findViewById(R.id.mylist);
        listView.setAdapter(myAdapter);
     /*   SimpleAdapter adapter = new SimpleAdapter(this,listitem,R.layout.activity_main,new String[]{"name","images"},new int[]{R.id.name,R.id.images});
        listView.setAdapter(adapter);*/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Toast toast =Toast.makeText(SimpleAdapter.this,names[position],Toast.LENGTH_SHORT);

                toast.show();
            }

        });

    }

}
