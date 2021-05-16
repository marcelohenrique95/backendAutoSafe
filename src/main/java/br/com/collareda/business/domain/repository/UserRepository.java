package br.com.collareda.business.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.collareda.business.domain.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	List<UserEntity> findByName(String name);
	
	List<UserEntity> findByNameContaining(String name);
	
	@Query(value = "SELECT ue FROM UserEntity ue WHERE ue.email = ?1 and ue.active = true")
	UserEntity findByEmail(String email);
	
	@Query(value = "SELECT ue FROM UserEntity ue WHERE ue.email = ?1 and ue.active = true")
	List<UserEntity> listByEmail(String email);
	
	List<UserEntity> findByIdPartner(Long idPartner);	
	

}
