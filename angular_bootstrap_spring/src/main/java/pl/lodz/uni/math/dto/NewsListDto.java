package pl.lodz.uni.math.dto;

public class NewsListDto {
	private String title;
	private String text;
	private String author;
	private Long link;
	private String image;


	public NewsListDto(String title, String text, String author, Long link, String image) {
		super();
		this.title = title;
		this.text = text;
		this.author = author;
		this.link = link;
		this.image = image;
	}

	public NewsListDto() {
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


	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}



}
