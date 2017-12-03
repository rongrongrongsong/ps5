package pkgEmpty;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import pkgLibrary.Book;
import pkgLibrary.BookException;
import pkgLibrary.Catalog;

public class BookTest {

@Test
	public void TestCatalog()
	{
		Catalog cat = Catalog.ReadXMLFile();
		System.out.println(cat.getId());
		System.out.println(cat.getBooks().size());
		Book b = new Book();
		b.setAuthor("Rong Song");
		b.setTitle("Kite Runner");
		b.setGenre("Novel");
		b.setDescription("The Kite Runner is the story of Amir, "
				+ "a Sunni Muslim, who struggles to find his place "
				+ "in the world because of the aftereffects and "
				+ "fallout from a series of traumatic childhood events");
		b.setId("bk113");
	
		String inputString = "08-15-1995";
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date inputDate = null;
		try {
			inputDate = dateFormat.parse(inputString);
		} catch (ParseException e) {
			fail("Exception raised");
		}
		b.setPublish_date(inputDate);
		b.setPrice(19.99);
		
		try {
			Book.addBook(cat, b);
		} catch (BookException e) {
			fail("Exception raised");
		}
		
		System.out.println(cat.getBooks().size());
		
		Book bookGet=null;
		try {
			 bookGet = Book.getBook(cat, b.getId());
		} catch (BookException e) {
			fail("Exception raised");
		}
		assertEquals(b.getId(), bookGet.getId());
	}

}