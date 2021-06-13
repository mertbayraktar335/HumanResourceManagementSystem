package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeEducationService;
import kodlamaio.hrms.core.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeEducationDao;
import kodlamaio.hrms.entities.concretes.ResumeEducation;
import kodlamaio.hrms.entities.dtos.ResumeEducationAddDto;

@Service
public class ResumeEducationManager implements ResumeEducationService{
	
	private ResumeEducationDao resumeEducationDao;
	private DtoConverterService dtoConverterService;

	@Autowired
	public ResumeEducationManager(ResumeEducationDao resumeEducationDao, DtoConverterService dtoConverterService) {
		super();
		this.resumeEducationDao = resumeEducationDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(ResumeEducationAddDto resumeEducationAddDto) {
		
		resumeEducationDao.save((ResumeEducation)dtoConverterService.dtoToEntity(resumeEducationAddDto, ResumeEducation.class));
		return new SuccessResult("Yetenekler Eklendi");
	}

	
	@Override
	public DataResult<List<ResumeEducationAddDto>> findAllByResumeId(int resumeId) {
		return new SuccessDataResult<List<ResumeEducationAddDto>>(dtoConverterService.entityToDto(resumeEducationDao.findAllByResumeId(resumeId),ResumeEducationAddDto.class),"Eğitimler Listelendi");
	}

	@Override
	public DataResult<List<ResumeEducationAddDto>> findByResumeIdOrderByEndDateDesc(int resumeId) {
		
		return new SuccessDataResult<List<ResumeEducationAddDto>>(dtoConverterService.entityToDto(resumeEducationDao.findByResumeIdOrderByEndDateDesc(resumeId),ResumeEducationAddDto.class),"Okullar Bitirme Tarihine Göre(Önce Son Bitirilen) listelendi");
	}

	
	}



