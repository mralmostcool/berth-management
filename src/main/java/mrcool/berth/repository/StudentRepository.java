package mrcool.berth.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mrcool.berth.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

}
