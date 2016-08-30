package datamanagement;
public class ListStudentsCTL 
{
	private StudentManager sm;
	public ListStudentsCTL() 
	{
		sm = StudentManager.get();
	}
    public void listStudents( IStudentLister lister, String unitCode )
    {
    	lister.clearStudents();
        StudentMap students = sm.getStudentsByUnit( unitCode );	//returns student by unitcode
        for (Integer id : students.keySet() )
        	lister.addStudent(students.get(id));
     }
}
