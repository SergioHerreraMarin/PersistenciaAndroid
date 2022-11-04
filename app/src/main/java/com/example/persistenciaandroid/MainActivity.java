package com.example.persistenciaandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileWriter;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    private EditText inputText;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.editText);
        buttonSave = findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = inputText.getText().toString();
                saveData(data);
            }
        });

    }


    private void saveData(String data){
        try{

            File path  = this.getFilesDir();
            File file = new File(path, "dades.txt");
            FileWriter writer = new FileWriter(file);
            writer.write(data);
            writer.flush();
            writer.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private String getData(){

        return null;

    }

}