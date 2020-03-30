package com.yoke.controller;

import com.yoke.BaseTest;
import com.yoke.model.Spittle;
import com.yoke.repository.SpittleRepository;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SpittleControllerTest extends BaseTest {

    @Test
    public void showSpittleTest() throws Exception {
        Spittle spittle = new Spittle(1L, "spittle_1", new Date(), 0.0, 0.0);
        SpittleRepository spittleRepository = Mockito.mock(SpittleRepository.class);
        Mockito.when(spittleRepository.findOneById(1L))
                .thenReturn(spittle);

        SpittleController spittleController = new SpittleController();
        spittleController.setSpittleRepository(spittleRepository);

        MockMvc mock = standaloneSetup(spittleController).build();

        mock.perform(get("/spittles/1"))
                .andExpect(view().name("spittle"))
                .andExpect(model().attributeExists("spittle"))
                .andExpect(model().attribute("spittle", spittle));
    }

    @Test
    public void spittlesTest() throws Exception {
        List<Spittle> spittles = createSpittle(20);
        // 创建SpittleRepository的mock对象
        SpittleRepository spittleRepository = Mockito.mock(SpittleRepository.class);
        Mockito.when(spittleRepository.findSpittles(Long.MAX_VALUE, 20))
                .thenReturn(spittles);

        SpittleController spittleController = new SpittleController();
        spittleController.setSpittleRepository(spittleRepository);
        //构建mock
        MockMvc mock = standaloneSetup(spittleController)
                //mock框架就不用解析控制器中的视图名了。在很多场景中，其实没有必要这样做。但是对
                //于这个控制器方法，视图名与请求路径是非常相似的，这样按照默认的视图解析规则时，
                //MockMvc就会发生失败，因为无法区分视图路径和控制器的路径。
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();
        mock.perform(get("/spittles"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(spittles.toArray())));
    }

    private List<Spittle> createSpittle(long num){
        List<Spittle> spittles = new ArrayList<>();
        for (long i = 0; i < num; i ++){
            spittles.add(new Spittle(i, "spittle " + i, new Date(), 0.0, 0.0));
        }
        return spittles;
    }

}
