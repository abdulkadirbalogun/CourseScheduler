/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3232 modeling language!*/



// line 32 "model.ump"
// line 63 "model.ump"
public class Lesson
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Lesson Attributes
  private String type;
  private int room;
  private int day;
  private String startTime;
  private String endTime;

  //Lesson Associations
  private Course course;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Lesson(String aType, int aRoom, int aDay, String aStartTime, String aEndTime, Course aCourse)
  {
    type = aType;
    room = aRoom;
    day = aDay;
    startTime = aStartTime;
    endTime = aEndTime;
    boolean didAddCourse = setCourse(aCourse);
    if (!didAddCourse)
    {
      throw new RuntimeException("Unable to create lesson due to course");
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

  public boolean setRoom(int aRoom)
  {
    boolean wasSet = false;
    room = aRoom;
    wasSet = true;
    return wasSet;
  }

  public boolean setDay(int aDay)
  {
    boolean wasSet = false;
    day = aDay;
    wasSet = true;
    return wasSet;
  }

  public boolean setStartTime(String aStartTime)
  {
    boolean wasSet = false;
    startTime = aStartTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndTime(String aEndTime)
  {
    boolean wasSet = false;
    endTime = aEndTime;
    wasSet = true;
    return wasSet;
  }

  public String getType()
  {
    return type;
  }

  public int getRoom()
  {
    return room;
  }

  public int getDay()
  {
    return day;
  }

  public String getStartTime()
  {
    return startTime;
  }

  public String getEndTime()
  {
    return endTime;
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
      existingCourse.removeLesson(this);
    }
    course.addLesson(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Course placeholderCourse = course;
    this.course = null;
    placeholderCourse.removeLesson(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "type" + ":" + getType()+ "," +
            "room" + ":" + getRoom()+ "," +
            "day" + ":" + getDay()+ "," +
            "startTime" + ":" + getStartTime()+ "," +
            "endTime" + ":" + getEndTime()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "course = "+(getCourse()!=null?Integer.toHexString(System.identityHashCode(getCourse())):"null")
     + outputString;
  }
}