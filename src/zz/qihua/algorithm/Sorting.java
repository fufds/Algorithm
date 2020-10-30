package zz.qihua.algorithm;

import java.util.Arrays;
import java.util.Random;

public class Sorting {
private static int countor=0;
	
	public static int[] randomArray(int size,int max){
		int[] array=new int[size];
		Random random=new Random();
		for(int i=0;i<size;i++){
			array[i]=random.nextInt(max);
		}
		return array;
	}
	
	public static void quickSort(int[] array,int lowBound,int upBound){
		if(lowBound==upBound){
			return;
		}
		int index=quickSortCore(array,lowBound,upBound);
		
		quickSort(array,lowBound,Math.max(lowBound, index-1));
		quickSort(array,Math.min(upBound, index+1),upBound);
	}
	
	public static int quickSortCore(int[] array,int lowBound,int upBound){
		int pivot=array[lowBound];
		int i=lowBound;
		int j=lowBound+1;
		for(;j<=upBound;j++){
			if(array[j]<pivot){
				i++;
				if(j>i){
					int tmp=array[j];
					array[j]=array[i];
					array[i]=tmp;
				}
			}
		}
		array[lowBound]=array[i];
		array[i]=pivot;
		return i;
	}
	
	public static void quickSorts(int[] array,int lowBound,int upBound){
		if(lowBound>=upBound){
			return;
		}else{
			int pivot=array[lowBound];
			int i=lowBound;
			int j=lowBound+1;
			for(;j<=upBound;j++){
				if(array[j]<pivot){
					i++;
					if(j>i){
						int tmp=array[j];
						array[j]=array[i];
						array[i]=tmp;
					}
				}
			}
			array[lowBound]=array[i];
			array[i]=pivot;
			quickSorts(array,lowBound,Math.max(lowBound, i-1));
			quickSorts(array,Math.min(upBound, i+1),upBound);
		}
	}
	
	public static int[] mergeSort(int [] array){
		if(array.length<=1)
			return array;
		int mid=array.length/2;
		int[] left=Arrays.copyOf(array, mid);
		int[] right=Arrays.copyOfRange(array, mid, array.length);
		return mergeSortCore(mergeSort(left),mergeSort(right));
	}
	
	public static int[] mergeSortCore(int[] left,int[] right){
		int[] mergeArray=new int[left.length+right.length];
		int leftPoint=0,rightPoint=0;
		int tmpVal=0;
		for(int i=0;i<mergeArray.length;i++){
			if(leftPoint>=left.length){
				tmpVal=right[rightPoint];
				rightPoint++;
			}else if(rightPoint>=right.length){
				tmpVal=left[leftPoint];
				leftPoint++;
			}else if(left[leftPoint]>right[rightPoint]){
				tmpVal=right[rightPoint];
				rightPoint++;				
			}else{
				tmpVal=left[leftPoint];
				leftPoint++;
			}
			mergeArray[i]=tmpVal;
		}
		return mergeArray;
	}
	
	public static int[] countingSort(int[] array,int min,int max){
		int[] cntArray=new int[max-min+1];
		int[] bakArray=new int[cntArray.length];
		int[] resArray=new int[array.length];
		for(int i=0;i<array.length;i++){
			int ind=array[i]-min;
			cntArray[ind]=cntArray[ind]+1;
		}
		bakArray[0]=cntArray[0];
		for(int i=1;i<cntArray.length;i++){
			bakArray[i]=bakArray[i-1]+cntArray[i];
		}
		for(int i=array.length-1;i>=0;i--){
			int bakInd=array[i]-min;
			int resInd=bakArray[bakInd]-1;
			resArray[resInd]=array[i];
			bakArray[bakInd]=bakArray[bakInd]-1;
		}
		return resArray;
	}
	
	public static int searchXth(int[] array,int rank){
		int mid=array.length/2;
		int p=0;
		int q=0;
		int pivot=array[p];
		int i=p,j=p+1;
		for(;j<=q;j++){
			
		}
		if(mid>rank){
			return array[mid];
		}else if(mid<rank){
			return array[mid];
		}else {
			return array[mid];
		}
	}
	
	public static int binarySearch(int[] array,int val){
		int len=array.length;
		int midVal=array[len/2];
		if(midVal>val){
			return binarySearch(Arrays.copyOf(array, len/2),val);
		}else if(midVal<val){
			return binarySearch(Arrays.copyOfRange(array, len/2+1, len),val);
		}else{
			return midVal;
		}
	}

	
}
