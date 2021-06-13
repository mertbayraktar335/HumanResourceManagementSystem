package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.GraduateService;
import kodlamaio.hrms.core.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.GraduateDao;
import kodlamaio.hrms.entities.concretes.Graduate;
import kodlamaio.hrms.entities.dtos.GraduateAddDto;

@Service
public class GraduateManager implements GraduateService{
	private GraduateDao graduateDao;
	private DtoConverterService dtoConverterService;

	@Autowired
	public GraduateManager(GraduateDao graduateDao, DtoConverterService dtoConverterService) {
		super();
		this.graduateDao = graduateDao;
		this.dtoConverterService = dtoConverterService;
	}


	@Override
	
		public Result add(GraduateAddDto graduateAddDto) {
			
			graduateDao.save((Graduate)dtoConverterService.dtoToEntity(graduateAddDto, Graduate.class));
			return new SuccessResult("Yetenekler Eklendi");
		}
	}


