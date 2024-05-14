package com.example.javaenterprise123.Service;

import com.example.javaenterprise123.Entitie.Member;
import com.example.javaenterprise123.Exception.ResourceNotFoundException;
import com.example.javaenterprise123.Repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service-klass för hantering av medlemsrelaterade tjänster
@Service
public class MemberService implements MemberServiceInterface {
    @Autowired
    private MemberRepository memberRepository;

    // Hämtar alla medlemmar från databasen
    @Override
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    // Hämtar en medlem baserat på dess ID, kastar ett undantag om inte hittad
    @Override
    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Member", "id", id));
    }

    // Uppdaterar en befintlig medlems information i databasen
    @Override
    public Member updateMember(Member member) {
        Member existingMember = getMemberById(member.getId());
        existingMember.setFirstName(member.getFirstName());
        existingMember.setLastName(member.getLastName());
        existingMember.setAddress(member.getAddress());
        existingMember.setEmail(member.getEmail());
        existingMember.setPhone(member.getPhone());
        existingMember.setDateOfBirth(member.getDateOfBirth());
        return memberRepository.save(existingMember);
    }

    // Lägger till en ny medlem i databasen
    @Override
    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    // Tar bort en medlem från databasen baserat på dess ID
    @Override
    public void deleteMember(Long id) {
        if (!memberRepository.existsById(id)) {
            throw new ResourceNotFoundException("Member", "id", id);
        }
        memberRepository.deleteById(id);
    }
}