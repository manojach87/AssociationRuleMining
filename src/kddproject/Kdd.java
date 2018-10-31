/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kddproject;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author Manoj Acharya
 */
public class Kdd extends javax.swing.JFrame {

    JFileChooser fileChooser;
    static Scanner input;
    public static String attributeFilePath="";
    public static String dataFilePath="";
    public static String currentFilePath="";

    //File f = new File("temp.txt");
    public static String outFilePath="."; 
    //System.out.println("f.getAbsolutePath() = " + f.getAbsolutePath());
    
    public static List<String> attributeNames = new ArrayList<String>();
    public static List<String> stableAttributes = new ArrayList<String>();
    public static List<String> flexibleAttributes = new ArrayList<String>();
    public static Kdd kdd;
    public static String decisionAtribute,decisionFrom,decisionTo, delimiter;
    public boolean hasHeader = false;
    public static String userStableAttribute;
    public static int minimum_Confidence=0,minimum_Support=0;
    public static StringBuilder stringBuilder = new StringBuilder();
    public static ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>(); 

    public static boolean outputFileWriteStarted = false;
    public static boolean outputLogFileWriteStarted = false;
    public static boolean writeOutputFile = false;
    public static String stringToWrite = ""; 

    static Map<String, HashSet<String>> dataMap = new HashMap<String, HashSet<String>>();
    static Map<String, HashSet<String>> attributeValuesToAtribute = new HashMap<String, HashSet<String>>();
    static Map<String, HashSet<String>> distinctAttributeValues = new HashMap<String, HashSet<String>>();
    static Map<HashSet<String>, HashSet<String>> attributeValues = new HashMap<HashSet<String>, HashSet<String>>();
    static Map<HashSet<String>, HashSet<String>> reducedAttributeValues = new HashMap<HashSet<String>, HashSet<String>>();
    static Map<String, HashSet<String>> decisionValues = new HashMap<String, HashSet<String>>();
    static Map<ArrayList<String>, HashSet<String>> markedValues = new HashMap<ArrayList<String>, HashSet<String>>();
    public static Map<ArrayList<String>,String> certainRules = new HashMap<ArrayList<String>,String>();
    public static Map<ArrayList<String>,HashSet<String>> possibleRules = new HashMap<ArrayList<String>,HashSet<String>>();

