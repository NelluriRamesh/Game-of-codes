package datamanagement;

public class Unit implements IUnit {
	private String uc; // Unit Code
	private String UN; // Unit Name
	private float co1;
	private float co2;
	private float co3;
	private float co4;
	private float co5;
	private int a1, a2, ex;
	
	private StudentUnitRecordList rs;

	public Unit(String UC, String un, float f1, float f2, float f3, float f4,
			float f5, int i1, int i2, int i3, StudentUnitRecordList rl) {

		uc = UC; // Unit code
		UN = un; // Unit Name
		co2 = f1;  
		co1 = f2;
		this.co4 = f3;
		co3 = f4;
		this.co5 = f5;
		this.setAssessmentWeights(i1, i2, i3);
		rs = rl == null ? new StudentUnitRecordList() : rl;
	}

	public String getUnitCode() { // return the Unit Code
		return this.uc;
	}

	public String getUnitName() { // return the Unit Name

		return this.UN;
	}

	public void setPsCutOff(float cutOff) { // set the Pass mark
		this.co2 = cutOff;
	}

	public float getPsCutOff() { // return the Pass mark
		return this.co2;
	}

	public void setCrCutOff(float cutOff) { // set the Credit mark
		this.co1 = cutOff;
	}

	public float getCrCutOff() { // return the Credit mark
		return this.co1;
	}

	public void setDiCutOff(float cutOff) { // set the Distinction mark
		this.co4 = cutOff;
	}

	public float getDiCuttOff() { // return the Distinction mark
		return this.co4;
	}

	public void getHDCutOff(float cutOff) { // set the High Distinction mark
		this.co3 = cutOff;
	}

	public void setHdCutOff(float cutOff) { // set the High Distinction mark
		this.co3 = cutOff;
	}

	public float getHdCutOff() { // return the High Distinction mark
		return this.co3;

	}

	public void setAeCutOff(float cutOff) { // set the marginal fail mark
		this.co5 = cutOff;
	}

	public float getAeCutOff() { // return the marginal fail mark
		return this.co5;
	}

	public void addStudentRecord(IStudentUnitRecord record) { // add a new student record
		rs.add(record);
	}

	public IStudentUnitRecord getStudentRecord(int studentID) { // check if the record is a student
		for (IStudentUnitRecord r : rs) {
			if (r.getStudentID() == studentID)
				return r;
		}
		return null;
	}

	public StudentUnitRecordList listStudentRecords() { // return a list of student
		return rs;
	}

	@Override
	public int getAsg1Weight() { // return assignment 1 weight
		return a1;
	}

	@Override
	public int getAsg2Weight() { // return assignment 2 weight
		return a2;
	}

	@Override
	public int getExamWeight() { // return exam weight
		return ex;
	}

	@Override
	public void setAssessmentWeights(int a1, int a2, int ex) {
		if (a1 < 0 || a1 > 100 ||
			a2 < 0 || a2 > 100 ||
			ex < 0 || ex > 100 ) {
			throw new RuntimeException("Assessment weights cant be less than zero or greater than 100");
		}			
		if (a1 + a2 + ex != 100) {
			throw new RuntimeException("Assessment weights must add to 100");
		}
		this.a1 = a1;
		this.a2 = a2;
		this.ex = ex;			
	}
	
	private void setCutOffs( float ps, float cr, float di, float hd, float ae) { // Never used locally
		if (ps < 0 || ps > 100 ||
			cr < 0 || cr > 100 ||
			di < 0 || di > 100 ||
			hd < 0 || hd > 100 ||
			ae < 0 || ae > 100 ) {
			throw new RuntimeException("Assessment cutoffs cant be less than zero or greater than 100");
		}
		if (ae >= ps) {
			throw new RuntimeException("AE cutoff must be less than PS cutoff");
		}
		if (ps >= cr) {
			throw new RuntimeException("PS cutoff must be less than CR cutoff");
		}
		if (cr >= di) {
			throw new RuntimeException("CR cutoff must be less than DI cutoff");
		}
		if (di >= hd) {
			throw new RuntimeException("DI cutoff must be less than HD cutoff");
		}
	}
	
	public String getGrade(float f1, float f2, float f3) {
		float t = f1 + f2 + f3;
		
		if (f1 < 0 || f1 > a1 ||
			f2 < 0 || f2 > a2 ||
			f3 < 0 || f3 > ex ) {
			throw new RuntimeException("marks cannot be less than zero or greater than assessment weights");
		} //Check if the marks are in the boundary limit

		if (t < co5) {
			return "FL"; // Fail
		} else if (t < co2)
			return "AE"; // Marginal fail
		else if (t < co1)
			return "PS"; // Pass
		else if (t < co4)
			return "CR"; // Credit
		else if (t < co3)
			return "DI"; // Distinction
		else
			return "HD"; // High Distinction
	}

	
}
