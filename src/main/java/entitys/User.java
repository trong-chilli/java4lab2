package entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "Users")
public class User {
	@Id
	@Column(name="Id")
	String Id;
	@Column(name="Password")
	String Password;
	@Column(name="Fullname", columnDefinition = "nvarchar")
	String Fullname;
	@Column(name="Email")
	String Email;
	@Column(name="Admin")
	Boolean Admin = false;
	
}
