package technifutur.crespin.JPAhotel.metier.service;

import technifutur.crespin.JPAhotel.model.dto.GerantDTO;
import technifutur.crespin.JPAhotel.model.forms.GerantForm;

import java.util.List;

public interface GerantService {

    // CREATE

    public GerantDTO insert(GerantForm form);

    // READ

    public GerantDTO getOne(Long id);
    public List<GerantDTO> getAll();

    // UPDATE

    public GerantDTO update(Long id, GerantForm form);

    // DELETE

    public GerantDTO delete ( Long id);

}
