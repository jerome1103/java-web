package tw.jerome.domain.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@Schema(example = "1", description = "會員編號")
	private Integer userId;
	
	@Column
	@Schema(example = "Jerome", description = "會員名稱")
	private String userName;

	public User() {
		
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Map<String, Object> dataToMap() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", this.userId);
		map.put("userName", this.userName);
		return map;
	}
}
