package tera;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NgCheck {
/**
*���e�L�������ɓ��͂��Ă͂����Ȃ����������݂��Ȃ������m�F���A�����܂܂�Ă����ꍇ�́A�G���[���b�Z�[�W��Ԃ��܂��B
* �܂��A�������̐������ꏏ�ɂł���悤�ɂȂ��Ă��܂��B
* �֎~������ǉ��������ꍇ�́Aword�z��ɋ֎~������������ǉ����Ă��������B
*/
//�֎~�����A����������
    public String doCheck(String text){
        //List<String> wordList = new ArrayList<String>();
        //String result="";
        //String value[] = {"���O","�Љ"};
        //String contents[] = {text};//���肷�镶����
        for(int o = 0;o<1;o++) {//�^�C�g��(�ŏ��A�ő�)�A�R�����g(�ŏ��A�ő�)
            /*
            int restriction[][] = {{1,100},{1,500}};
            if(contents[o].length() < restriction[o][0] || contents[o].length() > restriction[o][1]){
                wordList.add(value[o] + "��" + restriction[o][0] + "�����ȏ�" + restriction[o][1] + "�����ȉ��œ��͂��Ă��������B");
            }*/
            //�֎~������𑝂₵�����ꍇ�́A���̔z����ɗv�f��ǉ����Ă�������
            String word[] = {"����","���܂˂�","�ʂ˂�","������","�e","rabbit"};
    

            for(String i:word){ //word�z�񂩂�v�f�����o����i�Ɋi�[
                StringBuilder sb = new StringBuilder(); //���K�\���B�����A��
                sb.append("^(.*");
                sb.append(i);
                sb.append(").*");
                Pattern p = Pattern.compile(sb.toString()); //���K�\�����p�^�[���I�u�W�F�N�g�ɃR���p�C��
                Matcher m = p.matcher(/*contents[o]*/text); //���肷��

                //�֎~�������܂܂�Ă����ꍇ
                if(m.find()) {
                    //result="[���̔����ɂ͕s�K�؂ȓ��e���܂܂�Ă��܂���]";
                    text=text.replaceAll(i,"[�֎~�p��]");
                }
            }
        }/*
        String result = "";
        for(String words : wordList){
            result+= words+",";
        }*/

        //return result;
        return text;
    }
}
