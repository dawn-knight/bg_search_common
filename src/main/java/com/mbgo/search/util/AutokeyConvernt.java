package com.mbgo.search.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mbgo.search.util.bean.WordBean;

/**
 * 热门关键字格式化 多个空格合并，用于显示 多个空格用特殊字符替换，用于搜索
 * 
 * @author HQ01U8435
 *
 */
public class AutokeyConvernt {

  /**
   * 替换关键字中的空格
   */
  public static final String special_split = "#%%#";
  /**
   * 排序
   */
  private static IntegerSort _comparator = new IntegerSort();
  private static final String _p = "[0-9|a-z|A-Z|\\s|\u4e00-\u9fa5]+";
  /**
   * 过滤汉字、英文、数字和空格以外的其他字符
   */
  private static Pattern pattern = Pattern.compile(_p);
  private static final String AUTOKEY_FILTER = "[^(a-zA-Z|\u4e00-\u9fa5|\\d|\\-)|\\s]";

  private static final Pattern GOODS_SN_PATTERN = Pattern.compile("(\\d{6})", 0);

  /**
   * 用于显示，多个空格合并成一个空格
   * 
   * @param word
   * @return
   */
  public static String withOneSpace(String word) {
    return replace(word, " ");
  }

  /**
   * 多个空格由一个自定义特殊字符代替，用于索引
   * 
   * @param word
   * @return
   */
  public static String withReplaceSpace(String word) {
    return replace(word, special_split);
  }

  /**
   * 将特殊字符用指定的字符串替换
   * 
   * @param w
   * @param sp
   * @return
   */
  public static String replace(String w, String sp) {
    try {
      String temp = StringUtil.toDBC(w);
      temp = temp.replaceAll(AUTOKEY_FILTER, "").toLowerCase();
      return temp.trim().replaceAll("\\s+", sp);
    } catch (Exception e) {
      return w;
    }
  }

  /**
   * 分析出关键字中的“-”字符，表示“非”或NOT，表示不包含此关键字
   * 
   * @param qwb
   * @return
   */
  public static String convertSpecialSymbolic(WordBean wb) {
    StringBuilder sb = new StringBuilder("(");

    int wordCount = 0;
    for (String w : wb.getWords()) {
      // w = replace(w, " ");
      if (w.trim().length() < 1) {
        continue;
      }
      sb.append("\"" + w + "\"~10000").append(" ");
      wordCount++;
    }
    // 当只有not关键字时，必须设置一个默认的关键字，否则not不生效
    if (wordCount == 0) {
      sb.append("\"" + StringUtil.DEFAULT_STATIC_KEYWORD + "\"~10000").append(" ");
    }

    for (String w : wb.getNotWords()) {
      sb.append("NOT\"" + w + "\"").append(" ");
    }

    sb.append(")");
    return sb.toString();
  }

  /**
   * 关键字中如果含有“-”，那么紧跟在“-”后面的第一个关键词（以空格区分关键字），是排除关键字 这里将查询关键词和排除关键词提取
   * 
   * 例如 ： 关键字 “男 -格子 外套 -修身”，则表示搜索“男 外套”但 不是“格子”或“修身”的商品 那么，查询关键字是“男 外套”，排除关键词是“格子 修身”
   * 
   * @param k
   * @return
   */
  public static WordBean findQueryWordBean(String k) {
    if (k == null) {
      return new WordBean();
    }
    //k = k.replaceAll("-", " -");
    WordBean wb = new WordBean();
    /*String[] ws = k.split(" ");
    boolean is_apprear = false; // 是否出现“-”符号
    boolean isWordAfter_ = false; // 是否在“-”符号后面跟随了关键字
    for (int i = 0; i < ws.length; i++) {
      String w = ws[i];
      if (w.isEmpty()) {
        continue;
      }
      if (w.indexOf("-") > -1) {
        is_apprear = true;
        isWordAfter_ = false;
        String[] not = w.split("-");
        for (int j = 0; j < not.length; j++) {
          String ns = not[j];
          if (ns != null && ns.length() > 0) {
            isWordAfter_ = true;
            wb.getNotWords().add(ns);
          }
        }
      } else {
        if (is_apprear && !isWordAfter_) {
          wb.getNotWords().add(w);
          is_apprear = false;
          isWordAfter_ = true;
        } else {
          wb.getWords().add(w);
        }
      }
    }*/
    // 删除-逻辑，不改变用户输入关键字
     wb.getWords().add(k);
    return wb;
  }

  public static String wordCode(String s) {
    String rs = "";
    s = s.toLowerCase();
    if (StringUtil.isNumberOrLetters(s)) {
      return s;
    }
    List<Integer> codes = new ArrayList<Integer>();
    for (int i = 0, len = s.length(); i < len; i++) {
      int cv = s.codePointAt(i);
      if (cv == 32) {
        continue;
      }
      codes.add(cv);
    }
    Collections.sort(codes, _comparator);
    for (Integer code : codes) {
      rs += String.valueOf(code) + "_";
    }
    return rs;
  }

  public static boolean isValidate(String s) {
    return pattern.matcher(s).matches();
  }

  public static String spliteWord(String w) {
    try {
      if (w == null)
        return null;
      String temp = StringUtil.toDBC(w);
      temp = temp.replaceAll(AUTOKEY_FILTER, " ");
      return temp.replaceAll("[||\\(|\\)]?", "").trim().replaceAll("\\s+", " ");
    } catch (Exception e) {
      return w;
    }
  }

  public static List<String> pickString(String input) {
    List<String> rs = new ArrayList<String>(0);
    try {

      Matcher m = GOODS_SN_PATTERN.matcher(input);

      while (m.find()) {
        rs.add(m.group(1));
      }
      return rs;
    } catch (Exception e) {
      return rs;
    }
  }

  public static void main(String[] args) {
    // String s = "||你|   | 好０１２３４５６７８９ａｄｓ-,.ｆｇｈ,,，，， 休闲裤               男　　　特卖";
    // String s1 = "美特 斯邦威毛�?�";
    //
    // System.out.println(withOneSpace(s1));
    // System.out.println(withReplaceSpace(s1));
    // System.out.println(spliteWord(s));

    long b = System.currentTimeMillis();
    String word = "衬衫 格子-男 外套 - mb";
    // String word = "AMPM 灰色男衬衫";
    WordBean qwb = findQueryWordBean(word);

    System.out.println(convertSpecialSymbolic(qwb));
    System.out.println(System.currentTimeMillis() - b);

    System.out.println("query : ");
    for (String w : qwb.getWords()) {
      System.out.println("\t" + w);
    }
    System.out.println("not : ");
    for (String w : qwb.getNotWords()) {
      System.out.println("\t" + w);
    }

    System.out.println("165/88A".replaceAll("[^\\d]", ""));

    System.out.println(StringUtil.pickString("http://metersbonwe.banggo.2347811com/Goods/2378121.shtml"));

    System.out.println(wordCode("男 衬衫"));
    System.out.println(wordCode("衬衫 男"));
  }
}

class IntegerSort implements Comparator<Integer> {

  public int compare(Integer o1, Integer o2) {
    return o1 - o2;
  }
}
