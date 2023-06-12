package com.parthu.Runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.parthu.Repo.CitizenRepo;
import com.parthu.entity.CitizenPlan;

@Component
public class CitizenRunner implements ApplicationRunner {
	
	@Autowired
	private CitizenRepo repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		repo.deleteAll();
		
		CitizenPlan c1=new CitizenPlan();
		c1.setCitizenGender("Male");
		c1.setCitizenPlan("Cash");
		c1.setCitizenPlanStartDate(LocalDate.now());
		c1.setCitizenPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBeneficiaryAmount(20000.00);
		c1.setCitizenStatus("Approved");
		c1.setCitizenName("Raja");
		
		CitizenPlan c2=new CitizenPlan();
		c2.setCitizenGender("Male");
		c2.setCitizenPlan("Cash");
		c2.setCitizenPlanStartDate(LocalDate.now());
		c2.setCitizenPlanEndDate(LocalDate.now().plusMonths(6));
		c2.setBeneficiaryAmount(25000.0);
		c2.setCitizenStatus("Approved");
		c2.setCitizenName("MahaRaja");
		
		CitizenPlan c3=new CitizenPlan();
		c3.setCitizenGender("Male");
		c3.setCitizenPlan("Cash");
		c3.setTerminateDate(LocalDate.now().minusMonths(5));
		c3.setTerminateEndDate(LocalDate.now());
		c3.setTerminateReason("Employeed");
		c3.setCitizenStatus("Denied");
		c3.setCitizenName("Kiran");
		
		CitizenPlan c4=new CitizenPlan();
		c4.setCitizenGender("Fe-Male");
		c4.setCitizenPlan("Cash");
		c4.setTerminateDate(LocalDate.now().minusMonths(3));
		c4.setTerminateEndDate(LocalDate.now());
		c4.setTerminateReason("Employeed");
		c4.setCitizenStatus("Denied");
		c4.setCitizenName("Kirthi");
		
		CitizenPlan c5=new CitizenPlan();
		c5.setCitizenGender("Fe-Male");
		c5.setCitizenPlan("Cash");
		c5.setCitizenPlanStartDate(LocalDate.now());
		c5.setCitizenPlanEndDate(LocalDate.now().plusMonths(5));
		c5.setBeneficiaryAmount(35000.00);
		c5.setCitizenStatus("Approved");
		c5.setCitizenName("Swathi");
		
		CitizenPlan c6=new CitizenPlan();
		c6.setCitizenGender("Fe-Male");
		c6.setCitizenPlan("Finance");
		c6.setCitizenPlanStartDate(LocalDate.now());
		c6.setCitizenPlanEndDate(LocalDate.now().plusMonths(6));
		c6.setBeneficiaryAmount(25000.00);
		c6.setCitizenStatus("Approved");
		c6.setCitizenName("Jhothi");
		

		CitizenPlan c7=new CitizenPlan();
		c7.setCitizenGender("Male");
		c7.setCitizenPlan("Finance");
		c7.setCitizenPlanStartDate(LocalDate.now());
		c7.setCitizenPlanEndDate(LocalDate.now().plusMonths(6));
		c7.setBeneficiaryAmount(25000.00);
		c7.setCitizenStatus("Approved");
		c7.setCitizenName("Shiva");
		
		CitizenPlan c8=new CitizenPlan();
		c8.setCitizenGender("Male");
		c8.setCitizenPlan("Finance");
		c8.setCitizenPlanStartDate(LocalDate.now());
		c8.setCitizenPlanEndDate(LocalDate.now().plusMonths(9));
		c8.setBeneficiaryAmount(15000.00);
		c8.setCitizenStatus("Approved");
		c8.setCitizenName("Raja");
		

		CitizenPlan c9=new CitizenPlan();
		c9.setCitizenGender("Fe-Male");
		c9.setCitizenPlan("Cash");
		c9.setTerminateDate(LocalDate.now().minusMonths(3));
		c9.setTerminateEndDate(LocalDate.now());
		c9.setTerminateReason("Self-Employeed");
		c9.setCitizenStatus("Denied");
		c9.setCitizenName("Kirthi");
		
		CitizenPlan c10=new CitizenPlan();
		c10.setCitizenGender("Fe-Male");
		c10.setCitizenPlan("Finance");
		c10.setTerminateDate(LocalDate.now().minusMonths(3));
		c10.setTerminateEndDate(LocalDate.now());
		c10.setTerminateReason("Own-Company");
		c10.setCitizenStatus("Denied");
		c10.setCitizenName("Kirthi-Suresh");
		
		CitizenPlan c11=new CitizenPlan();
		c11.setCitizenGender("Fe-Male");
		c11.setCitizenPlan("Cash");
		c11.setTerminateDate(LocalDate.now().minusMonths(3));
		c11.setTerminateEndDate(LocalDate.now());
		c11.setTerminateReason("Queen of Kingdom");
		c11.setCitizenStatus("Denied");
		c11.setCitizenName("Rani");
		
		CitizenPlan c12=new CitizenPlan();
		c12.setCitizenGender("Fe-Male");
		c12.setCitizenPlan("Finance");
		c12.setTerminateDate(LocalDate.now().minusMonths(3));
		c12.setTerminateEndDate(LocalDate.now());
		c12.setTerminateReason("Owner-of-Chit-Fund");
		c12.setCitizenStatus("Denied");
		c12.setCitizenName("Suri");
		
		
		List<CitizenPlan> list = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
		repo.saveAll(list);
		
		System.out.println("Record Inserted...!!!");
		
	}
	

	

}
