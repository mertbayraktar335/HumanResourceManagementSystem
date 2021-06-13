package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.dtos.GraduateAddDto;

public interface GraduateService {
 Result add(GraduateAddDto graduateAddDto);
}
