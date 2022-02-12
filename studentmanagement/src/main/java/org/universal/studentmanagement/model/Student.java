package org.universal.studentmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

	private String name;
	private String favSubject;
	private String gender;
	private String dob;
	private String address;

}
