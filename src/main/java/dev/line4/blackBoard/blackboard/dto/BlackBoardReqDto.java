package dev.line4.blackBoard.blackboard.dto;

import dev.line4.blackBoard.blackboardsticker.dto.BlackBoardStickerDto;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BlackBoardReqDto {
    private String title;
    private String introduction;
    private String email;
    private String graduateDate;
    private List<BlackBoardStickerDto> stickers;
}
