package kw.kng.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import kw.kng.app.entities.Book;

@RepositoryRestResource(path = "books")
public interface BookRepository extends JpaRepository<Book, Integer>
{
	public List<Book> findByNameContaining(@Param("name") String name);

}


/*
1. If there are many controller classes + service layer that has RestController annotation which is accessing basic CRUD operations.
Then that many number of times we have to write boiler plate CRUD code for each and every classes. 
To avoid boiler plate code we are using @RepositoryRestResource

2. @RepositoryRestResource will only allow basic CRUD operations to be implemented for all classes
with using service layer and controller layer. You just need to define the entity class and a repository layer as shown above.

3. If you have custom queries then and only then u have to define @Query and use a service layer.
If you want to implement basic crud operations without any boilerplate code then this is what you must do.


----------------------------------------------------------------------------------------------------------------------------
POSTMAN:
1. Select dropdown POST
1.1 Link: localhost:8080/books
1.2 Add the below code in body
 {
     "id":"1",
 	"name":"Adv DBA",
 	"price":"1500.00"
 }

2.  Select dropdown GET
2.1 Link: localhost:8080/books/1
2.2 Click on "Send" you will get the output in POSTMAN console.

3.  Select dropdown PUT
3.1 Link: localhost:8080/books/1
3.2 Click on "Send" you will get the output in POSTMAN console as " 405 Method Not Allowed"
3.3 This means that the configuration file is performing its function.

4.  Select dropdown DELETE
4.1 Link: localhost:8080/books/1
4.2 Click on "Send" you will get the output in POSTMAN console as " 405 Method Not Allowed"
4.3 This means that the configuration file is performing its function.

*/