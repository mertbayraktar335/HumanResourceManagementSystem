package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeSkillService;
import kodlamaio.hrms.core.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeSkillDao;
import kodlamaio.hrms.entities.concretes.ResumeSkill;
import kodlamaio.hrms.entities.dtos.ResumeSkillDto;

@Service
public class ResumeSkillManager implements ResumeSkillService {
	private ResumeSkillDao resumeSkillDao;
	private DtoConverterService dtoConverterService;

	@Autowired
	public ResumeSkillManager(ResumeSkillDao resumeSkillDao, DtoConverterService dtoConverterService) {
		super();
		this.resumeSkillDao = resumeSkillDao;
		this.dtoConverterService = dtoConverterService;
	}

	
	@Override
	public Result add(ResumeSkillDto resumeSkillDto) {
		
		resumeSkillDao.save((ResumeSkill)dtoConverterService.dtoToEntity(resumeSkillDto, ResumeSkill.class));
		return new SuccessResult("Yetenekler Eklendi");
		
		
	}


	@Override
	public DataResult<List<ResumeSkillDto>> findAllByResumeId(int resumeId) {
		return new SuccessDataResult<List<ResumeSkillDto>>(dtoConverterService.entityToDto(resumeSkillDao.findAllByResumeId(resumeId),ResumeSkillDto.class),"Yetenekler Listelendi");
	}


	@Override
	public Result addAll(List<ResumeSkill> resumeSkill) {
		resumeSkillDao.saveAll(resumeSkill);
		return new SuccessResult();
	}

}
