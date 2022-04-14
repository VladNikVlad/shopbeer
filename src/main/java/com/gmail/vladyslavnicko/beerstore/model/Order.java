package com.gmail.vladyslavnicko.beerstore.model;

import com.gmail.vladyslavnicko.beerstore.dto.OrderDTO;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private  LocalDateTime change_date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private BigDecimal sum;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderDetails> details;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> comments;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Order() {
    }

    public Order(LocalDateTime created, LocalDateTime change_date, BigDecimal sum) {
        this.created = created;
        this.change_date = change_date;
        this.sum = sum;
    }

    public static Order of(LocalDateTime created, LocalDateTime change_date, BigDecimal sum) {
        return new Order(created, change_date, sum);
    }

    public OrderDTO toDTO(){
        return OrderDTO.of(id, created, change_date, sum);
    }

    public static Order fromDTO(OrderDTO orderDTO){
        return Order.of(orderDTO.getCreated(), orderDTO.getChange_date(), orderDTO.getSum());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getChange_date() {
        return change_date;
    }

    public void setChange_date(LocalDateTime change_date) {
        this.change_date = change_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public List<OrderDetails> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetails> details) {
        this.details = details;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", created=" + created +
                ", change_date=" + change_date +
                ", user=" + user +
                ", sum=" + sum +
                ", details=" + details +
                ", comments=" + comments +
                ", status=" + status +
                '}';
    }
}
