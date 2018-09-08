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

		String muscleName = "";
		String muscleDesc = "";

		try {
			Document d = Jsoup.connect("https://musclewiki.org/Exercises/Male/Biceps/").timeout(6000).get();
			Elements ele = d.select("div#mw-content-text");
			Session currentSession = getSession();
			for (Element element : ele.select("div#heading-outbox")) {
				muscleName = element.select("div#heading-leftbox").text();

			}
			for (Element element : ele.select("p")) {
				muscleDesc = element.select("p").text();
				if (muscleDesc.endsWith("More...")) {
					muscleDesc = muscleDesc.substring(0, muscleDesc.length() - 8);
				}
				if (index < 1) {

					index++;
				}
			}
			index = 0;
			MuscleGroup muscleTemp = new MuscleGroup(muscleName, muscleDesc);
			muscleTemp.setName(muscleName);
			muscleTemp.setDescription(muscleDesc);

			currentSession.saveOrUpdate(muscleTemp);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public List<MuscleGroup> getAllMuscleGroups() throws IOException {
		int count = ((Long) getSession().createQuery("select count(*) from MuscleGroup").uniqueResult()).intValue();

		Session currentSession = getSession();
		if (count < 1) {
			absCrawlerMuscle();
			bicepsCrawlerMuscle();
			calvesCrawlerMuscle();
			chestCrawlerMuscle();
			forearmsCrawlerMuscle();
			quadsCrawlerMuscle();
			shoulderCrawlerMuscle();
			trapsCrawlerMuscle();
		}
		Query<MuscleGroup> theQuery = currentSession.createQuery("from MuscleGroup", MuscleGroup.class);
		List<MuscleGroup> musclegroups = theQuery.getResultList();
		// System.out.println("hello there: " + musclegroups);
		return musclegroups;
	}

	/**
	 * web scraper for calves muscle. creates an array of muscle names and
	 * descriptions. Then creates a muscle group object and populates database
	 * 
	 * @throws IOException
	 */
	private void calvesCrawlerMuscle() throws IOException {
		ArrayList<String> muscleArrayNames = new ArrayList<String>();
		ArrayList<String> description = new ArrayList<String>();
		Session currentSession = getSession();
		Document d = Jsoup.connect("https://musclewiki.org/Exercises/Male/Calves/").userAgent("Mozilla").get();
		Elements ele = d.select("div#mw-content-text");

		for (Element element : ele.select("div#heading-outbox")) {
			String muscleName = element.select("div#heading-leftbox").text();
			muscleArrayNames.add(muscleName);

		}

		for (Element element : ele.select("p")) {
			String muscleDesc = element.select("p").text();
			if (muscleDesc.endsWith("More...")) {
				muscleDesc = muscleDesc.substring(0, muscleDesc.length() - 8);
				description.add(muscleDesc);
			}
		}

		MuscleGroup tempMuscle = new MuscleGroup(muscleArrayNames.get(0), description.get(0));
		currentSession.saveOrUpdate(tempMuscle);

	}

	/**
	 * web scraper for quads muscle. creates an array of muscle names and
	 * descriptions. Then creates a muscle group object and populates database
	 * 
	 * @throws IOException
	 */
	private void quadsCrawlerMuscle() throws IOException {
		ArrayList<String> muscleArrayNames = new ArrayList<String>();
		ArrayList<String> description = new ArrayList<String>();
		Session currentSession = getSession();
		Document d = Jsoup.connect("https://musclewiki.org/Exercises/Male/Quads/").userAgent("Mozilla").get();
		Elements ele = d.select("div#mw-content-text");

		for (Element element : ele.select("div#heading-outbox")) {
			String muscleName = element.select("div#heading-leftbox").text();
			muscleArrayNames.add(muscleName);

		}

		for (Element element : ele.select("p")) {
			String muscleDesc = element.select("p").text();
			if (muscleDesc.endsWith("More...")) {
				muscleDesc = muscleDesc.substring(0, muscleDesc.length() - 8);
				description.add(muscleDesc);
			}
		}

		MuscleGroup tempMuscle = new MuscleGroup(muscleArrayNames.get(0), description.get(0));
		currentSession.saveOrUpdate(tempMuscle);

	}

	/**
	 * web scraper for forearms muscle. creates an array of muscle names and
	 * descriptions. Then creates a muscle group object and populates database
	 * 
	 * @throws IOException
	 */
	private void forearmsCrawlerMuscle() throws IOException {
		ArrayList<String> muscleArrayNames = new ArrayList<String>();
		ArrayList<String> description = new ArrayList<String>();
		Session currentSession = getSession();
		Document d = Jsoup.connect("https://musclewiki.org/Exercises/Male/Forearms/").userAgent("Mozilla").get();
		Elements ele = d.select("div#mw-content-text");

		for (Element element : ele.select("div#heading-outbox")) {
			String muscleName = element.select("div#heading-leftbox").text();
			muscleArrayNames.add(muscleName);

		}

		for (Element element : ele.select("p")) {
			String muscleDesc = element.select("p").text();
			if (muscleDesc.endsWith("More...")) {
				muscleDesc = muscleDesc.substring(0, muscleDesc.length() - 8);
				description.add(muscleDesc);
			}
		}

		MuscleGroup tempMuscle = new MuscleGroup(muscleArrayNames.get(0), description.get(0));
		currentSession.saveOrUpdate(tempMuscle);

	}

	/**
	 * web scraper for biceps muscle. creates an array of muscle names and
	 * descriptions. Then creates a muscle group object and populates database
	 * 
	 * @throws IOException
	 */
	private void bicepsCrawlerMuscle() throws IOException {
		ArrayList<String> muscleArrayNames = new ArrayList<String>();
		ArrayList<String> description = new ArrayList<String>();
		Session currentSession = getSession();
		Document d = Jsoup.connect("https://musclewiki.org/Exercises/Male/Biceps/").userAgent("Mozilla").get();
		Elements ele = d.select("div#mw-content-text");

		for (Element element : ele.select("div#heading-outbox")) {
			String muscleName = element.select("div#heading-leftbox").text();
			muscleArrayNames.add(muscleName);

		}

		for (Element element : ele.select("p")) {
			String muscleDesc = element.select("p").text();
			if (muscleDesc.endsWith("More...")) {
				muscleDesc = muscleDesc.substring(0, muscleDesc.length() - 8);
				description.add(muscleDesc);
			}
		}

		MuscleGroup tempMuscle = new MuscleGroup(muscleArrayNames.get(0), description.get(0));
		currentSession.saveOrUpdate(tempMuscle);

	}

	private void trapsCrawlerMuscle() throws IOException {
		ArrayList<String> muscleArrayNames = new ArrayList<String>();
		ArrayList<String> description = new ArrayList<String>();
		Session currentSession = getSession();
		Document d = Jsoup.connect("https://musclewiki.org/Exercises/Male/Traps/").userAgent("Mozilla").get();
		Elements ele = d.select("div#mw-content-text");

		for (Element element : ele.select("div#heading-outbox")) {
			String muscleName = element.select("div#heading-leftbox").text();
			muscleArrayNames.add(muscleName);

		}

		for (Element element : ele.select("p")) {
			String muscleDesc = element.select("p").text();
			if (muscleDesc.endsWith("More...")) {
				muscleDesc = muscleDesc.substring(0, muscleDesc.length() - 8);
				description.add(muscleDesc);
			}
		}

		MuscleGroup tempMuscle = new MuscleGroup(muscleArrayNames.get(0), description.get(0));
		currentSession.saveOrUpdate(tempMuscle);

	}

	/**
	 * web scraper for shoulder muscle. creates an array of muscle names and
	 * descriptions. Then creates a muscle group object and populates database
	 * 
	 * @throws IOException
	 */
	private void shoulderCrawlerMuscle() throws IOException {
		ArrayList<String> muscleArrayNames = new ArrayList<String>();
		ArrayList<String> description = new ArrayList<String>();
		Session currentSession = getSession();
		Document d = Jsoup.connect("https://musclewiki.org/Exercises/Male/Shoulders/").userAgent("Mozilla").get();
		Elements ele = d.select("div#mw-content-text");

		for (Element element : ele.select("div#heading-outbox")) {
			String muscleName = element.select("div#heading-leftbox").text();
			muscleArrayNames.add(muscleName);

		}

		for (Element element : ele.select("p")) {
			String muscleDesc = element.select("p").text();
			if (muscleDesc.endsWith("More...")) {
				muscleDesc = muscleDesc.substring(0, muscleDesc.length() - 8);
				description.add(muscleDesc);
			}
		}

		MuscleGroup tempMuscle = new MuscleGroup(muscleArrayNames.get(0), description.get(0));
		currentSession.saveOrUpdate(tempMuscle);

	}

	/**
	 * web scraper for abs muscle. creates an array of muscle names and
	 * descriptions. Then creates a muscle group object and populates database
	 * 
	 * @throws IOException
	 */
	private void absCrawlerMuscle() throws IOException {
		ArrayList<String> muscleArrayNames = new ArrayList<String>();
		ArrayList<String> description = new ArrayList<String>();
		Session currentSession = getSession();
		Document d = Jsoup.connect("https://musclewiki.org/Exercises/Male/Abdominals/").userAgent("Mozilla").get();
		Elements ele = d.select("div#mw-content-text");

		for (Element element : ele.select("div#heading-outbox")) {
			String muscleName = element.select("div#heading-leftbox").text();
			muscleArrayNames.add(muscleName);

		}

		for (Element element : ele.select("p")) {
			String muscleDesc = element.select("p").text();
			if (muscleDesc.endsWith("More...")) {
				muscleDesc = muscleDesc.substring(0, muscleDesc.length() - 8);
				description.add(muscleDesc);
			}
		}

		MuscleGroup tempMuscle = new MuscleGroup(muscleArrayNames.get(0), description.get(0));
		currentSession.saveOrUpdate(tempMuscle);

	}

	/**
	 * web scraper for chest muscle. creates an array of muscle names and
	 * descriptions. Then creates a muscle group object and populates database
	 * 
	 * @throws IOException
	 */
	private void chestCrawlerMuscle() throws IOException {
		ArrayList<String> muscleArrayNames = new ArrayList<String>();
		ArrayList<String> description = new ArrayList<String>();
		Session currentSession = getSession();
		Document d = Jsoup.connect("https://musclewiki.org/Exercises/Male/Chest/").userAgent("Mozilla").get();
		Elements ele = d.select("div#mw-content-text");

		for (Element element : ele.select("div#heading-outbox")) {
			String muscleName = element.select("div#heading-leftbox").text();
			muscleArrayNames.add(muscleName);

		}

		for (Element element : ele.select("p")) {
			String muscleDesc = element.select("p").text();
			if (muscleDesc.endsWith("More...")) {
				muscleDesc = muscleDesc.substring(0, muscleDesc.length() - 8);
				description.add(muscleDesc);
			}
		}

		MuscleGroup tempMuscle = new MuscleGroup(muscleArrayNames.get(0), description.get(0));
		currentSession.saveOrUpdate(tempMuscle);

	}

	@Override
	public MuscleGroup getMuscleGroup(String theId) {
		// get current session
		Session currentSession = getSession();

		// read from database using pk
		MuscleGroup theMuscleGroup = currentSession.get(MuscleGroup.class, theId);
		theMuscleGroup.getExercises();

		return theMuscleGroup;

	}

}
