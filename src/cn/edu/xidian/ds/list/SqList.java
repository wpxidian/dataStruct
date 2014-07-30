package cn.edu.xidian.ds.list;

import java.util.Arrays;
/**
 * �����ƣ�SqList   
 * ��������˳����ʵ��   
 * �����ˣ�WangPeng  
 * ����ʱ�䣺2014-7-29 ����11:32:50   
 * �޸��ˣ�WangPeng   
 * �޸�ʱ�䣺2014-7-29 ����11:32:50   
 * �޸ı�ע��   
 * @version 1.0   
 *
 */
public class SqList<T>
{
	//private static final int MAX_SIZE = 20 ;
	private Object[] elementData ;
	private int size ;
	
	//1.���Ա�ĳ�ʼ��
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
	//2.���Ա�ĳ���
	public int getSize(){
		return this.size ;
	}
	//3.���Ա��Ƿ�Ϊ��
	public boolean isEmpty(){
		return this.size == 0 ;
	}
	//4.����ĳ��λ�õ�Ԫ��
	@SuppressWarnings("unchecked")
	public T get(int index){
		if(index<0||index>size-1){
			System.out.println("�±겻��ȷ");
			return null ;
		}
		return (T)elementData[index] ;
	}
	//5.ĳ��Ԫ�������Ա��е�λ��
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
	//6.����Ԫ��
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
	//��ָ��λ���ϲ���Ԫ��
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
			//����ʱ�쳣����Ҫ��ʽ����
			throw new ArrayIndexOutOfBoundsException("size:" + size + ",index:" + index) ;
		}
	}
	//7.ɾ��Ԫ��
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
	//8.�������Ա�
	public void clear(){
		for(int i=0;i<size;i++){
			elementData[i] = null ;
		}
		size = 0 ;
	}
	//9.��дtoString
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
