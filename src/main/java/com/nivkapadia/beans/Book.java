package com.nivkapadia.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {
	
	private int bookId;
	private String title;
	private String isbn;
}
