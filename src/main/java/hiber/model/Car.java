package hiber.model;

import javax.persistence.*;

@Entity(name = "Car")
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "model")
    private String name;

    @Column(name = "series")
    private int series;

    public Car() {

    }

    public Car(String name, int series) {
        this.name = name;
        this.series = series;
    }

  /*@OneToOne(mappedBy = "owner", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private User owner1;*/

    public int getId() {
        return id;
    }

    public void setName(String s) {
        this.name = s;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getName() {
        return name;
    }

    public int getSeries() {
        return series;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", series=" + series +
                '}';
    }
}
