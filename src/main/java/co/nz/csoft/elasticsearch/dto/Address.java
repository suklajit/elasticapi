package co.nz.csoft.elasticsearch.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.persistence.Embeddable;


@Embeddable
public class Address implements Serializable {

    private String country;
    private String postcode;
    private String streetNumber;
    private String streetName;
    private String suburb;
    private String city;
    private String state;
    private String locality;
    private String addressLine1;
    private String addressLine2;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNo) {
        this.streetNumber = streetNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address that = (Address) o;
        return Objects.equals(postcode, that.postcode)
                && Objects.equals(streetName, that.streetName)
                && Objects.equals(streetNumber, that.streetNumber)
                && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postcode, streetName, streetNumber, city);
    }
/*
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String separator = System.getProperty("line.separator");

        String line1 = Stream.of(streetNumber, streetName)
                .filter(s -> StringUtils.isNotBlank(s))
                .collect(Collectors.joining(", "));

        String line2 = Stream.of(suburb, city)
                .filter(s -> StringUtils.isNotBlank(s))
                .collect(Collectors.joining(", "));

        String line3 = Stream.of(state, country)
                .filter(s -> StringUtils.isNotBlank(s))
                .collect(Collectors.joining(", "));

        if (StringUtils.isNotBlank(line1)) {
            sb.append(line1).append(separator);
        }

        if (StringUtils.isNotBlank(line2)) {
            sb.append(line2).append(separator);
        }

        if (StringUtils.isNotBlank(line3)) {
            sb.append(line3).append(separator);
        }

        if (StringUtils.isNotBlank(postcode)) {
            sb.append(postcode).append(separator);
        }

        return sb.toString();
    }*/
}
