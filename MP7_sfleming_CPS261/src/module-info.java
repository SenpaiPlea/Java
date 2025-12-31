module MP7_sfleming_CPS261 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
    opens application.controller to javafx.fxml;
    opens application.resources to javafx.fxml;
    opens application.model to javafx.base;

}
