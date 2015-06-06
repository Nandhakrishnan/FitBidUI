package com.flipbidui.actions;

import com.flipbidui.network.HTTPCallActions;
import com.flipbidui.network.IHTTPCallActions;

/**
 * Created by sankeerth.reddy on 06/06/15.
 */
public class SampleTest {
    public static void main(String[] args) {
        test();
    }

    public static void test(){
    ActionImpl action = new ActionImpl();
        System.out.println(action.getProduct(1234123123).sellerPrice);
    }
}
