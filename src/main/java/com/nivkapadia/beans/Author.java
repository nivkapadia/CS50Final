package com.nivkapadia.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Author {
	@NonNull
	private int authorId;
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
}
