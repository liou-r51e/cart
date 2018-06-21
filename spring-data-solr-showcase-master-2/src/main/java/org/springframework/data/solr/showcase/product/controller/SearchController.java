package org.springframework.data.solr.showcase.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.showcase.product.ProductService;
import org.springframework.data.solr.showcase.product.model.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class SearchController {

	private ProductService productService;


	@RequestMapping("/search/{q}")
	public List<Product> search(@PathVariable(value = "q") String query) {
	    return productService.find(query);
	    }
	    @Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

}
