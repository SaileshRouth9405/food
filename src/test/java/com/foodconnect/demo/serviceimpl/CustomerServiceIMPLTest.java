package com.foodconnect.demo.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.foodconnect.demo.model.Customer;
import com.foodconnect.demo.repo.CustomerRepo;
import com.foodconnect.demo.requestdto.CustomerRequestDTO;
import com.foodconnect.demo.responsedto.CustomerResponseDTO;
import com.foodconnect.demo.service.CustomerService;
@SpringBootTest
class CustomerServiceIMPLTest {
	
	@Autowired
	private CustomerService customerService;

	@MockBean
	private CustomerRepo customerRepo;
	@Autowired
	private ModelMapper mapper;
	
	@Test
	void testSaveCustomer() {
		System.out.println(mapper);
		CustomerRequestDTO customerRequestDTO=new CustomerRequestDTO("name","gender","8985457845");
		Customer map = mapper.map(customerRequestDTO,Customer.class);
		CustomerResponseDTO customerResponseDTO= mapper.map(map,CustomerResponseDTO.class);
		when(customerService.saveCustomer(customerRequestDTO)).thenReturn(customerResponseDTO);
		assertEquals(customerRequestDTO.getName(),"test");
		assertEquals(customerRequestDTO.getGender(),customerResponseDTO.getGender());
		assertEquals(customerRequestDTO.getMobNumber(),customerResponseDTO.getMobNumber());
	}

//	@Test
//	void testGetByCustomerId() throws Exception
//	{
//		Integer id=1;
//		Customer customer=new Customer(1,"Sailesh","gender","8770708063");
//		when(customerRepo.findById(id)).thenReturn(Optional.of(customer));
//		assertEquals(customer.getId(),id);
//		CustomerResponseDTO responseDTO=mapper.map(customer,CustomerResponseDTO.class);
//		when(customerService.getByCustomerId(id)).thenReturn(responseDTO);
//		assertEquals(customer.getName(), responseDTO.getName());
//		assertEquals(customer.getGender(), responseDTO.getGender());
//		assertEquals(customer.getMobNumber(), responseDTO.getMobNumber());
//		
//	}

	@Test
	void testUpdateByCustomerId() {
	
		Integer id = 2;
		CustomerRequestDTO customerRequestDTO=new CustomerRequestDTO("name1","gender1","8985457847");
		Optional<Customer> customer=Optional.of(new Customer(2,"Sailesh1","gender1","8770708064"));
		when(customerRepo.findById(id)).thenReturn(customer);
		assertEquals(customer.get().getId(),id);
		Customer customer2=mapper.map(customerRequestDTO, Customer.class);
		customer2.setId(id);
		CustomerResponseDTO responseDTO=mapper.map(customer2,CustomerResponseDTO.class);
		when(customerService.updateByCustomerId(id,customerRequestDTO)).thenReturn(responseDTO);
		System.out.println();
		assertEquals(customerRequestDTO.getName(), responseDTO.getName());
		assertEquals(customerRequestDTO.getGender(), responseDTO.getGender());
		assertEquals(customerRequestDTO.getMobNumber(), responseDTO.getMobNumber());

	}
//
//	@Test
//	void testDeleteByCustomerId() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetAllCustomer() {
		List<Customer> customerResponseDTOs=new ArrayList<>();
		customerResponseDTOs.add(new Customer(1,"sailesh","male","8982158317"));
		customerResponseDTOs.add(new Customer(2,"sailesh11","male","8982158311"));
		
//		List<CustomerResponseDTO> map = customerResponseDTOs.stream().map(e->mapper.map(e,CustomerResponseDTO.class)).collect(Collectors.toList());
		
		when(customerRepo.findAll()).thenReturn(customerResponseDTOs);
		assertEquals(2,customerResponseDTOs.size());
	}

}
