package cn.edu.xidian.ds.sort;
/**
 * ֱ��ѡ������
 * ʱ�临�Ӷ�o(n2)
 * �ռ临�Ӷ�o(1)
 * �ȶ��ԣ����ȶ�
 * @author WangPeng
 *
 */
public class SelectSort {

	public static void selectSort(int[] data){
		for(int i=0;i<data.length;i++){
			int minDataIndex = i ; //ÿ����С�����±�
			for(int j=i+1;j<data.length;j++){
				if(data[j]<data[minDataIndex]){
					minDataIndex = j ;
				}
			}
			if(data[minDataIndex]<data[i]){//����minDataIndex != i
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
