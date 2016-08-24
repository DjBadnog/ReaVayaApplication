package com.example.abnn965.reavayaapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ABNN965 on 8/24/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ReaVaya.db";

    public static final String TABLE_NAME = "customer_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SURNAME";
    public static final String COL_4 = "CELL_NUMBER";
    public static final String COL_5 = "ACCOUNT_NUMBER";
    public static final String COL_6 = "PASSWORD";
    public static final String COL_7 = "EMAIL";

    public static final String TABLE_NAME2 = "account_table";
    public static final String TCOL_1 = "ID";
    public static final String TCOL_2 = "ACCOUNT_NUMBER";
    public static final String TCOL_3 = "ACCOUNT_BALANCE";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+ TABLE_NAME + "( ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, SURNAME TEXT, CELL_NUMBER TEXT, ACCOUNT_NUMBER INTEGER, PASSWORD TEXT, EMAIL TEXT)" );
        db.execSQL("create table "+ TABLE_NAME2 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, ACCOUNT_NUMBER INTEGER, ACCOUNT_BALANCE DOUBLE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXIST" + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXIST" + TABLE_NAME2);
        onCreate(db);
    }

    public boolean insertCustomerDetails(String name, String surname, String cellNumber, String accountNumber, String postalAddress, String email){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2, name);
        contentValues.put(COL_3, surname);
        contentValues.put(COL_4, cellNumber);
        contentValues.put(COL_5, accountNumber);
        contentValues.put(COL_6, postalAddress);
        contentValues.put(COL_7, email);

        long results = db.insert(TABLE_NAME, null, contentValues);

        if (results == -1){
            return false;
        }else{
            return true;
        }
    }
}
