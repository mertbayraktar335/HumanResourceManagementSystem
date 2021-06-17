package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeLanguageService;
import kodlamaio.hrms.core.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeLanguageDao;
import kodlamaio.hrms.entities.concretes.ResumeLanguage;
import kodlamaio.hrms.entities.dtos.ResumeLanguageAddDto;

@Service
public class ResumeLanguageManager  implements ResumeLanguageService{
	private ResumeLanguageDao resumeLanguageDao;
	private DtoConverterService dtoConverterService;

	@Autowired
	public ResumeLanguageManager(ResumeLanguageDao resumeLanguageDao, DtoConverterService dtoConverterService) {
		super();
		this.resumeLanguageDao = resumeLanguageDao;
		this.dtoConverterService = dtoConverterService;
	}

	
	@Override
	public Result add(ResumeLanguageAddDto resumeLanguageAddDto) {
		
		resumeLanguageDao.save((ResumeLanguage)dtoConverterService.dtoToEntity(resumeLanguageAddDto, ResumeLanguage.class));
		return new SuccessResult("Diller Eklendi");
		
		
	}


	@Override
	public DataResult<List<ResumeLanguageAddDto>> findAllByResumeId(int resumeId) {
		return new SuccessDataResult<List<ResumeLanguageAddDto>>(dtoConverterService.entityToDto(resumeLanguageDao.findAllByResumeId(resumeId),ResumeLanguageAddDto.class),"Diller Listelendi");
	}


	@Override
	public Result addAll(List<ResumeLanguage> resumeLanguage) {
		resumeLanguageDao.saveAll(resumeLanguage);
		return new SuccessResult();
	}
}
