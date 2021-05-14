package com.uol.productms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.uol.productms.domain.Product;
import com.uol.productms.dtos.ProductDTO;
import com.uol.productms.repositories.ProductRepository;
import com.uol.productms.services.exceptions.DataIntegrityException;
import com.uol.productms.services.exceptions.ObjectNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	
	public Product insert(Product obj) {
		obj.setId(null);
		obj=repo.save(obj);
		return obj;
	}
	
	
	
	public List<Product> findAll(){
		return repo.findAll();
	}
	
	
	public Product find(Integer id) {
		Optional<Product> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Product.class.getName()));
		
	}
	
	
	public Product update(Product obj) {
		Product newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	
	
	public List<Product> findSearch(String name, String description, Double min_price, Double max_price) {
		List<Product> newObj = repo.search(name,description,min_price,max_price);
		return newObj;
	}
	
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}
	
	
	
	public Product fromDTO(ProductDTO objDto) {
		Product pro = new Product(null, objDto.getName(),objDto.getDescription(), objDto.getPrice());
		System.out.println(pro);
		return pro;
	}
	
	
	private void updateData(Product newObj, Product obj) {
		newObj.setName(obj.getName());
		newObj.setDescription(obj.getDescription());
		newObj.setPrice(obj.getPrice());
	}
	
	
}