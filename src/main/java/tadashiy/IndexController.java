package tadashiy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"hoge"})
public class IndexController {
  @RequestMapping("/")
  public String index(Hoge hoge, Model model) {
    System.out.println("call index");
    System.out.println(hoge);
    System.out.println(hoge.count);
    System.out.println(model);
    model.addAttribute("count", hoge.count++);
    return "index";
  }
}