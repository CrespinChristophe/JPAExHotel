package technifutur.crespin.JPAhotel.metier.service;

import org.springframework.stereotype.Service;
import technifutur.crespin.JPAhotel.data.repo.GerantRepository;
import technifutur.crespin.JPAhotel.metier.mapper.GerantMapper;
import technifutur.crespin.JPAhotel.model.dto.GerantDTO;
import technifutur.crespin.JPAhotel.model.entities.Gerant;
import technifutur.crespin.JPAhotel.model.forms.GerantForm;

import java.util.List;

@Service
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
    public GerantDTO getOne(Long id) {
        return null;
    }

    @Override
    public List<GerantDTO> getAll() {
        return null;
    }

    @Override
    public GerantDTO update(Long id, GerantForm form) {
        return null;
    }

    @Override
    public GerantDTO delete(Long id) {
        return null;
    }
}
