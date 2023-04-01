package kw.kng.app.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import kw.kng.app.entities.Book;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
	
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

		HttpMethod[] unsupportedMethods = { HttpMethod.PUT, HttpMethod.DELETE };
		
		config.getExposureConfiguration()
			  .forDomainType(Book.class)
			  .withItemExposure((metadata, http) -> http.disable(unsupportedMethods))
			  .withCollectionExposure((metadata,http) -> http.disable(unsupportedMethods));
		
	}
}


/*
1.  @RepositoryRestResource will only allow basic CRUD operations to be implemented for all classes
2. But if the client is requesting only to read the data from API or if the client is asking for custom
configuration then we must use the above logic. The above logic will block the user from Updating and deleting any 
record via POSTMAN. This will only allow to GET,POST.

3. Here's a brief overview of the code:

3.1 Import statements: Import the necessary classes and interfaces from the Spring Framework.
3.2 @Configuration: This annotation informs Spring that this class is a configuration class that can be used to configure the application's behavior.
3.3 MyDataRestConfig class: The custom configuration class that implements the RepositoryRestConfigurer interface.
3.4 configureRepositoryRestConfiguration method: Override this method to configure the RepositoryRestConfiguration and CorsRegistry objects.
3.5 unsupportedMethods array: Defines an array of HTTP methods that should be disabled, in this case, PUT and DELETE.
3.6 config.getExposureConfiguration(): Access the exposure configuration of the RepositoryRestConfiguration.
3.7 forDomainType(Book.class): Specify that the configuration applies to the Book domain type.
3.8 withItemExposure(...): Configure the item exposure (individual resources) by disabling the unsupported HTTP methods.
3.9 withCollectionExposure(...): Configure the collection exposure (collection of resources) by disabling the unsupported HTTP methods.

4.This configuration ensures that the PUT and DELETE methods are disabled for both individual and collection resources of the Book entity, preventing users from modifying or deleting data related to books.

*/