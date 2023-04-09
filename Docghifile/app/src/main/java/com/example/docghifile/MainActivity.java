package com.example.docghifile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText ed_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_content = findViewById(R.id.ed_content);
    }
    public void SaveFile(View view){
        String noiDung = ed_content.getText().toString();
        String file_name = "vidu.txt";
        try{
            FileOutputStream fileOutputStream = openFileOutput(file_name, Context.MODE_PRIVATE);
            fileOutputStream.write(noiDung.getBytes());
            fileOutputStream.close();
            Toast.makeText(getBaseContext(), "Đã ghi vào file", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void ReadFile(View view){
        String file_name = "vidu.txt";
        StringBuffer stringBuffer = new StringBuffer();
        try{
            FileInputStream fileInputStream = openFileInput(file_name);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while((line = bufferedReader.readLine()) != null){
                stringBuffer.append(line);
            }
            Toast.makeText(getBaseContext(), stringBuffer.toString(), Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}