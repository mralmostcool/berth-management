package mrcool.berth.controller.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlagsRequestDTO {

    @Size(max = 255, message = "Name must be less that 255 characters")
    @NotNull(message = "Name is required")
    private String name;

    @Size(max = 3, message = "ISO code must be less than 3 characters")
    @NotNull(message = "ISO code is required")
    private String isoCode;

    @Size(max = 10, message = "IMO flag code must be less than 10 characters")
    @NotNull(message = "IMO flag code is required")
    private String imoFlagCode;

}
