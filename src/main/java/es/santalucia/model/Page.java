package es.santalucia.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.lang.Integer; 


@Entity
@Table(name = "pages")
public class Page implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "page_id")
    private Integer page_id;

	public void setPage_id(Integer page_id) {this.page_id = page_id;}
	public Integer getPage_id() {return page_id;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}