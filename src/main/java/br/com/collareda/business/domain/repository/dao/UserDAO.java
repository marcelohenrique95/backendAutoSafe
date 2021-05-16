package br.com.collareda.business.domain.repository.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.collareda.business.domain.dto.UserFilterDTO;
import br.com.collareda.business.domain.model.UserEntity;

@Repository
public class UserDAO {

	@PersistenceContext
    public EntityManager em;
	
	public List<UserEntity> findUserByFilter(UserFilterDTO userFilterDTO) {
		Query q = em.createQuery(queryFindUserByFilter(userFilterDTO));
		if(userFilterDTO.getName() != null && !userFilterDTO.getName().isEmpty()) {
			q.setParameter("nameFilter", "%" + userFilterDTO.getName() + "%");
		}
		if(userFilterDTO.getActive() != null) {
			q.setParameter("activeFilter", userFilterDTO.getActive());
		}
		List<UserEntity> listUsers = q.getResultList();
		return listUsers;
	}
	
	private String queryFindUserByFilter(UserFilterDTO userFilterDTO) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ue FROM UserEntity ue ");
		sql.append(" WHERE 1=1");
		if(userFilterDTO.getName() != null && !userFilterDTO.getName().isEmpty()) {
			sql.append(" AND ue.name LIKE :nameFilter ");			
		}
		if(userFilterDTO.getActive() != null) {
			sql.append(" AND ue.active = :activeFilter");			
		}
		return sql.toString();
	}
}
