package com.chendongyang.mapper;

import com.chendongyang.model.Book;

import java.util.List;
import java.util.Map;

public interface BookMapper {
    int deleteByPrimaryKey(Integer bid);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Map> aaaa(Map map);

    List<Book> springPager(Book book);
}