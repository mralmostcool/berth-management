package mrcool.berth.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mrcool.berth.models.Flags;

@Repository
public interface FlagsRepository extends JpaRepository<Flags, UUID> {

    public String findNameById(UUID id);

}
