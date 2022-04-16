package co.edu.usb.Service;

import co.edu.usb.Utils.Constantes;
import co.edu.usb.Utils.Utilities;
import co.edu.usb.domain.Customer;
import co.edu.usb.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Scope("singleton")
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findByStatusOrderByIdentificationNumberAsc(String status, Pageable pageable) throws SQLException {
        Page<Customer> pageCustomer = null;

        Pageable pageable1 = PageRequest.of(0, 3);
        pageCustomer = customerRepository.findByStatusOrderByIdentificationNumberAsc(status, pageable);


        return pageCustomer;
    }

    @Override
    public Customer findByEmailIgnoreCase(String email) throws Exception {

        if (!Utilities.isValidEmail(email)) {
            throw new Exception("Debe ingresar un email válido: no puede contener carácteres especiales");
        }
        /*
        if(email == null || email.trim().equals(""))
        {
            throw new Exception("Debe ingresar un correo");
        }*/
        if (email.trim().length() > 100) {
            throw new Exception("No puede ingresar mas de 100 carácteres");
        }

        Customer customer = customerRepository.findByEmailIgnoreCase(email);
        if (customer == null) {
            throw new Exception("No se encontro ningún cliente con esa dirección de correo electrónico");
        }


        return customer;
    }

    @Override
    public Customer findByIdentificationNumberLike(String identificationNumber) throws Exception {


        if (identificationNumber == null || identificationNumber.trim().equals("")) {
            throw new Exception("Debe ingresar un número de identificación");
        }
        if (Utilities.isStringInteger(identificationNumber)) {
            throw new Exception("Solo debe ingresar numeros");
        }
        if (identificationNumber.trim().length() > 15) {
            throw new Exception("El número de identificación no puede tener mas de 15 carácteres");
        }
        Customer customer = customerRepository.findByIdentificationNumberLike(identificationNumber);
        if (customer == null) {
            throw new Exception("No se encontraron clientes con ese número de identificación");
        }
        return customer;
    }

    @Override
    public Customer findByNameIgnoreCaseLike(String name) throws Exception {


        if (name == null || name.trim().equals("")) {
            throw new Exception("Debe  ingresar el nombre del cliente");
        }
        if (name.trim().length() > 100) {
            throw new Exception("No se permiten mas de 100 carácteres");
        }
        if (!Utilities.isStringInteger(name)) {
            throw new Exception("No se admiten números");
        }
        Customer customer = customerRepository.findByNameIgnoreCaseLike(name);
        if (customer == null) {
            throw new Exception("No se existen clientes con ese nombre en la base de datos");
        }
        return customer;
    }

    @Override
    public List<Customer> findBybirthDateBetween(Date fechaInicio, Date fechaFin) throws Exception {

        if (fechaInicio == null || fechaFin == null) {
            throw new Exception("Debe ingresar una fecha");
        }
        if (fechaInicio == null && fechaFin == null) {
            throw new Exception("Debe ingresar un rango de fecha válido");
        }
        // se revisa si la fecha, si puede ser la actual
        if ((fechaInicio.compareTo(new Date()) > 0) || (fechaFin.compareTo(new Date()) > 0)) {
            throw new Exception("La fecha inicial o final no pueden ser la fecha actual o una fecha que no aún no haya pasado");
        }
        if (fechaInicio.compareTo(fechaFin) == 0) {
            throw new Exception("La fecha de inicio no puede ser igual a la fecha final.");
        }

        List<Customer> lstCliente = customerRepository.findBybirthDateBetween(fechaInicio, fechaFin);
        if(lstCliente.isEmpty())
        {
            throw new Exception("No se encontraron clientes con ese rango de fecha de nacimiento");
        }
        return lstCliente;
    }
    @Override
    public long countAndfindByStatus(String status) throws Exception {

        if(!Utilities.isStringInteger(status))
        {
            throw new Exception("No se admiten números: Debe ingresar solo A o I");
        }
        if(Utilities.isStringLenght(status, Constantes.TamanoEstado))
        {
            throw new Exception("Debe ingresar solo A o I");
        }
        Long lstCustomer = customerRepository.countAndfindByStatus(status);
        return lstCustomer;
    }

    @Override
    public Page<Customer> findByIdentificationType_Code(String code, Pageable pageable) throws Exception {
        Page<Customer> pageCustomer;
       // Pageable pageable1 = PageRequest.of(0, 3);

        if(code == null  || code.trim().equals(""))
        {
            throw new Exception("Debe ingresar un código de Tipo De Identificación");
        }

        if(!Utilities.isStringInteger(code) ||  Utilities.isSpecialCaracter(code))
        {
            throw new Exception("No se admiten números ó carácteres especiales(·#$%jj)");
        }
        if (code.trim().length()>5)
        {
            throw new Exception("El código no puede tener más de 5 carácteres");
        }

        pageCustomer = customerRepository.findByIdentificationType_Code(code, pageable);
        if(pageCustomer.isEmpty())
        {
            throw new Exception("No se encontraron clientes con ese tipo de identificación");
        }
        return pageCustomer;
    }

    @Override
    public List<Customer> findByFirstNameAndSecondName(String firstName, String SecondName) throws Exception {

      if (firstName == null  && SecondName == null   || firstName.trim().equals("")
              || SecondName.trim().equals(""))
      {
          throw new Exception("Debe ingresar los Apellidos del cliente");
      }
      if(firstName.trim().length()>100     || SecondName.trim().length()>100)
      {
          throw new Exception("No se permiten más de 100 carácteres");
      }
          List<Customer> customers = customerRepository.findByFirstNameAndSecondName(firstName, SecondName);
       if(customers.isEmpty())
       {
           throw new Exception("No se encontraron clientes con los apellidos ingresados");
       }
        return customers;
    }
}
