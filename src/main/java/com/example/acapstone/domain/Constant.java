package com.example.acapstone.domain;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


@Entity
//@Table(name="constant")
@Table(name="test")
public class Constant {
	@Id
	public String stringName;
	public String stringValue;
	public int charLimit;
	public String url;
	@Lob
	private byte[] picByte;
	
	public void updateValue(String value) {
		this.stringValue = value;
	}
	
	public void updateUrl(String newUrl) {
		this.url = newUrl;
	}
	
	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}
}
