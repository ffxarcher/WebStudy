//package com.sq.order.controller;
//
//import com.sq.order.dataobject.ProductInfo;
//import com.sq.order.dto.CartDto;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Arrays;
//import java.util.List;
//
//@RestController
//@Slf4j
//public class test {
//
//
//    @Autowired
//    private LoadBalancerClient loadBalancerClient;
//    private RestTemplate restTemplate;
//
//    @RequestMapping("/urltest")
//    public String test() {
//
//        /**
//         * 1、直接使用地址调用方法
//         */
////        RestTemplate restTemplate = new RestTemplate();
////        String response = restTemplate.getForObject("http://localhost:8081/getProductMsg",String.class);
////        log.info("response:"+response);
//
//
//        //2、第2种方法(通过应用名获取)
//        //可以直接传递对象进行操作与feign相对；
//
//        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
//        String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort()) + "/product/decreaseStock";
//        RestTemplate restTemplate = new RestTemplate();
//        CartDto cartDto = new CartDto("157875196366160022", 2);
//        restTemplate.postForObject(url, Arrays.asList(cartDto), List.class);
//        //String response = restTemplate.getForObject(url,String.class);
//        //log.info("response:{}"+productInfoList.size());
//
//        //3、
//
////
////
////       List<ProductInfo> productInfoList = restTemplate.postForObject("http://PRODUCT/product/decreaseStock",
////                Arrays.asList(cartDto),List.class);
////       return productInfoList.size()+" ";
//        return "ok";
//    }
//}