    public void initVariables(){
        attributeFilePath   ="";
        dataFilePath        ="";
        attributeNames      = new ArrayList<String>();
        stableAttributes    = new ArrayList<String>();
        flexibleAttributes  = new ArrayList<String>();
        decisionAtribute    = "";
        decisionFrom        = "";
        decisionTo          = "";
        delimiter           = "";
        hasHeader           = false;
        userStableAttribute = "";
        minimum_Confidence  =0;
        minimum_Support     =0;
        stringBuilder       = new StringBuilder();
        data                = new ArrayList<ArrayList<String>>(); 


        distinctAttributeValues = new HashMap<String, HashSet<String>>();
        attributeValues         = new HashMap<HashSet<String>, HashSet<String>>();
        reducedAttributeValues  = new HashMap<HashSet<String>, HashSet<String>>();
        decisionValues          = new HashMap<String, HashSet<String>>();
        markedValues            = new HashMap<ArrayList<String>, HashSet<String>>();
        certainRules            = new HashMap<ArrayList<String>,String>();
        possibleRules           = new HashMap<ArrayList<String>,HashSet<String>>();
        dataFilePathTextField   .setText("");
        attrFilePathTextField   .setText("");
        attrValues              .setText("");

    }
    /**
     * Creates new form NewJFrame
     */
    public Kdd() {
    	trace(Thread.currentThread().getStackTrace());
        initComponents();
        for( int i=0; i<midPanel.getComponents().length; i++)
        {
            midPanel.getComponents()[i].setEnabled(false);
        }
        for( int i=0; i<lowerPanel.getComponents().length; i++)
        {
            lowerPanel.getComponents()[i].setEnabled(false);
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings({ "unchecked", "deprecation" })
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        jPanel3 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        jLabelLoading = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lowerPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListStableAttributesAvailable = new javax.swing.JList<>();
        label11 = new java.awt.Label();
        stableAttrs = new java.awt.TextField();
        label10 = new java.awt.Label();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        outFileBrowseBtn1 = new javax.swing.JButton();
        midPanel = new javax.swing.JPanel();
        label2 = new java.awt.Label();
        confidenceTxtField = new java.awt.TextField();
        label6 = new java.awt.Label();
        label9 = new java.awt.Label();
        label5 = new java.awt.Label();
        supportTxtField = new java.awt.TextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        label7 = new java.awt.Label();
        label8 = new java.awt.Label();
        attrValues = new java.awt.Label();
        decisionValFromJCB = new javax.swing.JComboBox<>();
        decisionValToJCB = new javax.swing.JComboBox<>();
        topPanel = new java.awt.Panel();
        attrFileLabel = new java.awt.Label();
        delimiterComboBox = new javax.swing.JComboBox<>();
        attrFilePathTextField = new javax.swing.JTextField();
        attrFileBrowseBtn = new javax.swing.JButton();
        label4 = new java.awt.Label();
        dataFilePathTextField = new javax.swing.JTextField();
        dataBrowseBtn = new javax.swing.JButton();
        submitBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        delimiterOtherText = new javax.swing.JTextField();
        hasHeaderCheckbox = new javax.swing.JCheckBox();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kdd Project - Group 1: Action Rules ");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabelLoading.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabelLoading.setForeground(new java.awt.Color(0, 204, 0));
        jLabelLoading.setText("Loading...");
        jLabelLoading.setToolTipText("");

        lowerPanel.setToolTipText("Click Ctrl to select multiple Attributes");
        lowerPanel.setEnabled(false);

        jListStableAttributesAvailable.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jListStableAttributesAvailable.setToolTipText("Click Ctrl to select multiple Attributes");
        jListStableAttributesAvailable.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListStableAttributesAvailableValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListStableAttributesAvailable);

        label11.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        label11.setForeground(java.awt.Color.black);
        label11.setText("Comma separated list of Selected Stable Attribute(s)");

        stableAttrs.setEditable(false);
        stableAttrs.setFont(new java.awt.Font("Comic Sans MS", 3, 12)); // NOI18N
        stableAttrs.addTextListener(new java.awt.event.TextListener() {
            public void textValueChanged(java.awt.event.TextEvent evt) {
                stableAttrsTextValueChanged(evt);
            }
        });

        label10.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        label10.setForeground(java.awt.Color.black);
        label10.setText("Select Stable Attributes:");

        jButton1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jButton1.setText("Generate Action Rules");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jButton3.setText("Reset");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextField1.setText(".");
        jTextField1.setMaximumSize(new java.awt.Dimension(6, 21));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Output File Location: ");

        outFileBrowseBtn1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        outFileBrowseBtn1.setLabel("...");
        outFileBrowseBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outFileBrowseBtn1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout lowerPanelLayout = new org.jdesktop.layout.GroupLayout(lowerPanel);
        lowerPanel.setLayout(lowerPanelLayout);
        lowerPanelLayout.setHorizontalGroup(
            lowerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(lowerPanelLayout.createSequentialGroup()
                .add(lowerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lowerPanelLayout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(lowerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(lowerPanelLayout.createSequentialGroup()
                                .add(jButton3)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jButton1))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, lowerPanelLayout.createSequentialGroup()
                                .add(lowerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(label10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 119, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(24, 24, 24)
                                .add(lowerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, lowerPanelLayout.createSequentialGroup()
                                        .add(jTextField1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                        .add(outFileBrowseBtn1))
                                    .add(stableAttrs, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, label11, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)))))
                    .add(lowerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel2)))
                .addContainerGap())
        );
        lowerPanelLayout.setVerticalGroup(
            lowerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(lowerPanelLayout.createSequentialGroup()
                .add(9, 9, 9)
                .add(lowerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(label10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(label11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lowerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(stableAttrs, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lowerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2)
                    .add(outFileBrowseBtn1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(1, 1, 1)
                .add(lowerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton3)
                    .add(jButton1))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        label2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        label2.setForeground(java.awt.Color.black);
        label2.setText("Available Attributes:");

        confidenceTxtField.setFont(new java.awt.Font("Comic Sans MS", 3, 12)); // NOI18N
        confidenceTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confidenceTxtFieldActionPerformed(evt);
            }
        });
        confidenceTxtField.addTextListener(new java.awt.event.TextListener() {
            public void textValueChanged(java.awt.event.TextEvent evt) {
                confidenceTxtFieldTextValueChanged(evt);
            }
        });

        label6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        label6.setForeground(java.awt.Color.black);
        label6.setMaximumSize(new java.awt.Dimension(99, 18));
        label6.setText("Min Confidence (%)");

        label9.setAlignment(java.awt.Label.RIGHT);
        label9.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        label9.setForeground(java.awt.Color.black);
        label9.setText("To");

        label5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        label5.setForeground(java.awt.Color.black);
        label5.setMaximumSize(new java.awt.Dimension(64, 18));
        label5.setText("Min Support:");

        supportTxtField.setFont(new java.awt.Font("Comic Sans MS", 3, 12)); // NOI18N
        supportTxtField.addTextListener(new java.awt.event.TextListener() {
            public void textValueChanged(java.awt.event.TextEvent evt) {
                supportTxtFieldTextValueChanged(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 153, 153));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("Get Attributes");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        label7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        label7.setForeground(java.awt.Color.black);
        label7.setText("Decision Attribute");

        label8.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        label8.setForeground(java.awt.Color.black);
        label8.setText("Decision Value From");

        attrValues.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        attrValues.setForeground(java.awt.Color.black);

        decisionValFromJCB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        decisionValFromJCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "I-1", "I-2", "I-3", "I-4" }));
        decisionValFromJCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decisionValFromJCBActionPerformed(evt);
            }
        });

        decisionValToJCB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        decisionValToJCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "I-1", "I-2", "I-3", "I-4" }));
        decisionValToJCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decisionValToJCBActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout midPanelLayout = new org.jdesktop.layout.GroupLayout(midPanel);
        midPanel.setLayout(midPanelLayout);
        midPanelLayout.setHorizontalGroup(
            midPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(midPanelLayout.createSequentialGroup()
                .add(1, 1, 1)
                .add(midPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, midPanelLayout.createSequentialGroup()
                        .add(label2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 122, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 115, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(midPanelLayout.createSequentialGroup()
                        .add(midPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(label5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(label6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(midPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(attrValues, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 125, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(midPanelLayout.createSequentialGroup()
                                .add(confidenceTxtField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(label8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(midPanelLayout.createSequentialGroup()
                                .add(supportTxtField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(label7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(midPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jComboBox1, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(midPanelLayout.createSequentialGroup()
                                .add(decisionValFromJCB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(2, 2, 2)
                                .add(label9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(decisionValToJCB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        midPanelLayout.setVerticalGroup(
            midPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(midPanelLayout.createSequentialGroup()
                .add(3, 3, 3)
                .add(midPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, label7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, supportTxtField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, label5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(2, 2, 2)
                .add(midPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, decisionValToJCB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, label9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, decisionValFromJCB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, label8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, confidenceTxtField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, label6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(midPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jButton2)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, attrValues, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, label2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        attrFileLabel.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        attrFileLabel.setForeground(java.awt.Color.black);
        attrFileLabel.setText("Choose Attribute File");

        delimiterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ",", "\\t", "|", "Other" }));
        delimiterComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delimiterComboBoxActionPerformed(evt);
            }
        });

        attrFilePathTextField.setEditable(false);
        attrFilePathTextField.setMaximumSize(new java.awt.Dimension(6, 20));
        attrFilePathTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attrFilePathTextFieldActionPerformed(evt);
            }
        });

        attrFileBrowseBtn.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        attrFileBrowseBtn.setLabel("...");
        attrFileBrowseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attrFileBrowseBtnActionPerformed(evt);
            }
        });

        label4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        label4.setForeground(java.awt.Color.black);
        label4.setText("Choose Data File ");

        dataFilePathTextField.setEditable(false);
        dataFilePathTextField.setMaximumSize(new java.awt.Dimension(6, 20));

        dataBrowseBtn.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        dataBrowseBtn.setText("...");
        dataBrowseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataBrowseBtnActionPerformed(evt);
            }
        });

        submitBtn.setFont(submitBtn.getFont().deriveFont(submitBtn.getFont().getStyle() | java.awt.Font.BOLD));
        submitBtn.setText("Load");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel1.setText("Delimiter");

        delimiterOtherText.setText("Other");

        hasHeaderCheckbox.setText("Data File contains headers.");
        hasHeaderCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hasHeaderCheckboxActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout topPanelLayout = new org.jdesktop.layout.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(topPanelLayout.createSequentialGroup()
                .add(topPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(topPanelLayout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(topPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(topPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                .add(attrFileLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(label4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .add(topPanelLayout.createSequentialGroup()
                                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(delimiterComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(18, 18, 18)
                        .add(topPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(topPanelLayout.createSequentialGroup()
                                .add(topPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(dataFilePathTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(attrFilePathTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(topPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(attrFileBrowseBtn)
                                    .add(dataBrowseBtn, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .add(topPanelLayout.createSequentialGroup()
                                .add(delimiterOtherText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(hasHeaderCheckbox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 206, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(0, 0, Short.MAX_VALUE))))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, topPanelLayout.createSequentialGroup()
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(submitBtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 116, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(topPanelLayout.createSequentialGroup()
                .add(10, 10, 10)
                .add(topPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, topPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(dataFilePathTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(dataBrowseBtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, label4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(10, 10, 10)
                .add(topPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(delimiterComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(hasHeaderCheckbox)
                    .add(delimiterOtherText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(topPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, topPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(attrFilePathTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(attrFileBrowseBtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, attrFileLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(submitBtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jSeparator1)
                    .add(jSeparator2)
                    .add(lowerPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jLabelLoading)
                        .add(202, 202, 202)
                        .add(jSeparator3))
                    .add(midPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(topPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 512, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 14, Short.MAX_VALUE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(filler1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(filler1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(topPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 133, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, 0)
                        .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(midPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jSeparator2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(lowerPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 129, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel3Layout.createSequentialGroup()
                                .add(jSeparator3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(25, 25, 25))
                            .add(jPanel3Layout.createSequentialGroup()
                                .add(jLabelLoading)
                                .add(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        jLabelLoading.getAccessibleContext().setAccessibleName("jLabelLoading");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 554, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    private void attrFileBrowseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attrFileBrowseBtnActionPerformed
        // TODO add your handling code here
        fileChooser = new JFileChooser(currentFilePath);
        int returnValue = fileChooser.showOpenDialog(Kdd.this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
          File selectedFile = fileChooser.getSelectedFile();
          attributeFilePath = selectedFile.getAbsolutePath();
          currentFilePath = selectedFile.getParent();
          attrFilePathTextField.setText(attributeFilePath);
          //readAttributes();
          kdd.setVisible(true);
    }              
        
    }//GEN-LAST:event_attrFileBrowseBtnActionPerformed

    private void dataBrowseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataBrowseBtnActionPerformed
        // TODO add your handling code here:


    	
    	delimiterComboBox.setSelectedIndex(0);
         fileChooser = new JFileChooser(currentFilePath);
        int returnValue = fileChooser.showOpenDialog(Kdd.this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
          File selectedFile = fileChooser.getSelectedFile();
          dataFilePath = selectedFile.getAbsolutePath();
          currentFilePath = selectedFile.getParent();
          dataFilePathTextField.setText(dataFilePath);
          //readData();
          //readData(dataFilePath,delimiter,hasHeader);
          
          kdd.setVisible(true);
    }            
    }//GEN-LAST:event_dataBrowseBtnActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        // TODO add your handling code here:
        //Read stable,flexible and decision attributes
        //label2.setText("Available Attributes are:" +" "+attributeNames.toString());
        

        
        boolean filesExist = false;
        if(hasHeader){
            filesExist = checkFile(dataFilePath) ;
            printMessage("Data File                : "+dataFilePath);
        }
        else {
            filesExist = checkFile(attributeFilePath) && checkFile(dataFilePath) ;
            printMessage("Data File                : "+dataFilePath);
            printMessage("AttributeFilePath        : "+attributeFilePath);
        }
        if (filesExist)
        {
            for( int i=0; i<midPanel.getComponents().length; i++)
            {
                midPanel.getComponents()[i].setEnabled(true);
            }
            printMessage("Reading Data File Now..");
            printMessage("Delimiter                : "+delimiter);
            printMessage("Data File Has Header?    : "+hasHeader);
            readData(dataFilePath,delimiter,hasHeader);
            attrValues.setText(attributeNames.toString());
            attributeNames.forEach((attr) -> {
                jComboBox1.addItem(attr);
            });
        } else{
            jOptionPane1.showMessageDialog(null,"Have you chosen your files correctly?","File Not Found",JOptionPane.ERROR_MESSAGE);
        }
        //setStableAttributes(attributeNames);
        //Find Certain and Possible rules
		
    }//GEN-LAST:event_submitBtnActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        decisionAtribute = jComboBox1.getSelectedItem().toString();
        //label8.setText("Decision("+decisionAtribute+") Value From");
        //System.out.println(distinctAttributeValues.get(decisionAtribute).toArray());

        Set<String> x = distinctAttributeValues.get(decisionAtribute);
        decisionValFromJCB.setModel(new javax.swing.DefaultComboBoxModel<>(x.toArray(new String[x.size()])));
        decisionValToJCB.setModel(new javax.swing.DefaultComboBoxModel<>(x.toArray(new String[x.size()])));
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        decisionFrom = decisionValFromJCB.getSelectedItem().toString();
        decisionTo = decisionValToJCB.getSelectedItem().toString();
        
        if(decisionFrom.equals(decisionTo)){
            jOptionPane1.showMessageDialog(null,"Decision From and Decision To Cannot Be the same?","Action Rule Decisions",JOptionPane.ERROR_MESSAGE);
        }
        else{
            //System.out.println(decisionFrom);
            printMessage("Minimum Support          : "+minimum_Support);
            printMessage("Minimum Confidence       : "+minimum_Confidence);
            
            printMessage("Decision Attribute       : "+decisionAtribute);
            printMessage("Decision From            : "+decisionFrom);
            printMessage("Decision To              : "+decisionTo);
            
            
            //printMessage("Stable Attributes : "+stableAttrs.getText());
            
            for( int i=0; i<lowerPanel.getComponents().length; i++)
            {
                lowerPanel.getComponents()[i].setEnabled(true);
            }
            setDecisionAttribute(attributeNames); 
            String[] flexArray = new String[flexibleAttributes.size()];
            for(int i=0;i<flexibleAttributes.size();i++){
                flexArray[i] = flexibleAttributes.get(i);
            }
                jListStableAttributesAvailable.setListData(flexArray);
            jScrollPane1.setViewportView(jListStableAttributesAvailable);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        

        setStableAttributes(attributeNames);
        
        //System.out.println(jListStableAttributesAvailable.getSelectedValuesList());
        
        //System.out.println("Min Confidence = "+minimum_Confidence+", Min Support = "+minimum_Support);
        printMessage("Min Confidence = "+minimum_Confidence+", Min Support = "+minimum_Support);
        findRules();
        //generateActionRules();
        generateActionRulesTest();
        ArrayList<String> arr = new ArrayList<>();
        arr.add("A1");
//        arr.add("F2");
        //System.out.println(findLineNumInFile(arr)); // To get line Number of the occurrence of a set of attributes
        //loops();
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void stableAttrsTextValueChanged(java.awt.event.TextEvent evt) {//GEN-FIRST:event_stableAttrsTextValueChanged
        // TODO add your handling code here:
        userStableAttribute = stableAttrs.getText();
    }//GEN-LAST:event_stableAttrsTextValueChanged

    private void supportTxtFieldTextValueChanged(java.awt.event.TextEvent evt) {//GEN-FIRST:event_supportTxtFieldTextValueChanged
        // TODO add your handling code here:
        minimum_Support = Integer.parseInt(supportTxtField.getText());
    }//GEN-LAST:event_supportTxtFieldTextValueChanged

    private void confidenceTxtFieldTextValueChanged(java.awt.event.TextEvent evt) {//GEN-FIRST:event_confidenceTxtFieldTextValueChanged
        // TODO add your handling code here:
        minimum_Confidence = Integer.parseInt(confidenceTxtField.getText());
    }//GEN-LAST:event_confidenceTxtFieldTextValueChanged

    private void confidenceTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confidenceTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confidenceTxtFieldActionPerformed

    private void attrFilePathTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attrFilePathTextFieldActionPerformed
        // TODO add your handling code here:
        attrFileBrowseBtnActionPerformed(evt);
    }//GEN-LAST:event_attrFilePathTextFieldActionPerformed

    private void delimiterComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delimiterComboBoxActionPerformed
        // TODO add your handling code here:
        String selection = (String) delimiterComboBox.getSelectedItem();
        if(!"Other".equals(selection))
            delimiter = selection;
        else delimiter = delimiterOtherText.getText();
        //System.out.println(delimiter);
    }//GEN-LAST:event_delimiterComboBoxActionPerformed

    private void hasHeaderCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hasHeaderCheckboxActionPerformed
        // TODO add your handling code here:
        printMessage("Data File has headers?  " + hasHeaderCheckbox.isSelected());
        hasHeader=hasHeaderCheckbox.isSelected();
        attrFileBrowseBtn    .setEnabled(!hasHeader);
        attrFileLabel        .setEnabled(!hasHeader);
        attrFilePathTextField.setEnabled(!hasHeader);
        
    }//GEN-LAST:event_hasHeaderCheckboxActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        initVariables();
        //new Kdd();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void decisionValFromJCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decisionValFromJCBActionPerformed
        // TODO add your handling code here:
        decisionFrom = decisionValFromJCB.getSelectedItem().toString();
        //printMessage("Decision From : "+decisionFrom);
    }//GEN-LAST:event_decisionValFromJCBActionPerformed

    private void decisionValToJCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decisionValToJCBActionPerformed
        // TODO add your handling code here:
        decisionTo = decisionValToJCB.getSelectedItem().toString();
        //printMessage("Decision From : "+decisionTo);
    }//GEN-LAST:event_decisionValToJCBActionPerformed

    private void jListStableAttributesAvailableValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListStableAttributesAvailableValueChanged
        // TODO add your handling code here:
        List<String> s = jListStableAttributesAvailable.getSelectedValuesList();
        //userStableAttribute = s.toString().replaceAll("[{}]","");
        //System.out.println(userStableAttribute);
        //System.out.println(stableAttrs);
        stableAttrs.setText(s.toString().replace("[","").replace("]","").replace(" ",""));
        //printMessage("Stable Attributes : "+stableAttrs.getText());
    }//GEN-LAST:event_jListStableAttributesAvailableValueChanged

    private void outFileBrowseBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outFileBrowseBtn1ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser(); 
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Choose Output File Location");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //
        // disable the "All files" option.
        //
        chooser.setAcceptAllFileFilterUsed(false);
        //    
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
          jTextField1.setText(chooser.getSelectedFile().toString());
          outFilePath = jTextField1.getText();
        }        
    }//GEN-LAST:event_outFileBrowseBtn1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    private final JButton open = new JButton("Open");
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (
//                ClassNotFoundException | 
//                InstantiationException | 
//                IllegalAccessException |
//                javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Kdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
              } catch (ClassNotFoundException e) {
                e.printStackTrace();
              } catch (InstantiationException e) {
                e.printStackTrace();
              } catch (IllegalAccessException e) {
                e.printStackTrace();
              } catch (UnsupportedLookAndFeelException e) {
                e.printStackTrace();
              }

              //SwingUtilities.updateComponentTreeUI(frame);
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            kdd = new Kdd();
            kdd.setVisible(true);
            kdd.getContentPane().setBackground(Color.WHITE);
            kdd.jLabelLoading.setVisible(false);
            printMessage(new Date());
        });
    }
        
	private static void readAttributes(String fileName, String delim) {
		//trace(Thread.currentThread().getStackTrace());
		try {
                        //System.out.println(fileName);
			Scanner headerScan = new Scanner(new File(fileName));
			//input.hasNext();
			//attributeNames.clear();
			if(headerScan.hasNextLine()) {
				//String h = headerScan.nextLine();
				//System.out.println(h);
				String[] splitted = (headerScan.nextLine()).split(delim); // Read First Line and split by delimiter
				//String[] splitted = h.split(delim); // Read First Line and split by delimiter
				
                attributeNames.addAll(Arrays.asList(splitted)); // Add to AttributeNames
                        //System.out.println(attributeNames);
			}
			headerScan.close();
		} catch (FileNotFoundException e) {
			printMessage("File Not Found");
			e.printStackTrace();
		} 
//		catch (NoSuchElementException e) {
//			printMessage("File Found But Empty Header! Please Update the headers and try Again.");
//			//e.printStackTrace();
//		}
		
	}

    private static void readData(String fileName, String delim, boolean hasHeader ) {
                
		try {
			//trace(Thread.currentThread().getStackTrace());
                    //System.out.println(fileName);
			input = new Scanner(new File(fileName));
			int lineNo = 0;
			if (hasHeader==true) {
				if(input.hasNextLine()){
					input.nextLine(); // Read Header and do nothing
					readAttributes(fileName, delim);
				}
			}
			else {
				String headerFileName = getHeaderFile(hasHeader);
				System.out.println(headerFileName);
				readAttributes(headerFileName, delim);
			}
			while(input.hasNextLine()){
				String[] lineData = input.nextLine().split(delim);
				String key;
				lineNo++;
				ArrayList<String> tempList = new ArrayList<>();
				HashSet<String> set;
				
				for (int i=0;i<lineData.length;i++) {
					String currentAttributeValue = lineData[i];
					String attributeName = attributeNames.get(i);
					
					//int ii = getSetID(attributeName,currentAttributeValue);
					key = attributeName + currentAttributeValue;
					//key = attributeName + ii;
					//System.out.println(getSetID(attributeName,currentAttributeValue) + ' ' + attributeName + ' ' + currentAttributeValue);
					
					//System.out.println(ii);
					tempList.add(key);

					HashSet<String> mapKey = new HashSet<>();
					mapKey.add(key);
					setMap(attributeValues,lineData[i],mapKey,lineNo);
					
					if (distinctAttributeValues.containsKey(attributeName)) {
						set = distinctAttributeValues.get(attributeName);
						set.add(key);
						
					}else{
						set = new HashSet<>();
					}
					
					set.add(key);
					distinctAttributeValues.put(attributeName, set);
				}
		
				data.add(tempList);
				
			}
                        for(ArrayList<String> dataList: data){
                             printList(dataList);
                        }

			input.close();
			
		} catch (FileNotFoundException e) {
			printMessage("File Not Found");
			e.printStackTrace();
		}
	}
	private static String getHeaderFile(boolean fileHasHeader) {
		trace(Thread.currentThread().getStackTrace());
		if(fileHasHeader)
			return null;
		else
			return attributeFilePath;
	}

    private static void setMap(Map<HashSet<String>, HashSet<String>> values,String string, HashSet<String> key, int lineNo) {

    	// Insert LineNumbers Alongside Values
       	trace(Thread.currentThread().getStackTrace());
		HashSet<String> tempSet;
		
		if (values.containsKey(key)) {
			tempSet = values.get(key);						
		}else{
			tempSet = new HashSet<>();
		}
		
		tempSet.add("x"+lineNo);
		values.put(key, tempSet);
	}
        //Printing String, List and Map
	public static void printMessage(Object content){
		trace(Thread.currentThread().getStackTrace());
		System.out.println(content);
        if(kdd.jTextArea1.getText().length()>4000)
            kdd.jTextArea1.setText("");
        kdd.jTextArea1.append(content.toString()+"\n");
	}
    public static void printList(List<String> list){
    	trace(Thread.currentThread().getStackTrace());
		Iterator iterate = list.iterator();
		
//		while(iterate.hasNext()){
//			printMessage(iterate.next().toString());
//		}
	}
	
	private static void printAttributeMap(Map<HashSet<String>, HashSet<String>> values) {
		trace(Thread.currentThread().getStackTrace());
		for(Map.Entry<HashSet<String>, HashSet<String>> set : values.entrySet()){
			
                        if(!(set.getValue().isEmpty())){
                            printMessage(set.getKey().toString() + " = " + set.getValue());
//                            stringBuilder.append(set.getKey().toString())
//                                         .append(" = ")
//                                         .append(set.getValue())
//                                         .append(System.lineSeparator());
                            writeFileBuffered(set.getKey().toString());
                            writeFileBuffered(" = ");
                            writeFileBuffered(set.getValue());
                            writeFileBuffered(System.lineSeparator());
                        }
		}
	}
	
	private static void printCertainRulesMap(Map<ArrayList<String>, String> value) {
		trace(Thread.currentThread().getStackTrace());
          kdd.jLabelLoading.setText("Generating Certain Rules");
          printMessage("Generating Certain Rules..");

          kdd.jLabelLoading.setVisible(true);
            //printMessage("\nCertain Rules:");
//                stringBuilder.append(System.lineSeparator())
//                             .append("Certain Rules:");

                writeFileBuffered(System.lineSeparator());
                writeFileBuffered("Certain Rules:");
                Iterator iterator = value.entrySet().iterator();
                while(iterator.hasNext()){
                    Map.Entry set = (Map.Entry)iterator.next();
                    	int support = calculateSupportLERS((ArrayList<String>)set.getKey(),(String)set.getValue());
			String confidence = calculateConfidenceLERS((ArrayList<String>)set.getKey(),(String)set.getValue());
                        //System.out.println(minimum_Confidence+" minConfidence "+minimum_Support+" minSupport ");
//                        stringBuilder
//                                    .append(minimum_Confidence)
//                                    .append(" minConfidence ")
//                                    .append(minimum_Support)
//                                    .append(" minSupport ")
//                                    .append(System.lineSeparator());
			if(Integer.parseInt(confidence) >= minimum_Confidence && support >= minimum_Support){
                            printMessage(set.getKey().toString() + " -> " + set.getValue() + "[Support:-" + support + ", Confidence:-" + confidence +"%]");
                            //System.out.println(set.getKey().toString() + " -> " + set.getValue() + "[Support:-" + support + ", Confidence:-" + confidence +"%]");
//                            stringBuilder
//                                    .append(set.getKey().toString())
//                                    .append(" -> ").append(set.getValue())
//                                    .append("[Support:-").append(support)
//                                    .append(", Confidence:-")
//                                    .append(confidence)
//                                    .append("%]")
//                                    .append(System.lineSeparator());

                            writeFileBuffered(set.getKey().toString());
                            writeFileBuffered(" -> ");
                            writeFileBuffered(set.getValue());
                            writeFileBuffered("[Support:-");
                            writeFileBuffered(support);
                            writeFileBuffered(", Confidence:-");
                            writeFileBuffered(confidence);
                            writeFileBuffered("%]");
                            writeFileBuffered(System.lineSeparator());
                            
                        }else{
                        iterator.remove();
                        }
                    
                }
	}
	
	private static void printPossibleRulesMap(Map<ArrayList<String>, HashSet<String>> value) {
		trace(Thread.currentThread().getStackTrace());
		 kdd.jLabelLoading.setText("Generating Possible Rules");
		 printMessage("\nGenerating Possible Rules..");
                 kdd.jLabelLoading.setVisible(true);
		if(!value.isEmpty()){
			//printMessage("\nPossible Rules:");
//                        stringBuilder
//                                    .append(System.lineSeparator())
//                                    .append("Possible Rules:")
//                                    .append(System.lineSeparator());
            writeFileBuffered(System.lineSeparator());
            writeFileBuffered("Possible Rules:");
            writeFileBuffered(System.lineSeparator());
                         Iterator iterator = value.entrySet().iterator();
                          while(iterator.hasNext()){
                            Map.Entry set = (Map.Entry)iterator.next();
                            Iterator<String> setIterator = ((HashSet<String>)set.getValue()).iterator();
                                        while(setIterator.hasNext()){
                                        String possibleValue = setIterator.next();
                                        int support = calculateSupportLERS((ArrayList<String>)set.getKey(),possibleValue);
					String confidence = calculateConfidenceLERS((ArrayList<String>)set.getKey(),possibleValue);
					
                                        if(Integer.parseInt(confidence) >= minimum_Confidence && support >= minimum_Support){
                                        //printMessage(set.getKey().toString() + " -> " + possibleValue + "[Support:-" + support + ", Confidence:-" + confidence +"%]");
                                        System.out.println(set.getKey().toString() + " -> " + possibleValue + "[Support:-" + support + ", Confidence:-" + confidence +"%]");
//                                        stringBuilder.append(set.getKey().toString())
//                                                .append(" -> ").append(possibleValue)
//                                                .append("[Support:-").append(support)
//                                                .append(", Confidence:-")
//                                                .append(confidence)
//                                                .append("%]")
//                                                .append(System.lineSeparator());
                                        writeFileBuffered(set.getKey().toString());
                                        writeFileBuffered(" -> ");writeFileBuffered(possibleValue);
                                        writeFileBuffered("[Support:-");writeFileBuffered(support);
                                        writeFileBuffered(", Confidence:-");
                                        writeFileBuffered(confidence);
                                        writeFileBuffered("%]");
                                        writeFileBuffered(System.lineSeparator());
                                        
                                        
                                        }else{
                                           setIterator.remove();
                                        }
                          }
                          }
		}
	}

	private static int findLERSSupport(ArrayList<String> tempList) {
		trace(Thread.currentThread().getStackTrace());
		int count = 0;
		
		for(ArrayList<String> data : data){	
			if(data.containsAll(tempList))
				count++;
		}
		
		return count;
	}
	// Get x1 x2 x3 etc - ie location of a attribute value
	private static ArrayList<String> findLineNumInFile(ArrayList<String> list) {
		trace(Thread.currentThread().getStackTrace());
		ArrayList<String> index = new ArrayList<>();
		int count = 0;
		
		for(ArrayList<String> data : data){
			count++;
			if(data.containsAll(list)) {
				index.add("x"+count);
			}
		}
		return index;
	}

	private static String gMarked(ArrayList<String> attrRowNums, Map<ArrayList<String>,ArrayList<String>> decisionAttrToRowMap) {
		String finalDecision = ""; 
		for(ArrayList<String> decision: decisionAttrToRowMap.keySet()){
			
			if(decisionAttrToRowMap.get(decision).containsAll(attrRowNums) == true) {
				finalDecision = decision.get(0);
				break;
			}
		}
		return finalDecision;
	}
	
	private static boolean isMarked(ArrayList<String> attrRowNums, Map<ArrayList<String>,ArrayList<String>> decisionAttrToRowMap) {
		// Returns 
		// true  for marked values
		// false for unmarked values
		boolean finalDecision = false; 
		for(ArrayList<String> decision: decisionAttrToRowMap.keySet()){
			finalDecision = decisionAttrToRowMap.get(decision).containsAll(attrRowNums); 
			if(finalDecision == true) {
				break;
			}
		}
		return finalDecision;
	}

	private static ArrayList<String> getMarked(ArrayList<String> attrRowNums, Map<ArrayList<String>,ArrayList<String>> decisionAttrToRowMap) {
		//Returns Decision Attribute value for Marked Values
		ArrayList<String> finalDecision = new ArrayList<>(); 
		for(ArrayList<String> decision: decisionAttrToRowMap.keySet()){
			if(decisionAttrToRowMap.get(decision).containsAll(attrRowNums) == true) {
				finalDecision = decision;
				break;
			}
		}
		return finalDecision;
	}
    // Loop Through Attributes
	private static void loops() {
		System.out.println(distinctAttributeValues);
		Map<ArrayList<String>,ArrayList<String>> attrToRowMap = new HashMap<>();
		Map<ArrayList<String>,ArrayList<String>> decisionAttrToRowMap = new HashMap<>();

		Map<ArrayList<String>,ArrayList<String>> attrToRowMapMarked = new HashMap<>();
		Map<ArrayList<String>,ArrayList<String>> attrToRowMapUnmarked = new HashMap<>();
		
		for(HashSet<String> attrList : distinctAttributeValues.values()) {
			for(int i =0; i < attrList.size();i++)
			{
				ArrayList<String> arr = new ArrayList<>();
				String attrVal = attrList.toArray()[i].toString();
				arr.add(attrList.toArray()[i].toString());
				
				if(getAttributeName(attrVal)==decisionAtribute) {
					decisionAttrToRowMap.put(arr, findLineNumInFile(arr));
					// For Ex: {[C1]=[x2, x3], [C2]=[x1, x4, x5, x6]}
				}
				else {
					attrToRowMap.put(arr, findLineNumInFile(arr)); 
					// For Ex. {[A2]=[x1, x5], [G1]=[x2, x4], [F1]=[x1, x4], [G2]=[x3, x5], [F2]=[x2, x3, x5, x6], [G3]=[x1, x6], [A1]=[x2, x3, x4, x6]}
				}
			}
		}
		ArrayList<String> nullArrayList = new ArrayList<>();
		nullArrayList.add("N/A");
		for(ArrayList<String> attrVal: attrToRowMap.keySet()){
			//System.out.println(isMarked(attrToRowMap.get(attrVal),decisionAttrToRowMap));
			
			//System.out.println(getMarked(attrToRowMap.get(attrVal),decisionAttrToRowMap));
			if(isMarked(attrToRowMap.get(attrVal),decisionAttrToRowMap)==true){
				attrToRowMapMarked.put(attrVal, getMarked(attrToRowMap.get(attrVal),decisionAttrToRowMap));
			}
			// Create Unmarked List
			else {
				attrToRowMapUnmarked.put(attrVal, nullArrayList);
			}			
			//System.out.println(decisionAttrToRowMap.get(decision).containsAll(attrRowNums));
		}
		System.out.println(attrToRowMap.toString());
		System.out.println(decisionAttrToRowMap.toString());
        printMessage("Decision Attribute       : "+decisionAtribute);
        printMessage("Decision From            : "+decisionFrom);
        printMessage("Decision To              : "+decisionTo);
        System.out.println("Marked Items");
        System.out.println(attrToRowMapMarked);
	} 
	private static HashSet<HashSet<String>> createAttributeValueList(int n, HashSet<String> cols, HashSet<HashSet<String>> attrVals ) {	
		HashSet<HashSet<String>> product = new HashSet<>();
		cols.remove(decisionAtribute);
		int i = cols.size();
		if(n<i) {
			//HashSet<HashSet<String>> crossProduct = 
			product = createAttributeValueList(n+1,cols,attrVals);
		}
		return product;		
	}
	
	private static HashSet<HashSet<String>> multiply(HashSet<HashSet<String>> set1, HashSet<HashSet<String>> set2) {
		HashSet<HashSet<String>> set = new HashSet<HashSet<String>>();
		for(int i=0; i<set1.size(); i++ ) {
			HashSet<String> smallerSet = new HashSet<>();
			for(int j=0; i<set2.size(); i++ ) {
				smallerSet.add(set1.toArray()[i].toString());
				smallerSet.add(set2.toArray()[j].toString());
			}
			set.add(smallerSet);
		}
		return set;
	}
	
	private static Set<Set<String>> setMultiply(Set<Set<String>> set1, Set<Set<String>> set2)
	{
		Set<Set<String>> x = new HashSet<>();
		
		return cartesianProduct(set1, set2);
	}
	
	public static HashSet<Set<String>> cartesianProduct(Set<?>... sets) {
	    if (sets.length < 2)
	        throw new IllegalArgumentException(
	                "Can't have a product of fewer than two sets (got " +
	                sets.length + ")");

	    return _cartesianProduct(0, sets);
	}

	private static HashSet<Set<String>> _cartesianProduct(int index, Set<?>... sets) {
		HashSet<Set<String>> ret = new HashSet<Set<String>>();
	    if (index == sets.length) {
	        ret.add(new HashSet<String>());
	    } else {
	        for (Object obj : sets[index]) {
	            for (Set<String> set : _cartesianProduct(index+1, sets)) {
	                set.add(obj.toString());
	                ret.add(set);
	            }
	        }
	    }
	    return ret;
	}
	
	
	private static int calculateSupportLERS(ArrayList<String> key, String value) {
		trace(Thread.currentThread().getStackTrace());
		ArrayList<String> tempList = new ArrayList<>();
		
		for(String val : key){
			tempList.add(val);
		}
		
		if(!value.isEmpty())
			tempList.add(value);
	
		return findLERSSupport(tempList);
		
	}


	private static String calculateConfidenceLERS(ArrayList<String> key,
			String value) {
		trace(Thread.currentThread().getStackTrace());
		int num = calculateSupportLERS(key, value);
		int den = calculateSupportLERS(key, "");
                int confidence = 0;
                if(den!=0){
                 confidence = (num * 100)/den;   
                }
		
		return String.valueOf(confidence);
	}
        
    private static void findRules() {
    	trace(Thread.currentThread().getStackTrace());
		int loopCount = 0;
		
		while(!attributeValues.isEmpty()){
			printMessage("\nLoop " + (++loopCount) +":");
//            stringBuilder
//                    .append(System.lineSeparator())
//                    .append("Loop ")
//                    .append(loopCount).append(":");

			writeFileBuffered(System.lineSeparator());
			writeFileBuffered("Loop ");
			writeFileBuffered(loopCount);
			
			printMessage("--------------------------");
//            stringBuilder.append("--------------------------");
			writeFileBuffered("--------------------------");
			printAttributeMap(attributeValues);
			
			for (Map.Entry<HashSet<String>, HashSet<String>> set : attributeValues.entrySet()) {
				ArrayList<String> setKey = new ArrayList<>();
				setKey.addAll(set.getKey());
				
				if (set.getValue().isEmpty()) {
					continue;
				}else{
					for(Map.Entry<String, HashSet<String>> decisionSet : decisionValues.entrySet()){
						if(decisionSet.getValue().containsAll(set.getValue())){
							certainRules.put(setKey, decisionSet.getKey());
							markedValues.put(setKey, set.getValue());
							break;
						}
					}
				}
				
				if(!markedValues.containsKey(setKey)){
					HashSet<String> possibleRulesSet = new HashSet<>();
					for(Map.Entry<String, HashSet<String>> decisionSet : decisionValues.entrySet()){
						possibleRulesSet.add(decisionSet.getKey());
					}
					possibleRules.put(setKey, possibleRulesSet);
				}
				
			}
			
			removeMarkedValues();
			
			printCertainRulesMap(certainRules);
			printPossibleRulesMap(possibleRules);
            try {
                writeFile(stringBuilder.toString());
            } catch (IOException ex) {
                Logger.getLogger(Kdd.class.getName()).log(Level.SEVERE, null, ex);
            }
			combinePossibleRules();
		}
          //       generateActionRules();
	}

	private static void removeMarkedValues() {

		trace(Thread.currentThread().getStackTrace());
		for(Map.Entry<ArrayList<String>, HashSet<String>> markedSet : markedValues.entrySet()){
			attributeValues.remove(new HashSet<>(markedSet.getKey()));
		}
		
	}
	private static String getAttributeName(String value) {
		String attributeName="N/A";
		for(String str:distinctAttributeValues.keySet()){
			for(String str1:distinctAttributeValues.get(str)) {
				if(str1==value) {
					attributeName = str; 
				}
			}
		}
		return attributeName;
	}
	private static void combinePossibleRules() {
		trace(Thread.currentThread().getStackTrace());
		Set<ArrayList<String>> keySet = possibleRules.keySet();
		ArrayList<ArrayList<String>> keyList = new ArrayList<>();
		keyList.addAll(keySet);
//		System.out.print("keySet : ");
//		System.out.println(keySet);
//		System.out.print("keyList");
//		System.out.println(keyList);
		
		for(int i = 0;i<possibleRules.size();i++){
			for(int j = (i+1);j<possibleRules.size();j++){
				HashSet<String> combinedKeys = new HashSet<>(keyList.get(i));
				combinedKeys.addAll(new HashSet<>(keyList.get(j)));
				//System.out.print("combinedKeys : ");
				//System.out.println(combinedKeys);
				
				if(!checkSameGroup(combinedKeys)){
					//combineAttributeValues(combinedKeys);
					combineAttributeValuesNew(combinedKeys);
				}
			}
		}
//
//		System.out.println("After----------");
//		System.out.print("keySet : ");
//		System.out.println(keySet);
//		System.out.print("keyList");
//		System.out.println(keyList);
		
		possibleRules.clear();
		
		removeRedundantValues();
		clearAttributeValues();
              		
	}

	private static boolean checkSameGroup(HashSet<String> combinedKeys) {
		trace(Thread.currentThread().getStackTrace());
		for(Map.Entry<String, HashSet<String>> singleAttribute : distinctAttributeValues.entrySet()){
			if(singleAttribute.getValue().containsAll(combinedKeys)){
				return true;
			}
		}
		
		return false;
	}
	private static boolean ensureDifferentAttributes(HashSet<String> combinedKeys) {
		boolean ret = true;
		Iterator<String> itr = combinedKeys.iterator(); 
		for(int i = 0; i<combinedKeys.size(); i++){
			if(itr.hasNext()) {
				String str = itr.next();
				Iterator<String> itr1 = combinedKeys.iterator();
				for(int j = 0; j<combinedKeys.size(); j++){
					if(itr1.hasNext()) {
						String str1 = itr1.next();
						if(getAttributeName(str) == getAttributeName(str1) && str!=str1) {
							//System.out.println("Comparison :" + getAttributeName(str)+ " " + getAttributeName(str));
							//System.out.println(str+" "+str1);
							ret=false;
							break;
						}
						
					}
				}
				
			}
		}
//		System.out.print("Processed combinedKeys");
//		System.out.println(combinedKeys);
		return ret;
	}
	private static void combineAttributeValuesNew(HashSet<String> combinedKeys) {
		trace(Thread.currentThread().getStackTrace());
		HashSet<String> combinedValues = new HashSet<>();
			
		for(Map.Entry<HashSet<String>, HashSet<String>> attributeValue : attributeValues.entrySet()){
			if(combinedKeys.containsAll(attributeValue.getKey())){
				if(combinedValues.isEmpty()){
					combinedValues.addAll(attributeValue.getValue());
				}else{
					combinedValues.retainAll(attributeValue.getValue());
				}
			}
		}
		

//		System.out.print("combinedValues : ");
//		System.out.println(combinedValues);
		if(ensureDifferentAttributes(combinedKeys)==true) {
			reducedAttributeValues.put(combinedKeys, combinedValues);
		}
//		else {
//			reducedAttributeValues.put(combinedKeys, null);
//		}
//		System.out.print("reducedAttributeValues : ");
//		System.out.println(reducedAttributeValues);
	
	}
	
	private static void combineAttributeValues(HashSet<String> combinedKeys) {
		trace(Thread.currentThread().getStackTrace());
		HashSet<String> combinedValues = new HashSet<>();
			
		for(Map.Entry<HashSet<String>, HashSet<String>> attributeValue : attributeValues.entrySet()){
			if(combinedKeys.containsAll(attributeValue.getKey())){
				if(combinedValues.isEmpty()){
					combinedValues.addAll(attributeValue.getValue());
				}else{
					combinedValues.retainAll(attributeValue.getValue());
				}
			}
		}
		

//		System.out.print("combinedValues : ");
//		System.out.println(combinedValues);
		
		reducedAttributeValues.put(combinedKeys, combinedValues);

//		System.out.print("reducedAttributeValues : ");
//		System.out.println(reducedAttributeValues);
	
	}

	private static void removeRedundantValues() {
		trace(Thread.currentThread().getStackTrace());
		HashSet<String> mark = new HashSet<>();
		
		for(Map.Entry<HashSet<String>, HashSet<String>> reducedAttributeValue : reducedAttributeValues.entrySet()){
			for(Map.Entry<HashSet<String>, HashSet<String>> attributeValue : attributeValues.entrySet()){
				
				if(attributeValue.getValue().containsAll(reducedAttributeValue.getValue()) || reducedAttributeValue.getValue().isEmpty()){
					mark.addAll(reducedAttributeValue.getKey());
				}
			}
		}
		
		reducedAttributeValues.remove(mark);
		
		
	}
	
	private static void clearAttributeValues() {
		trace(Thread.currentThread().getStackTrace());
		 attributeValues.clear();
		 for(Map.Entry<HashSet<String>, HashSet<String>> reducedAttributeValue : reducedAttributeValues.entrySet()){
			 attributeValues.put(reducedAttributeValue.getKey(), reducedAttributeValue.getValue());
		 }
		 reducedAttributeValues.clear();
	}
 //Get Action Rules by decision
 private static Map<ArrayList<String>,String> getCertainRulesByDecision(String decision) {
	 trace(Thread.currentThread().getStackTrace());
	 Map<ArrayList<String>,String> certainRuleByDecision = new HashMap<ArrayList<String>,String>();
	 for(Map.Entry<ArrayList<String>, String> certainRules1 : certainRules.entrySet()){
		 if (certainRules1.getValue().equals(decision)) {
			 certainRuleByDecision.put(certainRules1.getKey(),certainRules1.getValue());
			 //System.err.println(certainRules1);
		 }
		 else continue;
	 }
	 return certainRuleByDecision;
 }
 private static void generateActionRulesTest() {
	 trace(Thread.currentThread().getStackTrace());
	 System.out.println("Generating Action Rules");
     try {
         String rule = "";
         //int loop1Count = 0;
         boolean actionRuleFound = false;

         Map<ArrayList<String>,String> certainRulesByDecisionFrom = getCertainRulesByDecision(decisionFrom);
         Map<ArrayList<String>,String> certainRulesByDecisionTo   = getCertainRulesByDecision(decisionTo  );
         
         //System.err.println("Decision From Action Rules("+decisionFrom+")"); System.err.println(certainRulesByDecisionFrom);
         //System.err.println("Decision To Action Rules("+decisionTo+")");     System.err.println(certainRulesByDecisionTo  );
         
         
         //System.err.println(stableAttributes.toString());
         PrintWriter writer = new PrintWriter( new File(outFilePath,"ActionRules1.txt"), "UTF-8");
         //System.err.println(certainRules);

         //System.err.println(certainRules.entrySet());
         
         //If Both DecisionFrom and DecisionTo are not empty, then proceed, else abort
         if(!(certainRulesByDecisionFrom.isEmpty() || certainRulesByDecisionTo.isEmpty())) {
             //Loop through Certain Rules for DecisionFrom
	         for (Map.Entry<ArrayList<String>, String> oneDecisionFromRule : certainRulesByDecisionFrom.entrySet()) {
	         	//System.err.print("Certain Rule :");
	         	//System.err.println(oneDecisionFromRule);
	         	ArrayList<String> oneDecisionFromRuleKey = oneDecisionFromRule.getKey();
         
            	// Loop through Certain Rules for DecisionTo
             	for (Map.Entry<ArrayList<String>, String> oneDecisonToRule : certainRulesByDecisionTo.entrySet()) {
                     //System.out.println(certainRules2.getKey().equals(certainRules1.getKey()));
                 	//System.err.print("\t\t");
                 	//System.err.println(oneDecisonToRule);
                 	ArrayList<String> oneDecisonToRuleKey = oneDecisonToRule.getKey();
                 	
                 	String primeAttribute = "";
                     
                    //ArrayList<String> checkCertainValues1 = certainRules1.getKey();
                 	//Check if Value is Stable Attribute
                 	//Loop through Rule Attribute Values of Decision From  
                    for (String oneDecisionFromRuleKeyVal : oneDecisionFromRuleKey) {
                    	// Skip if Attribute is a stable attribute
						if (stableAttributes.contains(oneDecisionFromRuleKeyVal)) {
						    continue;
						} else {
						    primeAttribute = checkAttribute(oneDecisionFromRuleKeyVal);
						     
						    //ArrayList<String> checkCertainValues2 = certainRules2.getKey();
						
						    //Loop through Rule Attribute Values of Decision To  
						    for (String oneDecisonToRuleKeyVal : oneDecisonToRuleKey) {
						    	// if attribute from decision to Rules is a stable attribute 
						    	// or if attribute from decision from Rules and attribute from decision to Rules are different
						    	// then create rule from attribute to itself Ex . A2=A2
						    	// else create rule from attributeValue1 in attribute(from) to attributeValeu2 in attribute(to) Ex G3->G3
						        if (stableAttributes.contains(oneDecisonToRuleKeyVal) || !(checkAttribute(oneDecisonToRuleKeyVal).equals(primeAttribute))) {
						            rule = formRule(rule, oneDecisonToRuleKeyVal, oneDecisonToRuleKeyVal);
						        } else if (checkAttribute(oneDecisonToRuleKeyVal).equals(primeAttribute)) {
						            rule = formRule(rule, oneDecisionFromRuleKeyVal, oneDecisonToRuleKeyVal);
						        }
						    }
						}
                    }
                     
                    if (rule.indexOf(primeAttribute) != -1
                             && !primeAttribute.isEmpty()) {
                             writer.println(rule + " ==> " +decisionFrom + "->" + decisionTo);
                             //System.out.println(rule + " ==> " +decisionFrom + "->" + decisionTo);
                             printMessage(rule + " ==> " +decisionFrom + "->" + decisionTo);
                             actionRuleFound = true;
                    }
                    rule = "";
                 
                }	             
	        }
	        if(actionRuleFound == false) {
	        	printMessage("No Action Rule found for Decision from " + decisionFrom + " to " + decisionTo);
	        }
        }
        else {
        	printMessage("No Action Rule found for Decision from " + decisionFrom + " to " + decisionTo);
        }

        writer.close();
    } catch (FileNotFoundException | UnsupportedEncodingException ex) {
    	 
        Logger.getLogger(Kdd.class.getName()).log(Level.SEVERE, null, ex);
    }
    catch(Exception e) {
    	 System.err.println(e.getMessage());
    }
}

 private static void generateActionRules() {
	 trace(Thread.currentThread().getStackTrace());
        try {
            String rule = "";
            //int loop1Count = 0;
            //System.err.println("Decision From Action Rules("+decisionFrom+")");
            //certainRulesByDecisionFrom = getCertainRulesByDecision(decisionFrom);
            

            System.err.println("Decision To Action Rules("+decisionTo+")");
            getCertainRulesByDecision(decisionTo);
            
            System.err.println(stableAttributes.toString());
            PrintWriter writer = new PrintWriter( new File(outFilePath,"ActionRules1.txt"), "UTF-8");
            System.err.println(certainRules);

            //System.err.println(certainRules.entrySet());
            
            //Get all the Certain Rules
            
            for (Map.Entry<ArrayList<String>, String> certainRules1 : certainRules.entrySet()) {
            	//System.err.print("Certain Rule :");
            	//System.err.println(certainRules1);
            	ArrayList<String> checkCertainValues1 = certainRules1.getKey();
                //loop1Count++;
            // Get all Certain Rules that have Decision Value = DecisionFrom (source decision value)
                if (certainRules1.getValue().equals(decisionFrom)) { //
                    //int loop2Count = 0;
            
            // Compare All certain Values with each other

                	for (Map.Entry<ArrayList<String>, String> certainRules2 : certainRules.entrySet()) {
                        //System.out.println(certainRules2.getKey().equals(certainRules1.getKey()));
                    	//System.err.print("\t\t");
                    	//System.err.println(certainRules2);
                    	ArrayList<String> checkCertainValues2 = certainRules2.getKey();
                    	
            // Find Certain Rules that have decision Value = DecisionTo(Target Decision Value) else ignore
                        if ((!certainRules2.getValue().equals(decisionTo))) {
                        	//System.err.println("\t\t\tcontinue");
                            continue;
                        } else {
                            String primeAttribute = "";
                            
                            //ArrayList<String> checkCertainValues1 = certainRules1.getKey();
                            for (String value1 : checkCertainValues1) {
                                
                                if (stableAttributes.contains(value1)) {
                                    continue;
                                } else {
                                    primeAttribute = checkAttribute(value1);
                                    
                                    //ArrayList<String> checkCertainValues2 = certainRules2.getKey();
                                    for (String value2 : checkCertainValues2) {                                        
                                        if (stableAttributes.contains(value2) || !(checkAttribute(value2).equals(primeAttribute))) {
                                            rule = formRule(rule, value2, value2);
                                        } else if (checkAttribute(value2).equals(primeAttribute)) {
                                            rule = formRule(rule, value1, value2);
                                        }
                                        
                                    }
                                }
                            }
                            
                            if (rule.indexOf(primeAttribute) != -1
                                    && !primeAttribute.isEmpty()) {
                                    //writer.println("The first line");
                                    //writer.println("The second line");
                                    writer.println(rule + " ==> " +decisionFrom + "->" + decisionTo);
                                    //System.out.println(rule + " ==> " +decisionFrom + "->" + decisionTo);
                                    printMessage(rule + " ==> " +decisionFrom + "->" + decisionTo);
                            }
                            rule = "";
                        }
                        //loop2Count++;
                    }
                } else {
                    continue;
                }
            }
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(Kdd.class.getName()).log(Level.SEVERE, null, ex);
        }
 }

    private static String checkAttribute(String value1) {
    	trace(Thread.currentThread().getStackTrace());
        for (Map.Entry<String, HashSet<String>> entryValue : distinctAttributeValues.entrySet()) {
            if (entryValue.getValue().contains(value1)) {
                return entryValue.getKey();
            }
        }
        return null;
    }

    private static String formRule(String rule, String value1, String value2) {
    	trace(Thread.currentThread().getStackTrace());
        if (!rule.isEmpty()) {
            rule += "^";
        }

        if (value1.equals(value2)) {
            if (stableAttributes.contains(value2)) {

                rule += "(" + value1 + "=" + value2 + ")";
            } else {
                rule += "(" + value1 + ",->" + value2 + ")";
            }
        } else {

            rule += "(" + value1 + "->" + value2 + ")";
        }

        return rule;
    }

    private  void setStableAttributes(List<String> attributes) {
    	trace(Thread.currentThread().getStackTrace());
        if(userStableAttribute.contains(",")){
            String[] keys = userStableAttribute.split(",");
                for(int i=0;i<keys.length;i++){
                    if(checkValid(attributes,keys[i])){
                    stableAttributes.addAll(distinctAttributeValues.get(keys[i]));
                    attributes.remove(userStableAttribute);
                    }else{
                        printMessage("Invalid Attribute name...\n");
                    }
                }
//                           }
        }else{
            if(checkValid(attributes,userStableAttribute)){
                stableAttributes.addAll(distinctAttributeValues.get(userStableAttribute));
                attributes.remove(userStableAttribute);
            }else{
                    printMessage("Invalid Attribute name...\n");
            }
        }
			
    }

    private static boolean checkValid(List<String> attributes,String userStableAttribute) {
    	trace(Thread.currentThread().getStackTrace());
        return attributes.contains(userStableAttribute);
    }

    private static void setDecisionAttribute(List<String> attributes) {
    	trace(Thread.currentThread().getStackTrace());
        if (checkValid(attributes,decisionAtribute)) {
            attributes.remove(decisionAtribute);
            flexibleAttributes = attributes;

            HashSet<String> decisionValues = distinctAttributeValues.get(decisionAtribute);
            removeDecisionValueFromAttributes(decisionValues);

        }else{
                printMessage("Invalid attrbibute.");
        }
		
    }

    private static void removeDecisionValueFromAttributes(HashSet<String> decisionValues) {
    	trace(Thread.currentThread().getStackTrace());
        for(String value : decisionValues){
            HashSet<String> newHash = new HashSet<>();
            newHash.add(value);
            Kdd.decisionValues.put(value, attributeValues.get(newHash));
            attributeValues.remove(newHash);
        }
    }

    public static void writeFileBuffered(Object outputString) {
    	trace(Thread.currentThread().getStackTrace());

 		stringBuilder.append(outputString.toString());
        //System.out.println(stringBuilder.toString().length());
         if(stringBuilder.toString().length()>10000 || writeOutputFile == true) {
             try {
            	 Path dir      = Paths.get(outFilePath);
            	 Path filePath = dir.resolve("ActionRules.txt");
            	 File file     = new File(filePath.toString());
            	 SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhh24mmss");
            	 String dateString = format.format(new Date());

            	 File renamedfile = new File(filePath.toString()+"."+dateString);
            	 
		         //Path filePath = Paths.get(outFilePath+"/ActionRules.txt");
		         if (!Files.exists(filePath)) {
		             Files.createFile(filePath);
		             outputFileWriteStarted = true;
		         }
		         else if(Files.exists(filePath) && outputFileWriteStarted == false) {
		        	 file.renameTo(renamedfile);
		         }
		         Files.write(filePath, stringBuilder.toString().getBytes(), StandardOpenOption.APPEND);
		         stringBuilder.setLength(0);
            }catch (IOException e) {
            	e.printStackTrace();
            }
         }
    }

    public static void writeFile(String outputString) throws IOException {
    	trace(Thread.currentThread().getStackTrace());
        kdd.jLabelLoading.setText("Writing to File");
        kdd.jLabelLoading.setVisible(true);
       try {
                   File file = new File(outFilePath, "ActionRules.txt");
                   FileWriter fileWriter = new FileWriter(file,outputFileWriteStarted);
                   // Wrapping FileWriter to BufferedWriter to improve the efficiency
                   BufferedWriter outStream = new BufferedWriter(fileWriter);
                   // Writing outputs to file
                   outStream.write(outputString);
                   // Making sure we close the BufferedWriter to avoid memory leaks.
                   outStream.flush();
                   outStream.close();
           } catch (IOException e) {
                   e.printStackTrace();
           }
         kdd.jLabelLoading.setText("Program Completed. Please see output in ActionRules.txt");
         kdd.jLabelLoading.setVisible(true);
   }
    public boolean checkFile(String fileName){
    	trace(Thread.currentThread().getStackTrace());
        File file = new File(fileName);
        //System.out.println(fileName +":"+file.exists());
        //printMessage(fileName +":"+file.exists());
        return (file.exists() && file.isFile());
    }
//    public static void printText(Object message){
//        kdd.jTextArea1.append(message.toString()+"\n");
//        System.out.println(message);
//    }

//    public static void trace(StackTraceElement e[]) {
// 	   boolean doNext = false;
// 	   for (StackTraceElement s : e) {
// 	       if (doNext) {
// 	          //System.err.println(s.getMethodName());
// 	             try {
//
// 	            	 String path = "";
// 	            	 File f = new File("OutFile.txt"); 
// 	            	 path = f.getAbsolutePath();
// 	            	 f = new File(path);
// 	            	 path = f.getParent();
// 	            	 
// 	            	 
// 	            	 if (outFilePath == ".") {
// 	            		 outFilePath = path;            		 
// 	            	 }
// 	            	 Path dir      = Paths.get(outFilePath);
// 	            	 Path filePath = dir.resolve("ActionRules.log.txt");
// 	            	 File file     = new File(filePath.toString());
// 	            	 SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhh24mmss");
// 	            	 String dateString = format.format(new Date());
//
// 	            	 File renamedfile = new File(filePath.toString()+"."+dateString);
//
// 			         if (!Files.exists(filePath)) {
// 			             Files.createFile(filePath);
// 			             outputLogFileWriteStarted = true;
// 			         }
// 			         else if(Files.exists(filePath) && outputLogFileWriteStarted == false) {
// 			        	 file.renameTo(renamedfile);
// 			         }
// 			         Files.write(filePath, (s.getMethodName().toString()+" "+(new Date()).toString()+stringBuilder.toString()+"\n").getBytes(), StandardOpenOption.APPEND);
// 			         
// 	            }catch (IOException ee) {
// 	            	ee.printStackTrace();
// 	            }
// 	          return;
// 	       }
// 	       doNext = s.getMethodName().equals("getStackTrace");
// 	   }
// 	 }
    public static void trace(StackTraceElement e[]) {
  	   boolean doNext = false;
  	   for (StackTraceElement s : e) {
  	       if (doNext) {
  	          //System.err.println(s.getMethodName());
  	          //System.err.println(s.getMethodName().toString()+" "+(new Date()).toString());
  	       }
  	       doNext = s.getMethodName().equals("getStackTrace");
  	   }
  	 }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton attrFileBrowseBtn;
    private java.awt.Label attrFileLabel;
    private javax.swing.JTextField attrFilePathTextField;
    private java.awt.Label attrValues;
    private java.awt.TextField confidenceTxtField;
    private javax.swing.JButton dataBrowseBtn;
    private javax.swing.JTextField dataFilePathTextField;
    private javax.swing.JComboBox<String> decisionValFromJCB;
    private javax.swing.JComboBox<String> decisionValToJCB;
    private javax.swing.JComboBox<String> delimiterComboBox;
    private javax.swing.JTextField delimiterOtherText;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JCheckBox hasHeaderCheckbox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelLoading;
    private javax.swing.JList<String> jListStableAttributesAvailable;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private java.awt.Label label10;
    private java.awt.Label label11;
    private java.awt.Label label2;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label label9;
    private javax.swing.JPanel lowerPanel;
    private javax.swing.JPanel midPanel;
    private javax.swing.JButton outFileBrowseBtn1;
    private java.awt.TextField stableAttrs;
    private javax.swing.JButton submitBtn;
    private java.awt.TextField supportTxtField;
    private java.awt.Panel topPanel;
    // End of variables declaration//GEN-END:variables


}
