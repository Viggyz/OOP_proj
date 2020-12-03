class Book {
    String name,borby;
    boolean av;
    int type; // Type 1 is Textbook, Type 2 is Novel, Type 3 magazine
    Book(String name,int type) {
        this.name = name;
        this.type = type;
        av = true;
        borby = "-";
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
        borby = "-";
    }
}