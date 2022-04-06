package technifutur.crespin.JPAhotel.metier.service;

import technifutur.crespin.JPAhotel.model.dto.HotelDTO;
import technifutur.crespin.JPAhotel.model.forms.GerantForm;
import technifutur.crespin.JPAhotel.model.forms.HotelForm;

import java.util.List;

public interface HotelService {
    // CREATE

    public HotelDTO insert(HotelForm form);

    // READ

    public HotelDTO getOne(Long id);
    public List<HotelDTO> getAll();
    public List<HotelDTO> getStars(int stars);

    // UPDATE

    public HotelDTO update(Long id, HotelForm form);
    public HotelDTO updateGerant(Long idHotel, Long idNewGerant);

    // DELETE

    public HotelDTO delete ( Long id);
}
