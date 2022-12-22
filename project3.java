import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException classto handle errors
import java.io.FileWriter;
import java.io.FileReader;
import java.util.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;

/*
Project 2
Nikole Solano and Dave Dominique
*/

class Main 
{
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    //3 arraylists for each type of person
    ArrayList<Student> studentList= new ArrayList<Student>();
    ArrayList<Faculty> facultyList= new ArrayList<Faculty>();
    ArrayList<Staff> staffList= new ArrayList<Staff>();

    System.out.println("Welcome to my Personal Managment Program\n\nChoose one of the options: \n");
    boolean loop = true;
    while(loop)
    {
      System.out.println("1- Enter the infomation of a faculty \n2- Enter the information of a student \n3- Print tuition invoice for a student \n4- Print faculty information \n5- Enter the information of a staff member \n6- Print the information of a staff memeber\n7-Exit Program \n");
      System.out.print("\tEnter your selection: ");

      switch(scan.next())
      {
        case "1": 
          String facultyName = " ", facultyId = " ", facultyRank = null, facultyDepartment = null;
          
          System.out.println("Enter the faculty info: \n");
          
          System.out.print("\t Name of the faculty: ");
          scan.nextLine(); 
          facultyName = scan.nextLine();

          //IdException
          while(true)
         {
          try{
              Scanner scan2 = new Scanner(System.in);
              int len = 0;
              System.out.print("\n\tID: ");
              facultyId = scan.nextLine();
              len = facultyId.length();

              if(!(len == 6 && Character.isLetter(facultyId.charAt(0)) == true && Character.isLetter(facultyId.charAt(1)) == true && Character.isDigit(facultyId.charAt(2)) == true && Character.isDigit(facultyId.charAt(3)) == true && Character.isDigit(facultyId.charAt(4)) == true && Character.isDigit(facultyId.charAt(5)) == true))
                {
                  throw new Exception("Invalid ID format. Must be LetterLetterDigitDigitDigitDigit");
                }
              break;

          }catch(Exception q){
            System.out.println(q);
          }
      }
          //this will check for duplicates
          int duploop = 1;
          while(duploop == 1)
          {
            if(checkDuplicateFaculty(facultyList, facultyId) == 1)
            {
              System.out.println("Duplicate id found. Please enter a different id.");
              facultyId = scan.next();
              duploop = 1;
            }
            else
            {
              duploop = 0;
            }
          }

          
          System.out.print("\n\tRank: ");
          String user = scan.next();
          int loop2 = 1;
          //only two options for rank
          while(loop2 == 1)
          {
            if(user.equalsIgnoreCase("professor") || user.equalsIgnoreCase("adjunct"))
            {
              facultyRank = user;
              loop2 = 0;
            } 
            else
            {
              System.out.println("\t\"" + user + "\" is invalid\n");
              System.out.print("\tRank: ");
              scan.nextLine();
              user = scan.next();
              loop2 = 1;
            }
          }
          System.out.print("\n\tDepartment: ");
          String user2 = scan.next();
          int loop3 = 1;
          //only 3 options for department
          while(loop3 == 1)
          {
            if(user2.equalsIgnoreCase("mathematics") || user2.equalsIgnoreCase("engineering") || user2.equalsIgnoreCase("sciences"))
            {
              facultyDepartment = user2;
              loop3 = 0;
            }
            else
            {
              System.out.println("\t\"" + user2 + "\" is invalid\n");
              System.out.print("\tDepartment: ");
              user2 = scan.next();
              loop3 = 1;
            }
          }
          //adds a new faculty member to facultyList
          facultyList.add(new Faculty(facultyName, facultyId, facultyRank, facultyDepartment));

          System.out.println("Faculty added!\n");
          break;

        case "2": 
          String studentName = " ", studentId = " ";
          double studentGpa = 0;
          int studentCreditHours = 0; 
          System.out.println("Enter the student info: ");
          System.out.print("\tName of the student: ");
          scan.nextLine();
          studentName = scan.nextLine();
         
          //IDEXCEPTION
        
          while(true)
      {
        try{
            Scanner scan2 = new Scanner(System.in);
            int len = 0;
            System.out.print("\n\tID: ");
            studentId = scan2.next();
            len = studentId.length();

            if(!(len == 6 && Character.isLetter(studentId.charAt(0)) == true && Character.isLetter(studentId.charAt(1)) == true && Character.isDigit(studentId.charAt(2)) == true && Character.isDigit(studentId.charAt(3)) == true && Character.isDigit(studentId.charAt(4)) == true && Character.isDigit(studentId.charAt(5)) == true))
              {
                throw new Exception("Invalid ID format. Must be LetterLetterDigitDigitDigitDigit");
              }
           break;

        }catch(Exception q){
          System.out.println(q);
        }
      }
          //checks for duplicate id's
          int duploop2 = 1;
          while(duploop2 == 1)
          {
            if(checkDuplicateStudent(studentList, studentId) == 1)
            {
              System.out.println("Duplicate id found. Please enter a different id.");
              studentId = scan.next();
              duploop2 = 1;
            }
            else
            {
              duploop2 = 0;
            }
          }
          //catches if gpa is not a double
          while(true){
             try{
                System.out.print("\n\tGpa: ");
                Scanner myScan = new Scanner(System.in);
                studentGpa = myScan.nextDouble();
                break;
            }catch(Exception e){
                System.out.println("Input Mismatch!");
               
            }
          }
          //catches if credit hours is not an int
          while(true){
            try{
              System.out.print("\n\tCredit Hours: ");
               Scanner myScan2 = new Scanner(System.in);
             studentCreditHours = myScan2.nextInt();
             break;
          }catch(InputMismatchException exception){
               System.out.println("Input Mismatch!");
          }
          }
          //adds a new student to studentList
          studentList.add(new Student(studentName, studentId, studentGpa, studentCreditHours));
          System.out.println("Student added!");
          break;

        case "3": System.out.print("\tEnter the student's id: ");
        String studentid = scan.next();
        int flag = 0;
        //finds the student in the arrayList
        for(int i = 0; i < studentList.size(); i++)
        {
          if(studentList.get(i).getId().equalsIgnoreCase(studentid))
          {
            //if student found, print out an invoice
            Student.invoice(studentList.get(i));
            flag = 1;
            break;
          }
        }
        if(flag == 0)
        {
          //if student not found, do not print out invoice
          System.out.println("\nNo Student Matched!");
        }
        break;

        case "4":
        System.out.println("\tEnter the faculty's id: ");
        String facultyId5 = scan.next();
        int flag6 = 0;
        //looping through array to find faculty member
        for(int i = 0; i < facultyList.size(); i++)
        {
          if(facultyList.get(i).getId().equalsIgnoreCase(facultyId5))
          {
            //if faculty member is found, print out info
        	  System.out.println("\n--------------------------------------------------------------------------------------");
              System.out.println(facultyList.get(i).getName() + "\t" + facultyList.get(i).getId());
              System.out.println(facultyList.get(i).getDepartment() + " department, " + facultyList.get(i).getRank());
              System.out.println("--------------------------------------------------------------------------------------");
              flag6 = 1;
            break;
          }
        }
        if(flag6 == 0)
        {
          //if it isn't in the array, do not print out invoice
        	System.out.println("\nNo Faculty Member matched!");
        }
        break;

       case "5": 
          String staffName, staffId, staffDepartment, staffStatus = " ";
          char status;

            System.out.println("Name of the staff member: ");
            scan.nextLine(); 
            staffName = scan.nextLine();
            
            System.out.println("Enter the id: ");
            staffId = scan.next();
            //checks for duplicates
            int duploop3 = 1;
            while(duploop3 == 1)
            {
              if(checkDuplicateStaff(staffList, staffId) == 1)
              {
                System.out.println("Duplicate id found. Please enter a different id.");
                staffId = scan.next();
                duploop3 = 1;
              }
              else
              {
                duploop3 = 0;
              }
            }
            System.out.println("Department: ");
            scan.nextLine(); 
            staffDepartment = scan.nextLine();
            //catches if status is not p or f
            while(true)
            {
              try{
                System.out.println("Status, Enter P for Part time or Enter F for Full Time: ");
                  Scanner myScan3 = new Scanner(System.in);
                  staffStatus = myScan3.nextLine();
                 
                 break;
              }catch(InputMismatchException d ){
                  System.out.println("Input Mismatch!");
              }
            }
            //adds a new staff member to staffList
            staffList.add(new Staff(staffName, staffId, staffDepartment, staffStatus));
          
            System.out.println("Staff member added!");
            break;

        case "6":        
        System.out.println("Enter the Staff's id: ");
        String stafftid = scan.next();
        int flag5 = 0;
        //looping through staff array to find member
        for(int i = 0; i < staffList.size(); i++)
        {
          if(staffList.get(i).getId().equalsIgnoreCase(stafftid))
          {
            //if member found, print out info
        	  System.out.println("--------------------------------------------------------------------------------------");
              System.out.println(staffList.get(i).getName() + "\t" + staffList.get(i).getId());
              System.out.print(staffList.get(i).getDepartment() + " department, ");
              if(staffList.get(i).getStatus().equalsIgnoreCase("f"))
              {
                System.out.print("Full Time");
              }
              else  
              {
                System.out.print("Part Time");
              }
              System.out.println("\n--------------------------------------------------------------------------------------");
            flag5 = 1;
            break;
          }
        }
        if(flag5 == 0)
        {
          //not found in the array, do not print out info
          System.out.println("No Staff Member matched!");
        }
        break;
        

        case "7":
          System.out.println("Would you like to create the report? (Y/N");

          String printchoice = scan.next();
          if(printchoice.equalsIgnoreCase("y"))
          {
            long millis=System.currentTimeMillis();  
            java.sql.Date date=new java.sql.Date(millis);  
           // System.out.println(date);  

             try {
                FileWriter myWriter = new FileWriter("report.txt");

              myWriter.write("Report created on " + date +"\n" );
              myWriter.write("***********************\n\n");
              myWriter.write("Faculty Members\n");
              myWriter.write("-------------------------\n");
              //print out all faculty
              for(int i = 0; i < facultyList.size(); i++)
              {
                myWriter.write(i + 1 + "." + facultyList.get(i).getName()+"\n");
                myWriter.write("ID: " + facultyList.get(i).getId() + "\n");
                myWriter.write(facultyList.get(i).getRank() + ", " + facultyList.get(i).getDepartment() + "\n\n");
                
              }
              myWriter.write("\n\n\n");
              
              myWriter.write("Staff Members\n");
              myWriter.write("-------------------------\n");
              //print out all staff
              String curStatus;
              for(int i = 0; i < staffList.size(); i++)
              {
                myWriter.write(i + 1 + "." + staffList.get(i).getName()+"\n");
                myWriter.write("ID: " + staffList.get(i).getId() + "\n");
                if(staffList.get(i).getStatus().equalsIgnoreCase("f"))
                {
                  curStatus = "Full Time";
                }
                else
                {
                  curStatus = "Part Time";
                }
                myWriter.write(staffList.get(i).getDepartment() + ", " + curStatus + "\n\n");
              }
              myWriter.write("\n\n\n");

              myWriter.write("Students\n");
              myWriter.write("-------------------------\n");
              //print out all students
              for(int i = 0; i < studentList.size(); i++)
              {
                myWriter.write(i + 1 + "." + studentList.get(i).getName()+"\n");
                myWriter.write("ID: " + studentList.get(i).getId() + "\n");
                myWriter.write("Gpa: " + studentList.get(i).getGpa()+ "\n");
                myWriter.write("Credit Hours: " + studentList.get(i).getCreditHours() + "\n\n");
              }
              myWriter.write("\n\n\n");
               
              myWriter.close();

                
              } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
              }

             System.out.println("Report created and saved on your hard drive!");  
            System.out.println("\n\nGoodbye!");
	          System.exit(0);
            
          }       
	        else
          {
            System.out.println("\n\nGoodbye!");
	          System.exit(0);
          }
	        break;

        default: System.out.println("Invalid entry - please try again");
          break;
      }  
    }
    scan.close();
  }
  //methods to check for duplicate id's
  public static int checkDuplicateFaculty(ArrayList<Faculty> facultyList, String id)
  {
    int flag = 2;
    for(int i = 0; i < facultyList.size(); i++)
    {
      if(facultyList.get(i).getId().equalsIgnoreCase(id))
      {
        flag = 1;
      }
      else
      {
        flag = 0;
      }
    }
    return flag;
  }
  public static int checkDuplicateStudent(ArrayList<Student> studentList, String id)
  {
    int flag = 2;
    for(int i = 0; i < studentList.size(); i++)
    {
      if(studentList.get(i).getId().equalsIgnoreCase(id))
      {
        flag = 1;
      }
      else
      {
        flag = 0;
      }
    }
    return flag;
  }
  public static int checkDuplicateStaff(ArrayList<Staff> staffList, String id)
  {
    int flag = 2;
    for(int i = 0; i < staffList.size(); i++)
    {
      if(staffList.get(i).getId().equalsIgnoreCase(id))
      {
        flag = 1;
      }
      else
      {
        flag = 0;
      }
    }
    return flag;
  }
}

