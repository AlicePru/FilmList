package com.example.alice.homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeworkActivity extends AppCompatActivity {
  final List<ToDoItems> list = new ArrayList<>(Arrays.asList(
            new ToDoItems("Seven",false),
            new ToDoItems("Sleepy Hollow",false),
            new ToDoItems("House of Wax",false),
            new ToDoItems("From Hell",false)

    ));

    Database FilmDB;
    ToDoAdapter adapter;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hw);

        FilmDB = new Database(this);

        adapter = new ToDoAdapter(this, list);
        final ListView listView = (ListView) findViewById(R.id.Item);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        editText=(EditText) findViewById(R.id.film_name);


        //Задаем надпись на тулбаре
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.main_toolbar);
        toolbar.setTitle("My Film List");

        //Обработчик нажатия элемента и переход на новое активити
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                TextView tv = (TextView) view.findViewById(R.id.name);
                String filmName = tv.getText().toString();
                Intent intent = new Intent(HomeworkActivity.this, DescriptionActivity.class);
                intent.putExtra("FilmName", filmName);
                startActivity(intent);
            }
        });


    }



//Кнопка share - поделиться
    public void shareItem(View view) {
        Button button = (Button) view;
        int position = (int) button.getTag();
        String filmName = list.get(position).name;
        final Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(android.content.Intent.EXTRA_SUBJECT, "Homework");
        share.putExtra(Intent.EXTRA_TEXT, filmName + " - Great film,you should watch it");
        startActivity(Intent.createChooser(share, "Share via"));
    }
//Кнопка добавления нового жлемента в список
   public void addItem(View view) {
       String name = editText.getText().toString();
        //check = false;
        ToDoItems item = new ToDoItems(name, false);
        addData(item);
        list.add(item);
        editText.setText("");
        adapter.notifyDataSetChanged();
    }
//Добавление данных втаблицу...
    public void addData(ToDoItems item) {
        boolean isInserted = FilmDB.insertData(item);
        if (isInserted)
            Toast.makeText(HomeworkActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(HomeworkActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
    }
//Кнопка удаления элемента из списка
    public void deleteItem(View view) {
        Button button = (Button) view;
        int position = (int) button.getTag();
        list.remove(position);
        adapter.notifyDataSetChanged();
    }


}










