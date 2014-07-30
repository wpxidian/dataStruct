package cn.edu.xidian.ds.queue;

public class SequenceQueueTest {

	public static void main(String[] args) {
		SequenceQueue<String> sqQueue = new SequenceQueue<String>() ;
		System.out.println("队列长度：" + sqQueue.getSize()) ;
		sqQueue.enQueue("zhangsan") ;
		sqQueue.enQueue("lisi") ;
		sqQueue.enQueue("wagnwu") ;
		System.out.println("队列长度：" + sqQueue.getSize()) ;
		System.out.println("出队元素为：" + sqQueue.deQueue()) ;
		System.out.println("队列长度：" + sqQueue.getSize()) ;
		sqQueue.destory() ;
		System.out.println("队列长度：" + sqQueue.getSize()) ;

	}

}
