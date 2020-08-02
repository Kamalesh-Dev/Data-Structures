//$Id$
package kam.recusion;

import java.util.HashMap;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int val)
	{
		this.val=val;
		this.left=null;
		this.right=null;
	}
	
	public TreeNode(int val,TreeNode left,TreeNode right)
	{
		this.val=val;
		this.left=left;
		this.right=right;		
	}
}


public class LeetCode1139 {

	public static HashMap<Integer, Integer> hm;
	
	public static int result=Integer.MIN_VALUE;
	
	public static int totalSum;
	
	static void preOrder(TreeNode root)
	{
		
		if(root==null)
			return;
		
		if(root.left!=null && root.right!=null)
		{
			int leftTreeSum=hm.get(root.left.hashCode());
			int rightTreeSum=hm.get(root.right.hashCode());
			result=Math.max(result, Math.max((totalSum-leftTreeSum)*leftTreeSum, (totalSum-rightTreeSum)*rightTreeSum));
		}
		else if(root.left!=null)
		{
			int leftTreeSum=hm.get(root.left.hashCode());
			result=Math.max(result, (totalSum-leftTreeSum)*leftTreeSum);
		}
		else if(root.right!=null)
		{
			int rightTreeSum=hm.get(root.right.hashCode());
			result=Math.max(result, (totalSum-rightTreeSum)*rightTreeSum);
		}
			
		preOrder(root.left);
		preOrder(root.right);
		
	}
	
	
	
	
	
	
	
	
	static int sumAtEachNode(TreeNode root)
	{
		if(root==null)
		{
			return 0;			
		}
		else
		{
			int leftNodeSum=sumAtEachNode(root.left);
			int rightNodeSum=sumAtEachNode(root.right);
			int toReturn=root.val+leftNodeSum+rightNodeSum;
			hm.put(root.hashCode(), toReturn);
			System.out.println("Sum at node("+root.val+")="+toReturn);
			return toReturn;
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		totalSum=0;
		hm=new HashMap<Integer,Integer>();
//		TreeNode five=new TreeNode(5);
//		TreeNode six=new TreeNode(6);
//		TreeNode three=new TreeNode(3);
//		TreeNode four=new TreeNode(4,five,six);
//		TreeNode two=new TreeNode(2,three,four);
//		TreeNode one=new TreeNode(1,null,two);
		
		//System.out.println(one.hashCode());
		TreeNode five=new TreeNode(5);
		TreeNode six=new TreeNode(6);
		TreeNode three=new TreeNode(3,six,null);
		TreeNode four=new TreeNode(4);
		TreeNode two=new TreeNode(2,four,five);
		TreeNode one=new TreeNode(1,two,three);
		sumAtEachNode(one);
		totalSum=hm.get(one.hashCode());
		preOrder(one);		
		System.out.println("Done:"+result);
		
		
		
	}

}




