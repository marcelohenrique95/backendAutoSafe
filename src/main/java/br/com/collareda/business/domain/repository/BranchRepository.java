package br.com.collareda.business.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.collareda.business.domain.model.BranchEntity;

@Repository
public interface BranchRepository extends JpaRepository<BranchEntity, Long> {

	List<BranchEntity> findByDescription(String description);

	List<BranchEntity> findByDescriptionContaining(String description);

}
