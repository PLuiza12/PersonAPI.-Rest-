package Digital.Innovation.one.personapi.service;

import Digital.Innovation.one.personapi.mapper.PersonMapper;
import lombok.AllArgsConstructor;
import Digital.Innovation.one.personapi.dto.resquest.PersonDTO;
import Digital.Innovation.one.personapi.dto.response.MessageResponseDTO;
import Digital.Innovation.one.personapi.entities.Person;
import Digital.Innovation.one.personapi.exception.PersonNotFoundException;
import Digital.Innovation.one.personapi.repository.PersonRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonRepository personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;

    }
    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Create person whit ID" + savedPerson.getId())
                .build();

    }

    public List<PersonDTO> listAll(){
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException{
        Person person = verifyIfExists(id);

        return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFoundException {
        personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private PersonDTO verifyIfExistsy(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO){
        verifyIfExistsy(id);
        Person personToUpdate = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToUpdate);
        return MessageResponseDTO
                .builder()
                .message("Update person whit ID" + savedPerson.getId())
                .build();

    }

}


