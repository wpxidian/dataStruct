package cn.edu.xidian.ds.stack;
/**
 * 类名称：LinkStack   
 * 类描述：链式栈的实现   
 * 创建人：WangPeng  
 * 创建时间：2014-7-29 下午11:33:17   
 * 修改人：WangPeng   
 * 修改时间：2014-7-29 下午11:33:17   
 * 修改备注：   
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
	//头结点和栈的长度
	private LinkNode top ;
	private int size ;
	//1.链栈的初始化
	public LinkStack(){
		top = null ;
		size = 0 ;
	}
	public LinkStack(T elem){
		top = new LinkNode(elem,null) ;
		size = 1 ;
	}
	//2.栈的长度
	public int getSize(){
		return this.size ;
	}
	//3.栈是否为空
	public boolean isEmpty(){
		return this.size == 0 ;
	}
	//4.元素入栈操作
	public boolean push(T elem){
		top = new LinkNode(elem,top) ;
		size++ ;
		return true ;
	}
	//5.元素出栈操作
	public T pop(){
		LinkNode oldNode = top ;
		top = top.next ;
		size-- ;
		return oldNode.data ;
	}
	//6.销毁栈
	public void destory(){
		while(top!=null){
			LinkNode node = top.next ;
			top = null ;
			top = node ;
		}
		size = 0 ;
	}
}
