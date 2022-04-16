package co.edu.usb.Service;

import co.edu.usb.domain.DestinationType;

import java.sql.SQLException;
import java.util.List;

public interface DestynationTypeService {

    public DestinationType findByCodeAndStatus (String code, String status) throws Exception;

    public List<DestinationType> findByStatusOrderByCodeAsc (String status) throws SQLException;

}
