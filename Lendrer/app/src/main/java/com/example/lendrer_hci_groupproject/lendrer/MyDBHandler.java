package com.example.lendrer_hci_groupproject.lendrer;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 10;
    private static final String DATABASE_NAME = "itemDB.db";
    public static final String TABLE_ITEMS = "items";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "itemName";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_DUEDATE = "dueDate";
    public static final String COLUMN_LENTTO= "lentTo";

    //We need to pass database information along to superclass
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_ITEMS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_DATE + " TEXT, " +
                COLUMN_DUEDATE + " TEXT, " +
                COLUMN_LENTTO + " TEXT " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
        onCreate(db);
    }

    //Add a new row to the database
    public void addItem(Item item){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, item.get_name());
        values.put(COLUMN_DATE, item.get_date());
        values.put(COLUMN_DUEDATE, item.get_dueDate());
        values.put(COLUMN_LENTTO, item.get_lentTo());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_ITEMS, null, values);
        db.close();
    }

    //Delete a item from the database
    public void deleteItem(String itemName){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_ITEMS + " WHERE " + COLUMN_NAME + "=\"" + itemName + "\";");
    }

    //I used this for testing..
    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_ITEMS + " WHERE 1";

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("itemName")) != null) {
                dbString += c.getString(c.getColumnIndex("itemName"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }

    //creates an array with the item name
    public String[] databaseToArray(){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_ITEMS + " WHERE 1";

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);

        //Move to the first row in your results
        c.moveToFirst();

        //create a string the size of the table
        String[] items =  new String[c.getCount()];

        //Fill the array with the name of the item
        int i = 0;
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("itemName")) != null) {
                items[i] = c.getString(c.getColumnIndex("itemName"));
                i++;
            }
            c.moveToNext();
        }
        db.close();

        return items;
    }

    public String[] databaseDateArray(){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_ITEMS + " WHERE 1";

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);

        //Move to the first row in your results
        c.moveToFirst();

        //create a string the size of the table
        String[] items =  new String[c.getCount()];

        //Fill the array with the name of the item
        int i = 0;
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("date")) != null) {
                items[i] = c.getString(c.getColumnIndex("date"));
                i++;
            }
            c.moveToNext();
        }
        db.close();

        return items;
    }

    public String[] databaseDueDateArray(){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_ITEMS + " WHERE 1";

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);

        //Move to the first row in your results
        c.moveToFirst();

        //create a string the size of the table
        String[] items =  new String[c.getCount()];

        //Fill the array with the name of the item
        int i = 0;
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("dueDate")) != null) {
                items[i] = c.getString(c.getColumnIndex("dueDate"));
                i++;
            }
            c.moveToNext();
        }
        db.close();

        return items;
    }

    public String[] databaseLentToArray(){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_ITEMS + " WHERE 1";

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);

        //Move to the first row in your results
        c.moveToFirst();

        //create a string the size of the table
        String[] items =  new String[c.getCount()];

        //Fill the array with the name of the item
        int i = 0;
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("lentTo")) != null) {
                items[i] = c.getString(c.getColumnIndex("lentTo"));
                i++;
            }
            c.moveToNext();
        }
        db.close();

        return items;
    }



}
