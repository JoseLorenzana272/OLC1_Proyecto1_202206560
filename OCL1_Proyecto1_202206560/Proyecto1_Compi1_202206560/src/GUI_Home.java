
import java_cup.Lexer;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.Lexer;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author PERSONAL
 */
public class GUI_Home extends javax.swing.JFrame {

    private JTabbedPane tabbedPane;
    private int tabCounter = 1;
    
    public GUI_Home() {
        initComponents();
        tabbedPane = jTabbedPane1;
        customizeTabbedPane();
        JButton [] btns = {btnEjecutar, btnAbrir, btnGuardar, btnNuevo, btnReportes, btnSalir, btnAnterior, btnSiguiente};
        for (JButton btn : btns){
            btn.setBackground(new Color(21,25,28));
            btn.setUI(new BasicButtonUI());
            btn.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    btn.setBackground(new Color(5, 1, 43));
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    btn.setBackground(new Color(21,25,28));
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    btn.setBackground(new Color(54, 81, 207));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btn.setBackground(new Color(21,25,28));
                }
            });
        }
        tabbedPane.remove(0);
    }
    
    private void customizeTabbedPane() {
        jTabbedPane1.setUI(new BasicTabbedPaneUI() {
            @Override
            protected void installDefaults() {
                super.installDefaults();
                tabAreaInsets.right = 0;
            }

            @Override
            protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
                super.paintTabBackground(g, tabPlacement, tabIndex, x, y, w, h, isSelected);

                // Puedes personalizar el fondo de las pestañas aquí
                g.setColor(new Color(50, 81, 207));
                g.fillRect(x, y, w, h);
            }

            @Override
            protected void paintText(Graphics g, int tabPlacement, Font font, FontMetrics metrics, int tabIndex, String title, Rectangle textRect, boolean isSelected) {
                g.setColor(Color.WHITE);
                super.paintText(g, tabPlacement, font, metrics, tabIndex, title, textRect, isSelected);
            }
        });
    }
    
    private void openFile() {
    JFileChooser fileChooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");
    fileChooser.setFileFilter(filter);

    int result = fileChooser.showOpenDialog(this);

    if (result == JFileChooser.APPROVE_OPTION) {
        try {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            String fileContent = readFile(filePath);

            JTextArea textArea = new JTextArea();
            textArea.setText(fileContent);

            JScrollPane scrollPane = new JScrollPane(textArea);

            String tabTitle = fileChooser.getSelectedFile().getName();
            tabbedPane.addTab(tabTitle, scrollPane);
            int newIndex = tabbedPane.getTabCount() - 1;
            tabbedPane.setSelectedIndex(newIndex);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

private String readFile(String filePath) throws IOException {
    StringBuilder content = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
    }
    return content.toString();
}
        
    private void addNewTab(String tabTitle) {
    JTextArea textArea = new JTextArea();
    textArea.setFont(new Font("Corbel", Font.PLAIN, 14));
    textArea.setForeground(Color.WHITE);
    textArea.setBackground(new Color(51, 51, 51));

    JScrollPane scrollPane = new JScrollPane(textArea);
    scrollPane.setBorder(null);

    tabbedPane.addTab(tabTitle, scrollPane);
    int newIndex = tabbedPane.getTabCount() - 1;
    tabbedPane.setSelectedIndex(newIndex);
}
    
    private void saveFile() {
    JFileChooser fileChooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");
    fileChooser.setFileFilter(filter);

    int result = fileChooser.showSaveDialog(this);

    if (result == JFileChooser.APPROVE_OPTION) {
        try {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            if (!filePath.toLowerCase().endsWith(".txt")) {
                filePath += ".txt";
            }

            JTextArea currentTextArea = getCurrentTextArea();
            String contentToSave = currentTextArea.getText();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write(contentToSave);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

private JTextArea getCurrentTextArea() {
    int selectedIndex = tabbedPane.getSelectedIndex();
    JScrollPane selectedScrollPane = (JScrollPane) tabbedPane.getComponentAt(selectedIndex);
    return (JTextArea) selectedScrollPane.getViewport().getView();
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlRoot = new javax.swing.JPanel();
        pnlSide = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnEjecutar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        pnlCenter = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtConsola = new javax.swing.JTextArea();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlRoot.setLayout(new java.awt.BorderLayout());

        pnlSide.setBackground(new java.awt.Color(21, 25, 28));
        pnlSide.setPreferredSize(new java.awt.Dimension(140, 0));
        pnlSide.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 7));

        jPanel1.setBackground(new java.awt.Color(21, 25, 28));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 120));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-jaguar-negro-64.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pnlSide.add(jPanel1);

        btnEjecutar.setBackground(new java.awt.Color(34, 40, 44));
        btnEjecutar.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        btnEjecutar.setForeground(new java.awt.Color(153, 153, 153));
        btnEjecutar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-play-40.png"))); // NOI18N
        btnEjecutar.setText("Ejecutar");
        btnEjecutar.setPreferredSize(new java.awt.Dimension(135, 47));
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });
        pnlSide.add(btnEjecutar);

        btnNuevo.setBackground(new java.awt.Color(34, 40, 44));
        btnNuevo.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(153, 153, 153));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-agregar-archivo-40_1.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setPreferredSize(new java.awt.Dimension(135, 47));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        pnlSide.add(btnNuevo);

        btnAbrir.setBackground(new java.awt.Color(34, 40, 44));
        btnAbrir.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        btnAbrir.setForeground(new java.awt.Color(153, 153, 153));
        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-abrir-archivo-bajo-cursor-40.png"))); // NOI18N
        btnAbrir.setText("Abrir");
        btnAbrir.setPreferredSize(new java.awt.Dimension(135, 47));
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        pnlSide.add(btnAbrir);

        btnGuardar.setBackground(new java.awt.Color(34, 40, 44));
        btnGuardar.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(153, 153, 153));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-guardar-40.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setPreferredSize(new java.awt.Dimension(135, 47));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        pnlSide.add(btnGuardar);

        btnReportes.setBackground(new java.awt.Color(34, 40, 44));
        btnReportes.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        btnReportes.setForeground(new java.awt.Color(153, 153, 153));
        btnReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-reporte-de-negocios-40 (1).png"))); // NOI18N
        btnReportes.setText("Reportes");
        btnReportes.setPreferredSize(new java.awt.Dimension(135, 47));
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });
        pnlSide.add(btnReportes);

        btnSalir.setBackground(new java.awt.Color(34, 40, 44));
        btnSalir.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(153, 153, 153));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-cancelar-40.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setPreferredSize(new java.awt.Dimension(135, 47));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        pnlSide.add(btnSalir);

        pnlRoot.add(pnlSide, java.awt.BorderLayout.WEST);

        pnlCenter.setBackground(new java.awt.Color(24, 40, 44));

        jTabbedPane1.setBackground(new java.awt.Color(51, 51, 51));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));

        jScrollBar1.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(322, 322, 322)
                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab1", jPanel2);

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel3.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-código-fuente-30.png"))); // NOI18N
        jLabel3.setText("Entrada");

        jLabel4.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-gráfico-de-barras-40.png"))); // NOI18N
        jLabel4.setText("Gráficas");

        jLabel5.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-consola-30.png"))); // NOI18N
        jLabel5.setText("Consola");

        txtConsola.setBackground(new java.awt.Color(51, 51, 51));
        txtConsola.setColumns(20);
        txtConsola.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        txtConsola.setForeground(new java.awt.Color(255, 255, 255));
        txtConsola.setRows(5);
        txtConsola.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        jScrollPane2.setViewportView(txtConsola);

        btnAnterior.setBackground(new java.awt.Color(34, 40, 44));
        btnAnterior.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        btnAnterior.setForeground(new java.awt.Color(153, 153, 153));
        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-anterior-35.png"))); // NOI18N
        btnAnterior.setPreferredSize(new java.awt.Dimension(135, 47));

        btnSiguiente.setBackground(new java.awt.Color(34, 40, 44));
        btnSiguiente.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 14)); // NOI18N
        btnSiguiente.setForeground(new java.awt.Color(153, 153, 153));
        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-siguiente-35.png"))); // NOI18N
        btnSiguiente.setPreferredSize(new java.awt.Dimension(135, 47));

        javax.swing.GroupLayout pnlCenterLayout = new javax.swing.GroupLayout(pnlCenter);
        pnlCenter.setLayout(pnlCenterLayout);
        pnlCenterLayout.setHorizontalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(94, 94, 94)
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCenterLayout.createSequentialGroup()
                                    .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnSiguiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        pnlCenterLayout.setVerticalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel5))
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pnlRoot.add(pnlCenter, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlRoot, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        openFile();
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        addNewTab("Nuevo Archivo " + tabCounter++);
        txtConsola.setText("");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (jTabbedPane1.getTabCount() > 0) {
        saveFile();
    } else {
        JOptionPane.showMessageDialog(this, "No hay pestañas abiertas para guardar.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
    
    if (result == JOptionPane.YES_OPTION) {
        System.exit(0);
    }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed

        

        JTextArea currentTextArea = getCurrentTextArea();
        
        if (currentTextArea != null) {
            txtConsola.setText("");
            String texto = currentTextArea.getText();

            String resultado = analizar(texto);

            txtConsola.append(resultado);
        } else {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún JTextArea.");
        }
        
    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        
        StringBuilder htmlTable = new StringBuilder();
        htmlTable.append("<!DOCTYPE html>\n");
        htmlTable.append("<html>\n");
        htmlTable.append("<head>\n");
        htmlTable.append("<title>Tokens</title>\n");
        htmlTable.append("<style>\n");
        htmlTable.append("table {\n");
        htmlTable.append("  border-collapse: collapse;\n");
        htmlTable.append("  width: 100%;\n");
        htmlTable.append("}\n");
        htmlTable.append("th, td {\n");
        htmlTable.append("  border: 1px solid black;\n");
        htmlTable.append("  padding: 8px;\n");
        htmlTable.append("  text-align: left;\n");
        htmlTable.append("}\n");
        htmlTable.append("th {\n");
        htmlTable.append("  background-color: #f2f2f2;\n");
        htmlTable.append("}\n");
        htmlTable.append("</style>\n");
        htmlTable.append("</head>\n");
        htmlTable.append("<body>\n");
        htmlTable.append("<table>\n");
        htmlTable.append("<tr><th>#</th><th>Token</th><th>Linea</th><th>Columna</th><th>Tipo</th></tr>\n");

        int tokenCount = 1; // Inicializamos el contador de tokens

        for (codigo.Token token : codigo.Lexer.tokens) {
            htmlTable.append("<tr><td>");
            htmlTable.append(tokenCount); // Agregamos el número de token
            htmlTable.append("</td><td>");
            htmlTable.append(token.type);
            htmlTable.append("</td><td>");
            htmlTable.append(token.line);
            htmlTable.append("</td><td>");
            htmlTable.append(token.column);
            htmlTable.append("</td><td>");
            htmlTable.append(token.name);
            htmlTable.append("</td></tr>\n");
            tokenCount++; // Incrementamos el contador de tokens
        }
        htmlTable.append("</table>\n");
        htmlTable.append("</body>\n");
        htmlTable.append("</html>\n");

        generateHTMLReport(htmlTable.toString());
    }//GEN-LAST:event_btnReportesActionPerformed

    public static String analizar(String entrada) {
        try {
            codigo.Lexer lexer = new codigo.Lexer(new StringReader(entrada)); 
            codigo.Parser parser = new codigo.Parser(lexer);
            parser.parse();
            
            return codigo.Parser.resultado;
        } catch (Exception e) {
            System.out.println("Error fatal en compilación de entrada.");
            System.out.println(e);
            return "Error: " + e.getMessage();
        } 
    }
    
    private void limpiarConsola(){
        txtConsola.setText("");
    }
    
    private void generateHTMLReport(String htmlContent) {
    String filename = "tokens.html";
    try (PrintWriter out = new PrintWriter(filename)) {
        out.println(htmlContent);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

    URI fileURI = new File(filename).toURI();

    try {
        Desktop.getDesktop().browse(fileURI);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlRoot;
    private javax.swing.JPanel pnlSide;
    private javax.swing.JTextArea txtConsola;
    // End of variables declaration//GEN-END:variables
}
