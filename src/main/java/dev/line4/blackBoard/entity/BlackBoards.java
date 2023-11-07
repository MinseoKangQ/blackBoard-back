package dev.line4.blackBoard.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/*
id long
title varchar
introduction varchar
email varchar
graduate_date localdatetime
url text

*/
@Getter
@Setter
@Entity
public class BlackBoards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String title;
    @Column(length = 100)
    private String introduction;
    @Column(length = 255)
    private String email;
    @Column(name = "graduate_date")
    private LocalDateTime graduateDate;
    @Column(columnDefinition = "TEXT")
    private String url;
}
