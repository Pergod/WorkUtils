package com.sinolife.chapter5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class XSLGenerator {
	private static final String COMMON_HEAD="";
	private static final String COMMON_FOOT="";
	private static final String FILE_PREFIX="pcis_";
	
	public static void GeneratorReqXSL() {
		
	}
	
	public static void GeneratorResXSL() {
		
	}
	
	public static void main(String[] args) {
		String fullFilePath = "C:\\Users\\Flystar\\Desktop\\req.txt";
		StringBuilder content = ReadFile(fullFilePath);
		System.out.println(removeXMLHead(content.toString()));
	}
	
	public static StringBuilder ReadFile(String fullFilePath) {
		File file = null;
		BufferedReader reader = null;
		String line = "";
	    StringBuilder content = null;
		try {
			file = new File(fullFilePath);
			reader = new BufferedReader(new FileReader(file));  
		    content = new StringBuilder();
		    while ((line = reader.readLine()) != null) {  
		         content.append(line+"\n");
		    }  
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return content;
	}
	
	public static void WriteReqXSLFile(StringBuilder content) {
		
	}
	
	public static void WriteResXSLFile(StringBuilder content) {
		
	}
	
	public static String removeXMLHead(String content) {
		if ((null==content )|| ("".equals(content))) {
			return "";
		}
		
		if (content.indexOf("?>")>0) {
			content = content.substring(content.indexOf("?>")+"?>".length());
		}
		return content;
	}
	
	/*
	 * <head>
	 * 		<a>
	 * 			<a1>xxx</a1>		--><a1><xsl:value of='//head//a/a1'></a1>
	 * 		<a/>
	 * </head>
	 * 1.节点下面还是节点
	 * 2.节点下面为值
	 */
	public static String formatContent(String content) {
		content = removeXMLHead(content);
		StringBuilder sb  = new StringBuilder(content);
		int idx = 0;
		while((idx = content.indexOf(">"))>0) {
			/*
			 * 节点下面是节点，递归,并且存储节点的name
			 */
			if (content.charAt(idx+1)=='<') {
				
			}else {
				
			}
			idx++;
		}
		return content;
	}
	
	public static String getNodeName(String node) {
		int endIndex = node.indexOf(">");
		int startIndex = node.indexOf("<");
		node = node.substring(startIndex+1, endIndex);
		return node;
	}
	
	public static String getFilePath(String fullFilePath) {
		int endIndex = fullFilePath.lastIndexOf(File.separator);
		String filePath = fullFilePath.substring(0, endIndex);
		return filePath;
	}
	
	public static String getFileName(String fullFilePath) {
		int startIndex = fullFilePath.lastIndexOf(File.separator);
		int endIndex = fullFilePath.lastIndexOf(".");
		String fileName = fullFilePath.substring(startIndex+1, endIndex);
		return fileName;
	}
	
	public static String setReqXSLFileSavePath(String fullFilePath) {
		String PARTNER_ID = getFileName(fullFilePath);
		String filePath = getFilePath(fullFilePath)+FILE_PREFIX+PARTNER_ID.toLowerCase()+"_"+"req.xsl";
		return filePath;
	}
	
	public static String setResXSLFileSavePath(String fullFilePath) {
		String PARTNER_ID = getFileName(fullFilePath);
		String filePath = getFilePath(fullFilePath)+FILE_PREFIX+PARTNER_ID.toLowerCase()+"_"+"res.xsl";
		return filePath;
	}
}
