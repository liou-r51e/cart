/*
 * Copyright 2012 - 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.solr.showcase.product.web;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.showcase.product.ProductService;
import org.springframework.data.solr.showcase.product.model.Product;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SearchController {

	private ProductService productService;


	@RequestMapping("/search/{q}")
	public List<Product> search(Model model, @PathVariable(value = "q") String query, @PageableDefault(
			page = 0, size = ProductService.DEFAULT_PAGE_SIZE) Pageable pageable, HttpServletRequest request) {
		List<Product> products = new ArrayList<>();
		//products = productService.search(query);
		productService.findByName(query, pageable)
				.forEach(products::add);
		return products;
	}



	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

}
