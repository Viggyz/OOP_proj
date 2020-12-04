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
    String getBorby() {
        return borby;
    }
    boolean getAv() {
        return av;
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