package datamanagement;
public class UnitProxy implements IUnit {
	private String UC; // Unit code
	private String un; // Unit Name
	UnitManager   um;
	
    public UnitProxy( String unitCode, String unitName ) {
        this.UC = unitCode;
        this.un = unitName;
        um = UnitManager.UM();
    }
    
    public String getUnitCode() { // return the Unit Code
        return this.UC;
    }
    
    public String getUnitName() { // return the Unit Name
        return this.un; 
    }
    
    public void setPsCutOff1(float cutOff) { // set the Pass mark
        um.getUnit(UC).setPsCutOff1(cutOff);
	}
    
	public float getPsCutOff() { // return the Pass mark
	    return um.getUnit(UC).getPsCutOff();
	}
	
    public void setCrCutOff(float cutOff) { // set the Credit mark
    	um.getUnit(UC).setCrCutOff(cutOff);
    }
    
	public float getCrCutOff() { // return the Credit mark
		return um.getUnit(UC).getCrCutOff();
	}
	
	public void setDiCutOff(float cutOff) { // set the Distinction mark
		um.getUnit(UC).setDiCutOff(cutOff);
	}
	
	public float getDiCuttOff() { // return the Distinction mark
		return um.getUnit(UC).getDiCuttOff();
	}
	
	public void setHdCutOff(float cutOff) { // set the High Distinction mark
	    um.getUnit(UC).setHdCutOff(cutOff);
	}
	
	public float getHdCutOff() { // return the High Distinction mark
	    return um.getUnit(UC).getHdCutOff();
	}
	
	public void setAeCutOff(float cutOff) { // set the marginal fail mark
		um.getUnit(UC).setAeCutOff(cutOff);
	}
	
	public float getAeCutOff() { // return the marginal fail mark
		return um.getUnit(UC).getAeCutOff();
	}
	
	public String getGrade(float f1, float f2, float f3) { // return three grades
		return um.getUnit(UC).getGrade(f1, f2, f3);
	}
	
	public void addStudentRecord(IStudentUnitRecord record) { // add a new student record
		um.getUnit(UC).addStudentRecord(record);
	}
	
	public IStudentUnitRecord getStudentRecord(int s) { // check if the record is a student
		return um.getUnit(UC).getStudentRecord(s);
	}
	
	public StudentUnitRecordList listStudentRecords() { // return a list of student record
	    return um.getUnit(UC).listStudentRecords();
	}
	
	public int getAsg1Weight() { // return the weight of assignment 1
		return um.getUnit(UC).getAsg1Weight();
	}
	
	public int getAsg2Weight() { // return the weight of assignment 2
		return um.getUnit(UC).getAsg2Weight();
	}
	
	public int getExamWeight() { // return the weight of the exam
		return um.getUnit(UC).getExamWeight();
	}
	
	public void setAssessmentWeights(int asg1Wgt, int asg2Wgt, int examWgt) { // set the mark for assignment 1,2 and the exam
		um.getUnit(UC).setAssessmentWeights(asg1Wgt, asg2Wgt, examWgt);
		
	}
}
