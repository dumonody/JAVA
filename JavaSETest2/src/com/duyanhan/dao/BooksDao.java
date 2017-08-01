package com.duyanhan.dao;

import java.util.List;

import com.duyanhan.bean.Books;

public interface BooksDao {

	/**
	 * 根据书号来搜索书
	 * @param bookid
	 * @return
	 */
	public Books findBookBybookid(int bookid);
	/**
	 * 根据书名来搜索书
	 * @param bookname
	 * @return
	 */
	public List<Books> findBookBybookname(String bookname);
	
	/**
	 * 根据作者来搜索书
	 * @param author
	 * @return
	 */
	public List<Books> findBookByauthor(String author);
}
