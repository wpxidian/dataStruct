package cn.edu.xidian.ds.tree;

public class LinkBiTreeTest {

	public static void main(String[] args) {
		LinkBiTree<String> bt = new LinkBiTree<String>("��") ;
		LinkBiTree.Node<String> node1 = bt.add(bt.root(), "��һ�����", true) ;
		LinkBiTree.Node<String> node2 = bt.add(bt.root(), "�ڶ������", false) ;
		LinkBiTree.Node<String> node3 = bt.add(node1, "���������", true) ;
		LinkBiTree.Node<String> node6 = bt.add(node2, "���������", false) ;
		
		System.out.println(bt.deep());
		System.out.println("ǰ�����������");
		bt.preOrderTree(bt.root()) ;
		System.out.println("�������������");
		bt.inOrderTree(bt.root()) ;
		System.out.println("�������������");
		bt.postOrderTree(bt.root()) ;
		System.out.println("��α���������");
		bt.hiOrderTree(bt.root()) ;
	}

}
