package fr.humanbooster.sparks.avis.business;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModeleEconomique {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotBlank(message = "Le nom ne peut être vide !")
    private String nom;

	@ToString.Exclude
	@OneToMany(mappedBy = "modeleEconomique")
    private List<Jeu> jeux;

	public ModeleEconomique(String nom) {
		this.nom = nom;
	}
}