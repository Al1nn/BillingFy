module BillingFy {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires de.jensd.fx.glyphs.octicons;
	requires de.jensd.fx.glyphs.fontawesome;
	requires de.jensd.fx.glyphs.materialicons;
	requires javafx.base;
	opens application to javafx.graphics, javafx.fxml;
	opens application.billings to javafx.graphics, javafx.fxml, javafx.base;
	opens application.clients to javafx.graphics, javafx.fxml, javafx.base;
	opens application.business to javafx.graphics, javafx.fxml, javafx.base;
	opens application.services to javafx.graphics, javafx.fxml, javafx.base;
	opens application.statistics to javafx.graphics, javafx.fxml, javafx.base;
	opens application.clients.popup to javafx.graphics, javafx.fxml, javafx.base;
	opens application.business.popup to javafx.graphics, javafx.fxml, javafx.base;
	opens application.services.popup to javafx.graphics, javafx.fxml, javafx.base;
}
