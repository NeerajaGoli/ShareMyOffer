

import java.util.List;

import javax.validation.constraints.NotNull;

import com.neeraja.ShareMyOffer.entities.Address;
import com.neeraja.ShareMyOffer.entities.Offer;
import com.neeraja.ShareMyOffer.validator.ValidEmail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
	
	@NotNull(message = "is required")
	private int id;
	
	@NotNull(message = "is required")
	private String firstName;
	
	@NotNull(message = "is required")
	private String lastName;
	
	@NotNull(message = "is required")
	private String dateOfBirth;
	
	@NotNull(message = "is required")
	private String mobileNumber;
	
	@ValidEmail(message = "is invalid")
	@NotNull(message = "is required")
	private String email;
	
	@NotNull(message = "is required")
	private int rating;
	
	private Address address;
	
	private List<Offer> offers;
}

