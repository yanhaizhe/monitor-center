package com.beingmate.updateFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class FileReader {
	private StringBuilder fileContent;
	private RegexMatcher<LineModel> regexMatch;
	private String encode = "UTF-8";
	private boolean needWrite;
	private final static String BAK_PATH = "";
	private String mDir;

	public FileReader(RegexMatcher<LineModel> regexMatch) {
		super();
		this.regexMatch = regexMatch;
	}

	public FileReader() {
		super();
	}

	/**
	 * 读取类所在的目录
	 * 
	 * @param fileName
	 */
	public void readSrcFile(String fileName) {
		InputStream in = getClass().getResourceAsStream("/" + fileName);
		if (in == null)
			throw new NullPointerException(fileName + "'s content is empty");
		try {
			readLine(in, null);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读取路径下所有文件
	 * 
	 * @param dir
	 */
	public void readDirAllFile(String dir) {
		mDir = dir;
		if (StringUtils.isEmpty(dir)) {
			throw new NullPointerException("dir is empty");
		}
		File file = new File(dir);
		readFileRecursion(file);
	}

	/**
	 * 递归读取路径和文件
	 * 
	 * @param file
	 */
	public void readFileRecursion(File file) {
		if (!file.exists()) {
			throw new RuntimeException("file is not exist");
		}
		if (file.isDirectory()) {
			File files[] = file.listFiles();
			for (File f : files) {
				readFileRecursion(f);
			}
		} else if (file.isFile()) {
			System.out.println("文件：" + file.getName());
			readLine4Regex(file);
			write(file);
		}
	}
	

	/**
	 * 按照行读取，并正则匹配
	 * 
	 * @param file
	 */
	private void readLine4Regex(File file) {
		InputStream in = null;
		try {
			in = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			readLine(in, file.getName());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	private void readLine(InputStream in, String fileName) throws UnsupportedEncodingException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, encode));
		try {
			String line = "";
			while (line != null) {
				line = bufferedReader.readLine();
				//处理每“行”
				if (line != null) {
					LineModel input = new LineModel();
					input.setLine(line);
					input.setFileName(fileName);
					regexMatch.match(input);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void writeLine(File file) {
		List<LineModel> models = regexMatch.getMatchResult();
		if (models == null) {
			return;
		}
		FileWriter out = null;
		try {
			 out = new FileWriter(file);
			for (LineModel lm : models) {
				if(lm==null){
					continue;
				}
				switch (lm.getrType()) {
				//如果“行”已经被修改，则写入结果
				case REPLACE:
					out.write(lm.getResult());
				default:
					out.write(lm.getLine());
					break;
				}
			}
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 复制文件
	 * @param srcFile
	 * @param targetFile
	 */
	public void copyFile(File srcFile,File targetFile){
		BufferedInputStream inBuff = null;
		try {
			inBuff = new BufferedInputStream(new FileInputStream(srcFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedOutputStream outBuff =null;
		try {
			outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));
			byte [] bs = new byte[1024*5];
			int len;
			while((len=inBuff.read(bs))!=-1){
				outBuff.write(bs,0,len);
			}
			outBuff.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(inBuff!=null){
				try {
					inBuff.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(outBuff!=null){
				try {
					outBuff.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/*
	 * 复制文件夹
	 */
	public void copyDir(String srcDir,String targetDir){
		File tFile = new File(targetDir);
		tFile.mkdirs();
		File []files = new File(srcDir).listFiles();
		for(File f:files){
			if(f.isFile()){
				File targetFile = new File(tFile.getAbsoluteFile()+File.separator+f.getName());
				copyFile(f, targetFile);
			}else if(f.isDirectory()){
				//准备复制的源文件夹
				String dir = srcDir+File.separator+f.getName();
//				准备复制的目标文件夹
				String dir1 = targetDir+File.separator+f.getName();
				copyDir(dir, dir1);
			}
		}
	}
	
	/**
	 * 写入文件
	 * @param file
	 */
	public void write(File file){
		if(StringUtils.isEmpty(BAK_PATH)){
			throw new NullPointerException("bak path is empty");
		}
		copyDir(mDir,BAK_PATH);
		if(needWrite){
			writeLine(file);
		}
	}

	public boolean isNeedWrite() {
		return needWrite;
	}

	public void setNeedWrite(boolean needWrite) {
		this.needWrite = needWrite;
	}

	public String getEncode() {
		return encode;
	}

	public void setEncode(String encode) {
		this.encode = encode;
	}

	public StringBuilder getFileContent() {
		return fileContent;
	}
}
