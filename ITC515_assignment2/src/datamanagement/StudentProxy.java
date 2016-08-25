Skip to content
This repository
Search
Pull requests
Issues
Gist
 @BarisPro
 Unwatch 3
  Star 0
  Fork 2 NelluriRamesh/Game-of-codes
 Code  Issues 0  Pull requests 2  Wiki  Pulse  Graphs
Tree: 2911013d31 Find file Copy pathGame-of-codes/ITC515_assignment2/src/datamanagement/StudentProxy.java
6e4a168  9 hours ago
 Nikul More updated
1 contributor
RawBlameHistory     59 lines (47 sloc)  1.26 KB

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