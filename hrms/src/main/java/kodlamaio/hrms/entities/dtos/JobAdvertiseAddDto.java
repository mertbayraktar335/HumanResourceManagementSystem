package kodlamaio.hrms.entities.dtos;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.entities.concretes.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertiseAddDto {
	
	
	@JsonIgnore
	private int id;
	private int employerId;
	private int jobPositionId;
	private int cityId;
	private String jobDescription;
	private int minSalary;
	private int maxSalary;
	private int numberOfOpenPositions;
	private Date applicationDeadline;
	private String jobAdvertiseName;
	private String jobTypeTypeName;
	private boolean isRemote;
	
	
	

}
