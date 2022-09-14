package phoneBook;

public class ContactData extends Address {
	private String phoneNum;
	
	public String getPhoneNum() {
		return "(" + phoneNum.charAt(1) + phoneNum.charAt(2) +
				phoneNum.charAt(3) + ")-" + phoneNum.charAt(4) +
				phoneNum.charAt(5) + phoneNum.charAt(6) + "-" +
				phoneNum.charAt(7) + phoneNum.charAt(8) + 
				phoneNum.charAt(9) + phoneNum.charAt(10);	
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public ContactData(String name, String streetAddress, String city, String state, String zipCode, String phoneNum) {
		super(name, streetAddress, city, state, zipCode);
		this.phoneNum = phoneNum;
	}
	@Override
	public String toString() {
		return getName() + "," 
				+ getStreetAddress() +"," + getCity() + "," + getState()+
				"," + getZipCode() + ", " + getPhoneNum();
	}
}