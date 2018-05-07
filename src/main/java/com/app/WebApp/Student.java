package com.app.WebApp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mainInfo")

public class Student {

	@Id
    private String id;
	private String first_name, last_name, group;
	private int math, english,ukrainian;
	
	public Student(String id,String first_name,String last_name,String group,
			int math,int english,int ukrainian)
	{
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.group = group;
		this.math = math;
		this.english = english;
		this.ukrainian = ukrainian;
	}
	
	
	public void setId(String temp)
	{
		id = temp;
	}
	
	public String getId()
	{
		return id;
	}
	
	public void setFirst_name(String temp)
	{
		first_name = temp;
	}
	
	public String getFirst_name()
	{
		return first_name;
	}
	
	public void setLast_name(String temp)
	{
		last_name = temp;
	}

	public String getLast_name()
	{
		return last_name;
	}
	
	public void setGroup(String temp)
	{
		group = temp;
	}
	
	public String getGroup()
	{
		return group;
	}
	
	public void setMath(int temp)
	{
		math = temp;
	}
	
	public int getMath()
	{
		return math;
	}
	
	public void setEnglish(int temp)
	{
		english = temp;
	}
	
	public int getEnglish()
	{
		return english;
	}
	
	public void setUkrainian(int temp)
	{
		ukrainian = temp;
	}
	
	public int getUkrainian()
	{
		return ukrainian;
	}
	
	@Override
    public String toString() {
        return "{\n" +
        		'"' + "id" + '"' + ": "+id+ ",\n" +
        		'"' + "first_name" + '"' + ": "+'"'+ first_name +'"'+ ",\n" +
                '"' + "last_name" + '"' + ": "+'"'+ last_name +'"'+ ",\n" +
                '"' + "group" + '"' + ": "+'"'+ group +'"'+ ",\n" +
                '"' + "math" + '"' + ": "+math+ ",\n" +
                '"' + "english" + '"' + ": "+english+ ",\n" +
                '"' + "ukrainian" + '"' + ": "+ukrainian+ "\n" +
                '}';
    }
}
