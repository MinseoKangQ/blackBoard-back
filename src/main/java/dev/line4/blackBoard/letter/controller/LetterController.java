package dev.line4.blackBoard.letter.controller;

import dev.line4.blackBoard.letter.dto.LetterReqDto;
import dev.line4.blackBoard.letter.dto.LetterResDto;
import dev.line4.blackBoard.letter.service.LetterServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class LetterController {

    private final LetterServiceImpl letterService;

    @PostMapping("letter")
    public ResponseEntity<?> createLetter(@RequestBody LetterReqDto dto,
                                          @RequestParam("id") String blackboardId) {
        LetterResDto result = letterService.createLetter(dto, blackboardId);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

}
