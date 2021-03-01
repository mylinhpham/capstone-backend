package com.example.acapstone.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "constants")
@Table
public class Constant {
	@Id
	public String name;
	public String value;
	public int charLimit;

}
