package co.edu.usb;



import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import co.edu.usb.Service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usb.domain.Customer;
import co.edu.usb.repository.CustomerRepository;


@SpringBootTest
@Rollback(false)
class CustomerTest {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerService customerService;

	@Test
	@Transactional
	void searchCustomerByStatusPageAndOrderIdNumber() {
		
		Page<Customer> pageCustomer = null;

		try {
			Pageable pageable = PageRequest.of(0, 3);

			pageCustomer = customerService.findByStatusOrderByIdentificationNumberAsc("A", pageable);
			for (Customer customer : pageCustomer) {

				System.out.println(customer.getName());
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
		@Test
		@Transactional
		void searchCustomerByEmailIgnoreMayMin() throws SQLException {
			
		
			Customer customer = customerRepository.findByEmailIgnoreCase("HOYOSB90@GMAIL.COM");
			

		            System.out.println(customer.getName());
		
		}

@Test
@Transactional
void searchCustomerIdNumberUserLike() {
	
	Customer customer = customerRepository.findByIdentificationNumberLike("%11124697%");
	
	System.out.println(customer.getFirstName());
}

/* 5. Consultar al cliente por nombre,
 *  ignorando Mayúsculas y minúsculas, 
 *   usando LIKE.*/
@Test
@Transactional
void searchCustomerNameIgnoreCaseLike() throws SQLException{
	
	try {
		Customer customer = customerRepository.findByNameIgnoreCaseLike("Jhon Anderson");
		System.out.println(customer.getFirstName());
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage());

	}
}

/*
 *  6. Consultar clientes por rango de
 *  fecha (Se debe pasar dos fechas y
 *   traer los clientes cuya fecha de nacimiento se encuentre 
 *  entre el rango ingresado)	
 */

@Test
@Transactional
void searchCustomerForRangeDate() throws SQLException{
	
	
	Calendar fechaInicio = new GregorianCalendar(1991, 5, 30);

	Calendar fechaFin = new GregorianCalendar(2016, 12, 8);
	
	try {
		
		List<Customer> lstCliente = customerRepository.findBybirthDateBetween(fechaInicio.getTime(),
				fechaFin.getTime());

		for (Customer cliente : lstCliente) {
			System.out.println(cliente.getName());
		}
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage());
	}
}
	@Test
	@Transactional
	void searchTotalCustomerForStatus() {
		
		try {
			Long lstCustomer = customerRepository.countAndfindByStatus("A");

			System.out.println(lstCustomer);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Test
	@Transactional
	void searchCustomerForIdentificationTypePageable() {
		Page<Customer> pageCustomer;
		
		try {
			Pageable pageable = PageRequest.of(0, 3);

			pageCustomer = customerRepository.findByIdentificationType_Code("CE", pageable);

			for (Customer customer : pageCustomer) {
				System.out.println(customer.getName());
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
		@Test
		@Transactional
		void searchCustomerForApellidos() 	{
			
			try {

				List<Customer> customer = customerRepository.findByFirstNameAndSecondName("Hoyos", "Batero");

				for (Customer customerx : customer) {
					System.out.println(customerx.getName());
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
@Test
@Transactional
void imprimirNumeros() {
	
     
      
	  for(int i = 0; i<=13; i++) {
		
		  if(i % 2 != 0) {
			  System.out.println(i);
		  }else {
			  System.out.println(i + "not  is prime");
		  }
		  

	  }
	

		}
		
}
	
	

	

	

