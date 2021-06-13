package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeLinkService;
import kodlamaio.hrms.core.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessDataResult;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeLinkDao;
import kodlamaio.hrms.entities.concretes.ResumeLink;
import kodlamaio.hrms.entities.dtos.ResumeLinkAddDto;

@Service
public class ResumeLinkManager implements ResumeLinkService{
	private ResumeLinkDao resumeLinkDao;
	private DtoConverterService dtoConverterService;

	@Autowired
	public ResumeLinkManager(ResumeLinkDao resumeLinkDao, DtoConverterService dtoConverterService) {
		super();
		this.resumeLinkDao = resumeLinkDao;
		this.dtoConverterService = dtoConverterService;
	}

	
	@Override
	public Result add(ResumeLinkAddDto resumeLinkAddDto) {
		
		resumeLinkDao.save((ResumeLink)dtoConverterService.dtoToEntity(resumeLinkAddDto, ResumeLink.class));
		return new SuccessResult("Link Eklendi");
		
		
	}


	@Override
	public DataResult<List<ResumeLinkAddDto>> findAllByResumeId(int resumeId) {
		return new SuccessDataResult<List<ResumeLinkAddDto>>(dtoConverterService.entityToDto(resumeLinkDao.findAllByResumeId(resumeId),ResumeLinkAddDto.class),"Linkler Listelendi");
	}

}
