package com.mpfinder.model;

import java.util.Date;
public class Note {
	private int note_record_id;
	private int person_record_id;
	private int linked_person_record_id;
	private Date entry_date;
	private String author_name;
	private String author_email;
	private String author_phone;
	private String source_data;
	private String status;
	private Boolean author_made_contact;
	private String email_of_found_person;
	private String phone_of_found_person;
	private String last_known_location;
	private String text;
	private String photo_url;
	
	public int getNoteRecordId() {
		return note_record_id;
	}
	public void setNoteRecordId(int note_record_id) {
		this.note_record_id = note_record_id;
	}
	public int getPersonRecordId() {
		return person_record_id;
	}
	public void setPersonRecordId(int person_record_id) {
		this.person_record_id = person_record_id;
	}
	public int getLinkedPersonRecordId() {
		return linked_person_record_id;
	}
	public void setLinkedPersonRecordId(int linked_person_record_id) {
		this.linked_person_record_id = linked_person_record_id;
	}
	public Date getEntryDate() {
		return entry_date;
	}
	public void setEntryDate(Date entry_date) {
		this.entry_date = entry_date;
	}
	public String getAuthorName() {
		return author_name;
	}
	public void setAuthorName(String author_name) {
		this.author_name = author_name;
	}
	public String getAuthorEmail() {
		return author_email;
	}
	public void setAuthorEmail(String author_email) {
		this.author_email = author_email;
	}
	public String getAuthorPhone() {
		return author_phone;
	}
	public void setAuthorPhone(String author_phone) {
		this.author_phone = author_phone;
	}
	public String getSourceData() {
		return source_data;
	}
	public void setSourceData(String source_data) {
		this.source_data = source_data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Boolean getAuthorMadeContact() {
		return author_made_contact;
	}
	public void setAuthorMadeContact(Boolean author_made_contact) {
		this.author_made_contact = author_made_contact;
	}
	public String getEmailOfFoundPerson() {
		return email_of_found_person;
	}
	public void setEmailOfFoundPerson(String email_of_found_person) {
		this.email_of_found_person = email_of_found_person;
	}
	public String getPhoneOfFoundPerson() {
		return phone_of_found_person;
	}
	public void setPhoneOfFoundPerson(String phone_of_found_person) {
		this.phone_of_found_person = phone_of_found_person;
	}
	public String getLastKnownLocation() {
		return last_known_location;
	}
	public void setLastKnownLocation(String last_known_location) {
		this.last_known_location = last_known_location;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getPhotoUrl() {
		return photo_url;
	}
	public void setPhotoUrl(String photo_url) {
		this.photo_url = photo_url;
	}
	
}
