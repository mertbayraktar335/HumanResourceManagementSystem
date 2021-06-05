package kodlamaio.hrms.core.dtoConverter.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.dtoConverter.abstracts.DtoConverterService;

@Service
public class DtoConverterManager implements DtoConverterService {

	private ModelMapper modelMapper;
	
	@Autowired
	public DtoConverterManager(ModelMapper modelMapper) {
		super();
		this.modelMapper = modelMapper;
	}

	@Override
	public <S, T> List<T> entityToDto(List<S> listTypeentityClass, Class<T> targetDtoClass) {
		return listTypeentityClass.stream().map(element -> modelMapper.map(element, targetDtoClass)).collect(Collectors.toList());
	}

	@Override
	public <T> Object dtoToEntity(Object dtoClass, Class<T> targetEntityClass) {
		return modelMapper.map(dtoClass,targetEntityClass);
	}

}
