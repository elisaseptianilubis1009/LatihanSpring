package com.springboot.elisa.controller;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.elisa.model.Employee;
import com.springboot.elisa.model.Position;
import com.springboot.elisa.repository.EmployeeRepository;
import com.springboot.elisa.repository.PositionRepository;

@RestController
@RequestMapping ("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private PositionRepository positionRepository;
	
	@RequestMapping (value="/employee", method = RequestMethod.GET)
	public List<Employee> daftarEmployee() {
		return employeeRepository.findAll();
	}

	@RequestMapping (value="/position", method = RequestMethod.GET)
	public List<Position> daftarPosition() {
		return positionRepository.findAll();
	}
	
	@RequestMapping(value="/employee/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteEmployee(@PathVariable ("id")Long id) {
		employeeRepository.deleteById(id);
	}
	
	@RequestMapping (value="/employee", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void  insertEmployeeBaru(@RequestBody @Valid Employee m) {
		employeeRepository.save(m);
	}
	
	@RequestMapping (value="/employee/tampil/{id}", method = RequestMethod.GET)
	public Optional<Employee> findById (@PathVariable Long id) {
		return employeeRepository.findById(id);
	}
	
	public void update (@PathVariable Long id, @ RequestBody Employee employee) {
		Optional<Employee> em= employeeRepository.findById(id);
		if(em == null) {
			throw new IllegalStateException("No Employe with ID " +id);
		}
		 employee.setID(id);
		 employeeRepository.save(employee);
	}

}
