package com.solvd.Entity;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlType(name = "CreditCards")
@XmlRootElement(name = "CreditCards")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreditCards {

    @XmlAttribute(name = "idCard")
    private int id;
    @XmlElement(name = "cardNumber")
    private String card_number;
    @XmlElement(name = "createdDay")
    private String created_day;
    @XmlElement(name = "codeCVV")
    private int code_CVV;
    @XmlElement(name = "UsersId")
    private int Users_Id;

    public CreditCards(){}

    public CreditCards(int id, String card_number, String created_day, int code_CVV, int Users_Id) {
        this.id = id;
        this.card_number = card_number;
        this.created_day = created_day;
        this.code_CVV = code_CVV;
        this.Users_Id = Users_Id;
    }

    public void setId() {
        this.id = id;
    }

    public void setCard_number() {
        this.card_number = card_number;
    }

    public void setCreated_day() {
        this.created_day = created_day;
    }

    public void setCode_CVV() {
        this.code_CVV = code_CVV;
    }

    public void setUsers_Id() {
        this.Users_Id = Users_Id;
    }

    public int getId() {
        return id;
    }

    public String getCard_number() {
        return card_number;
    }

    public String getCreated_day() {
        return created_day;
    }

    public int getCode_CVV() {
        return code_CVV;
    }

    public int getUsers_Id() {
        return Users_Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCards that = (CreditCards) o;
        return id == that.id && card_number == that.card_number && code_CVV == that.code_CVV && Users_Id == that.Users_Id && Objects.equals(created_day, that.created_day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, card_number, created_day, code_CVV, Users_Id);
    }

    @Override
    public String toString() {
        return "CreditCards{" +
                "id=" + id +
                ", card_number=" + card_number +
                ", created_day=" + created_day +
                ", code_CVV=" + code_CVV +
                ", Users_Id=" + Users_Id +
                '}';
    }
}
