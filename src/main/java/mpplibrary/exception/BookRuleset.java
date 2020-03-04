package mpplibrary.exception;

import mpplibrary.dto.AuthorDto;
import mpplibrary.dto.BookDto;

public class BookRuleset implements RuleSet {
    @Override
    public void applyRules(Object dto) {
        BookDto bookDto = (BookDto) dto;
        if (isEmpty(bookDto.getTitle())) {
            throw new RuleSetException("Title required.");
        }

        if (isEmpty(bookDto.getIsbn())) {
            throw new RuleSetException("ISBN required.");
        }
    }

    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
