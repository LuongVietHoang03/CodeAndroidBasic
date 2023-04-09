package com.example.slide4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.img_shared);
        imageView.setImageURI((Uri) getIntent().getExtras().get(Intent.EXTRA_STREAM));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_option, menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.m_add1:
                Toast.makeText(this, "Chọn dấu X", Toast.LENGTH_SHORT).show();
                break;
            case R.id.m_add2:
                Toast.makeText(this, "Chọn thêm 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.m_add3:
                Toast.makeText(this, "Chọn thêm 3", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}