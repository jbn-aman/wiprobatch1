class Book {

private int bookId;
private String bookName;
private double price;
private Author author;

Book(int bookId, String bookName, double price, Author author) {
this.bookId = bookId;
this.bookName = bookName;
this.price = price;
this.author = author;
}

void display() {

System.out.println("BookId: "+bookId);
System.out.println("Name: "+bookName);
System.out.println("Price: "+price);
System.out.println("Author Details");
author.displayAuthor();
}
}
