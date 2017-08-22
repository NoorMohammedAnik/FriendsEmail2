package com.noor.friendsemail;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Noor Mohammed on 18-Aug-2017.
 */

public class MySqliteDB extends SQLiteOpenHelper {


    private static final int DB_VERSION=1;
    private static final String DB_NAME="mydb.db";
    private static final String TABLE_NAME="mytable";

    private static final String COLUMN1="ID";
    private static final String COLUMN2="NAME";
    private static final String COLUMN3="EMAIL";

    public MySqliteDB(Context context) {
        super(context, DB_NAME,null,DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String query;
        query="CREATE TABLE "+TABLE_NAME +"(ID INTEGER PRIMARY KEY,NAME TEXT,EMAIL TEXT)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }


    public boolean addToTable(String ID,String NAME,String EMAIL)
    {
        SQLiteDatabase database=getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put(COLUMN1,ID);
        values.put(COLUMN2,NAME);
        values.put(COLUMN3,EMAIL);

        long chk=database.insert(TABLE_NAME,null,values);

        if (chk==-1)
        {
            return false;

        }
        else
            return true;
    }


    public Cursor display()
    {
        SQLiteDatabase database=getReadableDatabase();
        Cursor result;
        result=database.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return result;

    }


}
