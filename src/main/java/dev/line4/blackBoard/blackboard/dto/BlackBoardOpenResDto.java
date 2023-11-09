package dev.line4.blackBoard.blackboard.dto;

import dev.line4.blackBoard.blackboardsticker.dto.BlackBoardStickerResDto;
import dev.line4.blackBoard.letter.dto.LetterOpenResDto;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BlackBoardOpenResDto {
    private String title;
    private String introduction;
    private String graduateDate;
    private List<BlackBoardStickerResDto> boardStickers;
    private List<LetterOpenResDto> letters;
}
