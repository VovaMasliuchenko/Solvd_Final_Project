package Entity;

import java.util.Objects;

public class Ratings {

    private int id;
    private int rating;
    private int User_Id;

    Ratings() {}

    Ratings(int id, int rating, int User_Id) {
        this.id = id;
        this.rating = rating;
        this.User_Id = User_Id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setUser_Id(int user_Id) {
        this.User_Id = user_Id;
    }

    public int getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public int getUser_Id() {
        return User_Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ratings ratings = (Ratings) o;
        return id == ratings.id && rating == ratings.rating && User_Id == ratings.User_Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rating, User_Id);
    }

    @Override
    public String toString() {
        return "Ratings{" +
                "id=" + id +
                ", rating=" + rating +
                ", User_Id=" + User_Id +
                '}';
    }
}
