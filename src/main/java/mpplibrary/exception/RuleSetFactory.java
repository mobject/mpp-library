package mpplibrary.exception;

import mpplibrary.dto.AuthorDto;
import mpplibrary.dto.BookDto;

import java.util.HashMap;
import java.util.Map;

public class RuleSetFactory {
    private static Map<String, RuleSet > ruleSetMap = new HashMap<>();
    static {
        ruleSetMap.put(AuthorDto.class.getSimpleName(), new AuthorRuleset());
        ruleSetMap.put(BookDto.class.getSimpleName(), new BookRuleset());
    }

    public static RuleSet getRuleSet(Object dto) {
        if(!ruleSetMap.containsKey(dto.getClass().getSimpleName())) {
            throw new IllegalArgumentException(
                    "No RuleSet found for this Form");
        }

        return ruleSetMap.get(dto.getClass().getSimpleName());

    }
}
