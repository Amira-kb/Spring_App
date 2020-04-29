package Web.Prog.Managment.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private int year;

    @Column(name = "available")
    private boolean available;

    public Movie() {
    }

    public Movie(String name, int year) {
        this.name = name;
        this.year = year;
        this.available = false;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setyear(int year) {
        this.year = year;
    }

    public int getyear() {
        return this.year;
    }

    public boolean isavailable() {
        return available;
    }

    public void setavailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", year=" + year + ", available=" + available + "]";
    }
}
