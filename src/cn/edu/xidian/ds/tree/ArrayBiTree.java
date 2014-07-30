package cn.edu.xidian.ds.tree;

import java.util.Arrays;
/**
 * �����ƣ�ArrayBiTree   
 * ����������������˳��洢  
 * �����ˣ�WangPeng  
 * ����ʱ�䣺2014-7-29 ����11:31:27   
 * �޸��ˣ�WangPeng   
 * �޸�ʱ�䣺2014-7-29 ����11:31:27   
 * �޸ı�ע��   
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
	 * �ж϶������Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return elementData[0] == null ;
	}
	/**
	 * ���ض����������
	 * @return
	 */
	public int deep(){
		return deep ;
	}
	/**
	 * ���ض������ĸ��ڵ�
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T root(){
		return (T) elementData[0] ;
	}
	/**
	 * ������ΪpIndex�������ӽڵ�
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
			throw new RuntimeException("����" + pIndex +"���Ľ��Ϊ��") ;
		}
		if(left){
			if(pIndex*2+1<arrayLength){
				elementData[pIndex*2+1] = data ;
				return true ;
			}
			throw new RuntimeException("�����������޷��洢������") ;
		}else{
			if(pIndex*2+2<arrayLength){
				elementData[pIndex*2+2] = data ;
				return true ;
			}
			throw new RuntimeException("�����������޷��洢������") ;
		}
	}
	/**
	 * �ڽ��parent�������ӽڵ�
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
	 * �����������ĸ��ڵ�
	 * @param pIndex
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T left(int pIndex){
		if(pIndex*2+1>=arrayLength){
			throw new RuntimeException("�����������") ;
		}
		return (T) elementData[pIndex*2+1] ;
	}
	/**
	 * ���ؽ���������
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
	 * �ж�ĳ������Ƿ����
	 * @param node
	 */
	private void isExit(T node) {
		if(node == null){
			throw new RuntimeException("���ڵ���Ϊ��") ;
		}
	}
	/**
	 * �����������ĸ��ڵ�
	 * @param pIndex
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T right(int pIndex){
		if(pIndex*2+2>=arrayLength){
			throw new RuntimeException("�����������") ;
		}
		return (T) elementData[pIndex*2+2] ;
	}
	/**
	 * ���ؽ���������
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
	 * ���ظ����
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
	 * ���ؽ�������
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
