/*
 * Copyright 2012 - 2014 the original author or authors.
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
package org.springframework.data.solr.showcase.product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.core.query.result.SolrResultPage;
import org.springframework.data.solr.showcase.product.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.data.solr.core.SolrTemplate;

import javax.xml.soap.Text;


@Service
class ProductServiceImpl implements ProductService {

	private static final Pattern IGNORED_CHARS_PATTERN = Pattern.compile("\\p{Punct}");

	private ProductRepository productRepository;
	private SolrTemplate solrTemplate;
	private Criteria createSearchConditions(String[] words) {
		Criteria conditions = null;

		for (String word: words) {
			if (conditions == null) {
				conditions = new Criteria("title").contains(word)
						.or(new Criteria("description").contains(word));
			}
			else {
				conditions = conditions.or(new Criteria("title").contains(word))
						.or(new Criteria("description").contains(word));
			}
		}

		return conditions;
	}
	@Override
	public Page<Product> findByName(String searchTerm, Pageable pageable) {
		if (StringUtils.isBlank(searchTerm)) {
			return productRepository.findAll(pageable);
		}

		return productRepository.findByNameIn(splitSearchTermAndRemoveIgnoredCharacters(searchTerm), pageable);
	}
	@Override
	public Page<Product> findById(String searchTerm, Pageable pageable) {
		if (StringUtils.isBlank(searchTerm)) {
			return productRepository.findAll(pageable);
		}

		return productRepository.findByIdIn(splitSearchTermAndRemoveIgnoredCharacters(searchTerm), pageable);

	}




	public List<Product> search(String searchTerm) {
		String[] words = searchTerm.split(" ");

		Criteria conditions = createSearchConditions(words);
		SimpleQuery search = new SimpleQuery(conditions);

		Page results = solrTemplate.queryForPage(search, Product.class);
		return results.getContent();
	}





	private Collection<String> splitSearchTermAndRemoveIgnoredCharacters(String searchTerm) {
		String[] searchTerms = StringUtils.split(searchTerm, " ");
		List<String> result = new ArrayList<String>(searchTerms.length);
		for (String term : searchTerms) {
			if (StringUtils.isNotEmpty(term)) {
				result.add(IGNORED_CHARS_PATTERN.matcher(term).replaceAll(" "));
			}
		}
		return result;
	}

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

}
