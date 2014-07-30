package cn.edu.xidian.ds.tree;

import java.util.ArrayDeque;

/**
 * 
 * �����ƣ�LinkBiTree   
 * ������������������ʽ�洢   
 * �����ˣ�WangPeng  
 * ����ʱ�䣺2014-7-29 ����11:30:53   
 * �޸��ˣ�WangPeng   
 * �޸�ʱ�䣺2014-7-29 ����11:30:53   
 * �޸ı�ע��   
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
	 * �ж϶������Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return root == null ;
	}
	/**
	 * ���ض������ĸ��ڵ�
	 * @return
	 */
	public Node<T> root(){
		return root ;
	}
	/**
	 * ��ָ����㴦�������ң�����
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
	 * ���ض����������
	 * @return
	 */
	public int deep(){
		return deep(root) ;
	}
	/**
	 * ���ض�����ĳ���������
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
	 * �жϽ���Ƿ�Ϊ��
	 * @param parent
	 */
	private void isNotNull(Node<T> parent) {
		if(parent == null){
			throw new RuntimeException("���Ϊ��") ;
		}
	}
	/**
	 * ǰ�����������
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
	 * �������������
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
	 * �������������
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
	 * ��α���������
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
