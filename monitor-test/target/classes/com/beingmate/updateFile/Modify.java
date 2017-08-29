package com.beingmate.updateFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 54wall
 * @date 创建时间：2016-6-13 下午3:16:06
 * @version 1.0
 */
public class Modify extends ModifyOut {
	public static void main(String[] args) {
		/*文件夹需要提前建立*/
		String path_before = "I:\\sdate";
//		String path_before = "./before";
		/*
		 * 这里注意我在GetDir方法中写了这么一句suffix.toLowerCase(Locale.PRC).equals(format)
		 * 所以format=".mark_TH"含有大写字母肯定不会和小写的.mark_th有equal的可能性了，所以list_file总是返回0
		 */
		// String format=".mark_TH";
		String format = ".sql";
		ModifyOut mOut = new ModifyOut();
		GetDocmentName gName = new GetDocmentName();
		GetDir gDir = new GetDir();
		List<String> list_file = new ArrayList<>();
		System.out.println("*****************************************");
		list_file = gDir.getFiles(path_before, format);
		System.out.println(list_file.size());
		for (int i = 0; i < list_file.size(); i++) {
			System.out.println(list_file.get(i));
			/* 比较奇怪，这里的分隔符还是'/' */
			/*注意文件夹需要提前建立，否则会报错*/
			mOut.modifyout(
					list_file.get(i),
					"I:\\sdate/after/" + gName.getDocmentName(list_file.get(i)),
					"I:\\sdate/infant/" + gName.getDocmentName(list_file.get(i))
//					"e:/TestProject/LandMark/after/" + gName.getDocmentName(list_file.get(i)),
//					"e:/TestProject/LandMark/infant/" + gName.getDocmentName(list_file.get(i))
					);
		}
	}

}
