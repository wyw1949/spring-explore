package com.yoke.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShowPrototype1 {
    @Autowired
    private PrototypeBean prototypeBean;

    public PrototypeBean getPrototypeBean() {
        return prototypeBean;
    }
}
