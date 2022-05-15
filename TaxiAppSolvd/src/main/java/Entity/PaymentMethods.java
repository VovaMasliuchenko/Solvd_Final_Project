package Entity;

import java.util.Objects;

public class PaymentMethods {

    private int id;
    private String payment_type;
    private int User_Id;

    PaymentMethods() {}

    PaymentMethods(int id, String payment_type, int User_Id) {
        this.id = id;
        this.payment_type = payment_type;
        this.User_Id = User_Id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public void setUser_Id(int user_Id) {
        User_Id = user_Id;
    }

    public int getId() {
        return id;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public int getUser_Id() {
        return User_Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentMethods that = (PaymentMethods) o;
        return id == that.id && User_Id == that.User_Id && Objects.equals(payment_type, that.payment_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, payment_type, User_Id);
    }

    @Override
    public String toString() {
        return "PaymentMethods{" +
                "id=" + id +
                ", payment_type='" + payment_type + '\'' +
                ", User_Id=" + User_Id +
                '}';
    }
}
