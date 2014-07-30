package cn.edu.xidian.ds.tree;

import java.util.Arrays;
/**
 * 类名称：ArrayBiTree   
 * 类描述：二叉树的顺序存储  
 * 创建人：WangPeng  
 * 创建时间：2014-7-29 下午11:31:27   
 * 修改人：WangPeng   
 * 修改时间：2014-7-29 下午11:31:27   
 * 修改备注：   
 * @version 1.0   
 *
 */
public class ArrayBiTree<T> {
	
	private static final int DEFALUT_DEEP = 8 ;
	private Object[] elementData ;
	private int arrayLength ;
	private int deep ;
	/**
	 * 
	 */
	public ArrayBiTree(){
		this(DEFALUT_DEEP) ;
	}
	/**
	 * 
	 * @param deep
	 */
	public ArrayBiTree(int deep){
		arrayLength = (int) Math.pow(2, deep) - 1 ;
		elementData = new Object[arrayLength] ;
		this.deep = deep ;
	}
	/**
	 * 
	 * @param data
	 */
	public ArrayBiTree(T data){
		this(DEFALUT_DEEP,data) ;
	}
	/**
	 * 
	 * @param deep
	 * @param data
	 */
	public ArrayBiTree(int deep,T data){
		arrayLength = (int) Math.pow(2, deep) - 1 ;
		elementData = new Object[arrayLength] ;
		this.deep = deep ;
		elementData[0] = data ;
	}
	/**
	 * 判断二叉树是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return elementData[0] == null ;
	}
	/**
	 * 返回二叉树的深度
	 * @return
	 */
	public int deep(){
		return deep ;
	}
	/**
	 * 返回二叉树的根节点
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T root(){
		return (T) elementData[0] ;
	}
	/**
	 * 在索引为pIndex处插入子节点
	 * @param pIndex
	 * @param data
	 * @param left
	 * @return
	 */
	public boolean add(int pIndex,T data,boolean left){
		if(pIndex<0 || pIndex>arrayLength){
			throw new ArrayIndexOutOfBoundsException(pIndex) ;
		}
		if(elementData[pIndex] == null){
			throw new RuntimeException("索引" + pIndex +"处的结点为空") ;
		}
		if(left){
			if(pIndex*2+1<arrayLength){
				elementData[pIndex*2+1] = data ;
				return true ;
			}
			throw new RuntimeException("数组已满，无法存储左子树") ;
		}else{
			if(pIndex*2+2<arrayLength){
				elementData[pIndex*2+2] = data ;
				return true ;
			}
			throw new RuntimeException("数组已满，无法存储右子树") ;
		}
	}
	/**
	 * 在结点parent处插入子节点
	 * @param parent
	 * @param data
	 * @param left
	 * @return
	 */
	public boolean add(T parent,T data, boolean left){
		isExit(parent) ;
		int position = pos(parent) ;
		if(position > 0){
			add(position,data,left) ;
			return true ;
		}
		return false ;
	}
	/**
	 * 返回左子树的根节点
	 * @param pIndex
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T left(int pIndex){
		if(pIndex*2+1>=arrayLength){
			throw new RuntimeException("超出数组界限") ;
		}
		return (T) elementData[pIndex*2+1] ;
	}
	/**
	 * 返回结点的左子树
	 * @param parent
	 * @return
	 */
	public T left(T parent){
		isExit(parent) ;
		int position = pos(parent) ;
		if(position > 0){
			return left(position) ;
		}
		return null ;
	}
	/**
	 * 判断某个结点是否存在
	 * @param node
	 */
	private void isExit(T node) {
		if(node == null){
			throw new RuntimeException("父节点结点为空") ;
		}
	}
	/**
	 * 返回右子树的根节点
	 * @param pIndex
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T right(int pIndex){
		if(pIndex*2+2>=arrayLength){
			throw new RuntimeException("超出数组界限") ;
		}
		return (T) elementData[pIndex*2+2] ;
	}
	/**
	 * 返回结点的右子树
	 * @param parent
	 * @return
	 */
	public T right(T parent){
		isExit(parent) ;
		int position = pos(parent) ;
		if(position > 0){
			return right(position) ;
		}
		return null ;
	}
	/**
	 * 返回父结点
	 * @param index
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T parent(int index){
		if(index<0 || index>=arrayLength){
			throw new ArrayIndexOutOfBoundsException(index) ;
		}
		return (T) elementData[(index-1)/2] ;
	}
	/**
	 * 返回结点的索引
	 * @param data
	 * @return
	 */
	/**
	 * 
	 * @Description: TODO
	 * @param @param data
	 * @param @return
	 * @return int
	 * @throws
	 */
	public int pos(T data){
		for(int i=0;i<arrayLength;i++){
			if(data.equals(elementData[i])){
				return i ;
			}
		}
		return -1 ;
	}
	/**
	 */
	public String toString(){
		return Arrays.toString(elementData) ;
	}
}
