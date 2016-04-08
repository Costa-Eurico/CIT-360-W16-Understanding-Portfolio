package com.cit360.mpfinder.client.model;

import java.util.Date;

public class Note {
	private int note_record_id;
	private int person_record_id;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author_email == null) ? 0 : author_email.hashCode());
		result = prime * result + ((author_made_contact == null) ? 0 : author_made_contact.hashCode());
		result = prime * result + ((author_name == null) ? 0 : author_name.hashCode());
		result = prime * result + ((author_phone == null) ? 0 : author_phone.hashCode());
		result = prime * result + ((email_of_found_person == null) ? 0 : email_of_found_person.hashCode());
		result = prime * result + ((entry_date == null) ? 0 : entry_date.hashCode());
		result = prime * result + ((last_known_location == null) ? 0 : last_known_location.hashCode());
		result = prime * result + note_record_id;
		result = prime * result + person_record_id;
		result = prime * result + ((phone_of_found_person == null) ? 0 : phone_of_found_person.hashCode());
		result = prime * result + ((photo_url == null) ? 0 : photo_url.hashCode());
		result = prime * result + ((source_data == null) ? 0 : source_data.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		if (author_email == null) {
			if (other.author_email != null)
				return false;
		} else if (!author_email.equals(other.author_email))
			return false;
		if (author_made_contact == null) {
			if (other.author_made_contact != null)
				return false;
		} else if (!author_made_contact.equals(other.author_made_contact))
			return false;
		if (author_name == null) {
			if (other.author_name != null)
				return false;
		} else if (!author_name.equals(other.author_name))
			return false;
		if (author_phone == null) {
			if (other.author_phone != null)
				return false;
		} else if (!author_phone.equals(other.author_phone))
			return false;
		if (email_of_found_person == null) {
			if (other.email_of_found_person != null)
				return false;
		} else if (!email_of_found_person.equals(other.email_of_found_person))
			return false;
		if (entry_date == null) {
			if (other.entry_date != null)
				return false;
		} else if (!entry_date.equals(other.entry_date))
			return false;
		if (last_known_location == null) {
			if (other.last_known_location != null)
				return false;
		} else if (!last_known_location.equals(other.last_known_location))
			return false;
		if (note_record_id != other.note_record_id)
			return false;
		if (person_record_id != other.person_record_id)
			return false;
		if (phone_of_found_person == null) {
			if (other.phone_of_found_person != null)
				return false;
		} else if (!phone_of_found_person.equals(other.phone_of_found_person))
			return false;
		if (photo_url == null) {
			if (other.photo_url != null)
				return false;
		} else if (!photo_url.equals(other.photo_url))
			return false;
		if (source_data == null) {
			if (other.source_data != null)
				return false;
		} else if (!source_data.equals(other.source_data))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Note [note_record_id=" + note_record_id + ", person_record_id=" + person_record_id
				+ ", entry_date=" + entry_date
				+ ", author_name=" + author_name + ", author_email=" + author_email + ", author_phone=" + author_phone
				+ ", source_data=" + source_data + ", status=" + status + ", author_made_contact=" + author_made_contact
				+ ", email_of_found_person=" + email_of_found_person + ", phone_of_found_person="
				+ phone_of_found_person + ", last_known_location=" + last_known_location + ", text=" + text
				+ ", photo_url=" + photo_url + "]";
	}
	
	
	
}
