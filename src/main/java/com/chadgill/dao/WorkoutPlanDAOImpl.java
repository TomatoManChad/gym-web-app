package com.chadgill.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.chadgill.entity.WorkoutPlan;

@Repository
public class WorkoutPlanDAOImpl implements WorkoutPlanDAO {

	@Autowired
	private EntityManager entityManager;

	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}

	@Override
	@Transactional
	public List<WorkoutPlan> getWorkoutPlans() {

		Session currentSession = getSession();
		System.out.println("HEEELLOOOOPLZ: " + currentSession.getTransaction().isActive());
		Query<WorkoutPlan> theQuery = currentSession.createQuery("from WorkoutPlan", WorkoutPlan.class);
		List<WorkoutPlan> workoutPlans = theQuery.getResultList();
		return workoutPlans;
	}

	@Override
	public void saveWorkoutPlan(WorkoutPlan theWorkoutPlan) {
		Session currentSession = getSession();
		currentSession.save(theWorkoutPlan);
	}

	@Override
	public void deleteWorkout(int theId) {
		Session currentSession = getSession();
		System.out.println("HEEELLOOOO1: " + currentSession.getTransaction().isActive());
		Query theQuery = currentSession.createQuery("delete from WorkoutPlan where id = :workout");
		theQuery.setParameter("workout", theId);
		System.out.println("HEEELLOOOO: " + currentSession.getTransaction().isActive());
		theQuery.executeUpdate();
	}
}
