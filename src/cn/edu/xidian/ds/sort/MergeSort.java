package cn.edu.xidian.ds.sort;
/**
 * 归并排序
 * 时间复杂度o(n*log(n))
 * 空间复杂度o(n)
 * 稳定性：稳定
 * @author WangPeng
 */
public class MergeSort {
	
	public static void mergeSort(int[] data){
		 sort(data,0,data.length-1) ; 
	}
	public static void sort(int[] data, int left ,int right){
		if(left<right){
			int middle = (left+right)/2 ;
			sort(data,left,middle) ;
			sort(data,middle+1,right) ;
			merge(data,left,middle,right) ;
		}
	}
	public static void merge(int[] data, int left, int middle, int right) {
		//临时数组
		int[] tempData = new int[data.length] ;
		//临时数组的下表，从left开始，方便后面的数组拷贝回原来的数组
		int third = left ;
		int mid = middle + 1 ;
		//记录数组的起始位置
		int tempLeft = left ;
		//合并两个有序的数组为一个有序数组
		while(left<mid && mid<=right){
			if(data[left]<=data[mid]){
				tempData[third++] = data[left++] ;
			}else{
				tempData[third++] = data[mid++] ;
			}
		}
		while(mid<=right){
			tempData[third++] = data[mid++] ;
		}
		while(left<=middle){
			tempData[third++] = data[left++] ;
		}
		//将来临时数组拷贝回原来的数组
		while(tempLeft<=right){
			data[tempLeft] = tempData[tempLeft] ;
			tempLeft++ ;
		}
	}
	public static void main(String[] args) {
		int[] data = {1,5,34,25,7,3,6,14,23}  ;
		printArray(data);
		mergeSort(data) ;
		printArray(data);
	}
	public static void printArray(int[] data){
		for(int i=0;i<data.length-1;i++){
			System.out.print(data[i] + ",");
		}
		System.out.println(data[data.length-1]);
	}

}
