package tera;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class newLine{
  public String htmlEscape(String text){
    for(int o = 0;o<1;o++) {
        String word[] = {"CHR(13)CHR(10)","CHR(13)","\n","\r\n"}; //恐らく/n(もしくは/r/n)だけでいける


        for(String i:word){ //word配列から要素を取り出してiに格納
            StringBuilder sb = new StringBuilder(); //正規表現。文字連結
            sb.append("^(.*");
            sb.append(i);
            sb.append(").*");
            Pattern p = Pattern.compile(sb.toString()); //正規表現をパターンオブジェクトにコンパイル
            Matcher m = p.matcher(text); //判定する

            //改行コードが含まれていた場合
            if(m.find()) {
                text=text.replaceAll(i,"<br/>");
            }
        }
    }
    return text;
}
}

