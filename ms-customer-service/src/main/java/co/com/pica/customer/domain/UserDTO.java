package co.com.pica.customer.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	@ApiModelProperty(value = "id", example = "2")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String id;
	
	@ApiModelProperty(value = "Document Type", example = "CC")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String documentType;

	@ApiModelProperty(value = "Document Number", example = "1015362595")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String documentNumber;
	
	@ApiModelProperty(value = "First Name", example = "Andrés")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String firstName;
	
	@ApiModelProperty(value = "Last Name", example = "Gómez")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String lastName;
	
	@ApiModelProperty(value = "email", example = "test@test.com")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String email;
	
	@ApiModelProperty(value = "Mobile Phone", example = "3113698521")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String phone;
	
	@ApiModelProperty(value = "Gender", example = "Male")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String gender;
	
	@ApiModelProperty(value = "Status", example = "Active")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String status;
	
	@ApiModelProperty(value = "Date Of Birth", example = "1988-05-15")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private LocalDate dateOfBirth;
	
	@ApiModelProperty(value = "Data Treatment", example = "1")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer dataTreatment;
	
	@ApiModelProperty(value = "password", example = "Colombia123")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String password;
}