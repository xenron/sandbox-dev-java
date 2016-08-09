package org.jboss.ejb3.model;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;
 
@Entity
@Table(name = "EDITION", uniqueConstraints = @UniqueConstraint(columnNames = "ID"))
@NamedQueries( { @NamedQuery(name = "findEditionAll",
        query = "SELECT e FROM Edition e")
,
@NamedQuery(name = "findEditionByEdition", query = "SELECT e from Edition e WHERE e.edition = :edition")
} )
public class Edition implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String edition;
	private Catalog catalog;
	private Set<Section> sections;
    public Edition() {
    }
	@Id 
	@Column(name="ID", nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	//bi-directional many-to-one association to Catalog
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinTable(name = "EditionCatalog",
               joinColumns = { @JoinColumn(name = "editionId",referencedColumnName = "ID")
                } ,
inverseJoinColumns = { @JoinColumn(name = "catalogId", referencedColumnName ="ID")})
	public Catalog getCatalog() {
		return this.catalog;
	}
	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}
	//bi-directional many-to-one association to Section
	@OneToMany(mappedBy="edition", targetEntity=org.jboss.ejb3.model.Section.class, cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	public Set<Section> getSections() {
		return this.sections;
	}
	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}
	public String getEdition() {
        return edition;
    }
    public void setEdition(String edition) {
        this.edition = edition;
    }
}