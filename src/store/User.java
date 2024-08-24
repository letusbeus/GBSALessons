package store;

public abstract class User {

    private static int counter = 1000;

    protected int id;

    public int getId() {
        return id;
    }

    {
        id = ++counter;
    }

}
