package model;

public class Library {
	
	String name;
	public String bookName;

	public int bkId;
	String libName;
	int totalBooksAdded;
	public String userName;
	public String pass;
	public String phone;
	public String passW;
	
	

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
	
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
	public String getPassW() {
		return passW;
	}
	public void setPassW(String passW) {
		this.passW = passW;
	}
	public Library(String name, String bookName, String authorName,int totalBooksAdded, int bkId, String pass, String userName, String phone, String passW) {
		super();
		this.name = name;
		this.bookName = bookName;
		this.bkId = bkId;
		this.pass=pass;
		this.userName=userName;
		this.phone=phone;
		this.passW=passW;
	}
	public Library() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Library [name=" + name +  ", bkId=" + bkId + "]";
	}
	
	


}

