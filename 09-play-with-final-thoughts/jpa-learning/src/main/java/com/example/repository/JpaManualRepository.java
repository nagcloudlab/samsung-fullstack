package com.example.repository;

import com.example.entity.Boy;
import com.example.entity.Employee;
import com.example.entity.Gender;
import com.example.entity.Girl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public class JpaManualRepository {

    @PersistenceContext
    EntityManager entityManager;


    @Transactional
    public void manageEmployees() {
        Employee employee = new Employee();
//		employee.setId(1);

//		EmployeeID employeeID = new EmployeeID();
//		employeeID.setDivision(10);
//		employeeID.setId(1);
//		employee.setEmployeeID(employeeID);

        employee.setName("John Doe");
        employee.setGender(Gender.MALE);
        employee.setDob(new Date());
        employee.setProfile("I am a Java Developer".repeat(5));
        employee.setImage("image".getBytes());

//		Address address = new Address();
//		address.setDoorNumber("123");
//		address.setStreet("ABC Street");
//		address.setCity("XYZ City");
//		address.setAddressType(AddressType.HOME);
//
//		Address officeAddress = new Address();
//		officeAddress.setDoorNumber("456");
//		officeAddress.setStreet("DEF Street");
//		officeAddress.setCity("UVW City");
//		officeAddress.setAddressType(AddressType.OFFICE);
//
//		employee.getAddresses().add(address);
//		employee.getAddresses().add(officeAddress);

        entityManager.persist(employee);
    }

    @Transactional
    public void saveBoy() {
        Girl girl = new Girl();
        girl.setId(22);
        girl.setName("Jane");
        Boy boy = new Boy();
        boy.setId(11);
        boy.setName("John");
        boy.setGirl(girl);
        entityManager.persist(boy);
    }

    public Girl selectGirl() {
        Girl girl = entityManager.find(Girl.class, 22);
        return girl;
    }

    public Boy selectBoy() {
        Boy boy = entityManager.find(Boy.class, 11);
//        System.out.println(boy.getId());
//        System.out.println(boy.getName());
//        System.out.println(boy.getGirl().getName());
        return boy;
    }

    @Transactional(readOnly = true)
    public void selectBoyAndGirl() {
        Boy boy = entityManager.find(Boy.class, 11); // separate connection
        Girl girl = entityManager.find(Girl.class, 22); // separate connection
        System.out.println(boy.getName());
        System.out.println(girl.getName());
    }


    @Transactional
    public void selectBoyUpdateName(){
        Boy boy=entityManager.find(Boy.class,11); // Managed state
        boy.setName("John Doe");
    }

    // JPQL
    @Transactional(readOnly = true)
    public void selectBoyByJPQL() {
       Boy boy = entityManager.createQuery("from Boy e where e.id = 11", Boy.class).getSingleResult();
       System.out.println(boy.getName());
    }

    // Criteria API
    @Transactional(readOnly = true)
    public void selectBoyByCriteriaAPI() {
        //..
    }


}
