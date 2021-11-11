package com.example.f21comp1011gctest1student;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class NetflixTableController implements Initializable {

    @FXML
    private TableView<NetflixShow> tableView;

    @FXML
    private TableColumn<NetflixShow, String> showIdCol;

    @FXML
    private TableColumn<NetflixShow, String> typeCol;

    @FXML
    private TableColumn<NetflixShow, String> titleCol;

    @FXML
    private TableColumn<NetflixShow, String> ratingCol;

    @FXML
    private TableColumn<NetflixShow, String> directorCol;

    @FXML
    private TableColumn<NetflixShow, String> castCol;

    @FXML
    private CheckBox movieCheckBox;

    @FXML
    private CheckBox tvCheckBox;

    @FXML
    private ComboBox<String> selectRatingComboBox;

    @FXML
    private Label numOfShowsLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String str = "(\"PG-13\",\"R\",\"TV-14\",\"TV-G\",\"TV-MA\",\"TV-Y\",\"TV-Y7\")";

        selectRatingComboBox.getItems().add("All ratings");

        showIdCol.setCellValueFactory(new PropertyValueFactory<>("showId"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        ratingCol.setCellValueFactory(new PropertyValueFactory<>("rating"));
        directorCol.setCellValueFactory(new PropertyValueFactory<>("director"));
        castCol.setCellValueFactory(new PropertyValueFactory<>("cast"));

        tableView.getItems().addAll(DBUtility.getNetflixShow(str));

        movieCheckBox.setSelected(true);
        tvCheckBox.setSelected(true);

        numOfShowsLabel.setText("Number of movies/shows: " + tableView.getItems().size());

        selectRatingComboBox.getItems().addAll(DBUtility.getSortedRatings());


    }

    @FXML
    void applyFilter(ActionEvent event)  {
        String str = "(\"PG-13\",\"R\",\"TV-14\",\"TV-G\",\"TV-MA\",\"TV-Y\",\"TV-Y7\")";
        String selectedItem = selectRatingComboBox.getSelectionModel().getSelectedItem();
        String selectedItemStr = "(\"" + selectRatingComboBox.getSelectionModel().getSelectedItem() + "\")";

        tableView.getItems().clear();

        if(selectedItem != null) {
            if(selectedItem != "All ratings"){
                if(movieCheckBox.isSelected() && tvCheckBox.isSelected()) {
                    tableView.getItems().addAll(DBUtility.getNetflixShow(selectedItemStr));
                }
                else if(movieCheckBox.isSelected())
                {
                    tableView.getItems().addAll(DBUtility.showMovies(selectedItemStr));
                }
                else if(tvCheckBox.isSelected())
                {
                    tableView.getItems().addAll(DBUtility.showTVs(selectedItemStr));
                }
            } else {
                if(movieCheckBox.isSelected() && tvCheckBox.isSelected()) {
                    tableView.getItems().addAll(DBUtility.getNetflixShow(str));
                }
                else if(movieCheckBox.isSelected())
                {
                    tableView.getItems().addAll(DBUtility.showMovies(str));
                }
                else if(tvCheckBox.isSelected())
                {
                    tableView.getItems().addAll(DBUtility.showTVs(str));
                }
            }
        } else {
            if(movieCheckBox.isSelected() && tvCheckBox.isSelected()) {
                tableView.getItems().addAll(DBUtility.getNetflixShow(str));
            }
            else if(movieCheckBox.isSelected())
            {
                tableView.getItems().addAll(DBUtility.showMovies(str));
            }
            else if(tvCheckBox.isSelected())
            {
                tableView.getItems().addAll(DBUtility.showTVs(str));
            }
        }

        numOfShowsLabel.setText("Number of movies/shows: " + tableView.getItems().size());
    }
}
