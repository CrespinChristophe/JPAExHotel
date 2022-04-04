package technifutur.crespin.JPAhotel.metier.service;

import technifutur.crespin.JPAhotel.model.dto.GerantDTO;
import technifutur.crespin.JPAhotel.model.forms.GerantForm;

import java.util.List;
//@Service //mock inactif quand pas @Service, actif quand @Service
public class GerantServiceMock implements GerantService{
    @Override
    public GerantDTO insert(GerantForm form) {
        return null;
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
