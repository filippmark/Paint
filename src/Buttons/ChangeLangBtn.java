package Buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChangeLangBtn extends BasicBtn{
    private ArrayList<BasicBtn> btns;

    public  ChangeLangBtn(ShapeDrawer shapeDrawer, ArrayList<BasicBtn> btns){
        super(shapeDrawer);
        this.btns = btns;
        setEngText("Change language");
        setRusText("Изменить язык");
        setLanguage(shapeDrawer.getLanguage());
        getBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              change();
            }
        });
    }

    public void change(){
        shapeDrawer.setLanguage(!shapeDrawer.getLanguage());
        getBtn().setText(shapeDrawer.getLanguage()? "Change language": "Изменить язык");
        for(int i = 0; i < btns.size(); i++)
            btns.get(i).setLanguage(shapeDrawer.getLanguage());
    }
}
