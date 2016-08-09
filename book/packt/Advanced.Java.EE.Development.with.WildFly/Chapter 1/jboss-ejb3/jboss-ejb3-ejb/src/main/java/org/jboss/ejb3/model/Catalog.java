package org.jboss.ejb3.model;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;
 
 
@Entity
@Table(name = "CATALOG", uniqueConstraints = @UniqueConstraint(columnNames = "ID"))
@NamedQueries({
	  @NamedQuery(name="findCatalogAll", query="SELECT c FROM Catalog c"),
	  @NamedQuery(name="findCatalogByJournal", 
	      query="SELECT c FROM Catalog c WHERE c.journal = :journal")
	})
public class Catalog implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String journal;
	private Set<Edition> editions;
	public Catalog() {
	}

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	// bi-directional many-to-one association to Edition
	@OneToMany(mappedBy = "catalog", targetEntity=org.jboss.ejb3.model.Edition.class, cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	public Set<Edition> getEditions() {
		return this.editions;
	}

	public void setEditions(Set<Edition> editions) {
		this.editions = editions;
	}
}