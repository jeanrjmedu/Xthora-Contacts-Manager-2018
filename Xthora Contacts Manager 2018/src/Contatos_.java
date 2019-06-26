

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.net.URL;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 5701600
 */
public class Contatos_ extends javax.swing.JFrame {

    Database_contatos db;
  
    
    public Contatos_() throws Exception {
        DefaultTableModel model = new DefaultTableModel();
        
        initComponents();
        
        this.setIconImage(new ImageIcon(getClass().getResource("icol.png")).getImage());
        
        try {
            db = new Database_contatos();
           db.initDados();
        } catch (Exception ex) {
            System.out.println("Não");
            lix.setVisible(true);
            lix.setResizable(false);
            //codigo do botao esta dentro do codigo do lix

        }

        CampoNome.setText("Nome");
        CampoTelefone.setText("Telefone");
        CampoCelular.setText("Celular");
         CampoEndereco.setText("Endereço");
        //setResizable(false);

        SetaTabela (model);
        Tabela.setModel(model);
        Tabela.setRowSelectionAllowed(true);
        Tabela.setColumnSelectionAllowed(false);
        
       
       SeletorButs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

            CampoNome1.setText((String) model.getValueAt(Tabela.getSelectedRow(), 0));
            CampoTelefone1.setText((String) model.getValueAt(Tabela.getSelectedRow(), 1));
            CampoCelular1.setText((String) model.getValueAt(Tabela.getSelectedRow(), 2));
            CampoEndereco1.setText((String) model.getValueAt(Tabela.getSelectedRow(), 3));

                } catch (Exception ex) {
                    Logger.getLogger(Contatos_.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        AdicRow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    AdicionarRow(model, CampoNome.getText(), CampoTelefone.getText(), CampoCelular.getText(), CampoEndereco.getText());

                } catch (Exception ex) {
                    Logger.getLogger(Contatos_.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        EditRow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    db.EditTabela(Tabela.getSelectedRow(), CampoNome1.getText(), CampoTelefone1.getText(), CampoCelular1.getText(), CampoEndereco1.getText() );
                    System.out.println(Tabela.getRowCount());
                   
                    limpa(model);
                    db.initDados();
                    LoadRowsDatabase(model);

                } catch (Exception ex) {
                    Logger.getLogger(Contatos_.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        Sobre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SobrePOP.setResizable(false);
                SobrePOP.setVisible(true);
            }}
        );
        Remover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    RemoveRow(model, 0);
                } catch (SQLException ex) {
                    Logger.getLogger(Contatos_.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

   public void limpa (DefaultTableModel model)
   {
        while ( Tabela.getRowCount()>0)
       {
            model.removeRow(0);
       }
   }
    public void SetaTabela (DefaultTableModel model) throws SQLException
       {
        model.addColumn("Nome");
        model.addColumn("Telefone");
        model.addColumn("Celular");
        model.addColumn("Endereço");

        LoadRowsDatabase (model);
       }
    
    public void LoadRowsDatabase(DefaultTableModel model) throws SQLException {
        for (int a = 0; a < db.rowQtd(); a++) {
            Vector row = new Vector();
            row.add(db.lnomes[a]);
            row.add(db.ltelefones[a]);
            row.add(db.lcelulares[a]);
            row.add(db.lenderecos[a]);
            model.addRow(row);
            // System.out.println(db.lnomes[a]);
        }
    }

    public void AdicionarRow(DefaultTableModel model, String Nome, String Telefone, String Celular, String Endereco) throws Exception {
        Vector row = new Vector();
        row.add(Nome);
        row.add(Telefone);
        row.add(Celular);
        row.add(Endereco);
        model.addRow(row);
        db.addTabela(Nome, Telefone, Celular, Endereco);
        CampoNome.setText("Nome");
        CampoTelefone.setText("Telefone");
    }

    public void RemoveRow(DefaultTableModel model, int Local) throws SQLException {
        //String a = (String) model.getValueAt(Tabela.getSelectedRow(), 1);

        db.remTabela(Tabela.getSelectedRow());

        model.removeRow(Tabela.getSelectedRow());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lix = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        SAIR = new javax.swing.JButton();
        SobrePOP = new javax.swing.JDialog();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        Tubar = new javax.swing.JTabbedPane();
        AdicionarJ = new javax.swing.JPanel();
        CampoNome = new javax.swing.JTextField();
        CampoTelefone = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CampoCelular = new javax.swing.JTextField();
        CampoEndereco = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        AdicRow = new javax.swing.JButton();
        EditorJ = new javax.swing.JPanel();
        CampoNome1 = new javax.swing.JTextField();
        CampoTelefone1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        CampoCelular1 = new javax.swing.JTextField();
        CampoEndereco1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        SeletorButs = new javax.swing.JButton();
        EditRow = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        RemoveJ = new javax.swing.JPanel();
        Remover = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Sobre = new javax.swing.JButton();

        lix.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        lix.setTitle("Erro");
        lix.setMinimumSize(new java.awt.Dimension(230, 153));
        lix.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        lix.setResizable(false);

        jLabel6.setText("NÂO FOI POSSIVEL SE CONECTAR.");

        jLabel8.setText("TENTE NOVAMENTE MAIS TARDE.");

        SAIR.setText("OK");
        SAIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SAIRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lixLayout = new javax.swing.GroupLayout(lix.getContentPane());
        lix.getContentPane().setLayout(lixLayout);
        lixLayout.setHorizontalGroup(
            lixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lixLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(lixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lixLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SAIR)
                .addGap(89, 89, 89))
        );
        lixLayout.setVerticalGroup(
            lixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lixLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(SAIR)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        SAIR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("ffa");
                System.exit(0);

            }
        });

