package com.appmon.entermon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        ListView listView = (ListView) findViewById(R.id.history);
        List<Map<String, Object>> u_list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "神奇女侠");
        map.put("date", "昨晚19:30");
        u_list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "摔跤吧！爸爸");
        map.put("date", "前天");
        u_list.add(map);
//        listView.setAdapter(new ArrayAdapter<String>(this, R.layout.activity_user_in_fo_, getData()));
//        setContentView(listView);
        SimpleAdapter simpleAdapter = new SimpleAdapter(UserInfoActivity.this, u_list, R.layout.theatre_item,
                new String[] {"name", "date"}, new int[] {R.id.theatre_name, R.id.theatre_address}
        );
        listView.setAdapter(simpleAdapter);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.u_group);
        final RadioButton u_home = (RadioButton) findViewById(R.id.u_home);
        final RadioButton u_theatre = (RadioButton) findViewById(R.id.u_theatre);
        final RadioButton u_shop = (RadioButton) findViewById(R.id.u_shop);
        final RadioButton u_me = (RadioButton) findViewById(R.id.u_me);
        u_me.setChecked(true);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup RGroup, int i) {
                if (u_home.getId() == i) {
                    Intent intent = new Intent(UserInfoActivity.this, MovieActivity.class);
                    startActivity(intent);
                }
                if (u_theatre.getId() == i) {
//                    Toast.makeText(MovieActivity.this, "theatre", Toast.LENGTH_SHORT).show();
//                   Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show(); 
                    Intent intent = new Intent(UserInfoActivity.this, TheatreActivity.class);
                    startActivity(intent);
                }
                if (u_shop.getId() == i) {
//                    Toast.makeText(MovieActivity.this, "moive", Toast.LENGTH_SHORT).show();
//                   Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show(); 
                }
                if (u_me.getId() == i) {
//                    Intent intent = new Intent(UserInFo_Activity.this, UserInFo_Activity.class);
//                    startActivity(intent);
//                   Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show(); 
                }


            }
        });
    }

}