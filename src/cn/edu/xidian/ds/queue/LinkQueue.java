package cn.edu.xidian.ds.queue;
/**
 * �����ƣ�LinkQueue   
 * ����������ʽ���е�ʵ��   
 * �����ˣ�WangPeng  
 * ����ʱ�䣺2014-7-29 ����11:33:45   
 * �޸��ˣ�WangPeng   
 * �޸�ʱ�䣺2014-7-29 ����11:33:45   
 * �޸ı�ע��   
 * @version 1.0   
 *
 */
public class LinkQueue<T> {
	private class LinkNode{
		private T data ;
		private LinkNode next ;
		public LinkNode(){}
		public LinkNode(T data,LinkNode next){
			this.data = data ;
			this.next = next ;
		}
	}
	private LinkNode front ;
	private LinkNode rear ;
	private int size ;
	
	//1.��ʽ���еĳ�ʼ��
	public LinkQueue(){
		front = null ;
		rear = null ;
		size = 0 ;
	}
	public LinkQueue(T data){
		front = new LinkNode(data,null) ;
		rear = front ;
		size++ ;
	}
	//2.��ʽ���еĳ���
	public int getSize(){
		return this.size ;
	}
	//3.��ʽ�����Ƿ�Ϊ��
	public boolean isEmpty(){
		return this.size == 0 ;
	}
	//4.��ʽ���е���Ӳ���
	public boolean enQueue(T data){
		//����Ϊ��
		if(rear == null){
			front = new LinkNode(data,null) ;
			rear = front ;
		}else{
			LinkNode newNode = new LinkNode(data,null) ;
			rear.next = newNode ;
			rear = newNode ;
		}
		size++ ;
		return true ;
	}
	//5.��ʽ���еĳ��Ӳ���
	public T deQueue(){
		if(front == null){
			System.out.println("����Ϊ��");
			return null ;
		}
		LinkNode oldValue = front ;
		//ֻ��һ��Ԫ��
		if(front == rear){
			front = null ;
			rear = null ;
		}else{
			front = front.next ;
		}
		size-- ;
		return oldValue.data ;
	}
	//6.��ʽ���е�����
	public void destory(){
		front = null ;
		rear = null ;
		size = 0 ;
	}
}
