package mpplibrary.dto;

public class BookCopyDto {
    private Long copyNo;
    private String title;
    private String isbn;
    private Boolean available;


    public BookCopyDto(Long copyNo, String title, String isbn, Boolean available) {
        this.copyNo = copyNo;
        this.title = title;
        this.isbn = isbn;
        this.available = available;
    }

    public Long getCopyNo() {
        return copyNo;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Boolean getAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return "BookCopyDto{" +
                "copyNo=" + copyNo +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", available=" + available +
                '}';
    }
}
