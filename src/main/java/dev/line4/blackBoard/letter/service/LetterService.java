package dev.line4.blackBoard.letter.service;

import dev.line4.blackBoard.letter.dto.LetterReqDto;
import dev.line4.blackBoard.letter.dto.LetterResDto;

public interface LetterService {
    LetterResDto createLetter(LetterReqDto dto, String blackboardId);
}
