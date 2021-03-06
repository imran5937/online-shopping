package net.imran.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.imran.shoppingbackend.dao.CategoryDAO;
import net.imran.shoppingbackend.dto.Category;

@Repository("categoryDAO")

public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private static List<Category> categories = new ArrayList<>();

	static {

		// Adding first category
		Category category = new Category();
		category.setId(1);
		category.setName("Smartphone");
		category.setDescription("this is some description of smartphone");
		category.setImageUrl("CAT-1.png");

		categories.add(category);

		// Adding second category
		category = new Category();
		category.setId(2);
		category.setName("Laptop");
		category.setDescription("this is some description of Laptop");
		category.setImageUrl("CAT-2.png");

		categories.add(category);

		// Adding third category
		category = new Category();
		category.setId(2);
		category.setId(3);
		category.setName("tablet");
		category.setDescription("this is some description of tablet");
		category.setImageUrl("CAT-3.png");

		categories.add(category);

	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {

		// enchance for loop

		for (Category category : categories) {
			if (category.getId() == id)
				return category;

		}
		return null;
	}

	@Override
	@Transactional
	public boolean add(Category category) {
		try {
			// add the category to the database
			sessionFactory.getCurrentSession().persist(category);
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

}
