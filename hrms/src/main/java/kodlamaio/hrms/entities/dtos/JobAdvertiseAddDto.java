package kodlamaio.hrms.entities.dtos;

import java.sql.Date;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertiseAddDto {
	
	private int id;
	private int employerId;
	private int jobPositionId;
	private int cityId;
	private String jobDescription;
	private int minSalary;
	private int maxSalary;
	private int numberOfOpenPositions;
	private Date applicationDeadline;
	
	

}
