package pl.lodz.uni.math.dto;

public class UserDto {

	private String userName;
	private String isEnabled;

	public UserDto(String userName, String isEnabled) {
		super();
		this.userName = userName;
		this.isEnabled = isEnabled;
	}

	public UserDto() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(String isEnabled) {
		this.isEnabled = isEnabled;
	}

}
