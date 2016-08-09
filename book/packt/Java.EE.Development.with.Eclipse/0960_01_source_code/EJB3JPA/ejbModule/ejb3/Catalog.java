package ejb3;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
/**
 * The persistent class for the CATALOG database table.
 * 
 */
@Entity
@NamedQueries({
	  @NamedQuery(name="findCatalogAll", query="SELECT c FROM Catalog c"),
	  @NamedQuery(name="findCatalogByJournal", 
	      query="SELECT c FROM Catalog c WHERE c.journal = :journal")
	})
public class Catalog implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String journal;
	private List<Edition> editions;

    public Catalog() {
    }
	@Id
	@Column(name="ID", nullable=false)
	@SequenceGenerator(name="CATALOG_ID_GENERATOR", sequenceName="CATALOG_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CATALOG_ID_GENERATOR")
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJournal() {
		return this.journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}

	//bi-directional many-to-one association to Edition
	@OneToMany(mappedBy="catalog", cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinTable(name="CATALOGEDITIONS", 
    joinColumns=
        @JoinColumn(name="catalogId", referencedColumnName="ID"),
      inverseJoinColumns=
      @JoinColumn(name="editionId", referencedColumnName="ID")
      )
	public List<Edition> getEditions() {
		return this.editions;
	}

	public void setEditions(List<Edition> editions) {
		this.editions = editions;
	}
	public void addEdition(Edition edition) {
	    this.getEditions().add(edition);
	  }
		
	  public void removeEdition(Edition edition) {
	    this.getEditions().remove(edition);
	  }
}
