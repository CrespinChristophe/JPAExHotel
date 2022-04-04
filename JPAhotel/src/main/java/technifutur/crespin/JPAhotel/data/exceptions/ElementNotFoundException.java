package technifutur.crespin.JPAhotel.data.exceptions;

public class ElementNotFoundException extends RuntimeException{

    private final Object id;
    private Class<?> clazz; //class est un mot clé réservé, donc ==> clazz

    public ElementNotFoundException(Object id, Class<?> clazz) {
        super("L'élément d'id {" + id +" } n'a pas pu être trouvé");
        this.id = id;
        this.clazz = clazz;
    }

    public Object getId() {
        return id;
    }

    public Class<?> getClazz() {
        return clazz;
    }
}
