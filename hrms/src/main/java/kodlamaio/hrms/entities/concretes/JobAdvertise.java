package kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_advertises")
public class JobAdvertise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="job_advertise_name")
	private String jobAdvertiseName;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="number_of_open_positions")
	private int numberOfOpenPositions;
	
	@JsonIgnore
	@Column(name="created_date")
	private LocalDate createdDate = LocalDate.now();
	
	@Column(name="application_deadline")
	private Date applicationDeadline; 
	
	
	@Column(name="is_active")
	private boolean isActive;
	
	
	@ManyToOne()
	@JoinColumn(name="employers_id", referencedColumnName = "id")
	private Employer employer;
	
	
	@ManyToOne()
	@JoinColumn(name="job_positions_id",referencedColumnName = "id")
	private JobPosition jobPosition;
	
	
	@ManyToOne()
	@JoinColumn(name="city_id",referencedColumnName = "id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name="job_type_id",referencedColumnName = "id")
	private JobType jobType;
	
	
	@Column(name="is_remote")
	private boolean isRemote;
	
	
	
	
	
	
}
