
public class TestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//The main method contains the several cases in which the system can be operated 
		
		//  Create Administrators For The System
			 Admin mike =  new Admin("mike001", "passkey1");
			 Admin gavin =  new Admin("gavin002","passkey2");
			 Admin kareem = new Admin("kareem003","passkey3");
			 Admin ryan =  new Admin("ryan004","passkey4");
			 Admin yang =  new Admin("yang005", "passkey5");
			 
		//Courses Available
			 Course Programming1 = new Course("Software Eng","Seg2015", gavin);
			 Course Mathematics = new Course("Calculus I", "Math1339", mike);
			 Course Computing1 = new Course("Intro To Computing I", "ITI1120", kareem);
			 Course Computing2 = new Course("Intro To Computing II ", "ITI1121",ryan);
			 Course CircuitTheory = new Course("CircuitTheory1","Elg213",yang);
			 
		 //Creating Users
			 User sam = new User("sam92","passwords1");
			 User keller = new User("keller02","passwords2");
			 User jimmy = new User("jimmy98","passwords3");
			 User kim = new User("kim982","passwords4");
			 
			 
		//Administrators adding courses 
			 mike.addCourse(Mathematics);
			 gavin.addCourse(Programming1);
			 kareem.addCourseAt(Computing1, 1);
			 ryan.addCourse(Computing2);
			 yang.addCourse(CircuitTheory);
			 
		//Users adding courses: Courses Sam registered for are -
			 sam.addCourse(CircuitTheory);
			 sam.addCourse(Mathematics);
			 sam.addCourse(Computing1);
		
		//Users adding courses: Courses Keller registered for are -
			 keller.addCourse(Mathematics);
			 keller.addCourse(CircuitTheory);
			 keller.addCourse(Programming1);
	   
	   //Users adding courses: Courses Jimmy registerd for are-
			 jimmy.addCourse(Mathematics);
			 jimmy.addCourse(Computing1);
			 jimmy.addCourse(CircuitTheory);
			 jimmy.addCourse(Programming1);
	   
	  //Users adding courses: Courses Jimmy registerd for are-
			 kim.addCourse(Mathematics);
			 kim.addCourse(Computing1);
			 kim.addCourse(CircuitTheory);
			 kim.addCourse(Programming1);
	   
		
			 
		// Lessons available for various courses
			 
			 Lesson segLecture = new Lesson("lecture",212,1, "8:30am","10:00am",Programming1);
			 Lesson calcLecture = new Lesson("lecture",109,4, "10:00am","11:30am",Mathematics);
			 Lesson itiLecture = new Lesson("lecture",214,2, "1:00pm","2:30pm",Computing1);
			 Lesson iti2Lecture = new Lesson("lecture",012,3, "7:00pm","8:30pm",Computing2);
			 
			 Lesson itiLab = new Lesson("lab",132,2,"4:00pm","7:00pm",Computing1);
			 Lesson segLab = new Lesson("lab",132,1,"1:00pm","4:00pm",Programming1);
			 Lesson iti2Lab = new Lesson("lab",134,3,"1:00pm","5:00pm",Computing2);
			 Lesson elgLecture = new Lesson("Lecture",017,5,"1:00pm", "2;30pm", CircuitTheory);
			 Lesson elgLab = new Lesson("lab",302,4, "7:00pm","10:00pm", CircuitTheory);
			 

		//Task for the courses
			 
			 Task taskForSeg = new Task("Assignment"," 13/11/13","Solve the problems in the textbook", Programming1);
			 Task taskForIti = new Task("Assignment","01/11/13","Write a program of your choice",Computing1);
			 Task taskForElg = new Task("Assignment","21/11/13","Solve problem 10.1-11.1 of the text",CircuitTheory);
			 Task taskForCalc = new Task("Assignment","30/11/13","revise all chapters for class quiz",Mathematics);
			 
		//Adding the task to the courses
			 Programming1.addLesson(segLab);
			 Programming1.addLesson(segLecture);
			 Mathematics.addLesson(calcLecture);
			 Computing1.addLesson(itiLecture);
			 Computing1.addLesson(itiLab);
			 Computing2.addLesson(iti2Lecture);
			 Computing2.addLesson(iti2Lab);
			 CircuitTheory.addLesson(elgLecture);
			 CircuitTheory.addLesson(elgLab);
			 
			 
		// Adding Tasks to the Courses
			 Programming1.addTask(taskForSeg);
			 Computing1.addTask(taskForIti);
			 CircuitTheory.addTask(taskForElg);
			 Mathematics.addTask(taskForCalc);
			 
			 
			 
		//Creating Updates For Courses
			 Update updateCalc = new Update("UpdatesOnLecture","The calculus class has been cancelled");
			 Update updateForIti = new Update("UpdatesOnAssignment1","Submit only your codes");
			 Update updateForElg = new Update("UpdatesOnLab2","Lab 2 has been rescheduled");
					
		//Adding new updates
			 Mathematics.addUpdate(updateCalc);
			 Computing1.addUpdate(updateForIti);
			 CircuitTheory.addUpdate(updateForElg);
		
		
		//System.out.println(ryan.toString());
		
		System.out.print(Mathematics.getLessons());
		System.out.print(CircuitTheory.getLessons());
		System.out.print(Computing1.getLessons());
		
		
		
					
			 
			 
			 
			 


	}

}
