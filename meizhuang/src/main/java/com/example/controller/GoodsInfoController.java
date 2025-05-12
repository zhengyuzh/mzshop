package com.example.controller;

import com.example.common.Result;
import com.example.entity.CommentInfo;
import com.example.entity.GoodsInfo;
import com.example.entity.Account;
import com.example.entity.RelateDTO;
import com.example.service.CommentInfoService;
import com.example.service.GoodsInfoService;
import com.example.utils.ItemCF;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/goodsInfo")
public class GoodsInfoController {
    @Resource
    private GoodsInfoService goodsInfoService;

    @Resource
    private CommentInfoService commentInfoService;

    @PostMapping
    public Result<GoodsInfo> add(@RequestBody GoodsInfo goodsInfo, HttpServletRequest request) {
        Account user = (Account) request.getSession().getAttribute("user");
        System.out.println(goodsInfo);
        goodsInfo.setUserId(user.getId());
        goodsInfo.setLevel(user.getLevel());
        goodsInfoService.add(goodsInfo);
        return Result.success(goodsInfo);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        goodsInfoService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody GoodsInfo goodsInfo) {
        goodsInfoService.update(goodsInfo);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<GoodsInfo> detail(@PathVariable Long id) {
        GoodsInfo goodsInfo = goodsInfoService.findById(id);
        return Result.success(goodsInfo);
    }

    @GetMapping
    public Result<List<GoodsInfo>> all() {
        return Result.success(goodsInfoService.findAll());
    }

    @GetMapping("/page/{name}")
    public Result<PageInfo<GoodsInfo>> page(@RequestParam(defaultValue = "1") Integer pageNum,
                                            @RequestParam(defaultValue = "10") Integer pageSize,
                                            @PathVariable String name,
                                            HttpServletRequest request) {
        return Result.success(goodsInfoService.findPage(pageNum, pageSize, name, request));
    }

    @GetMapping("/findByType/{typeId}")
    public Result<List<GoodsInfo>> findByType(@PathVariable Integer typeId) {
        return Result.success(goodsInfoService.findByType(typeId));
    }

    @GetMapping("/recommend")
    public Result<PageInfo<GoodsInfo>> recommendGoods(@RequestParam(defaultValue = "1") Integer pageNum,
                                                      @RequestParam(defaultValue = "10") Integer pageSize) {
        return Result.success(goodsInfoService.findRecommendGoods(pageNum, pageSize));
    }

    @GetMapping("/sales")
    public Result<PageInfo<GoodsInfo>> sales(@RequestParam(defaultValue = "1") Integer pageNum,
                                             @RequestParam(defaultValue = "10") Integer pageSize) {
        System.out.println(goodsInfoService.findHotSalesGoods(pageNum, pageSize));
        return Result.success(goodsInfoService.findHotSalesGoods(pageNum, pageSize));
    }

    /**
     * 查询用户买到过的所有商品
     * @return
     */
    @GetMapping("/comment/{userId}/{level}")
    public Result<List<GoodsInfo>> orderGoods(@PathVariable("userId") Long userId,
                                              @PathVariable("level") Integer level) {
        return Result.success(goodsInfoService.getOrderGoods(userId, level));
    }

    @GetMapping("/searchGoods")
    public Result<List<GoodsInfo>> searchGoods(@RequestParam String text) {
        return Result.success(goodsInfoService.searchGoods(text));
    }


    /**
     * @description: 协同过滤推荐商品
     * @author: author
     * @date: 2025/2/8 14:36
     * @param: [text]
     * @return: com.example.common.Result<java.util.List<com.example.entity.GoodsInfo>>
     **/

    @GetMapping("/sysRecommend")
    public  Result<PageInfo<GoodsInfo>> getSearchGoods(@RequestParam(defaultValue = "1") Integer pageNum,
                                                  @RequestParam(defaultValue = "10") Integer pageSize,HttpServletRequest request) {

        Account user = (Account) request.getSession().getAttribute("user");
        if(user == null){
            //未登录随机获取几个商品
            return Result.success(goodsInfoService.selectByGoodsRandom());

        }else{
            //获取用户评价最高的商品
            Map<String, Object> commentInfo = commentInfoService.selecCommentScoreBest(user.getId());

            int itemId= Integer.parseInt(user.getId().toString());
            //Sql获取不同用户对不同商品评分关系
            List<RelateDTO> data= commentInfoService.getAllGoodsComment();
            System.out.println(data);
            // 获取到推荐的商品id
            List<Integer> recommendations = ItemCF.recommend(itemId, data);
            for(Integer item : recommendations){
                System.out.println(item);
            }

            return Result.success(goodsInfoService.selectByGoodsIdList(recommendations));

        }
    }

}
