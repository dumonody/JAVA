package com.duyanhan.test;

import java.util.List;

import com.duyanhan.bean.Books;
import com.duyanhan.dao.BooksDao;
import com.duyanhan.dao.impl.BooksDaoImpl;


/**
 * 第五题
 * @author Pro.Du
 *
 */
public class Test2 {

	public static void main(String[] args) {

		BooksDao bdi = new BooksDaoImpl();
		
		// 查询书号为15的图书
		Books book = bdi.findBookBybookid(15);
		System.out.println(book.toString());
		
		System.out.println("吾乃分割线--------------------");
		
		// 查询书名为"英雄联盟"的图书
		List<Books> list = bdi.findBookBybookname("英雄联盟");
		for(Books b : list)
		{
			System.out.println(b.toString());
		}
		
		System.out.println("吾乃分割线--------------------");
		
		// 查询作者为"duyanhan"的图书
		List<Books> list2 = bdi.findBookByauthor("duyanhan");
		for(Books b2 : list)
		{
			System.out.println(b2.toString());
		}
	}

}
