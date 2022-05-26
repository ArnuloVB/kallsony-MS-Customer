package co.com.pica.customer.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "user", schema = "sql5491238")
public class User implements Serializable {

	private static final long serialVersionUID = 2187421635775232936L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "documentType")
	private String documentType;
	
	@Column(name = "documentNumber")
	private String documentNumber;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "email")
	private String email;

	@Column(name = "dob")
	private LocalDate dob;
	
	@Column(name = "gender")
	private Character gender;
	
	@Column(name = "phone")
	private String phone;

	@Column(name = "status")
	private String status;
	
	@Column(name= "dataTreatment")
	private Integer dataTreatment;
	
	@Column(name= "password")
	private String password;
}