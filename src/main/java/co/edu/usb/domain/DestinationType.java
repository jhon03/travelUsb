package co.edu.usb.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tipo_destino")
public class DestinationType {

	@Id
    @Column(name="id_tide")
	private Integer idTyde;

    @Column(name="codigo")
    private String code;

    @Column(name="nombre")
    private String name;

    @Column(name="descripcion")
    private String description;

    @Column(name="fecha_creacion")
    private Date dateCreated;
    
    @Column(name="fecha_modificacion")
    private Date dateModified;

    @Column(name="usu_creador")
    private String creatorUser;

    @Column(name="usu_modificador")
    private String modifierUser;
    
    @Column(name="estado")
    private String status;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "destinationType")
    private List<Destination> destination = new ArrayList<>();

}
