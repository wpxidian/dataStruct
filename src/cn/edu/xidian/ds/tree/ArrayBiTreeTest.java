package cn.edu.xidian.ds.tree;

public class ArrayBiTreeTest {

	public static void main(String[] args) {
		
		ArrayBiTree<String>  bt = new ArrayBiTree<>(3,"��") ;
		bt.add(0, "��һ�����", true) ;
		bt.add(0, "�ڶ������", false) ;
		bt.add(1, "���������", true) ;
		bt.add(2, "���������", false) ;
		System.out.println(bt.toString());
		
		System.out.println(bt.deep());
		System.out.println(bt.root());
		System.out.println(bt.parent(1));
		
		System.out.println(bt.left(1));
		System.out.println(bt.right(2));
		
		System.out.println(bt.pos("���������"));
	}

}
