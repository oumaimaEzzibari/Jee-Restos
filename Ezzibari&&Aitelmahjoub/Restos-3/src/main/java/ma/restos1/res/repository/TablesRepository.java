package ma.restos1.res.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import ma.restos1.res.entities.Tables_Restos;

import javax.transaction.Transactional;

@Transactional
public interface TablesRepository extends JpaRepository<Tables_Restos,Integer>{

    List<Tables_Restos> findAll();


}