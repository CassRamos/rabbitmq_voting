package cass.bbb_rabbitmq.controller;

import cass.bbb_rabbitmq.DTO.VoteRequestDTO;
import cass.bbb_rabbitmq.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/vote")
public class VoteController {

    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public void processVote(@RequestBody VoteRequestDTO request) {
        voteService.processVote(request);
    }
}
