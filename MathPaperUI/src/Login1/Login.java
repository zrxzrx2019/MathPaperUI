package Login1;

import javax.swing.*;  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener; 

public class Login  extends JFrame implements ActionListener {
	//�������  
    JButton jb1,jb2=null;  
    JRadioButton jrb1,jrb2=null;  
    JPanel jp1,jp2,jp3,jp4=null;  
    JLabel jlb1,jlb2,jlb3=null;  
    JTextField jtf=null;  
    JPasswordField jpf=null;  
    ButtonGroup bg=null;  
          
    //�趨�û���������  
    final String stu_name="6";  
    final String stu_pwd="1";  
    final String tea_name="5";  
    final String tea_pwd="1";  
      
    public static void main(String[] args) {  
        Login  win=new Login();  
    }  
    public Login()  
    {  
         //�������  
        jb1=new JButton("��¼");  
        jb2=new JButton("����");  
        //���ü���  
        jb1.addActionListener(this);  
        jb2.addActionListener(this);  
          
        jrb1=new JRadioButton("��ʦ");  
        jrb2=new JRadioButton("ѧ��");  
        bg=new ButtonGroup();  
        bg.add(jrb1);  
        bg.add(jrb2);  
        jrb2.setSelected(true);  
          
        jp1=new JPanel();  
        jp2=new JPanel();  
        jp3=new JPanel();  
        jp4=new JPanel();                 
          
        jlb1=new JLabel("�û�����");  
        jlb2=new JLabel("��    �룺");  
        jlb3=new JLabel("Ȩ    �ޣ�");  
          
        jtf=new JTextField(10);  
        jpf=new JPasswordField(10);  
        //���뵽JPanel��  
        jp1.add(jlb1);  
        jp1.add(jtf);  
          
        jp2.add(jlb2);  
        jp2.add(jpf);  
          
        jp3.add(jlb3);  
        jp3.add(jrb1);  
        jp3.add(jrb2);  
          
        jp4.add(jb1);  
        jp4.add(jb2);  
          
        //����JFrame��  
        this.add(jp1);  
        this.add(jp2);  
        this.add(jp3);  
        this.add(jp4);  
        //���ò��ֹ�����  
        this.setLayout(new GridLayout(4,1));  
        //���������ñ���  
        this.setTitle("ѧ���ɼ�����ϵͳ");  
        //���ô����С  
        this.setSize(300,200);  
        //���ô����ʼλ��  
        this.setLocation(200, 150);  
        //���õ��رմ���ʱ����֤JVMҲ�˳�  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        //��ʾ����  
        this.setVisible(true); 
        //�������� 
        this.setResizable(true);  
          
    }  
    @Override  
    public void actionPerformed(ActionEvent e) {  
          
        if(e.getActionCommand()=="��¼")  
        {  
            //���ѡ�н�ʦ��¼  
            if(jrb1.isSelected())  
            {  
                  tealogin();  
            }else if(jrb2.isSelected()) //ѧ���ڵ�¼ϵͳ  
            {  
                  stulogin();  
            }  
              
        }else if(e.getActionCommand()=="����")  
        {  
                  clear();  
        }             
          
    }  
      
     //ѧ����¼�жϷ���  
    public void stulogin()  
    {  
        if(stu_name.equals(jtf.getText())&&stu_pwd.equals(jpf.getText()))  
        {  
//          System.out.println("��¼�ɹ�");  
            JOptionPane.showMessageDialog(null,"��¼�ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
            clear();  
        }else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"�������û��������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
        }else if(jtf.getText().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"�������û�����","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
        }else if(jpf.getText().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"���������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
        }else  
        {  
            JOptionPane.showMessageDialog(null,"�û��������������\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);  
            //��������  
            clear();  
        }  
    }  
    //��ʦ��¼�жϷ���  
    public void tealogin()  
    {  
        if(tea_name.equals(jtf.getText())&&tea_pwd.equals(jpf.getText()))  
        {  
//          System.out.println("��¼�ɹ�");  
             JOptionPane.showMessageDialog(null,"��¼�ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
             clear();  
        }else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"�������û��������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
        }else if(jtf.getText().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"�������û�����","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
        }else if(jpf.getText().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"���������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
        }else  
        {  
            JOptionPane.showMessageDialog(null,"�û��������������\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);  
            //��������  
            clear();  
        }  
    }  
    //����ı���������  
    public  void clear()  
    {  
        jtf.setText("");  
        jpf.setText("");  
    }
}
