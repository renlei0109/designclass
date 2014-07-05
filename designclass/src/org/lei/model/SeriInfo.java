package org.lei.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class SeriInfo implements Serializable{
	private String id;
	private String description;
	private String serial;
	private int quality;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	
	@Override
	public String toString() {
		return "SeriInfo [id=" + id + ", description=" + description
				+ ", serial=" + serial + ", quality=" + quality + "]";
	}
	
	public SeriInfo(String id, String description, String serial, int quality) {
		super();
		this.id = id;
		this.description = description;
		this.serial = serial;
		this.quality = quality;
	}
	
	public SeriInfo() {
		super();
	}
	
	
	
}
