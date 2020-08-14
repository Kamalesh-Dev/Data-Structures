//$Id$
package kam.heaps;

public class HeapSort {

	public static int[] max_heapify(int[] arr,int i,int size)
	{
		int left=(i*2)+1;
		int right=(i*2)+2;
		int largest=i;
		if(left<=size && arr[left]>arr[i])
		{
			largest=left;
		}
		if(right<=size && arr[right]>arr[largest])
		{
			largest=right;
		}
		if(largest!=i)
		{
			//swap largest and i
			int temp=arr[largest];
			arr[largest]=arr[i];
			arr[i]=temp;
			
			return max_heapify(arr, largest, size);
		}
		return arr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={4,1,3,2,16,9,10,14,8,7};
		
		for(int i=(arr.length/2)-1;i>=0;i--)
		{
			arr=HeapSort.max_heapify(arr, i, arr.length-1);
		}
		
		int n=arr.length-1;
		
		while(n>=1)
		{
			int t=arr[n];
			arr[n]=arr[0];
			arr[0]=t;
			arr=max_heapify(arr, 0, --n);
		}

		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+"\t");
		}
		
	}

}
