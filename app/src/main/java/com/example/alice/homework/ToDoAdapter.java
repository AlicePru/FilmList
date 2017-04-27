package com.example.alice.homework;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AliceP on 23.02.2017..
 */

public class ToDoAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private final List<ToDoItems> list;

    public ToDoAdapter(Context context, List<ToDoItems> list) {
        this.list=list;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


//Получаем View для отображения,если он еще не существует,то создаем новый,а если он уже существует
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ToDoViewHolder viewHolder;
        View listView;
        if (convertView == null)
            listView=createView(parent,position);

        else
            listView = convertView;
        viewHolder = (ToDoViewHolder) listView.getTag();
        ToDoItems item = list.get(position);
        viewHolder.getNameTextView().setText(item.getName());
        viewHolder.getCheckBox().setChecked(item.isChecked);
        return listView;


    }

    //Создаем новый View
   private View createView(ViewGroup parent, int position) {
        View view = layoutInflater.inflate(R.layout.list_view_adapter, parent, false);
        TextView nameTextView = (TextView)view.findViewById(R.id.name);
        CheckBox checkBox = (CheckBox)view.findViewById(R.id.check);
        Button removeButton = (Button)view.findViewById(R.id.rem_film);
        Button shareButton =(Button)view.findViewById(R.id.share) ;

        removeButton.setTag(position);
        view.setTag(new ToDoViewHolder(nameTextView,  checkBox, removeButton));
       shareButton.setTag(position);
       view.setTag(new ToDoViewHolder(nameTextView,checkBox,shareButton));


        return view;
    }
}








