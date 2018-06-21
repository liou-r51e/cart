package org.springframework.data.solr.showcase.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.showcase.product.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
class ProductServiceImpl implements ProductService {

	//private static final Pattern IGNORED_CHARS_PATTERN = Pattern.compile("\\p{Punct}");

	private ProductRepository productRepository;

	@Override
	public List<Product> find(String searchTerm) {
		return productRepository.findByCategoriesContainsOrNameContainsOrProductNameContainsOrSubCategoryContainsOrDiscriptionContains ( searchTerm,searchTerm,searchTerm,searchTerm,searchTerm );
	}

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

}
