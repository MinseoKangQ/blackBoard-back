package dev.line4.blackBoard.letter.service;

import dev.line4.blackBoard.letter.dto.LetterReqDto;
import dev.line4.blackBoard.letter.dto.LetterResDto;
import dev.line4.blackBoard.letter.entity.Letters;
import dev.line4.blackBoard.letter.repository.LetterRepository;
import dev.line4.blackBoard.lettersticker.service.LetterStickerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LetterServiceImpl implements LetterService {

    // 추후에 BlackBoardRepository 추가
    private final LetterRepository letterRepository;
    private final LetterStickerServiceImpl letterStickerService;

    @Override
    public LetterResDto createLetter(LetterReqDto dto, String blackboardId) {

        // 추후에 blackboard 와 연관관계 작성

        // Letter 빌드
        Letters newLetter = Letters.builder()
                .nickname(dto.getNickname())
                .content(dto.getContent())
                .font(dto.getFont())
                .align(dto.getAlign())
                .build();

        // Letter 저장
        Letters savedLetter = letterRepository.save(newLetter);

        // LetterSticker 들 저장
        letterStickerService.createLetterStickers(dto.getStickers(), savedLetter);

        // 리턴값 (url) 빌드
        LetterResDto resDto = LetterResDto.builder()
                .url("임시값입니다. 실제로는 blackboardId, 즉 url 이 들어옵니다.")
                .build();

        return resDto;

    }
}
