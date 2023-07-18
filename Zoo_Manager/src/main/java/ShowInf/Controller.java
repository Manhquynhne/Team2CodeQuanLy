package ShowInf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
        if (command.equals("HIỂN THỊ THÔNG TIN")) {
            this.view.hienThiGiaoDien();

        } else if (command.equals("Hiển thị ")) {
            HienThiView.hienThiButton();
        } else if (command.equals("TABLE")) {
            try {
                HienThiView.docDuLieuTable();

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
                HienThiView.hienThiChimCanhCut();
            } else if (selectedRow == 1) {
                // view.inforChimCongLam();
            }
        }
    }

}
