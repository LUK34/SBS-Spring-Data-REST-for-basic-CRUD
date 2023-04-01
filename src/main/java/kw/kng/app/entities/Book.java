package kw.kng.app.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "book_tbl")
@Data
public class Book 
{
	@Id
	private Integer id;
	private String name;
	private Double price;

}
/*
 {
 	"id":"1",
 	"name":"SQL",
 	"price":"1000.00"
 }
 */
