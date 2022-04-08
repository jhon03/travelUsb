package co.edu.usb.DTO;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DestinationDTO implements Serializable {

    private Integer idDest;
    private String code;
    private String name;
    private String description;
    private String land;
    private String air;
    private String sea;
    private Date dateCreated;
    private Date dateModified;
    private String creatorUser;
    private String modifierUser;
    private String status;

    private Integer idTyde;
    private String nameDestinationType;
    private String CodeDestinationType;
}
