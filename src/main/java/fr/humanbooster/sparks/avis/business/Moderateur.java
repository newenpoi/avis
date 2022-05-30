package fr.humanbooster.sparks.avis.business;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Moderateur extends Utilisateur {

	@NotBlank(message = "Le numéro de téléphone doit être renseigné !")
	@Pattern(regexp = "^(?:(?:\\+|00)33|0)\s*[1-9](?:[\s.-]*\\d{2}){4}$", message = "Le numéro de téléphone doit être valide !")
    private String numeroDeTelephone;

}