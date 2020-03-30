package com.yoke.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class LookUpDIPrototype {

    /**
     * 方法签名符合：<public|protected> [abstract] <return-type> theMethodName()<{}|;>即可
     */
    @Lookup
    public PrototypeBean getPrototypeBean(){
        return null;
    }
}
