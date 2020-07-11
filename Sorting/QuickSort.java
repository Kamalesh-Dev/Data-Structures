//$Id$
package kam.sorting;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {

	static Random rand;
	static void dec()
	{
		rand=new Random();
	}
	static int partition(int[] arr,int p,int q)
	{
		int m = ThreadLocalRandom.current().nextInt(p, q);
		int temp1=arr[p];
		arr[p]=arr[m];
		arr[m]=temp1;
		int pivot=arr[p];
		int i=p;
		for(int j=i+1;j<q;j++)
		{
			if(arr[j]<pivot)
			{
				i=i+1;
				int temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
			}
		}
		int temp=arr[p];
		arr[p]=arr[i];
		arr[i]=temp;
		return i;
	}
	
	static int[] quickSort(int[] arr,int p,int r)
	{
		//p-left bound
		//q-right bound
		if(p<r)
		{
			int q=QuickSort.partition(arr, p, r);
			quickSort(arr, p, q);
			quickSort(arr, q+1, r);
		}
		return arr; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSort.dec();
		int[] arr={170, 45, 75, 90, 802, 24, 2, 66};
		arr=quickSort(arr, 0, arr.length);
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		/*T(n)=O(nlogn)
		 * */
	}

}
