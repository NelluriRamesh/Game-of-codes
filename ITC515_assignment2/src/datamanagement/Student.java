/**
 * This class is implemented IStudent interface which has a getter and mutators
 * of student's properties. Student class has following properties: student ID,
 * First name and last name, list of student unit records.
 * 
 * All above mentioned instance variables are private field of this class. So
 * that class have getters and mutators for each and every properties of student.
 * 
 */

package datamanagement;

// Class implements the IStudent interface.
public class Student implements IStudent
{
	// All fields are private members.
	private Integer id;   				// Student ID
	private String fn;					// First name of the student
    private String ln;					// Last name of the student
    private StudentUnitRecordList su;	// List of student unit records

    /*
     * Student constructor has a four argument of student's states.
     * @param id  id is the student ID
     * @param fn  fn is the first name of the student
     * @param ln  ln is the last name of the student
     * @param su  su is the list of the student unit records
     */
    public Student ( Integer id, String fn, String ln, StudentUnitRecordList su )
    {
    	this.id = id;
    	this.fn = fn;
        this.ln = ln;
        this.su = su == null ? new StudentUnitRecordList() : su;
    }

    // Return the student ID as integer.
    public Integer getID ()
    { 
    	return this.id; 
    }
    
    // Return the student's first name as a String.
    public String getFirstName ()
    { 
    	return fn;
    }
    
    /**
     * Set the student's first name.
     * @param firstName		firstName of the student.
     */
    public void setFirstName ( String firstName )
    { 
    	this.fn = firstName;
    }

    // Return the student's last name as a string.
    public String getLastName ()
    { 
    	return ln;
    }
    
    /**
     * Set the student's last name.
     * @param lastName		lastName of the student.
     */
    public void setLastName ( String lastName )
    {  
    	this.ln = lastName;
    }

    /**
     * Add the unit record for particular student.
     * @param record	record of the student.
     */
    public void addUnitRecord ( IStudentUnitRecord record )
    { 
    	su.add(record);
    }
    
    // Return the student's unit record and passed unitcode as an argument. 
    public IStudentUnitRecord getUnitRecord ( String unitCode )
    {	
    	for ( IStudentUnitRecord r : su ) 			 
            if ( r.getUnitCode().equals(unitCode)) // Return true if unitcode as same content of current student's unitcode.
            	return r; 

    	return null;    // if not match found then return null.
    }

    // Return the list of student unit records
    public StudentUnitRecordList getUnitRecords()
    { 
    	return su;
    }
}
