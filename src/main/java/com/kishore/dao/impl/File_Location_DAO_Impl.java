package com.kishore.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kishore.dao.interfaces.File_Location_DAO_Interfaces;
import com.viki.service.entities.File_Location;

@Repository
public class File_Location_DAO_Impl implements File_Location_DAO_Interfaces {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save_File(File_Location file_Location) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(file_Location);
		transaction.commit();
		session.flush();
		session.close();
	}

}