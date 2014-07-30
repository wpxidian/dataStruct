package cn.edu.xidian.ds.queue;
/**
 * �����ƣ�SequenceQueue   
 * ��������˳����е�ʵ��  
 * �����ˣ�WangPeng  
 * ����ʱ�䣺2014-7-29 ����11:34:10   
 * �޸��ˣ�WangPeng   
 * �޸�ʱ�䣺2014-7-29 ����11:34:10   
 * �޸ı�ע��   
 * @version 1.0   
 *
 */
public class SequenceQueue<T> {
	
	private static final int MAX_SIZE = 20 ;
	private Object[] elem ;
	private int front ;
	private int rear ;
	//1.˳����еĳ�ʼ��
	public SequenceQueue(){
		elem = new Object[MAX_SIZE] ;
	}
	public SequenceQueue(T data){
		this() ;
		elem[rear++] = data ;
	}
	//2.˳����еĳ���
	public int getSize(){
		return rear - front ;
	}
	//3.˳������Ƿ�Ϊ��
	public boolean isEmpty(){
		return (rear-front) == 0 ;
	}
	//4.˳����е���Ӳ���
	public boolean enQueue(T data){
		if(rear>MAX_SIZE-1){
			System.out.println("��������");
			return false ;
		}else{
			elem[rear++] = data ;
			return true ;
		}			
	}
	//5.˳����еĳ��Ӳ���
	public T deQueue(){
		if(front == rear){
			System.out.println("����Ϊ��");
			return null ;
		}else{
			T oldValue = (T) elem[front] ;
			elem[front++] = null ;
			return oldValue ;
		}
	}
	//6.˳����е�����
	public void destory(){
		while(front<rear){
			elem[front++] = null ;
		}
		front = 0 ;
		rear = 0 ;
	}
}
