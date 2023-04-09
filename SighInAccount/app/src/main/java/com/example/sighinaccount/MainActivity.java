package com.example.sighinaccount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    EditText ed_account,ed_password;
    CheckBox cb_ghinho;
    Button btn_dangnhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("user_account", Context.MODE_PRIVATE);
        ed_account = findViewById(R.id.ed_account);
        ed_password = findViewById(R.id.ed_password);
        cb_ghinho = (CheckBox) findViewById(R.id.cb_ghinho);
        btn_dangnhap = findViewById(R.id.btn_dangnhap);
        
        String user = sharedPreferences.getString("acccount","");
        String pass = sharedPreferences.getString("password","");
        if(!(user.equals("")  &&  pass.equals(""))) {
            ed_account.setText(user);
            ed_password.setText(pass);
            cb_ghinho.setChecked(true);
        }
    }
    public void SighIn(View view){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String account = ed_account.getText().toString();
        String password = ed_password.getText().toString();
        boolean ghinho = cb_ghinho.isChecked();
        if(account.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Không được để trống", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(!(account.equalsIgnoreCase("admin") && password.equalsIgnoreCase("123"))){
            Toast.makeText(this, "Thông tin tài khoản và mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
            return;
        }else if(ghinho == true){
            editor.putString("acccount",account);
            editor.putString("password",password);
            editor.commit();
            Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();

        }else if(ghinho == false){
            editor.putString("acccount",account);
            editor.commit();
            Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
        }


    }
}