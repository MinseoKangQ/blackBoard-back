package dev.line4.blackBoard.blackboardsticker.service;

import dev.line4.blackBoard.blackboardsticker.dto.BlackBoardStickerDto;
import dev.line4.blackBoard.blackboardsticker.entity.BlackBoardStickers;
import org.springframework.stereotype.Service;

@Service
public class BlackBoardStickerService {

    public BlackBoardStickers createBlackBoardStickers(BlackBoardStickerDto stickerDto) {
        return BlackBoardStickers.builder()
                .num(stickerDto.getNum())
                .positionX(stickerDto.getPositionX())
                .positionY(stickerDto.getPositionY())
                .img(stickerDto.getImg())
                .width(stickerDto.getWidth())
                .angle(stickerDto.getAngle())
                .mirror(stickerDto.getMirror())
                .build();
    }
}
