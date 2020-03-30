package com.yoke.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShowSingleton1 {
    @Autowired
    private SingletonBean singletonBean;

    public SingletonBean getSingletonBean() {
        return singletonBean;
    }
}
