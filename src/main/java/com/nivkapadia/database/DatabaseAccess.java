package com.nivkapadia.database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nivkapadia.beans.Author;
import com.nivkapadia.beans.Book;
import com.nivkapadia.beans.User;

@Repository
public class DatabaseAccess {

	@Autowired
	private NamedParameterJdbcTemplate jdbc;

	public User findUserAccount(String email) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM users WHERE email = :email";

		parameters.addValue("email", email);

		try {
			return jdbc.queryForObject(query, parameters, new BeanPropertyRowMapper<User>(User.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<String> getRolesById(Long userId) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT role.roleName " + "FROM userrole, role "
				+ "WHERE userRole.roleId = role.roleId " + "AND userId = :userId";
		namedParameters.addValue("userId", userId);
		return jdbc.queryForList(query, namedParameters, String.class);
	}

	public ArrayList<User> getAllUsers() {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM users;";

		ArrayList<User> users = (ArrayList<User>) jdbc.query(query, new BeanPropertyRowMapper<User>(User.class));
//		System.out.println(jdbc.query(query, 
//				new BeanPropertyRowMapper<User>(User.class)));
//		System.out.println(users);

		return users;
	}
	
	
	public void insertAuthor(Author author)
	{
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO author(firstName, lastName) VALUES (:fname, :lname);";
		parameters.addValue("fname", author.getFirstName());
		parameters.addValue("lname", author.getLastName());
		jdbc.update(query, parameters);
	}
	
	public void insertBook(Book book)
	{
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO book(title, isbn) VALUES(:title, :isbn);";
		parameters.addValue("title", book.getTitle());
		parameters.addValue("isbn", book.getIsbn());
		
		jdbc.update(query, parameters);
	}
	
	public ArrayList<Author> getAllAuthors()
	{
		String query = "SELECT * FROM author;";
		
		ArrayList<Author> result = (ArrayList<Author>) jdbc.query(query,
				new BeanPropertyRowMapper<Author>(Author.class));
		
		if (result.size() > 0)
			return result;
		else
			return null;
	}
	
	public ArrayList<Book> getAllBooks()
	{
		String query = "SELECT * FROM book;";
		
		ArrayList<Book> result = (ArrayList<Book>) jdbc.query(query,
				new BeanPropertyRowMapper<Book>(Book.class));
		
		
		if (result.size() > 0)
			return result;
		else
			return null;
	}
	
	public void deleteAuthorById(int id)
	{
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "DELETE FROM author WHERE authorid = :id";
		deleteDependentAuth(id);
		parameters.addValue("id", id);
		jdbc.update(query, parameters);
	}
	
	public void deleteBookById(int id)
	{
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		deleteDependent(id);
		String query = "DELETE FROM book WHERE bookid = :id;";
		
		parameters.addValue("id", id);
		jdbc.update(query, parameters);
	}
	
	public void deleteDependent(int id)
	{
		
		String query = "DELETE FROM authorbook where bookid = :id;";
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("id", id);
		jdbc.update(query, parameters);
				
	}
	public void deleteDependentAuth(int id)
	{
		
		String query = "DELETE FROM authorbook where authorid = :id;";
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("id", id);
		jdbc.update(query, parameters);
				
	}
}
