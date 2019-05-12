package Buttons;

import ModuleLoader.Module;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;

public class SaveSettings extends BasicBtn{
    JFileChooser fileChooser = new JFileChooser("C:\\Users\\lenovo\\Desktop");

    public SaveSettings(ShapeDrawer shapeDrawer, Module module){
        super(shapeDrawer);
        setEngText("Save Settings");
        setRusText("Сохранить настройки");
        setLanguage(shapeDrawer.getLanguage());
        getBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    factory.setNamespaceAware(true);
                    Document doc = factory.newDocumentBuilder().newDocument();

                    Element root = doc.createElement("SettingsForPaint");
                    doc.appendChild(root);

                    Element langOption = doc.createElement("Language");
                    root.appendChild(langOption);
                    langOption.setTextContent(shapeDrawer.getLanguage()? "English" : "Русский");

                    Element backColor = doc.createElement("BackgroundColor");
                    root.appendChild(backColor);
                    backColor.setTextContent(String.valueOf(shapeDrawer.getBackground().getRGB()));



                    fileChooser.setDialogTitle(shapeDrawer.getLanguage()? "Saving file" : "Сохранение файла");
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    int result = fileChooser.showSaveDialog(null);



                    if (result == JFileChooser.APPROVE_OPTION ) {
                        System.out.println(module.isOpen());
                        Element visible = doc.createElement("IsVisible");
                        root.appendChild(visible);
                        visible.setTextContent(module.isOpen()? "1" : "0");

                        File file = fileChooser.getSelectedFile();
                        if (!file.exists()){
                            FileOutputStream outStream = new FileOutputStream(file);
                            TransformerFactory tf = TransformerFactory.newInstance();
                            Transformer transformer = tf.newTransformer();
                            //transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                            transformer.transform(new DOMSource(doc), new StreamResult(outStream));
                        }else{
                            JOptionPane.showMessageDialog(null, shapeDrawer.getLanguage() ? "Please, choose another name for file" : "Выберите другое имя для файла");
                        }
                    }
                } catch (Exception exp) {
                    exp.printStackTrace();
                }


            }
        });
    }

}
