package cn.edu.xidian.ds.tree;

public class LinkBiTreeTest {

	public static void main(String[] args) {
		LinkBiTree<String> bt = new LinkBiTree<String>("根") ;
		LinkBiTree.Node<String> node1 = bt.add(bt.root(), "第一个结点", true) ;
		LinkBiTree.Node<String> node2 = bt.add(bt.root(), "第二个结点", false) ;
		LinkBiTree.Node<String> node3 = bt.add(node1, "第三个结点", true) ;
		LinkBiTree.Node<String> node6 = bt.add(node2, "第六个结点", false) ;
		
		System.out.println(bt.deep());
		System.out.println("前序遍历二叉树");
		bt.preOrderTree(bt.root()) ;
		System.out.println("中序遍历二叉树");
		bt.inOrderTree(bt.root()) ;
		System.out.println("后序遍历二叉树");
		bt.postOrderTree(bt.root()) ;
		System.out.println("层次遍历二叉树");
		bt.hiOrderTree(bt.root()) ;
	}

}
