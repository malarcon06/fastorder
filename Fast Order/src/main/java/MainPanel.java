import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MainPanel extends JPanel implements ActionListener {


    ArrayList<JButton> botonesMesas;
    int counter = 0;
    int counter2 = 0;
    JButton helperButton;
    JPanel panelDerecho;
        JPanel panelFiltro1;
            JRadioButton botonLibres;
            JRadioButton botonOcupadas;
        JPanel panelFiltro2;
            JRadioButton botonEsperando;
            JRadioButton botonComiendo;
            JRadioButton botonTodo;
        JPanel panelBusqueda;
            JTextField textoBusqueda;
            JButton botonBusqueda;
        JPanel panelInfo;
            JScrollPane scrollInfo;
                JPanel lista;

    JPanel panelIzquierdo;
        JPanel panelSalas;
            JPanel panelFiltro3;
                JRadioButton botonComedor;
                JRadioButton botonTerraza;
            JButton opcionesSalas;
                JPopupMenu opcionesPopup;
                JMenuItem opcion1, opcion2, opcion3;
        JPanel panelMesas;


    MainPanel(){

        this.setLayout(null);
        this.setBounds(0,0,900,600);
        this.setBackground(Color.black);

        //Panel Derecho

        panelDerecho = new JPanel();
        panelDerecho.setLayout(null);
        panelDerecho.setBounds(0,0,300,600);
        this.add(panelDerecho);

        panelFiltro1 = new JPanel();
        panelFiltro1.setLayout(new GridLayout(1,2));
        panelFiltro1.setBounds(0,0,300,60);
        panelFiltro1.setBackground(Color.orange);

        ImageIcon emptyIcon = new ImageIcon("empty.png");

        botonLibres = new JRadioButton("LIBRES");
        botonLibres.setIcon(emptyIcon);
        botonLibres.setFocusable(false);
        botonLibres.addActionListener(this);
        botonLibres.setHorizontalAlignment(JRadioButton.CENTER);
        panelFiltro1.add(botonLibres);

        botonOcupadas = new JRadioButton("OCUPADAS");
        botonOcupadas.setIcon(emptyIcon);
        botonOcupadas.setFocusable(false);
        botonOcupadas.addActionListener(this);
        panelFiltro1.add(botonOcupadas);
        ButtonGroup filtroMesas = new ButtonGroup();
        filtroMesas.add(botonLibres);
        filtroMesas.add(botonOcupadas);

        panelDerecho.add(panelFiltro1);

        panelFiltro2 = new JPanel();
        panelFiltro2.setLayout(new GridLayout(1,3));
        panelFiltro2.setBounds(0,60,300,60);
        panelFiltro2.setBackground(Color.blue);
        panelDerecho.add(panelFiltro2);

        botonEsperando = new JRadioButton("Esperando");
        botonEsperando.setIcon(emptyIcon);
        botonEsperando.setFocusable(false);
        botonEsperando.addActionListener(this);
        panelFiltro2.add(botonEsperando);

        botonComiendo = new JRadioButton("Comiendo");
        botonComiendo.setIcon(emptyIcon);
        botonComiendo.setFocusable(false);
        botonComiendo.addActionListener(this);
        panelFiltro2.add(botonComiendo);

        botonTodo = new JRadioButton("Todo");
        botonTodo.setIcon(emptyIcon);
        botonTodo.setFocusable(false);
        botonTodo.addActionListener(this);
        panelFiltro2.add(botonTodo);

        filtroMesas.add(botonEsperando);
        filtroMesas.add(botonComiendo);
        filtroMesas.add(botonTodo);

        panelBusqueda = new JPanel();
        panelBusqueda.setLayout(null);
        panelBusqueda.setBounds(0,120,300,35);
        panelBusqueda.setBackground(Color.white);
        panelDerecho.add(panelBusqueda);

        textoBusqueda = new JTextField();
        textoBusqueda.setBounds(2,0,220,35);
        panelBusqueda.add(textoBusqueda);

        botonBusqueda = new JButton("Buscar");
        botonBusqueda.setBounds(225,1,75,33);
        panelBusqueda.add(botonBusqueda);

        panelInfo = new JPanel();
        panelInfo.setLayout(new BorderLayout());
        panelInfo.setBackground(Color.orange);
        panelInfo.setBounds(0,155,300,407);


        lista = new JPanel(new GridBagLayout());
        System.out.println("Comoponentes de la lista: "+lista.getComponents().length);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.weighty = 1;
        lista.add(new JPanel(), gbc);
        scrollInfo = new JScrollPane(lista);


        panelInfo.add(scrollInfo);
        counter2 = 0;
        JButton deleteButton = new JButton("Delete BUTTON");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component[] listOfComponent = lista.getComponents();
                if(listOfComponent.length > 1){
                    counter2++;
                    System.out.println("Delete button "+counter2);
                    lista.remove(listOfComponent[0]);
                    validate();
                    repaint();
                }
            }
        });
        counter = 0;
        JButton addButton = new JButton("Add BUTTON");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter++;
                JPanel panel = new JPanel();
                panel.setPreferredSize(new Dimension(300, 50));
                panel.add(new JLabel("Hello "+counter));
                panel.setBorder(new MatteBorder(0, 0, 1, 0, Color.GRAY));
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                gbc.weightx = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                lista.add(panel, gbc, 0);
                validate();
                repaint();
            }
        });

        JPanel helperPanel = new JPanel(new BorderLayout());
        helperPanel.add(addButton, BorderLayout.WEST);
        helperPanel.add(deleteButton, BorderLayout.EAST);

        panelInfo.add(helperPanel, BorderLayout.SOUTH);

        panelDerecho.add(panelInfo);

        JList<JPanel> pba3 = new JList();

        JPanel pba = new JPanel();
        pba.setBackground(Color.black);
        pba.setBounds(0,0,300,800);

        JPanel pba2 = new JPanel();
        pba2.setBackground(Color.gray);
        pba2.setBounds(0,800,300,500);

        pba3.add(pba);
        pba3.add(pba2);


        for(Mesa mesa: FastOrderApp.esteLocal.getMesas()){

        }

        //Panel Izquierdo

        panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new BorderLayout());
        panelIzquierdo.setBounds(300,0,600,600);
        this.add(panelIzquierdo);

        panelSalas = new JPanel();
        panelSalas.setLayout(new BorderLayout());
        panelSalas.setPreferredSize(new Dimension(600,60));
        panelSalas.setBackground(Color.lightGray);
        panelIzquierdo.add(panelSalas, BorderLayout.NORTH);

        panelFiltro3 = new JPanel();
        panelFiltro3.setLayout(new GridLayout());
        panelFiltro3.setBackground(Color.BLUE);
        panelSalas.add(panelFiltro3);


        botonComedor = new JRadioButton("COMEDOR");
        botonComedor.setIcon(emptyIcon);
        botonComedor.setFocusable(false);
        botonComedor.addActionListener(this);
        panelFiltro3.add(botonComedor);

        botonTerraza = new JRadioButton("TERRAZA");
        botonTerraza.setIcon(emptyIcon);
        botonTerraza.setFocusable(false);
        botonTerraza.addActionListener(this);
        panelFiltro3.add(botonTerraza);

        ButtonGroup filtroSala = new ButtonGroup();
        filtroSala.add(botonComedor);
        filtroSala.add(botonTerraza);




        opcionesSalas = new JButton("Opciones");
        opcionesPopup = new JPopupMenu();
        opcionesPopup.add(new JMenuItem(new AbstractAction("Editar Menu") {
            public void actionPerformed(ActionEvent e) {
                //mostrar menu editable
            }
        }));

        opcionesPopup.add(new JMenuItem(new AbstractAction("Editar Mesas") {
            public void actionPerformed(ActionEvent e) {
                //mostrar editor de mesas
            }
        }));

        opcionesPopup.add(new JMenuItem(new AbstractAction("Editar Salas") {
            public void actionPerformed(ActionEvent e) {
                //??
            }
        }));

        opcionesSalas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                opcionesPopup.show(opcionesSalas, 0, opcionesSalas.getHeight());
            }
        });
        panelSalas.add(opcionesSalas, BorderLayout.EAST);

        panelMesas = new JPanel();
        panelMesas.setPreferredSize(new Dimension(600,540));
        panelMesas.setBackground(Color.darkGray);
        panelIzquierdo.add(panelMesas, BorderLayout.SOUTH);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==botonOcupadas){
           // botonOcupadas.setForeground(Color.GREEN);
        }
    }
}
