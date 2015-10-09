package com.lhh.sqlitehook.impl;

import android.database.sqlite.SQLiteDatabase;

import com.lhh.sqlitehook.obj.HookMap;
import com.lhh.sqlitehook.obj.HookObject;

/**
 * Created by linhonghong on 2015/8/14.
 */
public interface SQLiteHookInterface {
    public void createTable(String tableName, HookMap map) throws Exception;
    public void createTable(SQLiteDatabase db, String tableName, HookMap map) throws Exception;
}
