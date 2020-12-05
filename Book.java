class Book {
    private String name;
    private String borrowed_by;
    private boolean is_available;
    Book(String name) {
        this.name = name;
        is_available = true;
    }
    String getName() {
        return name;
    }
    String getBorrower() {
        return borrowed_by;
    }
    boolean getAvailability() {
        return is_available;
    }
    void borrowBook(String n){
        is_available = false;
        borrowed_by = n; 
    }
    void returnBook() {
        is_available = true;
        borrowed_by = "";
    }
}