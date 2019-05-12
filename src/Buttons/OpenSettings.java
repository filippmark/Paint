package Buttons;

import ModuleLoader.Module;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class OpenSettings extends BasicBtn{
    JFileChooser fileChooser = new JFileChooser("C:\\Users\\lenovo\\Desktop");

    public OpenSettings(ShapeDrawer shapeDrawer, ChangeLangBtn changeLangBtn, Module module){
        super(shapeDrawer);
        setEngText("Upload settings");
        setRusText("Загрузить настройки");
        setLanguage(shapeDrawer.getLanguage());
        getBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    int result = fileChooser.showOpenDialog(null);
                    if (result == JFileChooser.APPROVE_OPTION ) {
                        File file = fileChooser.getSelectedFile();
                        if (file.exists()){
                            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                            DocumentBuilder builder = factory.newDocumentBuilder();
                            Document doc = builder.parse(file);

                            Node root = doc.getDocumentElement();
                            NodeList nodeList = root.getChildNodes();
                            if ((root.getNodeName().equals("SettingsForPaint")) && (nodeList.item(0).getNodeName().equals("Language"))
                                    &&(nodeList.item(1).getNodeName().equals("BackgroundColor")) && (nodeList.item(2).getNodeName().equals("IsVisible"))){
                                shapeDrawer.setBackground(new Color(Integer.valueOf(nodeList.item(1).getTextContent())));
                                if (nodeList.item(2).getTextContent().equals("1"))
                                    module.setOpen(true);
                                else
                                    if (nodeList.item(2).getTextContent().equals("0"))
                                        module.setOpen(false);
                                    else
                                        JOptionPane.showMessageDialog(null, shapeDrawer.getLanguage()? "Please, check you config file": "Проверьте ваш конфигурационный файл");    ;

                                String lang = nodeList.item(0).getTextContent();
                                if(lang.equals("English")) {
                                    shapeDrawer.setLanguage(true);
                                    changeLangBtn.change();
                                }else {
                                    if (lang.equals("Русский")) {
                                        shapeDrawer.setLanguage(true);
                                        changeLangBtn.change();
                                    }else
                                        JOptionPane.showMessageDialog(null, shapeDrawer.getLanguage()? "Please, check you config file": "Проверьте ваш конфигурационный файл");

                                }
                            } else{
                                JOptionPane.showMessageDialog(null, shapeDrawer.getLanguage()? "Please, check you config file": "Проверьте ваш конфигурационный файл");
                            }

                        }else{
                            JOptionPane.showMessageDialog(null, shapeDrawer.getLanguage() ? "1Please, choose another name for file" : "Выберите другое имя для файла");
                        }
                    }
                }catch (Exception exp){
                    JOptionPane.showMessageDialog(null, shapeDrawer.getLanguage()? "Please, check you config file": "Проверьте ваш конфигурационный файл");
                }
            }
        });
    }

}
