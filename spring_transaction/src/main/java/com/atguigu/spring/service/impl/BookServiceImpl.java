package com.atguigu.spring.service.impl;

import com.atguigu.spring.dao.BookDao;
import com.atguigu.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public void buyBook(Integer userId, Integer bookId) {
        //查询图书的价格
        Integer price = bookDao.getPriceByBookId(bookId);

        //更新图书的库存
        bookDao.updateStock(1);

        //更新用户的余额
        bookDao.updateBalance(userId,price);
    }
}
