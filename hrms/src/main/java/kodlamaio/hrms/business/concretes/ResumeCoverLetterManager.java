package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeCoverLetterService;
import kodlamaio.hrms.core.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeCoverLetterDao;
import kodlamaio.hrms.entities.concretes.ResumeCoverLetter;
import kodlamaio.hrms.entities.concretes.ResumeSkill;
import kodlamaio.hrms.entities.dtos.ResumeCoverLetterAddDto;

@Service
public class ResumeCoverLetterManager implements ResumeCoverLetterService {
	
	private ResumeCoverLetterDao resumeCoverLetterDao;
	private DtoConverterService dtoConverterService;

	@Autowired
	public ResumeCoverLetterManager(ResumeCoverLetterDao resumeCoverLetterDao, DtoConverterService dtoConverterService) {
		super();
		this.resumeCoverLetterDao = resumeCoverLetterDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(ResumeCoverLetterAddDto resumeCoverLetterAddDto) {
		
		resumeCoverLetterDao.save((ResumeCoverLetter)dtoConverterService.dtoToEntity(resumeCoverLetterAddDto, ResumeCoverLetter.class));
		return new SuccessResult("Başlık ve İçerik Eklendi");
	}

	
	@Override
	public DataResult<List<ResumeCoverLetterAddDto>> findAllByResumeId(int resumeId) {
		return new SuccessDataResult<List<ResumeCoverLetterAddDto>>(dtoConverterService.entityToDto(resumeCoverLetterDao.findAllByResumeId(resumeId),ResumeCoverLetterAddDto.class),"Başlıklar Listelendi");
	}

}
