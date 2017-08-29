package com.beingmate.updateFile;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Test {
	public static void main(String[] args) {
		// XmlHandler handle = new StringXmlHandler();
		// handle.handle("/Users/cong/myxml/assets");
//		 read();
		// 匹配中文
//		readFromOs("F:\\gitRepo\\Botai\\src", "\"[[\u4e00-\u9fa5]+[，,！!]*]+\"");
		readFromOs("F:\\gitRepo\\Botai\\res", "\"^[\u4e00-\u9fa5]+[，,！!\n]*\"",null);
		// matchString();showConnErrorDialog("镜像出现异常，请尝试拔线重连！");
//		addString();
	}

	public static void read() {
		FileReader fileReader = new FileReader();
		fileReader.readSrcFile("file.txt");
		FileReader fileReader1 = new FileReader();
		fileReader1.readSrcFile("regex.txt");
		StringFinder sf = new StringFinder(fileReader.getFileContent());
		sf.find(Utils.strSplit(fileReader1.getFileContent().toString(), "、"));
		sf.printMatchStrList();
		// System.out.println(sf);
	}

	public static void addString() {
		List<LineModel> l = readSrc("file.txt","[\u4e00-\u9fa5]");
		for (LineModel s : l) {
			System.out.println("\"@@"+s.getResult()+"\"@@@");
		}
	}

	public static List<LineModel> readSrc(String file, String regex) {
		RegexMatcher<LineModel> regexMatch = new StringRegexMatcher(regex);
		FileReader fileReader = new FileReader(regexMatch);
		fileReader.readSrcFile(file);
		return regexMatch.getMatchResult();
	}

	public static void readFromOs(String dir, String regex,String encode) {
		RegexMatcher<LineModel> regexMatch = new StringRegexMatcher(regex);
		FileReader fileReader = new FileReader(regexMatch);
		if(!StringUtils.isEmpty(encode)){
			fileReader.setEncode(encode);
		}
		fileReader.readDirAllFile(dir);
		List<LineModel> result = regexMatch.getMatchResult();
		for (LineModel s : result) {
			System.out.println(s.getFileName());
			System.out.println(s.getResult());
		}
	}

}
