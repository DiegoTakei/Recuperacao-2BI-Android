package com.example.diegotakei.broadcastreceiver;

import android.content.ContentProvider;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Diego Takei on 23/11/2015.
 */
public class SQLHelper extends SQLiteOpenHelper {

    public static final String TB_AVALIACAO = "TB_AVALIACAO";

    public static final int VERSAO = 1;

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table usuario(_id " +
            "integer primary key autoincrement," +
            " avaliador text not null, titulo text not null, nota text not null, comentario text not null);";

    public SQLHelper(Context context) {

        super(context, TB_AVALIACAO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int arg1, int arg2) {
        bd.execSQL("drop table usuario;");
        onCreate(bd);
    }
}
