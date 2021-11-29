package com.tuanmhoang.bdd.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class OrderHooks {

    @Before
    public void runBefore(){
        System.out.println("Before test...");
    }

    @After
    public void runAfter(){
        System.out.println("After test...");
    }
}
