package com.beingmate.updateFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFinder {
	private StringBuilder target;
	private StringBuilder result;
	private static final String START_CORNER = "【";
	private static final String END_CORNER = "】";
	private int matchCount;
	private List<String> matchStrList;

	public StringFinder(StringBuilder target) {
		super();
		this.target = target;
	}

	public void find(String regex[]) {
		for (String r : regex) {
			System.out.println("查找：" + r);
			find(r);
		}
	}

	public void find(String regex) {
		checkNull();
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(target);
		if (result == null)
			result = new StringBuilder();
		if (matchStrList == null)
			matchStrList = new ArrayList<String>();
		while (matcher.find()) {
			String s = matcher.group();
			matchStrList.add(s);
			matcher.replaceAll("\\n" + START_CORNER + s + END_CORNER + "\\n");
			matchCount++;
		}
	}

	private void checkNull() {
		if (this.target == null)
			throw new NullPointerException("target is null pointer");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return target.toString();
	}

	public void printMatchStrList() {
		System.out.println(Arrays.toString(matchStrList.toArray()));
	}

}
