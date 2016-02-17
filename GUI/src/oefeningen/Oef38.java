/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oefeningen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author yannick.thibos
 */
public class Oef38 extends JFrame implements ActionListener {

    private JList list;
    private DefaultListModel listModel;
    private JButton remove, up, down, add;

    public Oef38() {
        setTitle("Keuzelijst");
        setSize(300, 200);
    }

    public static void main(String[] args) {

        Oef38 frame = new Oef38();
        frame.createGUI();
        frame.setVisible(true);

    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        listModel = new DefaultListModel();
        listModel.addElement("water");
        listModel.addElement("bier");
        listModel.addElement("wijn");

        list = new JList(listModel);
        add(list, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel();

        remove = new JButton("Remove");
        up = new JButton("Move up");
        down = new JButton("Move down");
        add = new JButton("Add new ..");
        remove.addActionListener(this);
        up.addActionListener(this);
        down.addActionListener(this);
        add.addActionListener(this);

        buttonsPanel.setLayout(new GridLayout(4, 1));
        buttonsPanel.add(remove);
        buttonsPanel.add(up);
        buttonsPanel.add(down);
        buttonsPanel.add(add);

        add(buttonsPanel, BorderLayout.EAST);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == remove) {
            if (list.getSelectedIndex() >= 0 && list.getSelectedIndex() < listModel.getSize()) {
                int focus = list.getSelectedIndex();
                listModel.remove(list.getSelectedIndex());
                if(!listModel.isEmpty())list.setSelectedIndex(focus);
            }
        } else if (e.getSource() == up) {
            int selectedIndex = list.getSelectedIndex();
            if (selectedIndex > 0) {
                int prevIndex = selectedIndex - 1;
                Object selectedObject = list.getSelectedValue();
                listModel.remove(selectedIndex);
                listModel.add(prevIndex, selectedObject);
                list.setSelectedIndex(prevIndex);
            }
        } else if (e.getSource() == down) {
            int selectedIndex = list.getSelectedIndex();
            if (selectedIndex < listModel.getSize() - 1) {
                int nextIndex = selectedIndex + 1;
                Object selectedObject = list.getSelectedValue();
                listModel.remove(selectedIndex);
                listModel.add(nextIndex, selectedObject);
                list.setSelectedIndex(nextIndex);
            }

        } else if (e.getSource() == add) {
            String newItem = JOptionPane.showInputDialog(null, "Enter item to add to list: ");
            listModel.addElement(newItem);
            list.setSelectedIndex(listModel.getSize() - 1);
        }
    }

}
