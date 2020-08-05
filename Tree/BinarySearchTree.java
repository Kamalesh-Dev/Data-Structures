//$Id$
package kam.bst;

import java.util.ArrayList;

class Node{
	
	int data;
	Node left;
	Node right;
	
	public Node(int data)
	{
		this.data=data;
		this.left=null;
		this.right=null;
	}
}

class BstOperations{
	
	Node root;
	
	public BstOperations()
	{
		this.root=null;
	}
	
	
	public BstOperations(Node root)
	{
		this.root=root;
	}
	
	private Node buildBST(Node root,int data)
	{
		if(root==null)
			return new Node(data);
		
		if(data<root.data)
		{
			root.left=buildBST(root.left, data);
		}
		else if(data>root.data)
		{
			root.right=buildBST(root.right, data);			
		}
		
		return root;
	}
	
	public void addElement(int data)
	{
		this.root=this.buildBST(this.root, data);
	}
	
	private ArrayList<Integer> inOrder(Node root, ArrayList<Integer> list)
	{
		if(root!=null)
		{
			inOrder(root.left, list);
			list.add(root.data);
			inOrder(root.right, list);
		}
		return list;
	}
	
	public ArrayList<Integer> inOrderList()
	{
		return inOrder(this.root,new ArrayList<Integer>());
	}
	
	private ArrayList<Integer> preOrder(Node root, ArrayList<Integer> list)
	{
		if(root!=null)
		{
			list.add(root.data);
			preOrder(root.left, list);			
			preOrder(root.right, list);
		}
		return list;
	}
	
	public ArrayList<Integer> preOrderList()
	{
		return preOrder(this.root,new ArrayList<Integer>());
	}
	
	private ArrayList<Integer> postOrder(Node root, ArrayList<Integer> list)
	{
		if(root!=null)
		{		
			postOrder(root.left, list);			
			postOrder(root.right, list);
			list.add(root.data);
		}
		return list;
	}
	
	public ArrayList<Integer> postOrderList()
	{
		return postOrder(this.root,new ArrayList<Integer>());
	}
	
	private Node deleteFromBST(Node root,int val)
	{
		if(root==null)
		{
			System.out.println("Element Not Found::");			
		}
		else
		{
			if(val<root.data)
			{
				root.left=this.deleteFromBST(root.left, val);
			}
			else if(val>root.data)
			{
				root.right=this.deleteFromBST(root.right, val);
			}
			else if(root.data==val)
			{
				if(root.left==null && root.right==null)
				{
					return null;
				}
				else if(root.left==null && root.right !=null)
				{
					return root.right;
				}
				else if(root.left!=null && root.right==null)
				{
					return root.left;
				}
				else if(root.left!=null && root.right!=null)
				{
					Node inOrderSuccessor=root.right;
					while(inOrderSuccessor.left!=null)
					{
						inOrderSuccessor=inOrderSuccessor.left;
					}
					
					root.data=inOrderSuccessor.data;
					root.right=this.deleteFromBST(root.right, inOrderSuccessor.data);
				}
			}
		}
		return root;
	}
	
	public void deleteValue(int val)
	{
		this.root=deleteFromBST(this.root, val) ;
	}
	
}


public class BinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BstOperations bst=new BstOperations();
		bst.addElement(5);
		bst.addElement(2);
		bst.addElement(8);
		bst.addElement(1);
		bst.addElement(3);
		bst.addElement(6);
		bst.addElement(7);
		System.out.println(bst.inOrderList());
		System.out.println(bst.preOrderList());
		System.out.println(bst.postOrderList());
		System.out.println(bst.root.data);
		bst.deleteValue(5);
		System.out.println(bst.inOrderList());
		System.out.println(bst.preOrderList());
		bst.deleteValue(2);
		System.out.println(bst.root.left.data);
	}

}
