package ru.ifmo.rain.bolotov.student;

import info.kgeorgiy.java.advanced.student.Student;
import info.kgeorgiy.java.advanced.student.StudentQuery;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentDB implements StudentQuery {
    @Override
    public List<String> getFirstNames(List<Student> list) {
        return collectStudents(list, Student::getFirstName);

    }

    @Override
    public List<String> getLastNames(List<Student> list) {
        return collectStudents(list, Student::getLastName);
    }

    @Override
    public List<String> getGroups(List<Student> list) {
        return collectStudents(list, Student::getGroup);
    }

    @Override
    public List<String> getFullNames(List<Student> list) {
        return collectStudents(list, s -> s.getFirstName() + " " + s.getLastName());
    }

    @Override
    public Set<String> getDistinctFirstNames(List<Student> list) {
        return collectStudents(list, Student::getFirstName, Collectors.toCollection(TreeSet::new));
    }

    @Override
    public String getMinStudentFirstName(List<Student> list) {
        return list.stream().min(Student::compareTo).map(Student::getFirstName).orElse("");
    }

    @Override
    public List<Student> sortStudentsById(Collection<Student> collection) {
        return comparator(collection, Comparator.comparing(Student::getId));
    }

    @Override
    public List<Student> sortStudentsByName(Collection<Student> collection) {
        return comparator(collection, compareByName);

    }

    private List<Student> comparator(Collection<Student> students, Comparator<Student> comp) {
        return students.stream().sorted(comp).collect(Collectors.toList());
    }

    @Override
    public List<Student> findStudentsByFirstName(Collection<Student> collection, String s) {
        return filterStudents(collection, student -> student.getFirstName().equals(s),compareByName);
    }

    @Override
    public List<Student> findStudentsByLastName(Collection<Student> collection, String s) {
        return filterStudents(collection, student -> student.getLastName().equals(s), compareByName);
    }

    private List<Student> filterStudents(Collection<Student> students, Predicate<Student> predicate, Comparator<Student> comparator) {
        return students.stream().filter(predicate).sorted(comparator).collect(Collectors.toList());

    }

    @Override
    public List<Student> findStudentsByGroup(Collection<Student> collection, String s) {
        return filterStudents(collection, student -> student.getGroup().equals(s), compareByName).
                stream().sorted(compareByName).collect(Collectors.toList());
    }

    @Override
    public Map<String, String> findStudentNamesByGroup(Collection<Student> collection, String s) {
        return collection.stream().filter(student -> student.getGroup().
                equals(s)).
                collect(Collectors.toMap(Student::getLastName, Student::getFirstName,
                        BinaryOperator.minBy(String::compareTo)));
    }

    private static final Comparator<Student> compareByName =
            Comparator.comparing(Student::getLastName, String::compareTo).
                    thenComparing(Student::getFirstName, String::compareTo).
                    thenComparingInt(Student::getId);

    private <collection extends Collection<String>>
    collection collectStudents(List<Student> students, Function<Student, String> mapper, Collector<String, ?, collection> collector) {
        return students.stream().map(mapper).collect(collector);
    }

    private List<String> collectStudents(List<Student> students, Function<Student, String> mapping) {
        return students.stream().map(mapping).collect(Collectors.toList());
    }

}