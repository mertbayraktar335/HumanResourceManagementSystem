package kodlamaio.hrms.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeAddDto;
import kodlamaio.hrms.entities.dtos.ResumeGetDto;
import kodlamaio.hrms.entities.dtos.ResumeUpdateDto;

@Service
public class ResumeManager implements ResumeService {
	private ResumeDao resumeDao;
	private DtoConverterService dtoConverterService;

	
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao, DtoConverterService dtoConverterService) {
		super();
		this.resumeDao = resumeDao;
		this.dtoConverterService = dtoConverterService;
	}




	@Override
	public Result add(ResumeAddDto resumeAddDto) {
		
		resumeAddDto.setCreatedDate(LocalDateTime.now());
		resumeDao.save((Resume)dtoConverterService.dtoToEntity(resumeAddDto, Resume.class));
		return new SuccessResult("Özgeçmiş Eklendi");
	}


	@Override
	public Result update(ResumeUpdateDto resumeUpdateDto, int resumeId, int candidateId) {
		resumeUpdateDto.setUpdateDate(LocalDateTime.now());
		resumeUpdateDto.setId(resumeId);
		resumeDao.save((Resume)dtoConverterService.dtoToEntity(resumeUpdateDto, Resume.class));
		return new SuccessResult("Özgeçmiş Güncellendi");
	}




	@Override
	public Result findAllByIdAndCandidateId(int id, int candidateId) {
		return new SuccessDataResult<List<ResumeGetDto>>(dtoConverterService.entityToDto(resumeDao.findByIdAndCandidateId(id, candidateId),ResumeGetDto.class));
	}








	

}
