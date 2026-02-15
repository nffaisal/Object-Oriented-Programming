
public class assignmentQ1 {
    public static void main(String[] args) {
    //Question 1
    System.out.println("New student object with default Constructor: ");
    Student student_1 = new Student();       //passing no parameters
    student_1.DisplayInfo();               //displaying all student no 1 data
    System.out.println("New student object with parameters passed to Constructor: ");    
    Student student_2 =new Student(2343, "Fatima ", 3.24, "Computer Science");     //passing all information of the Student2 when creating the new object
    student_2.DisplayInfo();        //Displaying all Student Number 2 Data
    
    //Question 2
    //Using Getter Methods  From Class STudent
    Student student_3 =new Student();         // Creating New Student
    System.out.println("Using Getter Methods: ");
    System.out.print("Getting Student Name: ");
    System.out.println(student_3.getName());     //getting student name
    System.out.print("Getting Student Course:");
    System.out.println(student_3.getCourse());    //getting student course    
    System.out.print("Getting Student GPA:");
    System.out.println(student_3.getGPA());       //getting student GPA
    System.out.print("Getting Student ID:");
    System.out.println(student_3.getStudentID());  //Getting Student ID

    //Using Setter Methods from Class Student
    System.out.println("USing Setter Methods: ");
    student_3.setName("Hasher");
    student_3.setStudentID(2342);
    student_3.setCourse("Mechanical Engineering");
    student_3.updateGPA(4.5);//will not update gpa
    System.out.println("getting gpa after updating to 4.5 (does not pass check): " + student_3.getGPA());
    student_3.updateGPA(3.6);
    student_3.DisplayInfo();
    System.out.print("Scholarship Status: ");
    student_3.getScholarshipStatus(student_3.getGPA()); 

    //Q5 Checking number of student obejcts created 
    System.out.print("Number of Students Before:  ");
    System.out.println(Student.TotalStudents);
    System.out.print("Total number after creating one object:  ");
    Student s1 =new Student();
    System.out.print(Student.TotalStudents +"\n");
    System.out.print("Total number after creating two more objects:  ");
    Student s2 =new Student();
    Student s3=new Student();
     System.out.println(Student.TotalStudents);
  }
    static class Student{
    private int StudentId;
    private String Name;
    private double GPA;
    private String Course;
    static int TotalStudents =0;
    public Student(int StudentId,String Name,double GPA, String Course){//Constructor to intialise all datasets of the student
        this.StudentId =StudentId;//intialise Student ID 
        this.Course =Course;//initalise Course
        this.GPA =GPA;//initalise GPA
        this.Name=Name;//Initialise Name
        TotalStudents++;  //increase total student count
    }
    public Student(){//default constructor when no parameters are passed.
        //default data of a student
        StudentId =0;
        GPA =0;
        Name = "Unknown";
        Course ="Not assigned";
        TotalStudents++; //increases count of total student
    }
    public void DisplayInfo(){//method to print the students information
        System.out.println("Student Id: " +StudentId + " Name: " + Name + " GPA: " + GPA + " Course: " + Course );
    }
    //getter methods 
    public int getStudentID(){         //access to student ID
        return StudentId;
    }
    
    public String getName(){         //accessing Name
        return Name;
    }

    public double getGPA(){          //accessing GPA
        return GPA;
    }

    public String getCourse(){      //accessing Course of Student
        return Course;
    }
    //setter methods
    public void  setStudentID(int StudentId){         //setter method to change student id of a student
           this.StudentId =StudentId;
    }
    public void updateGPA( double GPA){         //setter method to change gpa with an evaluation check in the starting
            if(GPA >0.0 & GPA < 4.0){         //condtion check evaluated first before updating gpa
                this.GPA =GPA;
            };
    }
    public void getScholarshipStatus(double GPA ){         // Checking a Students Scholarship Status
        if( GPA>= 3.5){
            System.out.println("Eligible");          //prints eligible if gpa is greater than 3.5
        }else{
            System.out.println("Ineligible");
        }
    }
    public void  setCourse(String Course){             //setter method to change course
        this.Course = Course;
    }
    public void setName(String Name){                  //setter method to change name of student
        this.Name =Name;
    }
    public int getTotalStudents(){  //returns total number of student objects created
        return TotalStudents;
    }
    }
}