package mrcool.berth.model;

import java.time.OffsetDateTime;
import java.util.UUID;

import mrcool.berth.model.enums.ContractAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "contract_log")
public class ContractLog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @NotNull(message = "Contract ID is required")
    @Column(name = "contract_id", nullable = false)
    private UUID contractId;

    @NotNull(message = "Allocation ID is required")
    @Column(name = "allocation_id", nullable = false)
    private UUID allocationId;

    @Enumerated(EnumType.STRING)
    @Column(name = "action")
    private ContractAction action;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = OffsetDateTime.now();
    }
}
