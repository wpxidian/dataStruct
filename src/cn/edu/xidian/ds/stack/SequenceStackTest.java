package cn.edu.xidian.ds.stack;

import java.util.Arrays;

public class SequenceStackTest {

	public static void main(String[] args) {
		SequenceStack<String> sqStack = new SequenceStack<String>() ;
		sqStack.push("zhangsan") ;
		sqStack.push("lisi") ;
		sqStack.push("wangwu") ;
		System.out.println("ջ��Ԫ��:" + Arrays.toString(sqStack.toArray())) ;
		System.out.println("��ջԪ��:"+sqStack.pop()) ;
		sqStack.destory() ;
		System.out.println("ջ��Ԫ�ظ���:" + Arrays.toString(sqStack.toArray())) ;
		sqStack.peek() ;//�׳��쳣
	}

}
