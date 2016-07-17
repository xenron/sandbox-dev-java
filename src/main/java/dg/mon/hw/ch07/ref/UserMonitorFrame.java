package dg.mon.hw.ch07.ref;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UserMonitorFrame extends JFrame implements Runnable{

    /**
     *
     */
    private static final long serialVersionUID = 8674569541853793419L;
    private JPanel contentPane;
    private JTextField fileField;
    private JTextField searchTextField;
    private JTextField replaceTextField;
    private File file;
    private JTextField textField;
    private JTextField textField_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserMonitorFrame frame = new UserMonitorFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public UserMonitorFrame() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 501, 184);
        setTitle("在读取文件时使用进度条");
        getContentPane().setLayout(null);

        JLabel label = new JLabel("\u6587\u4EF6\u5730\u5740\uFF1A");
        label.setBounds(10, 10, 70, 15);
        getContentPane().add(label);

        textField = new JTextField();
        textField.setBounds(90, 7, 300, 21);
        getContentPane().add(textField);
        textField.setColumns(10);

        JButton button = new JButton("\u9009\u62E9\u6587\u4EF6");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(400, 6, 93, 23);
        getContentPane().add(button);

        JLabel label_1 = new JLabel("\u590D\u5236\u5730\u5740\uFF1A");
        label_1.setBounds(10, 40, 70, 15);
        getContentPane().add(label_1);

        textField_1 = new JTextField();
        textField_1.setBounds(90, 38, 300, 21);
        getContentPane().add(textField_1);
        textField_1.setColumns(10);

        JButton button_1 = new JButton("\u9009\u62E9\u5730\u5740");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_1_actionPerformed(e);
            }
        });
        button_1.setBounds(400, 39, 93, 23);
        getContentPane().add(button_1);

        JButton button_2 = new JButton("\u5F00\u59CB\u590D\u5236");
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_copyButton_actionPerformed(e);
            }
        });
        button_2.setBounds(182, 69, 93, 23);
        getContentPane().add(button_2);
    }
    protected void do_button_actionPerformed(ActionEvent e){
        JFileChooser chooser=new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        // 显示文件打开对话框
        int option = chooser.showOpenDialog(this);
        // 确定用户按下打开按钮，而非取消按钮
        if (option != JFileChooser.APPROVE_OPTION)
            return;
        // 获取用户选择的文件对象
        file = chooser.getSelectedFile();
        // 显示文件信息到文本框
        textField.setText(file.toString());
    }
    protected void do_button_1_actionPerformed(ActionEvent e){
        JFileChooser chooser=new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option=chooser.showOpenDialog(this);
        if(option!=JFileChooser.APPROVE_OPTION)
            return;
        file=chooser.getSelectedFile();
        textField_1.setText(file.toString());
    }
    //确定复制按钮单击事件
    protected void do_copyButton_actionPerformed(ActionEvent arg0) {
        Thread thread = new Thread(this);
        thread.start();
    }
    //应用多线程技术实现读取操作
    @Override
    public void run() {
        ProgressMonitorTest test = new ProgressMonitorTest();
        String path = textField.getText();
        String save = textField_1.getText();
        test.useProgressMonitor(this,path,save+path.substring(path.lastIndexOf("."),path.length()));
    }
}
