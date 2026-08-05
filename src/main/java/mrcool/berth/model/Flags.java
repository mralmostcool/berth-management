package mrcool.berth.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "flags")
public class Flags {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Size(max = 255, message = "Name must be less than 255 characters")
    @NotNull(message = "Name is required")
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 3, message = "ISO code must be less than 3 characters")
    @NotNull(message = "ISO code is required")
    @Column(name = "iso_code", nullable = false)
    private String isoCode;

    @Size(max = 10, message = "IMO flag code must be less than 10 characters")
    @Column(name = "imo_flag_code", nullable = false)
    private String imoFlagCode;

}