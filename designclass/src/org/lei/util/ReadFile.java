package org.lei.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.catalina.ant.FindLeaksTask;
import org.lei.model.SeriInfo;

import com.sun.org.apache.regexp.internal.REUtil;


public class ReadFile {
	

	
		public List<SeriInfo> readFile() throws  Exception{
			File file = new File("C:/Users/磊/Desktop/test.txt");
			String key = null;
			String description = null;
			String serial = null;
			int quality = 0;
			String firstString = null;//拿到的某个数据的第一行数据
			int pos = 0;			  //记录第一行结尾的位置
			List<SeriInfo>seiInfos = new ArrayList<SeriInfo>();
			
			try {
				FileInputStream fin = new FileInputStream(file);
				byte[]b = new byte[1024];
				//String reString  = null;
				StringBuffer sb = new StringBuffer();
				while(fin.read(b)>0){
					sb.append(new String(b));
				}
				Pattern pattern  = Pattern.compile("^>",Pattern.MULTILINE);//提取每一次的数据
				Pattern patternFirstWord = Pattern.compile("[\\|A-Z0-9_]*\\b");//提取key的正则匹配
				Matcher matcher = null;
				char[]cSerial = null;
				//注意这里的result[0]是截取的第一个，为空值
				String []result = pattern.split(sb);
				System.out.println(result.length);
				for(int i = 1;i<result.length;i++){
					System.out.println(i);
					SeriInfo seriInfo = new SeriInfo();
					//System.out.println(result[i]);
					pos = result[i].indexOf("\n");
					/*if(i>=469){
						System.out.println(result[i]);
						System.out.println(pos);
					}*/
					firstString = result[i].substring(0,pos);
					matcher = patternFirstWord.matcher(firstString);
					matcher.find();
					key = matcher.group();//得到id
					description = firstString.substring(key.length()+1).trim();//得到描述值
					serial = result[i].substring(firstString.length()+1);//得到序列号
					quality = getQuality(serial);
					
					seriInfo.setId(key);
					seriInfo.setDescription(description);
					seriInfo.setSerial(serial);
					seriInfo.setQuality(quality);
					seiInfos.add(seriInfo);
					firstString = null;
					/*System.out.println(key);
					System.out.println(description);
					System.out.println(serial);
					System.out.println(quality);*/
				}
				
				return seiInfos;
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return null;
			}
			
		}
		
		public int getQuality(String serial){
			int quality = 0;
			char[] arrayChar = serial.toCharArray();
			for(int i =0;i<arrayChar.length;i++){
				switch (arrayChar[i]) {
				case 'G':
					quality+=Constant.G;
					break;
				case 'A':
					quality+=Constant.A;
					break;
				case 'B':
					quality+=Constant.B;
					break;
				case 'C':
					quality+=Constant.C;
					break;
				case 'D':
					quality+=Constant.D;
					break;
				case 'E':
					quality+=Constant.E;
					break;
				case 'F':
					quality+=Constant.F;
					break;
				case 'P':
					quality+=Constant.P;
					break;
				case 'H':
					quality+=Constant.H;
					break;
				case 'I':
					quality+=Constant.I;
					break;
				case 'O':
					quality+=Constant.O;
					break;
				case 'K':
					quality+=Constant.K;
					break;
				case 'L':
					quality+=Constant.L;
					break;
				case 'M':
					quality+=Constant.M;
					break;
				case 'N':
					quality+=Constant.N;
					break;
				case 'Q':
					quality+=Constant.Q;
					break;
				case 'X':
					quality+=Constant.X;
					break;
				case 'Y':
					quality+=Constant.Y;
					break;
				case 'Z':
					quality+=Constant.Z;
					break;
				default:
					break;
				}
			}
			return quality;
		}
		
		public static void main(String []args){
			try {
				new ReadFile().readFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
}
