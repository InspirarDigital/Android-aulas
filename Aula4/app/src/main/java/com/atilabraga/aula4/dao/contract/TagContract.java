package com.atilabraga.aula4.dao.contract;

import android.provider.BaseColumns;

/**
 * Created by atilabraga on 10/17/15.
 */
public final class TagContract {

    public TagContract() {}

    public static abstract class TagEntry implements BaseColumns {
        public static final String TABLE_NAME = "tag";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
    }

}
