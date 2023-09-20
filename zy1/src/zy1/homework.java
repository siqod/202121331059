package zy1;

import java.io.*;
import java.text.*;

public class homework {
	public static void main(String[] Args) {
		String path1="orig.txt";
		String path2="orig_add.txt";
		String path3="result.txt";
		File org=new File(path1);
		File adder=new File(path2);
		File otput=new File(path3);
		if(otput.exists()==false) {
			try {
				otput.createNewFile();
			}
			catch(IOException e) {
				System.out.println("无法创建输出文件，且文件不存在，请检查内存或读写权限");
				System.out.println("ERROR:"+e);
			}
		}
		else {//上面是查错，不用管它们
			try {
				otput.delete();
				otput.createNewFile();//这两行代码用于防止一开始文件内有东西
				FileReader rdorg=new FileReader(org);
				FileReader rdadd=new FileReader(adder);
				BufferedReader bufrdorg=new BufferedReader(rdorg);
				BufferedReader bufrdadd=new BufferedReader(rdadd);
				FileWriter wrrst=new FileWriter(otput);
				String str1=bufrdorg.readLine();
				String str2=bufrdadd.readLine();//开读！
				similarity sim=new similarity();
				if(str1!=null && str2!=null) {//你没有给我一个空文件或者无法处理的文件
					double chongfulv=0.0;
					chongfulv=sim.simi(str1,str2);
					DecimalFormat df=new DecimalFormat("######0.00");//保留2位小数
					String str3=df.format(chongfulv);
					wrrst.write(str3);
				}
				else {
					System.out.println("你要查重的文件/源文件没有任何东西！");
				}
				System.out.print(org.getAbsolutePath()+"\n"+adder.getAbsolutePath()+"\n"+otput.getAbsolutePath());
				bufrdorg.close();
				bufrdadd.close();
				wrrst.close();
			} catch (Exception e) {
				e.printStackTrace();//报错
			}
		}
	}
}
