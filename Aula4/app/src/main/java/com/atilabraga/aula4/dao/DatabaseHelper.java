package com.atilabraga.aula4.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.atilabraga.aula4.dao.contract.TagContract.TagEntry;
import com.atilabraga.aula4.dao.contract.TaskContract.TaskEntry;
import com.atilabraga.aula4.dao.contract.TaskTagContract.TaskTagEntry;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by atilabraga on 10/17/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "todo_manager";

    private static final String CREATE_TABLE_TASK = "CREATE TABLE " + TaskEntry.TABLE_NAME + "("
            + TaskEntry.COLUMN_ID + " INTEGER PRIMARY KEY,"
            + TaskEntry.COLUMN_NAME + " TEXT,"
            + TaskEntry.COLUMN_PRIORITY + " INTEGER,"
            + TaskEntry.COLUMN_STATUS + " INTEGER,"
            + TaskEntry.COLUMN_CREATED_AT + " DATETIME"
            + ")";
    private static final String DELETE_TABLE_TODO =
            "DROP TABLE IF EXISTS " + TaskEntry.TABLE_NAME;

    private static final String CREATE_TABLE_TAG = "CREATE TABLE " + TagEntry.TABLE_NAME + "("
            + TagEntry.COLUMN_ID + " INTEGER PRIMARY KEY,"
            + TagEntry.COLUMN_NAME + " TEXT"
            + ")";
    private static final String DELETE_TABLE_TAG =
            "DROP TABLE IF EXISTS " + TagEntry.TABLE_NAME;

    private static final String CREATE_TABLE_TASK_TAG = "CREATE TABLE " + TaskTagEntry.TABLE_NAME + "("
            + TaskTagEntry.COLUMN_ID + " INTEGER PRIMARY KEY,"
            + TaskTagEntry.COLUMN_ID_TASK + " INTEGER,"
            + TaskTagEntry.COLUMN_ID_TAG + " INTEGER,"
            + TaskTagEntry.COLUMN_CREATED_AT + " DATETIME"
            + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TASK);
        db.execSQL(CREATE_TABLE_TAG);
        db.execSQL(CREATE_TABLE_TASK_TAG);

        ContentValues values = new ContentValues();
        values.put(TaskEntry.COLUMN_NAME, "Task One");
        db.insert(TaskEntry.TABLE_NAME, null, values);
        values = new ContentValues();
        values.put(TaskEntry.COLUMN_NAME, "Task Two");
        db.insert(TaskEntry.TABLE_NAME, null, values);
        values = new ContentValues();
        values.put(TaskEntry.COLUMN_NAME, "Task Three");
        db.insert(TaskEntry.TABLE_NAME, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DELETE_TABLE_TODO);
        db.execSQL(DELETE_TABLE_TAG);
        db.execSQL(CREATE_TABLE_TASK_TAG);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}
