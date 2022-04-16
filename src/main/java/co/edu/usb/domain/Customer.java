package co.edu.usb.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Entity
@Table(name = "cliente")
public class Customer {

	 @Id
	 @Column(name = "id_clie")
	  private Integer idCustomer;
	 
	 @Column(name = "numero_identificacion")
	  private String identificationNumber;
	
	 @Column(name = "primer_apellido")
	  private String firstName;
	 
	 @Column(name = "segundo_apellido")
	  private String secondName;
	 
	 @Column(name = "nombre")
	  private String name;
	 
	 @Column(name = "telefono1" )
	  private String telephone;

	  @Column(name = "telefono2")
	  private String cellPhone;
	 
	  @Column(name = "correo" )
	  private String email;
	 
	  @Column(name = "sexo")
	  private String sexo;
	 
	  @Column(name = "fecha_nacimiento")
	  private Date birthDate;
	  
	  @Column(name = "fecha_creacion")
	  private Date dateCreated;
	  
	  @Column(name = "fecha_modificacion" )
	  private Date dateModified;
	  
	  @Column(name = "usu_creador")
	  private String creatorUser;
	  
	  @Column(name = "usu_modificador")
	  private String modifierUser;
	  
	  @Column(name = "estado")
	  private String status;
	  
	  @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "id_tiid")
	  private  IdentificationType identificationType;


	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	
	}

	  
	  
	
	
	  
	  


