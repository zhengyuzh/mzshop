package com.example.common.config;

import com.example.common.sensitive.MyWordAllow;
import com.example.common.sensitive.MyWordDeny;
import com.github.houbb.sensitive.word.api.IWordAllow;
import com.github.houbb.sensitive.word.api.IWordDeny;
import com.github.houbb.sensitive.word.bs.SensitiveWordBs;
import com.github.houbb.sensitive.word.support.allow.WordAllows;
import com.github.houbb.sensitive.word.support.deny.WordDenys;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SensitiveWordBsConfig {

    /**
     * 配置默认敏感词 + 自定义敏感词
     **/
    IWordDeny wordDeny = WordDenys.chains(WordDenys.system(), new MyWordDeny());

    /**
     * 配置默认非敏感词 + 自定义非敏感词
     **/
    IWordAllow wordAllow = WordAllows.chains(WordAllows.system(), new MyWordAllow());

    @Bean
    public SensitiveWordBs sensitiveWordBs() {
        System.out.println("进入配置文件");
        return SensitiveWordBs.newInstance()
                // 忽略大小写
                .ignoreCase(true)
                // 忽略半角圆角
                .ignoreWidth(true)
                // 忽略数字的写法
                .ignoreNumStyle(true)
                // 忽略中文的书写格式：简繁体
                .ignoreChineseStyle(true)
                // 忽略英文的书写格式
                .ignoreEnglishStyle(true)
                // 忽略重复词
                .ignoreRepeat(false)
                // 是否启用数字检测
                .enableNumCheck(true)
                // 是否启用邮箱检测
                .enableEmailCheck(true)
                // 是否启用链接检测
                .enableUrlCheck(true)
                // 数字检测，自定义指定长度
                .numCheckLen(8)
                // 配置自定义敏感词
                .wordDeny(wordDeny)
                // 配置非自定义敏感词
                .wordAllow(wordAllow)
                .init();
    }


}