//-----------------
abstract class Person{
  private String id;
  private String name;
  public String getName(){
    return name;
  }
  public void setName(String name){
    this.name = name;
  }
  public String getId(){
    return id;
  }
  public void setId(String id){
    this.id = id;
  }
}

//-----------------
class Student extends Person{
  private int creditHours;
  private double gpa;

  public double getGpa(){
    return gpa;
  }
  public void setGpa(double gpa){
    this.gpa = gpa;
  }
  public int getCreditHours(){
    return creditHours;
  }
  public void setCreditHours(int creditHours){
    this.creditHours = creditHours;
  }
  public static void invoice(Student student1)
  {
    //formatting
    final DecimalFormat df = new DecimalFormat("0.00");
    System.out.println("\nHere is the tuition invoice for " + student1.getName());
    System.out.println("--------------------------------------------------------------------------------------");
    double total, tempTotal;
    double discount = 0;
    System.out.println(student1.getName() + "\t" + student1.getId());
    System.out.println("Credit Hours: "  + student1.getCreditHours() + "($236.45/credit hour)");
    System.out.println("Fees: $52\n\n");
    if(student1.getGpa() >= 3.85)
    { 
      tempTotal = (235.45 * student1.getCreditHours() + 52);
      discount = (.25 * tempTotal);
      total = tempTotal - discount;
    }
    else
    {
      total = (236.45 * student1.getCreditHours()) + 52;
    }
    System.out.printf("Total payment (after discount): "+df.format(total)+ "      ($" +df.format(discount) + " discount applied)\n");
    System.out.println("--------------------------------------------------------------------------------------");
  }
  public Student(String name, String id, double gpa, int creditHours){
    setName(name);
    setId(id);
    setGpa(gpa);
    setCreditHours(creditHours);
  }
}
//------------------
abstract class Employee extends Person{
  private String department;
  public String getDepartment(){
    return department;
  }
  public void setDepartment(String department){
    this.department = department;
  }
}
//-------------------
class Faculty extends Employee{
  private String rank;
  public String getRank(){
    return rank;
  }
  public void setRank(String rank){
    this.rank = rank;
  }
  public Faculty(String name, String id, String rank, String department){
    setName(name);
    setId(id);
    setRank(rank);
    setDepartment(department);
  }
}
//--------------------
class Staff extends Employee{
  private String status;

  public String getStatus(){
    return status;
  }
  public void setStatus(String status){
    this.status = status;
  }
  public Staff(String name, String id, String department, String status){
    setName(name);
    setId(id);
    setDepartment(department);
    setStatus(status);
  }
}

