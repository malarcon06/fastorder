import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {


    JPanel panelVoler;
        JButton botonVolver;
    JPanel panelCategorias;
        JButton botonAnadirCategoria;
        JPanel listaCategorias;
            JScrollPane scrollCategorias;

    public MenuPanel(){

        this.setBounds(0,0,900,600);
        this.setBackground(Color.orange);
        this.setLayout(null);


        panelVoler = new JPanel();
        panelVoler.setLayout(new BorderLayout());
        panelVoler.setBackground(Color.darkGray);
        panelVoler.setBounds(0,0,900,50);
        this.add(panelVoler);

        botonVolver = new JButton("Volver");
        botonVolver.setFocusable(false);
        panelVoler.add(botonVolver, BorderLayout.WEST);

        panelCategorias = new JPanel();
        panelCategorias.setLayout(new BorderLayout());
        panelCategorias.setBackground(Color.gray);
        panelCategorias.setBounds(0,50,900,50);
        this.add(panelCategorias);


        listaCategorias = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridheight = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.weighty = 1;
        listaCategorias.add(new JPanel(), gbc);
        scrollCategorias = new JScrollPane(listaCategorias);
        panelCategorias.add(scrollCategorias);


        botonAnadirCategoria = new JButton("anadir categoria");
        botonAnadirCategoria.setFocusable(false);
        botonAnadirCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel = new JPanel();
                panel.setPreferredSize(new Dimension(200, 45));
                panel.add(new JLabel("Hello "));
                panel.setBorder(new MatteBorder(0, 0, 0, 1, Color.GRAY));
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridheight = GridBagConstraints.REMAINDER;
                gbc.weighty = 1;
                gbc.fill = GridBagConstraints.VERTICAL;
                listaCategorias.add(panel, gbc, 0);
                validate();
                repaint();
            }
        });
        panelCategorias.add(botonAnadirCategoria, BorderLayout.EAST);

    }

}
