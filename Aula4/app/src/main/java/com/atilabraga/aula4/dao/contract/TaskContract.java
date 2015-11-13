package com.atilabraga.aula4.dao.contract;

import android.provider.BaseColumns;

/**
 * Created by atilabraga on 10/17/15.
 */
public final class TaskContract {

    public TaskContract() {}

    public static abstract class TaskEntry implements BaseColumns {
        public static final String TABLE_NAME = "task";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PRIORITY = "priority";
        public static final String COLUMN_STATUS = "status";
        public static final String COLUMN_CREATED_AT = "created_at";
    }
}
