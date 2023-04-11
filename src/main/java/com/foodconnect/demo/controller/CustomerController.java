package com.foodconnect.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodconnect.demo.requestdto.CustomerRequestDTO;
import com.foodconnect.demo.responsedto.CustomerResponseDTO;
import com.foodconnect.demo.service.CustomerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/save")
	public CustomerResponseDTO saveCustomer(@RequestBody CustomerRequestDTO requestDTO)
	{
		return customerService.saveCustomer(requestDTO);
	}
	
	@GetMapping("/getAll")
	public List<CustomerResponseDTO> getAllCustomer()
	{
		return customerService.getAllCustomer();
	}
	
	@GetMapping("/geById/{id}")
	public CustomerResponseDTO getByCustomerId(@PathVariable Integer id)
	{
		return customerService.getByCustomerId(id);
	}
	
	@DeleteMapping("/delete")
	public String deleteByCustomerId(Integer id)
	{
		return customerService.deleteByCustomerId(id);
	}
	
	@PutMapping("/update/{id}")
	public CustomerResponseDTO updateByCustomerId(@PathVariable Integer id,@RequestBody CustomerRequestDTO requestDTO)
	{
		return customerService.updateByCustomerId(id, requestDTO);
	}
}
