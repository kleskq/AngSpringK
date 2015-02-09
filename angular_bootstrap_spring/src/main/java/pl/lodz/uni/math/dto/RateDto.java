package pl.lodz.uni.math.dto;

public class RateDto {

	private int newsId;
	private int rating;
	private String userName;

	public RateDto(int newsId, int rating, String userName) {
		super();
		this.newsId = newsId;
		this.rating = rating;
		this.userName = userName;
	}

	public RateDto() {
		super();
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
