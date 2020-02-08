package fr.cnam.tp5;

import java.lang.reflect.InvocationTargetException;


class SetFabric {

    static Set newSetFrom(String className, int arg)
            throws InstantiationException, NoSuchMethodException,
            IllegalAccessException, ClassNotFoundException,
            InvocationTargetException {
        Set objet;

        Class<?> klass = Class.forName(className);
        if (klass.isInterface()) {
            throw new RuntimeException(klass.getName() + " est une interface !\nIl faut fournir une classe concrète.");
        }
        try {
            // essayer le constructeur par défaut
            objet = (Set) klass.getConstructor().newInstance();
        } catch (NoSuchMethodException | InstantiationException e) {
            // il doit y avoir un constructeur avec un entier en paramètre
            objet = (Set) klass.getConstructor(int.class).newInstance(arg);
        }

        return objet;
    }
}
