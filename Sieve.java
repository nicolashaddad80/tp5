package fr.cnam.tp5;

class Sieve {
    private Set nombres;

    Sieve(Set ens) {
        this.nombres = ens;
    }

    void run(int max) {
        for (int natural = 2; natural <= max; natural++) {
            this.nombres.add(natural);
        }

        System.out.println("Nombres premiers : ");
        int nb = 0;
        while (!this.nombres.isEmpty()) {
            int premier = this.nombres.min();

            if (nb > 0) {
                System.out.print(", ");
            }
            if (nb %37 ==0) {
                System.out.print("\n");
            }
            System.out.print(premier);
            nb++;
            System.out.flush();

            for (int multiple = premier; multiple <= max; multiple += premier) {
                this.nombres.remove(multiple);
            }
        }
        System.out.println();
    }
}
