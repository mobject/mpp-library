package mpplibrary.service;

import mpplibrary.model.Book;
import mpplibrary.model.CheckoutRecord;
import mpplibrary.model.Member;
import mpplibrary.repository.CheckoutRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {

    @Autowired
    private CheckoutRecordRepository checkoutRecordRepository;

    public void checkoutBook(Book book, Member member){
        CheckoutRecord checkoutRecord = new CheckoutRecord();

        checkoutRecordRepository.save(checkoutRecord);
    }
}
