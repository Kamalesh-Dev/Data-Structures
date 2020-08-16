//$Id$
package kam.heaps;

import java.util.*;

class PriorityQueuesOperations
{
	ArrayList<Integer> arr;	
	public PriorityQueuesOperations(int size)
	{
		this.arr=new ArrayList<>(size);
	}
	public PriorityQueuesOperations(int[] arr)
	{
		this.arr=new ArrayList<>(arr.length);
		for(int i:arr)
		{
			this.arr.add(i);
		}
	}
	
	public ArrayList<Integer> max_heapify(int i)
	{
		int l=(i*2)+1;
		int r=(i*2)+2;
		int largest=i;
		if(l<this.arr.size() && this.arr.get(l)>this.arr.get(i))
		{
			largest=l;
		}
		if(r<this.arr.size() && this.arr.get(r) > this.arr.get(largest))
		{
			largest=r;
		}
		if(largest!=i)
		{
			//swapping largest and i
			int temp=this.arr.get(i);
			this.arr.set(i, this.arr.get(largest));
			this.arr.set(largest, temp);
			return max_heapify(largest);
		}
		
		
		return this.arr;
	}
	public int max()
	{
		return this.arr.get(0);		
	}
	public int extract_max()
	{
		int toReturn=this.arr.remove(0);
		int lastElement=this.arr.remove(this.arr.size()-1);
		this.arr.add(0,lastElement);
		this.arr=max_heapify(0);
		return toReturn;
	}
	public void insert(int element)
	{
		this.arr.add(element);
		int lastElementIndex=this.arr.size()-1;
		int parent=(lastElementIndex%2==0)?(lastElementIndex/2)-1:lastElementIndex/2;
		while(parent>=0 && lastElementIndex!=0)
		{
			if(arr.get(lastElementIndex)>arr.get(parent))
			{
				//swap
				int temp=arr.get(lastElementIndex);
				arr.set(lastElementIndex, arr.get(parent));
				arr.set(parent, temp);
				lastElementIndex=parent;
				parent=(lastElementIndex%2==0)?(lastElementIndex/2)-1:lastElementIndex/2;
			}
			else
			{
				break;
			}
		}
		
	}
	public void increaseKey(int currentKey,int increaseKey)
	{
				
		int lastElementIndex=this.arr.indexOf(currentKey);
		if(lastElementIndex!=-1)
		{
			this.arr.set(lastElementIndex, increaseKey);
			int parent=(lastElementIndex%2==0)?(lastElementIndex/2)-1:lastElementIndex/2;
			while(parent>=0 && lastElementIndex!=0)
			{
				if(arr.get(lastElementIndex)>arr.get(parent))
				{
					//swap
					int temp=arr.get(lastElementIndex);
					arr.set(lastElementIndex, arr.get(parent));
					arr.set(parent, temp);
					lastElementIndex=parent;
					parent=(lastElementIndex%2==0)?(lastElementIndex/2)-1:lastElementIndex/2;
				}
				else
				{
					break;
				}
			}
		}
		
		
	}
}

public class PriorityQueues {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={4,1,3,2,16,9,10,14,8,7};
		PriorityQueuesOperations op=new PriorityQueuesOperations(arr);
		for(int i=(arr.length/2)-1;i>=0;i--)
		{
			op.max_heapify(i);
		}
		System.out.println(op.extract_max());
		//System.out.println(op.extract_max());
		op.insert(15);
		op.increaseKey(10, 20);
		System.out.println(op.arr);
	}

}
