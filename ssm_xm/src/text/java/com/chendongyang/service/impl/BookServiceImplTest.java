package com.chendongyang.service.impl;

import com.chendongyang.SpringBaseTest;
import com.chendongyang.model.Book;
import com.chendongyang.service.BookService;
import com.chendongyang.util.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class BookServiceImplTest extends SpringBaseTest {
    @Autowired
    private BookService bookService;
    @Test
    public void insert() {
        book.setBid(1);
        book.setBname("刘狗");
        book.setPrice(78f);
        this.bookService.insert(book);
    }

    @Test
    public void selectByPrimaryKey() {
        System.out.println(bookService.selectByPrimaryKey(5));
    }

    @Test
    public void aaaa() {
        Map map=new HashMap();
        map.put("bname", StringUtils.toLikesStr("圣墟"));
        List<Map> aaaa = this.bookService.aaaa(map, pageBean);
        for (Map m : aaaa) {
            System.out.println(m);
        }
    }

    @Test
    public void listPager() {
        Map map=new HashMap();
        map.put("bname", StringUtils.toLikesStr("圣墟"));
        pageBean.setPage(3);
        List<Map> aaaa = this.bookService.listPager(map, pageBean);
        for (Map m : aaaa) {
            System.out.println(m);
        }
    }

    @Test
    public void testCacheOne() {
        System.out.println(bookService.selectByPrimaryKey(5));
        System.out.println(bookService.selectByPrimaryKey(5));
    }

    @Test
    public void testCacheMany() {
        Map map=new HashMap();
        map.put("bname", StringUtils.toLikesStr("圣墟"));
        pageBean.setPage(3);
        List<Map> aaaa = this.bookService.listPager(map, pageBean);
        for (Map m : aaaa) {
            System.out.println(m);
        }
        List<Map> aaaa2 = this.bookService.listPager(map, pageBean);
        for (Map m : aaaa2) {
            System.out.println(m);
        }
    }
}