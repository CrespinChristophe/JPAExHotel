package technifutur.crespin.JPAhotel.controllers;


import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technifutur.crespin.JPAhotel.data.exceptions.ElementNotFoundException;
import technifutur.crespin.JPAhotel.metier.service.GerantService;
import technifutur.crespin.JPAhotel.model.dto.ErrorDTO;
import technifutur.crespin.JPAhotel.model.dto.GerantDTO;
import technifutur.crespin.JPAhotel.model.forms.GerantForm;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/gerant")
public class GerantController {

    private final GerantService service;

    public GerantController(GerantService service) {
        this.service = service;
    }

    // GET - http://localhost:8080/gerant

    @GetMapping

    public List<GerantDTO> getAll() {
        return service.getAll();
    }

    // GET - http://localhost:8080/gerant/id

    @GetMapping("/{id}") //variable id
    //@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getOne(@PathVariable(name = "id") Long ident){

            //GerantDTO dto = service.getOne(ident);
            return /*ResponseEntity.ok(dto);//status ok == status 200 et dto c'est le body//4 façons de faire*/
                    ResponseEntity.status(HttpStatus.OK) //le OK c un body builder
                    .header("from-controller", "GerantController")
                    .body(service.getOne(ident));
            /*ResponseEntity.ok().body(dto);*/
            /*new ResponseEntity<GerantDTO>(dto, HttpStatus.OK);//body puis status*/


    }

    //POST - http://localhost:8080/gerant
    //     - http://localhost:8080/gerant/add
    @PostMapping({"", "/add"}) //value et path sont interchangeables mais y a une subtilité //à revoir!!!
    //implicitement c'est value
    public ResponseEntity<?> insert(GerantForm form){

            return ResponseEntity.ok(service.insert(form));


    }

   /* @DeleteMapping({"/gerant/{id}"})(@PathVariable)
    public ResponseEntity<?> delete(Long id){
        try{

            return ResponseEntity.ok(service.delete(id));
        }
        catch(ElementNotFoundException ex){
            return ResponseEntity.badRequest().body(new ErrorDTO(ex.getMessage(), "/gerant/delete"));

        }
    }

    @PutMapping({"/gerant/{id}", "/gerant/update"})
    public ResponseEntity<?> update(Long id, GerantForm form){
        try{
            return ResponseEntity.ok(service.update(id, form));
        }
        catch(ElementNotFoundException ex){
            return ResponseEntity.badRequest().body(new ErrorDTO(ex.getMessage(), "/gerant/update"));
        }
    }*/

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody GerantForm form,@PathVariable Long id){

            return ResponseEntity.ok( service.update(id, form) );

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

            return ResponseEntity.ok( service.delete(id) );

    }

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleElementNotFound(ElementNotFoundException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(
                        ErrorDTO.builder()
                                .message(ex.getMessage())
                                .method(HttpMethod.resolve(request.getMethod()))
                                .status(404)
                                .uri(request.getRequestURI())
                                .build()
                );
    }

}
