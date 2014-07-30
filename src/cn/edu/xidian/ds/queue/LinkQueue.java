package cn.edu.xidian.ds.queue;
/**
 * 类名称：LinkQueue   
 * 类描述：链式队列的实现   
 * 创建人：WangPeng  
 * 创建时间：2014-7-29 下午11:33:45   
 * 修改人：WangPeng   
 * 修改时间：2014-7-29 下午11:33:45   
 * 修改备注：   
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
	
	//1.链式队列的初始化
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
	//2.链式队列的长度
	public int getSize(){
		return this.size ;
	}
	//3.链式队列是否为空
	public boolean isEmpty(){
		return this.size == 0 ;
	}
	//4.链式队列的入队操作
	public boolean enQueue(T data){
		//队列为空
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
	//5.链式队列的出队操作
	public T deQueue(){
		if(front == null){
			System.out.println("队列为空");
			return null ;
		}
		LinkNode oldValue = front ;
		//只有一个元素
		if(front == rear){
			front = null ;
			rear = null ;
		}else{
			front = front.next ;
		}
		size-- ;
		return oldValue.data ;
	}
	//6.链式队列的销毁
	public void destory(){
		front = null ;
		rear = null ;
		size = 0 ;
	}
}
