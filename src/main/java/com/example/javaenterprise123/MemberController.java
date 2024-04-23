package com.example.javaenterprise123;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/members")
    public List<Member> listMembers() {
        return memberService.listAllMembers();
    }

    @GetMapping("/member/{id}")
    public Member getMember(@PathVariable Long id) {
        return memberService.getMember(id);
    }

    @PostMapping("/addmember")
    public Member addMember(@RequestBody Member member) {
        return memberService.saveMember(member);
    }

    @PutMapping("/updatemember/{id}")
    public Member updateMember(@PathVariable Long id, @RequestBody Member updatedMember) {
        Member member = memberService.getMember(id);
        // Set new values from updatedMember
        member.setFirstName(updatedMember.getFirstName());
        member.setLastName(updatedMember.getLastName());
        member.setEmail(updatedMember.getEmail());
        member.setPhone(updatedMember.getPhone());
        member.setDateOfBirth(updatedMember.getDateOfBirth());
        member.setAddress(updatedMember.getAddress());
        return memberService.saveMember(member);
    }

    @DeleteMapping("/deletemember/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.ok().build();
    }
}


