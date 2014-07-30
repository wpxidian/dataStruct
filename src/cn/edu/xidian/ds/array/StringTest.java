package cn.edu.xidian.ds.array;

public class StringTest {
	public static void main(java.lang.String[] args) {
		char[] value = {'H','e','l','l','o'} ;
		char[] value2 = {'l','l','o'} ;
		String str1 = new String(value) ;
		String str2 = new String(value2) ;
		System.out.println(str1.compareTo(str2));
		System.out.println(str1.concat(str2));
		System.out.println(str1.charAt(0));
		
		System.out.println(str1.indexOf('l'));
		System.out.println(str1.lastIndexOf('l'));
		
		System.out.println(str1.equals(str1));
		
		System.out.println(str1.startsWith(str2));
		
		System.out.println(str1.endsWith(str2));
		
		System.out.println(str1.replace('l', 'w'));
	}
}
