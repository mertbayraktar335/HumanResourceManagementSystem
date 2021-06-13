package kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeUpdateDto {
	@JsonIgnore
	private int id;
	private String about;
	private String resumeName;
	@JsonIgnore
	private LocalDateTime updateDate;
	
	

}
