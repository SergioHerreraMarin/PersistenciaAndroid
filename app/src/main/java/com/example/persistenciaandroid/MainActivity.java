package com.example.persistenciaandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.OutputStream;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private EditText inputText;
    private TextView textView;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.editText);
        textView = findViewById(R.id.textCarregat);
        buttonSave = findViewById(R.id.buttonSave);

        textView.setText("Text: " + getData());

        String text = "File Saved";
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_LONG);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = inputText.getText().toString();
                saveData(data, toast);
            }
        });
    }
    
    private void saveData(String data, Toast toast){
        try{
            File path  = this.getFilesDir();
            File file = new File(path, "dades.txt");
            FileWriter writer = new FileWriter(file);
            writer.write(data);
            writer.flush();
            writer.close();
            toast.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private String getData(){

        String data = "";
        File path  = this.getFilesDir();
        File file = new File(path, "dades.txt");

        if(file.exists()){
            try{
                Scanner scanner = new Scanner(file);
                while(scanner.hasNext()){
                    data += scanner.nextLine();
                }

            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return data;
    }

}