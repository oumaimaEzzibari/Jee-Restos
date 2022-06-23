package ma.restos1.res.entities;

import java.io.File;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



	 @Entity
	 @Table(name="Tables_Restos")
	 @Data
	 @NoArgsConstructor @AllArgsConstructor
	 public class Tables_Restos {

	     @Id
	     @GeneratedValue(strategy = GenerationType.IDENTITY)
	     private Integer ID_Table;

	     @Column(name="Name_table",nullable = false,unique = true)
	     private String Name_Table;

		 @Column(name="Description_Table",nullable = false,unique = true)
		 private String Description_Table;

		 @Column(name="Path_Table")
		 private String Path_Table;

	     @Column(name="Nombre_Presonne",nullable = false)
	     private String nombre_Presone_Table;

		 @Column(name="Prix",nullable = false)
		 private String Prix;


	    
	 }


