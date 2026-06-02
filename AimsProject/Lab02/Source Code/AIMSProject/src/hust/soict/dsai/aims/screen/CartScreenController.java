package hust.soict.dsai.aims.screen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.ListChangeListener;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javax.swing.SwingUtilities;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;

public class CartScreenController {
    private Store store;
    private Cart cart;
    private CartScreen stage;
    private FilteredList<Media> filteredList;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Label lblTotalCost;

    public CartScreenController(Store store, Cart cart, CartScreen stage) {
        super();
        this.store = store;
        this.cart = cart;
        this.stage = stage;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        
        // Wrap original list into a FilteredList
        filteredList = new FilteredList<>(this.cart.getItemsOrdered(), p -> true);
        tblMedia.setItems(filteredList);

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // Track selected item to update button state
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>() {
                @Override
                public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    }
                }
            }
        );

        // Add ChangeListener to tfFilter's text property
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });

        // Add ChangeListeners to radio buttons to update filter dynamically when toggled
        radioBtnFilterId.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    showFilteredMedia(tfFilter.getText());
                }
            }
        });

        radioBtnFilterTitle.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    showFilteredMedia(tfFilter.getText());
                }
            }
        });

        // Update total cost and listen for changes
        updateTotalCost();
        this.cart.getItemsOrdered().addListener((ListChangeListener<Media>) c -> {
            updateTotalCost();
        });
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Play Media");
            alert.setHeaderText("Playing: " + media.getTitle());
            
            StringBuilder sb = new StringBuilder();
            if (media instanceof DigitalVideoDisc) {
                DigitalVideoDisc dvd = (DigitalVideoDisc) media;
                sb.append("Category: ").append(dvd.getCategory()).append("\n");
                sb.append("Director: ").append(dvd.getDirector()).append("\n");
                sb.append("Length: ").append(dvd.getLength()).append(" minutes");
            } else if (media instanceof CompactDisc) {
                CompactDisc cd = (CompactDisc) media;
                sb.append("Artist: ").append(cd.getArtist()).append("\n");
                sb.append("Category: ").append(cd.getCategory()).append("\n");
                sb.append("Length: ").append(cd.getLength()).append(" seconds\n\n");
                sb.append("Tracks:\n");
                if (cd.getTracks().isEmpty()) {
                    sb.append(" - No tracks available");
                } else {
                    for (Track track : cd.getTracks()) {
                        sb.append(" - ").append(track.getTitle()).append(" (").append(track.getLength()).append("s)\n");
                    }
                }
            }
            alert.setContentText(sb.toString());
            alert.showAndWait();
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Empty Cart");
            alert.setHeaderText(null);
            alert.setContentText("Your cart is empty! Cannot place order.");
            alert.showAndWait();
            return;
        }

        cart.empty();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Order Success");
        alert.setHeaderText(null);
        alert.setContentText("Your order has been placed successfully!");
        alert.showAndWait();
    }

    @FXML
    void menuViewStorePressed(ActionEvent event) {
        SwingUtilities.invokeLater(() -> {
            new StoreScreen(store, cart);
            stage.dispose();
        });
    }

    @FXML
    void menuAddBookPressed(ActionEvent event) {
        SwingUtilities.invokeLater(() -> {
            new AddBookToStoreScreen(store, cart);
            stage.dispose();
        });
    }

    @FXML
    void menuAddCDPressed(ActionEvent event) {
        SwingUtilities.invokeLater(() -> {
            new AddCompactDiscToStoreScreen(store, cart);
            stage.dispose();
        });
    }

    @FXML
    void menuAddDVDPressed(ActionEvent event) {
        SwingUtilities.invokeLater(() -> {
            new AddDigitalVideoDiscToStoreScreen(store, cart);
            stage.dispose();
        });
    }

    void showFilteredMedia(String newValue) {
        if (newValue == null || newValue.trim().isEmpty()) {
            filteredList.setPredicate(media -> true);
            return;
        }
        String filterText = newValue.toLowerCase().trim();
        if (radioBtnFilterId.isSelected()) {
            filteredList.setPredicate(media -> String.valueOf(media.getId()).contains(filterText));
        } else if (radioBtnFilterTitle.isSelected()) {
            filteredList.setPredicate(media -> media.getTitle() != null && media.getTitle().toLowerCase().contains(filterText));
        }
    }

    void updateTotalCost() {
        lblTotalCost.setText(String.format("%.2f $", cart.totalCost()));
    }
}
