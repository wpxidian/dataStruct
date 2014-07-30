package cn.edu.xidian.ds.list;

public class SqListTest
{
	public static void main(String[] args){
		SqList<String> sq = new SqList<String>(2) ;
		sq.add("zhangsan") ;
		sq.add("lisi") ;
		sq.add("wangwu") ;
		System.out.println(sq.toString());
		
		System.out.println("lisi所在的索引："+sq.indexOf("lisi")) ;
		sq.remove(2) ;
		System.out.println("线性表的长度："+sq.getSize());
		
		System.out.println("第2个索引对应的元素："+sq.get(1)) ;
		System.out.println("删除后lisi所在的索引："+sq.indexOf("lisi")) ;
	}
}
