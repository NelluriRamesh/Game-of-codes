/**
 *  This interface has two abstract methods which clear the students details
 *  and add new student. 
 */
package datamanagement;

public interface IStudentLister
{
    public void clearStudents(); // Clear the student detail
    
    /**
     * This method add the new student and take a Istudent object as a argument.  
     * @param student student object has a student details.
     */
    public void addStudent(IStudent student); 
}
