package cgg.spring.orm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cgg.spring.orm.dao.StudentDao;
import cgg.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentdao",StudentDao.class);
        
//        Student student = new Student();
//        student.setStudentId(2345);
//        student.setStudentName("Fathima");
//        student.setStudentCity("hyd");
//        
//        int r = studentDao.insert(student);
//        System.out.println("done "+r);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean go = true;
        while(go) {
        	System.out.println("PRESS 1 for add new Student");
        	System.out.println("PRESS 2 for displau all Students");
        	System.out.println("PRESS 3  get detail of Single Student");
        	System.out.println("PRESS 4 for delete Student");
        	System.out.println("PRESS 5 for update Student");
        	System.out.println("PRESS 6 for exit");
        	
        	try {
				int input=Integer.parseInt(br.readLine());
				switch(input) {
				case 1: //add a new student
					    System.out.println("Enter student id: ");
					    int uId = Integer.parseInt(br.readLine());
				
					    System.out.println("Enter student name");
					    String name = br.readLine();
					    
					    System.out.println("Enter student city");
					    String city = br.readLine();
					    
					    Student student = new Student();
					    student.setStudentId(uId);
					    student.setStudentName(name);
					    student.setStudentCity(city);
					    
					    int r = studentDao.insert(student);
					    System.out.println(r+" student added");
					    
					    System.out.println("******************************");
					    System.out.println();
					    break;
					    
					    case 2: 
					    	    //display all students
					    	List<Student> allStudents = studentDao.getAllStudents();
					         for (Student st : allStudents) {
								System.out.println("Id :       "+st.getStudentId());
								System.out.println("Name :     "+st.getStudentName());
								System.out.println("City :     "+st.getStudentCity());
								System.out.println("_________________________________");
							}
					         
					         break;
					         
					    case 3: //get single student data
					    	System.out.println("Enter student id :");
						    int studId = Integer.parseInt(br.readLine());
						    
						    Student stud  = studentDao.getStudent(studId);
						    System.out.println("Id :       "+stud.getStudentId());
							System.out.println("Name :     "+stud.getStudentName());
							System.out.println("City :     "+stud.getStudentCity());
							System.out.println("_________________________________");
							break;
					    
					    case 4: // delete student
					    	System.out.println("Enter student id :");
						    int id = Integer.parseInt(br.readLine());
						    
						    studentDao.delete(id);
						    System.out.println("Student deleted.....");
						    break;
						    
					    case 5: //update student
					    	System.out.println("Enter student id :");
						    id = Integer.parseInt(br.readLine());
						    
						    System.out.println("Enter student name");
						    name = br.readLine();
						    
						    System.out.println("Enter student city");
						    city = br.readLine();
						    
						    student = new Student();
						    student.setStudentId(id);
						    student.setStudentName(name);
						    student.setStudentCity(city);
						    
						    studentDao.update(student);
						    System.out.println("Student Updated .....");
						    break;
						    
						    case 6: //exit
						    	   go= false;
						    	   break;
						    
				
				}
				
			} catch (NumberFormatException | IOException e) {
				System.out.println("Invalid input try with another one !!");
				System.out.println(e.getMessage());
			}
        	
        }
        
      System.out.println("Thankyou for using my application");
      System.out.println("see you soon");
        
        
    }
}
