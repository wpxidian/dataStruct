package cn.edu.xidian.ds.stack;

public class LinkStackTest {
	
	public static void main(String[] args) {
		LinkStack linkList = new LinkStack() ;
		System.out.println("栈长度为："+linkList.getSize()) ;
		linkList.push("zhangsan") ;
		linkList.push("lisi") ;
		linkList.push("wagnwu") ;
		System.out.println("栈长度为："+linkList.getSize()) ;
		System.out.println("出栈元素为："+linkList.pop()) ;
		System.out.println("栈长度为："+linkList.getSize()) ;
		linkList.destory() ;
		System.out.println("栈长度为："+linkList.getSize()) ;

	}

}
