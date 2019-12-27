package com.ijson.framework.utils

import com.google.common.base.Strings
import org.apache.commons.collections.MapUtils

import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * desc:
 * version: 6.7
 * Created by cuiyongxu on 2019/11/1 7:42 PM
 */
class ParseUtils {

    private static final String DEF_REGEX = $/\$\{*}/$;


    static String render(String parseText, Map<String, Object> data) {
        return render(parseText, data, DEF_REGEX);
    }

    static String render(String parseText, Map<String, Object> data, String regex) {

        if (Strings.isNullOrEmpty(parseText)) {
            return parseText;
        }

        try {
            StringBuffer sb = new StringBuffer();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(parseText);
            while (matcher.find()) {
                String name = matcher.group(1);// 键名
                String value = "";
                if (MapUtils.isNotEmpty(data)) {
                    Object dta = data.get(name);
                    if (Objects.nonNull(dta)) {
                        value = String.valueOf(dta);// 键值
                    }
                }
                value = Matcher.quoteReplacement(value);
                matcher.appendReplacement(sb, value);
            }
            matcher.appendTail(sb);
            return sb.toString();
        } catch (Exception e) {
            return parseText;
        }
    }

}
