package com.example.homa.justsave;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Films extends AppCompatActivity {
    static String FileName = "films.txt";
  //  TextView text;
    ArrayList<String> array = new ArrayList<String>();
    ArrayList<String> arrayAdd = new ArrayList<String>();


    final String LOG_TAG = "myLogs";
    final String DIR_SD = "JustSave";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_films);

       // text = (TextView) findViewById(R.id.textView);





    }

    public void add(View view){
            Intent intent = new Intent(Films.this, add.class);
        //intent.putStringArrayListExtra("filmsArray",array);
            startActivity(intent);
    }
    public void change (View view){
        Intent intent = new Intent(Films.this, change.class);
        startActivity(intent);
    }
    public void refresh (View view){
        ListView listView = (ListView) findViewById(R.id.ListView);
        File();
        readFile();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, array);

        //присваиваем адаптер списку
        listView.setAdapter(adapter);
    }

    public void File(){

        // проверяем доступность SD
        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            Log.d(LOG_TAG, "SD-карта не доступна: " + Environment.getExternalStorageState());
            return;
        }
        // получаем путь к SD
        File sdPath = Environment.getExternalStorageDirectory();
        // добавляем свой каталог к пути
        sdPath = new File(sdPath.getAbsolutePath() + "/" + DIR_SD);
        // создаем каталог
        sdPath.mkdirs();
        // формируем объект File, который содержит путь к файлу
        File sdFile = new File(sdPath, FileName);
        try {
            // открываем поток для записи
            BufferedWriter bw = new BufferedWriter(new FileWriter(sdFile));
            // пишем данные
            //if()
            bw.write("1 films\n"+ "2 films\n" +"3 films");

            //дописываем добавленые данные если не пустые
            Intent intent = getIntent();
             arrayAdd  = intent.getStringArrayListExtra("filmsArrayAdd");
            //////////////////////////////////////////////
            bw.write(array.toString());
            // закрываем поток
            bw.close();
            Log.d(LOG_TAG, "Файл записан на SD: " + sdFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile() {
        // проверяем доступность SD
        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            Log.d(LOG_TAG, "SD-карта не доступна: " + Environment.getExternalStorageState());
            return;
        }
        // получаем путь к SD
        File sdPath = Environment.getExternalStorageDirectory();
        // добавляем свой каталог к пути
        sdPath = new File(sdPath.getAbsolutePath() + "/" + DIR_SD);
        // формируем объект File, который содержит путь к файлу
        File sdFile = new File(sdPath, FileName);
        try {
            // открываем поток для чтения
            BufferedReader br = new BufferedReader(new FileReader(sdFile));
            String str = "";
            // читаем содержимое и записываем в массив

            while ((str = br.readLine()) != null ) {
                array.add(str);
                Log.d(LOG_TAG, str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }





