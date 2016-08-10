/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.carsystem.gui;



import com.alex.carsystem.entity.Car;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class CarSaleGUIImpl extends JFrame implements CarSaleGUI {
    
    private static final String[] TABLE_COLUMNS = {"CarId", "Model Name", "Make"};
    private static final String TAG_SEPARATOR = ",";
    private final JButton closeButton;
    private final JButton viewButton;
    private final JButton searchButton;
    
    private final JPanel inputPanel;
    private final JPanel buttonPanel;
    private final JPanel picPanel;
    private final JPanel centerPanel;
    
    private final JLabel carIdLabel;
    private final JLabel modelNoLabel;
    private final JLabel modelNameLabel;
    private final JLabel typeLabel;
    private JLabel thumbnailLabel;
    private final JLabel makeLabel;
    private final JLabel previewURLLable;
    private final JLabel descriptionLabel;
    
    private final JTextField CarIDTextField;
    private final JTextField modelNoTextField;
    private final JTextField modelNameTextField;
    private final JTextField typeTextField;
    private final JTextField thumbnailTextField;
    private final JTextField makeTextField;
    private final JTextField previewURLTextField;
    
    private final JTable carTable;
    private final JComboBox typeComboBox;
    private String typeString[] = {"Sedan", "4WheelDrive", "Truck"};
 //   private final JComboBox type;
//    private final JComboBox 
    Car car;
    private final JPanel rightPanel;
    
    
    private Container container = null;
    public CarSaleGUIImpl(ActionListener actionListener, ListSelectionListener listSelectionListener){
        super("Car Sales System");
        
        this.closeButton = new JButton("Close");
        this.viewButton = new JButton("Detail");
        this.searchButton = new JButton("Search");
        
        
        container = this.getContentPane();
        
        this.carIdLabel = new JLabel("Car ID");
        this.modelNoLabel = new JLabel("ModelNo");
        this.modelNameLabel = new JLabel("Model Name");
        this.typeLabel = new JLabel("Type");
        this.makeLabel  = new JLabel("Manufature");
        this.thumbnailLabel = new JLabel(" Thumbnail");
        this.previewURLLable = new JLabel("Preview URL");
        this.descriptionLabel = new JLabel("Description");
        
        // create labels
        this.CarIDTextField = new JTextField();
        this.modelNoTextField = new JTextField();
        this.modelNameTextField = new JTextField();
        this.makeTextField = new JTextField();
        this.typeTextField = new JTextField();
        this.thumbnailTextField = new JTextField();
        this.previewURLTextField = new JTextField();
        
        //create table
        this.carTable = new JTable(new DefaultTableModel(TABLE_COLUMNS,0));
        this.carTable.getSelectionModel().addListSelectionListener(listSelectionListener);
        this.carTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        TableColumnModel carTableColumnModel = this.carTable.getColumnModel();
        carTableColumnModel.getColumn(0).setPreferredWidth(200);
        carTableColumnModel.getColumn(1).setPreferredWidth(250);
        carTableColumnModel.getColumn(2).setPreferredWidth(250);
        
        
        this.typeComboBox = new JComboBox(typeString);
        //create panels
        this.inputPanel = new JPanel();
        this.buttonPanel = new JPanel();
        this.picPanel = new JPanel();
        this.centerPanel = new JPanel();
        this.rightPanel = new JPanel();
        
        //set layout manager
        container.setLayout(new BorderLayout());
        this.inputPanel.setLayout(new GridLayout(4,2));
        this.buttonPanel.setLayout(new GridLayout(1, 4));
        this.centerPanel.setLayout(new GridLayout(1, 2));
        this.rightPanel.setLayout(new GridLayout(2,1));
        
        
        //add action listeners
        this.closeButton.addActionListener(actionListener);
        this.viewButton.addActionListener(actionListener);
        this.searchButton.addActionListener(actionListener);
        
        //add components
     
        this.inputPanel.add(modelNoLabel);
        this.inputPanel.add(modelNoTextField);
        
        this.inputPanel.add(modelNameLabel);
        this.inputPanel.add(modelNameTextField);
        
        this.inputPanel.add(typeLabel);
        this.inputPanel.add(typeComboBox);
        
        this.inputPanel.add(makeLabel);
        this.inputPanel.add(makeTextField);
       
       //add buttons to panel 
       this.buttonPanel.add(this.viewButton);
       this.buttonPanel.add(this.searchButton);
       this.buttonPanel.add(this.closeButton);
       
       inputPanel.setPreferredSize(new Dimension(1500,200));
       picPanel.setPreferredSize(new Dimension(750,650));
       buttonPanel.setPreferredSize(new Dimension(1500, 50));
       picPanel.setPreferredSize(new Dimension(750, 400));
       descriptionLabel.setPreferredSize(new Dimension(750, 250));
       
       thumbnailLabel = new JLabel();
       this.rightPanel.add(picPanel);
       this.rightPanel.add(descriptionLabel);
       
       
       this.centerPanel.add(new JScrollPane(this.carTable));
       this.centerPanel.add(rightPanel);
       
       //add panels to content pane
       container.add(inputPanel,BorderLayout.NORTH);
       container.add(centerPanel,BorderLayout.CENTER);
       container.add(buttonPanel,BorderLayout.SOUTH);
       
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       this.setSize(1500, 900);
//       this.setResizable(false);
       this.setVisible(true);
       
    }    
    
    @Override
    public void clearInput() {
        this.clearTextField();
        this.clearComboBoxes();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clearTextField() {
       
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clearComboBoxes() {
//        if (this.type.getItemCount() >0) {
//             this.type.setSelectedIndex(0);
//        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dispalyMessageInDialog(String message) {
        JOptionPane.showMessageDialog(this, message);
        }

    @Override
    public void displayCarDetails(Car car) {
        this.clearInput();
       
        ((DefaultTableModel)this.carTable.getModel()).addRow(new Object[]{car.getVIN(),
            car.getModelNo(),car.getModelName(),car.getCarType(),
            car.getDescription(),car.getThumbNail(),car.getPreviewUrl()});
        
         }

    @Override
    public void displaySelectedCarDetails(Car car) {
        
            this.CarIDTextField.setText(String.valueOf(car.getVIN()));
            this.modelNoTextField.setText(String.valueOf(car.getModelNo()));
            this.modelNameTextField.setText(String.valueOf(car.getModelName()));
            this.typeTextField.setText(String.valueOf(car.getCarType()));
            this.makeTextField.setText(String.valueOf(car.getManufacturer()));
            this.thumbnailTextField.setText(String.valueOf(car.getThumbNail()));
            this.previewURLTextField.setText(String.valueOf(car.getPreviewUrl()));
         }

    @Override
    public void displayCarDetails(List<Car> cars) {
        this.clearInput();
        this.clearCarTable();
        
        for (Car car : cars) {
            ((DefaultTableModel)this.carTable.getModel()).addRow(new Object[]{car.getVIN(),
            car.getModelName(),car.getManufacturer()});
        }
    }

    @Override
    public void displayCarDetails(Set<Car> cars) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Car getCar(){
        Car car;
        car = new Car(typeComboBox.getSelectedIndex(),modelNoTextField.getText(),
                modelNameTextField.getText(),makeTextField.getText());
        
        return car;
    
    }

    @Override
    public String getSelectedCarId() throws Exception {
        
        int selectedRowIndex = this.carTable.getSelectedRow();
        
        String carId = this.carTable.getValueAt(selectedRowIndex, 0).toString();
        return carId;
        
  }

    @Override
    public JButton getCloseButton() {
        return closeButton;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JButton getSearchButton() {
        return searchButton;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JButton getViewButton() {
        return viewButton;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

    @Override
    public Car getCarDetails() {
        
        return new Car(makeTextField.getText(),modelNameTextField.getText());
    }
    
    @Override
    public int getCarID() {
        String id = this.CarIDTextField.getText();
        return id == null || id.isEmpty()? 0: Integer.parseInt(id);
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JTable getCarTable() {
        return carTable;
    }

    @Override
    public void displayAllCars() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clearCarTable() {
        int numberOfRow = this.carTable.getModel().getRowCount();
        
        if (numberOfRow > 0) {
            DefaultTableModel tableModel = (DefaultTableModel)this.carTable.getModel();
            for (int index = (numberOfRow -1); index >= 0; index--) {
                tableModel.removeRow(index);
            }
        }
    }

    @Override
    public boolean isCarSelected() {
     return carTable.getSelectedRow() >= 0;
      
    }

    @Override
    public void setInputContent(Car selectedCar) {
        
//        String path = getClass().getResource("/pic/"+selectedCar.getThumbNail());
        ImageIcon ic = new ImageIcon(getClass().getResource("/pic/"+selectedCar.getThumbNail()));
        thumbnailLabel.setIcon(ic);
        this.picPanel.add(thumbnailLabel);
        descriptionLabel.setText(selectedCar.getDescription());
        container.validate();
        
    }
    
}
