package com.atilabraga.aula4.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.atilabraga.aula4.dao.contract.TaskContract.TaskEntry;
import com.atilabraga.aula4.model.Tag;
import com.atilabraga.aula4.model.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by atilabraga on 10/17/15.
 */
public class TaskDao {

    private DatabaseHelper dbHelper;
    private TaskTagDao taskTagDao;

    public TaskDao(Context context) {
        dbHelper = new DatabaseHelper(context);
        taskTagDao = new TaskTagDao(context);
    }

    public void insert(String text) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(TaskEntry.COLUMN_NAME, text);
        db.insert(TaskEntry.TABLE_NAME, null, contentValues);
    }

    public long insert(Task task) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(TaskEntry.COLUMN_NAME, task.getName());
        contentValues.put(TaskEntry.COLUMN_PRIORITY, task.getPriority());
        contentValues.put(TaskEntry.COLUMN_STATUS, task.getStatus());
        contentValues.put(TaskEntry.COLUMN_CREATED_AT, System.currentTimeMillis());
        long id = db.insert(TaskEntry.TABLE_NAME, null, contentValues);

        for (Tag tag : task.getTagList()) {
            taskTagDao.insert((int) id, tag.getId());
        }

        return id;
    }

    public void remove(int todoId) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("todos", "_id = " + todoId, null);
    }

    public List<Task> getAll() {
        List<Task> tasks = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TaskEntry.TABLE_NAME, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                long itemId = cursor.getLong(cursor.getColumnIndexOrThrow(TaskEntry.COLUMN_ID));
                String itemName = cursor.getString(cursor.getColumnIndexOrThrow(TaskEntry.COLUMN_NAME));
                tasks.add(new Task((int) itemId, itemName));
            } while (cursor.moveToNext());
        }
        return tasks;
    }

    public void close() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }
}
