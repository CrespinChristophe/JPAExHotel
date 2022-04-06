package technifutur.crespin.JPAhotel.controllers;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;


@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/headers")
    public ResponseEntity<?> getHeaders(@RequestHeader HttpHeaders headers) {
        headers.forEach((key, value) -> {
            System.out.println(key + "-" + value.get(0));
        });

        return ResponseEntity.ok().build();
    }

    @GetMapping("/header")
    public ResponseEntity<?> getHeader(@RequestHeader(HttpHeaders.HOST) String host) {
        System.out.println(host);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/params")
    public ResponseEntity<?> getParams(@RequestParam MultiValueMap<String, String> params){
        params.forEach((key, value) -> {
            System.out.println(key + " : ");
            value.forEach((v) -> System.out.println(v + ", "));
        });
        return ResponseEntity.ok().build();
    }

    @GetMapping("/param")
    public ResponseEntity<?> getParam(@RequestParam(required = false) Integer size){
        System.out.println("size : " + size);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/for-all")
    @PreAuthorize("permitAll()")
    public String getForAll(){
        return "pour tous";
    }

    @GetMapping("/for-connected")
    @PreAuthorize("isAuthenticated()")
    public String getForConnected(Authentication auth){
        return "pour connected";
    }

    @GetMapping("/for-user")
   // @Secured("ROLE_USER")//meme chose que @RolesAllowed("ROLE_USER")
    @RolesAllowed("ROLE_USER")
    public String getForRoleUser(){
        return "pour user";
    }

    @GetMapping("/for-admin")
    @Secured("ROLE_ADMIN")
    public String getForAdmin(){
        return "pour admin";
    }


}
