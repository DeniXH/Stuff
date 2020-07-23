package skladtestgroup.sklad.model;
import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "stuff_s")
public class Stuff {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private int year;

    @Column(name = "genre")
    private String genre;

    @Column(name = "watched")
    private boolean watched;

   // @Lob
   // @Column(name="stuff_image", columnDefinition="BLOB") // здесь добавил стаф имдж
   // private byte[] image;

    public Stuff(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

 //   public byte[] getImage() { return image; }

 //   public void setImage(byte[] image) { this.image = image; }


  //  @Override
  //  public String toString() {
      //  return "Stuff{" +
      //          "id=" + id +
     //           ", title='" + title + '\'' +
     //           ", year=" + year +
     //           ", genre='" + genre + '\'' +
     //           ", watched=" + watched +
     //         //  ", image=" + Arrays.toString( image ) +
     //'}';

    @Override
    public String toString() {
        return id + " " + title + " " + year + " " + genre + " " + watched;
    }
}

