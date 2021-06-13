package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeExperienceService;
import kodlamaio.hrms.core.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeExperienceDao;
import kodlamaio.hrms.entities.concretes.ResumeExperience;
import kodlamaio.hrms.entities.dtos.ResumeEducationAddDto;
import kodlamaio.hrms.entities.dtos.ResumeExperienceAddDto;

@Service
public class ResumeExperienceManager implements ResumeExperienceService{
	private ResumeExperienceDao resumeExperienceDao;
	private DtoConverterService dtoConverterService;

	@Autowired
	public ResumeExperienceManager(ResumeExperienceDao resumeExperienceDao, DtoConverterService dtoConverterService) {
		super();
		this.resumeExperienceDao = resumeExperienceDao;
		this.dtoConverterService = dtoConverterService;
	}


	@Override
	public Result add(ResumeExperienceAddDto resumeExperienceAddDto) {
		
		resumeExperienceDao.save((ResumeExperience)dtoConverterService.dtoToEntity(resumeExperienceAddDto, ResumeExperience.class));
		return new SuccessResult("Yetenekler Eklendi");
		
		
	}


	@Override
	public DataResult<List<ResumeExperienceAddDto>> findAllByResumeId(int resumeId) {
		return new SuccessDataResult<List<ResumeExperienceAddDto>>(dtoConverterService.entityToDto(resumeExperienceDao.findAllByResumeId(resumeId),ResumeExperienceAddDto.class),"Tecrübeler Listelendi");
	}


	@Override
	public DataResult<List<ResumeExperienceAddDto>> findByResumeIdOrderByEndDateDesc(int resumeId) {
		return new SuccessDataResult<List<ResumeExperienceAddDto>>(dtoConverterService.entityToDto(resumeExperienceDao.findByResumeIdOrderByEndDateDesc(resumeId),ResumeExperienceAddDto.class),"İş Tecrübeleri Tarihe Göre listelendi");
	}

}
