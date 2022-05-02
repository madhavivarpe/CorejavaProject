package com.myownproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
public class StudentManagementMain {
	public static void main(String[] args) throws NumberFormatException, IOException, SQLException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		DataBaseOperation1 ob = new DataBaseOperation1();
		while(true) {
			System.out.println("welcome to our institude");
			System.out.println("*****MENU***********");
			System.out.println("Select any one option");
			System.out.println("1.pyhon");
			System.out.println("2.java");
			System.out.println("3.php");
			System.out.println("Enter the option");
			int ch=Integer.parseInt(br.readLine());
			switch(ch) {
			case 1:ob.python();
			        break;
			case 2:ob.java();
			        break;
			case 3: ob.php();
			         break;
			          
			}
			System.out.println("Are you intrested in some other courses Y/N");
			char choice=br.readLine().charAt(0);
			if(choice=='N' || choice=='n')
			{
				System.out.println("Thank you for visiting us");
				break;
			}
			
		}
		
	}




	}

		

		


