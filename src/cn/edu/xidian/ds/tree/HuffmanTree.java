package cn.edu.xidian.ds.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
/**
 * 
 * 类名称：HuffmanTree   
 * 类描述：哈夫曼树   
 * 创建人：WangPeng  
 * 创建时间：2014-7-30 上午10:10:24   
 * 修改人：WangPeng   
 * 修改时间：2014-7-30 上午10:10:24   
 * 修改备注：   
 * @version 1.0   
 *
 */
public class HuffmanTree<T> {
	
	private static class Node<E>{
		E data ;
		double weight ;
		Node<E> left ;
		Node<E> right ;
		public Node(E data,double weight){
			this.data = data ;
			this.weight = weight ;
		}
	}
	/**
	 * 构建哈夫曼树
	 * @param nodes
	 * @return
	 */
	public Node<T> createHuffmanTree(List<Node<T>> nodes){
		while(nodes.size() > 1){
			quickSort(nodes) ;
			Node<T> left = nodes.get(0) ;
			Node<T> right = nodes.get(1) ;
			Node<T> parent = new Node<T>(null,left.weight + right.weight) ;
			parent.left = left ;
			parent.right = right ;
			nodes.remove(left) ;
			nodes.remove(right) ;
			nodes.add(parent) ;
		}
		return nodes.get(0) ;
	}
	/**
	 * 快速排序
	 * @param nodes
	 */
	private void quickSort(List<Node<T>> nodes) {
		subSort(nodes,0,nodes.size()-1) ;
	}
	private void subSort(List<Node<T>> nodes, int first, int last) {
		int privot = parition(nodes,first,last) ;
		if(first<privot){
			parition(nodes,first,privot-1) ;
		}else if(last>privot){
			parition(nodes,privot+1,last) ;
		}
	}
	private int parition(List<Node<T>> nodes, int first, int last) {
		int privot = (first+last)>>1 ;
		while(first<last){
			while(first<privot && nodes.get(first).weight<=nodes.get(privot).weight){
				first++ ;
			}
			if(nodes.get(first).weight>nodes.get(privot).weight){
				swap(nodes,first,privot) ;
				privot = first ;
			}
			while(privot<last && nodes.get(last).weight>=nodes.get(privot).weight){
				last-- ;
			}
			if(nodes.get(last).weight<nodes.get(privot).weight){
				swap(nodes,last,privot) ;
				privot = last ;
			}
		}
		return privot ;
	}
	private void swap(List<Node<T>> nodes, int first, int privot) {
		Node<T> temp = nodes.get(privot) ;
		nodes.set(privot, nodes.get(first)) ;
		nodes.set(first, temp) ;
	}
	/**
	 * 中序遍历哈夫曼树
	 * @param root
	 * @return
	 */
	public List<Node<T>> hiOrderHuffmanTree(Node<T> root){
		List<Node<T>> nodes = new ArrayList<Node<T>>() ;
		Deque<Node<T>> deque = new ArrayDeque<Node<T>>() ;
		if(root != null){
			deque.add(root) ;
			while(!deque.isEmpty()){
				Node<T> remNode = deque.removeFirst() ;
				nodes.add(remNode) ;
				if(remNode.left != null){
					deque.add(remNode.left) ;
				}
				if(remNode.right != null){
					deque.add(remNode.right) ;
				}
			}
		}
		return nodes ;
	}
	public static void main(String[] args) {
		HuffmanTree<String> ht = new HuffmanTree<>() ;
		List<Node<String>> nodes = new ArrayList<Node<String>>() ;
		Node<String> node1 = new Node<String>("A",7) ;
		Node<String> node2 = new Node<String>("B",5) ;
		Node<String> node3 = new Node<String>("C",2) ;
		Node<String> node4 = new Node<String>("D",4) ;
		nodes.add(node1) ;
		nodes.add(node2) ;
		nodes.add(node3) ;
		nodes.add(node4) ;
		Node<String> root = ht.createHuffmanTree(nodes) ;
		nodes = ht.hiOrderHuffmanTree(root) ;
		for(Node<String> node:nodes){
			System.out.println(node.data);
		}
	}

}
