package com.foodconnect.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.foodconnect.demo.requestdto.CustomerRequestDTO;
import com.foodconnect.demo.responsedto.CustomerResponseDTO;
@Service
public interface CustomerService {

	public CustomerResponseDTO saveCustomer(CustomerRequestDTO requestDTO);
	
	public CustomerResponseDTO getByCustomerId(Integer id);
	
	public CustomerResponseDTO updateByCustomerId(Integer id,CustomerRequestDTO requestDTO);
	
	public String deleteByCustomerId(Integer id);
	
	public List<CustomerResponseDTO> getAllCustomer();
}
