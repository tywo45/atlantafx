/* SPDX-License-Identifier: MIT */

package atlantafx.sampler.page.talent.login;

import com.dlsc.formsfx.model.structure.Field;
import com.dlsc.formsfx.model.structure.Form;
import com.dlsc.formsfx.model.structure.Group;
import com.dlsc.formsfx.view.renderer.FormRenderer;

import atlantafx.sampler.page.OutlinePage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public final class FormPage extends OutlinePage {

	public static final String NAME = "Form";

	@Override
	public String getName() {
		return NAME;
	}

	public FormPage() {
		super();

		addPageHeader();
		addFormattedText("""
		        this page demonstrate how to use binding.
		                """);
		addSection("Simple Form", simpleForm());
		addSection("Formsfx Form", formsfxForm());
		addSection("listView", listView());
		

	}

	private Node simpleForm() {
		HBox root = new HBox();
		GridPane gridPane = new GridPane();
		//		gridPane.setAlignment(Pos.BOTTOM_RIGHT);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(25, 25, 25, 25));
		gridPane.setGridLinesVisible(true);
		HBox.setHgrow(gridPane, Priority.ALWAYS);
		

		//	        gridPane.addr

		Text sceneTitle = new Text("Welcome");
		sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		gridPane.add(sceneTitle, 0, 0, 2, 1);
		Label userName = new Label("User Name:");
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

		root.getChildren().add(gridPane);
		return root;
	}

	private Node formsfxForm() {
		Form loginForm = Form.of(Group.of(//
		        Field.ofStringType("tan")//
		                .label("Username"), //
		        Field.ofStringType("123456")//
		                .label("Password")//
		                .required("This field can’t be empty")//
		)).title("Login");

//		Pane root = new Pane();
		VBox root = new VBox();
		FormRenderer formRenderer = new FormRenderer(loginForm);
		root.getChildren().add(formRenderer);
		return root;
	}
	
	private Node listView() {
		// 创建 ListView
        ListView<String> listView = new ListView<>();
        listView.setMinHeight(200);//必须要有，否则界面上看不到listView

        // 创建项目列表
        ObservableList<String> items = FXCollections.observableArrayList(
            "Apple", "Banana", "Cherry", "Date", "Elderberry"
        );
        listView.setItems(items);

        // 设置为多选模式
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // 监听选中项变化
        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            System.out.println("Selected item: " + newSelection);
        });

        // 创建布局并添加 ListView
        VBox vbox = new VBox(10); // 间距为 10
        vbox.getChildren().add(listView);
        return vbox;
	}

}
