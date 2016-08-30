package datamanagement;

import org.jdom.*;
import java.util.List;

public class StudentManager
{
    private static StudentManager self = null;    		// Initialized the Student manager as a null.
    private StudentMap sm;								// Declare the StudentMap instance variable. 
    private java.util.HashMap<String, StudentMap> um;	// Declared the Hash map variable. 
    
    // Return the value of self variable, if self is null then it create the StudentManger object. 
    public static StudentManager get()
    {
        if (self == null) 
        	self = new StudentManager (); 	
        return self;
    }
    
    // Default constructor, initialized the variables. 
    private StudentManager ()
    {
        sm = new StudentMap();				// Create the StudentMap object.
        um = new java.util.HashMap<>();		// Create the HashMap object.
    }
    
    /**
     * getStudent() method return the Student object, if it is null then it will
     * create the student object by calling createStudent method and passed the
     * id of the student.
     * 
     * @param id	id of the student.
     * @return		student object.
     */
    public IStudent getStudent(Integer id)
    {
    	IStudent is = sm.get(id);
    	return is != null ? is : createStudent(id); 
    }

    /**
     * Return the list of the student, return null if it is null. 
     * 
     * @param id	student id.
     * @return		list of student.
     */
    private Element getStudentElement(Integer id)
    {
    	// loop continues until the last student in XML file.  
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentTable").getChildren("student")) 
            if (id.toString().equals(el.getAttributeValue("sid")))	// Compare student id with id stored in XML file. 
            		return el;										
        return null;
    }
    
    /**
     * Return the student object, otherwise throw the RuntimeException.
     * 
     * @param id	Student id.
     * @return		Student object.
     * @throws	RuntimeException	If student is not in file.
     */
    private IStudent createStudent(Integer id)
    {
        IStudent is;
        Element el = getStudentElement(id);		// Get the elements of the student.
        
       
        // If element is not null then create the student object and put into the StudentMap.  
        if (el != null)	
        {
            StudentUnitRecordList rlist = StudentUnitRecordManager.instance().getRecordsByStudent(id);
            is = new Student(new Integer(el.getAttributeValue("sid")),el.getAttributeValue("fname"),el.getAttributeValue("lname"),rlist);
            sm.put(is.getID(), is);
            return is;
        }
        throw new RuntimeException("DBMD: createStudent : student not in file");
    }
    
    /**
     * Return the StudentProxy object.
     * 
     * @param id	Student id.
     * @return		StudentProxy object.
     * @throws	RuntimeException	If student is not found in XML file.
     */
    private IStudent createStudentProxy(Integer id) 
    {
        Element el = getStudentElement(id);
        if (el != null)
        	return new StudentProxy(id, el.getAttributeValue("fname"), el.getAttributeValue("lname"));
        
        throw new RuntimeException("DBMD: createStudent : student not in file");
    }
    
    /**
     * Return the StudentMap, if it is null then create it and return.
     *  
     * @param uc	Unitcode.
     * @return		StudentMap.
     */
    public StudentMap getStudentsByUnit(String uc)
    {
        StudentMap s = um.get(uc);
        if (s != null) 
        {
        	return s;
        }

        s = new StudentMap();
        IStudent is;
        StudentUnitRecordList ur = StudentUnitRecordManager.instance().getRecordsByUnit(uc);
        for (IStudentUnitRecord S : ur) 
        {
        	is = createStudentProxy(new Integer(S.getStudentID()));
        	s.put(is.getID(), is);
        }
        um.put( uc, s);
        return s;
    }
}
