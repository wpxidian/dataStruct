package cn.edu.xidian.ds.queue;
/**
 * 类名称：SequenceQueue   
 * 类描述：顺序队列的实现  
 * 创建人：WangPeng  
 * 创建时间：2014-7-29 下午11:34:10   
 * 修改人：WangPeng   
 * 修改时间：2014-7-29 下午11:34:10   
 * 修改备注：   
 * @version 1.0   
 *
 */
public class SequenceQueue<T> {
	
	private static final int MAX_SIZE = 20 ;
	private Object[] elem ;
	private int front ;
	private int rear ;
	//1.顺序队列的初始化
	public SequenceQueue(){
		elem = new Object[MAX_SIZE] ;
	}
	public SequenceQueue(T data){
		this() ;
		elem[rear++] = data ;
	}
	//2.顺序队列的长度
	public int getSize(){
		return rear - front ;
	}
	//3.顺序队列是否为空
	public boolean isEmpty(){
		return (rear-front) == 0 ;
	}
	//4.顺序队列的入队操作
	public boolean enQueue(T data){
		if(rear>MAX_SIZE-1){
			System.out.println("队列已满");
			return false ;
		}else{
			elem[rear++] = data ;
			return true ;
		}			
	}
	//5.顺序队列的出队操作
	public T deQueue(){
		if(front == rear){
			System.out.println("队列为空");
			return null ;
		}else{
			T oldValue = (T) elem[front] ;
			elem[front++] = null ;
			return oldValue ;
		}
	}
	//6.顺序队列的销毁
	public void destory(){
		while(front<rear){
			elem[front++] = null ;
		}
		front = 0 ;
		rear = 0 ;
	}
}
