public abstract class Person{
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
     *single argument constructor fo rPerson class
     */
    public Person(String name)
    {
        setName(name);
    }


    @Override
    public String toString() {
        return "Name: " + getName();
    }
}
