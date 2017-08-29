package com.beingmate.updateFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/*
 * 参考SDK测试app，遍历文件夹内全部文件，以文件后缀名作为筛选条件
 * http://www.android-study.net/listxx.aspx?id=343
 */
public class GetDir {

	public List<String> getFiles(final String strPath, String format) {
		/*这里开始拷贝过来时，java是1.8报错了，fix之后已经兼容了1.5但是不知其他地方会报什么错误*/
		List<String> list = new ArrayList<String>();
		File file = new File(strPath);
		File[] allfiles = file.listFiles();
		if (allfiles == null) {
			return null;
		}
		for (int k = 0; k < allfiles.length; k++) {
			final File fi = allfiles[k];
			if (fi.isFile()) {
				int idx = fi.getPath().lastIndexOf(".");
				if (idx <= 0) {
					continue;
				}
				String suffix = fi.getPath().substring(idx);
				if (suffix.toLowerCase(Locale.PRC).equals(format)

				) {
					list.add(fi.getPath());
				}
			}
		}
		return list;
	}
}
