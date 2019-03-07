package jiajia.controller;

import jiajia.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class TestController {
    @RequestMapping("/JSR")
    public void testJSR(@Valid Student student, BindingResult result){

        if(result.getErrorCount() > 0){
            for(FieldError error:result.getFieldErrors()){
                System.out.println(error.getField() + ":" + error.getDefaultMessage());
            }
        }
        System.out.println(student);
    }
    @ExceptionHandler(Exception.class)
    public String myException(Exception e, ModelAndView modelAndView){
        modelAndView.addObject("exception",e.getCause()+"£º"+e.getMessage());
        System.out.println(e.getMessage());
        return "error";
    }
    @RequestMapping("/testException")
    public String testException(@RequestParam("num")Integer num){
        System.out.println(10/num);
        return "success";
    }
}
