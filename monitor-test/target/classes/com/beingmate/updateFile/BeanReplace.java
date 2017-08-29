package com.beingmate.updateFile;

import org.apache.commons.lang3.StringUtils;

public class BeanReplace implements Command<String, String>{
	private String regex = "";

	public BeanReplace(String regex) {
		super();
		this.regex = regex;
	}

	@Override
	public String execute(String t) {
		if(StringUtils.isEmpty(regex)){
			return null;
		}
		return t.replaceAll(regex, t);
	}

}
