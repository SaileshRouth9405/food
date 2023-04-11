package com.foodconnect.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodconnect.demo.model.Customer;
import com.foodconnect.demo.repo.CustomerRepo;
import com.foodconnect.demo.requestdto.CustomerRequestDTO;
import com.foodconnect.demo.responsedto.CustomerResponseDTO;
import com.foodconnect.demo.service.CustomerService;

@Service
public class CustomerServiceIMPL implements CustomerService
{
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CustomerResponseDTO saveCustomer(CustomerRequestDTO requestDTO) {
		Customer map = modelMapper.map(requestDTO,Customer.class);
		customerRepo.save(map);
		return modelMapper.map(map, CustomerResponseDTO.class);
	}

	@Override
	public CustomerResponseDTO getByCustomerId(Integer id) {
		Optional<Customer> customer = customerRepo.findById(id);
		if(customer.isPresent())
		{
		return	modelMapper.map(customer.get(),CustomerResponseDTO.class);
		}
		return null;
	}

	@Override
	public CustomerResponseDTO updateByCustomerId(Integer id, CustomerRequestDTO requestDTO) {
		Optional<Customer> customer = customerRepo.findById(id);
		if(customer.isPresent() && (customer.get().getId().equals(id)))
			{
				Customer map = modelMapper.map(customer.get(),Customer.class);
				map.setId(id);
				customerRepo.save(map);
				return modelMapper.map(map,CustomerResponseDTO.class);
			
		}
		return null;
	}

	@Override
	public String deleteByCustomerId(Integer id) {
		Optional<Customer> customer = customerRepo.findById(id);
		if(customer.isPresent() && (customer.get().getId().equals(id)))
			{
				customerRepo.deleteById(id);
				return	"Deleted Sucessfully";
			
		
		}
		return "Not Found";
	}

	@Override
	public List<CustomerResponseDTO> getAllCustomer() {
		List<Customer> findAll = customerRepo.findAll();
		
		return (List<CustomerResponseDTO>) findAll.stream().map(e-> modelMapper.map(e,CustomerResponseDTO.class));
	}

}
