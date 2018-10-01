package br.com.bordeau.DAOS;

import java.util.List;

public interface DAO {
	void gravar();
	Object findById(Integer id);
	List<?> listar(); 
	void update(Object object);
	void remove(Object object);
}
