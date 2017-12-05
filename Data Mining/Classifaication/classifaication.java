import java.io.*;
import java.util.*;
class classifaication
{
	public static void main(String []args)
	{
		 String csvFile = "person.csv";	//give address of csv file here
		 String line = "";
       		 String cvsSplitBy = ",";
       		 int buyscount=0,count=0;
       		 int c1=0,c2=0,c3=0,c4=0,c5=0,c6=0;
       		 int p1=0,p2=0,p3=0,p4=0,p5=0,p6=0;
       		 int q1=0,q2=0,q3=0,q4=0;
       		 int j1=0,j2=0,j3=0,j4=0;
		 double p_c1=0,p_c2=0,p_c3=0,p_c4=0,p_c5=0,p_c6=0;
		 double p_p1=0,p_p2=0,p_p3=0,p_p4=0,p_p5=0,p_p6=0;
		 double p_q1=0,p_q2=0,p_q3=0,p_q4=0;
		 double p_j1=0,p_j2=0,p_j3=0,p_j4=0;
		 double p_yes=0,p_no=0;
		  Scanner sc=new Scanner(System.in);                                           
        	try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
        	{

            		while ((line = br.readLine()) != null) 
            		{

             		         String[] person = line.split(cvsSplitBy);

        
        		        if(person[4].equals("Yes"))
        		 	    {
					buyscount++;
				     }
				
            			count++;              
              		    if(Integer.parseInt(person[0])<30&&person[4].equals("Yes"))
				   c1++;
				 if(Integer.parseInt(person[0])>40&&person[4].equals("Yes"))
				   c3++;
				if(Integer.parseInt(person[0])>30&&Integer.parseInt(person[0])<40&&person[4].equals("Yes"))
				   c5++;
        		 if(Integer.parseInt(person[0])<30&&person[4].equals("NO"))
				   c2++;
				 if(Integer.parseInt(person[0])>40&&person[4].equals("NO"))
				   c4++;
				 if(Integer.parseInt(person[0])>30&&Integer.parseInt(person[0])<40&&person[4].equals("NO"))	        		            		 c6++;
				 
				 p_c1=(double)(c1)/(c1+c2); 
				 p_c2=(double)(c2)/(c1+c2); 
				 p_c3=(double)(c3)/(c3+c4);
				 p_c4=(double)(c4)/(c3+c4);
				 p_c5=(double)(c5)/(c5+c6);
				 p_c6=(double)(c6)/(c5+c6);	 
				 if(person[1].equals("High")&&person[4].equals("Yes"))
				   p1++;
				if(person[1].equals("Medium")&&person[4].equals("Yes"))
				   p3++;
				if(person[1].equals("Low")&&person[4].equals("Yes"))
				   p5++;
        		 if(person[1].equals("High")&&person[4].equals("NO"))
				   p2++;
				 if(person[1].equals("Medium")&&person[4].equals("NO"))
				   p4++;
				 if(person[1].equals("Low")&&person[4].equals("NO"))	        		            
				   p6++;
				 	  
				 p_p1=(double)(p1)/(p1+p2);
				 p_p2=(double)(p2)/(p1+p2);
				 p_p3=(double)(p3)/(p3+p4);
				 p_p4=(double)(p4)/(p3+p4);
				 p_p5=(double)(p5)/(p5+p6);
				 p_p6=(double)(p6)/(p5+p6);


				 if(person[2].equals("Yes")&&person[4].equals("Yes"))
				   q1++;
				if(person[2].equals("NO")&&person[4].equals("Yes"))
				   q3++;
				if(person[2].equals("Yes")&&person[4].equals("NO"))
				   q2++;
      		  		 if(person[2].equals("NO")&&person[4].equals("NO"))
				   q4++;

				 p_q1=(double)(q1)/(q1+q2);
				 p_q2=(double)(q2)/(q1+q2);
				 p_q3=(double)(q3)/(q3+q4);
				 p_q4=(double)(q4)/(q3+q4);



				   
				 if(person[3].equals("Fair")&&person[4].equals("Yes"))
				   j1++;
				if(person[3].equals("Excellent")&&person[4].equals("Yes"))
				   j3++;
				if(person[3].equals("Fair")&&person[4].equals("NO"))
				   j2++;
        		 	if(person[3].equals("Excellent")&&person[4].equals("NO"))
				   j4++;
				   
				 p_j1=(double)(j1)/(j1+j2);
				 p_j2=(double)(j2)/(j1+j2);
				 p_j3=(double)(j3)/(j3+j4);
				 p_j4=(double)(j3)/(j3+j4);
			}

				System.out.println("Input a test case:");
				System.out.println("Enter age");
				int age=sc.nextInt();
				System.out.println("Enter Income");
				String income=sc.next();
				System.out.println("Enter Whether person is student or not");					
				String student=sc.next();
				System.out.println("Enter rating");
				String rating=sc.next();
				
				
				
				if(age<30 && income.equals("High") && student.equals("Yes") && rating.equals("Fair"))
				{
					p_yes=p_c1*p_p1*p_q1*p_j1;
					p_no=p_c2*p_p2*p_q2*p_j2;
				}
				if(age<30 && income.equals("High") && student.equals("Yes")&& rating.equals("Excellent"))
				{
					p_yes=p_c1*p_p1*p_q1*p_j3;
					p_no=p_c2*p_p2*p_q2*p_j4;
				}
				
				if(age<30 && income.equals("High") && student.equals("No") && rating.equals("Fair"))
				{
					p_yes=p_c1*p_p1*p_q3*p_j1;
					p_no=p_c2*p_p2*p_q4*p_j2;
				}
				
				if(age<30 && income.equals("High")&& student.equals("No")&& rating.equals("Excellent"))
				{
					p_yes=p_c1*p_p1*p_q3*p_j3;
					p_no=p_c2*p_p2*p_q4*p_j4;
				}
				
				if(age<30 && income.equals("Medium") && student.equals("Yes") && rating.equals("Fair"))
				{
					p_yes=p_c1*p_p3*p_q1*p_j1;
					p_no=p_c2*p_p4*p_q2*p_j2;
				}
				
				if(age<30 && income.equals("Medium") && student.equals("Yes") && rating.equals("Excellent"))
				{
					p_yes=p_c1*p_p3*p_q1*p_j3;
					p_no=p_c2*p_p4*p_q2*p_j4;
				}
				
				if(age<30 && income.equals("Medium") && student.equals("No") && rating.equals("Fair"))
				{
					p_yes=p_c1*p_p3*p_q3*p_j1;
					p_no=p_c2*p_p4*p_q4*p_j2;
				}
				
				if(age<30 && income.equals("Medium") && student.equals("No") && rating.equals("Excellent"))
				{
					p_yes=p_c1*p_p3*p_q3*p_j3;
					p_no=p_c2*p_p4*p_q4*p_j4;
				}
				
				if(age<30 && income.equals("Low") && student.equals("Yes") && rating.equals("Fair"))
				{
					p_yes=p_c1*p_p5*p_q1*p_j1;
					p_no=p_c2*p_p6*p_q2*p_j2;
				}
				
				if(age<30 && income.equals("Low") && student.equals("Yes") && rating.equals("Excellent"))
				{
					p_yes=p_c1*p_p5*p_q1*p_j3;
					p_no=p_c2*p_p6*p_q2*p_j4;
				}
				
				if(age<30 && income.equals("Low") && student.equals("No") && rating.equals("Fair"))
				{
					p_yes=p_c1*p_p5*p_q3*p_j1;
					p_no=p_c2*p_p6*p_q4*p_j2;
				}
				
				if(age<30 && income.equals("Low") && student.equals("No") && rating.equals("Excellent"))
				{
					p_yes=p_c1*p_p5*p_q3*p_j3;
					p_no=p_c2*p_p6*p_q4*p_j4;
				}	


				
				if(age>40 && income.equals("High") && student.equals("Yes") && rating.equals("Fair"))
				{
					p_yes=p_c3*p_p1*p_q1*p_j1;
					p_no=p_c4*p_p2*p_q2*p_j2;
				}
				if(age>40 && income.equals("High") && student.equals("Yes") && rating.equals("Excellent"))
				{
					p_yes=p_c3*p_p1*p_q1*p_j3;
					p_no=p_c4*p_p2*p_q2*p_j4;
				}
				
				if(age>40 && income.equals("High") && student.equals("No") && rating.equals("Fair"))
				{
					p_yes=p_c3*p_p1*p_q3*p_j1;
					p_no=p_c4*p_p2*p_q4*p_j2;
				}
				
				if(age>40 && income.equals("High") && student.equals("No") && rating.equals("Excellent"))
				{
					p_yes=p_c3*p_p1*p_q3*p_j3;
					p_no=p_c4*p_p2*p_q4*p_j4;
				}
				
				if(age>40 && income.equals("Medium") && student.equals("Yes") && rating.equals("Fair"))
				{
					p_yes=p_c3*p_p3*p_q1*p_j1;
					p_no=p_c4*p_p4*p_q2*p_j2;
				}
				
				if(age>40 && income.equals("Medium") && student.equals("Yes") && rating.equals("Excellent"))
				{
					p_yes=p_c3*p_p3*p_q1*p_j3;
					p_no=p_c4*p_p4*p_q2*p_j4;
				}
				
				if(age>40 && income.equals("Medium") && student.equals("No") && rating.equals("Fair"))
				{
					p_yes=p_c3*p_p3*p_q3*p_j1;
					p_no=p_c4*p_p4*p_q4*p_j2;
				}
				
				if(age>40 && income.equals("Medium") && student.equals("No") && rating.equals("Excellent"))
				{
					p_yes=p_c3*p_p3*p_q3*p_j3;
					p_no=p_c4*p_p4*p_q4*p_j4;
				}
				
				if(age>40 && income.equals("Low") && student.equals("Yes") && rating.equals("Fair"))
				{
					p_yes=p_c3*p_p5*p_q1*p_j1;
					p_no=p_c4*p_p6*p_q2*p_j2;
				}
				
				if(age>40 && income.equals("Low") && student.equals("Yes") && rating.equals("Excellent"))
				{
					p_yes=p_c3*p_p5*p_q1*p_j3;
					p_no=p_c4*p_p6*p_q2*p_j4;
				}
				
				if(age>40 && income.equals("Low") && student.equals("No") && rating.equals("Fair"))
				{
					p_yes=p_c3*p_p5*p_q3*p_j1;
					p_no=p_c4*p_p6*p_q4*p_j2;
				}
				
				if(age>40 && income.equals("Low") && student.equals("No") && rating.equals("Excellent"))
				{
					p_yes=p_c3*p_p5*p_q3*p_j3;
					p_no=p_c4*p_p6*p_q4*p_j4;
				}
				if(age>30&&age<40 && income.equals("High") && student.equals("Yes") && rating.equals("Fair"))
				{
					p_yes=p_c5*p_p1*p_q1*p_j1;
					p_no=p_c6*p_p2*p_q2*p_j2;
				}
				if(age>30&&age<40 && income.equals("High") && student.equals("Yes") && rating.equals("Excellent"))
				{
					p_yes=p_c5*p_p1*p_q1*p_j3;
					p_no=p_c6*p_p2*p_q2*p_j4;
				}
				
				if(age>30&&age<40 && income.equals("High") && student.equals("No") && rating.equals("Fair"))
				{
					p_yes=(double)p_c5*p_p1*p_q3*p_j1;
					p_no=(double)p_c6*p_p2*p_q4*p_j2;
				}
				
				if(age>30&&age<40 && income.equals("High") && student.equals("No") && rating.equals("Excellent"))
				{
					p_yes=(double)p_c5*p_p1*p_q3*p_j3;
					p_no=(double)p_c6*p_p2*p_q4*p_j4;
				}
				
				if(age>30&&age<40 && income.equals("Medium") && student.equals("Yes") && rating.equals("Fair"))
				{
					p_yes=p_c5*p_p3*p_q1*p_j1;
					p_no=p_c6*p_p4*p_q2*p_j2;
				}
				
				if(age>30&&age<40 && income.equals("Medium") && student.equals("Yes") && rating.equals("Excellent"))
				{
					p_yes=p_c5*p_p3*p_q1*p_j3;
					p_no=p_c6*p_p4*p_q2*p_j4;
				}
				
				if(age>30&&age<40 && income.equals("Medium") && student.equals("No") && rating.equals("Fair"))
				{
					p_yes=p_c5*p_p3*p_q3*p_j1;
					p_no=p_c6*p_p4*p_q4*p_j2;
				}
				
				if(age>30&&age<40 && income.equals("Medium") && student.equals("No") && rating.equals("Excellent"))
				{
					p_yes=p_c5*p_p3*p_q3*p_j3;
					p_no=p_c6*p_p4*p_q4*p_j4;
				}
				
				if(age>30&&age<40 && income.equals("Low") && student.equals("Yes") && rating.equals("Fair"))
				{
					p_yes=p_c5*p_p5*p_q1*p_j1;
					p_no=p_c6*p_p6*p_q2*p_j2;
				}
				
				if(age>30&&age<40 && income.equals("Low") && student.equals("Yes") && rating.equals("Excellent"))
				{
					p_yes=p_c5*p_p5*p_q1*p_j3;
					p_no=p_c6*p_p6*p_q2*p_j4;
				}
				
				if(age>30&&age<40 && income.equals("Low") && student.equals("No") && rating.equals("Fair"))
				{
					p_yes=p_c5*p_p5*p_q3*p_j1;
					p_no=p_c6*p_p6*p_q4*p_j2;
				}
				
				if(age>30&&age<40 && income.equals("Low") && student.equals("No") && rating.equals("Excellent"))
				{
					p_yes=p_c5*p_p5*p_q3*p_j3;
					p_no=p_c6*p_p6*p_q4*p_j4;
				}
				System.out.println("Postirier Probability of class Buys a Computer is "+p_yes);
				System.out.println("Postirier Probability of class Not Buys a Computer is "+p_no);
				if(p_yes>p_no)
				System.out.println("Hence Prediction is : Yes");
				else
				System.out.println("Hence Prediction is : No");	
            
            	
        }
         catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
	
	}




}
