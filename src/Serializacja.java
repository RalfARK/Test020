import java.io.*;

public class Serializacja {


    public static void main(String[] args) {
        ListaImion l1 = new ListaImion();

        System.out.println("Zaczynamy!");
        l1.dodajImieZKonsoli();
        l1.dodajImieZKonsoli();
        l1.dodajImieZKonsoli();

        System.out.println("");
        System.out.println("Wypisujemy: ");
        l1.wypiszImiona();

        System.out.println("");
        System.out.println("Serializacja: ");
        l1.serializuj();

        System.out.println("");
        System.out.println("Dodanie imienia na test i wypisanie: ");
        l1.dodajImie("TEST");
        l1.wypiszImiona();

        System.out.println("");
        System.out.println("DESerializacja i wypisanie: ");
        l1.deserializuj();
        l1.wypiszImiona();

        System.out.println("");
        System.out.println("HUMAN!!!");
        Human h1 = new Human("imie", 20);

        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("age.bin"))) {
            output.writeObject(new Human("Piotrek", 23));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("age.bin"))) {
            Human human = (Human) input.readObject();
            System.out.println(human.getName());
            System.out.println(human.getAge());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}