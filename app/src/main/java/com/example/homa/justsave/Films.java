package com.example.homa.justsave;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
    //TextView text;
    ArrayList<String> array = new ArrayList<String>();
    ArrayList<String> arrayAdd = new ArrayList<String>();


    final String LOG_TAG = "myLogs";
    final String DIR_SD = "JustSave";
        String temp="";
    char[] ch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_films);

        //text = (TextView) findViewById(R.id.textView);


    }

    public void add(View view){
            Intent intent = new Intent(Films.this, add.class);
        //intent.putStringArrayListExtra("filmsArray",array);
            startActivity(intent);
    }

    public void refresh (View view){
        //очищаем данные массивов
        array.clear();
        arrayAdd.clear();

        ListView listView = (ListView) findViewById(R.id.ListView);
        File();
        readFile();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, array);

        //присваиваем адаптер списку
        listView.setAdapter(adapter);

//обработка нажатия на определенный пункт списка
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(Films.this, change.class);

                intent.putExtra("position",position);
                startActivity(intent);
            }
        });


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
        sdPath = new File(sdPath.getAbsolutePath() + "/" + DIR_SD );
        // создаем каталог
        sdPath.mkdirs();
        // формируем объект File, который содержит путь к файлу
        File sdFile = new File(sdPath, FileName);



        try {
            // открываем поток для записи
            BufferedWriter bw = new BufferedWriter(new FileWriter(sdFile, true));
            // пишем данные
           // bw.write("1 films\n"+ "2 films\n" +"3 films\n");

            //дописываем добавленые данные
            Intent intent = getIntent();
             arrayAdd  = intent.getStringArrayListExtra("filmsArrayAdd");
            //////////////////////////////////////////////
            temp = arrayAdd.toString();
            ch = temp.toCharArray();
            temp="";

                for (int i = 0; i < ch.length; i++) {

                    if(ch[i] == '[' || ch[i] == ']' || ch[i] == ','){
                        temp +=" ";}
                    else temp += ch[i];
                }
            bw.write(temp);

           // bw.write(arrayAdd.toString());

           /* for(int i = 0; i <Integer.valueOf(array.size()); i++){
                temp+=(array.get(i).toString()+"\n");
            }*/
            //bw.write(arrayAdd.toString());
           // bw.write(temp);
           // text.setText(temp );
            temp = "";
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
              //  Log.d(LOG_TAG, str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }





