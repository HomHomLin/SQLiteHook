package com.lhh.sqlitehook.core;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by linhonghong on 2015/8/14.
 */
public abstract class HookBase extends SQLiteOpenHelper {

    private final static String TAG = "HookBase";

    public HookBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public SQLiteDatabase openReadableDB() {
        return getReadableDatabase();
    }

    public SQLiteDatabase openWritableDB() {
        return getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

    }


    public void onCreateTable(SQLiteDatabase db, String tableNmae) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
