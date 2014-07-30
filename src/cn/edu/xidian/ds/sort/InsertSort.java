package cn.edu.xidian.ds.sort;
/**
 * 直接插入排序
 * 时间复杂度o(n2)
 * 空间复杂度o(1)
 * 稳定性：稳定
 * @author WangPeng
 */
public class InsertSort {
	
	public static void insertSort(int[] data) throws Exception{
		if(data == null || data.length<1){
			throw new Exception("数组为空") ;
		}
		for(int i=1;i<data.length;i++){
			int temp = data[i];
			int prev = i ;
			while(data[prev-1]>temp){
				data[prev] = data[prev-1] ;
				prev-- ;
			}
			data[prev] = temp ;
			//printArray(data);
		}
	}
	public static void main(String[] args) throws Exception{
		int[] data = {1,5,34,25,7,3,6,14,23}  ;
		printArray(data);
		insertSort(data) ;
		printArray(data);
	}
	public static void printArray(int[] data){
		for(int i=0;i<data.length-1;i++){
			System.out.print(data[i] + ",");
		}
		System.out.println(data[data.length-1]);
	}
}
