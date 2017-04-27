package com.example.alice.homework;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {
    ImageView image;
    Toolbar d_toolbar;
    TextView date;
    TextView genre;
    Button btnAdd;
    EditText editDate;
    EditText editGenre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);


        image = (ImageView) findViewById(R.id.image);
        d_toolbar = (Toolbar) findViewById(R.id.toolbar);
        date = (TextView) findViewById(R.id.date);
        genre = (TextView) findViewById(R.id.genre);
        btnAdd = (Button) findViewById(R.id.setData);
        editDate = (EditText) findViewById(R.id.editDate);
        editGenre = (EditText) findViewById(R.id.editGenre);


//Через интент получаем строку-ключ с Названием фильма и записываем ее в переменную типа String
        String filmName = getIntent().getStringExtra("FilmName");

        //Передаем переменную с полученной строкой в Тулбар и устанавливаем там новый текст
        d_toolbar.setTitle(filmName);

        //Сравниваем названия в Тулбаре с желаемым названием фильма, если названия совпадают, то устанавливаем изображение ,дату выхода фильма и жанр фильма
        if (d_toolbar.getTitle().toString().equalsIgnoreCase("Seven")) {
            image.setImageDrawable(ContextCompat.getDrawable(DescriptionActivity.this, R.drawable.seven));
            date.setText("2000");
            genre.setText("Thriller,Detective");
        }

        if (d_toolbar.getTitle().toString().equalsIgnoreCase("Sleepy Hollow")) {

            image.setImageDrawable(ContextCompat.getDrawable(DescriptionActivity.this, R.drawable.sleepy_holl));
            date.setText("2000");
            genre.setText("Thriller,Horror");
        }

        if (d_toolbar.getTitle().toString().equalsIgnoreCase("House of Wax")) {
            image.setImageDrawable(ContextCompat.getDrawable(DescriptionActivity.this, R.drawable.h_of_wax));
            date.setText("2000");
            genre.setText("Horror");
        }

        if (d_toolbar.getTitle().toString().equalsIgnoreCase("From Hell")) {
            image.setImageDrawable(ContextCompat.getDrawable(DescriptionActivity.this, R.drawable.from_hell));
            date.setText("2000");
            genre.setText("Thriller,Horror");

        }


    }
}
//Тщетные попытки сохранить данные
  /*  public void addData(View view)
    {

                boolean isInserted =FilmDB.insertData(editDate.getText().toString(),
                        editGenre.getText().toString());
                if(isInserted==true)
                    Toast.makeText(DescriptionActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(DescriptionActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();


    }*/


   /* public void addGenre(View view) {
        EditText editText = (EditText) findViewById(R.id.editGenre);
        setGenre=editText.getText().toString();
        genre.setText(setGenre);
        saveGenre();
        editText.setText("");

    }*/

/*    public void saveDate()
    {
        sPref=getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed =sPref.edit();
        ed.putString(SAVED_TEXT1,date.getText().toString());
        ed.commit();
        //Toast.makeText(this."Changes are saved")
    }

    public void saveGenre()
    {
        sPref=getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed =sPref.edit();
        ed.putString(SAVED_TEXT2,genre.getText().toString());
        ed.commit();
        //Toast.makeText(this."Changes are saved")
    }

    void loadDateText()
    {
        sPref=getPreferences(MODE_PRIVATE);
        String savedText=sPref.getString(SAVED_TEXT1,"");
        date.setText(savedText);
}
    void loadGenreText()
    {
        sPref=getPreferences(MODE_PRIVATE);
        String savedText=sPref.getString(SAVED_TEXT2,"");
        genre.setText(savedText);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveDate();
        saveGenre();
    }*/




