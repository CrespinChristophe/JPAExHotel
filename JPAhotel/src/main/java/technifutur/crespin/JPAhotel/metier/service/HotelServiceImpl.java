package technifutur.crespin.JPAhotel.metier.service;

import org.springframework.stereotype.Service;
import technifutur.crespin.JPAhotel.data.exceptions.ElementNotFoundException;
import technifutur.crespin.JPAhotel.data.repo.GerantRepository;
import technifutur.crespin.JPAhotel.data.repo.HotelRepository;
import technifutur.crespin.JPAhotel.metier.mapper.HotelMapper;
import technifutur.crespin.JPAhotel.model.dto.HotelDTO;
import technifutur.crespin.JPAhotel.model.entities.Gerant;
import technifutur.crespin.JPAhotel.model.entities.Hotel;
import technifutur.crespin.JPAhotel.model.forms.HotelForm;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService{

    private final HotelRepository repository;
    private final GerantRepository gerantRepository;

    private final HotelMapper mapper;

    public HotelServiceImpl(HotelRepository repository, GerantRepository gerantRepository, HotelMapper mapper) {
        this.repository = repository;
        this.gerantRepository = gerantRepository;
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
    public List<HotelDTO> getStars(int stars) {

//        List <HotelDTO> listReturn = new ArrayList<>();
//        List<HotelDTO> listHotel;
        return repository.findAll()
                .stream()
                .filter((hotel -> hotel.getNbrEtoile() >= stars))
                .map(mapper::entityToDTO)
                .toList();

        /*for(HotelDTO listTemp : listHotel){
            if(listTemp.getNbrEtoile() >= stars)
                listReturn.add(getOne(listTemp.getId()));
        }*/

        /*return listReturn;*/
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
    public HotelDTO updateGerant(Long idHotel, Long idNewGerant) {
        Hotel entityHotel = repository.findById(idHotel)
                .orElseThrow(() -> new ElementNotFoundException(idHotel, HotelDTO.class));


        Gerant entityGerant = gerantRepository.findById(idNewGerant)
                .orElseThrow(() -> new ElementNotFoundException(idNewGerant, Gerant.class));


        entityHotel.setGerant(entityGerant);
        repository.save(entityHotel);




        return mapper.entityToDTO(entityHotel);



    }

    @Override
    public HotelDTO delete(Long id) {
        HotelDTO dto = getOne(id);
        repository.deleteById(id);
        return dto;
    }
}
