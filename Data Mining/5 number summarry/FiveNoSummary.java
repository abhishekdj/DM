import java.util.*;

class FiveNoSummary{
	public static void main(String[] args){
		int n;
		double med,q1,q3,iqr;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of records: ");
		n = sc.nextInt();
		
		int a[] = new int[n];
		
		System.out.println("Enter the records: ");
		for(int i = 0;i<n;i++){
			a[i] = sc.nextInt();
		} 
		
		Arrays.sort(a);
		
		for(int i = 0;i<n;i++){
			System.out.print(a[i]+" ");
		} 
		//System.out.println(n/4);
		
		if(n%2 != 0){
			med = a[(n)/2];
			if((n/4)==0)
			{
				q1=(double)a[n/4];
				q3=(double)a[3*n/4];
			}
			else if((n+1)/4==1 )
			{
				q1 = (double)(a[(n)/4]+a[((n)/4)-1])/2;
				q3 = (double)(a[3*(n)/4]+a[(3*(n)/4)+1])/2;
			}
			else
			{
				q1 = (double)(a[(n)/4]);
				q3 = (double)(a[3*(n)/4]);
			
			}			
		}
		
		else{
			med = ((double)(a[n/2] + a[(n/2)-1])/2);
			q1=(double)a[n/4];
			q3=(double)a[3*n/4];
		    }
		
		System.out.println("\nMinimum: "+a[0]);
		System.out.println("Maximum: "+a[n-1]);
		System.out.println("Median: "+med);		
		System.out.println("Q1: "+q1);		
		System.out.println("Q3: "+q3);
		iqr = q3 -q1;
		System.out.println("InterQuartile: "+iqr);		
		System.out.println("Lower limit : "+(q1-1.5*iqr));
		System.out.println("Upper limit : "+(q3+1.5*iqr));
				
		
		
	}
}
