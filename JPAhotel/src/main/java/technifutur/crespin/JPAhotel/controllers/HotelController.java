package technifutur.crespin.JPAhotel.controllers;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technifutur.crespin.JPAhotel.data.exceptions.ElementNotFoundException;

import technifutur.crespin.JPAhotel.metier.service.HotelService;
import technifutur.crespin.JPAhotel.model.dto.ErrorDTO;

import technifutur.crespin.JPAhotel.model.dto.HotelDTO;
import technifutur.crespin.JPAhotel.model.forms.HotelForm;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    private final HotelService service;

    public HotelController(HotelService service) {
        this.service = service;
    }

    // GET - http://localhost:8080/hotel

    @GetMapping

    public List<HotelDTO> getAll() {
        return service.getAll();
    }

    // GET - http://localhost:8080/gerant/id

    @GetMapping("/{id}") //variable id
    //@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getOne(@PathVariable(name = "id") Long ident){


        return /*ResponseEntity.ok(dto);//status ok == status 200 et dto c'est le body//4 façons de faire*/
                ResponseEntity.status(HttpStatus.OK) //le OK c un body builder
                        .header("from-controller", "HotelController")
                        .body(service.getOne(ident));
        /*ResponseEntity.ok().body(dto);*/
        /*new ResponseEntity<HotelDTO>(dto, HttpStatus.OK);//body puis status*/


    }

    //POST - http://localhost:8080/hotel
    //     - http://localhost:8080/hotel/add
    @PostMapping({"", "/add"}) //value et path sont interchangeables mais y a une subtilité //à revoir!!!
    //implicitement c'est value
    public ResponseEntity<?> insert(HotelForm form){

        return ResponseEntity.ok(service.insert(form));


    }



    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody HotelForm form,@PathVariable Long id){

        return ResponseEntity.ok( service.update(id, form) );

    }

    @PutMapping({"/hotel/{idHotel}/{idGerant}"})
    public ResponseEntity<?> updateGerant(@PathVariable Long idHotel, @PathVariable Long idGerant){

        return ResponseEntity.ok( service.updateGerant(idHotel, idGerant) );

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        return ResponseEntity.ok( service.delete(id) );

    }

    @GetMapping("/stars")// on aurait pu faire @GetMapping(params = "stars") et ne pas faire /stars, ce serait comme une surcharge
    //de méthode car il y a le parametre stars, donc, ce ne sera pas getAll() qui sera appellée mais cette méthode-ci
    public ResponseEntity<?> getParam(@RequestParam byte stars){

        return ResponseEntity.ok( service.getStars(stars));

    }



}
