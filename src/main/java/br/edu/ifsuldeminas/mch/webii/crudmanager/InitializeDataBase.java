package br.edu.ifsuldeminas.mch.webii.crudmanager;

import java.util.Calendar;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.EventRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.CoordRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Coord;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Event;
@Component
@Transactional
public class InitializeDataBase implements CommandLineRunner{
    
    @Autowired
    private CoordRepository coordRepository;
    @Autowired
    private EventRepository eventRepository;
    
    @Override
    public void run(String... args) throws Exception {
        Coord emerson = new Coord();
        emerson.setFullName("Emerson");
        emerson.setEmail("emerson@gmail.com");
        emerson.setNumber("(35)93214-5648");
        emerson.setRole("Docente");
        
        Coord luiza = new Coord();
        luiza.setFullName("Luiza");
        luiza.setEmail("luiza@gmail.com");
        luiza.setNumber("(35)98645-3214");
        luiza.setRole("TAE");
        
        Coord leo = new Coord();
        leo.setFullName("Leo");
        leo.setEmail("leo@gmail.com");
        leo.setNumber("(35)97217-2809");
        leo.setRole("TAE");
        
        Event CIT = new Event();
        CIT.setEventName("Conferência Internacional de Tecnologia");
        Calendar startDateCIT = Calendar.getInstance();
        startDateCIT.set(2023, Calendar.JUNE, 15);
        CIT.setDateStart(startDateCIT.getTime());
        Calendar endDateCIT = Calendar.getInstance();
        endDateCIT.set(2023, Calendar.JULY, 17);
        CIT.setDateEnd(endDateCIT.getTime());
        CIT.setLocation("Centro de Convenções ABC");
        CIT.setCoord(leo);

        Event IF = new Event();
        IF.setEventName("IF de Portas Abertas");
        Calendar startDateIF = Calendar.getInstance();
        startDateIF.set(2023, Calendar.JUNE, 26);
        IF.setDateStart(startDateIF.getTime());
        Calendar endDateIF = Calendar.getInstance();
        endDateIF.set(2023, Calendar.OCTOBER, 26);
        IF.setDateEnd(endDateIF.getTime());
        IF.setLocation("Auditório Antônio Estanislau");
        IF.setCoord(emerson);


        coordRepository.save(emerson);
        coordRepository.save(luiza);
        coordRepository.save(leo);
        eventRepository.save(CIT);
        eventRepository.save(IF);
        
        
     }
    
}