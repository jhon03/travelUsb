package co.edu.usb.Service;

import co.edu.usb.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface CustomerService {

    /**
     *
     * @param status
     * @param pageable
     * @return List Customers (páginada y ordenada Asc por #Identificacion)
     * @throws SQLException
     */
    public Page<Customer> findByStatusOrderByIdentificationNumberAsc(String status, Pageable pageable)
            throws SQLException;

    /**
     *
     * @param email customer
     * @return customer
     * restricción: ignorar mayúsculas y minúsculas
     */
    public Customer findByEmailIgnoreCase(String email);

    /**
     *
     * @param identificationNumber
     * @return customer
     * Usando LIKE
     */
    public Customer findByIdentificationNumberLike(String identificationNumber);

    /**
     *
     * @param name
     * @return Customer
     * Restricción: ignorar mayúsculas y minúsculas usando LIKE
     */
    public Customer findByNameIgnoreCaseLike(String name);


    /**
     *
     * @param fechaInicio
     * @param fechaFin
     * @return List Customers
     * @throws SQLException
     * consultar clientes por fecha de nacimiento en un periodo dado
     */
    public List<Customer> findBybirthDateBetween(Date fechaInicio, Date fechaFin) throws SQLException;

    /**
     *
     * @param status
     * @return contidad clientes
     * @throws SQLException
     */
    long countAndfindByStatus(String status) throws SQLException;


    /**
     *
     * @param code
     * @param pageable
     * @return customer paginado
     * @throws SQLException
     * consultar clientes por codigo de tipo de identificación paginada.
     */
    Page<Customer> findByIdentificationType_Code(String code, Pageable pageable) throws SQLException;


    /**
     *
     * @param firstName
     * @param SecondName
     * @return List customers
     * @throws SQLException
     */
    public List<Customer> findByFirstNameAndSecondName(String firstName, String SecondName) throws SQLException;
}
