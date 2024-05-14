package com.example.javaenterprise123.Controller;



import com.example.javaenterprise123.Entitie.Member;
import com.example.javaenterprise123.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    // Hämtar alla medlemmar
    @GetMapping("/admin/members")
    @ResponseBody
    public List<Member> getMembers() {
        return memberService.getMembers();
    }

    // Hämtar en medlem baserat på ID
    @GetMapping("/admin/member/{id}")
    @ResponseBody
    public Member getMemberById(@PathVariable(value = "id") Long id) {
        return memberService.getMemberById(id);
    }

    // Uppdaterar en medlem
    @PutMapping("/admin/updatemember")
    @ResponseBody
    public Member updateMember(@RequestBody Member member) {
        return memberService.updateMember(member);
    }

    // Lägger till en ny medlem
    @PostMapping("/admin/addmember")
    @ResponseBody
    public Member addMember(@RequestBody Member member) {
        return memberService.addMember(member);
    }

    // Visar vy för att ta bort medlem
    @GetMapping("/admin/deletemember")
    public String deleteMemberView(Model model) {
        model.addAttribute("members", memberService.getMembers());
        return "member-list";
    }

    // Tar bort en medlem
    @DeleteMapping("/admin/deletemember/{id}")
    public String deleteMember(@PathVariable("id") Long id, Model model) {
        memberService.deleteMember(id);
        model.addAttribute("members", memberService.getMembers());
        return "member-list";
    }
}