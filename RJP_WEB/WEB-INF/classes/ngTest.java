package jp.took.util;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ngTest {
/**
*投稿記事内部に入力してはいけない文字が存在しないかを確認し、もし含まれていた場合は、エラーメッセージを返します。
* また、文字数の制限も一緒にできるようになっています。
* 禁止文字を追加したい場合は、word配列に禁止したい文字を追加してください。
*/
//禁止文字、文字数制限
    public List<String> doCheck(String title,String introduction){
        List<String> stringList = new ArrayList<String>();
        String value[] = {"タイトル","紹介文"};
        String contents[] = {title,introduction};//判定する文字列
        for(int o = 0;o<2;o++) {//タイトル(最小、最大)、紹介文(最小、最大)
            int restriction[][] = {{1,15},{30,150}};
            if(contents[o].length() < restriction[o][0] || contents[o].length() > restriction[o][1]){
                stringList.add(value[o] + "は" + restriction[o][0] + "文字以上" + restriction[o][1] + "文字以下で入力してください。");
            }       
            //禁止文字種を増やしたい場合は、この配列内に要素を追加してください
            String word[] = {"禁止文字1","禁止文字2","禁止文字3","禁止文字4"};

            for(String i:word){
                StringBuilder sb = new StringBuilder();
                sb.append("^(.*");
                sb.append(i);
                sb.append(").*");
                Pattern p = Pattern.compile(sb.toString());
                Matcher m = p.matcher(contents[o]);

                //禁止文字が含まれているか判定する
                if(m.find()) {
                    stringList.add("禁止文字が含まれています。");
                    return stringList;
                }
            }
        }
        return stringList;
    }
}
