package com.payment.paymentgateway.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"bookID",
"title",
"authors",
"average_rating",
"isbn",
"language_code",
"ratings_count",
"price"
})
public class BookDetailsResponse {

@JsonProperty("bookID")
private String bookID;
@JsonProperty("title")
private String title;
@JsonProperty("authors")
private String authors;
@JsonProperty("average_rating")
private String averageRating;
@JsonProperty("isbn")
private String isbn;
@JsonProperty("language_code")
private String languageCode;
@JsonProperty("ratings_count")
private String ratingsCount;
@JsonProperty("price")
private String price;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("bookID")
public String getBookID() {
return bookID;
}

@JsonProperty("bookID")
public void setBookID(String bookID) {
this.bookID = bookID;
}

@JsonProperty("title")
public String getTitle() {
return title;
}

@JsonProperty("title")
public void setTitle(String title) {
this.title = title;
}

@JsonProperty("authors")
public String getAuthors() {
return authors;
}

@JsonProperty("authors")
public void setAuthors(String authors) {
this.authors = authors;
}

@JsonProperty("average_rating")
public String getAverageRating() {
return averageRating;
}

@JsonProperty("average_rating")
public void setAverageRating(String averageRating) {
this.averageRating = averageRating;
}

@JsonProperty("isbn")
public String getIsbn() {
return isbn;
}

@JsonProperty("isbn")
public void setIsbn(String isbn) {
this.isbn = isbn;
}

@JsonProperty("language_code")
public String getLanguageCode() {
return languageCode;
}

@JsonProperty("language_code")
public void setLanguageCode(String languageCode) {
this.languageCode = languageCode;
}

@JsonProperty("ratings_count")
public String getRatingsCount() {
return ratingsCount;
}

@JsonProperty("ratings_count")
public void setRatingsCount(String ratingsCount) {
this.ratingsCount = ratingsCount;
}

@JsonProperty("price")
public String getPrice() {
return price;
}

@JsonProperty("price")
public void setPrice(String price) {
this.price = price;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}