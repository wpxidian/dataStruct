package cn.edu.xidian.ds.sort;
/**
 * �鲢����
 * ʱ�临�Ӷ�o(n*log(n))
 * �ռ临�Ӷ�o(n)
 * �ȶ��ԣ��ȶ�
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
		//��ʱ����
		int[] tempData = new int[data.length] ;
		//��ʱ������±���left��ʼ�������������鿽����ԭ��������
		int third = left ;
		int mid = middle + 1 ;
		//��¼�������ʼλ��
		int tempLeft = left ;
		//�ϲ��������������Ϊһ����������
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
		//������ʱ���鿽����ԭ��������
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
