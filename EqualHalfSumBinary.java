//Link to problem : https://www.geeksforgeeks.org/find-all-even-length-binary-sequences-with-same-sum-of-first-and-second-half-bits/
public class EqualHaflSumBinary {
	static int count=0;
	static void printEqualHaflSumBinary(int diff,int start,int end,int[] arr)
	{ 
		if(start<0 || start>arr.length-1 || end<0 || end>arr.length-1)return;
		if(start>end)
		{
			if(diff==0)
			{
				for(int i=0;i<arr.length-1;i++)
				{
					System.out.print(arr[i]);
				}
				System.out.println();
				count ++;								
			}
			return;
		}
		arr[start]=0;
		arr[end]=1;
		printEqualHaflSumBinary(diff+1,start+1,end-1,arr);
		
		arr[start]=0;
		arr[end]=0;
		printEqualHaflSumBinary(diff,start+1,end-1,arr);
		
		arr[start]=1;
		arr[end]=1;
		printEqualHaflSumBinary(diff,start+1,end-1,arr);
		
		arr[start]=1;
		arr[end]=0;
		printEqualHaflSumBinary(diff-1,start+1,end-1,arr);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=3;
		printEqualHaflSumBinary(0,0,(n*2)-1,new int[n*2+1]);
		System.out.println("count:="+count);
	}

}
