package mrcool.berth.model;

import java.time.OffsetDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
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
@Table(name = "allocation")
public class Allocation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @NotNull(message = "Contract ID is required")
    @Column(name = "contract_id", nullable = false)
    private UUID contractId;

    @NotNull(message = "Student ID is required")
    @Column(name = "student_id", nullable = false)
    private UUID studentId;

    @NotNull(message = "Berth ID is required")
    @Column(name = "berth_id", nullable = false)
    private UUID berthId;

    @NotNull(message = "Status is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AllocationStatus status;

    @Column(name = "planned_start_date")
    private OffsetDateTime plannedStartDate;

    @Column(name = "planned_end_date")
    private OffsetDateTime plannedEndDate;

    @Column(name = "sign_on_date")
    private OffsetDateTime signOnDate;

    @Column(name = "sign_off_date")
    private OffsetDateTime signOffDate;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @NotNull
    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = OffsetDateTime.now();
        this.updatedAt = OffsetDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = OffsetDateTime.now();
    }
}
