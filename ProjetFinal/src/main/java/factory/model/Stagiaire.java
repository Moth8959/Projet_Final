package factory.model;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "trainee")
// @SecondaryTable(name = "trainee_lazy")
@SequenceGenerator(name = "seqStagiaire", sequenceName = "trainee_sequence")
public class Stagiaire {

	
	
}
