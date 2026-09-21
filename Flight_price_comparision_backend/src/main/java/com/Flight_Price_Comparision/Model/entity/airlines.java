package com.Flight_Price_Comparision.Model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "airlines")
public class airlines {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "airlines_name", nullable = false)
    private String airlinesName;

    @Column(name = "airlines_code", nullable = false, unique = true)
    private String airlinesCode;

    @Column(nullable = false)
    private String country;

    @Column(name = "logo_url")
    private String logoUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAirlinesName() {
        return airlinesName;
    }

    public void setAirlinesName(String airlinesName) {
        this.airlinesName = airlinesName;
    }

    public String getAirlinesCode() {
        return airlinesCode;
    }

    public void setAirlinesCode(String airlinesCode) {
        this.airlinesCode = airlinesCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
