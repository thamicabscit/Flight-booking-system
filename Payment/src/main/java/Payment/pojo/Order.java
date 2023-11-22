package Payment.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection="payment")
public class Order {

	private double price;
	private String currency;
	private String method;
	private String intent;
	private String description;
	public String getIntent() {
		// TODO Auto-generated method stub
		return null;
	}
	public Double getPrice() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getCurrency() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getMethod() {
		// TODO Auto-generated method stub
		return null;
	}
	

}