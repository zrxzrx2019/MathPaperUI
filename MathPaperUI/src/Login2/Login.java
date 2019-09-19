package Login2;
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.sql.*;

public class Login  extends JFrame implements ActionListener {
	 
    //�����¼��������  
    JButton jb1,jb2,jb3=null;  
    JRadioButton jrb1,jrb2=null;  
    JPanel jp1,jp2,jp3,jp4=null;  
    JTextField jtf=null;  
    JLabel jlb1,jlb2,jlb3=null;  
    JPasswordField jpf=null;  
    ButtonGroup bg=null;  
          
    //�趨�û���������  
    static String userword;  
    static String pwd;  
      
    static Connection ct=null;  
    PreparedStatement ps=null;  
    ResultSet rs=null;  
      
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        Login  ms=new Login();  
          
          
        try {  
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/zrx?useSSL=false&serverTimezone=UTC","root","123456");  
        } catch (Exception e) {  
              
            e.printStackTrace();  
        }  
                          
    }  
    //���캯��  
    public Login()  
    {  
         //�������  
        jb1=new JButton("��¼");  
        jb2=new JButton("����");  
        jb3=new JButton("�˳�");  
        //���ü���  
        jb1.addActionListener(this);  
        jb2.addActionListener(this);  
        jb3.addActionListener(this);  
        //����������ť�ļ���ͳһ������actionPerformance()��  
        //����Ҳ�������±����ַ�ʽ  
//      jb3.addActionListener(new ActionListener()  
//      {  
//  
//          @Override  
//          public void actionPerformed(ActionEvent e) {  
//              // TODO Auto-generated method stub                
//              System.exit(0);  
//          }  
//            
//      });  
          
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
        jp4.add(jb3);  
          
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
        this.setResizable(true);  
          
    }  
    @Override  
    public void actionPerformed(ActionEvent e) {  
  
        if(e.getActionCommand()=="�˳�")  
        {  
            System.exit(0);  
        }else if(e.getActionCommand()=="��¼")  
        {  
            //���ѡ�н�ʦ��¼  
            if(jrb1.isSelected())  
            {  
                //���������  
                try {  
                    ps=ct.prepareStatement("select * from info where Ȩ��=? ");  
                    //��?��ֵ(�ɷ�ֹSQLע��©������)����Ҫֱ��ʹ��ƴ�ӵķ�ʽ  
                    ps.setString(1, "��ʦ");                    
                    //ResultSet�����,��ҿ��԰�ResultSet���ɷ���һ�ű��еĽ����  
                    rs=ps.executeQuery();  
                    //ѭ��ȡ��  
                    while(rs.next()){  
                        //����ʦ���û���������ȡ��  
                         userword=rs.getString(2);  
                         pwd=rs.getString(3);  
                        System.out.println("�ɹ���ȡ��������û���from���ݿ�");  
                        System.out.println(userword+"\t"+pwd+"\t");   
                    }  
                } catch (SQLException e1) {  
                    e1.printStackTrace();  
                }  
                //�����ݿ�õ��û������������õ�¼��������������û������������Ƚ�  
                tealogin();  
            }else if(jrb2.isSelected()) //ѧ���ڵ�¼ϵͳ  
            {  
                //���������  
                try {  
                    ps=ct.prepareStatement("select * from info where Ȩ��=? ");  
                    //��?��ֵ(�ɷ�ֹSQLע��©������)����Ҫֱ��ʹ��ƴ�ӵķ�ʽ  
                    ps.setString(1, "ѧ��");  
                    //ResultSet�����,��ҿ��԰�ResultSet���ɷ���һ�ű��еĽ����  
                    rs=ps.executeQuery();  
                    //ѭ��ȡ��  
                    while(rs.next()){  
                        //��ѧ�����û���������ȡ��  
                         userword=rs.getString(2);  
                         pwd=rs.getString(3);  
                        System.out.println("�ɹ���ȡ��������û���from���ݿ�");  
                        System.out.println(userword+"\t"+pwd+"\t");   
                    }  
                } catch (SQLException e1) {  
                    e1.printStackTrace();  
                }  
                //�����ݿ�õ��û������������õ�¼��������������û������������Ƚ�  
                stulogin();  
            }  
              
        }else if(e.getActionCommand()=="����")  
        {  
            clear();  
        }             
          
    }  
          
      
//����ı���������  
    public  void clear()  
        {  
            jtf.setText("");  
            jpf.setText("");  
        }  
//ѧ����¼�жϷ���  
    public void stulogin()  
        {  
            if(userword.equals(jtf.getText())&&pwd.equals(jpf.getText()))  
            {  
//              System.out.println("��¼�ɹ�");  
                JOptionPane.showMessageDialog(null,"��¼�ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
                clear();  
                //�رյ�ǰ����  
                 dispose();  
                 //����һ���½���  
                 UI ui=new UI();  
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
            if(userword.equals(jtf.getText())&&pwd.equals(jpf.getText()))  
            {  
//              System.out.println("��¼�ɹ�");  
                 JOptionPane.showMessageDialog(null,"��¼�ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
                 clear();     
                //�رյ�ǰ����  
                 dispose();  
                 //����һ���½��棬�����ڽ�ʦ������ѧ��  
                 UI ui=new UI();                                          
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
}
