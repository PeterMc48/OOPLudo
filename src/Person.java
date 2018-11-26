public abstract class Person implements PlayersTurn{
    private String name;

    /**
     * getter for Person class
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     * Setter for Person class
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * no argument construtor for Person Class
     */
    public Person()
    {
        this("Unknown");
    }

    /**
     *single argument constructor for Person class
     */
    public Person(String name)
    {
        setName(name);
    }


    /**
     * toString Method for Person Class
     * @return
     */

    @Override
    public String toString() {
        return "Name: " + getName();
    }
}
