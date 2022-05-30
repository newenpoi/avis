package fr.humanbooster.sparks.avis.business;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Avis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Size(min = 8, max = 255, message = "Un avis dois contenir entre 8 et 255 caractères !")
    private String description;

    private LocalDateTime dateEnvoi;

	@Range(min = 0, max = 20)
    private Float note;

    private LocalDateTime dateModeration;

    @ManyToOne
    private Moderateur moderateur;

    @ManyToOne
    private Joueur joueur;

    @ManyToOne
    private Jeu jeu;

}