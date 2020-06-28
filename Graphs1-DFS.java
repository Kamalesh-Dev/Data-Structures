//File name DFS.java
import java.util.ArrayList;

class DFSNode
{
	int vertex;
	int d;
	int f;
	int prec;
	String color;
	public DFSNode(int vertex)
	{
		this.vertex=vertex;
		this.d=0;
		this.f=0;
		this.prec=-1;
		this.color="WHITE";
	}
	
}

class DFSOP
{
	ArrayList<ArrayList<DFSNode> > graph =  null;
	ArrayList<DFSNode> output=null;
	int time;
	public DFSOP(int n)//n of vertices of graph
	{
		time=0;
		graph=new ArrayList<ArrayList<DFSNode>>(n);
		for(int i=0;i<n;i++)
		{
			graph.add(new ArrayList<DFSNode>());
		}
		output=new ArrayList<DFSNode>(n);
	}
	public void addEdge(DFSNode source,DFSNode target)
	{
		//Directed edge
		graph.get(source.vertex).add(target);
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
	public ArrayList<DFSNode> DFS(DFSNode source)
	{
		source.d=++this.time;
		source.color="GREY";
		this.output.add(source);
		ArrayList<DFSNode> currNeighbours=graph.get(source.vertex);
		for(int i=0;i<currNeighbours.size();i++)
		{
			if(currNeighbours.get(i).color=="WHITE")
			{
				currNeighbours.get(i).color="GREY";
				currNeighbours.get(i).prec=source.vertex;
				currNeighbours.get(i).d=++this.time;
				this.DFS(currNeighbours.get(i));
			}
		}
		source.f=++this.time;
		source.color="BLACK";				
		return this.output;
	}
}



public class DFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DFSOP dfs=new DFSOP(6);
		DFSNode a=new DFSNode(0);
		DFSNode b=new DFSNode(1);
		DFSNode c=new DFSNode(2);
		DFSNode d=new DFSNode(3);
		DFSNode e=new DFSNode(4);
		DFSNode f=new DFSNode(5);
		ArrayList<DFSNode> ip=new ArrayList<DFSNode>(6);
		ip.add(a);
		ip.add(b);
		ip.add(c);
		ip.add(d);
		ip.add(e);
		ip.add(f);
		dfs.addEdge(a, b);
		dfs.addEdge(a, c);
		dfs.addEdge(b, d);
		dfs.addEdge(b, e);
		dfs.addEdge(c, e);
		dfs.addEdge(d, e);
		dfs.addEdge(d, f);
		dfs.addEdge(e, f);
		dfs.printGraph();
		ArrayList<DFSNode> op=null;
		for(int i=0;i<ip.size();i++)
		{
			if(ip.get(i).color=="WHITE")
			{
				op=dfs.DFS(ip.get(i));
			}
		}
		for(int i=0;i<op.size();i++)
		{
			System.out.println(op.get(i).vertex);
		}
		
	}

}
