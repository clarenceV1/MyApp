package com.wodejia.myapp.controller.manager;

import com.wodejia.myapp.app.AppController;
import com.wodejia.myapp.data.manager.FunctionDO;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by clarence on 16/9/19.
 */
public class ManagerMainController extends AppController {

    @Inject
    public ManagerMainController() {
    }

    public List<FunctionDO> getFunctions() {
        List<FunctionDO> funtionList = new ArrayList<>();
        FunctionDO blockAdd = new FunctionDO();
        blockAdd.setName("添加板块");
        blockAdd.setId(1);
        funtionList.add(blockAdd);
        return funtionList;
    }
}
