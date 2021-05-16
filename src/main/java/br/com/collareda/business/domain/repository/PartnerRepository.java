package br.com.collareda.business.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.collareda.business.domain.model.PartnerEntity;

@Repository
public interface PartnerRepository extends JpaRepository<PartnerEntity , Long>{

	List<PartnerEntity> findByPrincipalName (String principalName);
	List<PartnerEntity> findByPrincipalNameContaining(String principalName);
	PartnerEntity findByEmail(String email);
}
