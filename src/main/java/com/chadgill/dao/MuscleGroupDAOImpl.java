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
import com.chadgill.entity.MuscleGroup;

@Repository
public class MuscleGroupDAOImpl implements MuscleGroupDAO {
	
	@Autowired
	private EntityManager entityManager;

	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	@Transactional
	public void insert(MuscleGroup theMuscleGroup) {
		int index = 0;
		int vidIndex = 0;
		int counter = 0;
	//	Document d;
		
		String muscleName="";
		String muscleDesc="";
		
		try {
			Document d = Jsoup.connect("https://musclewiki.org/Exercises/Male/Biceps/").timeout(6000).get();
			Elements ele = d.select("div#mw-content-text");
			Session currentSession= getSession();
			for (Element element : ele.select("div#heading-outbox")) {
				 muscleName = element.select("div#heading-leftbox").text();
				System.out.println(muscleName);
				
			}
			for (Element element : ele.select("p")) {
				muscleDesc = element.select("p").text();
				if (muscleDesc.endsWith("More...")) {
					muscleDesc = muscleDesc.substring(0, muscleDesc.length() - 8);
				}
				if (index < 1) {
					System.out.println(muscleDesc);
					index++;
				}
			}
			index = 0;
			MuscleGroup muscleTemp = new MuscleGroup(muscleName, muscleDesc);
			muscleTemp.setName(muscleName);
			muscleTemp.setDescription(muscleDesc);
			System.out.println("pLZ work: " + muscleTemp);
			//currentSession.save(muscleTemp);
			currentSession.saveOrUpdate(muscleTemp);
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@Transactional
	@Override
	public List<MuscleGroup> getAllMuscleGroups() throws IOException {
		
		Session currentSession = getSession();
		
		chestCrawlerMuscle();
		absCrawlerExercises();
		shoulderCrawlerExercises();
		trapsCrawlerExercises();
		bicepsCrawlerExercises();
		forearmsCrawlerExercises();
		quadsCrawlerExercises();
		calvesCrawlerExercises();
		
		Query<MuscleGroup> theQuery = currentSession.createQuery("from MuscleGroup", MuscleGroup.class);
		List<MuscleGroup> musclegroups = theQuery.getResultList();
		System.out.println("hello there: " + musclegroups);
		return musclegroups;	
	}
	private void calvesCrawlerExercises() throws IOException {
		ArrayList<String> muscleArrayNames = new ArrayList<String>();
		ArrayList<String> description = new ArrayList<String>();
		Session currentSession = getSession();
		Document d = Jsoup.connect("https://musclewiki.org/Exercises/Male/Calves/").userAgent("Mozilla").get();
		Elements ele = d.select("div#mw-content-text");
		//System.out.println("Muscle Group: ");
		for (Element element : ele.select("div#heading-outbox")) {
			String muscleName = element.select("div#heading-leftbox").text();
			muscleArrayNames.add(muscleName);
		//	System.out.println(muscleName);
		}

		System.out.println("\nMuscle description: ");
		for (Element element : ele.select("p")) {
			String muscleDesc = element.select("p").text();
			if (muscleDesc.endsWith("More...")) {
				muscleDesc = muscleDesc.substring(0, muscleDesc.length() - 8);
				description.add(muscleDesc);
			}
		}
		
		MuscleGroup tempMuscle = new MuscleGroup(muscleArrayNames.get(0), description.get(0));
		currentSession.saveOrUpdate(tempMuscle);
		//System.out.println(tempMuscle.toString());
	}
		
	
	private void quadsCrawlerExercises() throws IOException {
		ArrayList<String> muscleArrayNames = new ArrayList<String>();
		ArrayList<String> description = new ArrayList<String>();
		Session currentSession = getSession();
		Document d = Jsoup.connect("https://musclewiki.org/Exercises/Male/Quads/").userAgent("Mozilla").get();
		Elements ele = d.select("div#mw-content-text");
		//System.out.println("Muscle Group: ");
		for (Element element : ele.select("div#heading-outbox")) {
			String muscleName = element.select("div#heading-leftbox").text();
			muscleArrayNames.add(muscleName);
		//	System.out.println(muscleName);
		}

		System.out.println("\nMuscle description: ");
		for (Element element : ele.select("p")) {
			String muscleDesc = element.select("p").text();
			if (muscleDesc.endsWith("More...")) {
				muscleDesc = muscleDesc.substring(0, muscleDesc.length() - 8);
				description.add(muscleDesc);
			}
		}
		
		MuscleGroup tempMuscle = new MuscleGroup(muscleArrayNames.get(0), description.get(0));
		currentSession.saveOrUpdate(tempMuscle);
		System.out.println(tempMuscle.toString());
	}
		
	
	private void forearmsCrawlerExercises() throws IOException {
		ArrayList<String> muscleArrayNames = new ArrayList<String>();
		ArrayList<String> description = new ArrayList<String>();
		Session currentSession = getSession();
		Document d = Jsoup.connect("https://musclewiki.org/Exercises/Male/Forearms/").userAgent("Mozilla").get();
		Elements ele = d.select("div#mw-content-text");
		//System.out.println("Muscle Group: ");
		for (Element element : ele.select("div#heading-outbox")) {
			String muscleName = element.select("div#heading-leftbox").text();
			muscleArrayNames.add(muscleName);
		//	System.out.println(muscleName);
		}

		System.out.println("\nMuscle description: ");
		for (Element element : ele.select("p")) {
			String muscleDesc = element.select("p").text();
			if (muscleDesc.endsWith("More...")) {
				muscleDesc = muscleDesc.substring(0, muscleDesc.length() - 8);
				description.add(muscleDesc);
			}
		}
		
		MuscleGroup tempMuscle = new MuscleGroup(muscleArrayNames.get(0), description.get(0));
		currentSession.saveOrUpdate(tempMuscle);
		System.out.println(tempMuscle.toString());
	}
		
	
	private void bicepsCrawlerExercises() throws IOException {
		ArrayList<String> muscleArrayNames = new ArrayList<String>();
		ArrayList<String> description = new ArrayList<String>();
		Session currentSession = getSession();
		Document d = Jsoup.connect("https://musclewiki.org/Exercises/Male/Biceps/").userAgent("Mozilla").get();
		Elements ele = d.select("div#mw-content-text");
		//System.out.println("Muscle Group: ");
		for (Element element : ele.select("div#heading-outbox")) {
			String muscleName = element.select("div#heading-leftbox").text();
			muscleArrayNames.add(muscleName);
		//	System.out.println(muscleName);
		}

		System.out.println("\nMuscle description: ");
		for (Element element : ele.select("p")) {
			String muscleDesc = element.select("p").text();
			if (muscleDesc.endsWith("More...")) {
				muscleDesc = muscleDesc.substring(0, muscleDesc.length() - 8);
				description.add(muscleDesc);
			}
		}
		
		MuscleGroup tempMuscle = new MuscleGroup(muscleArrayNames.get(0), description.get(0));
		currentSession.saveOrUpdate(tempMuscle);
		System.out.println(tempMuscle.toString());
	}
		
	
	private void trapsCrawlerExercises() throws IOException {
		ArrayList<String> muscleArrayNames = new ArrayList<String>();
		ArrayList<String> description = new ArrayList<String>();
		Session currentSession = getSession();
		Document d = Jsoup.connect("https://musclewiki.org/Exercises/Male/Traps/").userAgent("Mozilla").get();
		Elements ele = d.select("div#mw-content-text");
		//System.out.println("Muscle Group: ");
		for (Element element : ele.select("div#heading-outbox")) {
			String muscleName = element.select("div#heading-leftbox").text();
			muscleArrayNames.add(muscleName);
		//	System.out.println(muscleName);
		}

		System.out.println("\nMuscle description: ");
		for (Element element : ele.select("p")) {
			String muscleDesc = element.select("p").text();
			if (muscleDesc.endsWith("More...")) {
				muscleDesc = muscleDesc.substring(0, muscleDesc.length() - 8);
				description.add(muscleDesc);
			}
		}
		
		MuscleGroup tempMuscle = new MuscleGroup(muscleArrayNames.get(0), description.get(0));
		currentSession.saveOrUpdate(tempMuscle);
		System.out.println(tempMuscle.toString());
	}
		
	
	private void shoulderCrawlerExercises() throws IOException {
		ArrayList<String> muscleArrayNames = new ArrayList<String>();
		ArrayList<String> description = new ArrayList<String>();
		Session currentSession = getSession();
		Document d = Jsoup.connect("https://musclewiki.org/Exercises/Male/Shoulders/").userAgent("Mozilla").get();
		Elements ele = d.select("div#mw-content-text");
		//System.out.println("Muscle Group: ");
		for (Element element : ele.select("div#heading-outbox")) {
			String muscleName = element.select("div#heading-leftbox").text();
			muscleArrayNames.add(muscleName);
		//	System.out.println(muscleName);
		}

		System.out.println("\nMuscle description: ");
		for (Element element : ele.select("p")) {
			String muscleDesc = element.select("p").text();
			if (muscleDesc.endsWith("More...")) {
				muscleDesc = muscleDesc.substring(0, muscleDesc.length() - 8);
				description.add(muscleDesc);
			}
		}
		
		MuscleGroup tempMuscle = new MuscleGroup(muscleArrayNames.get(0), description.get(0));
		currentSession.saveOrUpdate(tempMuscle);
		System.out.println(tempMuscle.toString());
	}
		
	
	private void absCrawlerExercises() throws IOException {
		ArrayList<String> muscleArrayNames = new ArrayList<String>();
		ArrayList<String> description = new ArrayList<String>();
		Session currentSession = getSession();
		Document d = Jsoup.connect("https://musclewiki.org/Exercises/Male/Abdominals/").userAgent("Mozilla").get();
		Elements ele = d.select("div#mw-content-text");
		//System.out.println("Muscle Group: ");
		for (Element element : ele.select("div#heading-outbox")) {
			String muscleName = element.select("div#heading-leftbox").text();
			muscleArrayNames.add(muscleName);
		//	System.out.println(muscleName);
		}

		System.out.println("\nMuscle description: ");
		for (Element element : ele.select("p")) {
			String muscleDesc = element.select("p").text();
			if (muscleDesc.endsWith("More...")) {
				muscleDesc = muscleDesc.substring(0, muscleDesc.length() - 8);
				description.add(muscleDesc);
			}
		}
		
		MuscleGroup tempMuscle = new MuscleGroup(muscleArrayNames.get(0), description.get(0));
		currentSession.saveOrUpdate(tempMuscle);
		System.out.println(tempMuscle.toString());
	}
		
	
	private void chestCrawlerMuscle() throws IOException {
		ArrayList<String> muscleArrayNames = new ArrayList<String>();
		ArrayList<String> description = new ArrayList<String>();
		Session currentSession = getSession();
		Document d = Jsoup.connect("https://musclewiki.org/Exercises/Male/Chest/").userAgent("Mozilla").get();
		Elements ele = d.select("div#mw-content-text");
		//System.out.println("Muscle Group: ");
		for (Element element : ele.select("div#heading-outbox")) {
			String muscleName = element.select("div#heading-leftbox").text();
			muscleArrayNames.add(muscleName);
		//	System.out.println(muscleName);
		}

		System.out.println("\nMuscle description: ");
		for (Element element : ele.select("p")) {
			String muscleDesc = element.select("p").text();
			if (muscleDesc.endsWith("More...")) {
				muscleDesc = muscleDesc.substring(0, muscleDesc.length() - 8);
				description.add(muscleDesc);
			}
		}
		
		MuscleGroup tempMuscle = new MuscleGroup(muscleArrayNames.get(0), description.get(0));
		currentSession.saveOrUpdate(tempMuscle);
		System.out.println(tempMuscle.toString());
	}



}
