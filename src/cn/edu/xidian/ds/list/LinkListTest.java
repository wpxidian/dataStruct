package cn.edu.xidian.ds.list;

/**
 * ��ͷ������������
 */
public class LinkListTest
{
	public static void main(String[] args){
		LinkList<String> linkList = new LinkList<String>() ;		
		linkList.addLast("lisi") ;
		linkList.add("wangwu",1) ;
		linkList.addFirst("zhangsan");
		System.out.println(linkList.toString());
		/*System.out.println("��ȡ������λ�õ�Ԫ�أ�") ;
		System.out.println(linkList.getByIndex(2)) ;*/
		
		System.out.println("ɾ����һ��Ԫ�غ�") ;
		linkList.remove(2) ;
		System.out.println(linkList.toString());
		
		System.out.println("������ĵ������(�ݹ�)��");
		linkList.reversePrint_solution1() ;
		System.out.println("������ĵ������(ջ)��");
		linkList.reversePrint_solution2() ;
		
		System.out.println("��ת������");
		linkList.reverseLinkList() ;
		System.out.println(linkList.toString());
		
		System.out.println("���ٺ�") ;
		linkList.clear() ;
		System.out.println(linkList.toString());
		
	}
}