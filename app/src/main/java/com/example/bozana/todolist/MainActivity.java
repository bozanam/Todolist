package com.example.bozana.todolist;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText ed1 = findViewById(R.id.edInput);
    TodoDatabase db;
    Cursor cursor ;
    TodoAdapter adapter ;
    ListView theListView ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new TodoAdapter(getApplicationContext(), cursor);
        db  = TodoDatabase.getInstance(getApplicationContext());

        cursor = db.selectAll();
        theListView = findViewById(R.id.theListView);

        theListView.setAdapter(adapter);
    }

    private void updateData(){

        Cursor data = db.selectAll();
        adapter.swapCursor(data);

    }

    public void AddItem(View view) {
        String edInput = ed1.toString();
        db.insert(edInput, "false");
        updateData();
    }



    private class mylistener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }
    }



//
//    static class ViewHolder
//    {
//        TextView title;
//        CheckBox checked;
//        //ImageView changeRowStatus;
//    }


}
