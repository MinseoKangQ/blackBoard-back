package dev.line4.blackBoard.letter.controller;

import dev.line4.blackBoard.letter.service.LetterServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class LetterController {

    private final LetterServiceImpl letterService;
}
