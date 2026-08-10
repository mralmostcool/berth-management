package mrcool.berth.controller.dto.response;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlagsResponseDTO {

    private UUID id;
    private String name;
    private String isoCode;
    private String imoFlagCode;

}