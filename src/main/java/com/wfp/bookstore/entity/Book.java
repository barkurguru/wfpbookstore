package  com.wfp.bookstore.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "This is the Id",example = "1")
	private Integer id;

	@Column(name = "title")
	@Schema(description = "This is the title",example = "Harry Potter")
	private String title;

	@Column(name = "description")
	@Schema(description = "This is the description of Book",example = "Harry Potter")
	private String description;

	@Column(name = "author")
	@Schema(description = "This is the Author of Book",example = "JK Rowling")
	private String author;
	
	@Column(name = "coverimage")
	@Schema(description = "This is the coverImage of Book",example = "https://xyz.com/books/Harry_ptter.jpg")
	private String coverimage;

	@Column(name = "price")
	@Schema(description = "This is the price of Book",example = "$50.5")
	private String price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCoverimage() {
		return coverimage;
	}

	public void setCoverimage(String coverimage) {
		this.coverimage = coverimage;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
