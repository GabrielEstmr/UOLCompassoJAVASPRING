package com.uol.productms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uol.productms.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

	
	@Query("SELECT a FROM Product a WHERE (a.name = :name AND a.description = :description AND a.price >= :min_price AND a.price <= :max_price)" )
	List<Product> search(@Param("name") String name, @Param("description") String description, @Param("min_price") Double min_price, @Param("max_price") Double max_price);
	
}
