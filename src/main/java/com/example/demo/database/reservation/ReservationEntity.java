package com.example.demo.database.reservation;

import com.example.demo.domain.reservation.ReservationStatus;
import com.example.demo.domain.table.TableModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservations")
public class ReservationEntity {
    @Id
    @Column(name = "idReservation")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "id_shift")
    private int id_shift;

    @Column(name = "mail")
    private String mail;

    @Column(name = "customerQuantity")
    private int people;

    @Column(name = "name")
    private String name;

    @Column(name = "created_At")
    private LocalDateTime created_At;

    @Column(name = "updated_At")
    private LocalDateTime updated_At;

    @Column(name = "deleted")
    private boolean deleted;

    @Column(name = "status")
    private String status;
}
