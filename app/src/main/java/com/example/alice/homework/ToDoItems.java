package com.example.alice.homework;

/**
 * Created by AliceP on 25.02.2017.
 */

public class ToDoItems {
     String name;
     boolean isChecked;


//Конструктор кастомного класса

    public ToDoItems(String name,boolean isChecked) {
        this.name = name;
        this.isChecked = isChecked;

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getChecked() {
        return isChecked;
    }
    public void setChecked(boolean checked) {
        isChecked = checked;
    }


}
