package com.github.florent37.materialviewpager.sample;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {

    EditText id, password;
    String i, p;
    ProgressDialog progressDialog;
    private final int SUCCESS = 0;
    private final int FAIL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        id = (EditText) findViewById(R.id.id);
        password = (EditText) findViewById(R.id.password);

        id.setTextColor(Color.BLACK);
        password.setTextColor(Color.BLACK);
    }

    //버튼 이벤트
    public void myClick(View view) {
        i = id.getText().toString();
        p = password.getText().toString();

        if (i.length() == 0 || p.length() == 0) {
            Toast.makeText(this, "데이터를 입력해주세요", Toast.LENGTH_SHORT).show();
            return;
        }else{
            progressDialog = ProgressDialog.show(this, "Wait", "Download...");
            SendThread thread = new SendThread();
            thread.start();
        }
    }

    class SendThread extends Thread {
        String address = "http://192.168.0.14:8888/spring/login?email=" + i + "&password=" + p;

        // 주소, URL 객체
        public void run() {
            try {
                URL url = new URL(address);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                StringBuilder sb = new StringBuilder();

                if (conn != null) {
                    conn.setRequestMethod("GET");
                    conn.setRequestProperty("dataType", "jason");
                    conn.setConnectTimeout(1000);
                    if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {

                        InputStreamReader in = new InputStreamReader(conn.getInputStream());
                        int ch;
                        while ((ch = in.read()) != -1) {
                            sb.append((char) ch);
                        }
                        if (sb.toString().equals("SUCCESS")) {
                            handler.sendEmptyMessage(SUCCESS);
                            Intent i = new Intent(getApplicationContext(),MainActivity.class);
                            //Intent를 선언하여 생성을 하고, SecondActivity를 지정해주고
                            startActivity(i);
                        } else {
                            handler.sendEmptyMessage(FAIL);
                        }
                        in.close();
                    }
                }
                conn.disconnect();
            } catch (Exception e) {

            }
        }
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            progressDialog.dismiss();
            if(msg.what==SUCCESS){
                Toast.makeText(LoginActivity.this, i+"님 환영합니다.", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(LoginActivity.this, "아이디나 바밀번호가 잘못되었습니다.", Toast.LENGTH_SHORT).show();
            }
        }
    };
}
