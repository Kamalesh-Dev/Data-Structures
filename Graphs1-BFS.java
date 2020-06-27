//File name BFS.java
import java.util.*;
class BFSNode{
	 int vertex;
	 int precedent;
	 String color;
	 int distance;
	
	 public BFSNode(int vertex)
	 {
		 this.vertex=vertex;
		 this.precedent=-1;
		 this.color="WHITE";
		 this.distance=0;
	 }	 
}

class BFSOP
{
	ArrayList<ArrayList<BFSNode> > graph =  null;
            
	public BFSOP(int n)
	{
		graph=new ArrayList<ArrayList<BFSNode> >(n);
		for(int i=0;i<n;i++)
		{
			graph.add(new ArrayList<BFSNode>());
		}
		
	}
	
	public void addEdges(BFSNode source,BFSNode dest)
	{
		graph.get(source.vertex).add(dest);
		graph.get(dest.vertex).add(source);		
	}
	public void printGraph()
	{
		for(int i=0;i<graph.size();i++)
		{
			System.out.print("Vertex:"+i+" :");
			for(int j=0;j<graph.get(i).size();j++)
			{
				System.out.print("\t"+graph.get(i).get(j).vertex);
			}
			System.out.println();
		}
	}
	public void breadthFirstSearch(BFSNode source)
	{
		ArrayList<BFSNode> output=new ArrayList<>();
		ArrayList<BFSNode> queue=new ArrayList<>();
		source.precedent=-1;
		source.color="GREY";
		source.distance=0;
		queue.add(source);
		while(!queue.isEmpty())
		{
			BFSNode current=queue.get(0);
			current.color="black";			
			queue.remove(0);
			output.add(current);
			// Finding neighbours of current node;
			
			ArrayList<BFSNode> currNeighbours=graph.get(current.vertex);
			for(int i=0;i<currNeighbours.size();i++)
			{
				if(currNeighbours.get(i).color=="WHITE")
				{
					BFSNode temp=currNeighbours.get(i);
					temp.color="GREY";
					temp.distance=current.distance+1;
					temp.precedent=current.vertex;
					queue.add(temp);
				}
			}
			
		}
		for(int i=0;i<output.size();i++)
		{
			System.out.println(output.get(i).vertex+" dist:"+output.get(i).distance+" color:"+output.get(i).color+" prece:"+output.get(i).precedent);
		}
	}
	
	
}

public class BFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BFSOP bfs=new BFSOP(6);
		BFSNode a=new BFSNode(0);
		BFSNode b=new BFSNode(1);
		BFSNode c=new BFSNode(2);
		BFSNode d=new BFSNode(3);
		BFSNode e=new BFSNode(4);
		BFSNode f=new BFSNode(5);
		bfs.addEdges(a, b);
		bfs.addEdges(a, c);
		bfs.addEdges(b, d);
		bfs.addEdges(b, e);
		bfs.addEdges(c, e);
		bfs.addEdges(d, e);
		bfs.addEdges(d, f);
		bfs.addEdges(e, f);
		bfs.printGraph();
		bfs.breadthFirstSearch(c);
		
	}

}
