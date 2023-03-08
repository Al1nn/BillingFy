module BillingFy {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires de.jensd.fx.glyphs.octicons;
	requires de.jensd.fx.glyphs.fontawesome;
	requires de.jensd.fx.glyphs.materialicons;
	requires javafx.base;
	requires java.desktop;
	requires java.sql;
	requires jBCrypt;
	requires json.simple;
	opens application to javafx.graphics, javafx.fxml, javafx.base;
	opens application.register to javafx.graphics, javafx.fxml;
	opens application.billings to javafx.graphics, javafx.fxml, javafx.base;
	opens application.clients to javafx.graphics, javafx.fxml, javafx.base;
	opens application.business to javafx.graphics, javafx.fxml, javafx.base;
	opens application.services to javafx.graphics, javafx.fxml, javafx.base;
	opens application.resources to javafx.graphics, javafx.fxml, javafx.base;
	opens application.statistics to javafx.graphics, javafx.fxml, javafx.base;
	opens application.clients.popup to javafx.graphics, javafx.fxml, javafx.base;
	opens application.business.popup to javafx.graphics, javafx.fxml, javafx.base;
	opens application.services.popup to javafx.graphics, javafx.fxml, javafx.base;
	opens application.billings.popup to javafx.graphics, javafx.fxml, javafx.base;
}
