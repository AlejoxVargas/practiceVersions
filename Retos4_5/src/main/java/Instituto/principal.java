package Instituto;

import java.time.LocalDate;

public class principal {

    public static void main(String[] args) {
        alumno alumno1 = new alumno("Jennie", "Kim", LocalDate.of(1996, 1, 16));
        alumno alumno2 = new alumno("Ji-soo", "Kim", LocalDate.of(1995, 1, 3));
        alumno alumno3 = new alumno("Lalisa", "Manobal", LocalDate.of(1997, 3, 27));
        alumno alumno4 = new alumno("Roseanne", "Park", LocalDate.of(1997, 2, 11));
        alumno alumno5 = new alumno("Momo", "Hirai", LocalDate.of(1996, 11, 9));

    }

}
