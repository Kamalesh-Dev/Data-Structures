package kam.sorting;

public class CountingSort {

	public static int[] countingSort(int[] ip,int k)
	{
		int[] o=new int[ip.length];
		int[] c=new int[k+1];
		
		/*initializing c(cummilative array)
		 * */
		for(int i=0;i<c.length;i++)
		{
			c[i]=0;
		}
		
		/*Cummilative array contains the frequency of its index in the ip array
		 * */
		for(int i=0;i<ip.length;i++)
		{
			c[ip[i]]=c[ip[i]]+1;
		}
		
		/*Calculation cummilative sum
		 * This array now has the number of elements less than or equal to its index
		 * say c:[2,2,4,7,7,8]
		 * 7 at index 3 will tell us that there are seven elements less than or equal to 3
		 * */
		for(int i=1;i<c.length;i++)
		{
			c[i]=c[i-1]+c[i];
		}
		/*Important step:
		 * After finding the cummilative sum c:array
		 * Traverse the ip array backwards
		 * For the current element find its cummilative sum and in the op array change that index(cummilative sum) to the current element
		 * Reduce the cummilative sum of the current element by -1(we do this because we have processed an element).
		 * */
		
		
		for(int i=ip.length-1;i>=0;i--)
		{
			o[c[ip[i]]-1]=ip[i];
			c[ip[i]]=c[ip[i]]-1;
		}
		
		
		return o;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ip={2,5,3,0,2,3,0,3};
		//Counting sort done only if values range from 0-K
		//K- in the above array ip, the values range from 0-5 --> k is 5 
		int[] op=CountingSort.countingSort(ip, 5);
		for(int i=0;i<op.length;i++)
		{
			System.out.println(op[i]);
		}
		
		/*T(n)=O(n+k)--> if k is O(n) then T(n)=O(n)
		 * */
	}

}
