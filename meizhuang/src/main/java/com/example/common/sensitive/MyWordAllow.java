package com.example.common.sensitive;

import com.github.houbb.sensitive.word.api.IWordAllow;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MyWordAllow implements IWordAllow {

    @Override
    public List<String> allow() {
        List<String> list = new ArrayList<>();

        try {
            System.out.println("读取非敏感词文件文件");

            Resource myAllowWords = new ClassPathResource("sensitive_word_allow.txt");
            Path myAllowWordsPath = Paths.get(myAllowWords.getFile().getPath());
            list = Files.readAllLines(myAllowWordsPath, StandardCharsets.UTF_8);

        } catch (IOException ioException) {
            System.out.println("读取非敏感词文件错误！" + ioException.getMessage());
        }
        return list;
    }

}
