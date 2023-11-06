package dev.line4.blackBoard.lettersticker.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LetterStickerReqDto {
    private Long num;
    private Double positionX;
    private Double positionY;
    private Long img;
    private Double width;
}
