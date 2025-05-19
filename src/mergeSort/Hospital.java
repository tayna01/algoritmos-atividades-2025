package mergeSort;

import java.util.Arrays;

public class Hospital {

    public static void main(String[] args) {
        Object[][] pacientes = {
                {"João", 3, 5},
                {"Maria", 3, 10},
                {"Lucas", 5, 2}
        };

        Arrays.sort(pacientes, (p1, p2) -> {
            int grav1 = (int) p1[1];
            int grav2 = (int) p2[1];
            if (grav2 != grav1) {
                return grav2 - grav1;
            }
            int tempo1 = (int) p1[2];
            int tempo2 = (int) p2[2];
            return tempo2 - tempo1;
        });

        for (Object[] p : pacientes) {
            System.out.println(p[0]);
        }
    }
}
