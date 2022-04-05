package technifutur.crespin.JPAhotel.metier.service;

import org.springframework.stereotype.Service;
import technifutur.crespin.JPAhotel.data.exceptions.ElementNotFoundException;
import technifutur.crespin.JPAhotel.data.repo.HotelRepository;
import technifutur.crespin.JPAhotel.metier.mapper.HotelMapper;
import technifutur.crespin.JPAhotel.model.dto.HotelDTO;
import technifutur.crespin.JPAhotel.model.entities.Hotel;
import technifutur.crespin.JPAhotel.model.forms.HotelForm;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService{

    private final HotelRepository repository;
    private final HotelMapper mapper;

    public HotelServiceImpl(HotelRepository repository, HotelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public HotelDTO insert(HotelForm form) {
        Hotel entity = mapper.formToEntity(form);
        repository.save(entity);
        return mapper.entityToDTO(entity);
    }

    @Override
    public HotelDTO getOne(Long id) {

        return repository.findById(id)
                .map(mapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(id, HotelDTO.class));

    }

    @Override
    public List<HotelDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::entityToDTO)
                .toList();

    }

    @Override
    public HotelDTO update(Long id, HotelForm form) {
        Hotel entity = repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, HotelDTO.class));

        entity.setNom(entity.getNom());
        entity.setAdresse(entity.getAdresse());
        entity.setNbrEtoile(form.getNbrEtoile());

        repository.save(entity);

        return mapper.entityToDTO(entity);
    }

    @Override
    public HotelDTO delete(Long id) {
        HotelDTO dto = getOne(id);
        repository.deleteById(id);
        return dto;
    }
}
