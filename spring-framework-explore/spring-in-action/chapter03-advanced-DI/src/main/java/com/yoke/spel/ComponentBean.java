package com.yoke.spel;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ComponentBean {

    private Map<String, String> map = new HashMap<String, String>();

    {
        map.put("name", "Tom");
    }

    public Integer sum(Integer integer){
        Integer sum = 0;
        for (Integer i = 1; i <= integer; i++){
            sum += i;
        }
        return sum;
    }

    public Map<String, String> getMap() {
        return map;
    }
}
