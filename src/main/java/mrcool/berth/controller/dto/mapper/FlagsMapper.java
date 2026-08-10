package mrcool.berth.controller.dto.mapper;

import mrcool.berth.controller.dto.request.FlagsRequestDTO;
import mrcool.berth.controller.dto.response.FlagsResponseDTO;
import mrcool.berth.model.Flags;

public class FlagsMapper {

    public static FlagsResponseDTO toDTO(Flags flag) {
        return FlagsResponseDTO.builder()
                .id(flag.getId())
                .name(flag.getName())
                .isoCode(flag.getIsoCode())
                .imoFlagCode(flag.getImoFlagCode())
                .build();
    }

    public static Flags toEntity(FlagsRequestDTO dto) {
        return Flags.builder()
                .name(dto.getName())
                .isoCode(dto.getIsoCode())
                .imoFlagCode(dto.getImoFlagCode())
                .build();
    }

}