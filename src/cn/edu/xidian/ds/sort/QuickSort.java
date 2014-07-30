package cn.edu.xidian.ds.sort;
/**
 * 快速排序
 * 时间复杂度o(log(n))
 * 空间复杂度o(log(n))
 * 稳定性：不稳定
 * @author WangPeng
 */
public class QuickSort {
	
	public static void quickSort(int[] data,int start, int end){
		int middle = paritation(data,start,end) ;
		if(middle>start){
			quickSort(data,start,middle-1) ;
		}
		if(middle<end){
			quickSort(data,middle+1,end) ;
		}
	}
	private static int paritation(int[] data, int start, int end) {
		//快排的轴
		int base = (start+end)/2 ;
		while(start<end){
			while(data[start]<=data[base] && start<base){
				start++ ;
			}
			if(data[start]>data[base]){
				swap(data,start,base) ;
				base = start ;
			}
			while(data[end]>=data[base] && end>base){
				end-- ;
			}
			if(data[end]<data[base]){
				swap(data,base,end) ;
				base = end ;
			}
		}
		printArray(data);
		return start;
	}
	public static void swap(int[] data,int i, int j){
		int temp = data[i] ;
		data[i] = data[j] ;
		data[j] = temp ;
	}
	public static void main(String[] args) {
		int[] data = {1,5,34,25,7,3,6,14,23}  ;
		printArray(data);
		quickSort(data,0,data.length-1) ;
		printArray(data);
	}
	public static void printArray(int[] data){
		for(int i=0;i<data.length-1;i++){
			System.out.print(data[i] + ",");
		}
		System.out.println(data[data.length-1]);
	}
}
