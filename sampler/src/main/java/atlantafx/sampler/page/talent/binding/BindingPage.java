/* SPDX-License-Identifier: MIT */

package atlantafx.sampler.page.talent.binding;

import atlantafx.sampler.page.OutlinePage;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public final class BindingPage extends OutlinePage {

	public static final String NAME = "Binding";

	@Override
	public String getName() {
		return NAME;
	}

	public BindingPage() {
		super();

		addPageHeader();
		addFormattedText("""
		        this page demonstrate how to use binding.
		                """);
		addSection("Usage", usageExample());
	}

	private Node usageExample() {
		javafx.scene.control.TextField input = new TextField("100");
		javafx.scene.control.Label label = new Label("hello");
		
		
		StringProperty inputStringProperty = input.textProperty();
		StringProperty labelStringProperty = label.textProperty();
		SimpleIntegerProperty simpleIntegerProperty = new SimpleIntegerProperty();
		labelStringProperty.bind(inputStringProperty.concat(" - 999"));

		HBox hbox = new HBox(input, label);

		return hbox;
	}

}
