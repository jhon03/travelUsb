package co.edu.usb.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tipo_identificacion")
public class IdentificationType {

	@Id
	@Column(name = "id_tiid")
	private Integer idTiid;

	@Column(name = "codigo")
	private String code;

	@Column(name = "nombre")
	private String name;

	@Column(name = "fecha_creacion")
	private Date dateCreated;

	@Column(name = "fecha_modificacion")
	private Date dateModified;

	@Column(name = "usu_creador")
	private String CreatorUser;

	@Column(name = "usu_modificador")
	private String ModifierUser;

	@Column(name = "estado")
	private String status;
}
