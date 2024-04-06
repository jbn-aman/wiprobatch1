class Author{

private int authorId;
private String authorName;
private String email;

Author(int authorId, String authorName, String email) {
 this.authorId = authorId;
this.authorName = authorName;
this.email = email;
}

void displayAuthor() {
System.out.println("Author Name:"+authorName);
System.out.println("Email:"+email);
}
}

 