module MP3_sfleming {
    requires javafx.controls;
    requires javafx.fxml;

    opens randomCards to javafx.fxml;  // allow FXMLLoader to access your controller
    exports randomCards;              // allow JavaFX launcher to access Main

    opens hockeyStats to javafx.fxml;
    exports hockeyStats; // make public for JavaFX launcher
    
    opens conversionTool to javafx.fxml;
    exports conversionTool; // make public for JavaFX launcher
}


