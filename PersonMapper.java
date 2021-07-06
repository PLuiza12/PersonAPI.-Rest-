package Digital.Innovation.one.personapi.mapper;

import Digital.Innovation.one.personapi.dto.resquest.PersonDTO;
import Digital.Innovation.one.personapi.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.Mapping;

@Mapper
public class PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);


    @Mapping(target = "BirthDate", source = "BirthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}
