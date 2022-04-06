package technifutur.crespin.JPAhotel.model.forms;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;//javax validation //grace à spring-boot-starter-validation ajouté ds le pom.xml

import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Validated
public class GerantForm {

    @NotBlank//@Null est effectué auto
    @Size(min = 2, max = 50)//grace à spring-boot-starter-validation ajouté ds le pom.xml
    private String nom;
    @NotBlank//grace à spring-boot-starter-validation ajouté ds le pom.xml
    @Size(min = 2, max = 50)
    private String prenom;
    @PastOrPresent//grace à spring-boot-starter-validation ajouté ds le pom.xml
    private LocalDateTime dateCarriere;

}
