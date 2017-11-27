package com.example.bozana.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;
import android.widget.ResourceCursorAdapter;

/**
 * Created by Bozana on 20-11-2017.
 */

public class TodoDatabase extends SQLiteOpenHelper {
    private TodoDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    Cursor dbiets;


    private static TodoDatabase instance;

    public static TodoDatabase getInstance(Context context) {

        if (instance == null) {
            instance = new TodoDatabase(context, "tododb", null, 2);
        }
        return instance;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table todos (id INTEGER PRIMARY KEY, title TEXT, completed TEXT);");

        ContentValues cv = new ContentValues();
        ContentValues cv2 = new ContentValues();
        ContentValues cv3 = new ContentValues();

        cv.put("title", "boodschappen doen");
        cv.put("completed", "false");
        cv2.put("title", "kamer opruimen");
        cv2.put("completed", "false");
        cv3.put("title", "MAM afkijken");
        cv3.put("completed", "true");

        db.insert("todos", null, cv);
        db.insert("todos", null, cv2);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "todos" );
        onCreate(db);
    }

    public Cursor selectAll() {

        return dbiets = getWritableDatabase().rawQuery("SELECT * FROM todos", new String[]{});

    }

    public void insert(String title, String completed){
       ContentValues ConVal = new ContentValues();

       ConVal.put("title", title);
       ConVal.put("completed", completed);
       getWritableDatabase().insert("todos", null, ConVal);
    }

    public long update(long id, String status){
        

    }
}
