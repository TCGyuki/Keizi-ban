package tera;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class newLine{
  /*public String htmlEscape(String res){
    StringBuffer strResult=new StringBuffer();
    for(int i=0;i<res.length();i++){
        switch(res.charAt(i)){
        case 'CHR(13)CHR(10)' :
         strResult.append("\n");
         break;
        case 'CHR(13)' :
          strResult.append("\r\n");
          break;
        case '>' :
         strResult.append("&gt;");
          break;
        default :
          strResult.append(res.charAt(i));
          break;
        }
    }
    return strResult.toString();
  }
  */
  public String htmlEscape(String text){
    for(int o = 0;o<1;o++) {
        String word[] = {"CHR(13)CHR(10)","CHR(13)","\n","\r\n"};


        for(String i:word){ //word�z�񂩂�v�f�����o����i�Ɋi�[
            StringBuilder sb = new StringBuilder(); //���K�\���B�����A��
            sb.append("^(.*");
            sb.append(i);
            sb.append(").*");
            Pattern p = Pattern.compile(sb.toString()); //���K�\�����p�^�[���I�u�W�F�N�g�ɃR���p�C��
            Matcher m = p.matcher(text); //���肷��

            //���s�R�[�h���܂܂�Ă����ꍇ
            if(m.find()) {
                text=text.replaceAll(i,"<br/>");
            }
        }
    }
    return text;
}
}

