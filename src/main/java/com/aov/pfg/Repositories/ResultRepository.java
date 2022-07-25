package com.aov.pfg.Repositories;

import com.aov.pfg.Models.Question;
import com.aov.pfg.Models.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ResultRepository extends JpaRepository<Result, Long> {
}
