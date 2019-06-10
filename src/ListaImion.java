import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class ListaImion implements Serializable {
    private List<String> lista;

    public ListaImion() {
        lista = new ArrayList<String>();
    }

    public void wypiszImiona() {
        Stream<String> imiona = lista.stream();
        imiona.forEach(System.out::println);
    }

    public void dodajImie (String imie) {
        lista.add(imie);
    }

    public void dodajImieZKonsoli () {
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj imie:");
        lista.add(in.nextLine());
    }

    public void serializuj() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("D:\\Rafal\\PROGRAMOWANIE\\JAVA\\IdeaProjects\\Test020\\ser.bin"))) {
            outputStream.writeObject(lista);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deserializuj() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("D:\\Rafal\\PROGRAMOWANIE\\JAVA\\IdeaProjects\\Test020\\ser.bin"))) {
            lista = (List) inputStream.readObject();
        }
        catch (IOException e)  {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
    }
}
