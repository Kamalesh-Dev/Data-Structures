//$Id$
package kam.binarytree;

import java.util.ArrayList;


class TreeNode
{
	char val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(char val)
	{
		this.val=val;
		this.left=null;
		this.right=null;
	}
}

class Utils
{
	public static int indexOf(char[] arr,char value,int start,int end)
	{
		for(int i=start;i<=end;i++)
		{
			if(arr[i]==value)
				return i;
		}
		return -1;
	}
}

class ConstructBinaryTree
{
	TreeNode root;
	static int preIndex=0;
	static int postIndex;
	public ConstructBinaryTree()
	{
		this.root=null;
	}
	
	private TreeNode buildTreeFromPreAndInOrder(char[] in,char[] pre,int start,int end)
	{
		if(start>end)
			return null;
		
		TreeNode node=new TreeNode(pre[preIndex++]);
		
		if(start==end)
		{
			return node;
		}			
		else
		{
			int inOrderIndex=Utils.indexOf(in, node.val, start, end);
			node.left=this.buildTreeFromPreAndInOrder(in, pre, start, inOrderIndex-1);
			node.right=this.buildTreeFromPreAndInOrder(in, pre, inOrderIndex+1, end);
			
		}
			
		return node;
	}
	
	
	public TreeNode buildTreePreIn(char[] in,char[] pre,int start,int end)
	{
		this.root=buildTreeFromPreAndInOrder(in, pre, start, end);
		return this.root;
	}
	
	private ArrayList<Character> postOrder(TreeNode root, ArrayList<Character> list)
	{
		if(root!=null)
		{		
			postOrder(root.left, list);			
			postOrder(root.right, list);
			list.add(root.val);
		}
		return list;
	}
	
	public ArrayList<Character> postOrderList()
	{
		return postOrder(this.root,new ArrayList<Character>());
	}
	
	
	private TreeNode buildTreePostandInOrder(char[] in,char[] post,int start,int end)
	{
		if(start>end)
			return null;
			
		TreeNode node=new TreeNode(post[postIndex--]);
		
		if(start==end)
		{
			return node;
		}
		else
		{
			int inOrderIndex=Utils.indexOf(in,node.val, start, end);			
			node.right=this.buildTreePostandInOrder(in, post, inOrderIndex+1, end);
			node.left=this.buildTreePostandInOrder(in, post, start, inOrderIndex-1);
		}
		return node;
	}
	
	
	public TreeNode buildTreePostIn(char[] in,char[] post,int start, int end)
	{
		postIndex=5;
		this.root=this.buildTreePostandInOrder(in, post, start, end);
		return this.root;
	}
	
}



public class TreeConstruction {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] in={'D','B','E','A','F','C'};
		char[] pre={'A','B','D','E','C','F'};
		char[] post={'D', 'E', 'B', 'F', 'C', 'A'};
		ConstructBinaryTree tree=new ConstructBinaryTree();
		//tree.buildTreePreIn(in, pre, 0, in.length-1);
		//System.out.println(tree.postOrderList());
		tree.buildTreePostIn(in, post, 0, in.length-1);
		System.out.println(tree.postOrderList());
		
	}

}
