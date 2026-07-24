package com.shree.librarymanagement.service;

import com.shree.librarymanagement.entity.Member;
import com.shree.librarymanagement.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    public Member updateMember(Long id, Member updatedMember) {

        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        member.setName(updatedMember.getName());
        member.setEmail(updatedMember.getEmail());
        member.setPhone(updatedMember.getPhone());
        member.setAddress(updatedMember.getAddress());
        member.setMembershipType(updatedMember.getMembershipType());

        return memberRepository.save(member);
    }

    public String deleteMember(Long id) {
        memberRepository.deleteById(id);
        return "Member deleted successfully!";
    }
}