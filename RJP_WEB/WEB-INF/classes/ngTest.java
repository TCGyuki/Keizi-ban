package jp.took.util;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ngTest {
/**
*���e�L�������ɓ��͂��Ă͂����Ȃ����������݂��Ȃ������m�F���A�����܂܂�Ă����ꍇ�́A�G���[���b�Z�[�W��Ԃ��܂��B
* �܂��A�������̐������ꏏ�ɂł���悤�ɂȂ��Ă��܂��B
* �֎~������ǉ��������ꍇ�́Aword�z��ɋ֎~������������ǉ����Ă��������B
*/
//�֎~�����A����������
    public List<String> doCheck(String title,String introduction){
        List<String> stringList = new ArrayList<String>();
        String value[] = {"�^�C�g��","�Љ"};
        String contents[] = {title,introduction};//���肷�镶����
        for(int o = 0;o<2;o++) {//�^�C�g��(�ŏ��A�ő�)�A�Љ(�ŏ��A�ő�)
            int restriction[][] = {{1,15},{30,150}};
            if(contents[o].length() < restriction[o][0] || contents[o].length() > restriction[o][1]){
                stringList.add(value[o] + "��" + restriction[o][0] + "�����ȏ�" + restriction[o][1] + "�����ȉ��œ��͂��Ă��������B");
            }       
            //�֎~������𑝂₵�����ꍇ�́A���̔z����ɗv�f��ǉ����Ă�������
            String word[] = {"�֎~����1","�֎~����2","�֎~����3","�֎~����4"};

            for(String i:word){
                StringBuilder sb = new StringBuilder();
                sb.append("^(.*");
                sb.append(i);
                sb.append(").*");
                Pattern p = Pattern.compile(sb.toString());
                Matcher m = p.matcher(contents[o]);

                //�֎~�������܂܂�Ă��邩���肷��
                if(m.find()) {
                    stringList.add("�֎~�������܂܂�Ă��܂��B");
                    return stringList;
                }
            }
        }
        return stringList;
    }
}
