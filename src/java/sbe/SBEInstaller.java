/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.Image;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringWriter;
/*     */ import java.util.jar.JarFile;
/*     */ import java.util.regex.Pattern;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.UIManager;
/*     */ 
/*     */ public class SBEInstaller extends JFrame implements ActionListener, MouseListener {
/*  26 */   private static final Pattern IN_MODS_SUBFOLDER = Pattern.compile("1\\.8\\.9[/\\\\]?$");
/*  27 */   private File modFile = null;
/*  28 */   private JLabel logo = null;
/*  29 */   private JLabel versionInfo = null;
/*  30 */   private JLabel labelFolder = null;
/*  31 */   private JLabel sbeKey = null;
/*     */ 
/*     */   
/*  34 */   private JPanel panelCenter = null;
/*  35 */   private JPanel panelBottom = null;
/*  36 */   private JPanel totalContentPane = null;
/*     */   
/*  38 */   private JTextArea descriptionText = null;
/*  39 */   private JTextArea forgeDescriptionText = null;
/*     */   
/*  41 */   private JTextField textFieldFolderLocation = null;
/*  42 */   private JTextField keyField = null;
/*  43 */   private JButton buttonChooseFolder = null;
/*     */   
/*  45 */   private JButton buttonInstall = null;
/*  46 */   private JButton buttonOpenFolder = null;
/*  47 */   private JButton buttonClose = null;
/*     */   
/*     */   private static final int TOTAL_HEIGHT = 485;
/*     */   
/*     */   private static final int TOTAL_WIDTH = 404;
/*  52 */   private int x = 0;
/*  53 */   private int y = 0;
/*     */   
/*  55 */   private int w = 404;
/*     */   private int h;
/*     */   private int margin;
/*     */   
/*     */   public SBEInstaller() {
/*     */     try {
/*  61 */       setName("SBEInstaller");
/*  62 */       setTitle("Install Skyblock Extras");
/*  63 */       setResizable(false);
/*  64 */       setSize(404, 485);
/*  65 */       setContentPane(getPanelContentPane());
/*     */       
/*  67 */       getButtonFolder().addActionListener(this);
/*  68 */       getButtonInstall().addActionListener(this);
/*  69 */       getButtonOpenFolder().addActionListener(this);
/*  70 */       getButtonClose().addActionListener(this);
/*  71 */       getForgeTextArea().addMouseListener(this);
/*     */       
/*  73 */       pack();
/*  74 */       setDefaultCloseOperation(3);
/*     */       
/*  76 */       getFieldFolder().setText(getModsFolder().getPath());
/*  77 */       getButtonInstall().setEnabled(true);
/*  78 */       getButtonInstall().requestFocus();
/*  79 */     } catch (Exception ex) {
/*  80 */       showErrorPopup(ex);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void main(File modFile) {
/*     */     try {
/*  86 */       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
/*  87 */       SBEInstaller frame = new SBEInstaller();
/*  88 */       frame.centerFrame(frame);
/*  89 */       frame.setVisible(true);
/*  90 */       frame.modFile = modFile;
/*  91 */       frame.getFieldFolder().setText(frame.modFile.getAbsolutePath());
/*  92 */     } catch (Exception ex) {
/*  93 */       showErrorPopup(ex);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/*     */     try {
/*  99 */       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
/* 100 */       SBEInstaller frame = new SBEInstaller();
/* 101 */       frame.centerFrame(frame);
/* 102 */       frame.setVisible(true);
/*     */     }
/* 104 */     catch (Exception ex) {
/* 105 */       showErrorPopup(ex);
/*     */     } 
/*     */   }
/*     */   
/*     */   private JPanel getPanelContentPane() {
/* 110 */     if (this.totalContentPane == null) {
/*     */       try {
/* 112 */         this.totalContentPane = new JPanel();
/* 113 */         this.totalContentPane.setName("PanelContentPane");
/* 114 */         this.totalContentPane.setLayout(new BorderLayout(5, 5));
/* 115 */         this.totalContentPane.setPreferredSize(new Dimension(404, 485));
/* 116 */         this.totalContentPane.add(getPanelCenter(), "Center");
/* 117 */         this.totalContentPane.add(getPanelBottom(), "South");
/* 118 */       } catch (Throwable ivjExc) {
/* 119 */         showErrorPopup(ivjExc);
/*     */       } 
/*     */     }
/* 122 */     return this.totalContentPane;
/*     */   }
/*     */   
/*     */   private JPanel getPanelCenter() {
/* 126 */     if (this.panelCenter == null) {
/*     */       try {
/* 128 */         (this.panelCenter = new JPanel()).setName("PanelCenter");
/* 129 */         this.panelCenter.setLayout((LayoutManager)null);
/* 130 */         this.panelCenter.add(getPictureLabel(), getPictureLabel().getName());
/* 131 */         this.panelCenter.add(getVersionInfo(), getVersionInfo().getName());
/* 132 */         this.panelCenter.add(getTextArea(), getTextArea().getName());
/* 133 */         this.panelCenter.add(getForgeTextArea(), getForgeTextArea().getName());
/* 134 */         this.panelCenter.add(getSBEKey(), getSBEKey().getName());
/* 135 */         this.panelCenter.add(getKeyField(), getKeyField().getName());
/* 136 */         this.panelCenter.add(getLabelFolder(), getLabelFolder().getName());
/* 137 */         this.panelCenter.add(getFieldFolder(), getFieldFolder().getName());
/* 138 */         this.panelCenter.add(getButtonFolder(), getButtonFolder().getName());
/* 139 */       } catch (Throwable ivjExc) {
/* 140 */         showErrorPopup(ivjExc);
/*     */       } 
/*     */     }
/* 143 */     return this.panelCenter;
/*     */   }
/*     */   
/*     */   private JLabel getPictureLabel() {
/* 147 */     if (this.logo == null) {
/*     */       try {
/* 149 */         this.h = this.w / 2;
/* 150 */         this.margin = 5;
/*     */         
/* 152 */         BufferedImage myPicture = ImageIO.read(Objects.<InputStream>requireNonNull(getClass().getClassLoader()
/* 153 */               .getResourceAsStream("assets/skyblockextras/banner.png"), "Banner not found."));
/* 154 */         Image scaled = myPicture.getScaledInstance(this.w - this.margin * 2, this.h - this.margin, 4);
/* 155 */         this.logo = new JLabel(new ImageIcon(scaled));
/* 156 */         this.logo.setName("Logo");
/* 157 */         this.logo.setBounds(this.x + this.margin, this.y + this.margin, this.w - this.margin * 2, this.h - this.margin);
/* 158 */         this.logo.setFont(new Font("Dialog", 1, 18));
/* 159 */         this.logo.setHorizontalAlignment(0);
/* 160 */         this.logo.setPreferredSize(new Dimension(this.w, this.h));
/*     */         
/* 162 */         this.y += this.h;
/* 163 */       } catch (Throwable ivjExc) {
/* 164 */         showErrorPopup(ivjExc);
/*     */       } 
/*     */     }
/* 167 */     return this.logo;
/*     */   }
/*     */   
/*     */   private JLabel getVersionInfo() {
/* 171 */     if (this.versionInfo == null) {
/*     */       try {
/* 173 */         this.h = 25;
/*     */         
/* 175 */         this.versionInfo = new JLabel();
/* 176 */         this.versionInfo.setName("LabelMcVersion");
/* 177 */         this.versionInfo.setBounds(this.x, this.y, this.w, this.h);
/* 178 */         this.versionInfo.setFont(new Font("Dialog", 1, 14));
/* 179 */         this.versionInfo.setHorizontalAlignment(0);
/* 180 */         this.versionInfo.setPreferredSize(new Dimension(this.w, this.h));
/* 181 */         this.versionInfo.setText("v" + getVersionFromMcmodInfo() + " by AlphaElite - Installer made by Biscuit");
/*     */         
/* 183 */         this.y += this.h;
/* 184 */       } catch (Throwable ivjExc) {
/* 185 */         showErrorPopup(ivjExc);
/*     */       } 
/*     */     }
/* 188 */     return this.versionInfo;
/*     */   }
/*     */   
/*     */   private JTextArea getTextArea() {
/* 192 */     if (this.descriptionText == null) {
/*     */       try {
/* 194 */         this.h = 60;
/* 195 */         this.margin = 10;
/*     */         
/* 197 */         this.descriptionText = new JTextArea();
/* 198 */         this.descriptionText.setName("TextArea");
/* 199 */         setTextAreaProperties(this.descriptionText);
/* 200 */         this.descriptionText.setText("This installer will automatically install Skyblock Extras on your computer. You will also need to input a Skyblock Extras Key (obtainable via the SBE Discord server).");
/* 201 */         this.descriptionText.setWrapStyleWord(true);
/*     */         
/* 203 */         this.y += this.h;
/* 204 */       } catch (Throwable ivjExc) {
/* 205 */         showErrorPopup(ivjExc);
/*     */       } 
/*     */     }
/* 208 */     return this.descriptionText;
/*     */   }
/*     */   
/*     */   private void setTextAreaProperties(JTextArea textArea) {
/* 212 */     textArea.setBounds(this.x + this.margin, this.y + this.margin, this.w - this.margin * 2, this.h - this.margin);
/* 213 */     textArea.setEditable(false);
/* 214 */     textArea.setHighlighter((Highlighter)null);
/* 215 */     textArea.setEnabled(true);
/* 216 */     textArea.setFont(new Font("Dialog", 0, 12));
/* 217 */     textArea.setLineWrap(true);
/* 218 */     textArea.setOpaque(false);
/* 219 */     textArea.setPreferredSize(new Dimension(this.w - this.margin * 2, this.h - this.margin));
/*     */   }
/*     */   
/*     */   private JTextArea getForgeTextArea() {
/* 223 */     if (this.forgeDescriptionText == null) {
/*     */       try {
/* 225 */         this.h = 65;
/* 226 */         this.margin = 10;
/*     */         
/* 228 */         this.forgeDescriptionText = new JTextArea();
/* 229 */         this.forgeDescriptionText.setName("TextAreaForge");
/* 230 */         setTextAreaProperties(this.forgeDescriptionText);
/* 231 */         this.forgeDescriptionText.setText("However, you still need to install the newest Forge version in order to be able to run this mod. Click here to visit the download page for Forge 1.8.9!");
/* 232 */         this.forgeDescriptionText.setForeground(Color.BLUE.darker());
/* 233 */         this.forgeDescriptionText.setCursor(Cursor.getPredefinedCursor(12));
/* 234 */         this.forgeDescriptionText.setWrapStyleWord(true);
/*     */         
/* 236 */         this.y += this.h + this.margin;
/* 237 */       } catch (Throwable ivjExc) {
/* 238 */         showErrorPopup(ivjExc);
/*     */       } 
/*     */     }
/* 241 */     return this.forgeDescriptionText;
/*     */   }
/*     */   private JLabel getSBEKey() {
/* 244 */     if (this.sbeKey == null) {
/* 245 */       this.h = 16;
/* 246 */       this.w = 65;
/* 247 */       this.x += 10;
/*     */       
/*     */       try {
/* 250 */         this.sbeKey = new JLabel();
/* 251 */         this.sbeKey.setName("SbeKey");
/* 252 */         this.sbeKey.setBounds(this.x, this.y + 2, this.w, this.h);
/* 253 */         this.sbeKey.setPreferredSize(new Dimension(this.w, this.h));
/* 254 */         this.sbeKey.setText("SBE Key");
/* 255 */       } catch (Throwable ivjExc) {
/* 256 */         showErrorPopup(ivjExc);
/*     */       } 
/*     */       
/* 259 */       this.x += this.w;
/*     */     } 
/* 261 */     return this.sbeKey;
/*     */   }
/*     */   private JTextField getKeyField() {
/* 264 */     if (this.keyField == null) {
/* 265 */       this.h = 20;
/* 266 */       this.w = 200;
/*     */       
/*     */       try {
/* 269 */         this.keyField = new JTextField("Enter Key Here (Initial Installation)");
/* 270 */         this.keyField.setName("KeyField");
/* 271 */         this.keyField.setBounds(this.x, this.y, this.w, this.h);
/* 272 */         this.keyField.setEditable(true);
/* 273 */         this.keyField.setPreferredSize(new Dimension(this.w, this.h));
/* 274 */         this.keyField.setFont(new Font(this.keyField.getFont().getName(), 2, this.keyField.getFont().getSize()));
/* 275 */       } catch (Throwable ivjExc) {
/* 276 */         showErrorPopup(ivjExc);
/*     */       } 
/*     */       
/* 279 */       this.x += this.w;
/* 280 */       this.y += this.h + 10;
/*     */     } 
/* 282 */     return this.keyField;
/*     */   }
/*     */   private JLabel getLabelFolder() {
/* 285 */     if (this.labelFolder == null) {
/* 286 */       this.h = 16;
/* 287 */       this.w = 65;
/* 288 */       this.x = 0;
/* 289 */       this.x += 10;
/*     */       
/*     */       try {
/* 292 */         this.labelFolder = new JLabel();
/* 293 */         this.labelFolder.setName("LabelFolder");
/* 294 */         this.labelFolder.setBounds(this.x, this.y + 2, this.w, this.h);
/* 295 */         this.labelFolder.setPreferredSize(new Dimension(this.w, this.h));
/* 296 */         this.labelFolder.setText("Mods Folder");
/* 297 */       } catch (Throwable ivjExc) {
/* 298 */         showErrorPopup(ivjExc);
/*     */       } 
/*     */       
/* 301 */       this.x += this.w;
/*     */     } 
/* 303 */     return this.labelFolder;
/*     */   }
/*     */   
/*     */   private JTextField getFieldFolder() {
/* 307 */     if (this.textFieldFolderLocation == null) {
/* 308 */       this.h = 20;
/* 309 */       this.w = 287;
/*     */       
/*     */       try {
/* 312 */         this.textFieldFolderLocation = new JTextField();
/* 313 */         this.textFieldFolderLocation.setName("FieldFolder");
/* 314 */         this.textFieldFolderLocation.setBounds(this.x, this.y, this.w, this.h);
/* 315 */         this.textFieldFolderLocation.setEditable(false);
/* 316 */         this.textFieldFolderLocation.setPreferredSize(new Dimension(this.w, this.h));
/* 317 */       } catch (Throwable ivjExc) {
/* 318 */         showErrorPopup(ivjExc);
/*     */       } 
/*     */       
/* 321 */       this.x += this.w;
/*     */     } 
/* 323 */     return this.textFieldFolderLocation;
/*     */   }
/*     */   
/*     */   private JButton getButtonFolder() {
/* 327 */     if (this.buttonChooseFolder == null) {
/* 328 */       this.h = 20;
/* 329 */       this.w = 25;
/*     */       
/* 331 */       this.x += 10;
/*     */       
/*     */       try {
/* 334 */         BufferedImage myPicture = ImageIO.read(Objects.<InputStream>requireNonNull(getClass().getClassLoader()
/* 335 */               .getResourceAsStream("assets/skyblockextras/folder.png"), "Folder icon not found."));
/* 336 */         Image scaled = myPicture.getScaledInstance(this.w - 8, this.h - 6, 4);
/* 337 */         this.buttonChooseFolder = new JButton(new ImageIcon(scaled));
/* 338 */         this.buttonChooseFolder.setName("ButtonFolder");
/* 339 */         this.buttonChooseFolder.setBounds(this.x, this.y, this.w, this.h);
/* 340 */         this.buttonChooseFolder.setPreferredSize(new Dimension(this.w, this.h));
/* 341 */       } catch (Throwable ivjExc) {
/* 342 */         showErrorPopup(ivjExc);
/*     */       } 
/*     */     } 
/* 345 */     return this.buttonChooseFolder;
/*     */   }
/*     */   
/*     */   private JPanel getPanelBottom() {
/* 349 */     if (this.panelBottom == null) {
/*     */       try {
/* 351 */         this.panelBottom = new JPanel();
/* 352 */         this.panelBottom.setName("PanelBottom");
/* 353 */         this.panelBottom.setLayout(new FlowLayout(1, 15, 10));
/* 354 */         this.panelBottom.setPreferredSize(new Dimension(390, 55));
/* 355 */         this.panelBottom.add(getButtonInstall(), getButtonInstall().getName());
/* 356 */         this.panelBottom.add(getButtonOpenFolder(), getButtonOpenFolder().getName());
/* 357 */         this.panelBottom.add(getButtonClose(), getButtonClose().getName());
/* 358 */       } catch (Throwable ivjExc) {
/* 359 */         showErrorPopup(ivjExc);
/*     */       } 
/*     */     }
/* 362 */     return this.panelBottom;
/*     */   }
/*     */   
/*     */   private JButton getButtonInstall() {
/* 366 */     if (this.buttonInstall == null) {
/* 367 */       this.w = 100;
/* 368 */       this.h = 26;
/*     */       
/*     */       try {
/* 371 */         this.buttonInstall = new JButton();
/* 372 */         this.buttonInstall.setName("ButtonInstall");
/* 373 */         this.buttonInstall.setPreferredSize(new Dimension(this.w, this.h));
/* 374 */         this.buttonInstall.setText("Install");
/* 375 */       } catch (Throwable ivjExc) {
/* 376 */         showErrorPopup(ivjExc);
/*     */       } 
/*     */     } 
/* 379 */     return this.buttonInstall;
/*     */   }
/*     */   
/*     */   private JButton getButtonOpenFolder() {
/* 383 */     if (this.buttonOpenFolder == null) {
/* 384 */       this.w = 130;
/* 385 */       this.h = 26;
/*     */       
/*     */       try {
/* 388 */         this.buttonOpenFolder = new JButton();
/* 389 */         this.buttonOpenFolder.setName("ButtonOpenFolder");
/* 390 */         this.buttonOpenFolder.setPreferredSize(new Dimension(this.w, this.h));
/* 391 */         this.buttonOpenFolder.setText("Open Mods Folder");
/* 392 */       } catch (Throwable ivjExc) {
/* 393 */         showErrorPopup(ivjExc);
/*     */       } 
/*     */     } 
/* 396 */     return this.buttonOpenFolder;
/*     */   }
/*     */   
/*     */   private JButton getButtonClose() {
/* 400 */     if (this.buttonClose == null) {
/* 401 */       this.w = 100;
/* 402 */       this.h = 26;
/*     */       
/*     */       try {
/* 405 */         (this.buttonClose = new JButton()).setName("ButtonClose");
/* 406 */         this.buttonClose.setPreferredSize(new Dimension(this.w, this.h));
/* 407 */         this.buttonClose.setText("Cancel");
/* 408 */       } catch (Throwable ivjExc) {
/* 409 */         showErrorPopup(ivjExc);
/*     */       } 
/*     */     } 
/* 412 */     return this.buttonClose;
/*     */   }
/*     */   
/*     */   public void onFolderSelect() {
/* 416 */     File currentDirectory = new File(getFieldFolder().getText());
/*     */     
/* 418 */     JFileChooser jFileChooser = new JFileChooser(currentDirectory);
/* 419 */     jFileChooser.setFileSelectionMode(1);
/* 420 */     jFileChooser.setAcceptAllFileFilterUsed(false);
/* 421 */     if (jFileChooser.showOpenDialog(this) == 0) {
/* 422 */       File newDirectory = jFileChooser.getSelectedFile();
/* 423 */       getFieldFolder().setText(newDirectory.getPath());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void actionPerformed(ActionEvent e) {
/* 429 */     if (e.getSource() == getButtonClose()) {
/* 430 */       dispose();
/* 431 */       System.exit(0);
/*     */     } 
/* 433 */     if (e.getSource() == getButtonFolder()) {
/* 434 */       onFolderSelect();
/*     */     }
/* 436 */     if (e.getSource() == getButtonInstall()) {
/* 437 */       onInstall();
/*     */     }
/* 439 */     if (e.getSource() == getButtonOpenFolder()) {
/* 440 */       onOpenFolder();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void mouseClicked(MouseEvent e) {
/* 446 */     if (e.getSource() == getForgeTextArea()) {
/*     */       try {
/* 448 */         Desktop.getDesktop().browse(new URI("http://files.minecraftforge.net/maven/net/minecraftforge/forge/index_1.8.9.html"));
/* 449 */       } catch (IOException|URISyntaxException ex) {
/* 450 */         showErrorPopup(ex);
/*     */       } 
/* 452 */     } else if (e.getSource() == getKeyField()) {
/* 453 */       this.keyField.requestFocusInWindow();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void onInstall() {
/*     */     try {
/* 459 */       File modsFolder = new File(getFieldFolder().getText());
/* 460 */       if (!modsFolder.exists()) {
/* 461 */         showErrorMessage("Folder not found: " + modsFolder.getPath());
/*     */         return;
/*     */       } 
/* 464 */       if (!modsFolder.isDirectory()) {
/* 465 */         showErrorMessage("Not a folder: " + modsFolder.getPath());
/*     */         return;
/*     */       } 
/* 468 */       tryInstall(modsFolder);
/* 469 */     } catch (Exception e) {
/* 470 */       showErrorPopup(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void tryInstall(File modsFolder) {
/* 475 */     File thisFile = getThisFile();
/*     */     
/* 477 */     if (thisFile != null) {
/* 478 */       File newFile = new File(modsFolder, "SkyblockExtras-" + getVersionFromMcmodInfo() + ".jar");
/* 479 */       File config = new File(newFile.toString().replaceAll("\\\\mods.*", "\\\\config") + "\\SkyblockExtras.cfg");
/*     */       boolean exists;
/* 481 */       if ((exists = !config.exists()) && 
/* 482 */         this.keyField.getText().length() != 30) {
/* 483 */         showErrorMessage("Invalid SBE Key!");
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 488 */       boolean inSubFolder = IN_MODS_SUBFOLDER.matcher(modsFolder.getPath()).find();
/*     */ 
/*     */       
/* 491 */       if (thisFile.equals(newFile)) {
/* 492 */         showErrorMessage("You are opening this file from where the file should be installed... there's nothing to be done!");
/*     */         
/*     */         return;
/*     */       } 
/* 496 */       boolean deletingFailure = false;
/* 497 */       if (modsFolder.isDirectory()) {
/* 498 */         boolean failed = findSkyblockExtrasAndDelete(modsFolder.listFiles());
/* 499 */         if (failed) deletingFailure = true; 
/*     */       } 
/* 501 */       if (inSubFolder) {
/* 502 */         if (modsFolder.getParentFile().isDirectory()) {
/* 503 */           boolean failed = findSkyblockExtrasAndDelete(modsFolder.getParentFile().listFiles());
/* 504 */           if (failed) deletingFailure = true; 
/*     */         } 
/*     */       } else {
/* 507 */         File subFolder = new File(modsFolder, "1.8.9");
/* 508 */         if (subFolder.exists() && subFolder.isDirectory()) {
/* 509 */           boolean failed = findSkyblockExtrasAndDelete(subFolder.listFiles());
/* 510 */           if (failed) deletingFailure = true;
/*     */         
/*     */         } 
/*     */       } 
/* 514 */       if (deletingFailure)
/*     */         return; 
/* 516 */       if (thisFile.isDirectory()) {
/* 517 */         showErrorMessage("This file is a directory... Are we in a development environment?");
/*     */         
/*     */         return;
/*     */       } 
/*     */       try {
/* 522 */         Files.copy(thisFile.toPath(), newFile.toPath(), new java.nio.file.CopyOption[0]);
/* 523 */         if (exists) {
/* 524 */           PrintWriter writer = new PrintWriter(config);
/* 525 */           writer.println("SBEKey=" + this.keyField.getText());
/* 526 */           writer.close();
/*     */         } else {
/* 528 */           String text = this.keyField.getText();
/* 529 */           if (text.length() == 30 && !text.contains(" ")) {
/* 530 */             BufferedReader reader = new BufferedReader(new FileReader(config));
/* 531 */             StringBuilder configLines = new StringBuilder();
/* 532 */             reader.lines().forEach(line -> configLines.append(line.trim()));
/* 533 */             reader.close();
/* 534 */             JsonObject obj = (new JsonParser()).parse(configLines.toString()).getAsJsonObject();
/* 535 */             obj.getAsJsonObject("values").get("others").getAsJsonArray().add((JsonElement)new JsonPrimitive(text));
/* 536 */             String s = (new GsonBuilder()).setPrettyPrinting().create().toJson((JsonElement)obj);
/* 537 */             PrintWriter writer = new PrintWriter(config);
/* 538 */             writer.println(s);
/* 539 */             writer.close();
/*     */           } 
/*     */         } 
/* 542 */       } catch (Exception ex) {
/* 543 */         showErrorPopup(ex);
/*     */         
/*     */         return;
/*     */       } 
/* 547 */       showMessage("Skyblock Extras has been successfully installed into your mods folder.");
/* 548 */       dispose();
/* 549 */       System.exit(0);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean findSkyblockExtrasAndDelete(File[] files) {
/* 555 */     if (files == null) return false;
/*     */     
/* 557 */     for (File file : files) {
/* 558 */       if (!file.isDirectory() && file.getPath().endsWith(".jar")) {
/*     */         try {
/* 560 */           JarFile jarFile = new JarFile(file);
/* 561 */           ZipEntry mcModInfo = jarFile.getEntry("mcmod.info");
/* 562 */           if (mcModInfo != null) {
/* 563 */             InputStream inputStream = jarFile.getInputStream(mcModInfo);
/* 564 */             String modID = getModIDFromInputStream(inputStream);
/* 565 */             if (modID.equals("SkyblockExtras")) {
/* 566 */               jarFile.close();
/*     */               try {
/* 568 */                 boolean deleted = file.delete();
/* 569 */                 if (!deleted) {
/* 570 */                   throw new Exception();
/*     */                 }
/* 572 */               } catch (Exception ex) {
/* 573 */                 ex.printStackTrace();
/* 574 */                 showErrorMessage("Was not able to delete the other Skyblock Extras files found in your mods folder!" + System.lineSeparator() + "Please make sure that your minecraft is currently closed and try again, or feel" + 
/* 575 */                     System.lineSeparator() + "free to open your mods folder and delete those files manually.");
/*     */                 
/* 577 */                 return true;
/*     */               } 
/*     */               continue;
/*     */             } 
/*     */           } 
/* 582 */           jarFile.close();
/* 583 */         } catch (Exception exception) {}
/*     */       }
/*     */       
/*     */       continue;
/*     */     } 
/* 588 */     return false;
/*     */   }
/*     */   
/*     */   public void onOpenFolder() {
/*     */     try {
/* 593 */       Desktop.getDesktop().open(getModsFolder());
/* 594 */     } catch (Exception e) {
/* 595 */       showErrorPopup(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public File getModsFolder() {
/* 600 */     String userHome = System.getProperty("user.home", ".");
/*     */     
/* 602 */     File modsFolder = getFile(userHome, "minecraft/mods/1.8.9");
/* 603 */     if (!modsFolder.exists()) {
/* 604 */       modsFolder = getFile(userHome, "minecraft/mods");
/*     */     }
/*     */     
/* 607 */     if (!modsFolder.exists() && !modsFolder.mkdirs()) {
/* 608 */       throw new RuntimeException("The working directory could not be created: " + modsFolder);
/*     */     }
/* 610 */     return modsFolder;
/*     */   }
/*     */   
/*     */   public File getFile(String userHome, String minecraftPath) {
/*     */     String applicationData;
/* 615 */     switch (getOperatingSystem())
/*     */     { case LINUX:
/*     */       case SOLARIS:
/* 618 */         workingDirectory = new File(userHome, '.' + minecraftPath + '/');
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 639 */         return workingDirectory;case WINDOWS: applicationData = System.getenv("APPDATA"); if (applicationData != null) { workingDirectory = new File(applicationData, "." + minecraftPath + '/'); } else { workingDirectory = new File(userHome, '.' + minecraftPath + '/'); }  return workingDirectory;case MACOS: workingDirectory = new File(userHome, "Library/Application Support/" + minecraftPath); return workingDirectory; }  File workingDirectory = new File(userHome, minecraftPath + '/'); return workingDirectory;
/*     */   }
/*     */   
/*     */   public OperatingSystem getOperatingSystem() {
/* 643 */     String osName = System.getProperty("os.name").toLowerCase(Locale.US);
/* 644 */     if (osName.contains("win")) {
/* 645 */       return OperatingSystem.WINDOWS;
/*     */     }
/* 647 */     if (osName.contains("mac")) {
/* 648 */       return OperatingSystem.MACOS;
/*     */     }
/* 650 */     if (osName.contains("solaris") || osName.contains("sunos"))
/*     */     {
/* 652 */       return OperatingSystem.SOLARIS; } 
/* 653 */     if (osName.contains("linux") || osName.contains("unix"))
/*     */     {
/* 655 */       return OperatingSystem.LINUX;
/*     */     }
/* 657 */     return OperatingSystem.UNKNOWN;
/*     */   }
/*     */   
/*     */   public void centerFrame(JFrame frame) {
/* 661 */     Rectangle rectangle = frame.getBounds();
/* 662 */     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
/* 663 */     Rectangle screenRectangle = new Rectangle(0, 0, screenSize.width, screenSize.height);
/*     */     
/* 665 */     int newX = screenRectangle.x + (screenRectangle.width - rectangle.width) / 2;
/* 666 */     int newY = screenRectangle.y + (screenRectangle.height - rectangle.height) / 2;
/*     */     
/* 668 */     if (newX < 0) newX = 0; 
/* 669 */     if (newY < 0) newY = 0;
/*     */     
/* 671 */     frame.setBounds(newX, newY, rectangle.width, rectangle.height);
/*     */   }
/*     */   
/*     */   public void showMessage(String message) {
/* 675 */     JOptionPane.showMessageDialog(null, message, "Skyblock Extras", 1);
/*     */   }
/*     */   
/*     */   public void showErrorMessage(String message) {
/* 679 */     JOptionPane.showMessageDialog(null, message, "Skyblock Extras - Error", 0);
/*     */   }
/*     */   
/*     */   public enum OperatingSystem {
/* 683 */     LINUX,
/* 684 */     SOLARIS,
/* 685 */     WINDOWS,
/* 686 */     MACOS,
/* 687 */     UNKNOWN;
/*     */   }
/*     */   
/*     */   private static String getStacktraceText(Throwable ex) {
/* 691 */     StringWriter stringWriter = new StringWriter();
/* 692 */     ex.printStackTrace(new PrintWriter(stringWriter));
/* 693 */     return stringWriter.toString().replace("\t", "  ");
/*     */   }
/*     */ 
/*     */   
/*     */   private static void showErrorPopup(Throwable ex) {
/* 698 */     ex.printStackTrace();
/*     */     
/* 700 */     JTextArea textArea = new JTextArea("You may need to install the mod manually:\n\n" + getStacktraceText(ex));
/* 701 */     textArea.setEditable(false);
/* 702 */     Font currentFont = textArea.getFont();
/* 703 */     Font newFont = new Font("Monospaced", currentFont.getStyle(), currentFont.getSize());
/* 704 */     textArea.setFont(newFont);
/*     */     
/* 706 */     JScrollPane errorScrollPane = new JScrollPane(textArea);
/* 707 */     errorScrollPane.setPreferredSize(new Dimension(600, 400));
/* 708 */     JOptionPane.showMessageDialog(null, errorScrollPane, "Error", 0);
/*     */   }
/*     */   
/*     */   private String getVersionFromMcmodInfo() {
/* 712 */     String version = "";
/*     */     try {
/* 714 */       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Objects.<InputStream>requireNonNull(getClass()
/* 715 */               .getClassLoader().getResourceAsStream("mcmod.info"), "mcmod.info not found.")));
/* 716 */       while ((version = bufferedReader.readLine()) != null) {
/* 717 */         if (version.contains("\"version\": \"")) {
/* 718 */           version = version.split(Pattern.quote("\"version\": \""))[1];
/* 719 */           version = version.substring(0, version.length() - 2);
/*     */           break;
/*     */         } 
/*     */       } 
/* 723 */       bufferedReader.close();
/* 724 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/* 727 */     return version;
/*     */   }
/*     */   
/*     */   private String getModIDFromInputStream(InputStream inputStream) {
/* 731 */     String version = "";
/*     */     try {
/* 733 */       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
/* 734 */       while ((version = bufferedReader.readLine()) != null) {
/* 735 */         if (version.contains("\"modid\": \"")) {
/* 736 */           version = version.split(Pattern.quote("\"modid\": \""))[1];
/* 737 */           version = version.substring(0, version.length() - 2);
/*     */           break;
/*     */         } 
/*     */       } 
/* 741 */       bufferedReader.close();
/* 742 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/* 745 */     return version;
/*     */   }
/*     */   
/*     */   private File getThisFile() {
/*     */     try {
/* 750 */       return new File(SBEInstaller.class.getProtectionDomain().getCodeSource().getLocation().toURI());
/* 751 */     } catch (URISyntaxException ex) {
/* 752 */       showErrorPopup(ex);
/*     */       
/* 754 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void mousePressed(MouseEvent e) {}
/*     */   
/*     */   public void mouseReleased(MouseEvent e) {}
/*     */   
/*     */   public void mouseEntered(MouseEvent e) {}
/*     */   
/*     */   public void mouseExited(MouseEvent e) {}
/*     */ }


/* Location:              C:\Users\nebul\Downloads\SkyblockExtras-2.1.10.1 (1).jar!\SBEInstaller.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */