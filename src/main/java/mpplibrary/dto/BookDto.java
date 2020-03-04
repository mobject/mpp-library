package mpplibrary.dto;

public class BookDto {
    private Integer id;
    private String isbn;
    private String title;
    private int maxCheckoutPeriodInDays;

    public BookDto(String isbn, String title, int maxCheckoutPeriodInDays) {
        this.isbn = isbn;
        this.title = title;
        this.maxCheckoutPeriodInDays = maxCheckoutPeriodInDays;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMaxCheckoutPeriodInDays() {
        return maxCheckoutPeriodInDays;
    }

    public void setMaxCheckoutPeriodInDays(int maxCheckoutPeriodInDays) {
        this.maxCheckoutPeriodInDays = maxCheckoutPeriodInDays;
    }
}
