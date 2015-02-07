package pl.lodz.uni.math.api.persistence.dao.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Rate")
public class Rate implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "RateId")
	private int rateId;
	@Column(name = "Rating")
	private boolean rating; // true + , false -
	@ManyToOne
	@JoinColumn(name = "UserId")
	private User evaluator;
	@ManyToOne
	@JoinColumn(name = "NewsId")
	private News news;

	public int getRateId() {
		return rateId;
	}

	public void setRateId(int rateId) {
		this.rateId = rateId;
	}

	public boolean getRating() {
		return rating;
	}

	public void setRating(boolean rating) {
		this.rating = rating;
	}

	public User getEvaluator() {
		return evaluator;
	}

	public void setEvaluator(User evaluator) {
		this.evaluator = evaluator;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rateId;
		result = prime * result + (rating ? 1231 : 1237);
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
		Rate other = (Rate) obj;
		if (rateId != other.rateId)
			return false;
		if (rating != other.rating)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rate [rateId=" + rateId + ", rating=" + rating + ", evaluator=" + evaluator + ", news=" + news + "]";
	}

}
