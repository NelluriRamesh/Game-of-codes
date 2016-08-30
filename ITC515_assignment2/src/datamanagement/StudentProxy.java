
package datamanagement;

public class StudentProxy implements IStudent 
{
	// All data field are private members.
	private Integer Id;				// Student ID.
	private String firstName;		// Student's first name.
   	private String lastName;		// Student's last name.
   	private StudentManager manager; // Student manager.
   	
   	/**
   	 * StudentProxy constructor initialize the the student object.
   	 * @param id	Student ID.
   	 * @param fn	Student's first name.
   	 * @param Il	Student's last name.
   	 * Current object called the student manager's get() method to get manager object. 
   	 */
   	public StudentProxy ( Integer id, String fn, String Il )
   	{
        this.Id = id;
        this.firstName = fn;
       	this.lastName = Il;
       	this.manager = StudentManager.get();
    }

   	/**
   	 * @return Id	Return the student ID.
   	 */
   	public Integer getID ()
   	{ 
   		return Id; 
   	}
    
   	// Return the student's first name as a string.
   	public String getFirstName () 
    { 
        return firstName;
    }

   	// Return the last name of the student as a string
   	public String getLastName () 
    { 
	   	return lastName; 
   	}

   	/**
   	 *  Set the first name of the student.
   	 *  @param fistName	first name of the student.
   	 *  Get the student id and called the setFirstName method of the Student class.	
   	 */
    public void setFirstName ( String firstName ) 
    {	
   		manager.getStudent(Id).setFirstName(firstName);
    }
    
    /**
   	 *  Set the last name of the student.
   	 *  @param lastName	last name of the student.
   	 *  Get the student id and called the setLastName method of the Student class.	
   	 */
    public void setLastName ( String lastName ) 
   	{
        manager.getStudent(Id).setLastName(lastName);
    }
    
    // Add the student unit record by calling Student's class method addUnitRecord.
    public void addUnitRecord ( IStudentUnitRecord record )
    {
       manager.getStudent(Id).addUnitRecord(record);
   	}
    
    // Return the unit record of the student by calling getUnitRecord of Student class method.
    public IStudentUnitRecord getUnitRecord ( String unitCode )
    {
    	return manager.getStudent(Id).getUnitRecord(unitCode);
    }
    
    // Get the list of student's unit records.
    public StudentUnitRecordList getUnitRecords () 
    { 
    	return manager.getStudent(Id).getUnitRecords();
    }
}
