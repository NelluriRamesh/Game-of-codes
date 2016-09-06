package datamanagement;
import java.util.*;
import java.io.*;
public class AppProperties 
{
	private static AppProperties self = null;
	private Properties properties;

	public static AppProperties getInstance() //instance of the class(singleton class)
	{
		if (self == null ) 
		{ 
			self = new AppProperties();
		}
		return self;
	}
	
	private AppProperties() 
	{
		properties = new Properties();	//properties object that has no default values
		try
		{
			properties.load(new FileInputStream("Properties.prop"));	//read from file
		} 
		catch (IOException e) 
		{
			throw new RuntimeException("Could not read property file");
		}
	}
    public Properties getProperties()	//returns properties
    {
    	return properties;
    }
 }
