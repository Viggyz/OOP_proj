class Book {
    String name,borby;
    boolean av;
    Book(String name) {
        this.name = name;
        av = true;
    }
    String getName() {
        return name;
    }
    void borrowBook(String n){
        av = false;
        borby = n;
    }
    void returnBook() {
        av = true;
        borby = "";
    }
}