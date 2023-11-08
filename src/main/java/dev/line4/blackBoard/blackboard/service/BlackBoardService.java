package dev.line4.blackBoard.blackboard.service;

import dev.line4.blackBoard.blackboard.repository.BlackBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlackBoardService {
    private final BlackBoardRepository blackBoardRepository;

    @Autowired
    public BlackBoardService(BlackBoardRepository blackBoardRepository) {
        this.blackBoardRepository = blackBoardRepository;
    }

    public long getTotalRecordCount() {
        return blackBoardRepository.count();
    }

}
