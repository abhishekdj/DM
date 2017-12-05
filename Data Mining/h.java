import java.util.*;
class hierarchical
{
	public static void getArray(int n,int[][] previous)
	{
	Scanner sc = new Scanner(System.in);		
	System.out.println("enter cluster distances: ");
	for(int i=0;i<n;i++)
	{
		previous[i][i]=0;
		for(int j=i+1;j<n;j++)
		{
			System.out.print((i+1)+" to "+(j+1)+" :");
			previous[i][j] = sc.nextInt();
			previous[j][i] = previous[i][j];
			System.out.println();
		}		
	}
	sc.close();		
	}
	public static void printArray(int n,int[][] previous)
	{
		System.out.println("Array :");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(previous[i][j]+" ");
			}		
		System.out.println();
		}		
	}	
	public static int[] getMin(int n,int[][] previous)
	{
		int[] min = new int[3];
		min[0]=100000;
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(min[0]>previous[i][j])
				{
					min[0]=previous[i][j];
					min[1]=i;
					min[2]=j;				
				}
			}		
		}
		return min;		
	}
	public static int[][] nextArray(int n,int[][] previous,int[] min,int[] index)
	{
		int[][] next = new int[n-1][n-1];
		for(int i=0;i<n-1;i++)
		{
			next[i][i]=0;
			for(int j=i+1;j<n-1;j++)
			{
				if(i==0)
				{
					if(previous[index[j-1]][min[1]]>previous[index[j-1]][min[2]])
					{
						next[i][j]=previous[index[j-1]][min[2]];
						next[j][i]=previous[index[j-1]][min[2]];
					}
					else
					{
						next[i][j]=previous[index[j-1]][min[1]];
						next[j][i]=previous[index[j-1]][min[1]];
					}
				}
				else
				{
					int k=i-1;
					next[i][j]=previous[index[k]][index[j-1]];
					next[j][i]=previous[index[k]][index[j-1]];				
				}			
			}		
		}	
		return next;	
	}
	public static int[] make(int n,int x,int y)
	{
		int[] index = new int[n-2];
		int k=0;		
		for(int i=0;i<n;i++)
		{
			if(i!=x&&i!=y)
			{
				index[k]=i;
				k++;
			}
		}		
		return index;
	}
	public static void main(String[] args)
	{
		System.out.println("enter number of clusters: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] previous = new int[n][n];		
		getArray(n,previous);
		printArray(n,previous);
		for(int i=0;i<n-2;i++)
		{
			int[] min = getMin(n-i,previous);
			System.out.println("minimum distance is "+min[0]+" between cluster "+(min[1]+1)+" and "+(min[2]+1));
			int[] index = make(n-i,min[1],min[2]);
			int[][] next = nextArray(n-i,previous,min,index);
			previous = next;
			printArray(n-i-1,next);
		}
		sc.close();	
	}
}

