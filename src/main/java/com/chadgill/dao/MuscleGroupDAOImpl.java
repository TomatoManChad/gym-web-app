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
	public List<MuscleGroup> getAllMuscleGroups() {
		
		Session currentSession = getSession();
		Query<MuscleGroup> theQuery = currentSession.createQuery("from MuscleGroup", MuscleGroup.class);
		List<MuscleGroup> musclegroups = theQuery.getResultList();
		System.out.println("hello there: " + musclegroups);
		return musclegroups;	
	}

}
