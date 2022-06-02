package fr.humanbooster.sparks.avis.business;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlateForme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotBlank(message = "Le nom ne peut être vide !")
    private String nom;

	@ManyToMany(mappedBy = "plateformes", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Jeu> jeux;

	public PlateForme(String nom) {
		this.nom = nom;
	}
}