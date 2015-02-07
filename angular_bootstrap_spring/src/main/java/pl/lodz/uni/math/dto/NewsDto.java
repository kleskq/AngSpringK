package pl.lodz.uni.math.dto;

import java.util.Date;


public class NewsDto {
	private String title;
	private String text;
	private String author;
	private Long link;
	private int plus;
	private int minus;
	private Date createDate;
	private String image;
	private String category;

	public NewsDto() {
	}

	public NewsDto(String title, String text, String author, Long link, int plus, int minus, Date date, String image,
			String category) {
		super();
		this.title = title;
		this.text = text;
		this.author = author;
		this.link = link;
		this.plus = plus;
		this.minus = minus;
		this.createDate = date;
		this.image = image;
		this.category = category;
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

	public Long getLink() {
		return link;
	}

	public void setLink(Long link) {
		this.link = link;
	}

	public int getPlus() {
		return plus;
	}

	public void setPlus(int plus) {
		this.plus = plus;
	}

	public int getMinus() {
		return minus;
	}

	public void setMinus(int minus) {
		this.minus = minus;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
