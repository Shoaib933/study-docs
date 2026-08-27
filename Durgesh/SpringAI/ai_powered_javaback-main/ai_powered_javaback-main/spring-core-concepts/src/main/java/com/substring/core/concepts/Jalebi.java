package com.substring.core.concepts;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("jalebi1")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Jalebi  implements DisposableBean {
    public Jalebi(){
        System.out.println("creating jalebi");
    }

    public void eat(){
        System.out.println("you are eating jalebi.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroying jalebi");
    }
}
