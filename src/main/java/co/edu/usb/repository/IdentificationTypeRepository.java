package co.edu.usb.repository;


import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usb.domain.IdentificationType;

public interface IdentificationTypeRepository extends JpaRepository<IdentificationType, Integer>{

	/*
	 *1.Consultar todos los tipo de identificación
	 * por estado ordenados alfabéticamente.
	 */
	
	public List<IdentificationType> findByStatusOrderByCodeAsc (String status)throws Exception;
	
	/*
	 * 7.    Consultar tipo de identificación por código y estado.
	 */
	public IdentificationType findByCodeAndStatus(String code, String Status);
	
}