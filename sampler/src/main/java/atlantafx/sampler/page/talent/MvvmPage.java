/* SPDX-License-Identifier: MIT */

package atlantafx.sampler.page.talent;

import org.tio.fx.FxForms;

import atlantafx.sampler.page.OutlinePage;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public final class MvvmPage extends OutlinePage {

	public static final String NAME = "Mvvm";

	@Override
	public String getName() {
		return NAME;
	}

	public MvvmPage() {
		super();

		addPageHeader();
		//		addFormattedText("""
		//		        this page test mvvm with mvvmfx.
		//		                """);
		addSection("Use Fxml", useFxml());
		//		addSection("VBox Form", vboxForm());
		//		addSection("Grid Form", gridForm());
		addSection("Tio Grid Form", tioGridForm());

	}

	private Node useFxml() {
		ViewTuple<HelloWorldView, HelloWorldViewModel> viewTuple = FluentViewLoader.fxmlView(HelloWorldView.class).load();

		Parent root = viewTuple.getView();
		return root;
	}

	private VBox vboxForm() {
		VBox vbox = new VBox();
		//		vbox.setAlignment(Pos.CENTER);
		vbox.setSpacing(10);
		vbox.setPadding(new Insets(25, 25, 25, 25));

		//        vbox.addr

		Text sceneTitle = new Text("Welcome");
		sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		vbox.getChildren().add(sceneTitle);
		Label userName = new Label("User Name");
		TextField userTextField = new TextField();
		vbox.getChildren().add(hbox(userName, userTextField));

		Label pw = new Label("Password");
		pw.setPrefWidth(0);
		PasswordField pwBox = new PasswordField();
		vbox.getChildren().add(hbox(pw, pwBox));

		Button btn = new Button("Sign in");
		HBox hbBtn = new HBox(10);
		//		hbBtn.setAlignment(Pos.BASELINE_RIGHT);
		hbBtn.getChildren().add(btn);
		vbox.getChildren().add(hbBtn);
		final Text text = new Text();
		vbox.getChildren().add(text);

		btn.setOnAction(event -> {
			text.setFill(Color.FIREBRICK);
			text.setTextOrigin(VPos.BASELINE);
			text.setWrappingWidth(200);
			text.setText("Sign in button pressed Sign in button pressed Sign in button pressed ");
		});

		return vbox;
	}

	private HBox hbox(Labeled label, TextField input) {
		label.setPrefWidth(120);
		label.setAlignment(Pos.CENTER_RIGHT);
		HBox hbox = new HBox(label, input);
		HBox.setHgrow(input, Priority.ALWAYS);
		hbox.setSpacing(10);
		return hbox;
	}

	private Pane gridForm() {
		GridPane gridPane = new GridPane();
		//         gridPane.setAlignment(Pos.BOTTOM_RIGHT);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(25, 25, 25, 25));

		//         gridPane.addr

		Text sceneTitle = new Text("Welcome");
		sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		gridPane.add(sceneTitle, 0, 0, 2, 1);
		Label userName = new Label("User Name:");
		userName.setAlignment(Pos.CENTER_RIGHT);
		userName.setPrefWidth(100);
		gridPane.add(userName, 0, 1);

		TextField userTextField = new TextField();
		gridPane.add(userTextField, 1, 1);

		Label pw = new Label("Password:");
		gridPane.add(pw, 0, 2);

		PasswordField pwBox = new PasswordField();
		gridPane.add(pwBox, 1, 2);

		Button btn = new Button("Sign in");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		gridPane.add(hbBtn, 1, 4);
		final Text text = new Text();
		gridPane.add(text, 1, 6);

		btn.setOnAction(event -> {
			text.setFill(Color.FIREBRICK);
			text.setText("Sign in button pressed");
		});

		return gridPane;
	}

	private Pane tioGridForm() {
		Button submitBtn = new Button("提交");
		submitBtn.setDefaultButton(true);
		
		double[] colWidthes = OutlinePage.showOutline ? new double[] { 100, 250, 100, 250 } : new double[] { 150, 300, 150, 300 };
				
		return FxForms.gridForm(//
				colWidthes, //
		        new Region[][] { //
		                { new Label("First name and second name"), new TextField("talent.tan"), new Label("Password"), new PasswordField() }, //
		                { new Label("Home"), new TextField("") }, //
		                { new Label("Phone"), new TextField("18699998888"), new Label("Address"), new TextField("深圳光明") },//
				}, //
		        new Button[] { submitBtn, new Button("取消") });
	}

}
