package com.aaa.zk.mycat.service;

import com.aaa.zk.mycat.mapper.BookMapper;
import com.aaa.zk.mycat.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BookService
 * @Author 赵凯
 * @Date 2019/9/20 22:17}
 * @Version 1.0
 */
@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;

    /**
     * 添加book
     *
     * @param book
     * @return
     */
    public Map<String, Object> add(Book book) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        int i = bookMapper.insert(book);
        if (i > 0) {
            resultMap.put("code", 200);
        } else {
            resultMap.put("code", 400);
        }
        return resultMap;
    }

    /**
     * 查询全部
     *
     * @return
     */
    public Map<String, Object> selectAllBooks() {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<Book> bookList = bookMapper.selectAll();
        if (bookList.size() > 0) {
            resultMap.put("code", 200);
            resultMap.put("result", bookList);
        } else {
            resultMap.put("code", 404);
        }
        return resultMap;
    }

    /**
     * 通过id删除图书
     *
     * @param id
     * @return
     */
    public Map<String, Object> deleteBook(int id) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        int i = bookMapper.deleteByPrimaryKey(id);
        if (i > 0) {
            resultMap.put("code", 200);
        } else {
            resultMap.put("code", 404);
        }
        return resultMap;
    }

    /**
     * 通过id查找Book
     *
     * @param id
     * @return
     */
    public Map<String, Object> selectBookById(int id) {
        Map<String, Object> resutMap = new HashMap<String, Object>();
        Book book = bookMapper.selectByPrimaryKey(id);
        if (book != null) {
            resutMap.put("code", 200);
            resutMap.put("result", book);
        } else {
            resutMap.put("code", 404);
        }
        return resutMap;
    }

    /**
     * 修改图书
     *
     * @param book
     * @return
     */
    public Map<String, Object> update(Book book) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        int i = bookMapper.updateByPrimaryKey(book);
        if (i > 0) {
            resultMap.put("code", 200);
        } else {
            resultMap.put("code", 404);
        }
        return resultMap;
    }
}
