/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student.bmgts.main;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author Kasun
 */
public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root= FXMLLoader.load(this.getClass().getResource("/lk/ijse/student/bmgts/view/Login.fxml"));
        Scene temp=new Scene(root);
        primaryStage.setScene(temp);
        primaryStage.centerOnScreen();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        
        primaryStage.show();
        FadeTransition tempTrans=new FadeTransition(Duration.millis(2500), root);
        tempTrans.setFromValue(0.0);
        tempTrans.setToValue(1.0);
        tempTrans.play();
    }
    public static void main(String[] args){
        launch(args);
    }
    
}
