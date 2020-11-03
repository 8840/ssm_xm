package com.chendongyang;

import com.chendongyang.model.Book;
import com.chendongyang.util.PageBean;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class SpringBaseTest {
    protected Book book;
    protected PageBean pageBean;

    @Before
    public void init(){
        book =new Book();
        pageBean =new PageBean();
    }
}
