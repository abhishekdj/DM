import java.util.*;
import java.io.*;
public class Clustering 
{
   
	int size,clustcount;
	    	 
    	ArrayList clustersx[];
	ArrayList clustersy[];

	double dist[][]=new double[100][100];
    	double k[][]=new double[100][2];
	int p=0;
	double a[][]=new double[100][2]; 	

    void input()
    {
	Scanner sc=new Scanner(System.in);       
	System.out.println("Enter the number of points  :");
        size = sc.nextInt();
	System.out.println("Enter number of clusters :");
        clustcount = sc.nextInt();         
       	System.out.println("Enter "+size+" points with x co-ordinate and y coorinate respectively :");
        for(int i=0;i<size;i++)
         {
		a[i][0]=sc.nextDouble();
		a[i][1]=sc.nextDouble();	
	}
	
	for(int i=0;i<clustcount;i++)
	{
		k[i][0]=a[i][0];
		k[i][1]=a[i][1];
	}
                     
    }
    void kmeans()
    {
	       
	clustersx = null;
        clustersx = new ArrayList[clustcount];
	clustersy = null;
        clustersy = new ArrayList[clustcount];
        
	        
	int cnt;
        for(int i=0;i<clustcount;i++)
	{
            clustersx[i]=new ArrayList<>();
	    clustersy[i]=new ArrayList<>();
	    
	}
	   
		double min=1000000;
		 
		double cen[][]=new double[clustcount][2];
		while(true)
		{
			for(int j=0;j<clustcount;j++)
			{
				cen[j][0]=k[j][0];
				cen[j][1]=k[j][1];
			}
			 for(int i=0;i<size;i++)
				{
					int q=0;
					double x=0,y=0;			
					for(int j=0;j<clustcount;j++)
					{
						double v=(a[j][0]-k[i][0])*(a[j][0]-k[i][0]);
						double h=(a[j][1]-k[i][1])*(a[j][1]-k[i][1]);
						dist[i][j]=Math.sqrt(v+h);						
						
						if(dist[i][j]<min)
						{
							min=dist[i][j];
							p=j;
						}
					
					}
				for(int j=0;j<clustcount;j++)
				{
					if(clustersx[j].contains(a[i][0])&&clustersy[j].contains(a[i][1]))
					{				
					 clustersx[j].remove(a[i][0]);
					   clustersy[j].remove(a[i][1]);
					}				
				}				
				clustersx[p].add(a[i][0]);
				clustersy[p].add(a[i][1]);
				
				
				for(int z=0;z<clustersx[p].size();z++)
				{
					
					x=x+(double)clustersx[p].get(z);
					y=y+(double)clustersy[p].get(z);
					q++;
				}
				k[p][0]=x/q;
				k[p][1]=y/q;
				min=1000000;
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
    
    
    void output()
	{
	        for(int i=0;i<clustcount;i++)
		{
		   
		   System.out.println("Points in cluster "+(i+1)+":");
 	           for(int j=0;j<clustersx[i].size();j++)
			{
				
               		 	System.out.println("point:"+"("+clustersx[i].get(j)+","+clustersy[i].get(j)+")");
            		}
			System.out.println("New Cluster centers are:"+k[i][0]+" "+k[i][1]);            		
			System.out.println();
			System.out.println();
			
        	}
    	}
    
    public static void main(String []arg)
	{
	        Clustering b = new Clustering();
	        b.input();
	        System.out.println("\nAfter K means clustering :");
	        b.kmeans();
	        b.output();
	}

}