        SobrePOP.setTitle("Sobre");
        SobrePOP.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SobrePOP.setIconImage(null);
        SobrePOP.setMinimumSize(new java.awt.Dimension(319, 170));
        SobrePOP.setResizable(false);
        SobrePOP.getContentPane().setLayout(null);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalabout.png"))); // NOI18N
        jLabel11.setAlignmentY(0.0F);
        jLabel11.setIconTextGap(0);
        SobrePOP.getContentPane().add(jLabel11);
        jLabel11.setBounds(0, 0, 323, 87);

        jLabel9.setText("© 2018 Jean Ricardo Jaques Moraes. ");
        SobrePOP.getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 110, 184, 14);

        jLabel10.setText("Xthora Contacts Manager 2018");
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel10.setIconTextGap(0);
        SobrePOP.getContentPane().add(jLabel10);
        jLabel10.setBounds(10, 90, 150, 14);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Xthora Contacts Manager");
        setBackground(new java.awt.Color(214, 163, 81));
        setForeground(java.awt.Color.gray);
        setIconImages(null);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final.png"))); // NOI18N
        jLabel7.setText(" ");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel7.setAlignmentY(0.0F);
        jLabel7.setIconTextGap(0);
        jLabel7.setPreferredSize(new java.awt.Dimension(741, 100));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jLabel7, gridBagConstraints);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.BorderLayout(5, 5));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Contatos");
        jPanel3.add(jLabel1, java.awt.BorderLayout.NORTH);

        jScrollPane1.setMinimumSize(new java.awt.Dimension(500, 23));

        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Tabela);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        Tubar.setPreferredSize(new java.awt.Dimension(200, 423));

        CampoNome.setText(" ");
        CampoNome.setMinimumSize(new java.awt.Dimension(6, 40));
        CampoNome.setPreferredSize(new java.awt.Dimension(123, 20));

        CampoTelefone.setText(" ");
        CampoTelefone.setPreferredSize(new java.awt.Dimension(88, 20));

        jLabel2.setText("Nome");

        jLabel5.setText("Telefone");

        CampoCelular.setText(" ");

        CampoEndereco.setText(" ");
        CampoEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoEnderecoActionPerformed(evt);
            }
        });

        jLabel12.setText("Celular");

        jLabel13.setText("Endereço");

        AdicRow.setText("Adicionar");

        javax.swing.GroupLayout AdicionarJLayout = new javax.swing.GroupLayout(AdicionarJ);
        AdicionarJ.setLayout(AdicionarJLayout);
        AdicionarJLayout.setHorizontalGroup(
            AdicionarJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdicionarJLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(AdicionarJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdicionarJLayout.createSequentialGroup()
                        .addGroup(AdicionarJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AdicionarJLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdicionarJLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AdicionarJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CampoCelular, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(CampoEndereco)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdicionarJLayout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addGroup(AdicionarJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdicionarJLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CampoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdicionarJLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CampoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(AdicionarJLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(AdicRow)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AdicionarJLayout.setVerticalGroup(
            AdicionarJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdicionarJLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AdicionarJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CampoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AdicionarJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CampoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AdicionarJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CampoCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AdicionarJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CampoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
                .addComponent(AdicRow, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Tubar.addTab("Adicionar", AdicionarJ);

        EditorJ.setPreferredSize(new java.awt.Dimension(200, 423));

        CampoNome1.setText(" ");
        CampoNome1.setMaximumSize(new java.awt.Dimension(123, 20));
        CampoNome1.setMinimumSize(new java.awt.Dimension(123, 20));
        CampoNome1.setPreferredSize(new java.awt.Dimension(123, 20));

        CampoTelefone1.setText(" ");
        CampoTelefone1.setMaximumSize(new java.awt.Dimension(123, 20));
        CampoTelefone1.setMinimumSize(new java.awt.Dimension(123, 20));
        CampoTelefone1.setPreferredSize(new java.awt.Dimension(125, 20));

        jLabel14.setText("Nome");

        jLabel15.setText("Telefone");

        CampoCelular1.setText(" ");
        CampoCelular1.setMaximumSize(new java.awt.Dimension(123, 20));
        CampoCelular1.setMinimumSize(new java.awt.Dimension(123, 20));
        CampoCelular1.setPreferredSize(new java.awt.Dimension(123, 20));

        CampoEndereco1.setText(" ");
        CampoEndereco1.setMaximumSize(new java.awt.Dimension(123, 20));
        CampoEndereco1.setMinimumSize(new java.awt.Dimension(123, 20));
        CampoEndereco1.setPreferredSize(new java.awt.Dimension(123, 20));
        CampoEndereco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoEndereco1ActionPerformed(evt);
            }
        });

        jLabel16.setText("Celular");

        jLabel17.setText("Endereço");

        SeletorButs.setText("Selecionar");

        EditRow.setText("Editar");

        jLabel18.setText("1)Selecione item da tabela");

        jLabel19.setText("2)Pressione \"Selecionar\"");

        jLabel20.setText("3)Altere os dados nos campos abaixo");

        jLabel21.setText("4)Confirme clicando \"Editar\"");

        javax.swing.GroupLayout EditorJLayout = new javax.swing.GroupLayout(EditorJ);
        EditorJ.setLayout(EditorJLayout);
        EditorJLayout.setHorizontalGroup(
            EditorJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditorJLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(EditorJLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel19))
            .addGroup(EditorJLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel20))
            .addGroup(EditorJLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel21))
            .addGroup(EditorJLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel15)
                .addGap(8, 8, 8)
                .addComponent(CampoTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(EditorJLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel16)
                .addGap(10, 10, 10)
                .addComponent(CampoCelular1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(EditorJLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel17)
                .addGap(10, 10, 10)
                .addComponent(CampoEndereco1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(EditorJLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel14)
                .addGap(10, 10, 10)
                .addGroup(EditorJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SeletorButs)
                    .addComponent(CampoNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(EditorJLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(EditRow, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        EditorJLayout.setVerticalGroup(
            EditorJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditorJLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel18)
                .addGap(6, 6, 6)
                .addComponent(jLabel19)
                .addGap(6, 6, 6)
                .addComponent(jLabel20)
                .addGap(2, 2, 2)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SeletorButs)
                .addGap(13, 13, 13)
                .addGroup(EditorJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EditorJLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel14))
                    .addComponent(CampoNome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(EditorJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EditorJLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel15))
                    .addComponent(CampoTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(EditorJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EditorJLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel16))
                    .addComponent(CampoCelular1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(EditorJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EditorJLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel17))
                    .addComponent(CampoEndereco1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addComponent(EditRow)
                .addContainerGap())
        );

        Tubar.addTab("Editar", EditorJ);

        Remover.setText("Remover");
        Remover.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        Remover.setPreferredSize(new java.awt.Dimension(35, 33));

        jLabel3.setText("1)Selecione item da tabela");

        jLabel4.setText("2)Pressione \"Remover\"");

        javax.swing.GroupLayout RemoveJLayout = new javax.swing.GroupLayout(RemoveJ);
        RemoveJ.setLayout(RemoveJLayout);
        RemoveJLayout.setHorizontalGroup(
            RemoveJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RemoveJLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(RemoveJLayout.createSequentialGroup()
                .addGroup(RemoveJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RemoveJLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(Remover, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RemoveJLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        RemoveJLayout.setVerticalGroup(
            RemoveJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RemoveJLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Remover, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Tubar.addTab("Remover", RemoveJ);

        jPanel3.add(Tubar, java.awt.BorderLayout.EAST);

        Sobre.setText("Sobre");
        Sobre.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Sobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SobreActionPerformed(evt);
            }
        });
        jPanel3.add(Sobre, java.awt.BorderLayout.SOUTH);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jPanel3, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SobreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SobreActionPerformed

    private void SAIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SAIRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SAIRActionPerformed

    private void CampoEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoEnderecoActionPerformed

    private void CampoEndereco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoEndereco1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoEndereco1ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Contatos_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Contatos_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Contatos_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Contatos_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

           
        /* Create and display the form */
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    
                    new Contatos_().setVisible(true);
                  
                } catch (Exception ex) {
                    Logger.getLogger(Contatos_.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicRow;
    private javax.swing.JPanel AdicionarJ;
    private javax.swing.JTextField CampoCelular;
    private javax.swing.JTextField CampoCelular1;
    private javax.swing.JTextField CampoEndereco;
    private javax.swing.JTextField CampoEndereco1;
    private javax.swing.JTextField CampoNome;
    private javax.swing.JTextField CampoNome1;
    private javax.swing.JTextField CampoTelefone;
    private javax.swing.JTextField CampoTelefone1;
    private javax.swing.JButton EditRow;
    private javax.swing.JPanel EditorJ;
    private javax.swing.JPanel RemoveJ;
    private javax.swing.JButton Remover;
    private javax.swing.JButton SAIR;
    private javax.swing.JButton SeletorButs;
    private javax.swing.JButton Sobre;
    private javax.swing.JDialog SobrePOP;
    private javax.swing.JTable Tabela;
    private javax.swing.JTabbedPane Tubar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JDialog lix;
    // End of variables declaration//GEN-END:variables
}
