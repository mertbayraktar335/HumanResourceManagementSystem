package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertiseService;
import kodlamaio.hrms.core.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertiseDao;
import kodlamaio.hrms.entities.concretes.JobAdvertise;
import kodlamaio.hrms.entities.dtos.JobAdvertiseAddDto;
import kodlamaio.hrms.entities.dtos.JobAdvertiseDto;

@Service
public class JobAdvertiseManager implements JobAdvertiseService {

	private JobAdvertiseDao jobAdvertiseDao;
	private DtoConverterService dtoConverterService;
	
	
	@Autowired
	public JobAdvertiseManager(JobAdvertiseDao jobAdvertiseDao, DtoConverterService dtoConverterService) {
		super();
		this.jobAdvertiseDao = jobAdvertiseDao;
		this.dtoConverterService = dtoConverterService;
	}

	
	
	
	@Override
	public Result add(JobAdvertiseAddDto jobAdvertiseAddDto) {
		this.jobAdvertiseDao.save((JobAdvertise)dtoConverterService.dtoToEntity(jobAdvertiseAddDto, JobAdvertise.class));
		//this.jobAdvertiseDao.save(jobAdvertise);
		return new SuccessResult("İlanınız Eklendi");
	}

	@Override
	public Result deleteById(int id) {
		if(this.jobAdvertiseDao.findById(id)==null) {
			return new ErrorResult("İlan bulunamadı");
		
			}
		else {
		this.jobAdvertiseDao.deleteById(id);
		return new SuccessResult("İlanınız Silindi");
		}
	}

	@Override
	public DataResult<List<JobAdvertiseDto>> findAllByIsActive(boolean isActive) {
		
		return new SuccessDataResult<List<JobAdvertiseDto>>(dtoConverterService.entityToDto(jobAdvertiseDao.findAllByIsActive(true),JobAdvertiseDto.class),"Aktif İlanlar listelendi");
	}

	@Override
	public DataResult<List<JobAdvertiseDto>> findByIsActiveOrderByCreatedDateDesc(boolean isActive) {
		return new SuccessDataResult<List<JobAdvertiseDto>>(dtoConverterService.entityToDto(jobAdvertiseDao.findByIsActiveOrderByCreatedDateDesc(true),JobAdvertiseDto.class),"Aktif İlanlar Tarihe Göre(Önce Son Eklenen) listelendi");
		
	}

	@Override
	public DataResult<List<JobAdvertiseDto>> findByIsActiveAndEmployer_CompanyName(boolean isActive, String employerName) {
		return new SuccessDataResult<List<JobAdvertiseDto>>(dtoConverterService.entityToDto(jobAdvertiseDao.findByIsActiveAndEmployer_CompanyName(isActive, employerName),JobAdvertiseDto.class),"Aktif İlanlar listelendi");
		
	}


	@Override
	public DataResult<List<JobAdvertiseDto>> findByIsActiveOrderByCreatedDateAsc(boolean isActive) {
		return new SuccessDataResult<List<JobAdvertiseDto>>(dtoConverterService.entityToDto(jobAdvertiseDao.findByIsActiveOrderByCreatedDateAsc(true),JobAdvertiseDto.class),"Aktif İlanlar Tarihe Göre(Önce İlk Eklenen) listelendi");
		
	}
	
	
	
	@Override
	public Result isActive(int id, boolean isActive) {
		JobAdvertise posting = jobAdvertiseDao.findById(id);
		if(!posting.isActive() && isActive) {
			
			
			posting.setActive(true);
			this.jobAdvertiseDao.save(posting);
			
			return new SuccessResult("İlan aktif duruma getirildi");
			}else if(posting.isActive() && !isActive) {
				
			posting.setActive(false);
			this.jobAdvertiseDao.save(posting);
			
			return new SuccessResult("İlan pasif duruma getirildi"); 
		}
			else if(!posting.isActive() && !isActive) {
				return new ErrorResult("İlan zaten Pasif");
			}
			else if(posting.isActive() && isActive) {
				return new ErrorResult("İlan zaten Aktif");
			}
			
			else {
				return new ErrorResult("Null değer girdiniz");
			}
	}




	
}

