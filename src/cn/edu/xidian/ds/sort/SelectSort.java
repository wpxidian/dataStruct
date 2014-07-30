package cn.edu.xidian.ds.sort;
/**
 * 直接选择排序
 * 时间复杂度o(n2)
 * 空间复杂度o(1)
 * 稳定性：不稳定
 * @author WangPeng
 *
 */
public class SelectSort {

	public static void selectSort(int[] data){
		for(int i=0;i<data.length;i++){
			int minDataIndex = i ; //每趟最小数的下标
			for(int j=i+1;j<data.length;j++){
				if(data[j]<data[minDataIndex]){
					minDataIndex = j ;
				}
			}
			if(data[minDataIndex]<data[i]){//或者minDataIndex != i
				int temp = data[minDataIndex] ;
				data[minDataIndex] = data[i] ;
				data[i] = temp ;
			}
		}
	}
	public static void main(String[] args){
		int[] data = {1,5,34,25,7,3,6,14,23}  ;
		printArray(data);
		selectSort(data) ;
		printArray(data);
	}
	public static void printArray(int[] data){
		for(int i=0;i<data.length-1;i++){
			System.out.print(data[i] + ",");
		}
		System.out.println(data[data.length-1]);
	}
}
