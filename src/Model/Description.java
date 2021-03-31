package Model;

public class Description {
    private final Integer id;
    private String text;

    public Description(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return text;
    }

    public void setName(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Description{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}