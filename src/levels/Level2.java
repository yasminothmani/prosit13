package levels;

import models.Teacher;
import utils.Data;

import java.util.List;
import java.util.stream.Collectors;

public class Level2 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();

        /* TO DO 1: Retourner le nombre des enseignants dont le nom commence avec s */
        long nbr = teachers.stream().filter(t-> t.getName().startsWith("s") || t.getName().startsWith("S")).count();

        /* TO DO 2: Retourner la somme des salaires de tous les enseignants Flutter (hint: mapToInt) */
        long sum = teachers.stream().filter(t-> t.getSubject().equals("Flutter")).mapToLong(Teacher::getSalary).sum();

        /* TO DO 3: Retourner la moyenne des salaires des enseignants dont le nom commence avec a */
        double average = teachers.stream().filter(teacher -> teacher.getName().startsWith("a") || teacher.getName().startsWith("A")).mapToDouble(Teacher::getSalary).average().orElse(0.0);


        /* TO DO 4: Retourner la liste des enseignants dont le nom commence par f */
        List<Teacher> teachers1 = teachers.stream().filter(teacher -> teacher.getName().startsWith("f") || teacher.getName().startsWith("F")).collect(Collectors.toList());

        /* TO DO 5: Retourner la liste des enseignants dont le nom commence par s */
        List<Teacher> teachers2 = teachers.stream().filter(teacher -> teacher.getName().startsWith("s") || teacher.getName().startsWith("S"))
                .collect(Collectors.toList());

        /* TO DO 5: Retourner true si il y a au min un enseignants dont le salaire > 100000, false si non */
        boolean test = teachers.stream().anyMatch(teacher -> teacher.getSalary() > 100000);

        /* TO DO 6: Afficher le premier enseignant Unity le nom commence avec g avec 2 manières différentes */
        /*First way*/
        teachers.stream().filter(teacher -> teacher.getSubject().equals("Unity") && teacher.getName().startsWith("g") || teacher.getName().startsWith("G")).
                findFirst().ifPresent(System.out::println);
        ;
        /*Second way*/
        teachers.stream().filter(teacher -> teacher.getSubject().equals("Unity") && teacher.getName().startsWith("g") || teacher.getName().startsWith("G"))
                .limit(1)
                .forEach(System.out::println);


        /* TO DO 7: Afficher le deuxième enseignant dont le nom commence avec s */
        teachers.stream()
                .filter(teacher -> teacher.getName().startsWith("s") || teacher.getName().startsWith("S"))
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);

    }
}
