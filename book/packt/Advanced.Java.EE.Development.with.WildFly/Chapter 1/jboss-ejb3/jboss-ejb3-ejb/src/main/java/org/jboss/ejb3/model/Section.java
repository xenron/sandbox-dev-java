package org.jboss.ejb3.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "SECTION", uniqueConstraints = @UniqueConstraint(columnNames = "ID"))
@NamedQueries({
	  @NamedQuery(name="findSectionAll", query="SELECT s FROM Section s"),
	  @NamedQuery(
	    name="findSectionBySectionName", query="SELECT s from Section s WHERE s.sectionname = :section")})	 
public class Section implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String sectionname;
	private Set<Article> articles;
	private Edition edition;

    public Section() {
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
	public String getSectionname() {
		return this.sectionname;
	}

	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}
	//bi-directional one-to-many association to Article
	@OneToMany(mappedBy="section", targetEntity=org.jboss.ejb3.model.Article.class, cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	public Set<Article> getArticles() {
		return this.articles;
	}
	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}
	//bi-directional many-to-one association to Edition
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinTable(name = "SectionEdition",
               joinColumns = { @JoinColumn(name = "sectionId",
                                           referencedColumnName = "ID")
                } ,
        inverseJoinColumns = { @JoinColumn(name = "editionId", referencedColumnName =
                                           "ID")
                } )
	
	public Edition getEdition() {
		return this.edition;
	}
	public void setEdition(Edition edition) {
		this.edition = edition;
	}
}