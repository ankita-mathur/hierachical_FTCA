package com.base;
/* This class describes a snippet in the clustering system
 * A snippet has three components:
 * title- the title of web page the snippet belongs to
 * text- the snippet text
 * url- the url of the web page*/


public class Snippet {
	String title, text, url;
	public Snippet()
	{
		title=null;
		text=null;
		url=null;
	}
	public Snippet(String title, String text, String url)
	{
		this.title=title;
		this.text=text;
		this.url=url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	

}
