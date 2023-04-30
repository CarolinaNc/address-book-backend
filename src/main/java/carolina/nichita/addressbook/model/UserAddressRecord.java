package carolina.nichita.addressbook.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record UserAddressRecord(String id,
                                String fullName,
                                @NotEmpty(message = "Address is required")
                          String address,
                                String city,
                                String state,
                                @NotEmpty(message = "Zip code is required")
                         String zip,
                                @Email(message = "Invalid email")
                         String email,
                                String phone) {
}
