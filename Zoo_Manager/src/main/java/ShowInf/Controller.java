package ShowInf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Home.AnimalManagementInterface;

public class Controller implements ActionListener, ListSelectionListener {


    HienThiView view;
    Second secondview;


    public Controller(HienThiView view) {
        this.view = view;
    }

    public Controller(Second second) {
        this.secondview = second;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("HIỂN THỊ DANH SÁCH")) {
            try {
                Second.docDuLieuTable();

            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedRow = secondview.table.getSelectedRow();
            if (selectedRow == 0) {
                Second.hienThiChimCanhCut();
            } else if (selectedRow == 1) {
                Second.hienThiChimChaoMao();
            } else if (selectedRow == 2) {
                Second.hienThiChimCoDo();
            } else if (selectedRow == 3) {
                Second.hienThiChimCong();
            } else if (selectedRow == 4) {
                Second.hienThiChimHoetRung();
            } else if (selectedRow == 5) {
                Second.hienThiChimHongHac();
            } else if (selectedRow == 6) {
                Second.hienThiChimHongHoang();
            } else if (selectedRow == 7) {
                Second.hienThiChimRuoiOng();
            } else if (selectedRow == 8) {
                Second.hienThiChimSeuDauDo();
            } else if (selectedRow == 9) {
                Second.hienThiChimVetMacaw();
            }


        }
    }

}
