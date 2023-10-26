package mx.towers.suppliers.model.dto;

import java.util.HashMap;

import mx.towers.suppliers.model.Account;
import mx.towers.suppliers.model.Types;

public class AccountDTO {


    private String id;

    private String name;

    private String taxid;

    private String address;

    private String address2;

    private String city;

    private String state;

    private String countryId;

    private String zip;

    private String phone;

    private String mobile;

    private String email;

    private String website;

    private String notes;
    
    private String accountType;

    private String status;
 
    public AccountDTO(HashMap<String, String> data) {
		// TODO Auto-generated constructor stub
	}

	public AccountDTO() {
		// TODO Auto-generated constructor stub
	}
    // Getters, setters, equals, hashCode, and toString methods...

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaxid() {
		return taxid;
	}

	public void setTaxid(String taxid) {
		this.taxid = taxid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Account toAcccount(Types type) {
		
		System.out.println("Received object: " + this.toString());
		
		Account account = new Account();
    	account.setName(this.getName());
    	account.setTaxid(this.getTaxid());
    	account.setPhone(this.getPhone());
    	account.setEmail(this.getEmail());
    	
    	account.setWebsite(this.getWebsite());
    	
    	account.setNotes(this.getNotes());
    	account.setAddress(this.getAddress());
    	account.setAddress2(this.getAddress2());
    	account.setCity(this.getCity());
    	account.setState(this.getState());
    	account.setZip(this.getZip());
    	account.setCountryId(Integer.parseInt(this.getCountryId()));
    	
    	account.setAccountType(2);
		account.setStatus(type);

		return account;
	}

	@Override
	public String toString() {
		return "AccountDTO [id=" + id + ", name=" + name + ", taxid=" + taxid + ", address=" + address + ", address2="
				+ address2 + ", city=" + city + ", state=" + state + ", countryId=" + countryId + ", zip=" + zip
				+ ", phone=" + phone + ", mobile=" + mobile + ", email=" + email + ", website=" + website + ", notes="
				+ notes + ", accountType=" + accountType + ", status=" + status + "]";
	}

}
