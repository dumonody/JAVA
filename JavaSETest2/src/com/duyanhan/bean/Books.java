package com.duyanhan.bean;

import java.util.Date;

public class Books {

	private int id;
	private int bookid;
	private String bookname;
	private String author;
	private String chubanshe;
	private Date date;
	private int amount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getChubanshe() {
		return chubanshe;
	}
	public void setChubanshe(String chubanshe) {
		this.chubanshe = chubanshe;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Books [id=" + id + ", bookid=" + bookid + ", bookname=" + bookname + ", author=" + author
				+ ", chubanshe=" + chubanshe + ", date=" + date + ", amount=" + amount + "]";
	}

	
}
