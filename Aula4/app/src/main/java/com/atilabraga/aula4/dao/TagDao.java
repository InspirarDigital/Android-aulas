package com.atilabraga.aula4.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.atilabraga.aula4.dao.contract.TagContract.TagEntry;
import com.atilabraga.aula4.model.Tag;
import com.atilabraga.aula4.model.Task;

/**
 * Created by atilabraga on 10/17/15.
 */
public class TagDao {

    private DatabaseHelper dbHelper;
    private TaskTagDao taskTagDao;

    public TagDao(Context context) {
        dbHelper = new DatabaseHelper(context);
        taskTagDao = new TaskTagDao(context);
    }

    public long insert(Tag tag) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TagEntry.COLUMN_NAME, tag.getName());
        long id = db.insert(TagEntry.TABLE_NAME, null, values);

        for (Task task : tag.getTaskList()) {
            taskTagDao.insert(task.getId(), (int) id);
        }

        return id;
    }

    public void close() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }
}
