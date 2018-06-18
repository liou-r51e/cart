package org.springframework.data.solr.showcase.product.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.geo.GeoLocation;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;
import org.springframework.data.solr.showcase.product.SearchableProductDefinition;


@SolrDocument(solrCoreName = "techproducts")
public class Product implements SearchableProductDefinition {

	private @Id @Indexed String id;
	private @Indexed(PNAME_FIELD_NAME) String productName;
	private @Indexed(PRODUCTID_FIELD_NAME) int productId;


	private @Indexed(NAME_FIELD_NAME) String name;
	private @Indexed(IMAGES_FIELD_NAME) List<String> images;
//	private @Indexed(FIRSTNAME_FIELD_NAME) String firstName;

	//private @Indexed(AVAILABLE_FIELD_NAME) boolean available;

	//private @Indexed List<String> features;

//	private @Indexed(PRICE_FIELD_NAME) Float price;



	private @Indexed(SUBCATEGORY_FIELD_NAME) String subCategory;

	private @Indexed(CATEGORIES_FIELD_NAME) List<String> categories;
	private @Indexed(CATEGORY_FIELD_NAME) String category;
	private @Indexed(DISCRIPTION_FIELD_NAME) String discription;

	//private @Indexed Integer popularity;

/*	public String getId() {
		return id;
	}
/*
	public void setId(String id) {
		this.id = id;
	}*/

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
		}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	/*	public void setId(String id) {
            this.id = id;
        }*/



	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

/*	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
*/
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
/*
	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}


		/*public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
*/
/*	public List<String> getFeatures() {
		return features;
	}

	public void setFeatures(List<String> features) {
		this.features = features;
	}*/

	/*public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}*/

	/*public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

/*	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

/*	public Integer getPopularity() {

		return popularity;
	}

	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}
	*/

	@Override
	public String toString() {
		return "Product [id=" + id + "]";
	}

}
