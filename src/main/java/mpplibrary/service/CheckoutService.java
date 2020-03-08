package mpplibrary.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import mpplibrary.exception.BookNotFoundException;
import mpplibrary.exception.MemberNotFoundException;
import mpplibrary.repository.BookCopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mpplibrary.model.BookCopy;
import mpplibrary.model.CheckoutRecord;
import mpplibrary.model.Member;
import mpplibrary.repository.BookRepository;
import mpplibrary.repository.CheckoutRecordRepository;

@Service
public class CheckoutService {

    @Autowired
    private CheckoutRecordRepository checkoutRecordRepository;

    @Autowired
    private ManageMemberService memberService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookCopyRepository bookCopyRepository;

    @Autowired
    private BookCopyService bookCopyService;

    public CheckoutRecord checkoutBook(String isbn, int memberId) throws Exception {
        BookCopy availableBookCopy = bookCopyService.getAvailableBookCopy(isbn).orElseThrow(BookNotFoundException::new);
        Member member = memberService.findById(memberId).orElseThrow(MemberNotFoundException::new);
        CheckoutRecord checkoutRecord = this.buildCheckoutRecord(availableBookCopy, member);
//        availableBookCopy.setAvailable(false);
//        bookCopyRepository.save(availableBookCopy);
        return checkoutRecordRepository.save(checkoutRecord);
    }

    public List<CheckoutRecord> findCheckoutRecordsByMemberId(int memberId) {
        return checkoutRecordRepository.findAllByMemberId(memberId);
    }

    public boolean existByIdMember(int memberId) {
        return checkoutRecordRepository.existByIdMember(memberId)>0;
    }

    private CheckoutRecord buildCheckoutRecord(BookCopy availableBookCopy, Member member) {
        CheckoutRecord checkoutRecord = new CheckoutRecord();
        checkoutRecord.setBookCopy(availableBookCopy);
        checkoutRecord.setCheckoutDate(LocalDate.now());
        checkoutRecord.setDueDate(
                checkoutRecord.getCheckoutDate().plusDays(availableBookCopy.getBook().getMaxCheckoutDate()));
        checkoutRecord.setMember(member);
        return checkoutRecord;
    }
}
