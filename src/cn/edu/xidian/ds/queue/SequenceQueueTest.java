package cn.edu.xidian.ds.queue;

public class SequenceQueueTest {

	public static void main(String[] args) {
		SequenceQueue<String> sqQueue = new SequenceQueue<String>() ;
		System.out.println("���г��ȣ�" + sqQueue.getSize()) ;
		sqQueue.enQueue("zhangsan") ;
		sqQueue.enQueue("lisi") ;
		sqQueue.enQueue("wagnwu") ;
		System.out.println("���г��ȣ�" + sqQueue.getSize()) ;
		System.out.println("����Ԫ��Ϊ��" + sqQueue.deQueue()) ;
		System.out.println("���г��ȣ�" + sqQueue.getSize()) ;
		sqQueue.destory() ;
		System.out.println("���г��ȣ�" + sqQueue.getSize()) ;

	}

}
