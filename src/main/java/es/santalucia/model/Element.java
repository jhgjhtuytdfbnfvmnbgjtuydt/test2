package es.santalucia.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.lang.Integer; 
import java.lang.String; 
import java.lang.String; 
import java.lang.Integer; 


@Entity
@Table(name = "elements")
public class Element implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "element_id")
    private Integer element_id;

    @Column(name = "attribute_name")
    private String attribute_name;

    @Column(name = "value")
    private String value;

    @Column(name = "page_id")
    private Integer page_id;

	public void setElement_id(Integer element_id) {this.element_id = element_id;}
	public Integer getElement_id() {return element_id;}
	public void setAttribute_name(String attribute_name) {this.attribute_name = attribute_name;}
	public String getAttribute_name() {return attribute_name;}
	public void setValue(String value) {this.value = value;}
	public String getValue() {return value;}
	public void setPage_id(Integer page_id) {this.page_id = page_id;}
	public Integer getPage_id() {return page_id;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}