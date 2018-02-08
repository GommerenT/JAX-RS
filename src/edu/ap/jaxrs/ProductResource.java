package edu.ap.jaxrs;

import java.nio.file.Files;
import java.nio.file.Paths;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.servlet.ServletContext;

@Path("/products")
public class ProductResource {
	
	private String FILE;
	
	public ProductResource(@Context ServletContext servletContext) {
		FILE = servletContext.getInitParameter("FILE_PATH");
	}
	
	@GET
	@Produces({"text/html"})
	public String getProductsHTML() {
		
		return "<html><body><h1>TEST</h1></body></html>";
	}
	
	@GET
	@Produces({"application/json"})
	public String getProductsJSON() {
		String jsonString = "";
		try {
			jsonString = new String(Files.readAllBytes(Paths.get(FILE)));
		} 
		catch (Exception ex) {
			jsonString = ex.getMessage();
		}
		
		return jsonString;
	}
}