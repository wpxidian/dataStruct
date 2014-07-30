package cn.edu.xidian.ds.array;

import java.util.Arrays;
/**
 * 合并两个有序的数组为一个有序数组
 * @author WangPeng
 *
 */
public class Merge2Array {

	public static void main(String[] args) {
		int[] firstArr = {1,3,5,7,9,13,14,15,17} ;
		int[] secondArr = {2,4,6,8,10} ;
		System.out.println(Arrays.toString(merge(firstArr,secondArr))) ;
	}
	public static int[] merge(int[] firstArr, int[] secondArr){
		int firstLen = firstArr.length ;
		int secondLen = secondArr.length ;
		int[] thirdArr = new int[firstLen + secondLen] ;
		
		int firstIndex = firstLen - 1 ;
		int secondIndex = secondLen - 1 ;
		int thirdIndex = firstLen + secondLen - 1 ;
		
		while(firstIndex>=0 && secondIndex>=0){
			if(firstArr[firstIndex] > secondArr[secondIndex]){
				thirdArr[thirdIndex--] = firstArr[firstIndex--] ;
			}else{
				thirdArr[thirdIndex--] = secondArr[secondIndex--] ;
			}
		}
		if(firstIndex>=0){
			while(firstIndex>=0){
				thirdArr[thirdIndex--] = firstArr[firstIndex--] ;
			}
		}
		if(secondIndex>=0){
			while(secondIndex>=0){
				thirdArr[thirdIndex--] = secondArr[secondIndex--] ;
			}
		}
		return thirdArr ;
	}
}
