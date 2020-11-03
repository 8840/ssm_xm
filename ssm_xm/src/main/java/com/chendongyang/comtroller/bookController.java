package com.chendongyang.comtroller;

import com.chendongyang.model.Book;
import com.chendongyang.service.BookService;
import com.chendongyang.util.PageBean;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/book")
public class bookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/list")
    public String list(Book book, HttpServletRequest req){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(req);
        List<Book> books=this.bookService.springPager(book,pageBean);
        req.setAttribute("bookList",books);
        req.setAttribute("pageBean",pageBean);
        return "bookList";
    }
    @RequestMapping("/preSave")
    public String preSave(Book book, HttpServletRequest req){
        if(book!=null&& book.getBid()!=null&& book.getBid()!=0){
            Book b = this.bookService.selectByPrimaryKey(book.getBid());
            req.setAttribute("book2",b);
        }
        return "bookEdit";
    }
    @RequestMapping("/add")
    public String add(Book book, HttpServletRequest req){
        this.bookService.insert(book);
        return "redirect:/book/list";
    }
    @RequestMapping("/edit")
    public String edit(Book book, HttpServletRequest req){
        this.bookService.updateByPrimaryKeySelective(book);
        return "redirect:/book/list";
    }
    @RequestMapping("/del/{bid}")
    public String del(@PathVariable("bid") Integer bid, HttpServletRequest req){
        this.bookService.deleteByPrimaryKey(bid);
        return "redirect:/book/list";
    }

    /**
     *文件上传的方法
     * @param xxx
     * @param req
     * @return
     */
    @RequestMapping("/upload")
    public String upload(HttpServletRequest req, MultipartFile xxx){
        String fileName = xxx.getOriginalFilename();
        String contentType=xxx.getContentType();
        try {
            FileUtils.copyInputStreamToFile(xxx.getInputStream(),new File("G:/cs/"+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/book/list";
    }
}
