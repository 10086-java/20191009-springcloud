package com.aaa.zk.mycat.controller;

import com.aaa.zk.mycat.model.Book;
import com.aaa.zk.mycat.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @ClassName BookController
 * @Author 赵凯
 * @Date 2019/9/20 22:19}
 * @Version 1.0
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;


    /**
     * 跳添加页面
     *
     * @return
     */
    @RequestMapping("/toAdd")
    public String toAdd() {
        return "book_add";
    }


    /**
     * 添加
     *
     * @param book
     * @return
     */
    @RequestMapping("/addBook")
    public String addBook(Book book) {
        Map<String, Object> resultMap = bookService.add(book);
        if ((Integer) resultMap.get("code") == 200) {
            return "redirect:/indexPage";
        } else {
            return "404";
        }
    }

    /**
     * 查询全部
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/indexPage")
    public String indexPage(ModelMap modelMap) {
        Map<String, Object> resultMap = bookService.selectAllBooks();
        if ((Integer) resultMap.get("code") == 200) {
            List<Book> bookList = (List<Book>) resultMap.get("result");
            modelMap.addAttribute("bookList", bookList);
            return "index";
        }
        return "404";
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public String delete(int id) {
        Map<String, Object> resultMap = bookService.deleteBook(id);
        if ((Integer) resultMap.get("code") == 200) {
            return "redirect:/indexPage";
        }
        return "404";
    }


    /**
     * 通过id查找
     *
     * @param modelMap
     * @param id
     * @return
     */
    @RequestMapping("/selectBookById")
    public String selectBookById(ModelMap modelMap, int id) {
        Map<String, Object> resultMap = bookService.selectBookById(id);
        if ((Integer) resultMap.get("code") == 200) {
            Book update = (Book) resultMap.get("result");
            modelMap.addAttribute("update", update);
            return "book_update";
        }
        return "404";
    }

    /**
     * 修改
     *
     * @param book
     * @return
     */
    @RequestMapping("/updateBook")
    public String updateBook(Book book) {
        Map<String, Object> resultMap = bookService.update(book);
        if ((Integer) resultMap.get("code") == 200) {
            return "redirect:/indexPage";
        } else {
            return "404";
        }
    }
}
