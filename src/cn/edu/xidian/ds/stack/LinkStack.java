package cn.edu.xidian.ds.stack;
/**
 * �����ƣ�LinkStack   
 * ����������ʽջ��ʵ��   
 * �����ˣ�WangPeng  
 * ����ʱ�䣺2014-7-29 ����11:33:17   
 * �޸��ˣ�WangPeng   
 * �޸�ʱ�䣺2014-7-29 ����11:33:17   
 * �޸ı�ע��   
 * @version 1.0   
 *
 */
public class LinkStack<T> {
	private class LinkNode
	{
		private T data ;
		private LinkNode next ;
		public LinkNode(){}
		public LinkNode(T data, LinkNode next){
			this.data = data ;
			this.next = next ;
		}
	}
	//ͷ����ջ�ĳ���
	private LinkNode top ;
	private int size ;
	//1.��ջ�ĳ�ʼ��
	public LinkStack(){
		top = null ;
		size = 0 ;
	}
	public LinkStack(T elem){
		top = new LinkNode(elem,null) ;
		size = 1 ;
	}
	//2.ջ�ĳ���
	public int getSize(){
		return this.size ;
	}
	//3.ջ�Ƿ�Ϊ��
	public boolean isEmpty(){
		return this.size == 0 ;
	}
	//4.Ԫ����ջ����
	public boolean push(T elem){
		top = new LinkNode(elem,top) ;
		size++ ;
		return true ;
	}
	//5.Ԫ�س�ջ����
	public T pop(){
		LinkNode oldNode = top ;
		top = top.next ;
		size-- ;
		return oldNode.data ;
	}
	//6.����ջ
	public void destory(){
		while(top!=null){
			LinkNode node = top.next ;
			top = null ;
			top = node ;
		}
		size = 0 ;
	}
}
