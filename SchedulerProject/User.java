/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3232 modeling language!*/


import java.util.*;

// line 1 "model.ump"
// line 79 "model.ump"
public class User
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //User Attributes
  private String username;
  private String password;

  //User Associations
  private List<Course> courses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public User(String aUsername, String aPassword)
  {
    username = aUsername;
    password = aPassword;
    courses = new ArrayList<Course>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setUsername(String aUsername)
  {
    boolean wasSet = false;
    username = aUsername;
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

  public String getUsername()
  {
    return username;
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

  public boolean addCourse(Course aCourse)
  {
    boolean wasAdded = false;
    if (courses.contains(aCourse)) { return false; }
    courses.add(aCourse);
    if (aCourse.indexOfUser(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aCourse.addUser(this);
      if (!wasAdded)
      {
        courses.remove(aCourse);
      }
    }
    return wasAdded;
  }

  public boolean removeCourse(Course aCourse)
  {
    boolean wasRemoved = false;
    if (!courses.contains(aCourse))
    {
      return wasRemoved;
    }

    int oldIndex = courses.indexOf(aCourse);
    courses.remove(oldIndex);
    if (aCourse.indexOfUser(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aCourse.removeUser(this);
      if (!wasRemoved)
      {
        courses.add(oldIndex,aCourse);
      }
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
    ArrayList<Course> copyOfCourses = new ArrayList<Course>(courses);
    courses.clear();
    for(Course aCourse : copyOfCourses)
    {
      aCourse.removeUser(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "username" + ":" + getUsername()+ "," +
            "password" + ":" + getPassword()+ "]"
     + outputString;
  }
}