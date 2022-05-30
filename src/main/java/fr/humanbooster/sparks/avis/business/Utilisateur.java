package fr.humanbooster.sparks.avis.business;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TypeUtilisateur")
public abstract class Utilisateur {

    public Utilisateur() {
    }

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

	@NotBlank(message = "Le pseudo doit être renseigné !")
    protected String pseudo;

	@NotBlank(message = "Le mot de passe doit être renseigné !")
	@Size(min = 3, message = "Ce mot de passe est parfaitement invalide et surtout trop court !")
    protected String motDePasse;

	@Email
	@Column(unique = true, nullable = false, length = 255)
    protected String email;

}