package com.ex.tests.entities;

import com.ex.yummy.entities.Doop;
import com.ex.yummy.services.FunSearchOne;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath*:applicationContext.xml")
public class FunSearchTests {

    private FunSearchOne serv;

    @Before
    public void init(){
        serv = new FunSearchOne();
        serv.setSauces(6);
        serv.setSides(7);
    }

    @Test
    public void showMe() {
        ArrayList<Integer> giggle = serv.getFourRando(6);
        System.out.println(giggle.get(0));
        System.out.println(giggle.get(1));
        System.out.println(giggle.get(2));
        System.out.println(giggle.get(3));
    }

}