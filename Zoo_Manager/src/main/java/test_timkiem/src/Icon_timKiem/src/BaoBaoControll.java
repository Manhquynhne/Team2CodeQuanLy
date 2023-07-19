package Icon_timKiem.src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import test.read;
import test.timKiem;
import test.Animal;
import java.util.List;

public class BaoBaoControll implements ActionListener{
	
	BaoBaoView view;
	List<Animal> animals;
	
	
	public BaoBaoControll(BaoBaoView view) {
		this.view = view;
		this.animals = read.loadAnimal();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("Tìm")) {
			// add cho nó 1 hàm xử lí, hàm này nghĩa là nếu ấn chuột vào cái nút tìm thì hàm nào sẽ xử lí
			String thongTinCanTim = view.getThongTinCanTim(); // Lấy thông tin cần tìm từ ô nhập liệu
			timKiemTheoChuoi(thongTinCanTim);
		}
		
	}

	public void timKiemTheoChuoi(String thongTinCanTim) {
		timKiem.timKiemTheoChuoi(animals, thongTinCanTim);
	}

}
