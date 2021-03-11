package com.example.acapstone.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="constant")
public class Constant {
	@Id
	public String stringName;
	public String stringValue;
	public int charLimit;
	
	public void updateValue(String value) {
		this.stringValue = value;
	}


}
