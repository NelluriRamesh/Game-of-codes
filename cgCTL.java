package datamanagement;

public class cgCTL 
{

	cgUI CGUI;
	String cuc = null;
	Integer currentStudentID = null;
	boolean changed = false;

	public cgCTL()
	{
	
	}

	public void execute() 
	{
		CGUI = new cgUI(this);	//this is a keyword used inside the method or constructor of class
		CGUI.setState1(false);

		CGUI.setState2(false);
		CGUI.setState3(false);
		CGUI.setState4(false);
		CGUI.setState5(false);
		CGUI.setState6(false);
		CGUI.Refresh3();

		ListUnitsCTL luCTL = new ListUnitsCTL();
		luCTL.listUnits(CGUI);
		CGUI.setVisible(true);
		CGUI.setState1(true);
	}

	public void unitSelected(String code) 	// subject code selection
	{

		if (code.equals("NONE"))
			CGUI.setState2(false);
		else 
		{
			ListStudentsCTL lsCTL = new ListStudentsCTL();
			lsCTL.listStudents(CGUI, code);
			cuc = code;
			CGUI.setState2(true);
		}
		
		CGUI.setState3(false);
	}

	public void studentSelected(Integer id) 	//student id selection 
	{
		currentStudentID = id;
		if (currentStudentID.intValue() == 0) 
		{
			CGUI.Refresh3();
			CGUI.setState3(false);
			CGUI.setState4(false);
			CGUI.setState5(false);
			CGUI.setState6(false);
		}

		else 
		{
		
			IStudent s = StudentManager.get().getStudent(id);	//return student id

			IStudentUnitRecord r = s.getUnitRecord(cuc);	//return unit record

			CGUI.setRecord(r);
			CGUI.setState3(true);
			CGUI.setState4(true);
			CGUI.setState5(false);
			CGUI.setState6(false);
			changed = false;

		}
	}

	public String checkGrade(float f, float g, float h) //check grade
	{
		IUnit u = UnitManager.UM().getUnit(cuc);	//return unit
		String s = u.getGrade(f, g, h);	//return grade
		CGUI.setState4(true);
		CGUI.setState5(false);
		if (changed) 
		{
			CGUI.setState6(true);
		}
		return s;
	}

	public void enableChangeMarks() //it enables to change marks maually
	{
		CGUI.setState4(false);
		CGUI.setState6(false);
		CGUI.setState5(true);
		changed = true;
	}

	public void saveGrade(float asg1, float asg2, float exam) //to save the grade
	{

		IUnit u = UnitManager.UM().getUnit(cuc);	//return unit
		IStudent s = StudentManager.get().getStudent(currentStudentID);	//return current student by id

		IStudentUnitRecord r = s.getUnitRecord(cuc);	//return unit record
		r.setAsg1(asg1);	//set assignment 1
		r.setAsg2(asg2);	// set assignment 2
		r.setExam(exam);	// set exam
		StudentUnitRecordManager.instance().saveRecord(r);	// save record
		CGUI.setState4(true);
		CGUI.setState5(false);
		CGUI.setState6(false);
	}
}
