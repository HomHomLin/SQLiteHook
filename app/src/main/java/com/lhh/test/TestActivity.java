package com.lhh.test;

import android.app.Activity;
import android.os.Bundle;

import com.lhh.sqlitehook.helper.SQLiteHookHelper;
import com.lhh.sqlitehook.keys.HookKeys;
import com.lhh.sqlitehook.obj.HookMap;
import com.lhh.sqlitehook.obj.HookObject;


public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        SQLiteHookHelper helper = new SQLiteHookHelper(this,"test",2);
        HookMap map = new HookMap();
        HookObject obj = new HookObject();
        obj.mType = HookKeys.TYPE_TEXT;
        map.put("ts",obj);
        try {
            helper.createTable(helper.getWritableDatabase(),"test",map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
