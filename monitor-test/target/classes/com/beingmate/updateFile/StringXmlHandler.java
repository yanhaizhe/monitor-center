package com.beingmate.updateFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class StringXmlHandler extends XmlHandler {

	@Override
	void handle(String filePath) {
		// TODO Auto-generated method stub
		File file = new File(filePath);
		if (!file.exists()) {
			System.out.println(filePath + "目录不存在");
			return;
		}
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			NodeParser<StringNode> targetParser = null;
			for (File f : files) {
				System.out.println("文件："+f.getName());
				if (f.getName().equalsIgnoreCase("strings.xml")) {
					System.out.println(f.getName() + "=================== start parser ===================");
					InputStream inputStream = null;
					try {
						inputStream = new FileInputStream(f);
						targetParser = new QueryStringAttParser();
						parseXml(inputStream, null, targetParser);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println(f.getName() + "=================== end parser ===================");
				}
			}
			for (File f : files) {
				System.out.println("文件："+f.getName());
				if (!f.getName().equalsIgnoreCase("strings.xml")) {
					System.out.println(f.getName() + "=================== start parser ===================");
					InputStream inputStream = null;
					try {
						inputStream = new FileInputStream(f);
						targetParser = new QueryStringAttParser();
						parseXml(inputStream, null, targetParser);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println(f.getName() + "=================== end parser ===================");
				}
			}
		} else {
			System.out.println(filePath + "路径不是目录");
		}
	}

}
