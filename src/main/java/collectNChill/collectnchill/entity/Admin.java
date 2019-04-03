package collectNChill.collectnchill.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {

	private Long adminId;
	private String adminHash;
	private String adminUsername;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	public String getAdminHash() {
		return adminHash;
	}
	public void setAdminHash(String adminHash) {
		this.adminHash = adminHash;
	}
	@Column(unique=true)
	public String getAdminUsername() {
		return adminUsername;
	}
	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

}

