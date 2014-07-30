package cn.edu.xidian.ds.list;
/**
 * 类名称：LinkList   
 * 类描述：双向链表   
 * 创建人：WangPeng  
 * 创建时间：2014-7-29 下午11:32:31   
 * 修改人：WangPeng   
 * 修改时间：2014-7-29 下午11:32:31   
 * 修改备注：   
 * @version 1.0   
 *
 */
public class LinkList<T>
{
	private class Node<E>{
		E item ;
		Node<E> prev ;
		Node<E> next ;
		Node(Node<E> prev,E item, Node<E> next){
			this.item = item ;
			this.prev = prev ;
			this.next = next ;
		}
	}
	
	private Node<T> first ;
	private Node<T> last ;
	private int size ;
	public Node<T> getfirst(){
		return this.first ;
	}
	//1.单链表的初始化
	public LinkList(){
		first = null ;
		last = null ;
		size = 0 ;
	}
	//2.单链表的长度
	public int getSize(){
		return size ;
	}
	//3.单链表是否为空
	public boolean isEmpty(){
		return size == 0 ;
	}
	//4.查找某个位置的结点
	@SuppressWarnings("unchecked")
	public T get(int index){
		checkPositionIndex(index) ;
		return (T) node(index) ;
	}
	public Node<T> node(int index){
		if(index<(size>>1)){
			Node<T> f = first ;
			for(int i=0;i<index;i++){
				f = f.next ;
			}
			return f ;
		}else{
			Node<T> l = last ;
			for(int i=size-1;i>index;i--){
				l = l.prev ;
			}
			return l ;
		}
	}
	private void checkPositionIndex(int index) {
		if(index<0 || index>size-1){
			throw new ArrayIndexOutOfBoundsException("Size:" + size + ",Index:" + index);
		}
	}
	//5.插入元素操作
	public boolean add(T item, int index){
		checkPositionIndexForAdd(index) ;
		if(index == 0){
			if(first == null){
				first = new Node<T>(null,item,null) ;
				last = first ;
			}else{
				Node<T> newNode = new Node<T>(null,item,first) ;
				first.prev = newNode ;
				first = newNode ;
			}
		}else if(index == size){
			Node<T> newNode = new Node<T>(last,item,null) ;
			last.next = newNode ;
			last = newNode ;
		}else{
			Node<T> p = node(index) ;
			Node<T> prev = p.prev ;
			Node<T> next = p.next ;
			Node<T> newNode = new Node<T>(prev,item,next) ;
			if(prev == null){
				first = newNode ;
			}else{
				prev.next = newNode ;
			}
			if(next == null){
				last = newNode ;
			}else{
				next.prev = newNode ;
			}
		}
		size++ ;
		return true ;
	}
	private void checkPositionIndexForAdd(int index) {
		if(index<0 || index>size){
			throw new ArrayIndexOutOfBoundsException("Size:" + size + ",Index:" + index);
		}
	}
	//6.默认在链表头部插入元素
	public boolean addFirst(T item){
		add(item,0) ;
		return true ;
	}
	//7.默认在链表尾部插入元素
	public boolean addLast(T item){
		add(item,size) ;
		return true ;
	}
	//8.删除元素操作
	public T remove(int index){
		return unLink(index).item ;
	}
	public Node<T> unLink(int index){
		checkPositionIndex(index) ;
		Node<T> oldNode = node(index) ;
		Node<T> prev = oldNode.prev ;
		Node<T> next = oldNode.next ;
		if(prev == null){
			first = next ;
		}else{
			prev.next = next ;
			oldNode.prev = null ;
		}
		if(next == null){
			last = prev ;
		}else{
			next.prev = prev ;
			oldNode.next = null ;
		}
		size-- ;
		return oldNode ;
	}
	//9.删除第一个结点
	public Node<T> removeFirst(){
		return unLink(0) ;
	}
	//10.删除最后一个结点
	public Node<T> removeLast(){
		return unLink(size-1) ;
	}
	//11.获取链表第一个结点元素
	public T getFirst(){
		return first==null ? null : first.item ;
	}
	//12.获取链表最后一个结点元素
	public T getLast(){
		return last==null ? null : last.item ;
	}
	//8.单链表的销毁
	public void clear(){
		for(Node<T> p=first;p!=null;){
			Node<T> next = p.next ;
			p.item = null ;
			p.next = null ;
			p.prev = null ;
			p = next ;
		}
		first = last = null ;
		size = 0 ;
	}
	//9.打印链表
	public String toString(){
		if(first == null){
			return "[]" ;
		}
		StringBuilder sb = new StringBuilder("[") ;
		for(Node<T> p=first;p!=null;p=p.next){
			sb.append(p.item.toString()) ;
			if(p == last){
				return sb.append("]").toString() ;
			}
			sb.append(",") ;
		}
		return null ;
	}
	/**  ************************************************************************************************** */
	//10.单链表倒序输出(递归)
	public void reversePrint_solution1(){
		reserve(first) ;
	}
	private void reserve(Node<T> p) {
		if(p.next != null){
			reserve(p.next) ;
		}
		System.out.println(p.item) ;
	}	
	//11.单链表倒序输出(栈)
	public void reversePrint_solution2(){
		cn.edu.xidian.ds.stack.LinkStack<T> stack = new cn.edu.xidian.ds.stack.LinkStack<T>() ;
		Node<T> p = first ;
		while(p != null){
			stack.push(p.item) ;
			p = p.next ;
		}
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}
	//12.反转单链表
	public void reverseLinkList(){
		if(isEmpty()){
			System.out.println("单链表为空");
			return ;
		}
		Node<T> p = first.next ;
		first.next = null ;
		Node<T> q = p ;
		while(p!=null){
			q = p.next ;
			p.next = first ;
			first = p ;
			p = q ;
		}
	}
	//13.两个有序单链表的合并
}