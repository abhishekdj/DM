import java.util.*;
import java.io.*;
public class Clustering 
{
   



	String csvFile = "a.csv";	//give address of csv file here
	String line = "";
       	String cvsSplitBy = ",";
       		
	int size=0,clustcount;
	    	 
    	ArrayList clustersx[];
	ArrayList clustersy[];

	double dist[][]=new double[1000][1000];
    	double k[][]=new double[1000][2];
	int p=0;
	double a[][]=new double[1000][2]; 	

    void input()
    {
	Scanner sc=new Scanner(System.in);	
	try (BufferedReader br = new BufferedReader(new FileReader(csvFile)))
	{
		int i=0;		
		while ((line = br.readLine()) != null)
		{
			
			 String[] person = line.split(cvsSplitBy);
			 a[i][0]=Double.parseDouble(person[0]);
			 a[i][1]=Double.parseDouble(person[1]);
			 size++;
			 i++;
		}	

	}
	 catch (IOException e) {
            e.printStackTrace();
        }
        
	System.out.println("Enter number of clusters :");
        clustcount = sc.nextInt();         
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
		int f=1;
		while(true)
		{
			System.out.println("Iteration"+f+":");			
	
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
				
				System.out.println("Here Minimum Distance is between "+"("+a[i][0]+","+a[i][1]+")"+"and cluster"+p+"And min distance is "+min  );
				System.out.println("Here Point  "+"("+a[i][0]+","+a[i][1]+")"+"is added to cluster"+p);				
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
		f++;
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

