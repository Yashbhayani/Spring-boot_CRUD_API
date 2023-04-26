package com.blogboot.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.blogboot.database.config.HibernateDatabaseConfig;
import com.blogboot.model.User;
import com.blogboot.repository.UserRepository;

import net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName;

@Service
public class UsersService {

	UserRepository userRepository;

	public void saveRegistrationData(User user) {
		Transaction transaction = null;

		try (Session session = HibernateDatabaseConfig.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			System.out.println(":::::Save transaction bigin:::" + transaction);
			session.saveOrUpdate(user);
			System.out.println(":::::Save Status:::");
			transaction.commit();
		} catch (Exception e) {
			System.out.println(":::::Save transaction:::" + transaction);
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();

		}

	}
	
	public  List<User> getGroceryRecord() {
		Transaction transaction = null;
		List<User> userList = null;

		try (Session session = HibernateDatabaseConfig.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			userList = session.createQuery("from User").getResultList();

			transaction.commit();
			System.out.println(userList.size());

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return userList;
	}

	public  User getGroceryRecordByID(int id) {
		Transaction transaction = null;
		User user = null;

		try (Session session = HibernateDatabaseConfig.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			user = session.get(User.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return user;
	}

    public void deleteById(int id) {
    	Transaction transaction = null;

		try (Session session = HibernateDatabaseConfig.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			User user = session.get(User.class, id);

			if (user != null) {
				session.delete(user);
				System.out.println("Deleted Successfully");
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}	

	public void updateGroceryData(int id ,User u) {
		Transaction transaction = null;
		User user = null;

		try (Session session = HibernateDatabaseConfig.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			user = session.get(User.class, id);
			user.setSurname(u.getSurname());
			user.setFirstname(u.getFirstname());
			user.setLastname(u.getLastname());
			user.setBirthdate(u.getBirthdate());
			user.setEmail(u.getEmail());
			user.setMobilenumber(u.getMobilenumber());
			user.setPassword(u.getPassword());
			
			session.update(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}
