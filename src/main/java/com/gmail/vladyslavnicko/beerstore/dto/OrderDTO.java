package com.gmail.vladyslavnicko.beerstore.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;


@Data
public class OrderDTO {
    private Long id;

    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm", timezone = "UTC")
    private LocalDateTime created;

    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm", timezone = "UTC")
    private  LocalDateTime change_date;

    private BigDecimal sum;

    public OrderDTO() {
    }

    public OrderDTO(LocalDateTime created, LocalDateTime change_date, BigDecimal sum) {
        this.created = created;
        this.change_date = change_date;
        this.sum = sum;
    }

    @JsonCreator
//    public OrderDTO(@JsonProperty(required = true) LocalDateTime created,
//                   @JsonProperty(required = true) LocalDateTime change_date,
//                   @JsonProperty(required = true) BigDecimal sum
//                   ) {
//        this.created = created;
//        this.change_date = change_date;
//        this.sum = sum;
//    }



    private OrderDTO(Long id, LocalDateTime created, LocalDateTime change_date, BigDecimal sum) {
        this.id = id;
        this.created = created;
        this.change_date = change_date;
        this.sum = sum;
    }

    public static OrderDTO of(LocalDateTime created, LocalDateTime change_date, BigDecimal sum) {
        return new OrderDTO(null, created, change_date, sum);
    }
    public static OrderDTO of(Long id, LocalDateTime created, LocalDateTime change_date, BigDecimal sum) {
        return new OrderDTO(id, created, change_date, sum);
    }
}
