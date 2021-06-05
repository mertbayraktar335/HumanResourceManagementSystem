package kodlamaio.hrms.entities.dtos;

import java.sql.Date;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertiseDto {
	
	private String employerCompanyName;
	private String jobPositionPosition;
	private int numberOfOpenPositions;
	private LocalDateTime createdDate;
	private Date applicationDeadline;

}
