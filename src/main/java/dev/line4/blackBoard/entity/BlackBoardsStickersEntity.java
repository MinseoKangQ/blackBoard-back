package dev.line4.blackBoard.entity;

/*
id long
num long
position_x integer
position_y
board_id
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BlackBoardsStickersEntity {
    @Id
    private String id;
    private Long num;
    @Column(name = "position_x")
    private double positionX;
    @Column(name = "position_y")
    private double positionY;
    @ManyToOne
    @JoinColumn(name = "board_id")
    private BlackBoardsEntity boardId;
}
