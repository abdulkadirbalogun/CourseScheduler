/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3232 modeling language!*/


import java.util.*;

// line 8 "model.ump"
// line 73 "model.ump"
public class Admin
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Admin Attributes
  private String adminNum;
  private String password;

  //Admin Associations
  private List<Course> courses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Admin(String aAdminNum, String aPassword)
  {
    adminNum = aAdminNum;
    password = aPassword;
    courses = new ArrayList<Course>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAdminNum(String aAdminNum)
  {
    boolean wasSet = false;
    adminNum = aAdminNum;
    wasSet = true;
    return wasSet;
  }

  public boolean setPassword(String aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
    wasSet = true;
    return wasSet;
  }

  public String getAdminNum()
  {
    return adminNum;
  }

  public String getPassword()
  {
    return password;
  }

  public Course getCourse(int index)
  {
    Course aCourse = courses.get(index);
    return aCourse;
  }

  public List<Course> getCourses()
  {
    List<Course> newCourses = Collections.unmodifiableList(courses);
    return newCourses;
  }

  public int numberOfCourses()
  {
    int number = courses.size();
    return number;
  }

  public boolean hasCourses()
  {
    boolean has = courses.size() > 0;
    return has;
  }

  public int indexOfCourse(Course aCourse)
  {
    int index = courses.indexOf(aCourse);
    return index;
  }

  public static int minimumNumberOfCourses()
  {
    return 0;
  }

  public Course addCourse(String aName, String aCode)
  {
    return new Course(aName, aCode, this);
  }

  public boolean addCourse(Course aCourse)
  {
    boolean wasAdded = false;
    if (courses.contains(aCourse)) { return false; }
    Admin existingAdmin = aCourse.getAdmin();
    boolean isNewAdmin = existingAdmin != null && !this.equals(existingAdmin);
    if (isNewAdmin)
    {
      aCourse.setAdmin(this);
    }
    else
    {
      courses.add(aCourse);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCourse(Course aCourse)
  {
    boolean wasRemoved = false;
    //Unable to remove aCourse, as it must always have a admin
    if (!this.equals(aCourse.getAdmin()))
    {
      courses.remove(aCourse);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addCourseAt(Course aCourse, int index)
  {  
    boolean wasAdded = false;
    if(addCourse(aCourse))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCourses()) { index = numberOfCourses() - 1; }
      courses.remove(aCourse);
      courses.add(index, aCourse);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCourseAt(Course aCourse, int index)
  {
    boolean wasAdded = false;
    if(courses.contains(aCourse))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCourses()) { index = numberOfCourses() - 1; }
      courses.remove(aCourse);
      courses.add(index, aCourse);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCourseAt(aCourse, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=courses.size(); i > 0; i--)
    {
      Course aCourse = courses.get(i - 1);
      aCourse.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "adminNum" + ":" + getAdminNum()+ "," +
            "password" + ":" + getPassword()+ "]"
     + outputString;
    
    
  }
}