package beans;

public class Book {
	private String BookId;
	private String Title;
	private String Author;
	private int Release;
	private float Price;
	private String Picture;
	private int PublisherId;
	private int CategoryId;
	private Category category;
	public Book() {
		super();
	}

	public Book(String bookId, String title, String author, int release, float price, String picture, int publisherId,
			int categoryId) {
		super();
		BookId = bookId;
		Title = title;
		Author = author;
		Release = release;
		Price = price;
		Picture = picture;
		PublisherId = publisherId;
		CategoryId = categoryId;
	}

	
	
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Book(String bookId, String title, String author, int release, float price, String picture, int publisherId,
			int categoryId, Category category) {
		super();
		BookId = bookId;
		Title = title;
		Author = author;
		Release = release;
		Price = price;
		Picture = picture;
		PublisherId = publisherId;
		CategoryId = categoryId;
		this.category = category;
	}

	public String getBookId() {
		return BookId;
	}

	public void setBookId(String bookId) {
		BookId = bookId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public int getRelease() {
		return Release;
	}

	public void setRelease(int release) {
		Release = release;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public String getPicture() {
		return Picture;
	}

	public void setPicture(String picture) {
		Picture = picture;
	}

	public int getPublisherId() {
		return PublisherId;
	}

	public void setPublisherId(int publisherId) {
		PublisherId = publisherId;
	}

	public int getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}
	
	
}
