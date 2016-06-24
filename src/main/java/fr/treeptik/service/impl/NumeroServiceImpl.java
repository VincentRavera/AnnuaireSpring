package fr.treeptik.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.exception.DAOException;
import fr.treeptik.dao.interf.NumeroDAO;
import fr.treeptik.pojo.Numero;
import fr.treeptik.pojo.Personne;
import fr.treeptik.service.exception.ServiceException;
import fr.treeptik.service.interf.NumeroService;
import fr.treeptik.service.interf.PersonneService;

public class NumeroServiceImpl implements NumeroService{
	
	private NumeroDAO numeroDAO;
	private PersonneService servPersonne;

	public PersonneService getServPersonne() {
		return servPersonne;
	}

	public void setServPersonne(PersonneService servPersonne) {
		this.servPersonne = servPersonne;
	}

	public void setNumeroDAO(NumeroDAO numeroDAO) {
		this.numeroDAO = numeroDAO;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Numero add(Numero entity) throws ServiceException {
		try {
			List<Personne> lp = entity.getPersonnes();
			List<Numero> ln = new ArrayList<>();
			
			if (!lp.isEmpty()) {
				for (Personne personne : lp) {
					personne.setNumero(ln);
					servPersonne.add(personne);
				}
			}
			return entity;
			
		} catch (DAOException e) {
			throw new ServiceException(
					"Erreur NumeroService add(Numero)"+e.getMessage(), e);
		}
	}

	@Override
	@Transactional
	public void remove(Numero entity) throws ServiceException {
		try {
			entity = this.findById(entity.getId());
			numeroDAO.remove(entity);
			
		} catch (DAOException e) {
			throw new ServiceException(
					"Erreur NumeroService remove(Numero)"+e.getMessage(), e);
		}
		
	}

	@Override
	@Transactional
	public Numero update(Numero entity) throws ServiceException {
		try {
			Numero num = numeroDAO.update(entity);
			return num;
			
		} catch (DAOException e) {
			throw new ServiceException(
					"Erreur NumeroService update(Numero)"+e.getMessage(), e);
		}
		
	}

	@Override
	public List<Numero> findAll() throws ServiceException {
		try {
			return numeroDAO.find(null);
		} catch (DAOException e) {
			throw new ServiceException(
					"Erreur NumeroService findAll()"+e.getMessage(), e);
		}
	}

	@Override
	public List<Numero> findByTel(String tel) throws ServiceException {
		try {
			return numeroDAO.findByTel(tel);
		} catch (DAOException e) {
			throw new ServiceException(
					"Erreur NumeroService findByTel(String)"+e.getMessage(), e);
		}
	}

	@Override
	public List<Numero> findByType(String type) throws ServiceException {
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("type", type);
			return numeroDAO.find(map);
		} catch (DAOException e) {
			throw new ServiceException(
					"Erreur NumeroService findByType(String)"+e.getMessage(), e);
		}
	}

	@Override
	public Numero findById(Integer key) throws ServiceException {
		try {
			return numeroDAO.findById(key);
		} catch (DAOException e) {
			throw new ServiceException(
					"Erreur NumeroService findById(Integer)"+e.getMessage(), e);
		}
	}

	@Override
	public List<Numero> find(Map<String, Object> map) throws ServiceException {
		try {
			return numeroDAO.find(map);
		} catch (DAOException e) {
			throw new ServiceException(
					"Erreur NumeroService find(Map<Str, Obj>)"
							+e.getMessage(), e);
		}
	}

	@Override
	public List<Numero> findAllWPersonne() throws ServiceException {
		try {
			return numeroDAO.findAllWPersonne();
		} catch (DAOException e) {
			throw new ServiceException(
					"Erreur NumeroService findAllWPersonne()"
							+e.getMessage(), e);
		}
		
	}

}
