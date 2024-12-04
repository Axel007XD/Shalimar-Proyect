package com.axel.Views;

import com.axel.Controllers.ControllerUser;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Login extends JFrame implements ActionListener {

    private JLabel fondoImagen;
    private JLabel jlbName, jlbPassword, jlbLogin;
    private JTextField txtName;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JPanel panel,panel2;
    private ControllerUser controlleruser;

        public Login() {

            setTitle("Login");
            setSize(450,500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);


            panel = new JPanel(){
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    URL urlImagenLogin= Login.class.getResource("/imagenNevulosa1.png");
                    ImageIcon imagen = new ImageIcon(urlImagenLogin);
                    Image imagenFondo = imagen.getImage();
                    g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
                }
            };
            setContentPane(panel);

            panel2 = new JPanel();
            panel2.setPreferredSize(new Dimension(300,350));
            panel2.setOpaque(false);

            jlbLogin= new JLabel("Login");
            jlbLogin.setFont(new Font("Liberation Serif", Font.BOLD, 30));
            jlbLogin.setForeground(Color.white);

            LineBorder lineBorder = new LineBorder(Color.white,2);
            jlbName=new JLabel("Usuario:");
            jlbName.setFont(new Font("Liberation Serif", Font.BOLD, 19));
            jlbName.setForeground(Color.white);

            jlbPassword=new JLabel("Contraseña:");
            jlbPassword.setFont(new Font("Liberation Serif", Font.BOLD, 19));
            jlbPassword.setForeground(Color.white);

            txtName=new JTextField();
            txtName.setFont(new Font("Liberation Serif", Font.BOLD, 14));

            txtName.setBorder(lineBorder);

            txtPassword=new JPasswordField();
            txtPassword.setFont(new Font("Liberation Serif", Font.BOLD, 14));

            txtPassword.setBorder(lineBorder);

            btnLogin=new JButton("Enviar");
            btnLogin.setFont(new Font("Liberation Serif", Font.BOLD, 20));

            btnLogin.setBorder(lineBorder);


            panel2.setLayout(new GridBagLayout());

            GridBagConstraints c = new GridBagConstraints();


            c.gridx=0;
            c.gridy = 0;
            c.gridwidth=4;
            c.anchor=GridBagConstraints.CENTER;
            c.ipady=10;
            c.ipadx=10;
            c.insets=new Insets(5,5,25,0);
            panel2.add(jlbLogin,c);

            ///

            c.gridx=0;
            c.gridy=1;
            c.gridwidth=1;
            c.anchor=GridBagConstraints.WEST;
            c.weighty=1;
            c.ipady=10;
            c.ipadx=40;
            c.insets=new Insets(0,0,0,0);
            panel2.add(jlbName,c);

            c.gridx=1;
            c.gridy=1;
            c.gridwidth=2;
            c.ipadx=150;
            panel2.add(txtName,c);

            c.gridx=0;
            c.gridy=2;
            c.ipadx=40;
            c.gridwidth=1;
            panel2.add(jlbPassword,c);

            c.gridx=1;
            c.gridy=2;
            c.ipadx=150;
            c.gridwidth=2;
            panel2.add(txtPassword,c);

            c.gridx=0;
            c.gridy=3;
            c.gridwidth=4;
            c.anchor=GridBagConstraints.CENTER;
            c.weighty=4;
            c.insets=new Insets(5,5,5,0);
            c.ipady=10;
            c.ipadx=40;


            panel2.add(btnLogin,c);

            panel.add(panel2);


            btnLogin.addActionListener(this);
            setVisible(true);


        }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getSource() == btnLogin) {
                String username = txtName.getText();
                String password = String.valueOf(txtPassword.getPassword());
                if (!username.isEmpty() && !password.isEmpty()) {
                    boolean validarUser=inicializarControladorUser().validarUser(username,password);
                    if(validarUser){
                        new ventanaMenuPrincipal();
                        dispose();

                    }

                }else{
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                }
            }

    }
    private ControllerUser inicializarControladorUser(){
            if (controlleruser == null){
                controlleruser = new ControllerUser();
            }
            return controlleruser;
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public void setBtnLogin(JButton btnLogin) {
        this.btnLogin = btnLogin;
    }



    public JLabel getFondoImagen() {
        return fondoImagen;
    }

    public void setFondoImagen(JLabel fondoImagen) {
        this.fondoImagen = fondoImagen;
    }

    public JLabel getJlbLogin() {
        return jlbLogin;
    }

    public void setJlbLogin(JLabel jlbLogin) {
        this.jlbLogin = jlbLogin;
    }

    public JLabel getJlbName() {
        return jlbName;
    }

    public void setJlbName(JLabel jlbName) {
        this.jlbName = jlbName;
    }

    public JLabel getJlbPassword() {
        return jlbPassword;
    }

    public void setJlbPassword(JLabel jlbPassword) {
        this.jlbPassword = jlbPassword;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public void setTxtName(JTextField txtName) {
        this.txtName = txtName;
    }

    public JPasswordField getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(JPasswordField txtPassword) {
        this.txtPassword = txtPassword;
    }


}
