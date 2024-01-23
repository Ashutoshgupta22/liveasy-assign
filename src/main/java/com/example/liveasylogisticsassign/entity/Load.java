package com.example.liveasylogisticsassign.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
public class Load {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String loadingPoint;
    private String unloadingPoint;
    private String productType;
    private String truckType;
    private String noOfTrucks;
    private Double weight;
    private String comment;
    private String shipperId;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
}