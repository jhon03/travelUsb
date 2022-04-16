package co.edu.usb.DTO;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data

public class DestinationTypeDTO implements Serializable {

    private Integer idTyde;

    private String code;

    private String name;

    private String description;


    private Date dateCreated;

    private Date dateModified;

    private String creatorUser;

    private String modifierUser;

    private String status;
}
