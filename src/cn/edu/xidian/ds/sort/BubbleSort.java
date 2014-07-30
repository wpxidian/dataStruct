package cn.edu.xidian.ds.sort;

/**
 * 冒泡排序
 * 时间复杂度o(n2)
 * 空间复杂度o(1)
 * 稳定性：稳定
 * @author WangPeng
 */
public class BubbleSort {
	
	public static void bubbleSort(int[] data){
		int len = data.length ;
		for(int i=0;i<len-1;i++){
			boolean flag = false ;
			for(int j=0;j<len-i-1;j++){
				if(data[j]>data[j+1]){
					int temp = data[j] ;
					data[j] = data[j+1] ;
					data[j+1] = temp ;
					flag = true ;
				}
			}
			//如果某趟没有数据交换表明数组已经有序
			if(!flag){
				break ;
			}
		}
	}
	public static void main(String[] args) {
		int[] data = {1,5,34,25,7,3,6,14,23}  ;
		printArray(data);
		bubbleSort(data) ;
		printArray(data);
	}
	public static void printArray(int[] data){
		for(int i=0;i<data.length-1;i++){
			System.out.print(data[i] + ",");
		}
		System.out.println(data[data.length-1]);
	}
}
