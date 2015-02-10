package pl.lodz.uni.math.api.persistence.dao.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "News")
public class News implements Serializable {

	private static final long serialVersionUID = -3697685742277708187L;
	@Id
	@GeneratedValue
	@Column(name = "NewsId")
	private int newsId;
	@Column(name = "link")
	private long link;
	@Column(name = "NewsTitle")
	private String newsTitle;
	@Column(name = "NewsText")
	private String newsText;
	@Column(name = "CreateDate")
	private Date createDate;
	@Column(name = "NewsImageUrl")
	private String newsImageUrl;
	@ManyToOne
	@JoinColumn(name = "UserId")
	private User author;
	@OneToOne
	@JoinColumn(name = "news")
	private Category category;
	@OneToMany(mappedBy = "news", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Rate> rates;

	public int getNewsId() {
		return newsId;
	}

	
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public long getLink() {
		return link;
	}

	public void setLink(long link) {
		this.link = link;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsText() {
		return newsText;
	}

	public void setNewsText(String newsText) {
		this.newsText = newsText;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getNewsImageUrl() {
		return newsImageUrl;
	}

	public void setNewsImageUrl(String newsImageUrl) {
		this.newsImageUrl = newsImageUrl;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Rate> getRates() {
		return rates;
	}

	public void setRates(Set<Rate> rates) {
		this.rates = rates;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + (int) (link ^ (link >>> 32));
		result = prime * result + newsId;
		result = prime * result + ((newsImageUrl == null) ? 0 : newsImageUrl.hashCode());
		result = prime * result + ((newsText == null) ? 0 : newsText.hashCode());
		result = prime * result + ((newsTitle == null) ? 0 : newsTitle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		News other = (News) obj;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (link != other.link)
			return false;
		if (newsId != other.newsId)
			return false;
		if (newsImageUrl == null) {
			if (other.newsImageUrl != null)
				return false;
		} else if (!newsImageUrl.equals(other.newsImageUrl))
			return false;
		if (newsText == null) {
			if (other.newsText != null)
				return false;
		} else if (!newsText.equals(other.newsText))
			return false;
		if (newsTitle == null) {
			if (other.newsTitle != null)
				return false;
		} else if (!newsTitle.equals(other.newsTitle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", link=" + link + ", newsTitle=" + newsTitle + ", newsText=" + newsText
				+ ", createDate=" + createDate + ", newsImageUrl=" + newsImageUrl + ", author=" + author + ", category="
				+ category + ", rates=" + rates + "]";
	}





}
