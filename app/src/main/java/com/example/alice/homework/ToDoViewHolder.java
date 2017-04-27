package com.example.alice.homework;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by AliceP on 12.03.2017.
 */

public class ToDoViewHolder {
     TextView nameTextView;
     CheckBox checkBox;
     Button removeButton;


   public ToDoViewHolder(TextView nameTextView, CheckBox checkBox, Button removeButton) {
        this.nameTextView = nameTextView;
        this.checkBox = checkBox;
        this.removeButton=removeButton;

    }


    public TextView getNameTextView() {
        return nameTextView;
    }

    public void setNameTextView(TextView nameTextView) {
        this.nameTextView = nameTextView;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public Button getRemoveButton() {
        return removeButton;
    }

    public void setRemoveButton(Button removeButton) {
        this.removeButton = removeButton;
    }
    

}

