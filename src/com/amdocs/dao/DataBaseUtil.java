package com.amdocs.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.amdocs.Entity.Defect;
import com.amdocs.util.Database;

public class DataBaseUtil {
	public static Defect getDefect(String defectId) {
		Session session = Database.getDbConnection().openSession();
		Transaction tx = session.beginTransaction();
		Defect defect1 = (Defect) session.get(Defect.class, defectId);

		tx.commit();
		session.close();
		return defect1;
	}

	public static void saveDefect(Defect defect) {
		Session session = Database.getDbConnection().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(defect);
		tx.commit();
		session.close();
	}

	public static List searchDefects(String defectNo, String releaseDetected,
			String releaseFixed, String fixedBy, String status) {
		Session session = Database.getDbConnection().openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Defect.class);
		
		criteria.add(Restrictions.like("defectNo", "%" + defectNo + "%").ignoreCase());
		criteria.add(Restrictions.like("releaseDetected", "%" + releaseDetected+ "%").ignoreCase());
		criteria.add(Restrictions.like("releaseFixed", "%" + releaseFixed + "%").ignoreCase());
		criteria.add(Restrictions.like("fixedBy", "%" + fixedBy + "%").ignoreCase());
		criteria.add(Restrictions.like("status", "%" + status + "%").ignoreCase());
		List result = criteria.list();
		
		tx.commit();
		session.close();
		return result;
	}
}
