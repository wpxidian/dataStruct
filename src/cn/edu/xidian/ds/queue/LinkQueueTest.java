package cn.edu.xidian.ds.queue;

public class LinkQueueTest {

	public static void main(String[] args) {
		LinkQueue<String> linkQueue = new LinkQueue<String>() ;
		System.out.println("���г���Ϊ��"+linkQueue.getSize()) ;
		linkQueue.enQueue("zhangsan") ;
		linkQueue.enQueue("lisi") ;
		linkQueue.enQueue("wangwu") ;
		System.out.println("���г���Ϊ��"+linkQueue.getSize()) ;
		System.out.println("����Ԫ��Ϊ��"+linkQueue.deQueue()) ;
		System.out.println("���г���Ϊ��"+linkQueue.getSize()) ;
		linkQueue.destory() ;
		System.out.println("���г���Ϊ��"+linkQueue.getSize()) ;

	}

}
