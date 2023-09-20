package zy1;

import java.util.*;

public class similarity {
	public static Set<String> spl(String str){
		String ci[]=str.split("");//分割为词，每个字分
		Set<String> st=new HashSet<>();
		for(String words:ci) {
			st.add(words);//把词加进set里
		}
		return st;//词集返回
	}
	public double simi(String str1,String str2) {
		Set<String> stci=new HashSet<>(spl(str1));
		stci.addAll(spl(str2));//加起来
		Set<String> ysci=new HashSet<>(spl(str1));
		ysci.retainAll(spl(str2));//交集
		double tes1=stci.size()*1.0;
		double tes2=ysci.size()*1.0;
		return tes2/tes1;
	}
}
