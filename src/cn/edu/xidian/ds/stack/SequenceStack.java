package cn.edu.xidian.ds.stack;

import java.util.Arrays;
/**
 * 类名称：SequenceStack   
 * 类描述：顺序栈的实现   
 * 创建人：WangPeng  
 * 创建时间：2014-7-29 下午11:33:30   
 * 修改人：WangPeng   
 * 修改时间：2014-7-29 下午11:33:30   
 * 修改备注：   
 * @version 1.0   
 *
 */
public class SequenceStack<T> {
	//private static final int MAX_SIZE = 20 ;
	private Object[] elementData ;
	int capacityIncrement ;
	private int size ;
	
	//1.初始化线性栈
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
	//2.获取栈的长度
	public int getLength(){
		return size ;
	}
	//3.判断栈是否为空
	public boolean isEmpty(){
		return size == 0 ;
	}
	//4.元素进栈
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
	//5.元素出栈
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
	//6.转化成数组
	public Object[] toArray(){
		return Arrays.copyOf(elementData, size) ;
	}
	//7.销毁栈
	public void destory(){
		for(int i=0;i<size;i++){
			elementData[i] = null ;
		}
		size = 0 ;
	}
}
