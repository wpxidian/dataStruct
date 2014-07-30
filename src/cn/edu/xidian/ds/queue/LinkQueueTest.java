package cn.edu.xidian.ds.queue;

public class LinkQueueTest {

	public static void main(String[] args) {
		LinkQueue<String> linkQueue = new LinkQueue<String>() ;
		System.out.println("队列长度为："+linkQueue.getSize()) ;
		linkQueue.enQueue("zhangsan") ;
		linkQueue.enQueue("lisi") ;
		linkQueue.enQueue("wangwu") ;
		System.out.println("队列长度为："+linkQueue.getSize()) ;
		System.out.println("出队元素为："+linkQueue.deQueue()) ;
		System.out.println("队列长度为："+linkQueue.getSize()) ;
		linkQueue.destory() ;
		System.out.println("队列长度为："+linkQueue.getSize()) ;

	}

}
