package fr.humanbooster.sparks.avis.business;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jeu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotBlank(message = "Le nom ne peut être vide !")
	@Column(unique = true, length = 32)
    private String nom;

	@Size(min = 8, max = 255, message = "La description du jeu doit être comprise entre 8 et 255 caractères.")
    private String description;

    private LocalDate dateSortie;

    @NotBlank(message = "Le jeu doit au moins fournir une capture !")
    private String image;

    @ManyToOne
    private Genre genre;

    @ManyToOne
    private Editeur editeur;

    @ManyToOne
    private Classification classification;

    @ManyToMany
    @JoinTable(name = "jeu_plateformes", joinColumns = @JoinColumn(name = "plateforme_id"), inverseJoinColumns = @JoinColumn(name = "jeu_id"))
    private List<PlateForme> plateformes;

    @ManyToOne
    private ModeleEconomique modeleEconomique;

    @ManyToOne
    private Moderateur moderateur;

    @OneToMany(mappedBy = "jeu")
    private List<Avis> avis;

}