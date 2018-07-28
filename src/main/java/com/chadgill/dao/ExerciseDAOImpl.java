package com.chadgill.dao;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chadgill.entity.Exercise;
import com.chadgill.entity.MuscleGroup;

@Repository
public class ExerciseDAOImpl implements ExerciseDAO {

	
	@Autowired
	private EntityManager entityManager;

	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}

	@Transactional
	@Override
	public List<Exercise> getAllExercises() throws IOException {

		int index = 0;
		int vidIndex = 0;
		int counter = 0;

		String exerciseNames = "";
		String instructions = "";
		String vidLink = "";

		Session currentSession =getSession();

		Document d = Jsoup.connect("https://musclewiki.org/Exercises/Male/Chest/").userAgent("Mozilla").get();
		Elements ele = d.select("div#mw-content-text");
		for (Element element : ele.select(".mw-headline")) {
			if (index > 0) {
				exerciseNames = element.select(".mw-headline").text();
				counter++;
				System.out.println(counter + ". " + exerciseNames);
				index++;
			} else
				index++;

		}
		counter = 0;
		System.out.println("\nInstructions: ");
		for (Element element : ele.select("ol:not([class])")) {
			instructions = element.select("ol:not([class])").text();
			counter++;
			System.out.println(counter + ". " + instructions);
		}

		counter = 0;

		System.out.println("\nVideo: ");
		for (Element element : ele.select("a[href]")) {

			if (vidIndex % 2 == 1) {
				vidLink = element.select("a[href]").attr("href");
				counter++;
				System.out.println(counter + ". " + vidLink);
				vidIndex++;
				

			} else
				vidIndex++;
		}
		int theId = 1;
		MuscleGroup tempMuscleGroup = currentSession.get(MuscleGroup.class, theId);
		Exercise exerciseTemp = new Exercise(exerciseNames, instructions, vidLink);
		tempMuscleGroup.add(exerciseTemp);
		exerciseTemp.setMuscleGroup(tempMuscleGroup);
		currentSession.saveOrUpdate(exerciseTemp);
		

		

		Query<Exercise> theQuery = currentSession.createQuery("from Exercise", Exercise.class);
		List<Exercise> exercises = theQuery.getResultList();

		return exercises;
	}

	@Transactional
	public void createExercises() {

		Session currentSession = getSession();
		int index = 0;
		int vidIndex = 0;
		int counter = 0;

		String exerciseNames = "";
		String instructions = "";
		String vidLink = "";

		//prepopulate exercise for chest workouts-currently only prints last iteration of loop
/*		Document d;
		try {
			d = Jsoup.connect("https://musclewiki.org/Exercises/Male/Chest/").get();

			Elements ele = d.select("div#mw-content-text");
			for (Element element : ele.select(".mw-headline")) {
				if (index > 0) {
					exerciseNames = element.select(".mw-headline").text();
					counter++;
					System.out.println(counter + ". " + exerciseNames);
					index++;
				} else
					index++;

				counter = 0;
				System.out.println("\nInstructions: ");
				for (Element elementy : ele.select("ol:not([class])")) {
					instructions = elementy.select("ol:not([class])").text();
					counter++;
					System.out.println(counter + ". " + instructions);

					counter = 0;

					System.out.println("\nVideo: ");
					for (Element elementt : ele.select("a[href]")) {

						if (vidIndex % 2 == 1) {
							vidLink = elementt.select("a[href]").attr("href");
							counter++;
							System.out.println(counter + ". " + vidLink);
							vidIndex++;

						} else {
							vidIndex++;
						}
						int theId = 1;
						MuscleGroup tempMuscleGroup = currentSession.get(MuscleGroup.class, theId);
						Exercise exerciseTemp = new Exercise(exerciseNames, instructions, vidLink);

						tempMuscleGroup.add(exerciseTemp);
						exerciseTemp.setMuscleGroup(tempMuscleGroup);
						currentSession.saveOrUpdate(exerciseTemp);
					}
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	@Transactional
	@Override
	public void deleteExercise(int theId) {
		
			//get current hibernate session
			//delete the object with pk
			Session currentSession = getSession();
			Query theQuery = currentSession.createQuery("delete from Exercise where id=:exercise");
			theQuery.setParameter("exercise", theId);
			theQuery.executeUpdate();
	}
}