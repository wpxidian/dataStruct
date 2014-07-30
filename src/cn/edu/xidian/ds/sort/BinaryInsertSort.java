package cn.edu.xidian.ds.sort;
/**
 * �۰��������
 * ʱ�临�Ӷ�o(n2)
 * �ռ临�Ӷ�o(1)
 * �ȶ��ԣ��ȶ�
 * @author WangPeng
 */
public class BinaryInsertSort {
	
	public static void binaryInsertSort(int[] data){
		for(int i=1;i<data.length;i++){
			int temp = data[i] ;
			int low = 0 ;
			int high = i - 1 ;
			while(low<=high){
				int middle = (low+high)/2 ;
				if(temp>data[middle]){
					low = middle + 1;
				}else{
					high = middle - 1 ;
				}
			}
			for(int j=i;j>low;j--){
				data[j] = data[j-1] ;
			}
			data[low] = temp ;
		}
	}
	public static void main(String[] args) {
		int[] data = {1,5,34,25,7,3,6,14,23}  ;
		printArray(data);
		binaryInsertSort(data) ;
		printArray(data);
	}
	public static void printArray(int[] data){
		for(int i=0;i<data.length-1;i++){
			System.out.print(data[i] + ",");
		}
		System.out.println(data[data.length-1]);
	}
}
