package dev.line4.blackBoard.blackboardsticker.entity;

/*
id long
num long
position_x integer
position_y
board_id
 */

import dev.line4.blackBoard.blackboard.entity.BlackBoards;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BlackBoardStickers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long num;
    @Column(name = "position_x")
    private double positionX;
    @Column(name = "position_y")
    private double positionY;
    @ManyToOne
    @JoinColumn(name = "board_id")
    private BlackBoards boardId;
}
