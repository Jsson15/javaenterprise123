package com.example.javaenterprise123.Service;


import com.example.javaenterprise123.Entitie.Member;

import java.util.List;

// Interface som definierar tjänster för hantering av medlemmar
public interface MemberServiceInterface {
    // Hämtar en lista över alla medlemmar
    List<Member> getMembers();

    // Hämtar en specifik medlem baserat på dess ID
    Member getMemberById(Long id);

    // Uppdaterar informationen för en befintlig medlem
    Member updateMember(Member member);

    // Lägger till en ny medlem i systemet
    Member addMember(Member member);

    // Tar bort en medlem baserat på dess ID
    void deleteMember(Long id);
}
