package com.atilabraga.aula4.dao.contract;

import android.provider.BaseColumns;

/**
 * Created by atilabraga on 10/17/15.
 */
public final class TaskTagContract {

    public TaskTagContract() {}

    public static abstract class TaskTagEntry implements BaseColumns {
        public static final String TABLE_NAME = "todo_tag";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_ID_TASK = "id_task";
        public static final String COLUMN_ID_TAG = "id_tag";
        public static final String COLUMN_CREATED_AT = "created_at";
    }
}
