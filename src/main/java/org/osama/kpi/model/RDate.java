package org.osama.kpi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RDate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    // @Column(name = "date_reserved")
    private Date myDate;

    public RDate(Date myDate) {
        this.myDate = myDate;
    }
    public RDate(int id) {
        this.id = id;
    }

    public RDate() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getMyDate() {
        return myDate;
    }

    public void setMyDate(Date myDate) {
        this.myDate = myDate;
    }
}
