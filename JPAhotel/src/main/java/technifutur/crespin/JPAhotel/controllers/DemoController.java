package technifutur.crespin.JPAhotel.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;


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
    public String getForAll(){
        return "pour tous";
    }

    @GetMapping("/for-connected")
    public String getForConnected(){
        return "pour tous";
    }

    @GetMapping("/for-user")
    public String getForRoleUser(){
        return "pour tous";
    }

    @GetMapping("/for-admin")
    public String getForAdmin(){
        return "pour tous";
    }


}
