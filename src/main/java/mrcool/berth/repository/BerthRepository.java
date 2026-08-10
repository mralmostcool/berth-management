package mrcool.berth.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mrcool.berth.model.Berth;

@Repository
public interface BerthRepository extends JpaRepository<Berth, UUID> {

}
