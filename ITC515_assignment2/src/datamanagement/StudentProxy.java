
package datamanagement;

public class StudentProxy implements IStudent 
{
	private Integer Id;
	private String firstName;
    	private String lastName;
    	private StudentManager manager;

    	public StudentProxy ( Integer id, String fn, String Il )
    	{
	        this.Id = id;
        	this.firstName = fn;
        	this.lastName = Il;
        	this.manager = StudentManager.get();
    	}

    	public Integer getID ()
    	{ 
    		return Id; 
    	}
    
    	public String getFirstName () 
    	{ 
	        return firstName;
    	}

    	public String getLastName () 
    	{ 
	    	return lastName; 
    	}

    	public void setFirstName ( String firstName ) 
    	{	
    		manager.getStudent(Id).setFirstName(firstName);
    	}
    
    	public void setLastName ( String lastName ) 
    	{
	        manager.getStudent(Id).setLastName(lastName);
    	}
    
    	public void addUnitRecord ( IStudentUnitRecord record )
    	{
	        manager.getStudent(Id).addUnitRecord(record);
    	}
    
    	public IStudentUnitRecord getUnitRecord ( String unitCode )
    	{
        	return manager.getStudent(Id).getUnitRecord(unitCode);
    	}

    	public StudentUnitRecordList getUnitRecords () 
    	{ 
    		return manager.getStudent(Id).getUnitRecords();
    	}
}
