package com.sq.server.utils;


import com.sq.server.VO.ResultVO;

public class ResultVOUtil {
    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setData(object);
        resultVO.setMsg("success");
        return resultVO;
    }
}
