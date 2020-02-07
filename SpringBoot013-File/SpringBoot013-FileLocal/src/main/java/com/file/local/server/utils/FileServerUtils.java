package com.file.local.server.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.file.local.server.model.ImageWH;

/**
 * chenkw
 */
public class FileServerUtils {

    public static boolean isCutImgName(String name){
        String ipAddressRegex = ".*(_)[0-9]*(x)[0-9]*[.][a-zA-Z]*";
        Pattern ipAddressPattern = Pattern.compile(ipAddressRegex);
        Matcher matcher = ipAddressPattern.matcher(name);
        return matcher.matches();
    }

    public static List<ImageWH> loadCutSize(String cutSize) {
        List<ImageWH> whs =null;
        if(StringUtils.isNotEmpty(cutSize)) {
            List<String> sizes = Arrays.asList(cutSize.split(","));
            whs = new ArrayList<>();
            for (String size : sizes) {
                String vals[] = size.split("x");
                int w = Integer.parseInt(vals[0]);
                int h = Integer.parseInt(vals[1]);
                whs.add(new ImageWH(w, h));
            }
        }
        return whs;
    }

}
