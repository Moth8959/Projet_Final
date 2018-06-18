package factory.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("VideoProjecteur")
public class VideoProjecteur extends RessourcesMaterielles{

}
