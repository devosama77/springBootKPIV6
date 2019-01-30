package org.osama.kpi.model;

import javax.persistence.*;


@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String pipeline;
    String customerName;
    String contact;
    String industry;
    String customerMet;
    @ManyToOne
    SDate sDate;


    public Sale() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPipeline() {
        return pipeline;
    }

    public void setPipeline(String pipeline) {
        this.pipeline = pipeline;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getCustomerMet() {
        return customerMet;
    }

    public void setCustomerMet(String customerMet) {
        this.customerMet = customerMet;
    }

    public SDate getsDate() {
        return sDate;
    }

    public void setsDate(SDate sDate) {
        this.sDate = sDate;
    }
}
