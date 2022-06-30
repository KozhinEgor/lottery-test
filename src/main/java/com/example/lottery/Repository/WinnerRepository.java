package com.example.lottery.Repository;

import com.example.lottery.enity.Winner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WinnerRepository extends JpaRepository<Winner,Long> {
}
