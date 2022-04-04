package technifutur.crespin.JPAhotel.model.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;
@Getter
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true) // sert à mettre toutes var en private et en final
//donc ne plus écrire private et final si on l'utilise'
@AllArgsConstructor
@Builder
public class ErrorDTO {

    private final String message;
    private final int status;
    private final String uri;
    private final HttpMethod method;
    private final Map<String, Object> infos = new HashMap<>();

    public ErrorDTO(String message, String uri, HttpMethod method){
        this.message = message;
        this.status = 400;
        this.uri = uri;
        this.method = method;
    }

//    public ErrorDTO(String message, int status, String uri){
//        this.message = message;
//        this.status = status;
//        this.uri = uri;
//    }

    public ErrorDTO(String message, int status, String uri, HttpMethod method, Map<String, Object> infos){
        this.message = message;
        this.status = status;
        this.uri = uri;
        this.method = method;
        this.infos.putAll(infos);
    }

    /*public ErrorDTO(String message, String s) {
        this.message = message;

    }*/
}


