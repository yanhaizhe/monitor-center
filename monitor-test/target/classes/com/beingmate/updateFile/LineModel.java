package com.beingmate.updateFile;

public class LineModel {
	private String fileName;
	private String line;
	private String result;
	//正则做了什么操作
	private RegexType rType = RegexType.DEF;
	
	public enum RegexType{
		MATCH,REPLACE,DEF
	}
	
	public RegexType getrType() {
		return rType;
	}

	public void setrType(RegexType rType) {
		this.rType = rType;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
