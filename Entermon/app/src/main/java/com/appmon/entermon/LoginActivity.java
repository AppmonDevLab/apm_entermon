package com.appmon.entermon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TableRow;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final Button Reg = (Button) findViewById(R.id.register_button);
        final Button Login = (Button) findViewById(R.id.login_button);
        final TableRow t = (TableRow) findViewById(R.id.verify_row);
        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);
        EditText verify_pass = (EditText) findViewById(R.id.verify_password);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MovieActivity.class);
                startActivity(intent);
            }
        });
        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Reg.getText().equals("注册")) {
                    t.setVisibility(View.VISIBLE);
                    Login.setVisibility(View.GONE);
                    Reg.setText("确认");
                } else {
                    Intent intent = new Intent(LoginActivity.this, MovieActivity.class);
                    Reg.setText("注册");
                    t.setVisibility(View.GONE);
                    Login.setVisibility(View.VISIBLE);
                    startActivity(intent);
                }
            }
        });
    }
}
