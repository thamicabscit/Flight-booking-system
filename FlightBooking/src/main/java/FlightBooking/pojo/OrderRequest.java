package FlightBooking.pojo;

import lombok.Data;

@Data
public class OrderRequest {
    private String userName;
    private String customerName;
    private String email;
    private String phoneNumber;
    private int amount;

    public OrderRequest() {
	super();
	// TODO Auto-generated constructor stub
    }

    public OrderRequest(String userName, String customerName, String email, String phoneNumber, int amount) {
	super();
	this.userName = userName;
	this.customerName = customerName;
	this.email = email;
	this.phoneNumber = phoneNumber;
	this.amount = amount;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public String getCustomerName() {
	return customerName;
    }

    public void setCustomerName(String customerName) {
	this.customerName = customerName;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPhoneNumber() {
	return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
    }

    public int getAmount() {
	return amount;
    }

    public void setAmount(int amount) {
	this.amount = amount;
    }

    @Override
    public String toString() {
	return "OrderRequest [userName=" + userName + ", customerName=" + customerName + ", email=" + email
		+ ", phoneNumber=" + phoneNumber + ", amount=" + amount + "]";
    }

}