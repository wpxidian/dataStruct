package cn.edu.xidian.ds.stack;

import java.util.Arrays;

public class SequenceStackTest {

	public static void main(String[] args) {
		SequenceStack<String> sqStack = new SequenceStack<String>() ;
		sqStack.push("zhangsan") ;
		sqStack.push("lisi") ;
		sqStack.push("wangwu") ;
		System.out.println("栈中元素:" + Arrays.toString(sqStack.toArray())) ;
		System.out.println("出栈元素:"+sqStack.pop()) ;
		sqStack.destory() ;
		System.out.println("栈中元素个数:" + Arrays.toString(sqStack.toArray())) ;
		sqStack.peek() ;//抛出异常
	}

}
