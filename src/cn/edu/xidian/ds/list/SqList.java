package cn.edu.xidian.ds.list;

import java.util.Arrays;
/**
 * 类名称：SqList   
 * 类描述：顺序表的实现   
 * 创建人：WangPeng  
 * 创建时间：2014-7-29 下午11:32:50   
 * 修改人：WangPeng   
 * 修改时间：2014-7-29 下午11:32:50   
 * 修改备注：   
 * @version 1.0   
 *
 */
public class SqList<T>
{
	//private static final int MAX_SIZE = 20 ;
	private Object[] elementData ;
	private int size ;
	
	//1.线性表的初始化
	public SqList(int initialCapacity){
		if(initialCapacity<0){
			 throw new IllegalArgumentException("Illegal Capacity: "+
                     initialCapacity);
		}
		elementData = new Object[initialCapacity] ;
	}
	public SqList(){
		this(10) ;
	}
	//2.线性表的长度
	public int getSize(){
		return this.size ;
	}
	//3.线性表是否为空
	public boolean isEmpty(){
		return this.size == 0 ;
	}
	//4.查找某个位置的元素
	@SuppressWarnings("unchecked")
	public T get(int index){
		if(index<0||index>size-1){
			System.out.println("下标不正确");
			return null ;
		}
		return (T)elementData[index] ;
	}
	//5.某个元素在线性表中的位置
	public int indexOf(T data){
		if(data == null){
			for(int i=0;i<size;i++){
				if(null == elementData[i]){
					return i ;
				}
			}
		}else{
			for(int i=0;i<size;i++){
				if(data.equals(elementData[i])){
					return i ;
				}
			}
		}
		return -1 ;
	}
	public int lastIndexOf(T data){
		if(data == null){
			for(int i=size-1;i>=0;i--){
				if(null == elementData[i]){
					return i ;
				}
			}
		}else{
			for(int i=size-1;i>=0;i--){
				if(data.equals(elementData[i])){
					return i ;
				}
			}
		}
		return -1 ;
	}
	//6.插入元素
	public boolean add(T data){
		ensureCapacity(size + 1) ;
		elementData[size++] = data ;
		return true ;
	}
	private void ensureCapacity(int minCapacity) {
		if(minCapacity - elementData.length > 0){
			grow(minCapacity) ;
		}
	}
	private void grow(int minCapacity) {
		int oldCapacity = elementData.length ;
		int newCapacity = oldCapacity + (oldCapacity>>1) ;
		if(newCapacity<minCapacity){
			newCapacity = minCapacity ;
		}
		elementData = Arrays.copyOf(elementData, newCapacity) ;
	}
	//在指定位置上插入元素
	public boolean add(T data,int index){
		rangeCheckForAdd(index) ;
		ensureCapacity(size + 1) ;
		System.arraycopy(elementData, index, elementData, index+1, size - index) ;
		elementData[index] = data ;
		size++ ;
		return true ;
	}
	private void rangeCheckForAdd(int index) {
		if(index<0||index>size){
			//运行时异常不需要显式捕获
			throw new ArrayIndexOutOfBoundsException("size:" + size + ",index:" + index) ;
		}
	}
	//7.删除元素
	public T remove(int index){
		rangeCheckForRemove(index) ;
		T oldValue = (T)elementData[index] ;
		System.arraycopy(elementData, index+1, elementData, index, size - index - 1) ;	
		elementData[--size] = null ;
		return oldValue ;
	}
	private void rangeCheckForRemove(int index) {
		if(index<0||index>size-1){
			throw new ArrayIndexOutOfBoundsException("size:" + size + ",index:" + index) ;
		}
	}
	//8.销毁线性表
	public void clear(){
		for(int i=0;i<size;i++){
			elementData[i] = null ;
		}
		size = 0 ;
	}
	//9.重写toString
	@Override
	public String toString(){
		if(size == 0){
			return "[]" ;
		}
		StringBuilder sb = new StringBuilder("[") ;
		for(int i=0;i<size;i++){
			sb.append(elementData[i].toString()) ;
			if(i == size - 1){
				return sb.append("]").toString() ;
			}
			sb.append(",") ;
		}
		return null ;
	}
}
