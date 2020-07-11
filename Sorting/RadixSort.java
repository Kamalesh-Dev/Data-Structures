//$Id$
package kam.sorting;
public class RadixSort {
	
	static int[] countSortOnDigit(int[]ip,int k,int digit)
	{
		//(ip[i]/digit)%10-->digit selection
		//k - 9 constant as numbers range from 0-9
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
			c[(ip[i]/digit)%10]=c[(ip[i]/digit)%10]+1;
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
			o[c[(ip[i]/digit)%10]-1]=ip[i];
			c[(ip[i]/digit)%10]=c[(ip[i]/digit)%10]-1;
		}
		
		
		return o;
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={170, 45, 75, 90, 802, 24, 2, 66};
		int max=arr[0];		
		for(int i=1;i<arr.length;i++)
		{
			if(max<arr[i])
			{
				max=arr[i];
			}
		}
		int lengthofMax=(max+"").length();		
		for(int i=0;i<lengthofMax;i++)
		{
			int pow=(int)Math.pow(Double.valueOf(10),Double.valueOf(i));
			arr=RadixSort.countSortOnDigit(arr, 9, pow);			
		}
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}

}
