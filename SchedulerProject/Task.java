/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3232 modeling language!*/



// line 41 "model.ump"
// line 58 "model.ump"
public class Task
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Task Attributes
  private String type;
  private String dueDate;
  private String description;

  //Task Associations
  private Course course;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Task(String aType, String aDueDate, String aDescription, Course aCourse)
  {
    type = aType;
    dueDate = aDueDate;
    description = aDescription;
    boolean didAddCourse = setCourse(aCourse);
    if (!didAddCourse)
    {
      throw new RuntimeException("Unable to create task due to course");
    }
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

  public boolean setDueDate(String aDueDate)
  {
    boolean wasSet = false;
    dueDate = aDueDate;
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

  public String getDueDate()
  {
    return dueDate;
  }

  public String getDescription()
  {
    return description;
  }

  public Course getCourse()
  {
    return course;
  }

  public boolean setCourse(Course aCourse)
  {
    boolean wasSet = false;
    if (aCourse == null)
    {
      return wasSet;
    }

    Course existingCourse = course;
    course = aCourse;
    if (existingCourse != null && !existingCourse.equals(aCourse))
    {
      existingCourse.removeTask(this);
    }
    course.addTask(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Course placeholderCourse = course;
    this.course = null;
    placeholderCourse.removeTask(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "type" + ":" + getType()+ "," +
            "dueDate" + ":" + getDueDate()+ "," +
            "description" + ":" + getDescription()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "course = "+(getCourse()!=null?Integer.toHexString(System.identityHashCode(getCourse())):"null")
     + outputString;
  }
}