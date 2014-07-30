package cn.edu.xidian.ds.list;

/**
 * 带头结点的线性链表
 */
public class LinkListTest
{
	public static void main(String[] args){
		LinkList<String> linkList = new LinkList<String>() ;		
		linkList.addLast("lisi") ;
		linkList.add("wangwu",1) ;
		linkList.addFirst("zhangsan");
		System.out.println(linkList.toString());
		/*System.out.println("获取第三个位置的元素：") ;
		System.out.println(linkList.getByIndex(2)) ;*/
		
		System.out.println("删除第一个元素后：") ;
		linkList.remove(2) ;
		System.out.println(linkList.toString());
		
		System.out.println("单链表的倒序输出(递归)：");
		linkList.reversePrint_solution1() ;
		System.out.println("单链表的倒序输出(栈)：");
		linkList.reversePrint_solution2() ;
		
		System.out.println("反转单链表：");
		linkList.reverseLinkList() ;
		System.out.println(linkList.toString());
		
		System.out.println("销毁后：") ;
		linkList.clear() ;
		System.out.println(linkList.toString());
		
	}
}