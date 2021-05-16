package br.com.collareda.business.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.collareda.business.domain.model.ServiceBranchEntity;

@Repository
public interface ServiceBranchRepository extends JpaRepository<ServiceBranchEntity, Long> {

	public List<ServiceBranchEntity> findByIdService(Long idService);
	
	@Modifying
	@Transactional
	@Query("UPDATE ServiceBranchEntity sb SET sb.idService = :idService WHERE sb.id = :id ")
	public void updateIdService(@Param("idService")Long idService , @Param("id") Long id);
	
}
