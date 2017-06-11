package com.appmon.entermon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class TheatreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        List<Map<String, Object>> t_list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "星美国际影城(奥园广场店)");
        map.put("info", "番禺区桥南街福德路281号奥园广场3-4楼（长堤路");
        t_list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "UUE国际影城(番禺易发店)");
        map.put("info", "番禺区繁华路57号");
        t_list.add(map);

        SimpleAdapter adapter = new SimpleAdapter(TheatreActivity.this, t_list, R.layout.theatre_item,
                new String[]{"title", "info"}, new int[]{R.id.theatre_name, R.id.theatre_address}
        );
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);


        final RadioButton rb_theatre = (RadioButton) findViewById(R.id.rb_theatre);
        rb_theatre.setChecked(true);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rg_group);
        final RadioButton rb_home = (RadioButton) findViewById(R.id.rb_home);
//        final RadioButton rb_theatre = (RadioButton) findViewById(R.id.rb_theatre);
        final RadioButton rb_shop = (RadioButton) findViewById(R.id.rb_shop);
        final RadioButton rb_me = (RadioButton) findViewById(R.id.rb_me);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup RGroup, int i) {
                if (rb_home.getId() == i) {
//                    Toast.makeText(TheatreActivity.this, "moive", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(TheatreActivity.this, MovieActivity.class);
                    startActivity(intent);
//                   Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show(); 
                }
                if (rb_shop.getId() == i) {
                    Toast.makeText(TheatreActivity.this, "moive", Toast.LENGTH_SHORT).show();
//                   Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show(); 
                }
                if (rb_me.getId() == i) {
//                    Toast.makeText(TheatreActivity.this, "moive", Toast.LENGTH_SHORT).show();
//                   Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show(); 
                    Intent intent = new Intent(TheatreActivity.this, UserInfoActivity.class);
                    startActivity(intent);
                }


            }
        });
    }
}
