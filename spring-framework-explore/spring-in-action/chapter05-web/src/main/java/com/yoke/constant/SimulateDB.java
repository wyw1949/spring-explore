package com.yoke.constant;

import com.yoke.model.Spitter;
import com.yoke.model.Spittle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class SimulateDB {

    public static AtomicLong id = new AtomicLong(0);

    public static List<Spitter> table_spitter = Collections.synchronizedList(new ArrayList<Spitter>());

    public static List<Spittle> table_spittle = Collections.synchronizedList(new ArrayList<Spittle>());

    static {
        Spittle spittle = new Spittle(0L, "spittle_1", new Date(), 0.0, 0.0);
        table_spittle.add(spittle);
    }

}
