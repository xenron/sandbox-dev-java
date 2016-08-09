package ejb3;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SECTION database table.
 * 
 */
@Entity
@NamedQueries({
	  @NamedQuery(name="findSectionAll", query="SELECT s FROM Section s"),
	  @NamedQuery(
	    name="findSectionBySectionName", query="SELECT s from Section s WHERE s.sectionname = :section")
	})
public class Section implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String sectionname;
	private List<Article> articles;
	private Edition edition;

    public Section() {
    }
	@Id
	@Column(name="ID", nullable=false)
	@SequenceGenerator(name="SECTION_ID_GENERATOR", sequenceName="SECTION_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SECTION_ID_GENERATOR")
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
	//bi-directional many-to-one association to Article
	@OneToMany(mappedBy="section", cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinTable(name = "SectionArticles",
          joinColumns = {  
              @JoinColumn(name="sectionId", referencedColumnName="ID")},   
              inverseJoinColumns = { @JoinColumn(name="articleId", referencedColumnName="ID")})
	public List<Article> getArticles() {
		return this.articles;
	}
	public void setArticles(List<Article> articles) {
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
	public void addArticle(Article article) {
        this.getArticles().add(article);
        article.setSection(this);
    }
	public void removeArticle(Article article) {
        this.getArticles().remove(article);
    }
}
