package com.example.baitapwebview2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    Button btn_addthongtin;
    WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sharedPreferences = getSharedPreferences("Thongtincanhan", Context.MODE_PRIVATE);

        WebView mWebView = findViewById(R.id.mWebview);
        mWebView.getSettings().setJavaScriptEnabled(true);
        final Activity activity = this;
        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                Log.d("zzzzzzzzz", "onProgressChanged: " + newProgress); // xem log tiến trình load
                super.onProgressChanged(view, newProgress);
            }
        });
        mWebView.setWebViewClient( new WebViewClient(){
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                Toast.makeText(activity, error.  getDescription(), Toast.LENGTH_SHORT).show();
            }
        });
        String hoTen = sharedPreferences.getString("hoTen","");
        String email = sharedPreferences.getString("email","");
        String sodienthoai = sharedPreferences.getString("sodienthoai","");
        String gioithieu =  sharedPreferences.getString("gioithieu","");
        String thongTin = " <h1  >Thông tin cá nhân </h1>\n" +
                "    <p> - Họ tên : " + hoTen + "</p>\n" +
                "    <p> - Email : " + email + "</p>\n" +
                "    <p> - Điện thoại : " + sodienthoai + "</p>\n" +
                "    <p> - Giới thiệu : " + gioithieu + " </p>";
        mWebView.loadData(thongTin,"text/html","utf-8");

    }
    }
