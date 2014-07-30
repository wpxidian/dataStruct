package cn.edu.xidian.ds.tree;

public class ArrayBiTreeTest {

	public static void main(String[] args) {
		
		ArrayBiTree<String>  bt = new ArrayBiTree<>(3,"根") ;
		bt.add(0, "第一个结点", true) ;
		bt.add(0, "第二个结点", false) ;
		bt.add(1, "第三个结点", true) ;
		bt.add(2, "第六个结点", false) ;
		System.out.println(bt.toString());
		
		System.out.println(bt.deep());
		System.out.println(bt.root());
		System.out.println(bt.parent(1));
		
		System.out.println(bt.left(1));
		System.out.println(bt.right(2));
		
		System.out.println(bt.pos("第六个结点"));
	}

}
