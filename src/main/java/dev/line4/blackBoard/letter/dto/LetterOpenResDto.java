package dev.line4.blackBoard.letter.dto;

import dev.line4.blackBoard.lettersticker.dto.LetterStickerReqDto;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LetterOpenResDto {
    private Long id;
    private String nickname;
    private String content;
    private String font;
    private String align;
    private List<LetterStickerReqDto> stickers;
}
