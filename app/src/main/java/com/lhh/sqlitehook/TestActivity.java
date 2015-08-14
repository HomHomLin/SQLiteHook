package com.lhh.sqlitehook;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.lhh.sqlitehook.helper.SQLiteHookHelper;
import com.lhh.sqlitehook.keys.HookKeys;
import com.lhh.sqlitehook.obj.HookMap;
import com.lhh.sqlitehook.obj.HookObject;


public class TestActivity extends ActionBarActivity {

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
