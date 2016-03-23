package org.issat.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class News  implements Serializable{

	
	private static final long serialVersionUID = -8898639370560866707L;
	@Id
	@GeneratedValue
	private Long id;
	
	private String url;
	
	private String title;
	
	private String abstracts;
	
	private String publisheddate;
	
	private String byline;
	
	private String caption;
	
	private String urlimage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAbstracts() {
		return abstracts;
	}

	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}

	public String getPublisheddate() {
		return publisheddate;
	}

	public void setPublisheddate(String publisheddate) {
		this.publisheddate = publisheddate;
	}

	public String getByline() {
		return byline;
	}

	public void setByline(String byline) {
		this.byline = byline;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getUrlimage() {
		return urlimage;
	}

	public void setUrlimage(String urlimage) {
		this.urlimage = urlimage;
	}

	public News(String url, String title, String abstracts,
			String publisheddate, String byline, String caption, String urlimage) {
		super();
		this.url = url;
		this.title = title;
		this.abstracts = abstracts;
		this.publisheddate = publisheddate;
		this.byline = byline;
		this.caption = caption;
		this.urlimage = urlimage;
	}

	public News() {
		// TODO Auto-generated constructor stub
	}
	
}
