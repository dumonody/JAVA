package com.duyanhan.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.duyanhan.bean.Books;
import com.duyanhan.dao.BooksDao;
import com.duyanhan.dbc.BaseDao;

public class BooksDaoImpl implements BooksDao{

	BaseDao bd = new BaseDao();

	@Override
	public Books findBookBybookid(int bookid) {
		Books book = null;
		String sql = "select * from books where bookid=?";
		List<Object> args = new ArrayList<Object>();
		args.add(bookid);
		book = (Books) bd.query(sql, args, Books.class).get(0);
		return book;
	}

	@Override
	public List<Books> findBookBybookname(String bookname) {
		List<Books> bookList = null;
		String sql = "select * from books where bookname=?";
		List<Object> args = new ArrayList<Object>();
		args.add(bookname);
		bookList = bd.query(sql, args, Books.class);
		return bookList;
	}

	@Override
	public List<Books> findBookByauthor(String author) {
		List<Books> bookList = null;
		String sql = "select * from books where author=?";
		List<Object> args = new ArrayList<Object>();
		args.add(author);
		bookList = bd.query(sql, args, Books.class);
		return bookList;
	}
}
