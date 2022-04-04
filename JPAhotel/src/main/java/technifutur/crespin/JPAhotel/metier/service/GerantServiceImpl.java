package technifutur.crespin.JPAhotel.metier.service;

import org.springframework.stereotype.Service;
import technifutur.crespin.JPAhotel.data.exceptions.ElementNotFoundException;
import technifutur.crespin.JPAhotel.data.repo.GerantRepository;
import technifutur.crespin.JPAhotel.metier.mapper.GerantMapper;
import technifutur.crespin.JPAhotel.model.dto.GerantDTO;
import technifutur.crespin.JPAhotel.model.entities.Gerant;
import technifutur.crespin.JPAhotel.model.forms.GerantForm;

import java.util.List;

@Service//c un bean, cad une instance gérée par le container SPRING
public class GerantServiceImpl implements GerantService{

    private  final GerantRepository repository;
    private  final GerantMapper mapper;

    public GerantServiceImpl(GerantRepository repository, GerantMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public GerantDTO insert(GerantForm form) {

        Gerant entity = mapper.formToEntity(form);

        entity = repository.save(entity);

        return mapper.entityToDTO(entity);
    }

    @Override
    public GerantDTO getOne(Long id) { //pas de .stream car c'est un optionnal pas un stream
                                        //c'est presque comme un stream mais ce n'en est pas un

        return  repository.findById(id)
                .map(mapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(id, GerantDTO.class));

    }

    @Override
    public List<GerantDTO> getAll() {//.stream ici car c'est un stream, pas un optionnal

        return repository.findAll().stream()
                .map(mapper::entityToDTO)
                .toList();
    }

    @Override
    public GerantDTO update(Long id, GerantForm form) {
        Gerant entity = repository.findById(id)
                .orElseThrow( () -> new ElementNotFoundException(id, GerantDTO.class) );

        entity.setNom(form.getNom());
        entity.setPrenom(form.getPrenom());
        entity.setDebutCarriere(form.getDateCarriere());

        repository.save(entity);

        return mapper.entityToDTO(entity);
    }

    @Override
    public GerantDTO delete(Long id) {
        GerantDTO dto = getOne(id);
        repository.deleteById(id);
        return dto;
    }
}
