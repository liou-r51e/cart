package org.springframework.data.solr.showcase.product;
import org.springframework.data.solr.showcase.product.model.Product;
import java.util.List;


public interface ProductService {


	List<Product> find(String searchTerm);


}
