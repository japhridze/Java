package com.epam.rd.autocode.collections;

import java.math.BigDecimal;
import java.util.*;

public class StudentGradebookImpl implements StudentGradebook {

	private final TreeMap<Student, Map<String, BigDecimal>> gradeBook;

	public StudentGradebookImpl() {
		this.gradeBook = new TreeMap<>(Comparator
				.comparing(Student::getFirstName)
				.thenComparing(Student::getLastName)
				.thenComparing(Student::getGroup));
	}

	@Override
	public boolean addEntryOfStudent(Student student, String discipline, BigDecimal grade) {
		Map<String, BigDecimal> disciplines = gradeBook.computeIfAbsent(student, k -> new HashMap<>());
		if (disciplines.containsKey(discipline)) {
			return false; // Entry already exists for this discipline
		}
		disciplines.put(discipline, grade);
		return true;
	}

	@Override
	public int size() {
		return gradeBook.size();
	}

	@Override
	public Comparator<Student> getComparator() {
		return (Comparator<Student>) gradeBook.comparator();
	}

	@Override
	public List<String> getStudentsByDiscipline(String discipline) {
		List<String> studentsByDiscipline = new ArrayList<>();
		for (Map.Entry<Student, Map<String, BigDecimal>> entry : gradeBook.entrySet()) {
			BigDecimal grade = entry.getValue().get(discipline);
			if (grade != null) {
				studentsByDiscipline.add(entry.getKey().getFirstName() + "_" + entry.getKey().getLastName() + ": " + grade);
			}
		}
		return studentsByDiscipline;
	}

	@Override
	public Map<Student, Map<String, BigDecimal>> removeStudentsByGrade(BigDecimal thresholdGrade) {
		Map<Student, Map<String, BigDecimal>> removedStudents = new TreeMap<>(getComparator());

		Iterator<Map.Entry<Student, Map<String, BigDecimal>>> iterator = gradeBook.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Student, Map<String, BigDecimal>> entry = iterator.next();
			if (entry.getValue().values().stream().anyMatch(grade -> grade.compareTo(thresholdGrade) < 0)) {
				removedStudents.put(entry.getKey(), entry.getValue());
				iterator.remove();
			}
		}

		return removedStudents;
	}

	@Override
	public Map<BigDecimal, List<Student>> getAndSortAllStudents() {
		TreeMap<BigDecimal, List<Student>> sortedStudents = new TreeMap<>();

		for (Map.Entry<Student, Map<String, BigDecimal>> entry : gradeBook.entrySet()) {
			BigDecimal average = calculateAverage(entry.getValue());
			sortedStudents.computeIfAbsent(average, k -> new ArrayList<>()).add(entry.getKey());
		}

		return sortedStudents;
	}

	private BigDecimal calculateAverage(Map<String, BigDecimal> grades) {
		BigDecimal sum = BigDecimal.ZERO;
		for (BigDecimal grade : grades.values()) {
			sum = sum.add(grade);
		}
		return sum.divide(BigDecimal.valueOf(grades.size()), 1, BigDecimal.ROUND_HALF_UP);
	}
}