package mrcool.berth.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mrcool.berth.model.Allocation;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, UUID> {

}
