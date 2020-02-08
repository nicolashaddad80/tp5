package fr.cnam.tp5;

public class PrimesPrinter {

    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                System.out.println("Usage : java PrimesPrinter <Classe Set> <MAX>");
            } else {
                String className = args[0];
                final int max = Integer.parseInt(args[1]);

                long time = System.nanoTime();
                Set ens = SetFabric.newSetFrom(className, max - 1);
                new Sieve(ens).run(max);
                System.out.println("Temps passé : " + ((System.nanoTime() - time) / 1000000.) + "ms");
            }
        } catch (NumberFormatException e) {
            System.out.println("Le deuxième argument doit être un entier !");
        } catch (ClassNotFoundException e) {
            System.out.println("Impossible de trouver la classe : " + e.getMessage());
        } catch (NoSuchMethodException e) {
            String name = args[0];
            System.out.println("La classe " + name + " doit définir :");
            System.out.println("\t- soit " + name + "(), constructeur par défaut");
            System.out.println("\t- soit " + name + "(int)");
        } catch (java.lang.reflect.InvocationTargetException e) {
            Throwable aSignaler = e.getCause() == null ? e : e.getCause();
            aSignaler.printStackTrace();
        } catch (Exception e) {
            System.out.println("Erreur lors de l'exécution : " + e.getMessage());
            e.printStackTrace();
        }
    }
}