package com.webshop.model;

public class Product {
	private int id;
	private String name;
	private String image;
	private String description;
	private double price;
	private int cateID;
	private String title;
	private int sellID;
	private int views;
	

	public Product() {
		super();
	}

	public Product(int id, String name, String image, String description, double price, int cateID, String title,
			int sellID, int views) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.description = description;
		this.price = price;
		this.cateID = cateID;
		this.title = title;
		this.sellID = sellID;
		this.views = views;
	}

	public Product(String name, String image, String description, double price, int cateID, String title, int sellID,
			int views) {
		super();
		this.name = name;
		this.image = image;
		this.description = description;
		this.price = price;
		this.cateID = cateID;
		this.title = title;
		this.sellID = sellID;
		this.views = views;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCateID() {
		return cateID;
	}

	public void setCateID(int cateID) {
		this.cateID = cateID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSellID() {
		return sellID;
	}

	public void setSellID(int sellID) {
		this.sellID = sellID;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

}
