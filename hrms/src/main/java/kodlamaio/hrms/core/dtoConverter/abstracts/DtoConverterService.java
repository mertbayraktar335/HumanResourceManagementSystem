package kodlamaio.hrms.core.dtoConverter.abstracts;

import java.util.List;

public interface DtoConverterService {
	
	<S,T>  List<T> entityToDto(List<S> listTypeentityClass, Class<T> targetDtoClass);
	
	<T> Object dtoToEntity(Object dtoClass, Class<T> targetEntityClass);
	
	

}
