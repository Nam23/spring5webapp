package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class BootstrapData implements CommandLineRunner{

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	public BootstrapData(AuthorRepository authorRepository,
			BookRepository bookRepository,PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository=publisherRepository;
	}

	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Started in Bootstrap");
		Publisher pub =new Publisher("Nam","house","la","ca","1234");
		publisherRepository.save(pub);
		Author author=new Author("Tim","Cook");
		Book book=new Book("Hello World","1234");
		author.getBooks().add(book);
		book.getAuthors().add(author);
		
		book.setPublisher(pub);
		pub.getBooks().add(book);
		
		authorRepository.save(author);
		bookRepository.save(book);
		publisherRepository.save(pub);
		
		Author author1=new Author("Timmy","Cookie");
		Book book1=new Book("Hello Guys","1235");
		author1.getBooks().add(book1);
		book1.getAuthors().add(author1);
		book1.setPublisher(pub);
		pub.getBooks().add(book1);
		authorRepository.save(author1);
		bookRepository.save(book1);
		publisherRepository.save(pub);
		
		
		
		
		System.out.println("Book count is : "+bookRepository.count());
		System.out.println("Publisher count is "+publisherRepository.count());
		System.out.print("Publisher number of books "+pub.getBooks().size());
	}

}
