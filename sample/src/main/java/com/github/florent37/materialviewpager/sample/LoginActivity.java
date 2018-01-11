package com.github.florent37.materialviewpager.sample;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.InputMismatchException;

public class LoginActivity extends AppCompatActivity {

    EditText id, password;
    TextView idText;
    int i;
    String p;
    String user;
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

        changeView();
    }

    //로그인뷰 이벤트
    public void changeView(){
        idText = (TextView)findViewById(R.id.idText);
        id = (EditText)findViewById(R.id.id);
        id.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN){
                    Log.v("유저네임텍스트 사이즈", idText.getTextSize()+"");
                }

                return false;
            }
        });
    }

    //버튼 이벤트
    public void myClick(View view) {
        try {
            i = Integer.parseInt(id.getText().toString());
        }catch (Exception e){
            Toast.makeText(this, "아이디는 사원번호입니다", Toast.LENGTH_SHORT).show();
        }

        p = password.getText().toString();

        if (id.getText().toString().length() == 0 || p.length() == 0) {
            Toast.makeText(this, "아이디와 비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();
            return;
        } else {
            progressDialog = ProgressDialog.show(this, "Wait", "Download...");
            SendThread thread = new SendThread();
            thread.start();
        }
    }

    class SendThread extends Thread {
        String address = "http://203.233.199.126:8811/www/loginAndroid?staff_code=" + i + "&staff_password=" + p;

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
                        if (sb.toString().substring(0, 7).equals("SUCCESS")) {
                            user = sb.toString().substring(7, sb.length());
                            Log.v("로그인 성공", sb.toString().substring(7, sb.length())+"");
                            handler.sendEmptyMessage(SUCCESS);
                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            //Intent를 선언하여 생성을 하고, SecondActivity를 지정해주고
                            startActivity(i);
                            finish();
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
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.v("메세지1", "====>"+user+"");
            //String code = msg.toString().substring(0,6);
            progressDialog.dismiss();
            if (msg.what == SUCCESS) {
                Toast.makeText(LoginActivity.this, user+"님이 접속되었습니다", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(LoginActivity.this, "아이디나 비밀번호가 잘못되었습니다", Toast.LENGTH_SHORT).show();
            }
        }
    };
}
