package cn.edu.xidian.ds.stack;

public class LinkStackTest {
	
	public static void main(String[] args) {
		LinkStack linkList = new LinkStack() ;
		System.out.println("ջ����Ϊ��"+linkList.getSize()) ;
		linkList.push("zhangsan") ;
		linkList.push("lisi") ;
		linkList.push("wagnwu") ;
		System.out.println("ջ����Ϊ��"+linkList.getSize()) ;
		System.out.println("��ջԪ��Ϊ��"+linkList.pop()) ;
		System.out.println("ջ����Ϊ��"+linkList.getSize()) ;
		linkList.destory() ;
		System.out.println("ջ����Ϊ��"+linkList.getSize()) ;

	}

}
