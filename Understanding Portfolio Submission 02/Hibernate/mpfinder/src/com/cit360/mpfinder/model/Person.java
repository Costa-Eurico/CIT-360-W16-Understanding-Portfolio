package com.cit360.mpfinder.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	private List<Note> notes = new ArrayList<Note>(0); 
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "note")
	public List<Note> getNotes() {
		return this.notes;
	}
	
	public void setNotes(List<Note> notes) {
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
}
