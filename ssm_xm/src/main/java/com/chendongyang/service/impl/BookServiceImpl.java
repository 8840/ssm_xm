package com.chendongyang.service.impl;

import com.chendongyang.mapper.BookMapper;
import com.chendongyang.model.Book;
import com.chendongyang.service.BookService;
import com.chendongyang.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public int deleteByPrimaryKey(Integer bid) {
        return bookMapper.deleteByPrimaryKey(bid);
    }

    @Override
    public int insert(Book record) {
        return bookMapper.insert(record);
    }

    @Override
    public int insertSelective(Book record) {
        return bookMapper.insertSelective(record);
    }

    @Override
    public Book selectByPrimaryKey(Integer bid) {
        return bookMapper.selectByPrimaryKey(bid);
    }

    @Override
    public int updateByPrimaryKeySelective(Book record) {
        return bookMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Book record) {
        return bookMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map> aaaa(Map map, PageBean pageBean) {
        return bookMapper.aaaa(map);
    }

    @Override
    public List<Map> listPager(Map map, PageBean pageBean) {
        return bookMapper.aaaa(map);
    }

    @Override
    public List<Book> springPager(Book book, PageBean pageBean) {
        return bookMapper.springPager(book);
    }

}
