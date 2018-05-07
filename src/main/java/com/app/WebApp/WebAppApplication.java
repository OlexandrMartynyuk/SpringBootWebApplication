package com.app.WebApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;


@EnableAutoConfiguration
@Controller
@SpringBootApplication
public class WebAppApplication {
	public int num =1;
	
	@Autowired
    private StudentRepository repository;

	
	public WebAppApplication()
	{
	}
	
	public static void main(String[] args) {
		SpringApplication.run(WebAppApplication.class, args);	
	}
	
	
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	@ResponseBody
	public List<Student> find()
	{
		return repository.findAll();
	}
	
	@RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Optional<Student> findOne(@PathVariable  String id)
	{
		return repository.findById(id);
	}
	
	@RequestMapping(value = "/students", method = RequestMethod.POST)
	@ResponseBody
	public String insert(@RequestParam("id") String id,@RequestParam("first_name")
	String first_name,@RequestParam("last_name") String last_name
	,@RequestParam("group") String group,@RequestParam("math") int math
	,@RequestParam("english") int english,@RequestParam("ukrainian") int ukrainian)
	{
		if(!repository.findById(id).isPresent()) {
		repository.save(new Student(id,first_name,last_name,group,math,english,ukrainian));
		return "Success";}
		else return "Error: the id is already taken";
		
	}
	
	@RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@PathVariable  String id)
	{
		if(repository.findById(id).isPresent()) {
		repository.deleteById(id);
		return "Success";}
		else return "Error: the id is wrong" + id;
	}	

	
	@RequestMapping(value = "/students", method = RequestMethod.PUT)
	@ResponseBody
	public String update(@RequestParam("id") String id,@RequestParam("first_name")
	String first_name,@RequestParam("last_name") String last_name
	,@RequestParam("group") String group,@RequestParam("math") String math
	,@RequestParam("english") String english,@RequestParam("ukrainian") String ukrainian)
	{
		if(repository.findById(id).isPresent()) {
		Student temp = repository.findById(id).get();
		if(first_name!=""&&temp.getFirst_name()!=first_name)
			temp.setFirst_name(first_name);
		if(last_name!=""&&temp.getLast_name()!=last_name)
			temp.setLast_name(last_name);
		if(group!=""&&temp.getGroup()!=group)
			temp.setGroup(group);
		if(math!=""&&temp.getMath()!=Integer.parseInt(math))
			temp.setMath(Integer.parseInt(math));
		if(english!=""&&temp.getEnglish()!=Integer.parseInt(english))
			temp.setEnglish(Integer.parseInt(english));
		if(ukrainian!=""&&temp.getUkrainian()!=Integer.parseInt(ukrainian))
			temp.setUkrainian(Integer.parseInt(ukrainian));
		repository.save(temp);
		return "Success";}
		else return "Error: the id is wrong";
		
	}
	
		
}
