package dao;

import java.util.List;

import org.hibernate.Session;

import entity.Employee;
import utils.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public List<Employee> getAllEmployee() {
		Session session = 
				HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List<Employee> list = session.createQuery("from Employee").list();
			session.getTransaction().commit();
			session.close();
			return list;
		}catch(Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		return null;
	}
}
