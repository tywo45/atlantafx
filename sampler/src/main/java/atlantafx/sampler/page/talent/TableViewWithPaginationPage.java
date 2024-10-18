package atlantafx.sampler.page.talent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import atlantafx.sampler.page.OutlinePage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TableViewWithPaginationPage extends OutlinePage {
	private static Logger log = LoggerFactory.getLogger(TableViewWithPaginationPage.class);

    public static final String NAME = "TableViewWithPaginateion";

	@Override
	public String getName() {
		return NAME;
	}
	
    public TableViewWithPaginationPage() {
        super();

        addPageHeader();
        addSection("Usage", usageExample());
    }

    private Node usageExample() {
    	 // 创建数据
        ObservableList<User> users = FXCollections.observableArrayList(
                new User("Alice", 24),
                new User("Bob", 30),
                new User("Charlie", 18),
                new User("David", 22),
                new User("Emily", 26),
                new User("Frank", 32),
                new User("Grace", 28),
                new User("Henry", 20),
                new User("Isabella", 25),
                new User("Jack", 29),
                
                new User("Tan", 18),
                new User("姚明", 22),
                new User("周红衣", 26),
                new User("柳军", 32),
                new User("裘伯君", 28),
                
                new User("Kevin", 21)
                // 添加更多用户...
        );

        // 创建分页控件
        Pagination pagination = new Pagination((int) Math.ceil((double) users.size() / 5), 0);
        pagination.setPageFactory((pageIndex) -> createPage(users, pageIndex));
        pagination.setStyle("-fx-page-information-alignment:left;");
        pagination.setMaxPageIndicatorCount(2);//显示几个可以直接点击的数字
        
        // 创建布局容器
        HBox vbox = new HBox(pagination);
        HBox.setHgrow(pagination, Priority.ALWAYS);
        return vbox; 
    }
    
    private Pane createPage(ObservableList<User> users, int pageIndex) {
        // 创建表格
        TableView<User> tableView = new TableView<>();
        TableColumn<User, String> nameCol = new TableColumn<>("Name");
        TableColumn<User, Integer> ageCol = new TableColumn<>("Age");

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));

        tableView.getColumns().addAll(nameCol, ageCol);

        // 计算当前页的数据
        int startItemIndex = pageIndex * 5; // 假设每页5项
        int endItemIndex = Math.min(startItemIndex + 5, users.size());

        // 显示当前页的数据
        tableView.setItems(FXCollections.observableArrayList(users.subList(startItemIndex, endItemIndex)));

        HBox box = new HBox(tableView);
        HBox.setHgrow(tableView, Priority.ALWAYS);

        return box;
    }
    
    public static class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
