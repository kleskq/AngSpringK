package pl.lodz.uni.math.dto;

import java.util.Date;

public class NewNewsDto {
	private String title;
	private String text;
	private String author;
	private String Category;
	private Date CreateDate;
	private Long link;
	private String image;

	public NewNewsDto(String title, String text, String author, String category, Date createDate, Long link, String image) {
		super();
		this.title = title;
		this.text = text;
		this.author = author;
		Category = category;
		CreateDate = createDate;
		this.link = link;
		this.image = image;
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

}
