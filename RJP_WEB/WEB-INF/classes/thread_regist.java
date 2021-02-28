import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tera.DBAccess;
import tera.ThreadBean;


public class thread_regist extends HttpServlet {

    private ArrayList<ThreadBean> threads = new ArrayList<ThreadBean>();

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        //POST�v���ɂ���đ��M���ꂽ��������N���C�A���g��
        //�G���R�[�h�����Ƃ��̕����R�[�h���w�肷��
        //������w�肵�Ȃ��ƕ�����������\��������
        req.setCharacterEncoding("Windows-31J");

        //POST�v���ɂ���đ��M���ꂽ�p�����[�^���擾����
        String tn = req.getParameter("thread_Name");
        String pn = req.getParameter("pen_Name");

        //UserBean���C���X�^���X�����A�f�[�^���Z�b�g����
		ThreadBean thread=new ThreadBean();
		thread.setThreadName(tn);
		thread.setPenName(pn);
		
        DBAccess db=new DBAccess();
        //db.insertRes(2,thread.getRes_name(),���񂽂炩�񂽂�)

		//���X�g�ɒǉ�����@ArrayList�ɂ����
		threads.add(thread);

        //HttpServletRequest�̎����N���X�̃C���X�^���X��
        //threads�Ƃ������O��pass�Ƃ������O�Ńf�[�^��o�^���� thread��Arraylist���𑗂��Ă���
        req.setAttribute("threads", threads);
        
        //RequestDispatcher�C���^�[�t�F�C�X����������N���X��
        //�C���X�^���X���擾����
        //�����͓]�����URL
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("threadslist");

        //�]����ɗv����]������
        dispatcher.forward(req, res);
    }

    protected void doGet(HttpservletRequest req,HttpServletResponse res)throws ServletException,IOException {

    }
}