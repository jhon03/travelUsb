package co.edu.usb.Service;

import co.edu.usb.domain.DestinationType;

import java.sql.SQLException;
import java.util.List;

public interface DestynationTypeService {

    public DestinationType findByCodeAndStatus (String Code, String Status) throws Exception;

}
