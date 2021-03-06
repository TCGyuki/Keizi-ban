package tera;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NgCheck {
/**
*投稿記事内部に入力してはいけない文字が存在しないかを確認し、
もし含まれていた場合は、エラーメッセージを返す。
* また、初期の時点ではここで文字数の制限も一緒にできるようにしていた。(現在非実装。)
* 禁止文字を追加したい場合は、word配列に禁止したい文字を追加。
*/
//禁止文字、文字数制限
    public String doCheck(String text){
        /*List<String> wordList = new ArrayList<String>();
        String result="";
        String value[] = {"名前","紹介文"};
        String contents[] = {text};*/ //判定する文字列text←name,contentsとかに。引数も変更

        for(int o = 0;o<1;o++) {//タイトル(最小、最大)、コメント(最小、最大)
            /*文字数判定
            int restriction[][] = {{1,100},{1,500}};
            if(contents[o].length() < restriction[o][0] || contents[o].length() > restriction[o][1]){
                wordList.add(value[o] + "は" + restriction[o][0] + "文字以上" + restriction[o][1] + "文字以下で入力してください。");
            }*/

            //禁止文字種を増やしたい場合は、この配列内に要素を追加してください
            String word[] = {"たまねぎ","玉ねぎ","うさぎ","兎","rabbit"};
            String word2[] = {"井坂","呉石"};

            for(String i:word){ //word配列から要素を取り出してiに格納
                StringBuilder sb = new StringBuilder(); //正規表現。文字連結
                sb.append("^(.*");
                sb.append(i);
                sb.append(").*");
                Pattern p = Pattern.compile(sb.toString()); //正規表現をパターンオブジェクトにコンパイル
                Matcher m = p.matcher(text); //判定する　/*判定が配列の時はcontents[o]*/

                //禁止文字が含まれていた場合
                if(m.find()) {
                    //result="[この発言には不適切な内容が含まれていました]";    //初期は一部分ではなく文全体を変えていた
                    text=text.replaceAll(i,"[禁止用語]");
                }
            }
            for(String i:word2){ //word配列から要素を取り出してiに格納
                StringBuilder sb = new StringBuilder(); //正規表現。文字連結
                sb.append("^(.*");
                sb.append(i);
                sb.append(").*");
                Pattern p = Pattern.compile(sb.toString()); //正規表現をパターンオブジェクトにコンパイル
                Matcher m = p.matcher(text); //判定する

                //禁止文字が含まれていた場合
                if(m.find()) {
                    //result="[この発言には不適切な内容が含まれていました]";
                    text=text.replaceAll(i, i + "大先生");
                }
            }
        }
        
        /*
        String result = "";
        for(String words : wordList){
            result+= words+",";
        }return result;
        */
        return text;
    }
}
