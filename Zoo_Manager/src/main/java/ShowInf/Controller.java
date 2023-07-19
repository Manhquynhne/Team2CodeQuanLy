package ShowInf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Home.AnimalManagementInterface;



public class Controller implements ActionListener, ListSelectionListener {


    HienThiView view;
    Second secondview;

    Second second;
    AnimalManagementInterface giaoDien;


    public Controller(HienThiView view) {
        this.view = view;
    }

    public Controller(Second second) {
        this.secondview = second;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Hiển thị ")) {
           second.hienThiButton();
        } else if (command.equals("TABLE")) {
            second.docDuLieuTable();
        } else if (command.equals("SỐ LIỆU SỨC KHỎE")) {
            this.view.hienThiGiaoDienSLSK();
            this.view.hienThiSLSK();
        } else if (command.equals("Home")) {
            //giaoDien.showHome();
        }

    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedRow = secondview.table.getSelectedRow();
            if (selectedRow == 0) {
                HienThiView.hienThiChimCanhCut();
            } else if (selectedRow == 1) {

            }
        }
    }

}
