package com.example.common.sensitive;

import com.github.houbb.sensitive.word.api.IWordDeny;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MyWordDeny implements IWordDeny {

    @Override
    public List<String> deny() {
        List<String> list = new ArrayList<String>();
        try {
            System.out.println("读取敏感词文件");
            Resource mySensitiveWords = new ClassPathResource("sensitive_word_dict.txt");
            Path mySensitiveWordsPath = Paths.get(mySensitiveWords.getFile().getPath());
            list = Files.readAllLines(mySensitiveWordsPath, StandardCharsets.UTF_8);
        } catch (IOException ioException) {
            System.out.println("读取敏感词文件错误！" + ioException.getMessage());
        }
        return list;
    }

}
