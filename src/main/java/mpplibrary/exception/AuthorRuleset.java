package mpplibrary.exception;

import mpplibrary.dto.AuthorDto;

public class AuthorRuleset implements RuleSet {
    @Override
    public void applyRules(Object dto) {
        AuthorDto authorDto = (AuthorDto) dto;
        if (isEmpty(authorDto.getFirstName())) {
            throw new RuleSetException("First Name required.");
        }

        if (isEmpty(authorDto.getLastName())) {
            throw new RuleSetException("Last Name required.");
        }


        if (isEmpty(authorDto.getPhone())) {
            throw new RuleSetException("Phone required.");
        }

        if (isEmpty(authorDto.getShortBio())) {
            throw new RuleSetException("Short bio required.");
        }

        if (isEmpty(authorDto.getStreet())) {
            throw new RuleSetException("Street required.");
        }

        if (isEmpty(authorDto.getCity())) {
            throw new RuleSetException("City required.");
        }

        if (isEmpty(authorDto.getState())) {
            throw new RuleSetException("State required.");
        }

        if (isEmpty(authorDto.getZipCode())) {
            throw new RuleSetException("Zip code required.");
        }
        try {
            Integer.parseInt(authorDto.getZipCode());
        } catch (Exception ex) {
            throw new RuleSetException("Invalid value for zip code. Only numbers allowed.");
        }

    }

    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
