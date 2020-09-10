package com.udacity.jdnd.course3.critter.user.entity;

import javax.persistence.*;

/*
Customer and Employee Entities both have name
By using User parent entity, any current or will-be-added shared fields
can be written once in the User.
Using the TABLE_PER_CLASS strategy here so that any current or will-be-added unique
fields from child entities can have "not null" constraint.
With TABLE_PER_CLASS strategy, non-polymorphic queries is optimized and can use UNION
to achieve polymorphic queries.
* */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(nullable = false)
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
