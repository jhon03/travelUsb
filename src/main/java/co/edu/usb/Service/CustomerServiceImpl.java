package co.edu.usb.Service;

import co.edu.usb.domain.Customer;
import co.edu.usb.repository.CustomerRepository;
import jdk.jshell.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Scope("singleton")
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findByStatusOrderByIdentificationNumberAsc(String status, Pageable pageable) throws SQLException {
        Page <Customer> pageCustomer = null;

            Pageable pageable1 = PageRequest.of(0, 3);
            pageCustomer = customerRepository.findByStatusOrderByIdentificationNumberAsc(status, pageable);



        return pageCustomer;
    }

    @Override
    public Customer findByEmailIgnoreCase(String email) {
        return null;
    }

    @Override
    public Customer findByIdentificationNumberLike(String identificationNumber) {
        return null;
    }

    @Override
    public Customer findByNameIgnoreCaseLike(String name) {
        return null;
    }

    @Override
    public List<Customer> findBybirthDateBetween(Date fechaInicio, Date fechaFin) throws SQLException {
        return null;
    }

    @Override
    public long countAndfindByStatus(String status) throws SQLException {
        return 0;
    }

    @Override
    public Page<Customer> findByIdentificationType_Code(String code, Pageable pageable) throws SQLException {
        return null;
    }

    @Override
    public List<Customer> findByFirstNameAndSecondName(String firstName, String SecondName) throws SQLException {
        return null;
    }
}
