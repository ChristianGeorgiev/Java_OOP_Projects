package ex2;

public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String author, String title, double price) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);
    }

    private String getTitle() {
        return this.title;
    }

    protected void setTitle(String title) {
        if (title.trim().length() < 3 || title.isEmpty()) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    private String getAuthor(){
        return this.author;
    }

    protected void setAuthor(String author) {
        String[] names = author.split("\\s+");
        if (names.length > 1) {
            if (Character.isDigit(names[1].charAt(0)) || author.isEmpty() || author.trim().length() == 0) {
                throw new IllegalArgumentException("Author not valid!");
            }
            this.author = author;
        }else {
            if (author.isEmpty() || author.trim().length() == 0){
                throw new IllegalArgumentException("Author not valid!");
            }
            this.author = author;
        }
    }

    public double getPrice(){
        return this.price;
    }

    protected void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(this.getPrice())
                .append(System.lineSeparator());
        return sb.toString();
    }
}