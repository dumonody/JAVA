package com.duyanhan.io.a.file;

import java.io.File;
import java.util.LinkedList;

public class FileOpDemo7 {

	public static void main(String[] args) {

		File dir = new File("D:\\MySoft\\MyBlog\\myhexo\\source");
		
		// 先定义一个空的队列
		Queue<File> queue = new Queue<File>(new LinkedList<File>());
		
		// 健壮性判断，dir必须存在，且是个目录
		if(dir.exists() && dir.isDirectory())
		{
			// 将当前目录放入队列中
			queue.add(dir);
			// 如果队列不为空
			while(!queue.isEmpty())
			{
				// 获取队列头部元素(获取但不删除),必定是个文件夹
				File cDir = (File) queue.getTop();
				// 输出这个目录名：
				System.out.println("目录 ： " + cDir.getName());
				// 获取这个文件夹下的所有内容，如果是文件夹就添加到队尾，如果是文件，就输出其名称
				File[] files = cDir.listFiles();
				for(File f : files)
				{
					if(f.isDirectory())
					{
						queue.add(f);
					}
					else {
						System.out.println(f.getName());
					}
				}
				// 然后删除头部元素
				queue.delete();
			}
		}
	}
	
}

/**
 * 定义一个队列
 * @author Pro.Du
 *
 * @param <E>
 */
class Queue<E> {
	// 利用LinkedList来实现队列
	private LinkedList<E> link = null;
	
	// 有参构造
	public Queue(LinkedList<E> link){
		this.link = link;
	}
	
	// 队列添加元素操作
	public void add(E e)
	{
		// 添加元素至队列尾部
		this.link.addLast(e);
	}
	
	// 获取队列头部元素
	public E getTop()
	{
		return this.link.getFirst();
	}
	
	// 队列删除元素操作
	public void delete()
	{
		// 删除队列头部元素
		this.link.removeFirst();
	}
	
	// 队列元素判空操作
	public boolean isEmpty()
	{
		return this.link.isEmpty();
	}
}
