package Hibernate.Controller;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Hibernate.Entity.Student;
import Hibernate.Util.HibernateUtil;

import javax.persistence.Query;

@Controller
public class HibernateController {

	@RequestMapping("/hello_kaan")
	public String red(Model model) throws Exception {
		
		model.addAttribute("name", "KAAN");

		return "welcome_mr";
	}
	
	@RequestMapping("/student_add")
	public String green(Model model) throws Exception {
		
		Student student1 = new Student("ALEX", "KOVIAC", "alexkoviac@gmail.com", "MALE", "IAU", "ENGINEERING");
        Student student2 = new Student("MARIA", "BECOVIAN", "mariabecovian@gmail.com", "FEMALE", "BAU", "LAW");
        Student student3 = new Student("JONHATTAN", "WHITE", "jonhattanwhite@gmail.com", "MALE", "BAU", "LAW");
        Student student4 = new Student("LARA", "MENOVIN", "laramenovin@gmail.com", "FEMALE", "BAU", "ENGINEERING");
        Student student5 = new Student("TONY", "KARLEUCI", "tonykarleuci@gmail.com", "MALE", "IAU", "ENGINEERING");
        Student student6 = new Student("KEN", "JONEC", "kenjonec@gmail.com", "MALE", "BAU", "LAW");
        Student student7 = new Student("MAURA", "SILVA", "maurasilva@gmail.com", "FEMALE", "IAU", "LAW");
        Student student8 = new Student("ALEXANDRA", "MERRY", "alexandramerry@gmail.com", "FEMALE", "IAU", "ENGINEERING");
        
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        // Start A Transaction
        transaction = session.beginTransaction();
            
        // Save The Student Objects
        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);
        session.save(student5);
        session.save(student6);
        session.save(student7);
        session.save(student8);
            
        // Commit Transaction
        transaction.commit();
            
		return "welcome_add";
	}
	
	@RequestMapping("/student_list")
	public String blue(Model model) throws Exception {

		Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session = HibernateUtil.getSessionFactory().openSession();
        List < Student > students = session.createQuery("FROM Student ORDER BY id", Student.class).list();
        
        session.close();
        model.addAttribute("data", students);
        
		return "welcome_list";
	}
	
	@RequestMapping("/student_delete")
	public String black(Model model) throws Exception{
		
		Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        transaction = session.beginTransaction();
        
        /*
        // Delete The Student Objects
        Student student1 = new Student();
	    student1.setId(1);
        session.delete(student1);
        
        // Delete The Student Objects
        Student student2 = new Student();
	    student2.setId(2);
        session.delete(student2); 
        */
        
        Query query = (Query) session.createQuery("DELETE FROM Student");
        int result = query.executeUpdate();
        
        transaction.commit();
        session.close();

		return "welcome_delete";
	}
	
	@RequestMapping("/student_order_by_firstname")
	public String yellow(Model model) throws Exception{
		
		Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        transaction = session.beginTransaction();
        
        String hql = "FROM Student as S ORDER BY S.firstName";
		List<Student> students = session.createQuery(hql).list();
        
        transaction.commit();
        session.close();
        model.addAttribute("data", students);

		return "welcome_firstname";
	}
	
	@RequestMapping("/student_order_by_department_eng")
	public String brown(Model model) throws Exception{
		
		Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        transaction = session.beginTransaction();
        
        String hql = "FROM Student S WHERE S.department = 'ENGINEERING' ORDER BY id";
        //Query query = session.createQuery(hql);
        List<Student> students = session.createQuery(hql).list();
        
        transaction.commit();
        session.close();
        model.addAttribute("data", students);

		return "welcome_engineering";
	}
	
	@RequestMapping("/student_order_by_department_law")
	public String pink(Model model) throws Exception{
		
		Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        transaction = session.beginTransaction();
        
        String hql = "FROM Student S WHERE S.department = 'LAW' ORDER BY id";
        Query query = session.createQuery(hql);
        List<Student> students = session.createQuery(hql).list();
        
        transaction.commit();
        session.close();
        model.addAttribute("data", students);

		return "welcome_law";
	}
}
