package com.employee.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

import org.springframework.ui.Model;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
/*	@GetMapping("/")
    public String viewHomepage(Model model) {
        return findPaginated(1, model);
    }
	 @GetMapping("/index")
	    public String index(Model model) {
	        model.addAttribute("listEmployee", employeeService.getAllEmployees());
	        return "index";
	    }*/
	
	@GetMapping("/z")
	public String viewHomepage(Model model) {
		 model.addAttribute("listEmployee", employeeService.getAllEmployees());
	return "index"; 
	}
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		return "newEmployee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
	    employeeService.saveEmployee(employee);
	    return "redirect:/";
	}
	 @GetMapping("/showForUpdate/{id}")
	    public String showForUpdate(@PathVariable("id") long id, Model model) {
	        Employee employee = employeeService.getEmployeeById(id);
	        if (employee == null) {
	            // Handle case where employee with given ID was not found
	            return "redirect:/";
	        }
	        model.addAttribute("employee", employee);
	        return "update_employee";
	    }
	
	 
	 
	 @GetMapping("/deleteEmployee/{id}")
	 public String deleteEmployee(@PathVariable("id") long id) {
		 //call delete 
		 this.employeeService.deleteEmployeeById(id);
		 return "redirect:/";
	 }
	 @GetMapping("/page/{pageNo}")
	 public String findPaginated(@PathVariable(value = "pageNo")int pageNo,Model model) {
		 int pageSize =5;
		 Page<Employee> page = employeeService.findPagination(pageNo, pageSize);
		 List<Employee> listEmployees = page.getContent();
		 model.addAttribute("currentPage",pageNo);
		 model.addAttribute("totalPage",page.getTotalPages());
		 model.addAttribute("totalItem",page.getTotalElements());
		 model.addAttribute("listEmployee",listEmployees);
		 return "index"; 
	 }
	 
}
