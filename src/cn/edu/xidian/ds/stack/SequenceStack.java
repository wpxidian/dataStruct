package cn.edu.xidian.ds.stack;

import java.util.Arrays;
/**
 * �����ƣ�SequenceStack   
 * ��������˳��ջ��ʵ��   
 * �����ˣ�WangPeng  
 * ����ʱ�䣺2014-7-29 ����11:33:30   
 * �޸��ˣ�WangPeng   
 * �޸�ʱ�䣺2014-7-29 ����11:33:30   
 * �޸ı�ע��   
 * @version 1.0   
 *
 */
public class SequenceStack<T> {
	//private static final int MAX_SIZE = 20 ;
	private Object[] elementData ;
	int capacityIncrement ;
	private int size ;
	
	//1.��ʼ������ջ
	public SequenceStack(int initialCapacity,int capacityIncrement){
		if(initialCapacity < 0){
			throw new IllegalArgumentException("Illegal Capacity: "+ initialCapacity) ;
		}
		elementData = new Object[initialCapacity] ;
		this.capacityIncrement = capacityIncrement ;
	}
	public SequenceStack(int initialCapacity){
		this(initialCapacity, 0) ;
	}
	public SequenceStack(){
		this(10) ;
	}
	//2.��ȡջ�ĳ���
	public int getLength(){
		return size ;
	}
	//3.�ж�ջ�Ƿ�Ϊ��
	public boolean isEmpty(){
		return size == 0 ;
	}
	//4.Ԫ�ؽ�ջ
	public boolean push(Object e){
		ensureCapacity(size + 1) ;
		elementData[size++] = e ;
		return true ;
	}
	private void ensureCapacity(int minCapacity) {
		if(minCapacity - elementData.length > 0){
			grow(minCapacity) ;
		}
	}
	private void grow(int minCapacity) {
		int oldCapacity = elementData.length ;
		int newCapacity = oldCapacity + ((capacityIncrement>0)?
				capacityIncrement:(capacityIncrement>>1)) ;
		if(newCapacity < minCapacity){
			newCapacity = minCapacity ;
		}
		elementData = Arrays.copyOf(elementData, newCapacity) ;
	}
	//5.Ԫ�س�ջ
	@SuppressWarnings("unchecked")
	public T peek(){
		if(isEmpty()){
			throw new ArrayIndexOutOfBoundsException("Stack Is Empty.") ;
		}
		return (T) elementData[size - 1] ;
	}
	public T pop(){
		T oldValue = peek() ;
		elementData[--size] =  null ;
		return oldValue ;
	}
	//6.ת��������
	public Object[] toArray(){
		return Arrays.copyOf(elementData, size) ;
	}
	//7.����ջ
	public void destory(){
		for(int i=0;i<size;i++){
			elementData[i] = null ;
		}
		size = 0 ;
	}
}
