package cn.edu.xidian.ds.sort;
/**
 * Shell排序
 * 时间复杂度o(n*log(n))
 * 空间复杂度o(1)
 * 稳定性：稳定
 * @author WangPeng
 */
public class ShellSort {
	
	public static void shellSort(int[] data){
		int h = 1 ;
		while(h<=data.length/3){
			h = h*3 + 1 ;
		}
		while(h>0){
			for(int i=h;i<data.length;i++){
				if(data[i-h]>data[i]){
					int temp = data[i] ;
					int j = i - h ;
					for(;j>=0 && data[j]>temp;j-=h){
						data[j+h] = data[j] ;
					}
					data[j+h] = temp ;
				}
			}
			h = (h-1)/3 ;
		}
	}
	public static void main(String[] args) {
		int[] data = {1,5,34,25,7,3,6,14,23}  ;
		printArray(data);
		shellSort(data) ;
		printArray(data);
	}
	public static void printArray(int[] data){
		for(int i=0;i<data.length-1;i++){
			System.out.print(data[i] + ",");
		}
		System.out.println(data[data.length-1]);
	}
}
