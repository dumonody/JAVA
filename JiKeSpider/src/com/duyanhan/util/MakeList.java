package com.duyanhan.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

public class MakeList {

	public void makeListByAimStringList(List<String[]> aimStringList, String fileName, String charSet) throws Exception
	{
		BufferedWriter bufW = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), charSet));
		
		for(int i = 0, len = aimStringList.size(); i < len; i++)
		{
			String[] strArray = aimStringList.get(i);
			
			String aimString = "";
			
			for(String item : strArray)
			{
				aimString += "\t" + item;
			}
			
			aimString = (i+1) + aimString;
			
			if(i+1 < 10) {
				aimString = "00" + aimString;
			}
			else if(i+1 < 100) {
				aimString ="0" + aimString;
			}
			
			
			// 打印路径
			System.out.println(aimString);
			this.makeDir("HTML5", aimString);
			bufW.write(aimString);
			bufW.newLine();
			bufW.flush();
		}
		
		bufW.close();
	}
	
	public void makeDir(String dirPath, String descStr)
	{
		String[] strArray = descStr.split("\t");
		String fileName = strArray[0] + "." + strArray[2];
		
		File dir = new File(dirPath + File.separator + fileName);
		if(!dir.exists())
		{
			dir.mkdirs();
		}
	}
}
