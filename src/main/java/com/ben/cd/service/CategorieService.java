package com.ben.cd.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.ben.cd.CDService;
import com.ben.cd.exception.BusinessException;
import com.ben.cd.model.Categorie;

public class CategorieService extends CDService<Categorie>{
	
	private static final CategorieService INSTANCE = new CategorieService();
	private static List<String> COLS_NAME_SORT = new ArrayList<String>();
	static {
		COLS_NAME_SORT.add("raisonSociale");
	}
	
	public static final CategorieService getInstance() {
		return INSTANCE;
	}
	
	public Categorie insertOrUpdate(Categorie categorie) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Categorie>> constraintViolations = validator.validate(categorie);
        
        if (constraintViolations.size() > 0) {
        	for(ConstraintViolation<Categorie> violation : constraintViolations) {
				throw new BusinessException(violation.getMessage());
			}
        } else {
        	super.insertOrUpdate(categorie);
        }
        
        return categorie;
	}
	
	public void delete(Categorie categorie) {    
        super.delete(categorie);
    }
	
	
	public Categorie getById(Long id) {
		return super.getById(Categorie.class, id);
	}

//	public List<Categorie> getAllCategories()
//	{
//		EntityManager em = getEntityManager();
//	    List<Categorie> categories = em.createQuery("Select a.titre from Categorie a", Categorie.class).getResultList();
//		return (categories);
//	}
}
