package pl.lodz.uni.math.dto;

import java.util.Date;

public class NewsDto {
	private String title;
	private String text;
	private String author;
	private long plus;
	private long minus;
	private String Category;
	private Date CreateDate;
	private Long link;
	private String image;
	private int rating;

	public NewsDto(String title, String text, String author, long l, long m, String category, Date createDate, Long link,
			String image, int rating) {
		super();
		this.title = title;
		this.text = text;
		this.author = author;
		this.plus = l;
		this.minus = m;
		Category = category;
		CreateDate = createDate;
		this.link = link;
		this.image = image;
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public long getPlus() {
		return plus;
	}

	public void setPlus(long plus) {
		this.plus = plus;
	}

	public long getMinus() {
		return minus;
	}

	public void setMinus(long minus) {
		this.minus = minus;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public Date getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}

	public Long getLink() {
		return link;
	}

	public void setLink(Long link) {
		this.link = link;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
