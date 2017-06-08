package com.appmon.entermon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.Toast;


public class MovieActivity extends AppCompatActivity {
    private ListView listView = null;
    // private List<String> data = new ArrayList<String>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        List<Map<String, Object>> m_list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "G1");
        map.put("info", "google 1");
        map.put("img", R.drawable.jialebihaidao);
        m_list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "G2");
        map.put("info", "google 2");
        map.put("img", R.drawable.duolaameng);
        m_list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "G3");
        map.put("info", "google 3");
        map.put("img", R.drawable.meihaodeyiwai);
        m_list.add(map);
        SimpleAdapter adapter = new SimpleAdapter(MovieActivity.this,m_list,R.layout.new_item,
                new String[]{"title","info","img"},
                new int[]{R.id.title,R.id.info,R.id.img});
//        setListAdapter(adapter);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rg_group);
        final RadioButton rb_home = (RadioButton) findViewById(R.id.rb_home);
        rb_home.setChecked(true);
        final RadioButton rb_theatre = (RadioButton) findViewById(R.id.rb_theatre);
        final RadioButton rb_shop = (RadioButton) findViewById(R.id.rb_shop);
        final RadioButton rb_me = (RadioButton) findViewById(R.id.rb_me);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup RGroup, int i) {
                if (rb_home.getId() == i) {
                    Toast.makeText(MovieActivity.this, "moive", Toast.LENGTH_SHORT).show();
//                   Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show(); 
                }
                if (rb_theatre.getId() == i) {
//                    Toast.makeText(MovieActivity.this, "theatre", Toast.LENGTH_SHORT).show();
//                   Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show(); 
                    Intent intent = new Intent(MovieActivity.this, TheatreActivity.class);
                    startActivity(intent);
                }
                if (rb_shop.getId() == i) {
                    Toast.makeText(MovieActivity.this, "moive", Toast.LENGTH_SHORT).show();
//                   Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show(); 
                }
                if (rb_me.getId() == i) {
                    Intent intent = new Intent(MovieActivity.this, UserInfoActivity.class);
                    startActivity(intent);
//                   Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show(); 
                }


            }
        });
    }

//    private List<Map<String, Object>> getData() {
//        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("title", "G1");
//        map.put("info", "google 1");
//        map.put("img", R.drawable.jialebihaidao);
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("title", "G2");
//        map.put("info", "google 2");
//        map.put("img", R.drawable.duolaameng);
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("title", "G3");
//        map.put("info", "google 3");
//        map.put("img", R.drawable.meihaodeyiwai);
//        list.add(map);
//
//        return list;
//    }
}