/* This interface declared the methods of the student properties such as
 * student id , first name and last name and unit record and list. 
 */

package datamanagement;

public interface IStudent 
{
    public Integer getID(); // Return the student id

    public String getFirstName(); // Return the student's first name
    public void setFirstName(String firstName); // Set the student's first name

    public String getLastName(); // Return the student's last name
    public void setLastName(String lastName); // Set the student's last name

    public void addUnitRecord( IStudentUnitRecord record ); // Add the unit record of particular student
    public IStudentUnitRecord getUnitRecord( String unitCode ); // Get the student's unit record

    public StudentUnitRecordList getUnitRecords(); // Return the student's unit record list

}
