import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Ristorante> risto = Arrays.asList(
                new Ristorante("La pergoladddddddddddddddddddd", TipoRistorante.RISTO, 55),
                new Ristorante("L’etico", TipoRistorante.PIZZERIA, 235),
                new Ristorante("Da Rossi", TipoRistorante.RISTO, 400),
                new Ristorante("Da Gigi", TipoRistorante.PIZZERIA, 42),
                new Ristorante("Giggetto", TipoRistorante.PIZZERIA, 80),
                new Ristorante("Da Ivo", TipoRistorante.PIZZERIA, 150),
                new Ristorante("Romolo e Luigi", TipoRistorante.PIZZERIA, 50),
                new Ristorante("La terrazza", TipoRistorante.RISTO, 40)
        );


        createFileWithAllRestaurants(risto);
        readAllTheRestaurantsFromFile();
        System.out.println("\nEsercizio 1");
        es1(risto);

        System.out.println("\nEsercizio 2");
        es2(risto);

        System.out.println("\nEsercizio 3");
        es3(risto);

        System.out.println("\nEsercizio 4");
        es4(risto);

        System.out.println("\nEsercizio 5");
        es5(risto);

        System.out.println("\nEsercizio 6");
        es6(risto);
        System.out.println("\nEsercizio 7");
        es7(risto);
        System.out.println("\nEsercizio 8");
        es8(risto);
        System.out.println("\nEsercizio 9");
        es10(risto);
        System.out.println("\nEsercizio 10");
        restaurantWithMostCoperti(risto);
        System.out.println("\nEsercizio 11");
        test(risto);
    }


    private static void readAllTheRestaurantsFromFile() {
        try {
            System.out.println("\nWe are reading the file we have just created");
            System.out.println("********************************************");
            BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line + "\n");
            }
            reader.close();
            System.out.println("********************************************");
            System.out.println("\nRead completed");
            System.out.println("********************************************");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createFileWithAllRestaurants(List<Ristorante> risto) {
        try {
            System.out.println("********************************************");
            System.out.println("\nCreating a file that contains all the restaurants");
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            for (Ristorante r : risto) {
                writer.write("\n" + r);
            }

            writer.close();
            System.out.println("********************************************");
            System.out.println("\nFile creation completed");
            System.out.println("********************************************");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\nError creating file");
        }
    }

    public static void es1(List<Ristorante> lista) {
        List<Ristorante> l = lista.stream()
                .sorted(Comparator.comparing(Ristorante::getCoperti).reversed())
                .collect(Collectors.toList());
        l.forEach(System.out::println);
    }

    public static void es2(List<Ristorante> lista) {
        Set<Ristorante> l = lista.stream()
                .filter(r -> r.getCoperti() >= 45)
                .collect(Collectors.toSet());
        System.out.println(l);
    }

    public static void es3(List<Ristorante> lista) {
        List<Ristorante> l = lista.stream()
                .sorted(Comparator.comparing(Ristorante::getCoperti))
                .collect(Collectors.toList());
        System.out.println(l);
    }

    public static void es4(List<Ristorante> lista) {
        List<Ristorante> l = lista.stream()
                .sorted(Comparator.comparing(Ristorante::getNome))
                .map(r -> {
                    String addvirgola = ",";
                    addvirgola = r.getNome() + addvirgola;
                    return r;
                })
                .collect(Collectors.toList());
        System.out.println(l);

    }

    public static void es5(List<Ristorante> lista) {
        Integer sum = lista.stream()
                .map(r -> r.getCoperti()).mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }


    public static void es6(List<Ristorante> lista) {
        List<Ristorante> l = lista.stream()
                .filter(r -> r.getCoperti() < 50)
                .map(r -> {
                            int changenumerocoperti = r.getCoperti() + 25;
                            r.setCoperti(changenumerocoperti);
                            return r;
                        }
                )
                .collect(Collectors.toList());
        l.forEach(System.out::println);
    }

    public static void es7(List<Ristorante> lista) {
        Map<Integer, TipoRistorante> l = lista.stream()
                .collect(Collectors.toMap(Ristorante::getCoperti, Ristorante::getTipo));
        System.out.println(l);

    }


    public static void es8(List<Ristorante> lista) {
        Map<Integer, TipoRistorante> l = lista.stream()
                .collect(Collectors.toMap(Ristorante::getCoperti, Ristorante::getTipo));
        System.out.println(l);

    }

    public static void es9(List<Ristorante> lista) {
        List<Ristorante> ristorante = lista.stream()
                .skip(3)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(ristorante);
    }

    public static void es10(List<Ristorante> lista) {
        List<Ristorante> ristorante = lista.stream()
                .sorted(Comparator.comparing(Ristorante::getNome))
                .collect(Collectors.toList());
        ristorante.forEach(System.out::println);

    }

    public static void restaurantWithMostCoperti(List<Ristorante> risto) {
        Optional<String> restaurantWithMostCoperti = risto.stream()
                .filter(r -> r.getTipo().equals(TipoRistorante.RISTO))
                .max(Comparator.comparing(Ristorante::getCoperti))
                .map(r -> r.getNome() + " " + r.getCoperti());
        restaurantWithMostCoperti.ifPresent(System.out::println);

    }

    public static void test(List<Ristorante> lista) {
        List<String> rt = lista.stream()
                .filter(r -> r.getTipo() == TipoRistorante.PIZZERIA)
                .map(Ristorante::getNome)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        rt.forEach(System.out::println);
    }

}