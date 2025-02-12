package com.example.diploma.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DayOfWeek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Day name;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Class> className;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Lesson> lessons;

    public DayOfWeek(Day name, List<Class> className, List<Lesson> lessons) {
        this.name = name;
        this.className = className;
        this.lessons = lessons;
    }
}

