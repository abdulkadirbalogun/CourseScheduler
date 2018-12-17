/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3232 modeling language!*/


import java.util.*;

// line 26 "model.ump"
// line 68 "model.ump"
public class Update
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Update Attributes
  private String type;
  private String description;

  //Update Associations
  private List<Course> courses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Update(String aType, String aDescription)
  {
    type = aType;
    description = aDescription;
    courses = new ArrayList<Course>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setType(String aType)
  {
    boolean wasSet = false;
    type = aType;
    wasSet = true;
    return wasSet;
  }

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public String getType()
  {
    return type;
  }

  public String getDescription()
  {
    return description;
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
    if (aCourse.indexOfUpdate(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aCourse.addUpdate(this);
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
    if (aCourse.indexOfUpdate(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aCourse.removeUpdate(this);
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
      aCourse.removeUpdate(this);
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "type" + ":" + getType()+ "," +
            "description" + ":" + getDescription()+ "]"
     + outputString;
  }
}