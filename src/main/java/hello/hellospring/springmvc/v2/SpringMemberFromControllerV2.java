package hello.hellospring.springmvc.v2;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/springmvc/v2/members")
public class SpringMemberFromControllerV2 {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    @RequestMapping("new-form")
    public ModelAndView members(){
        return new ModelAndView("new-form");
    }

}
