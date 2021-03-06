package com.ben.cd.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.ben.cd.CDService;
import com.ben.cd.exception.BusinessException;
import com.ben.cd.model.Album;
import com.ben.cd.service.AlbumService;
import com.ben.cd.tool.EntityManagerTool;

public class AlbumService extends CDService<Album>{
	
	private static final AlbumService INSTANCE = new AlbumService();
	private static List<String> COLS_NAME_SORT = new ArrayList<String>();
	static {
		COLS_NAME_SORT.add("raisonSociale");
	}
	
	public static final AlbumService getInstance() {
		return INSTANCE;
	}
	
	public Album insertOrUpdate(Album  album) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Album>> constraintViolations = validator.validate(album);
        
        if (constraintViolations.size() > 0) {
        	for(ConstraintViolation<Album> violation : constraintViolations) {
				throw new BusinessException(violation.getMessage());
			}
        } else {
        	super.insertOrUpdate(album);
        }
        
        return album;
	}
	
	public void delete(Album album) {    
        super.delete(album);
    }
	
	
	public Album getById(Long id) {
		return super.getById(Album.class, id);
	}
	
	public void deleteByTitre(Album album, String titre) {	
		EntityManager em = getEntityManager();
		Query q = em.createQuery("DELETE FROM Album WHERE titre = :titre");
		q.setParameter("titre", titre);
		q.executeUpdate();
		EntityManagerTool.closeEntityManager();
	}

    @SuppressWarnings("unchecked")
	public List<Album> getAllAlbums()
	{
		EntityManager em = getEntityManager();
		List<Album> albums = em.createQuery("Select a.titre from Album a").getResultList();
		return (albums);
	}
}
