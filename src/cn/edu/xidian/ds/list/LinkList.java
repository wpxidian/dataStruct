package cn.edu.xidian.ds.list;
/**
 * �����ƣ�LinkList   
 * ��������˫������   
 * �����ˣ�WangPeng  
 * ����ʱ�䣺2014-7-29 ����11:32:31   
 * �޸��ˣ�WangPeng   
 * �޸�ʱ�䣺2014-7-29 ����11:32:31   
 * �޸ı�ע��   
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
	//1.������ĳ�ʼ��
	public LinkList(){
		first = null ;
		last = null ;
		size = 0 ;
	}
	//2.������ĳ���
	public int getSize(){
		return size ;
	}
	//3.�������Ƿ�Ϊ��
	public boolean isEmpty(){
		return size == 0 ;
	}
	//4.����ĳ��λ�õĽ��
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
	//5.����Ԫ�ز���
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
	//6.Ĭ��������ͷ������Ԫ��
	public boolean addFirst(T item){
		add(item,0) ;
		return true ;
	}
	//7.Ĭ��������β������Ԫ��
	public boolean addLast(T item){
		add(item,size) ;
		return true ;
	}
	//8.ɾ��Ԫ�ز���
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
	//9.ɾ����һ�����
	public Node<T> removeFirst(){
		return unLink(0) ;
	}
	//10.ɾ�����һ�����
	public Node<T> removeLast(){
		return unLink(size-1) ;
	}
	//11.��ȡ�����һ�����Ԫ��
	public T getFirst(){
		return first==null ? null : first.item ;
	}
	//12.��ȡ�������һ�����Ԫ��
	public T getLast(){
		return last==null ? null : last.item ;
	}
	//8.�����������
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
	//9.��ӡ����
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
	//10.�����������(�ݹ�)
	public void reversePrint_solution1(){
		reserve(first) ;
	}
	private void reserve(Node<T> p) {
		if(p.next != null){
			reserve(p.next) ;
		}
		System.out.println(p.item) ;
	}	
	//11.�����������(ջ)
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
	//12.��ת������
	public void reverseLinkList(){
		if(isEmpty()){
			System.out.println("������Ϊ��");
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
	//13.������������ĺϲ�
}