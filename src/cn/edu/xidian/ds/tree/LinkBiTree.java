package cn.edu.xidian.ds.tree;

import java.util.ArrayDeque;

/**
 * 
 * 类名称：LinkBiTree   
 * 类描述：二叉树的链式存储   
 * 创建人：WangPeng  
 * 创建时间：2014-7-29 下午11:30:53   
 * 修改人：WangPeng   
 * 修改时间：2014-7-29 下午11:30:53   
 * 修改备注：   
 * @version 1.0   
 *
 */
public class LinkBiTree<T> {

	public static class Node<E>{
		E data ;
		Node<E> left ;
		Node<E> right ;
		public Node(){}
		public Node(E data, Node<E> left, Node<E> right){
			this.data = data ;
			this.left = left ;
			this.right = right ;
		}
	}
	
	private Node<T> root ;
	/**
	 * 
	 */
	public LinkBiTree(){
		root = new Node<T>() ;
	}
	/**
	 * 
	 * @param data
	 */
	public LinkBiTree(T data){
		root = new Node<T>(data,null,null) ;
	}
	/**
	 * 判断二叉树是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return root == null ;
	}
	/**
	 * 返回二叉树的根节点
	 * @return
	 */
	public Node<T> root(){
		return root ;
	}
	/**
	 * 在指定结点处插入左（右）子树
	 * @param parent
	 * @param data
	 * @param left
	 * @return
	 */
	public Node<T> add(Node<T> parent,T data,boolean left){
		isNotNull(parent) ;
		Node<T> newNode = new Node<T>(data, null , null) ;
		if(left){
			parent.left = newNode ;
			return newNode ;
		}else{
			parent.right = newNode ;
			return newNode ;
		}
	}
	/**
	 * 返回二叉树的深度
	 * @return
	 */
	public int deep(){
		return deep(root) ;
	}
	/**
	 * 返回二叉树某个结点的深度
	 * @param node
	 * @return
	 */
	public int deep(Node<T> node) {
		if(node == null){
			return 0 ;
		}
		int leftDeep = deep(node.left) + 1 ;
		int rightDeep = deep(node.right) + 1 ;
		return leftDeep>rightDeep?leftDeep:rightDeep;
	}
	/**
	 * 判断结点是否为空
	 * @param parent
	 */
	private void isNotNull(Node<T> parent) {
		if(parent == null){
			throw new RuntimeException("结点为空") ;
		}
	}
	/**
	 * 前序遍历二叉树
	 * @param node
	 */
	public void preOrderTree(Node<T> node){
		 if(node != null){
			 System.out.println(node.data);
			 preOrderTree(node.left) ;
			 preOrderTree(node.right) ;
		 }
	}
	/**
	 * 中序遍历二叉树
	 * @param node
	 */
	public void inOrderTree(Node<T> node){
		if(node != null){
			 inOrderTree(node.left) ;
			 System.out.println(node.data);
			 inOrderTree(node.right) ;
		}
	}
	/**
	 * 后序遍历二叉树
	 * @param node
	 */
	public void postOrderTree(Node<T> node){
		if(node != null){
			 postOrderTree(node.left) ;
			 postOrderTree(node.right) ;
			 System.out.println(node.data);
		}
	}
	/**
	 * 层次遍历二叉树
	 * @param node
	 */
	public void hiOrderTree(Node<T> node){
		if(node != null){
			ArrayDeque<Node<T>> deque = new ArrayDeque<Node<T>>() ;
			deque.add(node) ;
			while(!deque.isEmpty()){
				Node<T> pNode = deque.removeFirst() ;
				if(pNode.left != null){
					deque.add(pNode.left) ;
				}
				if(pNode.right != null){
					deque.add(pNode.right) ;
				}
				System.out.println(pNode.data);
			}
		}
	}
}
