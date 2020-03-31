package com.springboot.example.constant;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MessageGroup {

    private MessageGroup() {

    }

    private static final String GROUP_CAT = "CAT";
    private static final String GROUP_DOG = "DOG";
    private static final String GROUP_APPLE = "APPLE";

    private static final List<String> GROUP_LIST = Arrays.asList(GROUP_CAT, GROUP_DOG, GROUP_APPLE);
    private static final Random random = new Random();

    public static String randomGroup() {
        int groupIndex = random.nextInt(GROUP_LIST.size());
        if (groupIndex < 0) {
            groupIndex = 0;
        }
        if (groupIndex >= GROUP_LIST.size()) {
            groupIndex = GROUP_LIST.size() - 1;
        }
        return GROUP_LIST.get(groupIndex);
    }
}
