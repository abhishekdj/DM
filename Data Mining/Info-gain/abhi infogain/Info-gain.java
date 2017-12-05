import java.io.*;
import java.util.*;
class Info_gain
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
        	try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
        	{

            	while ((line = br.readLine()) != null) 
            	{

                // use comma as separator
                String[] person = line.split(cvsSplitBy);

               // System.out.println(" age = " + person[0] + "  Income=  " + person[1] + "  Student=  "+person[2]+"  Credit Rating=  "+person[3]+" Buys Laptop= "+person[4]);
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
				 if(Integer.parseInt(person[0])>30&&Integer.parseInt(person[0])<40&&person[4].equals("NO"))	        		            
				   c6++;
				 
				 
				 
				 
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
				   
				 if(person[2].equals("Yes")&&person[4].equals("Yes"))
				   q1++;
				if(person[2].equals("NO")&&person[4].equals("Yes"))
				   q3++;
				if(person[2].equals("Yes")&&person[4].equals("Yes"))
				   q2++;
        		 if(person[2].equals("NO")&&person[4].equals("NO"))
				   q4++;
				   
				 if(person[3].equals("Fair")&&person[4].equals("Yes"))
				   j1++;
				if(person[3].equals("Excellent")&&person[4].equals("Yes"))
				   j3++;
				if(person[3].equals("Fair")&&person[4].equals("Yes"))
				   j2++;
        		 if(person[3].equals("Excellent")&&person[4].equals("NO"))
				   j4++;
				   
				   
            }
            double a=(double)(buyscount)/count;
            if(a==0)a=1;
            //System.out.println(buyscount+"  "+count+"  "+a);
            double b=(double)(count-buyscount)/count;
			if(b==0)b=1;
			//System.out.println(buyscount+"  "+count+"  "+a+" "+b);
			double I=-(a*(Math.log(a)/Math.log(2))+b*(Math.log(b)/Math.log(2)));
			//c3=count-c1-c2;
			//System.out.println(buyscount+"  "+count+"  "+a+" "+b+"  "+I);
			double s1=(double)c1/(c1+c2);
			if(s1==0)s1=1;
			double s2=(double)c2/(c1+c2);
			if(s2==0)s2=1;
			double s3=(double)c3/(c3+c4);
			if(s3==0)s3=1;
			double s4=(double)c4/(c3+c4);
			if(s4==0)s4=1;
			double s5=(double)c5/(c5+c6);
			if(s5==0)s5=1;
			double s6=(double)c6/(c5+c6);
		   	if(s6==0)s6=1;
			double i1=((double)(c1+c2)/count)*((s1)*(Math.log(s1)/Math.log(2))+(s2)*(Math.log(s2)/Math.log(2)));
			double i2=((double)(c3+c4)/count)*((s3)*(Math.log(s3)/Math.log(2))+(s4)*(Math.log(s4)/Math.log(2)));
			double i3=((double)(c5+c6)/count)*((s5)*(Math.log(s5)/Math.log(2))+(s6)*(Math.log(s6)/Math.log(2)));	
			double Iage=-(i1+i2+i3)	;
        	//System.out.println(" "+c1+" "+c2+" "+c3+" "+c4+" "+c5+" "+" "+c6+" "+i1+" "+i2+" "+i3);
        	//System.out.println(Iage);
        	double Info_gain_age=I-Iage;
        	System.out.println("Info gain from age is  "+Info_gain_age);
        	
        	double t1=(double)p1/(p1+p2);
			if(t1==0)t1=1;
			double t2=(double)p2/(p1+p2);
			if(t2==0)t2=1;
			double t3=(double)p3/(p3+p4);
			if(t3==0)t3=1;
			double t4=(double)p4/(p3+p4);
			if(t4==0)t4=1;
			double t5=(double)p5/(p5+p6);
			if(t5==0)t5=1;
			double t6=(double)p6/(p5+p6);
		   	if(t6==0)t6=1;
        	double i4=((double)(p1+p2)/count)*((t1)*(Math.log(t1)/Math.log(2))+(t2)*(Math.log(t2)/Math.log(2)));
			double i5=((double)(p3+p4)/count)*((t3)*(Math.log(t3)/Math.log(2))+(t4)*(Math.log(t4)/Math.log(2)));
			double i6=((double)(p5+p6)/count)*((t5)*(Math.log(t5)/Math.log(2))+(t6)*(Math.log(t6)/Math.log(2)));
			double Iincome=-(i4+i5+i6)	;
			double Info_gain_income=I-Iincome;
			System.out.println("Info gain from income is  "+Info_gain_income);
			
			
			double y1=(double)q1/(q1+q2);
			if(y1==0)y1=1;
			double y2=(double)q2/(q1+q2);
			if(y2==0)y2=1;
			double y3=(double)q3/(q3+q4);
			if(y3==0)y3=1;
			double y4=(double)q4/(q3+q4);
			if(y4==0)y4=1;
			double i7=((double)(q1+q2)/count)*((y1)*(Math.log(y1)/Math.log(2))+(y2)*(Math.log(y2)/Math.log(2)));
			double i8=((double)(q3+q4)/count)*((y3)*(Math.log(y3)/Math.log(2))+(y4)*(Math.log(y4)/Math.log(2)));
			
			double Istudent=-(i7+i8)	;
			double Info_gain_student=Math.abs(I-Istudent);
			
			System.out.println("Info gain from student is  "+Info_gain_student);
			
			
			
			double z1=(double)j1/(j1+j2);
			if(z1==0)z1=1;
			double z2=(double)j2/(j1+j2);
			if(z2==0)z2=1;
			double z3=(double)j3/(j3+j4);
			if(z3==0)z3=1;
			double z4=(double)j4/(j3+j4);
			if(z4==0)z4=1;
			
			double i9=((double)(j1+j2)/count)*((z1)*(Math.log(z1)/Math.log(2))+(z2)*(Math.log(z2)/Math.log(2)));
			double i10=((double)(j3+j4)/count)*((z3)*(Math.log(z3)/Math.log(2))+(z4)*(Math.log(z4)/Math.log(2)));
			
			double Icredit=-(i9+i10)	;
			double Info_gain_credit=Math.abs(I-Icredit);
			
			System.out.println("Info gain from Credit Rating is  "+Info_gain_credit);
			
			
        }
         catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
	
	}




}
