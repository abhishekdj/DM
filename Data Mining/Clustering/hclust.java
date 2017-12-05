import java.io.*;
import java.util.*;
class Hierarchical
{
	int size;
	ArrayList clusters[];
	ArrayList clustersx[];

	double dist[][]=new double[100][100];
    	double a[]=new double[100];
	String b[]=new String[100];
	int q=0,p=0;
	ArrayList z;
	void input()
	{

		p=new ArrayList();		
'		Scanner sc=new Scanner(System.in);       
		System.out.println("Enter the number of points  :");
        	size = sc.nextInt();     
       		System.out.println("Enter "+size+" points with  co-ordinate and name respectively :");
       		 for(int i=0;i<size;i++)
       		  {
			a[i]=sc.nextDouble();
			b[i]=sc.next();
			z.add(b[i]);	
		  }
	

	}

	public static void main()
	{



	}	

	void hclust()
	{
		clusters = null;
        	clusters = new ArrayList[clustcount];
		clustersx = null;
        	clustersx = new ArrayList[clustcount];
        
	        
		int cnt;
        	for(int i=0;i<size;i++)
		{
        	    clusters[i]=new ArrayList<>();
		    clustersx[i]=new ArrayList<>();
			    
		}
	   
		double min=1000000;
		 
		
		while(z.size()>0)
		{
			if(z.size()==size)
			{		
				 for(int i=0;i<size;i++)
					{
						for(int j=0;j<size;j++)
						{
							dist[i][j]=a[i]-a[j];						
							
							if(dist[i][j]<min)
							{
								min=dist[i][j];
								p=i;
								q=j;
							}
					
					}
			}
			else
			{
				


			}
								
				clustersx[p].add(a[p]);
				clusters[p].add(b[p]);
				z.remove(b[p]);

				



				
			}
		cnt=0;
		for(int j=0;j<clustcount;j++)
		{
						
			if(cen[j][0]==k[j][0] &&cen[j][1]==k[j][1])
			cnt++;
			else
			 break;

		}
		
		if(cnt==clustcount)
			break;	
		
	 }
	

	}


}
