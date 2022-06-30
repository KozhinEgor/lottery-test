package com.example.lottery.Repository;

import com.example.lottery.enity.Participan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipanRepository extends JpaRepository<Participan,Long> {


}
