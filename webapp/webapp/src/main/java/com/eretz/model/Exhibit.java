package com.eretz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "EXHIBIT")
public class Exhibit {
	private Long exhibitId;
	private String name;
	private String description;
	private String content;
	private Long imageId;
	private String soundUrl;
	private int tourOrder;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	public Long getExhibitId() {
		return exhibitId;
	}

	public void setExhibitId(Long id) {
		this.exhibitId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	public String getSoundUrl() {
		return soundUrl;
	}

	public void setSoundUrl(String soundUrl) {
		this.soundUrl = soundUrl;
	}

	public int getTourOrder() {
		return tourOrder;
	}

	public void setTourOrder(int order) {
		this.tourOrder = order;
	}

	@Lob
	@Type(type = "org.hibernate.type.TextType")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
