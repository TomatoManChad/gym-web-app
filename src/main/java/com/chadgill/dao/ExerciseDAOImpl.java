package com.chadgill.dao;

import java.io.IOException;
import java.util.ArrayList;
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
		int count = ((Long)getSession().createQuery("select count(*) from Exercise").uniqueResult()).intValue();
		
		Session currentSession =getSession();
		if(count<1) {
		chestCrawlerExercises();
		absCrawlerExercises();
		shoulderCrawlerExercises();
		trapsCrawlerExercises();
		bicepsCrawlerExercises();
		forearmsCrawlerExercises();
		quadsCrawlerExercises();
		calvesCrawlerExercises();
		}
		Query<Exercise> theQuery = currentSession.createQuery("from Exercise", Exercise.class);
		List<Exercise> exercises = theQuery.getResultList();

		return exercises;
	}

	@Transactional
	@Override
	public void deleteExercise(String theId) {
		
			//get current hibernate session
			//delete the object with pk
			Session currentSession = getSession();
			Query theQuery = currentSession.createQuery("delete from Exercise where id=:exercise");
			theQuery.setParameter("exercise", theId);
			theQuery.executeUpdate();
	}
	
	public void chestCrawlerExercises() throws IOException {
		int index = 0;
		int vidIndex = 0;
		int counter = 0;
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> instructions = new ArrayList<String>();
		ArrayList<String> vud = new ArrayList<String>();

		Session currentSession = getSession();
		Document d = Jsoup.connect("https://musclewiki.org/Exercises/Male/Chest/").userAgent("Mozilla").get();
		Elements ele = d.select("div#mw-content-text");

		System.out.println("Muscle Group: ");
		for (Element element : ele.select("div#heading-outbox")) {
			String muscleName = element.select("div#heading-leftbox").text();
			System.out.println(muscleName);
		}

		System.out.println("\nMuscle description: ");
		for (Element element : ele.select("p")) {
			String muscleDesc = element.select("p").text();
			if (muscleDesc.endsWith("More...")) {
				muscleDesc = muscleDesc.substring(0, muscleDesc.length() - 8);
			}
			if (index < 1) {
				System.out.println(muscleDesc);
				index++;
			}
		}
		index = 0;

		System.out.println("\nEXERCISES: ");
		for (Element element : ele.select(".mw-headline")) {
			if (index > 0) {
				String exerciseNames = element.select(".mw-headline").text();
				counter++;
				names.add(exerciseNames);

				// System.out.println(counter + ". " + exerciseNames);
				index++;
			} else
				index++;
		}
		counter = 0;
		System.out.println("\nInstructions: ");
		for (Element element : ele.select("ol:not([class])")) {
			String intructions = element.select("ol:not([class])").text();
			counter++;
			instructions.add(intructions);
			System.out.println(counter + ". " + intructions);
		}

		counter = 0;

		System.out.println("\nVideo: ");
		for (Element element : ele.select("a[href]")) {

			if (vidIndex % 2 == 1) {
				String vidLink = element.select("a[href]").attr("href");
				counter++;
				StringBuffer sb = new StringBuffer(vidLink);
				sb.insert(24, "embed/");
				String embedInsert =sb.toString();
				
				StringBuilder sp = new StringBuilder(embedInsert);
				sp.delete(30, 38);
				sp.delete(41, 44);
				String charRemoval = sp.toString();
				vud.add(charRemoval);
				System.out.println(counter + ". " + charRemoval);
				vidIndex++;

			} else
				vidIndex++;
		}
		counter = 0;
		vidIndex = 0;
		Exercise exerciseTemp1 = new Exercise(names.get(0), instructions.get(0), vud.get(0));
		Exercise exerciseTemp2 = new Exercise(names.get(1), instructions.get(1), vud.get(1));
		Exercise exerciseTemp3 = new Exercise(names.get(2), instructions.get(2), vud.get(2));
		Exercise exerciseTemp4 = new Exercise(names.get(3), instructions.get(3), vud.get(3));

		String theId = "Chest";
		MuscleGroup tempMuscleGroup = currentSession.get(MuscleGroup.class, theId);

		tempMuscleGroup.add(exerciseTemp1);
		tempMuscleGroup.add(exerciseTemp2);
		tempMuscleGroup.add(exerciseTemp3);
		tempMuscleGroup.add(exerciseTemp4);

		exerciseTemp1.setMuscleGroup(tempMuscleGroup);
		exerciseTemp2.setMuscleGroup(tempMuscleGroup);
		exerciseTemp3.setMuscleGroup(tempMuscleGroup);
		exerciseTemp4.setMuscleGroup(tempMuscleGroup);

		currentSession.saveOrUpdate(exerciseTemp1);
		currentSession.saveOrUpdate(exerciseTemp2);
		currentSession.saveOrUpdate(exerciseTemp3);
		currentSession.saveOrUpdate(exerciseTemp4);
		System.out.println("PLZWORKPLZPLZPLZPLZ: "+ exerciseTemp1.toString());
		System.out.println("PLZWORKPLZPLZPLZPLZ: "+ exerciseTemp2.toString());
		System.out.println("PLZWORKPLZPLZPLZPLZ: "+ exerciseTemp3.toString());
		System.out.println("PLZWORKPLZPLZPLZPLZ: "+ exerciseTemp4.toString());
	}
	public void absCrawlerExercises() throws IOException {
		int index = 0;
		int vidIndex = 0;
		int counter = 0;
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> instructions = new ArrayList<String>();
		ArrayList<String> vud = new ArrayList<String>();

		Session currentSession = getSession();
		Document d = Jsoup.connect("https://musclewiki.org/Exercises/Male/Abdominals/").userAgent("Mozilla").get();
		Elements ele = d.select("div#mw-content-text");

		System.out.println("Muscle Group: ");
		for (Element element : ele.select("div#heading-outbox")) {
			String muscleName = element.select("div#heading-leftbox").text();
			System.out.println(muscleName);
		}

		System.out.println("\nMuscle description: ");
		for (Element element : ele.select("p")) {
			String muscleDesc = element.select("p").text();
			if (muscleDesc.endsWith("More...")) {
				muscleDesc = muscleDesc.substring(0, muscleDesc.length() - 8);
			}
			if (index < 1) {
				System.out.println(muscleDesc);
				index++;
			}
		}
		index = 0;

		System.out.println("\nEXERCISES: ");
		for (Element element : ele.select(".mw-headline")) {
			if (index > 0) {
				String exerciseNames = element.select(".mw-headline").text();
				counter++;
				names.add(exerciseNames);

				// System.out.println(counter + ". " + exerciseNames);
				index++;
			} else
				index++;
		}
		counter = 0;
		System.out.println("\nInstructions: ");
		for (Element element : ele.select("ol:not([class])")) {
			String intructions = element.select("ol:not([class])").text();
			counter++;
			instructions.add(intructions);
			System.out.println(counter + ". " + intructions);
		}

		counter = 0;

		System.out.println("\nVideo: ");
		for (Element element : ele.select("a[href]")) {

			if (vidIndex % 2 == 1) {
				String vidLink = element.select("a[href]").attr("href");
				counter++;
				StringBuffer sb = new StringBuffer(vidLink);
				sb.insert(24, "embed/");
				String embedInsert =sb.toString();
				
				StringBuilder sp = new StringBuilder(embedInsert);
				sp.delete(30, 38);
				sp.delete(41, 44);
				String charRemoval = sp.toString();
				vud.add(charRemoval);
				System.out.println(counter + ". " + charRemoval);
				vidIndex++;

			} else
				vidIndex++;
		}
		counter = 0;
		vidIndex = 0;

		Exercise exerciseTemp1 = new Exercise(names.get(0), instructions.get(0), vud.get(0));
		Exercise exerciseTemp2 = new Exercise(names.get(1), instructions.get(1), vud.get(1));
		Exercise exerciseTemp3 = new Exercise(names.get(2), instructions.get(2), vud.get(2));
		Exercise exerciseTemp4 = new Exercise(names.get(3), instructions.get(3), vud.get(3));

		String theId = "Abdominals";
		MuscleGroup tempMuscleGroup = currentSession.get(MuscleGroup.class, theId);

		tempMuscleGroup.add(exerciseTemp1);
		tempMuscleGroup.add(exerciseTemp2);
		tempMuscleGroup.add(exerciseTemp3);
		tempMuscleGroup.add(exerciseTemp4);

		exerciseTemp1.setMuscleGroup(tempMuscleGroup);
		exerciseTemp2.setMuscleGroup(tempMuscleGroup);
		exerciseTemp3.setMuscleGroup(tempMuscleGroup);
		exerciseTemp4.setMuscleGroup(tempMuscleGroup);

		currentSession.saveOrUpdate(exerciseTemp1);
		currentSession.saveOrUpdate(exerciseTemp2);
		currentSession.saveOrUpdate(exerciseTemp3);
		currentSession.saveOrUpdate(exerciseTemp4);
		
	}
	public void shoulderCrawlerExercises() throws IOException {
		int index = 0;
		int vidIndex = 0;
		int counter = 0;
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> instructions = new ArrayList<String>();
		ArrayList<String> vud = new ArrayList<String>();

		Session currentSession = getSession();
		Document d = Jsoup.connect("https://musclewiki.org/Exercises/Male/Shoulders/").userAgent("Mozilla").get();
		Elements ele = d.select("div#mw-content-text");

		System.out.println("Muscle Group: ");
		for (Element element : ele.select("div#heading-outbox")) {
			String muscleName = element.select("div#heading-leftbox").text();
			System.out.println(muscleName);
		}

		System.out.println("\nMuscle description: ");
		for (Element element : ele.select("p")) {
			String muscleDesc = element.select("p").text();
			if (muscleDesc.endsWith("More...")) {
				muscleDesc = muscleDesc.substring(0, muscleDesc.length() - 8);
			}
			if (index < 1) {
				System.out.println(muscleDesc);
				index++;
			}
		}
		index = 0;

		System.out.println("\nEXERCISES: ");
		for (Element element : ele.select(".mw-headline")) {
			if (index > 0) {
				String exerciseNames = element.select(".mw-headline").text();
				counter++;
				names.add(exerciseNames);

				// System.out.println(counter + ". " + exerciseNames);
				index++;
			} else
				index++;
		}
		counter = 0;
		System.out.println("\nInstructions: ");
		for (Element element : ele.select("ol:not([class])")) {
			String intructions = element.select("ol:not([class])").text();
			counter++;
			instructions.add(intructions);
			System.out.println(counter + ". " + intructions);
		}

		counter = 0;

		System.out.println("\nVideo: ");
		for (Element element : ele.select("a[href]")) {

			if (vidIndex % 2 == 1) {
				String vidLink = element.select("a[href]").attr("href");
				counter++;
				StringBuffer sb = new StringBuffer(vidLink);
				sb.insert(24, "embed/");
				String embedInsert =sb.toString();
				
				StringBuilder sp = new StringBuilder(embedInsert);
				sp.delete(30, 38);
				sp.delete(41, 44);
				String charRemoval = sp.toString();
				vud.add(charRemoval);
				System.out.println(counter + ". " + charRemoval);
				vidIndex++;

			} else
				vidIndex++;
		}
		counter = 0;
		vidIndex = 0;

		Exercise exerciseTemp1 = new Exercise(names.get(0), instructions.get(0), vud.get(0));
		Exercise exerciseTemp2 = new Exercise(names.get(1), instructions.get(1), vud.get(1));
		Exercise exerciseTemp3 = new Exercise(names.get(2), instructions.get(2), vud.get(2));
		Exercise exerciseTemp4 = new Exercise(names.get(3), instructions.get(3), vud.get(3));

		String theId = "Shoulders";
		MuscleGroup tempMuscleGroup = currentSession.get(MuscleGroup.class, theId);

		tempMuscleGroup.add(exerciseTemp1);
		tempMuscleGroup.add(exerciseTemp2);
		tempMuscleGroup.add(exerciseTemp3);
		tempMuscleGroup.add(exerciseTemp4);

		exerciseTemp1.setMuscleGroup(tempMuscleGroup);
		exerciseTemp2.setMuscleGroup(tempMuscleGroup);
		exerciseTemp3.setMuscleGroup(tempMuscleGroup);
		exerciseTemp4.setMuscleGroup(tempMuscleGroup);

		currentSession.saveOrUpdate(exerciseTemp1);
		currentSession.saveOrUpdate(exerciseTemp2);
		currentSession.saveOrUpdate(exerciseTemp3);
		currentSession.saveOrUpdate(exerciseTemp4);
	
	}
	public void trapsCrawlerExercises() throws IOException {
		int index = 0;
		int vidIndex = 0;
		int counter = 0;
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> instructions = new ArrayList<String>();
		ArrayList<String> vud = new ArrayList<String>();

		Session currentSession = getSession();
		Document d = Jsoup.connect("https://musclewiki.org/Exercises/Male/Traps/").userAgent("Mozilla").get();
		Elements ele = d.select("div#mw-content-text");

		System.out.println("Muscle Group: ");
		for (Element element : ele.select("div#heading-outbox")) {
			String muscleName = element.select("div#heading-leftbox").text();
			System.out.println(muscleName);
		}

		System.out.println("\nMuscle description: ");
		for (Element element : ele.select("p")) {
			String muscleDesc = element.select("p").text();
			if (muscleDesc.endsWith("More...")) {
				muscleDesc = muscleDesc.substring(0, muscleDesc.length() - 8);
			}
			if (index < 1) {
				System.out.println(muscleDesc);
				index++;
			}
		}
		index = 0;

		System.out.println("\nEXERCISES: ");
		for (Element element : ele.select(".mw-headline")) {
			if (index > 0) {
				String exerciseNames = element.select(".mw-headline").text();
				counter++;
				names.add(exerciseNames);

				// System.out.println(counter + ". " + exerciseNames);
				index++;
			} else
				index++;
		}
		counter = 0;
		System.out.println("\nInstructions: ");
		for (Element element : ele.select("ol:not([class])")) {
			String intructions = element.select("ol:not([class])").text();
			counter++;
			instructions.add(intructions);
			System.out.println(counter + ". " + intructions);
		}

		counter = 0;

		System.out.println("\nVideo: ");
		for (Element element : ele.select("a[href]")) {

			if (vidIndex % 2 == 1) {
				String vidLink = element.select("a[href]").attr("href");
				counter++;
				StringBuffer sb = new StringBuffer(vidLink);
				sb.insert(24, "embed/");
				String embedInsert =sb.toString();
				
				StringBuilder sp = new StringBuilder(embedInsert);
				sp.delete(30, 38);
				sp.delete(41, 44);
				String charRemoval = sp.toString();
				vud.add(charRemoval);
				System.out.println(counter + ". " + charRemoval);
				vidIndex++;

			} else
				vidIndex++;
		}
		counter = 0;
		vidIndex = 0;

		Exercise exerciseTemp1 = new Exercise(names.get(0), instructions.get(0), vud.get(0));
		Exercise exerciseTemp2 = new Exercise(names.get(1), instructions.get(1), vud.get(1));
	
		String theId = "Traps";
		MuscleGroup tempMuscleGroup = currentSession.get(MuscleGroup.class, theId);

		tempMuscleGroup.add(exerciseTemp1);
		tempMuscleGroup.add(exerciseTemp2);
		

		exerciseTemp1.setMuscleGroup(tempMuscleGroup);
		exerciseTemp2.setMuscleGroup(tempMuscleGroup);
		

		currentSession.saveOrUpdate(exerciseTemp1);
		currentSession.saveOrUpdate(exerciseTemp2);
	}
	public void bicepsCrawlerExercises() throws IOException {
		int index = 0;
		int vidIndex = 0;
		int counter = 0;
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> instructions = new ArrayList<String>();
		ArrayList<String> vud = new ArrayList<String>();

		Session currentSession = getSession();
		Document d = Jsoup.connect("https://musclewiki.org/Exercises/Male/Biceps/").userAgent("Mozilla").get();
		Elements ele = d.select("div#mw-content-text");

		System.out.println("Muscle Group: ");
		for (Element element : ele.select("div#heading-outbox")) {
			String muscleName = element.select("div#heading-leftbox").text();
			System.out.println(muscleName);
		}

		System.out.println("\nMuscle description: ");
		for (Element element : ele.select("p")) {
			String muscleDesc = element.select("p").text();
			if (muscleDesc.endsWith("More...")) {
				muscleDesc = muscleDesc.substring(0, muscleDesc.length() - 8);
			}
			if (index < 1) {
				System.out.println(muscleDesc);
				index++;
			}
		}
		index = 0;

		System.out.println("\nEXERCISES: ");
		for (Element element : ele.select(".mw-headline")) {
			if (index > 0) {
				String exerciseNames = element.select(".mw-headline").text();
				counter++;
				names.add(exerciseNames);

				// System.out.println(counter + ". " + exerciseNames);
				index++;
			} else
				index++;
		}
		counter = 0;
		System.out.println("\nInstructions: ");
		for (Element element : ele.select("ol:not([class])")) {
			String intructions = element.select("ol:not([class])").text();
			counter++;
			instructions.add(intructions);
			System.out.println(counter + ". " + intructions);
		}

		counter = 0;

		System.out.println("\nVideo: ");
		for (Element element : ele.select("a[href]")) {

			if (vidIndex % 2 == 1) {
				String vidLink = element.select("a[href]").attr("href");
				counter++;
				StringBuffer sb = new StringBuffer(vidLink);
				sb.insert(24, "embed/");
				String embedInsert =sb.toString();
				
				StringBuilder sp = new StringBuilder(embedInsert);
				sp.delete(30, 38);
				sp.delete(41, 44);
				String charRemoval = sp.toString();
				vud.add(charRemoval);
				System.out.println(counter + ". " + charRemoval);
				vidIndex++;

			} else
				vidIndex++;
		}
		counter = 0;
		vidIndex = 0;

		Exercise exerciseTemp1 = new Exercise(names.get(0), instructions.get(0), vud.get(0));
		Exercise exerciseTemp2 = new Exercise(names.get(1), instructions.get(1), vud.get(1));
		Exercise exerciseTemp3 = new Exercise(names.get(2), instructions.get(2), vud.get(2));
	
		String theId = "Biceps";
		MuscleGroup tempMuscleGroup = currentSession.get(MuscleGroup.class, theId);

		tempMuscleGroup.add(exerciseTemp1);
		tempMuscleGroup.add(exerciseTemp2);
		tempMuscleGroup.add(exerciseTemp3);

		exerciseTemp1.setMuscleGroup(tempMuscleGroup);
		exerciseTemp2.setMuscleGroup(tempMuscleGroup);
		exerciseTemp3.setMuscleGroup(tempMuscleGroup);

		currentSession.saveOrUpdate(exerciseTemp1);
		currentSession.saveOrUpdate(exerciseTemp2);
		currentSession.saveOrUpdate(exerciseTemp3);
	
	}
	public void forearmsCrawlerExercises() throws IOException {
		int index = 0;
		int vidIndex = 0;
		int counter = 0;
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> instructions = new ArrayList<String>();
		ArrayList<String> vud = new ArrayList<String>();

		Session currentSession = getSession();
		Document d = Jsoup.connect("https://musclewiki.org/Exercises/Male/Forearms/").userAgent("Mozilla").get();
		Elements ele = d.select("div#mw-content-text");

		System.out.println("Muscle Group: ");
		for (Element element : ele.select("div#heading-outbox")) {
			String muscleName = element.select("div#heading-leftbox").text();
			System.out.println(muscleName);
		}

		System.out.println("\nMuscle description: ");
		for (Element element : ele.select("p")) {
			String muscleDesc = element.select("p").text();
			if (muscleDesc.endsWith("More...")) {
				muscleDesc = muscleDesc.substring(0, muscleDesc.length() - 8);
			}
			if (index < 1) {
				System.out.println(muscleDesc);
				index++;
			}
		}
		index = 0;

		System.out.println("\nEXERCISES: ");
		for (Element element : ele.select(".mw-headline")) {
			if (index > 0) {
				String exerciseNames = element.select(".mw-headline").text();
				counter++;
				names.add(exerciseNames);

				// System.out.println(counter + ". " + exerciseNames);
				index++;
			} else
				index++;
		}
		counter = 0;
		System.out.println("\nInstructions: ");
		for (Element element : ele.select("ol:not([class])")) {
			String intructions = element.select("ol:not([class])").text();
			counter++;
			instructions.add(intructions);
			System.out.println(counter + ". " + intructions);
		}

		counter = 0;

		System.out.println("\nVideo: ");
		for (Element element : ele.select("a[href]")) {

			if (vidIndex % 2 == 1) {
				String vidLink = element.select("a[href]").attr("href");
				counter++;
				StringBuffer sb = new StringBuffer(vidLink);
				sb.insert(24, "embed/");
				String embedInsert =sb.toString();
				
				StringBuilder sp = new StringBuilder(embedInsert);
				sp.delete(30, 38);
				sp.delete(41, 44);
				String charRemoval = sp.toString();
				vud.add(charRemoval);
				System.out.println(counter + ". " + charRemoval);
				vidIndex++;

			} else
				vidIndex++;
		}
		counter = 0;
		vidIndex = 0;

		Exercise exerciseTemp1 = new Exercise(names.get(0), instructions.get(0), vud.get(0));
		Exercise exerciseTemp2 = new Exercise(names.get(1), instructions.get(1), vud.get(1));
		
	
		String theId = "Forearms";
		MuscleGroup tempMuscleGroup = currentSession.get(MuscleGroup.class, theId);

		tempMuscleGroup.add(exerciseTemp1);
		tempMuscleGroup.add(exerciseTemp2);
		

		exerciseTemp1.setMuscleGroup(tempMuscleGroup);
		exerciseTemp2.setMuscleGroup(tempMuscleGroup);
		

		currentSession.saveOrUpdate(exerciseTemp1);
		currentSession.saveOrUpdate(exerciseTemp2);

	}
	public void quadsCrawlerExercises() throws IOException {
		int index = 0;
		int vidIndex = 0;
		int counter = 0;
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> instructions = new ArrayList<String>();
		ArrayList<String> vud = new ArrayList<String>();

		Session currentSession = getSession();
		Document d = Jsoup.connect("https://musclewiki.org/Exercises/Male/Quads/").userAgent("Mozilla").get();
		Elements ele = d.select("div#mw-content-text");

		System.out.println("Muscle Group: ");
		for (Element element : ele.select("div#heading-outbox")) {
			String muscleName = element.select("div#heading-leftbox").text();
			System.out.println(muscleName);
		}

		System.out.println("\nMuscle description: ");
		for (Element element : ele.select("p")) {
			String muscleDesc = element.select("p").text();
			if (muscleDesc.endsWith("More...")) {
				muscleDesc = muscleDesc.substring(0, muscleDesc.length() - 8);
			}
			if (index < 1) {
				index++;
			}
		}
		index = 0;

		System.out.println("\nEXERCISES: ");
		for (Element element : ele.select(".mw-headline")) {
			if (index > 0) {
				String exerciseNames = element.select(".mw-headline").text();
				counter++;
				names.add(exerciseNames);
				index++;
			} else
				index++;
		}
		counter = 0;
		System.out.println("\nInstructions: ");
		for (Element element : ele.select("ol:not([class])")) {
			String intructions = element.select("ol:not([class])").text();
			counter++;
			instructions.add(intructions);
		}

		counter = 0;

		System.out.println("\nVideo: ");
		for (Element element : ele.select("a[href]")) {

			if (vidIndex % 2 == 1) {
				String vidLink = element.select("a[href]").attr("href");
				counter++;
				StringBuffer sb = new StringBuffer(vidLink);
				sb.insert(24, "embed/");
				String embedInsert =sb.toString();
				
				StringBuilder sp = new StringBuilder(embedInsert);
				sp.delete(30, 38);
				sp.delete(41, 44);
				String charRemoval = sp.toString();
				vud.add(charRemoval);
				System.out.println(counter + ". " + charRemoval);
				vidIndex++;

			} else
				vidIndex++;
		}
		counter = 0;
		vidIndex = 0;

		Exercise exerciseTemp1 = new Exercise(names.get(0), instructions.get(0), vud.get(0));
		Exercise exerciseTemp2 = new Exercise(names.get(1), instructions.get(1), vud.get(1));
		Exercise exerciseTemp3 = new Exercise(names.get(2), instructions.get(2), vud.get(2));
		Exercise exerciseTemp4 = new Exercise(names.get(3), instructions.get(3), vud.get(3));
	
		String theId = "Quads";
		MuscleGroup tempMuscleGroup = currentSession.get(MuscleGroup.class, theId);

		tempMuscleGroup.add(exerciseTemp1);
		tempMuscleGroup.add(exerciseTemp2);
		tempMuscleGroup.add(exerciseTemp3);
		tempMuscleGroup.add(exerciseTemp4);

		exerciseTemp1.setMuscleGroup(tempMuscleGroup);
		exerciseTemp2.setMuscleGroup(tempMuscleGroup);
		exerciseTemp3.setMuscleGroup(tempMuscleGroup);
		exerciseTemp4.setMuscleGroup(tempMuscleGroup);

		currentSession.saveOrUpdate(exerciseTemp1);
		currentSession.saveOrUpdate(exerciseTemp2);
		currentSession.saveOrUpdate(exerciseTemp3);
		currentSession.saveOrUpdate(exerciseTemp4);
	}
	public void calvesCrawlerExercises() throws IOException {
		int index = 0;
		int vidIndex = 0;
		int counter = 0;
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> instructions = new ArrayList<String>();
		ArrayList<String> vud = new ArrayList<String>();

		Session currentSession = getSession();
		Document d = Jsoup.connect("https://musclewiki.org/Exercises/Male/Calves/").userAgent("Mozilla").get();
		Elements ele = d.select("div#mw-content-text");

		System.out.println("Muscle Group: ");
		for (Element element : ele.select("div#heading-outbox")) {
			String muscleName = element.select("div#heading-leftbox").text();
			System.out.println(muscleName);
		}

		System.out.println("\nMuscle description: ");
		for (Element element : ele.select("p")) {
			String muscleDesc = element.select("p").text();
			if (muscleDesc.endsWith("More...")) {
				muscleDesc = muscleDesc.substring(0, muscleDesc.length() - 8);
			}
			if (index < 1) {
				System.out.println(muscleDesc);
				index++;
			}
		}
		index = 0;

		System.out.println("\nEXERCISES: ");
		for (Element element : ele.select(".mw-headline")) {
			if (index > 0) {
				String exerciseNames = element.select(".mw-headline").text();
				counter++;
				names.add(exerciseNames);
				index++;
			} else
				index++;
		}
		counter = 0;
		System.out.println("\nInstructions: ");
		for (Element element : ele.select("ol:not([class])")) {
			String intructions = element.select("ol:not([class])").text();
			counter++;
			instructions.add(intructions);
		}

		counter = 0;

		System.out.println("\nVideo: ");
		for (Element element : ele.select("a[href]")) {

			if (vidIndex % 2 == 1) {
				String vidLink = element.select("a[href]").attr("href");
				counter++;
				StringBuffer sb = new StringBuffer(vidLink);
				sb.insert(24, "embed/");
				String embedInsert =sb.toString();
				
				StringBuilder sp = new StringBuilder(embedInsert);
				sp.delete(30, 38);
				sp.delete(41, 44);
				String charRemoval = sp.toString();
				vud.add(charRemoval);
				System.out.println(counter + ". " + charRemoval);
				vidIndex++;

			} else
				vidIndex++;
		}
		counter = 0;
		vidIndex = 0;

		Exercise exerciseTemp1 = new Exercise(names.get(0), instructions.get(0), vud.get(0));
		Exercise exerciseTemp2 = new Exercise(names.get(1), instructions.get(1), vud.get(1));
		
		String theId ="Calves";
		MuscleGroup tempMuscleGroup = currentSession.get(MuscleGroup.class, theId);

		tempMuscleGroup.add(exerciseTemp1);
		tempMuscleGroup.add(exerciseTemp2);
		
		exerciseTemp1.setMuscleGroup(tempMuscleGroup);
		exerciseTemp2.setMuscleGroup(tempMuscleGroup);
		
		currentSession.saveOrUpdate(exerciseTemp1);
		currentSession.saveOrUpdate(exerciseTemp2);	

	}

	@Override
	public Exercise getExercise(String theId) {
		Session currentSession = getSession();
		Exercise exercise = currentSession.get(Exercise.class, theId);
		System.out.println("INEEDTHISTOWORK"+exercise.toString());
		return exercise;
	}
}