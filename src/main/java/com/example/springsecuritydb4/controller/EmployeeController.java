package com.example.springsecuritydb4.controller;
import com.example.springsecuritydb4.entity.Employee;
import com.example.springsecuritydb4.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        //get employee from db

        List<Employee> theEmployees = employeeService.findAll();

        // add to the spring model

        theModel.addAttribute("employees",theEmployees);
        return "/employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        // create model attribute to bind form data
        Employee theEmployee = new Employee();

        theModel.addAttribute("employee",theEmployee);

        return "/employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,Model theModel){
        //get the employee from the service
        Employee theEmployee = employeeService.findById(theId);

        //set employee as a model attribute ro pre-populate the form
        theModel.addAttribute("employee",theEmployee);
        return "/employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee")Employee theEmployee) {

        // save the employee
        employeeService.save(theEmployee);

        //use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId")int theId) {

        //delete the employee
        employeeService.deleteById(theId);

        //redirect to /employee/list
        return "redirect:/employees/list";
    }
    @GetMapping("/search")
    public String search(@RequestParam("employeeName") String theName,Model theModel){

        List<Employee> theEmployees = employeeService.searchBy(theName);

        theModel.addAttribute("employees",theEmployees);
        return "/employees/list-employees";
    }
}