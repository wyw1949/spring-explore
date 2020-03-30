package com.yoke.controller;

import com.yoke.constant.SystemConstant;
import com.yoke.model.Spittle;
import com.yoke.repository.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.yoke.constant.SystemConstant.MAX_LONG_AS_STRING;

@Controller
@RequestMapping(value = {"/spittles"})
public class SpittleController {


    @Autowired
    private SpittleRepository spittleRepository;

    @GetMapping
    public String spittles(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) Long max,
            @RequestParam(value = "count", defaultValue = "20") Integer count,
            Model model){
        /*
         *当调用addAttribute()方法并且不指定key的时候，那么key会根据值的对象类型推断确定。
         *在本例中，因为它是一个List<Spittle>，因此，键将会推断为spittleList。
         *
         * 参数也可以用Map代替
         */
        model.addAttribute(spittleRepository.findSpittles(max, count));
        return "spittles";
    }

    @GetMapping("/{id}")
    public String showSpittle(@PathVariable(value = "id") Long id, Model model){
        model.addAttribute("spittle", spittleRepository.findOneById(id));
        return "spittle";
    }

    /*
    //此种形式虽然并没有返回视图名称，也没有显式地设定模型，这个方法返回的是Spittle列表。
    //当处理器方法像这样返回对象或集合时，这个值会放到模型中，模型的key会根据其类型推断得
    //出（在本例中，也就是spittleList）。
    //而逻辑视图的名称将会根据请求路径推断得出。因为这个方法处理针对“/spittles”的GET请求，
    //因此视图的名称将会是spittles（去掉开头的斜线）。
    @GetMapping
    public List<Spittle> spittles(){
        return spittleRepository.findSpittles(Long.MAX_VALUE, 20);
    }*/

    public void setSpittleRepository(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }
}
