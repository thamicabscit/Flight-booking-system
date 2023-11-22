package FlightBooking.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "razorpay")
public class RazorPayClientConfig {
    private String key;
    private String secret;

    public RazorPayClientConfig() {
	super();
	// TODO Auto-generated constructor stub
    }

    public RazorPayClientConfig(String key, String secret) {
	super();
	this.key = key;
	this.secret = secret;
    }

    public String getKey() {
	return key;
    }

    public void setKey(String key) {
	this.key = key;
    }

    public String getSecret() {
	return secret;
    }

    public void setSecret(String secret) {
	this.secret = secret;
    }

    @Override
    public String toString() {
	return "RazorPayClientConfig [key=" + key + ", secret=" + secret + "]";
    }

}
