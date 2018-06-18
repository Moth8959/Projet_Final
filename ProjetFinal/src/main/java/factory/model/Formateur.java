package factory.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "trainer")
public class Formateur extends RessourcesHumaines {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@ManyToMany
	@JoinTable(name = "trainer_subject", joinColumns = @JoinColumn(name = "trainer_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
	@JsonView(Views.ViewFormateur.class)
	private List<Matiere> matieres = new ArrayList<>();
	@OneToOne(mappedBy = "formation")
	@JsonView(Views.ViewCommon.class)
	private Formation formation;
	@OneToOne(mappedBy = "module")
	@JsonView(Views.ViewCommon.class)
	private Module module;

	public Formateur() {
		super();
	}

	

}
