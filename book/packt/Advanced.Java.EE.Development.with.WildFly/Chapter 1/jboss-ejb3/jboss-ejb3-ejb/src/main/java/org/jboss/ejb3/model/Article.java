package org.jboss.ejb3.model;
import java.io.Serializable;
import javax.persistence.*;
@Entity
@Table(name = "ARTICLE", uniqueConstraints = @UniqueConstraint(columnNames = "ID"))
@NamedQueries({
		@NamedQuery(name = "findArticleAll", query = "SELECT a FROM Article a"),
		@NamedQuery(name = "findArticleByTitle", query = "SELECT a from Article a WHERE a.title = :title") })
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private Section section;

	public Article() {
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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// bi-directional many-to-one association to Section
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinTable(name = "ArticleSection", joinColumns = { @JoinColumn(name = "articleId", referencedColumnName = "ID") }, inverseJoinColumns = { @JoinColumn(name = "sectionId", referencedColumnName = "ID") })
	public Section getSection() {
		return this.section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

}