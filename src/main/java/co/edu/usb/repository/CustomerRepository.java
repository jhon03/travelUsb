package co.edu.usb.repository;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usb.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	/*
	 * 2. Consultar a todos los clientes por estado. Esta consulta debe ser paginada
	 * y ordenada de forma ascendente por número de identificación
	 */
	public Page<Customer> findByStatusOrderByIdentificationNumberAsc(String status, Pageable pageable)
			throws SQLException;

	/*
	 * 3. Consultar a un cliente por correo electrónico. Esta consulta debe ignorar
	 * las mayúsculas y minúsculas.
	 */
	public Customer findByEmailIgnoreCase(String email);

	/*
	 * 4.Consultar cliente por número de identificación, usando LIKE
	 */
	public Customer findByIdentificationNumberLike(String identificationNumber);

	/*
	 * 
	 * 5.
	 */
	public Customer findByNameIgnoreCaseLike(String name);

	/*
	 * 6.
	 */
	public List<Customer> findBybirthDateBetween(Date fechaInicio, Date fechaFin) throws SQLException;

	/*
	 * 8
	 */

	long countAndfindByStatus(String status) throws SQLException;

	/*
	 * 9
	 */
	Page<Customer> findByIdentificationType_Code(String code, Pageable pageable) throws SQLException;

	/*
	 * 10
	 */

	public List<Customer> findByFirstNameAndSecondName(String firstName, String SecondName) throws SQLException;
}
