package com.cit360.mpfinder.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

public class Person {
	
	private int person_record_id;
	private Date entry_date;
	private Date expiry_date;
	private String author_name;
	private String author_email;
	private String author_phone;
	private String source_name;
	private String source_url;
	private Date source_date;
	private String full_name;
	private String given_name;
	private String family_name;
	private String alternate_names;
	private String description;
	private String sex;
	private Date dob;
	private int age;
	private String home_street;
	private String home_neighborhood;
	private String home_city;
	private String home_state;
	private String home_postal_code;
	private String home_country;
	private String photo_url;
	private String profile_url;
	private Set<Note> notes; 
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "note")
	public Set<Note> getNotes() {
		return this.notes;
	}
	
	public void setNotes(Set<Note> notes) {
		this.notes = notes;
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
	public Date getExpiryDate() {
		return expiry_date;
	}
	public void setExpiryDate(Date expiry_date) {
		this.expiry_date = expiry_date;
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
	public String getSourceName() {
		return source_name;
	}
	public void setSourceName(String source_name) {
		this.source_name = source_name;
	}
	public String getSourceUrl() {
		return source_url;
	}
	public void setSourceUrl(String source_url) {
		this.source_url = source_url;
	}
	public Date getSourceDate() {
		return source_date;
	}
	public void setSourceDate(Date source_date) {
		this.source_date = source_date;
	}
	public String getFullName() {
		return full_name;
	}
	public void setFullName(String full_name) {
		this.full_name = full_name;
	}
	public String getGivenName() {
		return given_name;
	}
	public void setGivenName(String given_name) {
		this.given_name = given_name;
	}
	public String getFamilyName() {
		return family_name;
	}
	public void setFamilyName(String family_name) {
		this.family_name = family_name;
	}
	public String getAlternateNames() {
		return alternate_names;
	}
	public void setAlternateNames(String alternate_names) {
		this.alternate_names = alternate_names;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getDateOfBirth() {
		return dob;
	}
	public void setDateOfBirth(Date dob) {
		this.dob = dob;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getHomeStreet() {
		return home_street;
	}
	public void setHomeStreet(String home_street) {
		this.home_street = home_street;
	}
	public String getHomeNeighborhood() {
		return home_neighborhood;
	}
	public void setHomeNeighborhood(String home_neighborhood) {
		this.home_neighborhood = home_neighborhood;
	}
	public String getHomeCity() {
		return home_city;
	}
	public void setHomeCity(String home_city) {
		this.home_city = home_city;
	}
	public String getHomeState() {
		return home_state;
	}
	public void setHomeState(String home_state) {
		this.home_state = home_state;
	}
	public String getHomePostalCode() {
		return home_postal_code;
	}
	public void setHomePostalCode(String home_postal_code) {
		this.home_postal_code = home_postal_code;
	}
	public String getHomeCountry() {
		return home_country;
	}
	public void setHomeCountry(String home_country) {
		this.home_country = home_country;
	}
	public String getPhotoUrl() {
		return photo_url;
	}
	public void setPhotoUrl(String photo_url) {
		this.photo_url = photo_url;
	}
	public String getProfileUrl() {
		return profile_url;
	}
	public void setProfileUrl(String profile_url) {
		this.profile_url = profile_url;
	}
	
	@Override
	public String toString() {
		return "Person [person_record_id=" + person_record_id + ", entry_date=" + entry_date + ", expiry_date="
				+ expiry_date + ", author_name=" + author_name + ", author_email=" + author_email + ", author_phone="
				+ author_phone + ", source_name=" + source_name + ", source_url=" + source_url + ", source_date="
				+ source_date + ", full_name=" + full_name + ", given_name=" + given_name + ", family_name="
				+ family_name + ", alternate_names=" + alternate_names + ", description=" + description + ", sex=" + sex
				+ ", dob=" + dob + ", age=" + age + ", home_street=" + home_street + ", home_neighborhood="
				+ home_neighborhood + ", home_city=" + home_city + ", home_state=" + home_state + ", home_postal_code="
				+ home_postal_code + ", home_country=" + home_country + ", photo_url=" + photo_url + ", profile_url="
				+ profile_url + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((alternate_names == null) ? 0 : alternate_names.hashCode());
		result = prime * result + ((author_email == null) ? 0 : author_email.hashCode());
		result = prime * result + ((author_name == null) ? 0 : author_name.hashCode());
		result = prime * result + ((author_phone == null) ? 0 : author_phone.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((entry_date == null) ? 0 : entry_date.hashCode());
		result = prime * result + ((expiry_date == null) ? 0 : expiry_date.hashCode());
		result = prime * result + ((family_name == null) ? 0 : family_name.hashCode());
		result = prime * result + ((full_name == null) ? 0 : full_name.hashCode());
		result = prime * result + ((given_name == null) ? 0 : given_name.hashCode());
		result = prime * result + ((home_city == null) ? 0 : home_city.hashCode());
		result = prime * result + ((home_country == null) ? 0 : home_country.hashCode());
		result = prime * result + ((home_neighborhood == null) ? 0 : home_neighborhood.hashCode());
		result = prime * result + ((home_postal_code == null) ? 0 : home_postal_code.hashCode());
		result = prime * result + ((home_state == null) ? 0 : home_state.hashCode());
		result = prime * result + ((home_street == null) ? 0 : home_street.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + person_record_id;
		result = prime * result + ((photo_url == null) ? 0 : photo_url.hashCode());
		result = prime * result + ((profile_url == null) ? 0 : profile_url.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((source_date == null) ? 0 : source_date.hashCode());
		result = prime * result + ((source_name == null) ? 0 : source_name.hashCode());
		result = prime * result + ((source_url == null) ? 0 : source_url.hashCode());
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
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (alternate_names == null) {
			if (other.alternate_names != null)
				return false;
		} else if (!alternate_names.equals(other.alternate_names))
			return false;
		if (author_email == null) {
			if (other.author_email != null)
				return false;
		} else if (!author_email.equals(other.author_email))
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
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (entry_date == null) {
			if (other.entry_date != null)
				return false;
		} else if (!entry_date.equals(other.entry_date))
			return false;
		if (expiry_date == null) {
			if (other.expiry_date != null)
				return false;
		} else if (!expiry_date.equals(other.expiry_date))
			return false;
		if (family_name == null) {
			if (other.family_name != null)
				return false;
		} else if (!family_name.equals(other.family_name))
			return false;
		if (full_name == null) {
			if (other.full_name != null)
				return false;
		} else if (!full_name.equals(other.full_name))
			return false;
		if (given_name == null) {
			if (other.given_name != null)
				return false;
		} else if (!given_name.equals(other.given_name))
			return false;
		if (home_city == null) {
			if (other.home_city != null)
				return false;
		} else if (!home_city.equals(other.home_city))
			return false;
		if (home_country == null) {
			if (other.home_country != null)
				return false;
		} else if (!home_country.equals(other.home_country))
			return false;
		if (home_neighborhood == null) {
			if (other.home_neighborhood != null)
				return false;
		} else if (!home_neighborhood.equals(other.home_neighborhood))
			return false;
		if (home_postal_code == null) {
			if (other.home_postal_code != null)
				return false;
		} else if (!home_postal_code.equals(other.home_postal_code))
			return false;
		if (home_state == null) {
			if (other.home_state != null)
				return false;
		} else if (!home_state.equals(other.home_state))
			return false;
		if (home_street == null) {
			if (other.home_street != null)
				return false;
		} else if (!home_street.equals(other.home_street))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (person_record_id != other.person_record_id)
			return false;
		if (photo_url == null) {
			if (other.photo_url != null)
				return false;
		} else if (!photo_url.equals(other.photo_url))
			return false;
		if (profile_url == null) {
			if (other.profile_url != null)
				return false;
		} else if (!profile_url.equals(other.profile_url))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (source_date == null) {
			if (other.source_date != null)
				return false;
		} else if (!source_date.equals(other.source_date))
			return false;
		if (source_name == null) {
			if (other.source_name != null)
				return false;
		} else if (!source_name.equals(other.source_name))
			return false;
		if (source_url == null) {
			if (other.source_url != null)
				return false;
		} else if (!source_url.equals(other.source_url))
			return false;
		return true;
	}
	
	
}
