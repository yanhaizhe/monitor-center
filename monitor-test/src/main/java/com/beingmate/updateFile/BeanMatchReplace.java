package com.beingmate.updateFile;

import org.apache.commons.lang3.StringUtils;

public class BeanMatchReplace implements Command<LineModel, LineModel>{
	private BeanRegexFind regexFindBean;
	private BeanReplace strReplaceBean;
	
	public BeanMatchReplace(String input,String output){
		regexFindBean = new BeanRegexFind(input);
		strReplaceBean = new BeanReplace(output);
	}
	
	public LineModel execute(LineModel model){
		if(model==null){
			throw new NullPointerException("model is null");
		}
		boolean b = regexFindBean.execute(model.getLine());
		if(b){
			String output = strReplaceBean.execute(model.getLine());
			if(!StringUtils.isEmpty(output)){
				model.setrType(LineModel.RegexType.REPLACE);
			}
		}else{
			model.setrType(LineModel.RegexType.MATCH);
		}
		return model;
	}
}
