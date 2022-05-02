package com.myownproject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DataBaseOperation1 {
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	int sd;
	String sn;
	String sc;
	int amount;
	int currentbalance;

	 void python() throws  IOException, SQLException {
		
		conn=DatabaseUtility1.getConnection();
		
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("student login form");
	   
	   System.out.println("Student id");
	   sd=Integer.parseInt(br.readLine());
	   System.out.println("Enter your name");
	   sn=br.readLine();
	   System.out.println("Enter your course");
	   sc=br.readLine();
	   System.out.println("your fees will be 5000,how many amount you want to pay");
	   amount=Integer.parseInt(br.readLine());
	   try
	   {
		  
		   if(amount<1000)
		   
		   {
			   throw new Exception(amount+" is low for this course you have to pay more than 1000");   
		   }
		   else
		   {
			   System.out.println("you are registered");
		   }
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		 
	currentbalance=5000-amount;
	try
	{
	System.out.println(currentbalance+" fees is pending");
	   String sel="select * from student1 where studId="+sd+"";
	    Statement stmt=conn.createStatement();
		
	 rs=stmt.executeQuery(sel);
		
		//check record exists
		if(!rs.next()) {
			String ins="insert into student1 values("+sd+",'"+sn+" ' ,'"+sc+"' ,"+amount+");";
			int i=stmt.executeUpdate(ins);
			if(i>0) {
				System.out.println("Record added successfully");
			}else
			{
				System.out.println("Record not added ");
			}
			
		}else {
			System.out.println("Schoo id "+sd +" is already exists");
		}
		 }
	catch(Exception e)
	{
			 e.printStackTrace();
		 }
		
		
	
	   
	        
	
	 while(true) {
			System.out.println("*****MENU***********");
			
			System.out.println("1.do you want to update your information");
			System.out.println("2.do you want to cancel your admission");
			System.out.println("3.display your Data");
			System.out.println("Enter the option");
			int ch=Integer.parseInt(br.readLine());
			switch(ch) {
			case 1:updateRecord();
			        break;
			case 2:deleteRecord();
			        break;

			case 3:displayParticlarRecord();
			       break;
		  
			        
			}
			System.out.println("Do you want to continue Y/N");
			char choice=br.readLine().charAt(0);
			if(choice=='n' || choice=='N') {
				break;
			}
	 }
	 }
			
	void updateRecord() throws NumberFormatException, IOException, SQLException
	{
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Student id");
		   sd=Integer.parseInt(br.readLine());
		   System.out.println("Enter your name");
		   sn=br.readLine();
		   System.out.println("Enter your course");
		   sc=br.readLine();
		   String sel="select * from student1 where studId="+sd+"";
		   Statement stmt=conn.createStatement();
			 rs=stmt.executeQuery(sel);
	
			 try
				{
			 if(rs.next()) {
					String ins="update student1 set studName='"+sn+"' where studId="+sd+"";
					int i=stmt.executeUpdate(ins);
				
					   
					   if(i>0)
					   {
					
						System.out.println("your Record is updated successfully");
					}
			      else
			         {
						System.out.println("Not updated");
				    
			         }
			 }
			 else
			 {
				 System.out.println("This id is not exist ");
					   
			 }
					
				
		}
	
		catch(Exception e) 
		{
				 e.printStackTrace();
			 }
			 
				
			 
	}
	 
void deleteRecord() throws NumberFormatException, IOException, SQLException

{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter your id to cancel your admission");
	 sd=Integer.parseInt(br.readLine());
	 String sel="select * from student1 where studId="+sd+"";
	   Statement stmt=conn.createStatement();
		 rs=stmt.executeQuery(sel);
		 try
			{
		 if(rs.next()) {
			 String delr="delete from student1 where studId="+sd;
				int i=stmt.executeUpdate(delr);
				if(i>0) {
					System.out.println("your admission has been cancelled");
		
			 	}
	          else {
					System.out.println("Record not deleted");
				}
			}else {
				System.out.println(sd+" not exists deletion not possible");
			}
		  
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 }
void displayParticlarRecord() throws NumberFormatException, IOException, SQLException
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter your id to show your details");
	 sd=Integer.parseInt(br.readLine());
	 String sel="select * from student1 where studId="+sd+"";
	   Statement stmt=conn.createStatement();
		 rs=stmt.executeQuery(sel);
		 System.out.println("studId\t studName\t CourseEnrolled\t balance");
		 try
		 {
			 if(rs.next()) {
				 System.out.println(""+sd+"\t ' "+sn+" '\t '"+sc+"'\t  "+amount+"");
			 }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 finally {
				
				if(rs!=null) {
				rs.close();
				}
				conn.close();
			}
			 
		}


	
	 
	 //java
	 void java() throws  IOException, SQLException {
			
			conn=DatabaseUtility1.getConnection();
			
		   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		   
		   System.out.println("Student id");
		   sd=Integer.parseInt(br.readLine());
		   System.out.println("Enter your name");
		   sn=br.readLine();
		   System.out.println("Enter your course");
		   sc=br.readLine();
		   System.out.println("your fees will be 10000,how many amount you want to pay");
		   amount=Integer.parseInt(br.readLine());
		   try
		   {
			  
			   if(amount<5000)
			   
			   {
				   throw new Exception(amount+" is low for this course you have to pay more than 5000");
				   
			   }
			  
			   else
			   {
				   System.out.println("you are registered");
			   }
			   }
			   catch(Exception e)
			   {
				   e.printStackTrace();
			   }
			 
		currentbalance=10000-amount;
		try
		{
		System.out.println(currentbalance+" fees is pending");
		   String sel="select * from student1 where studId="+sd+"";
		    Statement stmt=conn.createStatement();
			
		 rs=stmt.executeQuery(sel);
			
			//check record exists
			if(!rs.next()) {
				String ins="insert into student1 values("+sd+",'"+sn+" ' ,'"+sc+"' ,"+amount+");";
				int i=stmt.executeUpdate(ins);
				if(i>0) {
					System.out.println("Record added successfully");
				}else
				{
					System.out.println("Record not added ");
				}
				
			}else {
				System.out.println("Schoo id "+sd +" is already exists");
			}
			 }
		catch(Exception e)
		{
				 e.printStackTrace();
			 }
			
			
		

	 while(true) {
			System.out.println("*****MENU***********");
			
			System.out.println("1.do you want to update your information");
			System.out.println("2.do you want to cancel your admission");
			System.out.println("3.display your Data");
			System.out.println("Enter the option");
			int ch=Integer.parseInt(br.readLine());
			switch(ch) {
			case 1:update();
			        break;
			case 2:delete();
			        break;

			case 3:display();
			       break;
		  
			        
			}
			System.out.println("Do you want to continue Y/N");
			char choice=br.readLine().charAt(0);
			if(choice=='n' || choice=='N') 
			{
				break;
			}
	 }
	 }
	void update() throws NumberFormatException, IOException, SQLException
	{
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Student id");
		   sd=Integer.parseInt(br.readLine());
		   System.out.println("Enter your name");
		   sn=br.readLine();
		   System.out.println("Enter your course");
		   sc=br.readLine();
		   String sel="select * from student1 where studId="+sd+"";
		   Statement stmt=conn.createStatement();
			 rs=stmt.executeQuery(sel);
	
			 try
				{
			 if(rs.next()) {
					String ins="update student1 set studName='"+sn+"' where studId="+sd+"";
					int i=stmt.executeUpdate(ins);
				
					   
					   if(i>0)
					   {
					
						System.out.println("your Record is updated successfully");
					}
			      else
			         {
						System.out.println("Not updated");
				    
			         }
			 }
			 else
			 {
				 System.out.println("This id is not exist ");
					   
			 }
					
				
		}
	
		catch(Exception e) 
		{
				 e.printStackTrace();
			 }
			 
				
			 
	}
	 
void delete() throws NumberFormatException, IOException, SQLException

{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter your id to cancel your admission");
	 sd=Integer.parseInt(br.readLine());
	 String sel="select * from student1 where studId="+sd+"";
	   Statement stmt=conn.createStatement();
		 rs=stmt.executeQuery(sel);
		 try
			{
		 if(rs.next()) {
			 String delr="delete from student1 where studId="+sd;
				int i=stmt.executeUpdate(delr);
				if(i>0) {
					System.out.println("your admission has been cancelled");
		
			 	}
	          else {
					System.out.println("Record not deleted");
				}
			}else {
				System.out.println(sd+" not exists deletion not possible");
			}
		  
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 }
void display() throws NumberFormatException, IOException, SQLException
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter your id to show your details");
	 sd=Integer.parseInt(br.readLine());
	 String sel="select * from student1 where studId="+sd+"";
	   Statement stmt=conn.createStatement();
		 rs=stmt.executeQuery(sel);
		 System.out.println("studId\t studName\t CourseEnrolled\t balance");
		 try
		 {
			 if(rs.next()) {
				 System.out.println(""+sd+"\t ' "+sn+" '\t '"+sc+"'\t  "+amount+"");
			 }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 finally {
				
				if(rs!=null) {
				rs.close();
				}
				conn.close();
			}
			 
		}


		 
	 void php() throws  IOException, SQLException {
			
			conn=DatabaseUtility1.getConnection();
			
		   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		   
		   System.out.println("Student id");
		   sd=Integer.parseInt(br.readLine());
		   System.out.println("Enter your name");
		   sn=br.readLine();
		   System.out.println("Enter your course");
		   sc=br.readLine();
		   System.out.println("your fees will be 15000,how many amount you want to pay");
		   amount=Integer.parseInt(br.readLine());
		   try
		   {
			  
			   if(amount<7000)
			   
			   {
				   throw new Exception(amount+" is low for this course you have to pay more than 1000");   
			   }
			   else
			   {
				   System.out.println("you are registered");
			   }
			   }
			   catch(Exception e)
			   {
				   e.printStackTrace();
			   }
			 
		currentbalance=15000-amount;
		try
		{
		System.out.println(currentbalance+" fees is pending");
		   String sel="select * from student1 where studId="+sd+"";
		    Statement stmt=conn.createStatement();
			
		 rs=stmt.executeQuery(sel);
			
			//check record exists
			if(!rs.next()) {
				String ins="insert into student1 values("+sd+",'"+sn+" ' ,'"+sc+"' ,"+amount+");";
				int i=stmt.executeUpdate(ins);
				if(i>0) {
					System.out.println("Record added successfully");
				}else
				{
					System.out.println("Record not added ");
				}
				
			}else {
				System.out.println("Schoo id "+sd +" is already exists");
			}
			 }
		catch(Exception e)
		{
				 e.printStackTrace();
			 }
			

		 while(true) {
				System.out.println("*****MENU***********");
				
				System.out.println("1.do you want to update your information");
				System.out.println("2.do you want to cancel your admission");
				System.out.println("3.display your Data");
				System.out.println("Enter the option");
				int ch=Integer.parseInt(br.readLine());
				switch(ch) {
				case 1:updatephp();
				        break;
				case 2:deletephp();
				        break;

				case 3:displayphp();
				       break;
			  
				        
				}
				System.out.println("Do you want to continue Y/N");
				char choice=br.readLine().charAt(0);
				if(choice=='n' || choice=='N') 
				{
					break;
				}
		 }
		 }
		void updatephp() throws NumberFormatException, IOException, SQLException
		{
			  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Student id");
			   sd=Integer.parseInt(br.readLine());
			   System.out.println("Enter your name");
			   sn=br.readLine();
			   System.out.println("Enter your course");
			   sc=br.readLine();
			   String sel="select * from student1 where studId="+sd+"";
			   Statement stmt=conn.createStatement();
				 rs=stmt.executeQuery(sel);
		
				 try
					{
				 if(rs.next()) {
						String ins="update student1 set studName='"+sn+"' where studId="+sd+"";
						int i=stmt.executeUpdate(ins);
					
						   
						   if(i>0)
						   {
						
							System.out.println("your Record is updated successfully");
						}
				      else
				         {
							System.out.println("Not updated");
					    
				         }
				 }
				 else
				 {
					 System.out.println("This id is not exist ");
						   
				 }
						
					
			}
		
			catch(Exception e) 
			{
					 e.printStackTrace();
				 }
				 
					
				 
		}
		 
	void deletephp() throws NumberFormatException, IOException, SQLException

	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter your id to cancel your admission");
		 sd=Integer.parseInt(br.readLine());
		 String sel="select * from student1 where studId="+sd+"";
		   Statement stmt=conn.createStatement();
			 rs=stmt.executeQuery(sel);
			 try
				{
			 if(rs.next()) {
				 String delr="delete from student1 where studId="+sd;
					int i=stmt.executeUpdate(delr);
					if(i>0) {
						System.out.println("your admission has been cancelled");
			
				 	}
		          else {
						System.out.println("Record not deleted");
					}
				}else {
					System.out.println(sd+" not exists deletion not possible");
				}
			  
			 }catch(Exception e)
			 {
				 e.printStackTrace();
			 }
			 }
	void displayphp() throws NumberFormatException, IOException, SQLException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter your id to show your details");
		 sd=Integer.parseInt(br.readLine());
		 String sel="select * from student1 where studId="+sd+"";
		   Statement stmt=conn.createStatement();
			 rs=stmt.executeQuery(sel);
			 System.out.println("studId\t studName\t CourseEnrolled\t balance");
			 try
			 {
				 if(rs.next()) {
					 System.out.println(""+sd+"\t ' "+sn+" '\t '"+sc+"'\t  "+amount+"");
				 }
				 
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
			 finally {
					
					if(rs!=null) 
					{
					rs.close();
					}
					conn.close();
				}
				 
	}
}





