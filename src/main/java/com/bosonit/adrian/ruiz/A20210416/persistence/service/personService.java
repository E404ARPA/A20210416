package com.bosonit.adrian.ruiz.A20210416.persistence.service;

import com.bosonit.adrian.ruiz.A20210416.controller.exceptions.personNotFoundException;
import com.bosonit.adrian.ruiz.A20210416.model.person.person;
import com.bosonit.adrian.ruiz.A20210416.persistence.repository.personRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class personService extends BaseService <person, String, personRepository> {
    public person birthdaySrvc(person p) {
        p.setAge(p.getAge()+1);
        return p;
    }

    public Boolean genPersonByHeadersSrvc(String name, String town, Integer age) {
        this.repo.save(new person(name, town, age));
        return this.repo.findById(name).isPresent();
    }

    public person oldifierSrvc(String name, Integer multFactor) {
        Optional<person> p = this.repo.findById(name);

        if (p.isEmpty())
            throw new personNotFoundException(name);

        return new person(p.get().getName(),
                          p.get().getTown(),
                      p.get().getAge()*multFactor);
    }

    public String greetingsSrvc(String name) {
        Optional<person> p = this.repo.findById(name);

        if (p.isEmpty())
            throw new personNotFoundException(name);

        return "Hello " + p.get().getName();
    }

    public Boolean personAddSrvc(person person) {
        this.repo.save(person);
        return this.repo.findById(person.getName()).isPresent();
    }
}
