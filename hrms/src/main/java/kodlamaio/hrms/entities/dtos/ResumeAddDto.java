package kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeAddDto {
	
	@JsonIgnore
	private int id;
	private int candidateId;
	private String about;
	private String resumeName;
	
	@JsonIgnore
	private LocalDateTime createdDate;
	@JsonIgnore
	private LocalDateTime updateDate;
	//private boolean isActive;
	
	
	
	

}
