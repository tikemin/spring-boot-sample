package com.example.domain.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.model.Product;

@Repository
public class ProductRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductRepository.class);

	private static final String FIND_ALL_SQL = "SELECT id, name, url, imgsrc, description FROM PRODUCTS";

	private static final String FIND_ONE_SQL = "SELECT id, name, url, imgsrc, description FROM PRODUCTS WHERE id = :id";

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	/**
	 * 商品１件を取得する
	 */
	public Product findOne(String id) {
		try {
			SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
			return jdbcTemplate.queryForObject(FIND_ONE_SQL, param, productRowMapper());
		} catch (EmptyResultDataAccessException e) {
			LOGGER.error("EmptyResultError : FIND_ALL_SQL error:{}", e);
			return new Product();//とりあえず空の商品を返す
		} catch (DataAccessException e) {
			LOGGER.error("DataAccessError : FIND_ALL_SQL error:{}", e);
			return new Product();//とりあえず空の商品を返す;
		}
	}

	
	/**
	 * 商品一覧を取得する
	 */
	public List<Product> findAll() {
		try {
			return jdbcTemplate.query(FIND_ALL_SQL, productRowMapper());
		} catch (EmptyResultDataAccessException e) {
			LOGGER.error("EmptyResultError : FIND_ALL_SQL error:{}", e);
			return null;
		} catch (DataAccessException e) {
			LOGGER.error("DataAccessError : FIND_ALL_SQL error:{}", e);
			return null;
		}
	}

	/**
	 * 一覧を作成する為に、DBの結果をリストにマッピングする
	 */
	private RowMapper<Product> productRowMapper() {

		return new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

				Product product = new Product();
				
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setUrl(rs.getString("url"));
				product.setImgsrc(rs.getString("imgsrc"));
				product.setDescription(rs.getString("description"));

				return product;
			}
		};
	}
}
