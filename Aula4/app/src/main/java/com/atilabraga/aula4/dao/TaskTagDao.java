package com.atilabraga.aula4.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.atilabraga.aula4.dao.contract.TaskTagContract.TaskTagEntry;

/**
 * Created by atilabraga on 10/17/15.
 */
public class TaskTagDao {

    private DatabaseHelper dbHelper;
    private TaskTagDao taskTagDao;

    public TaskTagDao(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public long insert(int idTask, int idTag) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(TaskTagEntry.COLUMN_ID_TASK, idTask);
        contentValues.put(TaskTagEntry.COLUMN_ID_TAG, idTag);
        long id = db.insert(TaskTagEntry.TABLE_NAME, null, contentValues);

        return id;
    }

    public void close() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }
}
