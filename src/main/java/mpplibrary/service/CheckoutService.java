package mpplibrary.service;

import java.time.LocalDate;
import java.util.List;

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
	private BookCopyService bookCopyService;

	public CheckoutRecord checkoutBook(String isbn, int memberId) {
//        //Build test data
//        Book book = new Book();
//        book.setIsbn(isbn);
//        book.setTitle("Test book");
//        book.setMaxCheckoutDate(5);
//        Book savedBook = bookRepository.save(book);
//
//        try {
//            bookCopyService.addBookCopy(savedBook.getIsbn(), 4);
//        } catch (BookNotFoundException e) {
//            throw new RuntimeException(e);
//        }

		BookCopy availableBookCopy = bookCopyService.getAvailableBookCopy(isbn);

		CheckoutRecord checkoutRecord = new CheckoutRecord();
		checkoutRecord.setBookCopy(availableBookCopy);
		checkoutRecord.setCheckoutDate(LocalDate.now());
		checkoutRecord.setDueDate(
				checkoutRecord.getCheckoutDate().plusDays(availableBookCopy.getBook().getMaxCheckoutDate()));
		Member member = memberService.findById(memberId).get();
		checkoutRecord.setMember(member);
		return checkoutRecordRepository.save(checkoutRecord);
	}

	public List<CheckoutRecord> findCheckoutRecordsByMemberId(int memberId) {
		return checkoutRecordRepository.findAllByMemberId(memberId);
	}

	public boolean existByIdMember(int memberId) {
		if (checkoutRecordRepository.existByIdMember(memberId)>0)
			return true;
		else
			return false;
	}

}
