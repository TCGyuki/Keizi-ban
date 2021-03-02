import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

import tera.ThreadBean;
import tera.ResBean;
import tera.DBAccess;
import tera.NgCheck;
import tera.newLine;

public class ResponseServlet extends HttpServlet {

    private ArrayList<ResBean> responses = new ArrayList<ResBean>();
    DBAccess db  = new DBAccess();
    NgCheck nc = new NgCheck();
    newLine nl = new newLine();
    private String t_id; 
    private ArrayList<ThreadBean> r_list = new ArrayList<ThreadBean>();

    //private String th_id;//THREAD_ID�i�[�p

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        //POST�v���ɂ���đ��M���ꂽ��������N���C�A���g��
        //�G���R�[�h�����Ƃ��̕����R�[�h���w�肷��
        //������w�肵�Ȃ��ƕ�����������\��������
        req.setCharacterEncoding("Windows-31J");
        
        //POST�v���ɂ���đ��M���ꂽ�p�����[�^���擾����
        String ri = req.getParameter("Res_ID");
        String rd = req.getParameter("Res_Date");
        String ru = req.getParameter("Res_User");
        String rc = req.getParameter("Res_comment");
        
        //Integer rii=Integer.parseInt(ri);
        
        //���s����
        //rc = nl.htmlEscape(rc);
        //NG�`�F�b�N����
        String result=nc.doCheck(rc);
        if(result == ""){
        }else{
            rc = result;
        }

        
        //UserBean���C���X�^���X�����A�f�[�^���Z�b�g����
		ResBean response=new ResBean();
		response.setResID(ri);
		response.setResDate(rd);
        response.setResUser(ru);
        response.setResComment(rc);
        
        t_id=req.getParameter("id");
        db.resInsert(t_id,/*response.getResID(),*/response.getResUser(),/*response.getResDate(),*/response.getResComment());
        //db.resInsert(ru,rc);

        req.setAttribute("t_id",t_id);
		//���X�g�ɒǉ�����@ArrayList�ɂ����
		//responses.add(response);

        //HttpServletRequest�̎����N���X�̃C���X�^���X��
        //threads�Ƃ������O��pass�Ƃ������O�Ńf�[�^��o�^���� thread��Arraylist���𑗂��Ă���
        //req.setAttribute("responses", responses);
        
        //RequestDispatcher�C���^�[�t�F�C�X����������N���X��
        //�C���X�^���X���擾����
        //�����͓]�����URL
        //RequestDispatcher dispatcher =
        //        req.getRequestDispatcher("responselist");

        //�]����ɗv����]������
        //dispatcher.forward(req, res);
        
        
        doGet(req,res);
    }

    protected void doGet(HttpServletRequest req,HttpServletResponse res)
        throws ServletException,IOException {
        //���ʂɃ��X��S���o��
        res.setContentType("text/html; charset=Windows-31J");

        PrintWriter out = res.getWriter();
        
        t_id = req.getParameter("id");
        r_list=db.selectThid(t_id,r_list);
        responses=db.resSelect(t_id,responses);
        //responses = db.getData();//�Z�b�g���Ȃ��Ⴂ���Ȃ����� 
        req.setAttribute("r_list",r_list);
        req.setAttribute("responses",responses);
        req.setAttribute("t_id",t_id);

        RequestDispatcher dispatcher = 
            req.getRequestDispatcher("responselist");
        
        dispatcher.forward(req,res);
    }
}