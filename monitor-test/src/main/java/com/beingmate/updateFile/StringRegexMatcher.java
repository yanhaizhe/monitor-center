package com.beingmate.updateFile;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringRegexMatcher extends RegexMatcher<LineModel>{
	private String regex;
	private List<LineModel> lineStrList = null;

	public StringRegexMatcher(String regex) {
		super();
		this.regex = regex;
	}

	@Override
	public boolean match(LineModel input) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input.getLine());
//		System.out.println(target);
		if(matcher.find()){
//			System.out.println("匹配成功");
			if(lineStrList==null){
				lineStrList = new ArrayList<LineModel>();
			}
			input.setResult(input.getLine());
			lineStrList.add(input);
			return true;
		}
//		System.out.println("匹配失敗");
		return false;
	}

	@Override
	public List<LineModel> getMatchResult() {
		return lineStrList;
	}
}
