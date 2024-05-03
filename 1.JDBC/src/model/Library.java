package model;

public class Library {
	
	String name;
	public String bookName;
//	String authorName;
//	String bookId;
	public int bkId;
	String libName;
	int totalBooksAdded;
	
	
//	public String getAuthorName() {
//		return authorName;
//	}
//	public void setAuthorName(String authorName) {
//		this.authorName = authorName;
//	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public String getBookId() {
//		return bookId;
//	}
//	public void setBookId(String bookId) {
//		this.bookId = bookId;
//	}
	
	
	
	public int getBkId() {
		return bkId;
	}
	public void setBkId(int bkId) {
		this.bkId = bkId;
	}
	
	
	
	public String getLibName() {
		return libName;
	}
	public void setLibName(String libName) {
		this.libName = libName;
	}
	public int getTotalBooksAdded() {
		return totalBooksAdded;
	}
	public void setTotalBooksAdded(int totalBooksAdded) {
		this.totalBooksAdded = totalBooksAdded;
	}
	public Library(String name, String bookName, String authorName,int totalBooksAdded, int bkId) {
		super();
		this.name = name;
		this.bookName = bookName;
//		this.authorName = authorName;
		this.bkId = bkId;
	}
	public Library() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Library [name=" + name + ", bookName=" + bookName + ", bkId=" + bkId + "]";
	}
	
	


}

