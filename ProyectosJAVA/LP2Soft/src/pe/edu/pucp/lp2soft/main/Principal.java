package pe.edu.pucp.lp2soft.main;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class Principal {
    public static void main(String[] args) throws Exception{
        /* look and feel */
        try{
            for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
                if(("Windows".equals(info.getName()))){
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        JFrame formPrincipal = new JFrame();
        frmPrincipal panelPrincipal = new frmPrincipal(formPrincipal);
        formPrincipal.setUndecorated(true);
        formPrincipal.add(panelPrincipal);
        FrameDragListener listener = new FrameDragListener(formPrincipal);
        formPrincipal.addMouseListener(listener);
        formPrincipal.addMouseMotionListener(listener);
        formPrincipal.setLocationRelativeTo(null);
        formPrincipal.pack();
        formPrincipal.setFocusable(true);
        formPrincipal.setResizable(false);
        formPrincipal.setLocationRelativeTo(null);
        formPrincipal.setDefaultCloseOperation(EXIT_ON_CLOSE);
        formPrincipal.setVisible(true);
    }
}