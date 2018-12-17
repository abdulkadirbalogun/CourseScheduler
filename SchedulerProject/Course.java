/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3232 modeling language!*/


import java.util.*;

// line 16 "model.ump"
// line 50 "model.ump"
public class Course
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Course Attributes
  private String name;
  private String code;

  //Course Associations
  private List<Lesson> lessons;
  private List<Task> tasks;
  private List<Update> updates;
  private List<User> users;
  private Admin admin;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Course(String aName, String aCode, Admin aAdmin)
  {
    name = aName;
    code = aCode;
    lessons = new ArrayList<Lesson>();
    tasks = new ArrayList<Task>();
    updates = new ArrayList<Update>();
    users = new ArrayList<User>();
    boolean didAddAdmin = setAdmin(aAdmin);
    if (!didAddAdmin)
    {
      throw new RuntimeException("Unable to create course due to admin");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setCode(String aCode)
  {
    boolean wasSet = false;
    code = aCode;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getCode()
  {
    return code;
  }

  public Lesson getLesson(int index)
  {
    Lesson aLesson = lessons.get(index);
    return aLesson;
  }

  public List<Lesson> getLessons()
  {
    List<Lesson> newLessons = Collections.unmodifiableList(lessons);
    return newLessons;
  }

  public int numberOfLessons()
  {
    int number = lessons.size();
    return number;
  }

  public boolean hasLessons()
  {
    boolean has = lessons.size() > 0;
    return has;
  }

  public int indexOfLesson(Lesson aLesson)
  {
    int index = lessons.indexOf(aLesson);
    return index;
  }

  public Task getTask(int index)
  {
    Task aTask = tasks.get(index);
    return aTask;
  }

  public List<Task> getTasks()
  {
    List<Task> newTasks = Collections.unmodifiableList(tasks);
    return newTasks;
  }

  public int numberOfTasks()
  {
    int number = tasks.size();
    return number;
  }

  public boolean hasTasks()
  {
    boolean has = tasks.size() > 0;
    return has;
  }

  public int indexOfTask(Task aTask)
  {
    int index = tasks.indexOf(aTask);
    return index;
  }

  public Update getUpdate(int index)
  {
    Update aUpdate = updates.get(index);
    return aUpdate;
  }

  public List<Update> getUpdates()
  {
    List<Update> newUpdates = Collections.unmodifiableList(updates);
    return newUpdates;
  }

  public int numberOfUpdates()
  {
    int number = updates.size();
    return number;
  }

  public boolean hasUpdates()
  {
    boolean has = updates.size() > 0;
    return has;
  }

  public int indexOfUpdate(Update aUpdate)
  {
    int index = updates.indexOf(aUpdate);
    return index;
  }

  public User getUser(int index)
  {
    User aUser = users.get(index);
    return aUser;
  }

  public List<User> getUsers()
  {
    List<User> newUsers = Collections.unmodifiableList(users);
    return newUsers;
  }

  public int numberOfUsers()
  {
    int number = users.size();
    return number;
  }

  public boolean hasUsers()
  {
    boolean has = users.size() > 0;
    return has;
  }

  public int indexOfUser(User aUser)
  {
    int index = users.indexOf(aUser);
    return index;
  }

  public Admin getAdmin()
  {
    return admin;
  }

  public static int minimumNumberOfLessons()
  {
    return 0;
  }

  public Lesson addLesson(String aType, int aRoom, int aDay, String aStartTime, String aEndTime)
  {
    return new Lesson(aType, aRoom, aDay, aStartTime, aEndTime, this);
  }

  public boolean addLesson(Lesson aLesson)
  {
    boolean wasAdded = false;
    if (lessons.contains(aLesson)) { return false; }
    Course existingCourse = aLesson.getCourse();
    boolean isNewCourse = existingCourse != null && !this.equals(existingCourse);
    if (isNewCourse)
    {
      aLesson.setCourse(this);
    }
    else
    {
      lessons.add(aLesson);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeLesson(Lesson aLesson)
  {
    boolean wasRemoved = false;
    //Unable to remove aLesson, as it must always have a course
    if (!this.equals(aLesson.getCourse()))
    {
      lessons.remove(aLesson);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addLessonAt(Lesson aLesson, int index)
  {  
    boolean wasAdded = false;
    if(addLesson(aLesson))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLessons()) { index = numberOfLessons() - 1; }
      lessons.remove(aLesson);
      lessons.add(index, aLesson);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveLessonAt(Lesson aLesson, int index)
  {
    boolean wasAdded = false;
    if(lessons.contains(aLesson))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLessons()) { index = numberOfLessons() - 1; }
      lessons.remove(aLesson);
      lessons.add(index, aLesson);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addLessonAt(aLesson, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfTasks()
  {
    return 0;
  }

  public Task addTask(String aType, String aDueDate, String aDescription)
  {
    return new Task(aType, aDueDate, aDescription, this);
  }

  public boolean addTask(Task aTask)
  {
    boolean wasAdded = false;
    if (tasks.contains(aTask)) { return false; }
    Course existingCourse = aTask.getCourse();
    boolean isNewCourse = existingCourse != null && !this.equals(existingCourse);
    if (isNewCourse)
    {
      aTask.setCourse(this);
    }
    else
    {
      tasks.add(aTask);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTask(Task aTask)
  {
    boolean wasRemoved = false;
    //Unable to remove aTask, as it must always have a course
    if (!this.equals(aTask.getCourse()))
    {
      tasks.remove(aTask);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addTaskAt(Task aTask, int index)
  {  
    boolean wasAdded = false;
    if(addTask(aTask))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTasks()) { index = numberOfTasks() - 1; }
      tasks.remove(aTask);
      tasks.add(index, aTask);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTaskAt(Task aTask, int index)
  {
    boolean wasAdded = false;
    if(tasks.contains(aTask))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTasks()) { index = numberOfTasks() - 1; }
      tasks.remove(aTask);
      tasks.add(index, aTask);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTaskAt(aTask, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfUpdates()
  {
    return 0;
  }

  public boolean addUpdate(Update aUpdate)
  {
    boolean wasAdded = false;
    if (updates.contains(aUpdate)) { return false; }
    updates.add(aUpdate);
    if (aUpdate.indexOfCourse(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aUpdate.addCourse(this);
      if (!wasAdded)
      {
        updates.remove(aUpdate);
      }
    }
    return wasAdded;
  }

  public boolean removeUpdate(Update aUpdate)
  {
    boolean wasRemoved = false;
    if (!updates.contains(aUpdate))
    {
      return wasRemoved;
    }

    int oldIndex = updates.indexOf(aUpdate);
    updates.remove(oldIndex);
    if (aUpdate.indexOfCourse(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aUpdate.removeCourse(this);
      if (!wasRemoved)
      {
        updates.add(oldIndex,aUpdate);
      }
    }
    return wasRemoved;
  }

  public boolean addUpdateAt(Update aUpdate, int index)
  {  
    boolean wasAdded = false;
    if(addUpdate(aUpdate))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUpdates()) { index = numberOfUpdates() - 1; }
      updates.remove(aUpdate);
      updates.add(index, aUpdate);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUpdateAt(Update aUpdate, int index)
  {
    boolean wasAdded = false;
    if(updates.contains(aUpdate))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUpdates()) { index = numberOfUpdates() - 1; }
      updates.remove(aUpdate);
      updates.add(index, aUpdate);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUpdateAt(aUpdate, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfUsers()
  {
    return 0;
  }

  public boolean addUser(User aUser)
  {
    boolean wasAdded = false;
    if (users.contains(aUser)) { return false; }
    users.add(aUser);
    if (aUser.indexOfCourse(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aUser.addCourse(this);
      if (!wasAdded)
      {
        users.remove(aUser);
      }
    }
    return wasAdded;
  }

  public boolean removeUser(User aUser)
  {
    boolean wasRemoved = false;
    if (!users.contains(aUser))
    {
      return wasRemoved;
    }

    int oldIndex = users.indexOf(aUser);
    users.remove(oldIndex);
    if (aUser.indexOfCourse(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aUser.removeCourse(this);
      if (!wasRemoved)
      {
        users.add(oldIndex,aUser);
      }
    }
    return wasRemoved;
  }

  public boolean addUserAt(User aUser, int index)
  {  
    boolean wasAdded = false;
    if(addUser(aUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsers()) { index = numberOfUsers() - 1; }
      users.remove(aUser);
      users.add(index, aUser);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUserAt(User aUser, int index)
  {
    boolean wasAdded = false;
    if(users.contains(aUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsers()) { index = numberOfUsers() - 1; }
      users.remove(aUser);
      users.add(index, aUser);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUserAt(aUser, index);
    }
    return wasAdded;
  }

  public boolean setAdmin(Admin aAdmin)
  {
    boolean wasSet = false;
    if (aAdmin == null)
    {
      return wasSet;
    }

    Admin existingAdmin = admin;
    admin = aAdmin;
    if (existingAdmin != null && !existingAdmin.equals(aAdmin))
    {
      existingAdmin.removeCourse(this);
    }
    admin.addCourse(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=lessons.size(); i > 0; i--)
    {
      Lesson aLesson = lessons.get(i - 1);
      aLesson.delete();
    }
    for(int i=tasks.size(); i > 0; i--)
    {
      Task aTask = tasks.get(i - 1);
      aTask.delete();
    }
    ArrayList<Update> copyOfUpdates = new ArrayList<Update>(updates);
    updates.clear();
    for(Update aUpdate : copyOfUpdates)
    {
      aUpdate.removeCourse(this);
    }
    ArrayList<User> copyOfUsers = new ArrayList<User>(users);
    users.clear();
    for(User aUser : copyOfUsers)
    {
      aUser.removeCourse(this);
    }
    Admin placeholderAdmin = admin;
    this.admin = null;
    placeholderAdmin.removeCourse(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "CourseName" + ":" + getName()+ "," +
            "CourseCode" + ":" + getCode()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "admin = "+(getAdmin()!=null?Integer.toHexString(System.identityHashCode(getAdmin())):"null")
     + outputString;
	 
	  
	  
	  /*
	  String infoString = "";
	  infoString = "[" +"CourseName:" + ":" +getName()+ "," +"CourseCode :" +getCode()+ "]"
	  +System.getProperties().getProperty("line.separator") + " " + "Administrator =" +(getAdmin())
	  */
  }
}