package com.example.javaenterprise123.Repo;

import com.example.javaenterprise123.Entitie.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Gränssnitt för repository som hanterar databasoperationer för Member-entiteten
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
