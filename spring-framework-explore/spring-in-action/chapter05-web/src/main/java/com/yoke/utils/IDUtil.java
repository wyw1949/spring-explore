package com.yoke.utils;

import com.yoke.constant.SimulateDB;

public class IDUtil {

    public static Long getId(){
        return SimulateDB.id.addAndGet(1);
    }
}
