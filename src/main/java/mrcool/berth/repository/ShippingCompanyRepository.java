package mrcool.berth.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mrcool.berth.model.ShippingCompany;

@Repository
public interface ShippingCompanyRepository extends JpaRepository<ShippingCompany, UUID> {

}
