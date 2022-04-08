package co.edu.usb.domain;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;

@Data

@Entity
@Table(name = "destino")

public class Destination {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_dest")
	private Integer idDest;

	@Column(name = "codigo")
	private String code;

	@Column(name = "nombre")
	private String name;

	@Column(name = "descripcion")
	private String description;

	@Column(name = "tierra")
	private String land;

	@Column(name = "aire")
	private String air;

	@Column(name = "mar")
	private String sea;

	@Column(name = "fecha_creacion")
	private Date dateCreated;

	@Column(name = "fechaModificacion")
	private Date dateModified;

	@Column(name = "usu_creador")
	private String creatorUser;

	@Column(name = "usu_modificador")
	private String modifierUser;

	@Column(name = "estado")
	private String status;

	// llave primaria
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tide")
	private DestinationType destinationType;

	/*public Destination(Integer idDest, String code, String name, String description, String land, String air,
			String sea, Date dateCreated, Date dateModified, String creatorUser, String modifierUser, String status,
			DestinationType destinationType) {
		super();
		this.idDest = idDest;
		this.code = code;
		this.name = name;
		this.description = description;
		this.land = land;
		this.air = air;
		this.sea = sea;
		this.dateCreated = dateCreated;
		this.dateModified = dateModified;
		this.creatorUser = creatorUser;
		this.modifierUser = modifierUser;
		this.status = status;
		this.destinationType = destinationType;
	}*/
	public Destination() {
		
	}
}
