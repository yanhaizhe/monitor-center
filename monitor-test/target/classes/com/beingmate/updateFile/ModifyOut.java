package com.beingmate.updateFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author  54wall 
 * @date 创建时间：2016-6-13 下午5:30:35
 * @version 1.0 
 */
public class ModifyOut {
	
	public ModifyOut() {
		super();//这里是自动生成的构造函数
	}
	public  void modifyout(String file_before,String file_after,String file_infant_path) {	
		boolean infant=false;
		int i_line = 0;
		StringBuffer buf = new StringBuffer();
		try {
			Scanner in = new Scanner(new File(file_before));
			while (in.hasNextLine()) {
				if (i_line == 2) {
					String str = in.nextLine();
					/* str=="check: 2"显然忘记了字符串的不可以直接按逻辑比较 */
					if (str.equals("check: 0")) {
						System.out.println("我在这里！");
						/* 开始仅用了str.replace(),没有看API的返回值才是 */
						str = str.replace("check: 0", "check: 2");
					}
					buf.append("\r\n");
					buf.append(str);
					i_line++;
				}
				else {																				
					String str = in.nextLine();	
					/*如果是infant则挑出*/
					if (i_line==190) {												
						if (str.equals("age: 0")) {
							System.out.println("age<6");
							infant=true;							
						}
					}
					/*解决首行出现一个空行的问题*/
					if (i_line == 0) {
						/*这里是错误的，多了一个换行*/
//						buf.append("\n");
						buf.append(str);
						i_line++;
					} else {
						buf.append("\r\n");
						buf.append(str);
						i_line++;
					}
				}
			
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		try {
			File file = new File(file_after);
			if (!file.exists()) {
				file.createNewFile();
			}
		/*可以指定编码形式：PrintStream out_model = new PrintStream(new FileOutputStream(file, true),true,"utf-8");
			但是已经发现不是编码选择问题，而是.mark_TH文件在读取时增加了一个空格导致LandMarkV5无法使用*/
			PrintStream out_model = new PrintStream(new FileOutputStream(file, true));
			/*原来输出总是有多一行*/
//			out_model.println(buf);
			out_model.print(buf);
			out_model.close();
			/*如果是infant则保存*/
			if (infant) {
				File file_infant = new File(file_infant_path);
				if (!file_infant.exists()) {
					file_infant.createNewFile();
				}
				PrintStream out_model_infant = new PrintStream(new FileOutputStream(file_infant, true));
				out_model_infant.print(buf);
				out_model_infant.close();
			}			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}