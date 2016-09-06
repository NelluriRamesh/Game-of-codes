package datamanagement;
public class ListUnitsCTL 
{
    private UnitManager um;
    public ListUnitsCTL() 
    {
        um = UnitManager.UM();
    }
    public void listUnits( IUnitLister lister )
    {
    	lister.clearUnits();//clears units
    	UnitMap units = um.getUnits();//returns units
        for (String s : units.keySet() )
        lister.addUnit(units.get(s));//adds units
     }
}
