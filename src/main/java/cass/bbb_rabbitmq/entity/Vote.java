package cass.bbb_rabbitmq.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "votes")
public class Vote {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getVote_timestamp() {
        return vote_timestamp;
    }

    public void setVote_timestamp(LocalDateTime voteDateTime) {
        this.vote_timestamp = voteDateTime;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "vote_timestamp", nullable = false, updatable = false)
    private LocalDateTime vote_timestamp;

    @ManyToOne
    private Candidate candidate;
}
