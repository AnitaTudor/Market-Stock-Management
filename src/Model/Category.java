package Model;


public class Category {
        private final Integer id;
        private String name;
        private Description description;

        public Category(Integer id, String name, Description description) {
            this.id = id;
            this.name = name;
            this.description = description;

        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Description getDescription() {
            return description;
        }

        public void setDescription(Description description) {
            this.description = description;
        }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description=" + description +
                '}';
    }
}

