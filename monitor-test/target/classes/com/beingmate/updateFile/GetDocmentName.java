package com.beingmate.updateFile;
/**
 * @author  54wall from test5bitmap
 * http://zhidao.baidu.com/link?url=EpV9WC8_kzHPr1WgFdHtrDjIg6irShHP1wZj_S6qfpb1Vd-mdUpyy160lq2pa_YFP52iKmiEFn-jD57M4MN-TSglcZrlACkQ-bdDUYQFiRe
 */
public class GetDocmentName {
	public String getDocmentName(String pathandname) {
		/*保留文件名及后缀*/
		int start = pathandname.lastIndexOf("\\");
		if (start != -1 ) {
			return pathandname.substring(start + 1);
		} else {
			return null;
		}
		
	}
}
