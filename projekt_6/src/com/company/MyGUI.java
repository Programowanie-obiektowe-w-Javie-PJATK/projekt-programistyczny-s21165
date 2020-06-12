package com.company;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyGUI extends JFrame {


    private JTextField Out;
    private JTextField In;
    private JPanel rootPanel;
    private JButton Agn;
    private JButton Afin;
    private JButton Mors;
    private JTabbedPane tabbedPane1;
    private JButton Cezar;
    private JButton fromFileButton;
    private StringBuilder sb = new StringBuilder();
    private JButton saveButton;
    private JRadioButton afinicznyRadioButton;
    private JRadioButton cezarRadioButton;
    private JRadioButton morsRadioButton1;
    private JTextField ValueA;
    private JTextField ValueB;
    private JTextField ile;
    ButtonGroup group = new ButtonGroup();
    boolean DecriptMorsdecode = morsRadioButton1.isSelected();
    boolean DecriptCezardecode = cezarRadioButton.isSelected();
    boolean DecriptAfidecode = afinicznyRadioButton.isSelected();
    private String SaveLocation = "E:\\Decrypted.txt";




    public MyGUI() {
        add(rootPanel);
        setTitle("Kodziarka");
        setSize(600, 500);

        group.add(morsRadioButton1);
        group.add(afinicznyRadioButton);
        group.add(cezarRadioButton);                // dzięki grupie można tylko jeden na raz zasnaczyć

        Out.setEditable(false);                     // blokada wpisywania w okienku wyświetlającym odpowiedzi




        Agn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = In.getText();
                if (In.getText().equals("")) {
                    Out.setText("wprowadź wartość którą chcesz\n zamienić do okienka u góry");

                } if(morsRadioButton1.isSelected()) {
                    try {

                        com.company.MorsTranslate MorsTranslate = new com.company.MorsTranslate();
                        com.company.Counter counter = new com.company.Counter();

                        String answer= MorsTranslate.Mors(input,false);
                        String answer1= counter.licznik(answer);

                        Out.setText(answer);
                        ile.setText(answer1);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }


                }if (cezarRadioButton.isSelected()) {
                    com.company.CaesarCipher Cezar = new com.company.CaesarCipher();
                    com.company.Counter counter = new com.company.Counter();

                    String answer= Cezar.Cezar(input,false);
                    String answer1= counter.licznik(answer);


                    Out.setText(answer);
                    ile.setText(answer1);

                }

                if(afinicznyRadioButton.isSelected()) {

                    String aText = ValueA.getText();
                    int a = Integer.parseInt(aText);

                    String bText = ValueB.getText();
                    int b = Integer.parseInt(bText);

                    com.company.Counter counter = new com.company.Counter();
                    com.company.Afi Afi = new com.company.Afi();
                    String answer1= Afi.AfiTranlate(input,false,a,b );

                    Out.setText(answer1);


                }



            }
        });

        Mors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = In.getText();
                if (In.getText().equals("")) {
                    Out.setText("wprowadź wartość którą chcesz\n zamienić do okienka u góry");
                    return;
                } else {


                    try {
                        com.company.MorsTranslate MorsTranslate = new com.company.MorsTranslate();
                        String answer= MorsTranslate.Mors(input,true);

                        Out.setText(answer);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });





        Afin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = In.getText();
                if (In.getText().equals("")) {
                    Out.setText("wprowadź wartość którą chcesz\n zamienić do okienka u góry");

                }else {

                    String aText = ValueA.getText();
                    int a = Integer.parseInt(aText);

                    String bText = ValueB.getText();
                    int b = Integer.parseInt(bText);


                    com.company.Afi Afi = new com.company.Afi();
                    String answer1= Afi.AfiTranlate(input,true,a,b );
                    Out.setText(answer1);

                }
            }
        });


        Cezar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = In.getText();
                if (In.getText().equals("")) {
                    Out.setText("wprowadź wartość którą chcesz\n zamienić do okienka u góry");

                }else {
                    com.company.CaesarCipher Cezar = new com.company.CaesarCipher();
                    String answer1= Cezar.Cezar(input,true);
                    Out.setText(answer1);

                }
            }
        });

        fromFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                                                                    // nie pokazanę na zajęciach :)
                JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
                jfc.setFileFilter(filter);
                int returnValue = jfc.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = jfc.getSelectedFile();
                    try {
                        Scanner InputFromFile = new Scanner(selectedFile);
                        while(InputFromFile.hasNextLine()){
                            sb.append(InputFromFile.nextLine());


                        }

                        In.setText(String.valueOf(sb));
                        System.out.print(sb);
                        InputFromFile.close();

                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }

                }
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileWriter fileWriter = new FileWriter(SaveLocation);
                    Out.write(fileWriter);
                    fileWriter.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }


            }

        });

    }
}
