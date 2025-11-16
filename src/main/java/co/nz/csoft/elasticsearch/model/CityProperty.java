package co.nz.csoft.elasticsearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "city-property")
public class CityProperty {

	@Id
	private String id;

	private String city;
	private String propertyName;

	// Constructors
	public CityProperty() {
	}

	public CityProperty(String id, String city, String propertyName) {
		this.id = id;
		this.city = city;
		this.propertyName = propertyName;
	}

	// Getters & Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
}
