package kodlamaio.hrms.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeCoverLetterService;
import kodlamaio.hrms.business.abstracts.ResumeEducationService;
import kodlamaio.hrms.business.abstracts.ResumeExperienceService;
import kodlamaio.hrms.business.abstracts.ResumeLanguageService;
import kodlamaio.hrms.business.abstracts.ResumeLinkService;
import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.business.abstracts.ResumeSkillService;
import kodlamaio.hrms.core.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeGetDto;
import kodlamaio.hrms.entities.dtos.ResumeUpdateDto;

@Service
public class ResumeManager implements ResumeService {
	private ResumeDao resumeDao;
	private DtoConverterService dtoConverterService;
	private ResumeLanguageService resumeLanguageService;
	private ResumeSkillService resumeSkillService;
	private ResumeLinkService resumeLinkService;
	private ResumeExperienceService resumeExperienceService;
	private ResumeEducationService resumeEducationService;
	private ResumeCoverLetterService resumeCoverLetterService;
	
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao, DtoConverterService dtoConverterService,ResumeLanguageService resumeLanguageService,
			ResumeSkillService resumeSkillService,ResumeLinkService resumeLinkService,ResumeExperienceService resumeExperienceService,ResumeEducationService resumeEducationService,ResumeCoverLetterService resumeCoverLetterService) {
		super();
		this.resumeDao = resumeDao;
		this.dtoConverterService = dtoConverterService;
		this.resumeLanguageService = resumeLanguageService;
		this.resumeSkillService = resumeSkillService;
		this.resumeLinkService = resumeLinkService;
		this.resumeExperienceService = resumeExperienceService;
		this.resumeEducationService = resumeEducationService;
		this.resumeCoverLetterService = resumeCoverLetterService;
	}




	@Override
	public Result add(ResumeGetDto resumeGetDto) {
		
		resumeGetDto.setCreatedDate(LocalDateTime.now());
		
		resumeDao.save((Resume)dtoConverterService.dtoToEntity(resumeGetDto, Resume.class));
		
		resumeGetDto.getLanguages().forEach(item -> item.setResume(resumeDao.findByResumeNameAndCandidateId(resumeGetDto.getResumeName(),resumeGetDto.getCandidateId())));
		resumeLanguageService.addAll(resumeGetDto.getLanguages());
		
		resumeGetDto.getSkills().forEach(item -> item.setResume(resumeDao.findByResumeNameAndCandidateId(resumeGetDto.getResumeName(),resumeGetDto.getCandidateId())));
		resumeSkillService.addAll(resumeGetDto.getSkills());
	
		resumeGetDto.getLinks().forEach(item -> item.setResume(resumeDao.findByResumeNameAndCandidateId(resumeGetDto.getResumeName(),resumeGetDto.getCandidateId())));
		resumeLinkService.addAll(resumeGetDto.getLinks());
		
		resumeGetDto.getExperiences().forEach(item -> item.setResume(resumeDao.findByResumeNameAndCandidateId(resumeGetDto.getResumeName(),resumeGetDto.getCandidateId())));
		resumeExperienceService.addAll(resumeGetDto.getExperiences());
		
		resumeGetDto.getEducation().forEach(item -> item.setResume(resumeDao.findByResumeNameAndCandidateId(resumeGetDto.getResumeName(),resumeGetDto.getCandidateId())));
		resumeEducationService.addAll(resumeGetDto.getEducation());
		
		resumeGetDto.getCoverLetters().forEach(item -> item.setResume(resumeDao.findByResumeNameAndCandidateId(resumeGetDto.getResumeName(),resumeGetDto.getCandidateId())));
		resumeCoverLetterService.addAll(resumeGetDto.getCoverLetters());
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
