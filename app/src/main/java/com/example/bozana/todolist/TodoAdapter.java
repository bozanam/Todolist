package com.example.bozana.todolist;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

import static java.lang.reflect.Array.getInt;

/**
 * Created by Bozana on 24-11-2017.
 */

public class TodoAdapter extends ResourceCursorAdapter {
    public TodoAdapter(Context context, Cursor cursor) {
        super(context, R.layout.row_todo, cursor);


    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView deTextview = view.findViewById(R.id.deTV);
        CheckBox deCheckbox = view.findViewById(R.id.deCB);
        String item = cursor.getString(1);
        String status = cursor.getString(3);
        deTextview.setText(item);
        if(status.equals("true")){
            deCheckbox.setChecked(true);
        }
        if (status.equals("false")){
            deCheckbox.setChecked(false);
        }

    }

    public void addItem(){

    }

}
