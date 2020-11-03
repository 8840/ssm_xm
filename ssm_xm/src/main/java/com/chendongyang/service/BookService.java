package com.chendongyang.service;

import com.chendongyang.model.Book;
import com.chendongyang.util.PageBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BookService {
    int deleteByPrimaryKey(Integer bid);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Map> aaaa(Map map, PageBean pageBean);

    List<Map> listPager(Map map, PageBean pageBean);

    List<Book> springPager(Book book, PageBean pageBean);

}
