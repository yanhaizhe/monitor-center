package com.beingmate.updateFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class DimenXmlHandler extends XmlHandler {
	@Override
	public void handle(String filePath) {
		File file = new File(filePath);
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			NodeParser targetParser = null;
			for (File f : files) {
				// System.out.println(f.getName());
				if (f.getName().equalsIgnoreCase("target.xml")) {
					System.out.println("target========");
					InputStream inputStream = null;
					try {
						inputStream = new FileInputStream(f);
						targetParser = new TargetNodeParser();
						parseXml(inputStream, null, targetParser);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println("====================next");
			if (targetParser != null) {
				for (File f : files) {
					System.out.println("文件：" + f.getName());
					if (!f.getName().equalsIgnoreCase("target.xml") && f.getName().indexOf(".xml") > -1) {
						OutputStream outputStream = null;
						InputStream inputStream = null;
						try {
							inputStream = new FileInputStream(f);
							File newFile = new File("/Users/cong/myxml/" + f.getName());
							if (!newFile.exists()) {
								newFile.createNewFile();
							}
							outputStream = new FileOutputStream(newFile);
							ChangeAttParser changeAttParser = new ChangeAttParser();
							changeAttParser.setTargetList(targetParser.getTargetList());
							parseXml(inputStream, outputStream, changeAttParser);
						} catch (Exception e) {
							e.printStackTrace();
							return;
						}
						if (inputStream != null) {
							try {
								inputStream.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						if (outputStream != null) {
							try {
								outputStream.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}

}
