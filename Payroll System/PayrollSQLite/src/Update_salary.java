import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Update_salary extends JFrame implements ActionListener,ItemListener{
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton b1,b2;
    Choice c2;
    
    Update_salary(){
        
        setLayout(null);
        getContentPane().setBackground(Color.YELLOW);
        getContentPane().setForeground(Color.BLUE);
        
        c2 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from salary");
            while(rs.next()){
                c2.add(rs.getString("id"));    
            }
                        rs.close();
            c.s.close();
            c.c.close();
           
        }catch(Exception e){ }
       
        JLabel emp = new JLabel("Employee no. :");
        emp.setBounds(40,40,100,20);
        add(emp);
        
        c2.setBounds(140,40,200,20);
        add(c2);
        
        l1 = new JLabel("HRA : ");
        t1 = new JTextField(15);
        
        l1.setBounds(40,80,100,20);
        t1.setBounds(140,80,200,20);
        add(l1);
        add(t1);
       
        l2 = new JLabel("DA : ");
        t2 = new JTextField(15);
        
        l2.setBounds(40,120,100,20);
        t2.setBounds(140,120,200,20);
        add(l2);
        add(t2);
       
        l3 = new JLabel("MED : ");
        t3 = new JTextField(15);
        
        l3.setBounds(40,160,100,20);
        t3.setBounds(140,160,200,20);
        add(l3);
        add(t3);
       
        l4 = new JLabel("PF : ");
        t4 = new JTextField(15);
        
        l4.setBounds(40,200,100,20);
        t4.setBounds(140,200,200,20);
        add(l4);
        add(t4); 
       
        l5 = new JLabel("basic_salary : ");
        t5 = new JTextField(15);
        
        l5.setBounds(40,240,100,20);
        t5.setBounds(140,240,200,20);
        add(l5);
        add(t5);
       
        b1 =new JButton("Update");
        b1.setBackground(Color.black);
        b1.setForeground(Color.GREEN);
        
        b2 = new JButton("Delete");
        b2.setBackground(Color.black);
        b2.setForeground(Color.RED);
        
        b1.setBounds(60,320,100,20);
        b2.setBounds(220,320,100,20);
        add(b1);
        add(b2);
       
        b1.addActionListener(this);
        b2.addActionListener(this);
        c2.addItemListener(this);
       
        setVisible(true);
        setSize(400,450);
        setLocation(800,300);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b1){
            String hra = t1.getText();
            String id = c2.getSelectedItem();
            String da = t2.getText();
            String med = t3.getText();
            String pf = t4.getText();
            String basic = t5.getText();
      
            String qry = "update salary set hra="+hra+",da="+da+",med="+med+",pf="+pf+",basic_salary="+basic+"  where id="+c2.getSelectedItem();
       
            try{
                conn c1 = new conn();
                c1.s.executeUpdate(qry);
                JOptionPane.showMessageDialog(null,"Salary Updated");
                this.setVisible(false);
                
            c1.s.close();
            c1.c.close();
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
        
        if(ae.getSource()==b2){
            
            try{
                conn c1 = new conn();
                c1.s.executeUpdate("delete from salary where id="+c2.getSelectedItem());
                JOptionPane.showMessageDialog(null,"Salary Deleted");
                this.setVisible(false);
                            
            c1.s.close();
            c1.c.close();
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
    }
    
    public void itemStateChanged(ItemEvent ie)
    {
        try{
           conn c1 = new conn();
            ResultSet rs = c1.s.executeQuery("select * from salary where id="+c2.getSelectedItem());
            if(rs.next()){
                t1.setText(rs.getString("hra"));
                t2.setText(rs.getString("da"));
                t3.setText(rs.getString("med"));
                t4.setText(rs.getString("pf"));
                t5.setText(rs.getString("basic_salary"));
         
            }
                        rs.close();
            c1.s.close();
            c1.c.close();
       }catch(Exception ee){
           ee.printStackTrace();
       }
        
        
    }
    
    public static void main(String[] args){
        new Update_salary();
    }
    
}
