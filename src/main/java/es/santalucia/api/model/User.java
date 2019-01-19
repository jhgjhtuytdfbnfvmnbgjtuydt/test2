package es.santalucia.api.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.lang.String; 
import java.lang.String; 
import java.lang.String; 


@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "hash")
    private String hash;

	public void setUsername(String username) {this.username = username;}
	public String getUsername() {return username;}
	public void setEmail(String email) {this.email = email;}
	public String getEmail() {return email;}
	public void setHash(String hash) {this.hash = hash;}
	public String getHash() {return hash;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}