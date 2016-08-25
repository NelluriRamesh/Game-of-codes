package datamanagement;

public interface IUnit {

    public String getUnitCode(); // return the Unit Code
    public String getUnitName(); // return the Unit Name

    public float getPsCutOff(); // return the Pass mark
    public void  setPsCutOff(float cutOff); // set the Pass mark

    public float getCrCutOff(); // return the Credit mark
    public void  setCrCutOff(float cutOff); // set the Credit mark

    public float getDiCuttOff(); // return the Distinction mark 
    public void  setDiCutOff(float cutOff); // set the Distinction mark

    public float getHdCutOff(); // return the High Distinction mark 
    public void  setHdCutOff(float cutOff); // set the High Distinction mark   

    public float getAeCutOff(); // return the marginal fail mark    
    public void  setAeCutOff(float cutOff); // set the marginal fail mark  
    
    public int getAsg1Weight(); // return the weight of Assignment 1  
    public int getAsg2Weight(); // return the weight of Assignment 2
    public int getExamWeight(); // return the weight of Exam 
    public void setAssessmentWeights(int asg1Wgt, int asg2Wgt, int examWgt); // set all the assignement weight

    public String getGrade(float asg1, float asg2, float exam); // return the grade of assignment 1, 2 and exam

    public void addStudentRecord(IStudentUnitRecord record ); // add a new student record
    public IStudentUnitRecord getStudentRecord(int studentID ); // return a student record
    
    public StudentUnitRecordList listStudentRecords(); // return a list of student record
}
