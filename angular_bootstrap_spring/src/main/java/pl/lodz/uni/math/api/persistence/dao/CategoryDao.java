package pl.lodz.uni.math.api.persistence.dao;

import pl.lodz.uni.math.api.persistence.dao.pojo.Category;

public interface CategoryDao {

	public Category getCategory(String categoryName);
}
