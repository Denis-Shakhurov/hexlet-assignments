package exercise.dto;

// BEGIN
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Digits;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter
public class GuestCreateDTO {

    @NotNull
    private String name;
    
    @Email
    @NotBlank
    private String email;
    
    @Pattern(regexp = "^[+][0-9]{11,13}")
    private String phoneNumber;
    
    @Size(min = 4, max = 4)
    //@Digits
    private String clubCard;
    
    @Future
    private LocalDate cardValidUntil;
}
// END
