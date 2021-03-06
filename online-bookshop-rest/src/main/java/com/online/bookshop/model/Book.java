package com.online.bookshop.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String author;
	private String publisher;
	private String publicationDate;
	private String language;
	private String category;
	private int numberOfPages;
	private String format;
	private int isbn;
	private double shippingWeight;
	private double listPrice;
	private double ourPrice;
	private boolean active=true;
	
	@Column(columnDefinition="text")
	private String description;
	
	private int inStockNumber;
	
	@Transient
	private MultipartFile bookImage;
	
	
	@OneToMany(mappedBy = "book")
	private List<BookToShoppingCart> bookToShoppingCartList;
	
}