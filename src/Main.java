import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import dao.DataAccess;
import dao.DataAccessFacade;
import model.Book;
import model.LendableCopy;
import model.LibraryMember;
import model.Publication;

public class Main {

	public static void main(String[] args) {
		LibraryMember member = new LibraryMember("John");
		Publication p = new Book(1, "1234", "Gone with the Wind");
		LendableCopy c = new LendableCopy();
		c.setPublication(p);
		c.setCopyId(1);
		member.checkout(c, LocalDate.now(), LocalDate.now().plus(30, ChronoUnit.DAYS));
		System.out.println("Location of 'user.dir':\n  " + DataAccessFacade.OUTPUT_DIR);
		DataAccess da = new DataAccessFacade();
		da.saveLibraryMember("John", member);
		System.out.println("Reading record for John:\n" + "  " + da.readLibraryMember("John"));

	}

}
