package com.ex.tests.entities;

import com.ex.yummy.entities.Doop;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath*:applicationContext.xml")
public class DoopTests {
    private Doop om;

    @Before
    public void init(){
        om = new Doop();
        om.setChinese(3);
    }

    @Test
    public void alwaysChinese() {
        Assert.assertEquals("not sure how", 1, om.doopSpit());

    }

}
