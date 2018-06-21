package org.springframework.data.solr.showcase.product;

import java.util.List;


import org.springframework.data.solr.repository.Boost;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.data.solr.showcase.product.model.Product;

interface ProductRepository extends SolrCrudRepository<Product, String> {

	List<Product> findByCategoriesContainsOrNameContainsOrProductNameContainsOrSubCategoryContainsOrDiscriptionContains(@Boost(4) String searchTerm,@Boost(5) String searchTerm1,@Boost(5) String searchTerm2,@Boost(3) String searchTerm3,@Boost(2) String searchTerm4);


}

