package fr.humanbooster.sparks.avis.business;

import java.time.LocalDate;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Joueur extends Utilisateur {

	@Past(message = "Hein !? Attends tu te fou de moi ! Ce joueur n'est même pas encore né !")
    private LocalDate dateDeNaissance;

	@OneToMany(mappedBy = "joueur")
    private List<Avis> avis;

}