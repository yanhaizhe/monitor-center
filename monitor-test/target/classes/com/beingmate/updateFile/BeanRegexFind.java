package com.beingmate.updateFile;

import org.apache.commons.lang3.StringUtils;

public class BeanRegexFind implements Command<String, Boolean>{
	private String regex;
	
	public BeanRegexFind(String regex) {
		super();
		this.regex = regex;
	}

	public Boolean execute(String input){
		if(StringUtils.isEmpty(regex)){
			return false;
		}
		return input.matches(regex);
	}
}
