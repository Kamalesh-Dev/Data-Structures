package kam.dp.codes;

class LCSOp
{
	public int[][] l;
	public String x;
	public String y;
	public LCSOp(int m,int n,String x,String y)
	{
		l=new int[x.length()+1][y.length()+1];
		this.x=x;
		this.y=y;
		for(int i=0;i<x.length()+1;i++)
		{
			for(int j=0;j<y.length()+1;j++)
			{
				l[i][j]=-1;
			}
		}
	}
	
	public int lcs(int m,int n)// without DP
	{				
		if(m<0||n<0)
			return 0;
		else if(x.charAt(m)==y.charAt(n))
			return 1+lcs(m-1,n-1);
		else 
			return Math.max(lcs(m,n-1),lcs(m-1,n));

	}
	public void display()
	{
		for(int i=0;i<=this.x.length();i++)
		{
			for(int j=0;j<=y.length();j++)
			{
				System.out.print("\t"+this.l[i][j]);
			}
			System.out.println();
		}
	}
	public int LCSdp(int m,int n)// Up Down
	{
		if(this.l[m][n]!=-1)
		{
			return l[m][n];
		}
		if(m==0||n==0)
			l[m][n]=0;
		
		else if(this.x.charAt(m-1) == this.y.charAt(n-1))
		{
			l[m][n]=1+this.LCSdp(m-1, n-1);
		}
		else
		{
			l[m][n]=Math.max(this.LCSdp(m-1, n), this.LCSdp(m, n-1));
		}
		return l[m][n];
	}
	public int LCSdp2(int m,int n)
	{		
		for(int i=0;i<=m;i++)
		{
			for(int j=0;j<=n;j++)
			{
				if(i==0||j==0)
				{
					l[i][j]=0;
				}
				else if(this.x.charAt(i-1)==this.y.charAt(j-1))
				{
					l[i][j]=1+l[i-1][j-1];
				}
				else
				{
					l[i][j]=Math.max(l[i][j-1], l[i-1][j]);
				}
					
			}
		}
		return l[m][n];
	}
	public String printLCS(int m,int n,int len)
	{
		String s="";
		int currentRow=m;
		int currentCol=n;
		while(len>0)
		{
			if(this.x.charAt(currentRow-1)==this.y.charAt(currentCol-1) && l[m][n]!=0)
			{
				s=s+this.x.charAt(currentRow-1);
				len--;
				currentRow-=1;
				currentCol-=1;
			}
			else if(this.x.charAt(currentRow-1)!=this.y.charAt(currentCol-1))
			{
				if(l[currentRow][currentCol]==l[currentRow][currentCol-1])
				{
					currentCol-=1;
				}
				else
				{
					currentRow-=1;
				}
			}
		}
		return new StringBuffer(s).reverse().toString();
	}
	
}


public class LCS {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x="AAAAAAAAAAAA";
		String y="AAAAAAA";
		LCSOp op=new LCSOp(x.length(), y.length(), x, y);
		//System.out.println(op.LCSdp(x.length(), y.length()));
		int len=op.LCSdp2(x.length(), y.length());
		op.display();
		System.out.println(op.printLCS(x.length(), y.length(), len));
		
	}

}
