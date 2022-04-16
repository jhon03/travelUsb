package co.edu.usb.Service;

import co.edu.usb.domain.IdentificationType;

import java.sql.SQLException;
import java.util.List;

public interface IdentificationTypeService {

    /**
     *
     * @param status
     * @return List tipos de identificación ordenados por código en orden ascendente
     * @throws SQLException
     */
    public List<IdentificationType> findByStatusOrderByCodeAsc (String status)throws Exception;

    /**
     * author: Anderson Hoyos
     * @param code
     * @param Status
     * @return tipo de identificación
     */
    public IdentificationType findByCodeAndStatus(String code, String Status) throws Exception;

}
