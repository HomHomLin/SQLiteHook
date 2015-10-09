package com.lhh.sqlitehook.obj;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by linhonghong on 2015/8/14.
 */
public class HookMap implements Serializable {
    private HashMap<String, HookObject> mMap = null;

    public HookMap(){
        if(mMap == null){
            mMap = new HashMap<>();
        }
    }

    public void put(String key, HookObject type){
        mMap.put(key, type);
    }

    public HookObject get(String key){
        return mMap.get(key);
    }

    public void free(){
        if(mMap != null){
            mMap.clear();
            mMap = null;
        }
    }

    public HashMap<String,HookObject> getMap(){
        return mMap;
    }
}
