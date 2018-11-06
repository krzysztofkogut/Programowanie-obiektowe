package microdvd;

import java.io.IOException;

public class MicroDVDApplication {

    public static void main(String[] arguments) {
        try {
            MicroDVD.microDVD(arguments[0], arguments[1],
                Integer.parseInt(arguments[2]), Integer.parseInt(arguments[3]));
        } catch (IndexOutOfBoundsException exe) {
            System.out.println("Zbyt mało argumentów programu. "
                + exe.getMessage());
        } catch (NumberFormatException exe) {
            System.out.println(
                "Błędne argumenty (3 i 4 powinny być liczbami). "
                    + exe.getMessage());
        } catch (IOException exe) {
            System.out.println("Błąd wejścia/wyjścia. "
                + exe.getMessage());
        } catch (UnproperDataException exe) {
            System.out.println("Błąd w pliku. "
                + exe.getMessage());
        }
    }
}