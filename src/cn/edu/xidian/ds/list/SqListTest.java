package cn.edu.xidian.ds.list;

public class SqListTest
{
	public static void main(String[] args){
		SqList<String> sq = new SqList<String>(2) ;
		sq.add("zhangsan") ;
		sq.add("lisi") ;
		sq.add("wangwu") ;
		System.out.println(sq.toString());
		
		System.out.println("lisi���ڵ�������"+sq.indexOf("lisi")) ;
		sq.remove(2) ;
		System.out.println("���Ա�ĳ��ȣ�"+sq.getSize());
		
		System.out.println("��2��������Ӧ��Ԫ�أ�"+sq.get(1)) ;
		System.out.println("ɾ����lisi���ڵ�������"+sq.indexOf("lisi")) ;
	}
}
