package com.lhh.sqlitehook.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

import com.lhh.sqlitehook.core.HookBase;
import com.lhh.sqlitehook.impl.SQLiteHookInterface;
import com.lhh.sqlitehook.obj.HookMap;
import com.lhh.sqlitehook.obj.HookObject;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by linhonghong on 2015/8/14.
 */
public class SQLiteHookHelper extends HookBase implements SQLiteHookInterface{

    public String mDbName = "";
    public int mVersion = 0;
    public Context mContext = null;

    public SQLiteHookHelper(Context context, String dbName, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbName, factory, version);
        mDbName = dbName;
        mVersion = version;
        mContext = context;
    }

    public SQLiteHookHelper(Context context, String dbName, int version) {
        this(context, dbName, null, version);
    }

    @Override
    public void createTable(String tableName, HookMap map) throws Exception {
        this.createTable(getWritableDatabase(), tableName, map);
    }

    @Override
    public void createTable(SQLiteDatabase db, String tableName, HookMap map) throws Exception {
        if (null != db && null != tableName) {
            String statement;
            statement = "CREATE  TABLE IF NOT EXISTS " + tableName + getTableCreateCMD(map);
            db.execSQL(statement);
        }
    }

//    private final static String TABLE_ITEMS = "(ID INTEGER PRIMARY KEY AUTOINCREMENT, displayname TEXT, " +
//            "type TEXT, name TEXT, " +
//            "cover TEXT, targetkey TEXT, onlinecount TEXT, " +
//            "creator TEXT, url TEXT, data BLOB, pos TEXT);";

    /**
     * create table by cmd
     * @param map
     * @return
     * @throws Exception
     */
    public String getTableCreateCMD(HookMap map) throws Exception{
        String cmd = "";
        Iterator iter = map.getMap().entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            String key = entry.getKey().toString();
            HookObject hookObject = (HookObject)entry.getValue();
            if(TextUtils.isEmpty(key)  || TextUtils.isEmpty(hookObject.mType)){
                throw new Exception("the values is not allow null");
            }

            if(TextUtils.isEmpty(hookObject.mExtra)){
                cmd = cmd + key + " " + hookObject.mType;
            }else {
                cmd = cmd + key + " " + hookObject.mType + " " + hookObject.mExtra;
            }

            if(iter.hasNext()){
                //if has next, add ","
                cmd = cmd + ",";
            }
        }

        cmd = "(" + cmd + ");";
        return cmd;
    }

}
