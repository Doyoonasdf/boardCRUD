package com.spring.board;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
//@RequestMapping(value = "/sample")
public class SampleController {

//    @RequestMapping(value = "/getSample")
//    public void getSample(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        System.out.println("getSample");
//    }
   
   @RequestMapping(value = "/getSample", method = RequestMethod.GET)
   public String getSample(HttpServletRequest request, HttpServletResponse response) throws Exception {
      return "sampleView";
   }
}